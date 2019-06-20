package com.twf.class_16.demo1;

/**
 * @ClassName:ComputerBook
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/315:31
 * @Version:1.0
 **/
public class ComputerBook extends IBookAdapt{

    public ComputerBook(String name, double price, String author,String scope) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.scope = scope;
    }

    @Override
    public String getScope() {
        return this.scope;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getAuthor() {
        return super.getAuthor();
    }
}
