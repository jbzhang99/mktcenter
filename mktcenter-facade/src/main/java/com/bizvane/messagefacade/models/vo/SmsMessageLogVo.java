package com.bizvane.messagefacade.models.vo;

import com.bizvane.messagefacade.models.po.MsgSmsLogPO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Geng on 2018/8/9.
 */
public class SmsMessageLogVo extends MsgSmsLogPO{


    @ApiModelProperty(value = "基本查询条件",name = "baseSearchValue",required = false,example = "")
    private String baseSearchValue;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "短信发送的最早时间",name = "sentTimeStart",required = false,example = "")
    private Date sendTimeStart;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "短信发送的最晚时间",name = "sendTimeEnd",required = false,example = "")
    private Date sendTimeEnd;
    
    @ApiModelProperty(value = "页码", name = "pageNumber", required = false, example = "")
    private Integer pageNumber = 1;

    @ApiModelProperty(value = "每页显示条数", name = "pageSize", required = false, example = "")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "品牌sysBrandId",name = "sysBrandId",required = false,example = "")
	private Long sysBrandId;
    

    public Long getSysBrandId() {
		return sysBrandId;
	}

	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getBaseSearchValue() {
        return baseSearchValue;
    }

    public void setBaseSearchValue(String baseSearchValue) {
        this.baseSearchValue = baseSearchValue;
    }

    public Date getSendTimeStart() {
        return sendTimeStart;
    }

    public void setSendTimeStart(Date sentTimeStart) {
        this.sendTimeStart = sentTimeStart;
    }

    public Date getSendTimeEnd() {
        return sendTimeEnd;
    }

    public void setSendTimeEnd(Date sendTimeEnd) {
        this.sendTimeEnd = sendTimeEnd;
    }
}
