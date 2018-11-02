package com.roger.annotation;

import com.roger.enumeration.EventType;
import com.roger.enumeration.ModuleType;

import java.lang.annotation.*;

/**
 * 只有当方法上添加该注解时，才会执行日志处理逻辑
 * 在类上添加该注解，只是为了，添加一些默认值，
 * 即在这个类中所有需要日志处理逻辑的方法的公共日志部分
 * 比如这个类都是登陆模块，只是不同的事件类型
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface LogEvent {
    //日志所属模块
    ModuleType module() default ModuleType.DEFAULT;
    //日志事件类型
    EventType event() default EventType.DEFAULT;
    String desc() default "";//描述信息
}
