package com.bizvane.messagefacade.models.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yunjie.tian on 2018/7/16.
 */
public class GenrealTemMessage implements Serializable{

    private static final long serialVersionUID = 1L;


    
    @ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
    private Long sysBrandId;

    
    @ApiModelProperty(value = "批量短信类型消息：GEN_QY_TEMPLATE_MESSAGE", name = "templateType", required = false, example = "")
    private String templateType;


	public Long getSysBrandId() {
		return sysBrandId;
	}


	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}


	public String getTemplateType() {
		return templateType;
	}


	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}


    


    

}
