package org.simpleframework.mvc.render;

import org.simpleframework.mvc.RequestProcessorChain;

/**
 * 渲染请求结果
 */
public interface ResultRender {
    /**
     * 执行渲染
     * @param requestProcessorChain 请求处理器责任链
     * @throws Exception 异常
     */
    void render(RequestProcessorChain requestProcessorChain) throws Exception;
}
