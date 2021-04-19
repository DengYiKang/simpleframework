package com.yikang.controller.frontend;

import com.yikang.entity.dto.MainPageInfoDTO;
import com.yikang.entity.dto.Result;
import com.yikang.service.combine.HeadLineShopCategoryCombineService;
import lombok.Getter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainPageController {

    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp) {
        return headLineShopCategoryCombineService.getMainPageInfo();
    }

    public void throwException() {
        throw new RuntimeException("抛出异常测试");
    }
}
