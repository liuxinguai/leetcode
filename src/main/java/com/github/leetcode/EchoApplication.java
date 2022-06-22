package com.github.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xinguai.liu
 */
public class EchoApplication {

    public static volatile boolean echoStarted = true;


    public static void main(String[] args) throws IOException, InterruptedException {

        final int listenPort = 12345;

        // 启动服务端
        EchoServer server = new EchoServer(listenPort);
        server.startService();
        Scanner scanner = new Scanner(System.in);
        CommandLineParse parse = new SimpleCommandLineParse();
        while(echoStarted && scanner.hasNext()) {
            String line = scanner.nextLine();
            parse.parse(line).handleCommand(line);
        }
        server.stopService();
        System.exit(-1);

        // 服务端启动后，运行结果示例：
        /**
         java -cp ./classes EchoApplication

         2020-03-31 16:58:44.049 - Welcome to My Echo Server.(from SERVER)
         The current connections:
         Id.			Client				LogonTime
         -----------------------------------------------------
         1			127.0.0.1:32328		2020-03-31 16:59:13
         2			127.0.0.1:43434		2020-03-31 17:03:02
         3			127.0.0.1:39823		2020-03-31 07:03:48

         Enter(h for help): h
         The commands:
         ----------------------------------------------------
         q		query current connections
         d id		disconnect client
         x		quit server
         h		help

         Enter(h for help): d 1
         2020-03-31 16:58:44.049 - The connection '127.0.0.1:32328' has been disconnected.
         The current connections:
         Id.			Client				LogonTime
         -----------------------------------------------------
         1			127.0.0.1:43434		2020-03-31 17:03:02
         2			127.0.0.1:39823		2020-03-31 07:03:48

         Enter(h for help): x
         2020-03-31 16:58:44.049 - The server has exited. Bye!
         */

        // 在telnet控制台输入，服务端直接原文返回输入信息
        // 客户端结果示例：
        /**
         2020-03-31 16:58:44.049 - Welcome to My Echo Server.(from SERVER)

         Enter: hello!
         2020-03-31 16:58:55.452 - hello!(from SERVER)

         Enter: This is KOAL.
         2020-03-31 16:59:06.565 - This is KOAL.(from SERVER)

         Enter: What can i do for you?
         2020-03-31 16:59:12.828 - What can i do for you?(from SERVER)

         Enter: bye!
         2020-03-31 16:59:16.502 - Bye bye!(from SERVER)
         */
    }

    /**
     * 命令行处理器
     */
    interface CommandLineHandle {
        public void handleCommand(String line);
    }

    /**
     * 命令行解析器
     */
    interface CommandLineParse {
        CommandLineHandle parse(String line);
    }

    static class SimpleCommandLineParse implements CommandLineParse {

        @Override
        public CommandLineHandle parse(String line) {
            if (line.equals("h")) {
                return new HelpCommandLineHandle();
            } else if (line.equals("q")) {
                return new QueryCommandLineHandle();
            } else if(line.equals("x")) {
                return line1 -> echoStarted = false;
            } else {
                return new CloseCommandLineHandle();
            }
        }
    }

    static class CloseCommandLineHandle implements CommandLineHandle {

        @Override
        public void handleCommand(String line) {
            String[] split = line.split(" ");
            if (split.length == 2) {
                Pools.remove(Integer.parseInt(split[1]));
            }
        }
    }

    static class QueryCommandLineHandle implements CommandLineHandle {

        @Override
        public void handleCommand(String line) {
            List<String> items = Pools.getList();
            for (int i = 0; i < items.size(); i++) {
                System.out.println(items.get(i));
            }
        }
    }

    static class HelpCommandLineHandle implements CommandLineHandle {

        @Override
        public void handleCommand(String line) {
            System.out.println("q\t\tquery current connections");
            System.out.println("d id\t\tdisconnect client");
            System.out.println("x\t\tquit server");
            System.out.println("h\t\thelp");
        }
    }

    static class Pools {

        private static List<PoolItem> list = new ArrayList<>();


        public static void put(SocketChannel channel) {
            synchronized (Pools.class) {
                list.add(new PoolItem(channel,LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.sss"))));
            }
        }

        public static void remove(SocketChannel channel) {
            synchronized (Pools.class) {
                Iterator<PoolItem> iterator = list.iterator();
                while (iterator.hasNext()) {
                    PoolItem item = iterator.next();
                    if (item.channel == channel) {
                        iterator.remove();
                    }
                }
            }
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void remove(int i) {
            synchronized (Pools.class) {
                PoolItem item = list.remove(i);
                try {
                    item.channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public static List<String> getList() {
            List<String> result = new ArrayList<>(list.size());
            synchronized (Pools.class) {
                int i = 0;
                Iterator<PoolItem> iterator = list.iterator();
                while (iterator.hasNext()) {
                    PoolItem item = iterator.next();
                    try {
                        result.add(String.format("%d\t%s\t%s",i++,item.getChannel().getRemoteAddress().toString(),item.socketTime));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return result;
        }

        @AllArgsConstructor
        @Data
        static class PoolItem {
            private SocketChannel channel;
            private String socketTime;
        }
    }

    interface EchoWorkerSelector {
        EchoWorker select();
    }

    static class SimpleEchoWorkerSelector implements EchoWorkerSelector {

        private AtomicInteger count = new AtomicInteger();
        private EchoWorker[] echoWorkers;

        public SimpleEchoWorkerSelector(EchoWorker[] echoWorkers) {
            this.echoWorkers = echoWorkers;
        }

        @Override
        public EchoWorker select() {
            return echoWorkers[Math.abs(count.getAndIncrement() % echoWorkers.length)];
        }
    }

    @Data
    static class EchoServer extends Thread {

        int listenPort;

        Selector selector;

        private volatile boolean closed;

        private volatile boolean started = false;

        private volatile ServerSocketChannel socketChannel;

        private EchoWorker[] workers = null;

        private EchoWorkerSelector workerSelector;

        public EchoServer(int listenPort) throws IOException {
            this.listenPort = listenPort;
            selector = Selector.open();
            workers = new EchoWorker[Runtime.getRuntime().availableProcessors() * 2];
            for (int i = 0; i < workers.length; i++) {
                workers[i] = new EchoWorker();
            }
            this.workerSelector = new SimpleEchoWorkerSelector(workers);
        }

        @Override
        public void run() {
            try {
                socketChannel = ServerSocketChannel.open();
                socketChannel.bind(new InetSocketAddress(listenPort));
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_ACCEPT);
                while (!closed) {
                    try {
                        int select = selector.select(200);
                        if (select > 0) {
                            Set<SelectionKey> keys = selector.selectedKeys();
                            Iterator<SelectionKey> iterator = keys.iterator();
                            while (iterator.hasNext()) {
                                SelectionKey key = iterator.next();
                                if (key.isAcceptable()) {
                                    handleAcceptHandle((SocketChannel) key.channel());
                                }
                                iterator.remove();
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    selector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        protected void handleAcceptHandle(SocketChannel channel) {
            Pools.put(channel);
            EchoWorker worker = workerSelector.select();
            worker.registerTask(() -> {
                worker.selector.notify();
                try {
                    channel.configureBlocking(false);
                    channel.register(worker.selector, SelectionKey.OP_READ);
                    worker.doWrite(channel,"hello!".getBytes(StandardCharsets.UTF_8));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        public void startService() {
            if (started) {
                System.out.println("Echo server 已启动");
                return;
            }
            synchronized (this) {
                if (!started) {
                    started = true;
                    this.start();
                }
            }
        }

        public void stopService() {
            this.closed = true;
            this.started = false;
            for (int i = 0; i < workers.length; i++) {
                try {
                    workers[i].close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class EchoWorker implements Runnable, Closeable {

        private volatile boolean closed;

        private Selector selector;

        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(1024);

        public EchoWorker() throws IOException {
            selector = Selector.open();
        }

        @Override
        public void run() {
            while (!closed) {
                int select = 0;
                try {
                    select = selector.select(200);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (select > 0) {
                    handleSelectorKey(selector.selectedKeys());
                }
                try {
                    Runnable poll = queue.poll(100, TimeUnit.MILLISECONDS);
                    safeExcute(poll);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        protected void registerTask(Runnable runnable) {
            selector.notify();
            queue.add(runnable);
        }

        private void safeExcute(Runnable runnbale) {
            if (runnbale != null) {
                runnbale.run();
            }
        }

        protected void handleSelectorKey(Set<SelectionKey> selectorKeys) {
            Iterator<SelectionKey> iterator = selectorKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isReadable()) {
                    doRead((SocketChannel) key.channel());
                }
                iterator.remove();
            }
        }

        protected void doRead(SocketChannel socketChannel) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            try {
                int write = socketChannel.write(buffer);
                if (write > 0) {
                    buffer.flip();
                    byte[] array = new byte[buffer.remaining()];
                    buffer.get(array,0,array.length);
                    String response = new String(array, StandardCharsets.UTF_8);
                    System.out.println("Server receive msg : "+response);
                    doWrite(socketChannel,array);
                    if (response.equals("bye")) {
                        Pools.remove(socketChannel);
                        buffer.clear();
                    }
                } else {
                    Pools.remove(socketChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        protected void doWrite(SocketChannel socketChannel, byte[] request) {
            try {
                socketChannel.write((ByteBuffer) ByteBuffer.wrap(request).flip());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @Override
        public void close() throws IOException {
            closed = true;
            selector.notify();
        }
    }


}
