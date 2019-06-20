package com.twf.class_28_jdbc_02.homeWork;

import com.twf.class_28_jdbc_02.jdbcUtils.JDBCUtils_02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName:MyHandler
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/2010:58
 * @Version:1.0
 * 代理
 **/
public class MyHandler implements InvocationHandler {
    private Object object;

    //  object:需要代理的类
    public Object newProxyInstance(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(this.object.getClass().getClassLoader(),
                this.object.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object object = null;
        try {
//            开启事务
            JDBCUtils_02.beginTranscation();

            object = method.invoke(this.object, args);

//         提交事务
            JDBCUtils_02.commitTransaction();
        } catch (Exception e) {
//       回滚事务
            JDBCUtils_02.rollbackTransaction();
        }

        return object;
    }
}
