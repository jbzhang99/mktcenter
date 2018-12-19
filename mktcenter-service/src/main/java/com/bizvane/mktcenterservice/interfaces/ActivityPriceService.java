package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceBO;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceParamVO;
import com.bizvane.utils.responseinfo.ResponseData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/12/19 14:21
 */
public interface ActivityPriceService {

    public ResponseData<String> addActivityPrice(ActivityPriceBO bo, HttpServletRequest request);
    public ResponseData<ActivityPriceBO> selectActivityPrice(Long mktActivityId,HttpServletRequest request);
    public ResponseData<List<MktActivityPOWithBLOBs>> selectActivityPriceLists(ActivityPriceParamVO vo, HttpServletRequest request);
}
