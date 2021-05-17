package org.simpleframework.aop.interceptor;

import net.sf.cglib.proxy.MethodProxy;

import java.util.List;

public class InterceptorChain {
    private List<MyInterceptor> interceptorList;
    private MethodProxy methodProxy;
    private Object targetObject;
    private Object[] args;
    private int index;

    public InterceptorChain(List<MyInterceptor> list, Object targetObject, MethodProxy methodProxy, Object[] args) {
        this.interceptorList = list;
        this.targetObject = targetObject;
        this.methodProxy = methodProxy;
        this.args = args;
        index = 0;
    }

    public Object proceed() throws Throwable {
        if (index == interceptorList.size()) {
            return methodProxy.invokeSuper(targetObject, args);
        }
        return interceptorList.get(this.index++).invoke(this);
    }
}
