package org.simpleframework.mvc.processor.impl;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.mvc.RequestProcessorChain;
import org.simpleframework.mvc.processor.RequestProcessor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 * 静态资源请求处理，包括但不限于图片、css以及js文件等，转发到tomcat的DefaultServlet处理
 */
@Slf4j
public class StaticResourceRequestProcessor implements RequestProcessor {

    //tomcat默认请求派发器RequestDispatcher的名称
    public static final String DEFAULT_TOMCAT_SERVLET = "default";
    public static final String STATIC_RESOURCE_PREFIX = "/static/";
    //tomcat的default servlet实例
    private RequestDispatcher defaultDispatcher;

    public StaticResourceRequestProcessor(ServletContext servletContext) {
        this.defaultDispatcher = servletContext.getNamedDispatcher(DEFAULT_TOMCAT_SERVLET);
        if (defaultDispatcher == null) {
            throw new RuntimeException("There is no default tomcat servlet");
        }
        log.info("The default servlet for static resource is {}", DEFAULT_TOMCAT_SERVLET);
    }

    @Override
    public boolean process(RequestProcessorChain requestProcessorChain) throws Exception {
        //1、通过请求路径判断是否是请求的静态资源，假设我们将所有的静态资源放在webapp/static下
        if (isStaticResource(requestProcessorChain.getRequestPath())) {
            //2、如果是静态资源，则将请求转发给default servlet处理
            defaultDispatcher.forward(requestProcessorChain.getRequest(), requestProcessorChain.getResponse());
            //已经交由tomcat的default servlet处理了，无需后续的责任链处理
            return false;
        }
        return true;
    }

    /**
     * 通过请求路径前缀（目录）判断是否为对静态资源的请求 /static/
     * 注意，为什么不是/webapp/开头的path？因为/webapp/是classpath，不会出现在请求的路径里面
     *
     * @param requestPath 请求路径
     * @return 如果是对静态资源的请求则返回true
     */
    private boolean isStaticResource(String requestPath) {
        return requestPath.startsWith(STATIC_RESOURCE_PREFIX);
    }
}
