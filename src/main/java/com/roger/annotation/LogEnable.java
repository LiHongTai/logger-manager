package com.roger.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)//类级别的注解
public @interface LogEnable {

    /**
     * 默认启动日志LogEvent事件 即true启动 false关闭
     * @return
     */
    boolean logEnable() default true;
}
