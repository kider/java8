package com.concurrent;

/**
 * @ClassName PrintXYZ
 * @Description 顺序打印XYZ
 * @Author kider
 * @Date 2022/9/24 23:19
 * @Version 1.0
 **/
public class PrintXYZ {


    public static void main(String[] args) {

        PrintThread printThreadX = new PrintThread("X", null);
        PrintThread printThreadY = new PrintThread("Y", printThreadX);
        PrintThread printThreadZ = new PrintThread("Z", printThreadY);

        printThreadZ.start();
        printThreadY.start();
        printThreadX.start();
    }


    static class PrintThread extends Thread {

        private String res;

        private Thread thread;


        PrintThread(String res, Thread thread) {
            this.res = res;
            this.thread = thread;
        }


        @Override
        public void run() {
            try {
                if (null != thread) {
                    thread.join();
                } else {
                    Thread.sleep(2000);
                }
                System.out.println("print" + this.res);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


}
