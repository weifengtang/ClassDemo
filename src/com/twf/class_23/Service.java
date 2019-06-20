package com.twf.class_23;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName:Service
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/139:42
 * @Version:1.0
 *
 * 业务层组件
 **/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    public String value();
}
