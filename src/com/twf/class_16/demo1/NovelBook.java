package com.twf.class_16.demo1;

/**
 * @ClassName:NovelBook 小说类书籍
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/315:31
 * @Version:1.0
 **/
public class NovelBook  extends  IBookAdapt{

    public NovelBook() {
    }

    public NovelBook(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    //书名
    @Override
    public String getName() {
        return this.name;
    }


    //价格
    @Override
    public double getPrice() {
        return this.price;
    }

    //作者
    @Override
    public String getAuthor() {
        return this.author;
    }
}
