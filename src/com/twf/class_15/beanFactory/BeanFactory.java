package com.twf.class_15.beanFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName:BeanFactory
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/110:31
 * @Version:1.0
 **/
public class BeanFactory {

    //获取增强后对象
    public static IShow getBean(IShow object){
        IShow object_2 =(IShow) Proxy.newProxyInstance(object.getClass().getClassLoader()
                , object.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("增强---");
                        Object objValue =method.invoke(object,args);

                        return objValue;
                    }
                });

            return object_2;
    }

}
