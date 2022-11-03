package com.threadpool;

public abstract class ChatMessageRunnable implements HashRunnable {

    private final ChatMessage message;

    public ChatMessageRunnable(ChatMessage message) {
        this.message = message;
    }

    public ChatMessage getMessage() {
        return message;
    }

    @Override
    public int hash() {
        return getMessage().getId().hashCode();
    }
}
