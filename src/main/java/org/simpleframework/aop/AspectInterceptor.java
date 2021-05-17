package org.simpleframework.aop;

import lombok.Getter;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.simpleframework.aop.aspect.AspectInfo;
import org.simpleframework.aop.interceptor.InterceptorChain;
import org.simpleframework.aop.interceptor.MyInterceptor;
import org.simpleframework.aop.interceptor.TargetMethod;
import org.simpleframework.util.ValidationUtil;

import java.lang.reflect.Method;
import java.util.*;

public class AspectInterceptor implements MethodInterceptor {
    //被代理的类
    private Class<?> targetClass;

    //排好序的列表
    @Getter
    List<AspectInfo> sortedAspectInfoList;

    public AspectInterceptor(Class<?> targetClass, List<AspectInfo> aspectInfoList) {
        this.targetClass = targetClass;
        this.sortedAspectInfoList = sortAspectInfoList(aspectInfoList);
    }

    /**
     * 按照order的值进行升序排序，确保order值小的aspect先被织入
     *
     * @param aspectInfoList aspectInfo列表
     * @return 排好序后的aspectInfo列表
     */
    private List<AspectInfo> sortAspectInfoList(List<AspectInfo> aspectInfoList) {
        Collections.sort(aspectInfoList, Comparator.comparingInt(AspectInfo::getOrderIndex));
        return aspectInfoList;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        collectAccurateMatchedAspectList(method);
        if (ValidationUtil.isEmpty(sortedAspectInfoList)) {
            //这里要注意，如果没有匹配的切面，那么还是需要调用原方法
            return methodProxy.invokeSuper(o, args);
        }
        TargetMethod targetMethod = new TargetMethod(o, method, args);
        List<MyInterceptor> interceptorList = new ArrayList<>();
        for (AspectInfo aspectInfo : this.sortedAspectInfoList) {
            interceptorList.add(new MyInterceptor(targetMethod, aspectInfo.getAspectObject()));
        }
        InterceptorChain chain = new InterceptorChain(interceptorList, o, methodProxy, args);
        return chain.proceed();
    }

    private void collectAccurateMatchedAspectList(Method method) {
        if (ValidationUtil.isEmpty(sortedAspectInfoList)) return;
        Iterator<AspectInfo> it = sortedAspectInfoList.iterator();
        while (it.hasNext()) {
            AspectInfo aspectInfo = it.next();
            if (!aspectInfo.getPointcutLocator().accurateMatches(method)) {
                it.remove();
            }
        }
    }
}
