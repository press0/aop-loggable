package com.pressc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by q on 5/24/15.
 */
@Aspect
public class MethodLogger {
    @Around("execution(* *(..)) && @annotation(com.pressc.aspect.Loggable)")
    public Object around(ProceedingJoinPoint point) {
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable t) {
            System.out.println(t);
        }
        String s = String.format(
                "#%s(%s): %s in %s msecs",
                MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
                args(point.getArgs()),
                result,
                System.currentTimeMillis() - start
        );
        System.out.println(s);
        return result;
    }

    String args(Object[] objs) {
        StringBuilder sb = new StringBuilder();
        for (Object o : objs) {
            sb.append("'" + o.toString() + "' ");
        }
        return sb.toString();
    }
}