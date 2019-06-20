package com.twf.class_16.demo2;

/**
 * @ClassName:Email
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/316:09
 * @Version:1.0
 **/
public class Email implements IEmail {

    private  String header;
    private String  receiver;
    private String content;

    public Email() {
    }


    @Override
    public void setHeader(String header) {
        this.header = header;
    }
    @Override
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    public void sendEmail() {
        System.out.println("header:  "+header+"\nreceiver:  "
                +receiver+"\n content:  "+content);
    }


}
