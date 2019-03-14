package com.bizvane.messageservice.mongo;

import com.bizvane.messageservice.common.utils.PageForm;
import com.bizvane.messagefacade.models.po.MsgWxTuWenPO;
import com.bizvane.messagefacade.models.vo.WechatMessageLogVO;
import com.bizvane.utils.responseinfo.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class WechatTuWenLogPOMongoDao extends BaseMongoDao<MsgWxTuWenPO> {

  public String saveRocketLogPO(MsgWxTuWenPO msgSmsTempPO) {

	  MsgWxTuWenPO item = super.insert(msgSmsTempPO);
      return item.get_id();
  }
  
  public void updateRocketLogPO(MsgWxTuWenPO msgSmsTempPO) {
	  
	  Query query = Query.query(Criteria.where("_id").is(msgSmsTempPO.get_id()));
	  super.update(query, msgSmsTempPO);
	  
  }
  public static boolean isNumeric(String str){
	     for (int i = str.length();--i>=0;){ 
			if (!Character.isDigit(str.charAt(i))){
             return false;
		        }
		   }
	      return true;
   }

  public  PageInfo<MsgWxTuWenPO> getRocketLogPOList( WechatMessageLogVO wechatMessageLogVO) {
    Criteria criteriabaseSysBrandId= new Criteria();
    Criteria criteria = new Criteria();
    Criteria headlTitle= new Criteria();
    Criteria groupName= new Criteria();
    
    Criteria criteriasendTimeStart= new Criteria();
    Criteria criteriasendTimeEnd= new Criteria();
    Criteria criteriaSearchValue= new Criteria();
    Criteria criteriaSearchStatistics= new Criteria();
    

    
    if(null!=wechatMessageLogVO.getSysBrandId()) {
    	criteriabaseSysBrandId= Criteria.where("brandId").is(wechatMessageLogVO.getSysBrandId());
    }else {
    	
    	PageInfo<MsgWxTuWenPO> saveMsgWxTuWenPOList=new  PageInfo<MsgWxTuWenPO>();
    	 return saveMsgWxTuWenPOList;   
    }

    if(!StringUtils.isBlank(wechatMessageLogVO.getSearchValue())) {
    	criteriaSearchValue.orOperator(
	    Criteria.where("headlTitle").is(wechatMessageLogVO.getSearchValue()),
	    Criteria.where("groupName").is(wechatMessageLogVO.getSearchValue())
		);
    }
    
    if(!StringUtils.isBlank(wechatMessageLogVO.getHeadlTitle())) {
    	headlTitle=Criteria.where("headlTitle").is(wechatMessageLogVO.getHeadlTitle());
    }
    
    if(!StringUtils.isBlank(wechatMessageLogVO.getGroupName())) {
    	groupName=Criteria.where("groupName").is(wechatMessageLogVO.getGroupName());
    }


	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  try {

		if(!StringUtils.isBlank(wechatMessageLogVO.getSendTimeStart())) {

			Date timeStart = format.parse(wechatMessageLogVO.getSendTimeStart());
			criteriasendTimeStart= Criteria.where("createDate").gte(timeStart);


		}

		if(!StringUtils.isBlank(wechatMessageLogVO.getSendTimeEnd())) {
			Date timeEnd = format.parse(wechatMessageLogVO.getSendTimeEnd());
			criteriasendTimeEnd = Criteria.where("createDate").lte(timeEnd);
		}

	  }catch (Exception e){}


    if(!StringUtils.isBlank(wechatMessageLogVO.getSendState())) {
    	criteriaSearchStatistics= Criteria.where("sendState").is(wechatMessageLogVO.getSendState());
    }
    

    criteria.andOperator(criteriaSearchValue,criteriabaseSysBrandId,headlTitle,groupName,
	criteriaSearchStatistics,criteriasendTimeStart,criteriasendTimeEnd);


    Query findquery = new Query();
    findquery.addCriteria(criteria).with(new Sort(Sort.Direction.DESC, "createDate"));
    
    PageForm pageForm =new PageForm();
    pageForm.setPageNum(wechatMessageLogVO.getPageNumber());
    pageForm.setPageSize(wechatMessageLogVO.getPageSize());
    
    PageInfo<MsgWxTuWenPO> MsgWxTuWenPOl=super.findPage(pageForm, findquery);
    
     return MsgWxTuWenPOl;
     
  }
}



