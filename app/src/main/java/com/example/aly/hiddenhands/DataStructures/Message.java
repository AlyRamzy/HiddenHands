package com.example.aly.hiddenhands.DataStructures;

/**
 * Created by Nour Ahmed on 7/25/2019.
 */

public class Message {
    private String content;
    private String senderId;

    public Message(String content, String senderId) {
        this.content = content;
        this.senderId = senderId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }


    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderId() {
        return senderId;
    }
}
