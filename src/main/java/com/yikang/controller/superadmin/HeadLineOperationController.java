package com.yikang.controller.superadmin;

import com.yikang.entity.bo.HeadLine;
import com.yikang.entity.dto.Result;
import com.yikang.service.solo.HeadLineService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class HeadLineOperationController {

    private HeadLineService headLineService;

    public Result<Boolean> addHeadLine(HttpServletRequest request, HttpServletResponse response) {
        //TODO:参数校验以及请求参数转化
        return headLineService.addHeadLine(new HeadLine());
    }

    public Result<Boolean> removeHeadLine(HttpServletRequest request, HttpServletResponse response) {
        //TODO:参数校验以及请求参数转化
        return headLineService.removeHeadLine(1);
    }

    public Result<Boolean> modifyHeadLine(HttpServletRequest request, HttpServletResponse response) {
        //TODO:参数校验以及请求参数转化
        return headLineService.modifyHeadLine(new HeadLine());
    }

    public Result<HeadLine> queryHeadLineById(HttpServletRequest request, HttpServletResponse response) {
        //TODO:参数校验以及请求参数转化
        return headLineService.queryHeadLineById(1);
    }

    public Result<List<HeadLine>> queryHeadLineList(HttpServletRequest request, HttpServletResponse response) {
        //TODO:参数校验以及请求参数转化
        return headLineService.queryHeadLineList(new HeadLine(), 1, 100);
    }

}
