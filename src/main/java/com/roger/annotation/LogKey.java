package com.roger.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
public @interface LogKey {

    String keyName() default "";
    boolean isUserId() default false;
    boolean isLog() default true; //是否加入到日志中去

}
