package com.twf.class_23;

import java.lang.annotation.*;

/**
 * @ClassName:NotNull
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1319:24
 * @Version:1.0
 **/
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyNotNull {
    public String name()default "默认名称：唐伟锋";
    public int age()default 23;
}
