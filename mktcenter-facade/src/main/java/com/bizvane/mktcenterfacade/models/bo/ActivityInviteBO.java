package com.bizvane.mktcenterfacade.models.bo;

import lombok.Data;

/**
 * @author chen.li
 * @date on 2019/6/26 13:57
 * @description
 */
@Data
public class ActivityInviteBO {

    /**
     * 是否奖励了
     */
    private Boolean awarded;

    /**
     * 参与次数
     */
    private Integer parcitpateTimes;
}
