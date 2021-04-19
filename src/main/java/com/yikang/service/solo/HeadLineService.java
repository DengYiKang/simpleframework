package com.yikang.service.solo;

import com.yikang.entity.bo.HeadLine;
import com.yikang.entity.dto.Result;

import java.util.List;

public interface HeadLineService {
    Result<Boolean> addHeadLine(HeadLine headLine);

    Result<Boolean> removeHeadLine(int headLineId);

    Result<Boolean> modifyHeadLine(HeadLine headLine);

    Result<HeadLine> queryHeadLineById(int headLineId);

    Result<List<HeadLine>> queryHeadLineList(HeadLine headLineCondition, int pageIndex, int pageSize);
}
