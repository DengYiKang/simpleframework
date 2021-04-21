package com.yikang.service.combine.impl;

import com.yikang.entity.bo.HeadLine;
import com.yikang.entity.bo.ShopCategory;
import com.yikang.entity.dto.MainPageInfoDTO;
import com.yikang.entity.dto.Result;
import com.yikang.service.combine.HeadLineShopCategoryCombineService;
import com.yikang.service.solo.HeadLineService;
import com.yikang.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Service;

import java.util.List;


@Service
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {

    private HeadLineService headLineService;

    private ShopCategoryService shopCategoryService;

    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        //1.获取头条列表
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> HeadLineResult = headLineService.queryHeadLineList(headLineCondition, 1, 4);
        //2.获取店铺类别列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult = shopCategoryService.queryShopCategory(shopCategoryCondition, 1, 100);
        //3.合并两者并返回
        Result<MainPageInfoDTO> result = mergeMainPageInfoResult(HeadLineResult, shopCategoryResult);
        return result;
    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineResult, Result<List<ShopCategory>> shopCategoryResult) {
        return null;
    }
}
