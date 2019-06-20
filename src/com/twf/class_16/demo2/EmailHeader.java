package com.twf.class_16.demo2;

import java.io.UnsupportedEncodingException;

/**
 * @ClassName:EmailHeader 邮件头
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/316:02
 * @Version:1.0
 **/
public class EmailHeader {

    private  String head ; //邮件头

    public  String getHead() {

        return head;
    }

    public  void setHead(String encoding,String[] head) {
        StringBuilder sb = new StringBuilder();
        try {
            System.out.println("对邮件头编码 encoding");
            for (int i = 0;i<head.length;i++){
               sb.append( new String(head[i].getBytes("utf-8"),encoding));
            }
            this.head =sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
