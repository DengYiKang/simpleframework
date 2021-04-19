package com.yikang.controller;

import com.yikang.controller.frontend.MainPageController;
import com.yikang.controller.superadmin.HeadLineOperationController;
import com.yikang.service.combine.HeadLineShopCategoryCombineService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 这个类起拦截功能，根据不同的url转发到不同的controller处理
 */
@WebServlet("/")
//注意，不能拦截"/*"，否则会进入死循环。因为"/*"会拦截转发行为（forward hello.jsp）
//"/"不会拦截jsp请求
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getServletPath());
        System.out.println(req.getMethod());
        if (req.getServletPath().equals("/frontend/getmainpageinfo") && req.getMethod().equals("GET")) {
            new MainPageController().getMainPageInfo(req, resp);
        } else if (req.getServletPath().equals("/superadmin/addheadline") && req.getMethod().equals("POST")) {
            new HeadLineOperationController().addHeadLine(req, resp);
        }
    }
}
