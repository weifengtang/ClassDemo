package com.twf.class_16.demo2;

public interface IEmail {

    public abstract void setHeader(String sender);
    public abstract void setReceiver(String receiver);
    public abstract void setContent(String content);

}
