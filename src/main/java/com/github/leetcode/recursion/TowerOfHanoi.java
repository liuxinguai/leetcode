package com.github.leetcode.recursion;

/**
 * 含诺塔
 * @author liuxg
 */
public class TowerOfHanoi {


    /**
     * 将1~n个盘从from位置挪到to的位置上，且顺序不变，要求盘子的顺序还是不变
     *  划分成挪干个小任务：将1~n-1个盘子从from中移动到other中，再将n盘子从from中移动到to中
     * @param from 汉诺塔起始位置
     * @param to 汉诺塔终止位置
     * @param other 汉诺塔最后一个位置
     * @param n 最大的一个节点
     */
    protected void move(String from, String to, String other, int n) {
        //将最后一个盘子从from中移动到to中
        if (n == 1) {
            System.out.println("Move 1 from " + from + " to "+ to);
        } else {
            move(from, other, to,n-1);
            System.out.println("Move " + n + " from " + from + " to "+ to);
            move(other, to, from,n-1);
        }
    }

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.move("左","右","中",4);
    }

}
