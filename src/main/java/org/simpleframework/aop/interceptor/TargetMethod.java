package org.simpleframework.aop.interceptor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TargetMethod {
    private Object targetObject;
    private Method method;
    private Object[] args;
}
