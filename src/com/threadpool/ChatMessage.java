package com.threadpool;

import java.io.Serializable;

/**
 * chat_message
 */
public class ChatMessage implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息id
     */
    private Long id;

    /**
     * 消息载体
     */
    private String content;

    /**
     * 状态
     */
    private String state;


    public ChatMessage() {


    }

    public ChatMessage(Long id, String content, String state) {
        this.id = id;
        this.content = content;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
