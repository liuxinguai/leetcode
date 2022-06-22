package com.github.leetcode;

import java.util.*;

public class Demo1 {

    private static boolean start = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String,Item> urlMap = new HashMap<>();

        while (in.hasNext()) {
            if (in.hasNextInt()) {
                int sum = in.nextInt();
                List<Item> list = new ArrayList<>(urlMap.values());
                System.out.println(urlMap.values());
                Collections.sort(list, new Comparator<Item>() {
                    @Override
                    public int compare(Item o1, Item o2) {
                        if (o2.index == o1.index) {
                            return o2.key.compareTo(o1.key);
                        }
                        return o2.index - o1.index;
                    }
                });
                System.out.println(list);
            } else if (in.hasNextLine()) {
                String line = in.nextLine();
                if (!urlMap.containsKey(line)) {
                    urlMap.put(line,new Item(line,1));
                } else {
                    urlMap.get(line).index += 1;
                }
            }
        }
    }

    public void printf(List<Item> list, int sum) {
        for (int i = 0; i < list.size(); i++) {
            if (start) {
                start = false;
                System.out.printf("%s",list.get(i).key);
            } else {
                System.out.printf(",%s",list.get(i).key);
            }
        }
    }

    static class Item {
        public String key;

        public Integer index;

        public Item(String key, Integer index) {
            this.key = key;
            this.index = index;
        }

        @Override
        public String toString() {
            return key +":"+index;
        }
    }







}
