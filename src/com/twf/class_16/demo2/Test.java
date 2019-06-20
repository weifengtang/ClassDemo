package com.twf.class_16.demo2;

/**
 * @ClassName:Test
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/316:25
 * @Version:1.0
 **/
public class Test {
    public static void main(String[] args) {

        EmailHeader emailHeader = new EmailHeader();
        String heads[] = {"邮件头","邮件头二"};
        emailHeader.setHead("utf-8",heads);

        EmailContent emailContent = new EmailContent();
        emailContent.setContent("邮件内容","html");

        Email email = new Email();

        email.setHeader(emailHeader.getHead());
        email.setContent(emailContent.getContent());
        email.setReceiver("收件人");
        email.sendEmail();


    }
}
