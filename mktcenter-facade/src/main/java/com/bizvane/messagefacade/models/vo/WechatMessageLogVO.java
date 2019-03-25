package com.bizvane.messagefacade.models.vo;

import com.bizvane.messagefacade.models.po.WechatMessageLogPO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yunjie.tian on 2018/7/31.
 */
public class WechatMessageLogVO extends WechatMessageLogPO{

    @ApiModelProperty(value = "基本查询条件",name = "searchValue",required = false,example = "")
    private String searchValue;
    @ApiModelProperty(value = "发送开始时间",name = "sendTimeStart",required = false,example = "")
    private String sendTimeStart;
    @ApiModelProperty(value = "发送结束时间",name = "sendTimeEnd",required = false,example = "")
    private String sendTimeEnd;
    @ApiModelProperty(value = "品牌sysBrandId",name = "sysBrandId",required = false,example = "")
	private Long sysBrandId;

    @ApiModelProperty(value = "页码", name = "pageNumber", required = false, example = "")
    private Integer pageNumber = 1;

    @ApiModelProperty(value = "每页显示条数", name = "pageSize", required = false, example = "")
    private Integer pageSize = 10;

    
    @ApiModelProperty(value = "消息名称",name = "sendTimeEnd",required = false,example = "")
    private String headlTitle;
    @ApiModelProperty(value = "分组名称",name = "sendTimeEnd",required = false,example = "")
    private String groupName;
    

	public String getHeadlTitle() {
		return headlTitle;
	}

	public void setHeadlTitle(String headlTitle) {
		this.headlTitle = headlTitle;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Long getSysBrandId() {
		return sysBrandId;
	}

	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getSendTimeStart() {
        return sendTimeStart;
    }

    public void setSendTimeStart(String sendTimeStart) {
        this.sendTimeStart = sendTimeStart;
    }

    public String getSendTimeEnd() {
        return sendTimeEnd;
    }

    public void setSendTimeEnd(String sendTimeEnd) {
        this.sendTimeEnd = sendTimeEnd;
    }
}
