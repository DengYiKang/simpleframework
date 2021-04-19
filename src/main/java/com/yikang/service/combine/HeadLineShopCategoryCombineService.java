package com.yikang.service.combine;

import com.yikang.entity.dto.MainPageInfoDTO;
import com.yikang.entity.dto.Result;

public interface HeadLineShopCategoryCombineService {
    Result<MainPageInfoDTO> getMainPageInfo();
}
