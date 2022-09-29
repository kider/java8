package com.test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Deque 测试
 *
 * @author chenh
 * @version 1.0
 * @date 2022/9/29 16:31
 **/
public class DequeTest {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque();

        //添加元素
        System.out.println("添加元素");

        //add 尾部添加
        deque.add(1);
        deque.add(2);
        System.out.println("add:" + deque.toString());
        //addLast 尾部添加
        deque.addLast(3);
        deque.addLast(4);
        System.out.println("addLast:" + deque.toString());
        //addFirst 头部添加
        deque.addFirst(5);
        deque.addFirst(6);
        System.out.println("addFirst:" + deque.toString());
        //offer 尾部添加
        deque.offer(7);
        deque.offer(8);
        System.out.println("offer:" + deque.toString());
        //offerFirst 头部添加
        deque.offerFirst(9);
        deque.offerFirst(10);
        System.out.println("offerFirst:" + deque.toString());
        //offer 尾部添加
        deque.offerLast(11);
        deque.offerLast(12);
        System.out.println("offerLast:" + deque.toString());

        System.out.println("查看元素");

        //查看Deque中的元素
        Integer r1 = deque.peek();
        System.out.println("peek :" + r1);
        System.out.println("after peek:" + deque.toString());

        Integer r2 = deque.peekFirst();
        System.out.println("peekFirst:" + r2);
        System.out.println("after peekFirst:" + deque.toString());

        Integer r3 = deque.peekLast();
        System.out.println("peekLast:" + r3);
        System.out.println("after peekLast:" + deque.toString());

        Integer r4 = deque.getFirst();
        System.out.println("getFirst:" + r4);
        System.out.println("after getFirst:" + deque.toString());

        Integer r5 = deque.getLast();
        System.out.println("getLast:" + r5);
        System.out.println("after getLast:" + deque.toString());

        System.out.println("移除Deque中的元素");

        Integer r6 = deque.remove();
        System.out.println("remove :" + r6);
        System.out.println("after remove:" + deque.toString());

        Integer r7 = deque.removeFirst();
        System.out.println("removeFirst:" + r7);
        System.out.println("after removeFirst:" + deque.toString());

        Integer r8 = deque.removeLast();
        System.out.println("removeLast:" + r8);
        System.out.println("after removeLast:" + deque.toString());

        Integer r9 = deque.poll();
        System.out.println("poll:" + r9);
        System.out.println("after poll:" + deque.toString());

        Integer r10 = deque.pollFirst();
        System.out.println("pollFirst:" + r10);
        System.out.println("after pollFirst:" + deque.toString());

        Integer r11 = deque.pollLast();
        System.out.println("pollLast:" + r11);
        System.out.println("after pollLast:" + deque.toString());

    }


}
