package com.twf.class_15.beanFactory;

/**
 * @ClassName:ShowMemoey
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/110:38
 * @Version:1.0
 **/
public class ShowMemoey implements IShow {
    @Override
    public Long showSize() {
        return (getTotalMemory()-getFreeMemory())>>10;
    }

    @Override
    public Long getFreeMemory() {
        return  Runtime.getRuntime().freeMemory();//Java 虚拟机中的空闲内存量。
    }

    @Override
    public Long getTotalMemory() {
        return Runtime.getRuntime().totalMemory();//Java 虚拟机中的内存总量
    }
}
