package com.ibm.moses.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Moses
 */
@Aspect
@Component
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Around("execution(public * com.ibm.moses.*.repository..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method targetMethod = methodSignature.getMethod();
        if (targetMethod.isAnnotationPresent(TargetDateSource.class)) {
            String targetDataSource = targetMethod.getAnnotation(TargetDateSource.class).dataSource();
            logger.info("operation from database: " + targetDataSource);
            DynamicDataSourceHolder.setDataSource(targetDataSource);
        }
        // 执行方法
        Object result = pjp.proceed();
        DynamicDataSourceHolder.clearDataSource();
        return result;
    }
}
