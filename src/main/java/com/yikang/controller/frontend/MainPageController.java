package com.yikang.controller.frontend;

import com.yikang.entity.dto.MainPageInfoDTO;
import com.yikang.entity.dto.Result;
import com.yikang.service.combine.HeadLineShopCategoryCombineService;
import lombok.Getter;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;
import org.simpleframework.mvc.annotation.RequestMapping;
import org.simpleframework.mvc.type.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Getter
@RequestMapping("/main")
public class MainPageController {

    @Autowired(value = "HeadLineShopCategoryCombineServiceImpl")
    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp) {
        return headLineShopCategoryCombineService.getMainPageInfo();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void throwException() {
        throw new RuntimeException("抛出异常测试");
    }
}
