package com.threadpool;

import com.threadlocal.ThreadLocalUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试
 *
 * @author chenh
 * @version 1.0
 * @date 2022/11/3 10:38
 **/
public class TestThreadPool {

    public static void main(String[] args) throws InterruptedException {

        ChatMessage chatMessage10 = new ChatMessage(10001L, "i am 100010", "0");
        ChatMessage chatMessage11 = new ChatMessage(10001L, "i am 100011", "1");
        ChatMessage chatMessage12 = new ChatMessage(10001L, "i am 100012", "2");

        ChatMessage chatMessage20 = new ChatMessage(10002L, "i am 100020", "0");
        ChatMessage chatMessage21 = new ChatMessage(10002L, "i am 100021", "1");
        ChatMessage chatMessage22 = new ChatMessage(10002L, "i am 100022", "2");

        ChatMessage chatMessage30 = new ChatMessage(10003L, "i am 100030", "0");
        ChatMessage chatMessage31 = new ChatMessage(10003L, "i am 100031", "1");
        ChatMessage chatMessage32 = new ChatMessage(10003L, "i am 100032", "2");

        TestChatMessageRunnable ms10 = new TestChatMessageRunnable(chatMessage10);
        TestChatMessageRunnable ms11 = new TestChatMessageRunnable(chatMessage11);
        TestChatMessageRunnable ms12 = new TestChatMessageRunnable(chatMessage12);

        TestChatMessageRunnable ms20 = new TestChatMessageRunnable(chatMessage20);
        TestChatMessageRunnable ms21 = new TestChatMessageRunnable(chatMessage21);
        TestChatMessageRunnable ms22 = new TestChatMessageRunnable(chatMessage22);

        TestChatMessageRunnable ms30 = new TestChatMessageRunnable(chatMessage30);
        TestChatMessageRunnable ms31 = new TestChatMessageRunnable(chatMessage31);
        TestChatMessageRunnable ms32 = new TestChatMessageRunnable(chatMessage32);

        HashTreadGroup hashTreadGroup = new HashTreadGroup(5);
        hashTreadGroup.execute(ms10);
        hashTreadGroup.execute(ms11);
        hashTreadGroup.execute(ms12);
        hashTreadGroup.execute(ms20);
        hashTreadGroup.execute(ms21);
        hashTreadGroup.execute(ms22);
        hashTreadGroup.execute(ms30);
        hashTreadGroup.execute(ms31);
        hashTreadGroup.execute(ms32);

        hashTreadGroup.shutdown();


    }


    static class TestChatMessageRunnable extends ChatMessageRunnable {

        public TestChatMessageRunnable(ChatMessage message) {
            super(message);
        }

        @Override
        public void run() {
            ChatMessage ms = this.getMessage();
            List<String> params = ThreadLocalUtil.getThreadLocal();
            if (null == params) {
                params = new ArrayList<>();
            }
            params.add(ms.getState());
            ThreadLocalUtil.setThreadLocal(params);
            System.out.println("threadId:" + Thread.currentThread().getId() + ",threadLocal:" + Arrays.toString(params.toArray()) + ",messageId:" + ms.getId() + ",state:" + ms.getState() + ",content:" + ms.getContent());
        }
    }


}
