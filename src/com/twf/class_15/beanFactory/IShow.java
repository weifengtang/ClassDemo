package com.twf.class_15.beanFactory;

public interface IShow {
    //使用的内存
    public Long showSize();
    //空闲内存
    public Long getFreeMemory();
    //总内存
    public Long getTotalMemory();

}
