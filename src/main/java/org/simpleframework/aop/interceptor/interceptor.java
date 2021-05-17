package org.simpleframework.aop.interceptor;

public interface interceptor {
    Object invoke(InterceptorChain chain) throws Throwable;
}
