package com.yikang.controller.superadmin;

import com.yikang.entity.bo.HeadLine;
import com.yikang.entity.dto.Result;
import com.yikang.service.solo.HeadLineService;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;
import org.simpleframework.mvc.annotation.RequestMapping;
import org.simpleframework.mvc.annotation.RequestParam;
import org.simpleframework.mvc.annotation.ResponseBody;
import org.simpleframework.mvc.type.ModelAndView;
import org.simpleframework.mvc.type.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping(value = "/headline")
public class HeadLineOperationController {

    @Autowired
    private HeadLineService headLineService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addHeadLine(@RequestParam("lineName") String lineName,
                                    @RequestParam("lineLink") String lineLink,
                                    @RequestParam("lineImg") String lineImg,
                                    @RequestParam("priority") Integer priority) {
        //TODO:参数校验以及请求参数转化
        HeadLine headLine = new HeadLine();
        headLine.setLineName(lineName);
        headLine.setLineLink(lineLink);
        headLine.setLineImg(lineImg);
        headLine.setPriority(priority);
        Result<Boolean> result = headLineService.addHeadLine(headLine);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView("addheadline.jsp").addViewData("result", result);
        return modelAndView;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public void removeHeadLine() {
        //TODO:参数校验以及请求参数转化
        System.out.println("delete headline");
    }

    public Result<Boolean> modifyHeadLine(HttpServletRequest request, HttpServletResponse response) {
        //TODO:参数校验以及请求参数转化
        return headLineService.modifyHeadLine(new HeadLine());
    }


    public Result<HeadLine> queryHeadLineById(HttpServletRequest request, HttpServletResponse response) {
        //TODO:参数校验以及请求参数转化
        return headLineService.queryHeadLineById(1);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<HeadLine>> queryHeadLineList() {
        //TODO:参数校验以及请求参数转化
        return headLineService.queryHeadLineList(new HeadLine(), 1, 100);
    }

}
