package com.roger.aspect;

import com.roger.annotation.LogEnable;
import com.roger.annotation.LogEvent;
import com.roger.entity.LogAdmDTO;
import com.roger.enumeration.EventType;
import com.roger.enumeration.ModuleType;
import com.roger.logger.ILogManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Aspect
public class LogAspect {

    @Resource(name = "dbLogManager")
    ILogManager iLogManager;

    @Pointcut("execution(* com.roger.service..*.*(..))")
    public void mangerLogPoint() {

    }

    @Around("mangerLogPoint()")
    public Object aroundMangerLogPoint(ProceedingJoinPoint pJoinPoint) throws Throwable {

        Class targetCls = pJoinPoint.getTarget().getClass();
        //如果目标类,被注解LogEnnable注解,并且值为true
        //则走日志逻辑
        LogEnable logEnable = (LogEnable) targetCls.getAnnotation(LogEnable.class);
        if (logEnable == null || !logEnable.logEnable()) {
            return pJoinPoint.proceed();
        }
        //获取类上LogEvent注解作为默认值
        LogEvent logEventClass = (LogEvent) targetCls.getAnnotation(LogEvent.class);
        //因为使用java反射,所以在定义方法的时候，注意基本类型的参数类型，必须时封装类型
        Method method = getInvokedMethod(targetCls, pJoinPoint);
        if(method == null){
            return pJoinPoint.proceed();
        }
        //获取方法上的LogEvent注解
        LogEvent logEventMethod = (LogEvent) method.getAnnotation(LogEvent.class);
        if(logEventMethod == null){
            return pJoinPoint.proceed();
        }
        String optEvent = logEventMethod.event().getEvent();
        String optModule = logEventMethod.module().getModule();
        String optDesc = logEventMethod.desc();

        if(logEventClass != null){
            //如果方法上使用的时默认值，则使用全局变量替换
            optEvent = optEvent.equals(EventType.DEFAULT.getEvent()) ? logEventClass.event().getEvent() : optEvent;
            optModule = optModule.equals(ModuleType.DEFAULT.getModule()) ? logEventClass.module().getModule() : optModule;
        }
        LogAdmDTO logAdmDTO = new LogAdmDTO();
        logAdmDTO.setAdmEvent(optEvent);
        logAdmDTO.setAdmMode(optModule);
        logAdmDTO.setDateCreated(LocalDateTime.now());
        logAdmDTO.setDesc(optDesc);

        iLogManager.dealLog(logAdmDTO);

        return pJoinPoint.proceed();
    }

    private Method getInvokedMethod(Class targetCls, ProceedingJoinPoint pJoinPoint) {
        List<Class<? extends Object>> clazzList = new ArrayList<>();
        Object[] args = pJoinPoint.getArgs();
        for (Object arg : args) {
            clazzList.add(arg.getClass());
        }

        Class[] argsCls = (Class[]) clazzList.toArray(new Class[0]);

        String methodName = pJoinPoint.getSignature().getName();
        Method method = null;
        try {
            method = targetCls.getMethod(methodName,argsCls);
        }catch (NoSuchMethodException e){
            //不做任何处理,这个切面只处理日志相关逻辑
            //其他任何异常不在这个切面的考虑范围
        }
        return method;
    }
}
