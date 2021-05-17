package org.simpleframework.aop.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.aop.aspect.DefaultAspect;

@Slf4j
public class MyInterceptor implements interceptor {

    private TargetMethod targetMethod;
    private DefaultAspect aspect;

    public MyInterceptor(TargetMethod targetMethod, DefaultAspect aspect) {
        this.targetMethod = targetMethod;
        this.aspect = aspect;
    }

    @Override
    public Object invoke(InterceptorChain chain) throws Throwable {
        Object returnValue = null;
        try {
            aspect.before(targetMethod.getTargetObject().getClass(), targetMethod.getMethod(), targetMethod.getArgs());
            returnValue = chain.proceed();
            aspect.afterReturning(targetMethod.getTargetObject().getClass(), targetMethod.getMethod(), targetMethod.getArgs(), returnValue);
        } catch (Throwable throwable) {
            aspect.afterThrowing(targetMethod.getTargetObject().getClass(), targetMethod.getMethod(), targetMethod.getArgs(), throwable);
            throw throwable;
        }
        return returnValue;
    }
}
