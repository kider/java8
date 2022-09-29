package com.test;

/**
 * 位移操作
 *
 * @author chenh
 * @version 1.0
 * @date 2022/9/28 14:14
 **/
public class BitRemoveTest {

    public static void main(String[] args) {

        //leftRemove(-1, 3);
        //leftRemove(2, 3);

        rightRemove();

        rightRemove2();

    }

    /**
     * 左移操作符 <<
     * 左移操作符 << 是将数据转换成二进制数后，向左移若干位，高位丢弃，低位补零
     */
    public static void leftRemove(int i, int j) {
        System.out.println("Before << , i's value is " + i);
        System.out.println("i's binary string is " + Integer.toBinaryString(i));
        i <<= j;
        System.out.println("After << , i's value is " + i);
        System.out.println("i's binary string is " + Integer.toBinaryString(i));
    }

    /**
     * 带符号右移操作符 >>
     * 众所周知，Java中整型表示负数时，最高位为符号位，正数为0，负数为1。
     * >> 是带符号的右移操作符，将数据转换成二进制数后，向右移若干位，高位补符号位，低位丢弃
     */
    public static void rightRemove() {
        // 对正数进行右移操作
        int i1 = 4992;
        System.out.println("Before >> , i1's value is " + i1);
        System.out.println("i1's binary string is " + Integer.toBinaryString(i1));
        i1 >>= 10;
        System.out.println("After >> , i1's value is " + i1);
        System.out.println("i1's binary string is " + Integer.toBinaryString(i1));
        // 对负数进行右移操作
        int i2 = -4992;
        System.out.println("Before >> , i2's value is " + i2);
        System.out.println("i2's binary string is " + Integer.toBinaryString(i2));
        i2 >>= 10;
        System.out.println("After >> , i2's value is " + i2);
        System.out.println("i2's binary string is " + Integer.toBinaryString(i2));
    }


    /**
     * 无符号右移操作符 >>>
     * 无符号右移操作符 >>>与>>类似，都是将数据转换为二进制数后右移若干位，
     * 不同之处在于，不论负数与否，结果都是高位补零，低位丢弃。
     */
    public static void rightRemove2() {
        int i3 = -4992;
        System.out.println("Before >>> , i3's value is " + i3);
        System.out.println("i3's binary string is " + Integer.toBinaryString(i3));
        i3 >>>= 10;
        System.out.println("After >>> , i3's value is " + i3);
        System.out.println("i3's binary string is " + Integer.toBinaryString(i3));

    }

}
