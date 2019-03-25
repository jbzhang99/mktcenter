package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;

/**
 * Created by yunjie.tian on 2018/8/22.
 */
public class CouponSendBatchAgainVO implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long[] ids;

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }
}
