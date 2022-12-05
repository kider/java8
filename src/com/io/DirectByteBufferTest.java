package com.io;

import sun.misc.Unsafe;

/**
 * TODO
 *
 * @author chenh
 * @version 1.0
 * @date 2022/11/9 18:09
 **/
public class DirectByteBufferTest {

    public static void main(String[] args) {

        Unsafe.getUnsafe().allocateMemory(1024);
        
    }


}
