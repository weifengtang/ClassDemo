package com.twf.class_16.demo1;

/**
 * @ClassName:IBook
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/315:30
 * @Version:1.0
 **/
public interface IBook {

    //书名
    abstract String getName();
    //价格
    abstract double getPrice();
    //作者
    abstract String getAuthor();

    //范围
    public String getScope() ;
}
