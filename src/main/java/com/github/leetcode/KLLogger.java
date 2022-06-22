package com.github.leetcode;

import lombok.AllArgsConstructor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author xinguai.liu
 */
public abstract class KLLogger {

    private Appender appender;

    private KLLogger root;
    private DebugLevel level;

    private boolean active;

    public void main(String[] args) {
        final KLLogger logger = KLLogger.getLogger(KLLogger.class);
        // TODO
        logger.setAppender(new PrintlnAppender());
        logger.setLogLevel(DebugLevel.DEBUG);
        logger.debug("debug 1...");
        logger.info("info 1...");
        logger.warn("warn 1...");
        logger.error("error 1...");

        // TODO
        logger.setAppender(new FileAppender("~/document/test.log"));
        logger.setLogLevel(DebugLevel.ERROR);
        logger.debug("debug 2...");
        logger.info("info 2...");
        logger.warn("warn 2...");
        logger.error("error 2...");

    }

    protected void setAppender(Appender appender) {
        this.appender = appender;
    }

    public void error(String s) {
        doAppend(new LogEventImpl(name(),DebugLevel.ERROR,s));
    }

    public void warn(String s) {
        doAppend(new LogEventImpl(name(),DebugLevel.WARN,s));
    }

    public void info(String s) {
        doAppend(new LogEventImpl(name(),DebugLevel.INFO,s));
    }

    public void debug(String s) {
        doAppend(new LogEventImpl(name(),DebugLevel.DEBUG,s));
    }

    public void setRoot(KLLogger logger) {
        this.root = logger;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    protected abstract String name();

    protected void doAppend(LogEvent logEvent) {
        for (KLLogger logger = this; logger != null; logger = logger.root) {
            if (level.accept(logEvent.level().level_in)) {
                this.appender.append(logEvent);
            }
            if (!active) {
                break;
            }
        }
    }

    private void setLogLevel(DebugLevel debug) {
        this.level = debug;
    }

    private static KLLogger parent = new KLLogger() {
        @Override
        protected String name() {
            return "root";
        }
    };


    private static <T> KLLogger getLogger(Class<T> clazz) {
        String name = clazz.getName();
        if (name.equals("root")) {
            if (parent.appender == null) {
                parent.appender = new PrintlnAppender();
            }
            return parent;
        }
        //TODO 此处可以设置缓存
        KLLogger logger = new KLLogger() {
            @Override
            protected String name() {
                return clazz.getCanonicalName();
            }
        };
        logger.setRoot(parent);
        return logger;
    }


    enum DebugLevel {
        DEBUG(5), INFO(4), WARN(3), ERROR(2);

        private final int level_in;

        DebugLevel(int level_in) {
            this.level_in = level_in;
        }

        public boolean accept(int level_in) {
            return this.level_in >= level_in;
        }
    }

    @AllArgsConstructor
    class LogEventImpl implements LogEvent {

        private String name;

        private DebugLevel level;

        private String message;

        @Override
        public String name() {
            return name;
        }

        @Override
        public DebugLevel level() {
            return level;
        }

        @Override
        public String message() {
            return message;
        }
    }

    interface LogEvent {

        String name();

        DebugLevel level();

        String message();
    }

    interface Appender {

        void append(LogEvent logEvent);

    }

    static class PrintlnAppender implements Appender {


        @Override
        public void append(LogEvent logEvent) {
            System.out.printf("%s-%s:%s\n",logEvent.name(),logEvent.level().name(),logEvent.message());
        }
    }


    static class FileAppender implements Appender {

        final File file;

        public FileAppender(String filePath) {
            this.file = new File(filePath);
        }

        @Override
        public void append(LogEvent logEvent) {
            write(String.format("%s-%s:%s\n",logEvent.name(),logEvent.level().name(),logEvent.message()));
        }

        public void write(String message) {
            try {
                FileWriter writer = new FileWriter(file, true);
                writer.write(message);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
