package com.yikang.entity.dto;

import com.yikang.entity.bo.HeadLine;
import com.yikang.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
