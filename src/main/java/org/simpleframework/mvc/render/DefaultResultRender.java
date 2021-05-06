package org.simpleframework.mvc.render;

import org.simpleframework.mvc.RequestProcessorChain;

/**
 * 默认渲染器
 * 当用户不需要获取请求结果时被调用
 */
public class DefaultResultRender implements ResultRender{
    @Override
    public void render(RequestProcessorChain requestProcessorChain) throws Exception {

    }
}
