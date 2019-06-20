package com.twf.class_16.demo1;

/**
 * @ClassName:IBookAdapt
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/315:46
 * @Version:1.0
 **/
public class IBookAdapt implements IBook {

    protected String name;
    protected double  price;
    protected String author;
    protected String scope;

    //书所属领域
    @Override
    public String getScope() {
        return scope;
    }

    //书名
    @Override
    public String getName() {
        return name;
    }

    //价格
    @Override
    public double getPrice() {
        return price;
    }

    //作者
    @Override
    public String getAuthor() {
        return author;
    }
}
