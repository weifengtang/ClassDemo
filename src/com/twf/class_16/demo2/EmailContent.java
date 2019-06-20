package com.twf.class_16.demo2;

/**
 * @ClassName:EmailContent 邮件内容
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/316:05
 * @Version:1.0
 **/
public class EmailContent {

    private String content;

    public String getContent() {
        return content;
    }

    //设置正文
    public void setContent(String content,String type) {
        if (type.equalsIgnoreCase("HTML")){
            this.content = setContentHtml(content);
        }else if (type.equalsIgnoreCase("PlainText")){
            this.content = setContentPlainText(content);
        }else {
            this.content = content;
        }

    }
    public String  setContentHtml(String content) {
        //html包装
       return  "html包装后-"+content;
    }
    public String  setContentPlainText(String content) {
        //PlainText包装
       return  "PlainText包装后-"+content;
    }
}
