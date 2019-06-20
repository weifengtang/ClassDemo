package com.twf.class_25_jdk8;

import java.lang.annotation.*;

/**
 * @ClassName:Demo_06
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1719:36
 * @Version:1.0 •在Java 8中使用@Repeatable注解定义重复注解。
 * •Java 8拓宽了注解的应用场景。
 * 现在，注解几乎可 以使用在任何元素上：
 * 局部变量、接口类型、超类 和接口实现类，甚至可以用在函数的异常定义上。
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Filters {//@interface 声明一个注解

    Filter[] value();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Filters.class)
        //该注解可重复使用
@interface Filter {
    String value();
};

public class Demo_06 {
    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable {
    }

    public static void main(String[] args) {
        for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
            System.out.println(filter.value());
        }
    }
}
