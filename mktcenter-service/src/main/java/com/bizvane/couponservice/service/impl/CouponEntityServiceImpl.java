package com.bizvane.couponservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.enums.CouponManualTaskStatusEnum;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.es.CouponEntityInfoSearchPojo;
import com.bizvane.couponfacade.es.CouponEntitySearchConstant;
import com.bizvane.couponfacade.models.po.*;
import com.bizvane.couponfacade.models.vo.*;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponfacade.utils.TimeUtils;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponservice.common.constants.SystemConstants;
import com.bizvane.couponservice.common.utils.DateUtil;
import com.bizvane.couponservice.common.utils.CouponSpringContextUtil;
import com.bizvane.couponservice.es.repository.CouponEntityserviceRepository;
import com.bizvane.couponservice.es.repository.CouponserviceRepository;
import com.bizvane.couponservice.mappers.*;
import com.bizvane.couponservice.service.CouponBatchSendRecordService;
import com.bizvane.couponservice.service.CouponEntityService;
import com.bizvane.couponservice.service.CouponSendFailLogService;
import com.bizvane.couponservice.service.SendCouponService;
import com.bizvane.members.facade.es.pojo.MembersInfoSearchPojo;
import com.bizvane.members.facade.exception.MemberException;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.models.query.CouponMemberPo;
import com.bizvane.members.facade.service.api.MemberInfoApiForCouponService;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.WxChannelInfoApiService;
import com.bizvane.members.facade.vo.MemberInfoForCouponSearchVo;
import com.bizvane.members.facade.vo.WxChannelAndMemberVo;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by yunjie.tian on 2018/7/20.
 */
@Service
public class CouponEntityServiceImpl implements CouponEntityService{

    private static Logger logger = LoggerFactory.getLogger(CouponEntityServiceImpl.class);
    
	public static final String YYYY_MM_DD_T_HH_MM_SS_SSS_0800 = "yyyy-MM-dd'T'HH:mm:ss.SSS+0800";
	public static final String ASIA_SHANGHAI = "Asia/Shanghai";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private CouponEntityPOMapper couponEntityPOMapper;
    @Autowired
    private CouponDefinitionPOMapper couponDefinitionPOMapper;
    @Autowired
    private CouponStatusLogPOMapper couponStatusLogPOMapper;
    @Autowired
    private CouponSendFailLogPOMapper couponSendFailLogPOMapper;
    @Autowired
    private WxChannelInfoApiService wxChannelInfoApiService;
    @Autowired
    private CouponBatchSendRecordPOMapper couponBatchSendRecordPOMapper;
    @Autowired
    private CouponManualPOMapper couponManualPOMapper;
    @Autowired
    private CouponBatchSendRecordService couponBatchSendRecordService;
    @Autowired
    private CouponSendFailLogService couponSendFailLogService;
    @Autowired
    private SendCouponService sendCouponService;
    @Autowired
    private MemberInfoApiService memberInfoApiService;
    
    @Autowired
    private  CouponserviceRepository couponserviceRepository;
    
    @Autowired
    private CouponEntityserviceRepository couponEntityserviceRepository;
    
    @Autowired
    private  MemberInfoApiForCouponService memberInfoApiForCouponService;


    @Override
    public ResponseData<CouponEntityPO> findCouponEntity(String couponCode, String memberCode) {
        return null;
    }

    /**
     * 券的发放记录分页
     *
     * @param entityParam
     * @return
     */
    @Override
    public ResponseData<PageInfo<CouponEntityVO>> getList(CouponEntityVO entityParam, SysAccountPo accountPo, PageFormUtil pageForm) {

        logger.info("enter CouponEntityServiceImpl getList method");
        List<CouponEntityVO> newEntityVOList  = new ArrayList<>();
        ResponseData<PageInfo<CouponEntityVO>> responseData = new ResponseData<>();
        PageInfo<CouponEntityVO> pageInfonewEntityVOList = new PageInfo<>(newEntityVOList);
        responseData.setData(pageInfonewEntityVOList);

        //本品牌
        entityParam.setSysBrandId(accountPo.getBrandId());

        CouponStatusEntitySuccessVO successVO = new CouponStatusEntitySuccessVO();
        successVO.setCouponStatusUnused(SystemConstants.COUPON_STATUS_UNUSED);
        successVO.setCouponStatusOverdue(SystemConstants.COUPON_STATUS_OVERDUE);
        successVO.setCouponStatusUsed(SystemConstants.COUPON_STATUS_USED);

//        转换
//      1.手动发券任务 -- 85
//      2.会员活动-- 15,30,35,45,50,55,90,100
//      3.会员任务 -- 60,65,70,75,80
//      4.智能营销 - 95
//      5.会员分组运营-94
//      6.转赠-20
//      7.积分商城-101
//      8.企业微信券-102
//      8.104红包膨胀，
//      8.101 - 积分商城
        if(entityParam.getListType()==null) {
            entityParam.setListType("1");
        }
        if(entityParam.getListType().equals("1")) {
            entityParam.setListType("85");
        }else if(entityParam.getListType().equals("2")) {
            entityParam.setListType("10,15,30,35,45,50,55,56,90,100,103,104,105");
        }else if(entityParam.getListType().equals("3")) {
            entityParam.setListType("60,65,70,75,80");
        }else if(entityParam.getListType().equals("4")) {
            entityParam.setListType("95");
        }else if(entityParam.getListType().equals("5")) {
            entityParam.setListType("94");
        }else if(entityParam.getListType().equals("6")) {
            entityParam.setListType("20");
        }else if(entityParam.getListType().equals("7")) {
            entityParam.setListType("101");
        }else if(entityParam.getListType().equals("8")) {
            entityParam.setListType("102");
        }
//       couponStatus 20-未使用，25-已过期，30-已核销',
        logger.info("查询时间吧1--" + new Date().getTime());

        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        logger.info("查询时间吧2--" + new Date().getTime());
        //ResponseData<Long> totalResult = getCouponTotal(entityParam,accountPo);

        //ResponseData<Long> totalResult = getCouponTotal(entityParam,successVO);
        //logger.info("查询时间吧3--" + new Date().getTime());
        //查询会员信息
        CouponMemberPo couponMember = new CouponMemberPo();
        if(entityParam.getPhone()!=null) {
        	couponMember.setPhone(entityParam.getPhone());
            ResponseData<List<MemberInfoModel>> getMemberInfoByCodeList = memberInfoApiService.getMemberInfoByCodeList(couponMember);
            if (CollectionUtils.isNotEmpty(getMemberInfoByCodeList.getData()) ) {
            	for(MemberInfoModel memberInfoModel : getMemberInfoByCodeList.getData()) {
            		entityParam.setMemberCode(memberInfoModel.getMemberCode());
            	}
            }else {
               return responseData;
            }
            
        }else if(entityParam.getCardNo()!=null) {
        	couponMember.setCardNo(entityParam.getCardNo());
            ResponseData<List<MemberInfoModel>> getMemberInfoByCodeList = memberInfoApiService.getMemberInfoByCodeList(couponMember);
            if (CollectionUtils.isNotEmpty(getMemberInfoByCodeList.getData())) {
            	for(MemberInfoModel memberInfoModel : getMemberInfoByCodeList.getData()) {
            		entityParam.setMemberCode(memberInfoModel.getMemberCode());
            	}
            }else {
                return responseData;
             }
        }else if(entityParam.getBaseSearchValue()!=null) {
        	couponMember.setCardNo(entityParam.getBaseSearchValue());
            ResponseData<List<MemberInfoModel>> getMemberInfoByCodeList = memberInfoApiService.getMemberInfoByCodeList(couponMember);
            if (CollectionUtils.isNotEmpty(getMemberInfoByCodeList.getData())) {
            	for(MemberInfoModel memberInfoModel : getMemberInfoByCodeList.getData()) {
            		entityParam.setMemberCode(memberInfoModel.getMemberCode());
            		entityParam.setBaseSearchValue("");
            	}
            }else {
                return responseData;
             }
        }
        //查询会员信息	

        //查询券
        logger.info("查询时间吧333--" + new Date().getTime());
        List<CouponEntityVO> entityVOList = couponEntityPOMapper.findCouponEntityByConditions(entityParam,successVO);
        logger.info("查询时间吧444--" + new Date().getTime());


        //统计会员code
        List<String> memberCodeList = new ArrayList<>();
        for(CouponEntityVO entityVO : entityVOList){
            memberCodeList.add(entityVO.getMemberCode());
        }

       ResponseData<List<MemberInfoModel>> getMemberInfoByCodeList = null;
        if (CollectionUtils.isNotEmpty(entityVOList)) {
           //查询会员接口
           CouponMemberPo couponMemberPo = new CouponMemberPo();
           couponMemberPo.setMemberCodeList(memberCodeList);
           getMemberInfoByCodeList = memberInfoApiService.getMemberInfoByCodeList(couponMemberPo);
        }

        Map<String, MemberInfoModel> map = new HashMap<>();
        if (getMemberInfoByCodeList != null && getMemberInfoByCodeList.getData() != null) {
        	for(MemberInfoModel memberInfoModel : getMemberInfoByCodeList.getData()) {
        		map.put(memberInfoModel.getMemberCode(), memberInfoModel);
        	}
        }

            for(CouponEntityVO couponEntityVO : entityVOList){
            	MemberInfoModel MemberNamePojoNEW 	= map.get(couponEntityVO.getMemberCode());
                if(MemberNamePojoNEW!=null) {
                    couponEntityVO.setCardNo(MemberNamePojoNEW.getCardNo());
                    couponEntityVO.setMemberName(MemberNamePojoNEW.getName());
                    couponEntityVO.setName(MemberNamePojoNEW.getName());
                    couponEntityVO.setPhone(MemberNamePojoNEW.getPhone());
                }

            }
            //查询会员接口
        logger.info("查询时间吧4" + new Date().getTime());
        PageInfo<CouponEntityVO> pageInfo = new PageInfo<>(entityVOList);
        //pageInfo.setTotal(totalResult.getData());

        responseData.setData(pageInfo);
        return responseData;
    }
    /**
     * 券的发放记录分页
     *
     * @param entityParam
     * @return
     */
    @Override
    public ResponseData<PageInfo<CouponEntityInfoSearchPojo>> getListEs(CouponEntityVO entityParam, SysAccountPo accountPo, PageFormUtil pageForm) {

        logger.info("es enter CouponEntityServiceImpl getList method" + DateUtil.format(new Date(), DateUtil.ymdhmsS));
        List<CouponEntityInfoSearchPojo> newEntityVOList  = new ArrayList<>();
        ResponseData<PageInfo<CouponEntityInfoSearchPojo>> responseData = new ResponseData<>();
        PageInfo<CouponEntityInfoSearchPojo> pageInfonewEntityVOList = new PageInfo<>(newEntityVOList);
        responseData.setData(pageInfonewEntityVOList);

        //本品牌
        entityParam.setSysBrandId(accountPo.getBrandId());

        CouponStatusEntitySuccessVO successVO = new CouponStatusEntitySuccessVO();
        successVO.setCouponStatusUnused(SystemConstants.COUPON_STATUS_UNUSED);
        successVO.setCouponStatusOverdue(SystemConstants.COUPON_STATUS_OVERDUE);
        successVO.setCouponStatusUsed(SystemConstants.COUPON_STATUS_USED);

        if(entityParam.getListType()==null) {
            entityParam.setListType("1");
        }
        
       
        if(entityParam.getPhone()!=null) {
        	MemberInfoForCouponSearchVo couponMemberPo =new MemberInfoForCouponSearchVo();
        	couponMemberPo.setPageNumber(1);
        	couponMemberPo.setPageSize(1);
        	couponMemberPo.setConditions(entityParam.getPhone());
        	couponMemberPo.setBrandId(accountPo.getBrandId());
        	ResponseData<com.github.pagehelper.PageInfo<MembersInfoSearchPojo>> getMemberInfoByCodeList = memberInfoApiForCouponService.queryMemberInfoForCouponCondition(couponMemberPo);
        	com.github.pagehelper.PageInfo<MembersInfoSearchPojo> friendPojos=getMemberInfoByCodeList.getData();
            if (CollectionUtils.isNotEmpty(friendPojos.getList()) ) {
            		entityParam.setMemberCode(friendPojos.getList().get(0).getMemberCode());
            }else { 
               return responseData;
            }
            
        }else if(entityParam.getCardNo()!=null) {
        	MemberInfoForCouponSearchVo couponMemberPo =new MemberInfoForCouponSearchVo();
        	couponMemberPo.setPageNumber(1);
        	couponMemberPo.setPageSize(1);
        	couponMemberPo.setConditions(entityParam.getCardNo());
        	couponMemberPo.setBrandId(accountPo.getBrandId());
        	ResponseData<com.github.pagehelper.PageInfo<MembersInfoSearchPojo>> getMemberInfoByCodeList = memberInfoApiForCouponService.queryMemberInfoForCouponCondition(couponMemberPo);
        	com.github.pagehelper.PageInfo<MembersInfoSearchPojo> friendPojos=getMemberInfoByCodeList.getData();
            if (CollectionUtils.isNotEmpty(friendPojos.getList()) ) {
            		entityParam.setMemberCode(friendPojos.getList().get(0).getMemberCode());
            }else { 
               return responseData;
            }
            
        }else if(entityParam.getBaseSearchValue()!=null) {
        	 
         	MemberInfoForCouponSearchVo couponMemberPo =new MemberInfoForCouponSearchVo();
         	couponMemberPo.setPageNumber(1);
         	couponMemberPo.setPageSize(1);
         	couponMemberPo.setConditions(entityParam.getBaseSearchValue());
         	couponMemberPo.setBrandId(accountPo.getBrandId());
         	ResponseData<com.github.pagehelper.PageInfo<MembersInfoSearchPojo>> getMemberInfoByCodeList = memberInfoApiForCouponService.queryMemberInfoForCouponCondition(couponMemberPo);
         	com.github.pagehelper.PageInfo<MembersInfoSearchPojo> friendPojos=getMemberInfoByCodeList.getData();
             if (CollectionUtils.isNotEmpty(friendPojos.getList()) ) {
             		entityParam.setMemberCode(friendPojos.getList().get(0).getMemberCode());
            		entityParam.setBaseSearchValue("");
             }

        }
        //查询会员信息	

        //查询券
        logger.info("es券查询拼接--" + DateUtil.format(new Date(), DateUtil.ymdhmsS));
        
		// 分页排序
        Pageable pageableCoupon=null;
        if(StringUtils.isNotBlank(entityParam.getFingType())) {
        	 pageableCoupon = PageRequest.of(pageForm.getPageNumber() - 1, pageForm.getPageSize(),
    				Sort.by(Sort.Direction.ASC, CouponEntitySearchConstant.VADTDATE));
        }else {
        	 pageableCoupon = PageRequest.of(pageForm.getPageNumber() - 1, pageForm.getPageSize(),
    				Sort.by(Sort.Direction.DESC, CouponEntitySearchConstant.ENTITYID));
        }
		
	
	
		BoolQueryBuilder builderCoupon = QueryBuilders.boolQuery();
		builderCoupon = getESWhere(entityParam, builderCoupon);
		 logger.info("es券查询开始--" + DateUtil.format(new Date(), DateUtil.ymdhmsS));
		Page<CouponEntityInfoSearchPojo> pageCoupon = couponEntityserviceRepository.search(builderCoupon, pageableCoupon);
		 logger.info("es券查询结束--" + DateUtil.format(new Date(), DateUtil.ymdhmsS));
		List<CouponEntityInfoSearchPojo>  entityVOList = pageCoupon.getContent();


		
		 logger.info("es拼接会员信息--" + DateUtil.format(new Date(), DateUtil.ymdhmsS));
        //统计会员code
        List<String> memberCodeList = new ArrayList<>();
        for(CouponEntityInfoSearchPojo entityVO : entityVOList){
            memberCodeList.add(entityVO.getMemberCode());
        }

       ResponseData<List<MemberInfoModel>> getMemberInfoByCodeList = null;
        if (CollectionUtils.isNotEmpty(entityVOList)) {
           //查询会员接口
           CouponMemberPo couponMemberPo = new CouponMemberPo();
           couponMemberPo.setMemberCodeList(memberCodeList);
           getMemberInfoByCodeList = memberInfoApiService.getMemberInfoByCodeList(couponMemberPo);
        }

        Map<String, MemberInfoModel> map = new HashMap<>();
        if (getMemberInfoByCodeList != null && getMemberInfoByCodeList.getData() != null) {
        	for(MemberInfoModel memberInfoModel : getMemberInfoByCodeList.getData()) {
        		map.put(memberInfoModel.getMemberCode(), memberInfoModel);
        	}
        }

            for(CouponEntityInfoSearchPojo couponEntityVO : entityVOList){
            	MemberInfoModel MemberNamePojoNEW 	= map.get(couponEntityVO.getMemberCode());
                if(MemberNamePojoNEW!=null) {
                    couponEntityVO.setCardNo(MemberNamePojoNEW.getCardNo());
                    couponEntityVO.setMemberName(MemberNamePojoNEW.getName());
                    couponEntityVO.setName(MemberNamePojoNEW.getName());
                    couponEntityVO.setPhone(MemberNamePojoNEW.getPhone());
                }

            }
            //查询会员接口
        PageInfo<CouponEntityInfoSearchPojo> pageInfo = new PageInfo<>(entityVOList);
        pageInfo.setTotal(pageCoupon.getTotalElements());
        logger.info("es拼接完成--" + DateUtil.format(new Date(), DateUtil.ymdhmsS));
        responseData.setData(pageInfo);
        return responseData;
    }

	public BoolQueryBuilder getESWhere(CouponEntityVO infoSearchVo, BoolQueryBuilder builder)
			throws MemberException {

		// valid
		builder.filter(QueryBuilders.matchQuery(CouponEntitySearchConstant.VALID, true));

		// 企业
		if (null != infoSearchVo.getSysCompanyId()) {
			builder.filter(
					QueryBuilders.matchQuery(CouponEntitySearchConstant.SYSCOMPANYID, infoSearchVo.getSysCompanyId()));
		}

		// 品牌号
		if (null != infoSearchVo.getSysBrandId()) {
			builder.filter(QueryBuilders.matchQuery(CouponEntitySearchConstant.SYSBRANDID, infoSearchVo.getSysBrandId()));
		}

		// 类型
		if (StringUtils.isNotBlank(infoSearchVo.getListType())) {
			
	        if(infoSearchVo.getListType().equals("1")) {
	        	infoSearchVo.setListType("85");
	        }else if(infoSearchVo.getListType().equals("2")) {
//	        	infoSearchVo.setListType("10,15,30,35,45,50,55,56,90,100,103,104");
	        }else if(infoSearchVo.getListType().equals("3")) {
//	        	infoSearchVo.setListType("60,65,70,75,80");
	        }else if(infoSearchVo.getListType().equals("4")) {
	        	infoSearchVo.setListType("95");
	        }else if(infoSearchVo.getListType().equals("5")) {
	        	infoSearchVo.setListType("94");
	        }else if(infoSearchVo.getListType().equals("6")) {
	        	infoSearchVo.setListType("20");
	        }else if(infoSearchVo.getListType().equals("7")) {
	        	infoSearchVo.setListType("101");
	        }else if(infoSearchVo.getListType().equals("8")) {
	        	infoSearchVo.setListType("102");
	        }
	        
	        if(infoSearchVo.getListType().equals("2")) {
	        	builder.must(QueryBuilders.termsQuery(CouponEntitySearchConstant.LISTTYPE,"10","15","30","35","45","50","55","56","90","100","103","104","105"));
	        }else if(infoSearchVo.getListType().equals("3")) {
	        	builder.must(QueryBuilders.termsQuery(CouponEntitySearchConstant.LISTTYPE,"60","65","70","75","80"));
	        }else {
	        	builder.must(QueryBuilders.termsQuery(CouponEntitySearchConstant.LISTTYPE, infoSearchVo.getListType()));
	        }
		}
		
		
		// 任务名称
		if (StringUtils.isNotBlank(infoSearchVo.getBusinessName())) {
			builder.filter(QueryBuilders.matchQuery(CouponEntitySearchConstant.BUSINESSNAME, infoSearchVo.getBusinessName()).operator(Operator.AND));
		}
		

		// 券定义id
		if (StringUtils.isNotBlank(infoSearchVo.getCouponDefinitionId())) {
			builder.filter(QueryBuilders.matchQuery(CouponEntitySearchConstant.COUPONDEFINITIONID, infoSearchVo.getCouponDefinitionId()));
		}
		
		// 券号
		if (StringUtils.isNotBlank(infoSearchVo.getCouponCode())) {
			builder.filter(QueryBuilders.matchQuery(CouponEntitySearchConstant.COUPONCODE, infoSearchVo.getCouponCode()));
		}
		
		// 会员号
		if (StringUtils.isNotBlank(infoSearchVo.getMemberCode())) {
			builder.filter(QueryBuilders.matchQuery(CouponEntitySearchConstant.MEMBERCODE, infoSearchVo.getMemberCode()));
		}
		// 券类型
		if (null != infoSearchVo.getPreferentialType()) {
			builder.filter(QueryBuilders.matchQuery(CouponEntitySearchConstant.PREFERENTIALTYPE, infoSearchVo.getPreferentialType()));
		}
		
		// 券状态
		if (null != infoSearchVo.getCouponStatus()) {
			builder.filter(QueryBuilders.matchQuery(CouponEntitySearchConstant.COUPONSTATUS, infoSearchVo.getCouponStatus()));
		}else {
			builder.filter(QueryBuilders.termsQuery(CouponEntitySearchConstant.COUPONSTATUS,"20","25","30"));
		}
		
		
		// 券名称
		if (StringUtils.isNotBlank(infoSearchVo.getCouponName())) {
			builder.filter(QueryBuilders.matchQuery(CouponEntitySearchConstant.COUPONNAME, infoSearchVo.getCouponName()).operator(Operator.AND));
		}
		
		// 创建人
		if (StringUtils.isNotBlank(infoSearchVo.getCreateUserName())) {
			builder.filter(QueryBuilders.matchQuery(CouponEntitySearchConstant.CREATEUSERNSME, infoSearchVo.getCreateUserName()));
		}
		
		// 是否使用
		if (null!=infoSearchVo.getIsUse()) {
			builder.filter(QueryBuilders.matchQuery(CouponEntitySearchConstant.ISUSE, infoSearchVo.getIsUse()));
		}
		
		// 高级搜索
		if (StringUtils.isNotBlank(infoSearchVo.getBaseSearchValue())) {
			
			// 查找与任何字段匹配的文档，但使用最佳字段中的_score
			builder.must(QueryBuilders
					.multiMatchQuery(infoSearchVo.getBaseSearchValue(), CouponEntitySearchConstant.COUPONNAME,
							CouponEntitySearchConstant.COUPONDEFINITIONID, CouponEntitySearchConstant.COUPONCODE)
					.operator(Operator.AND).type(MultiMatchQueryBuilder.Type.BEST_FIELDS)
					);
		}
		
		// 时间
		if (StringUtils.isNotBlank(infoSearchVo.getCreateDtStart())) {
			BoolQueryBuilder createTimeBuilder = QueryBuilders.boolQuery();
			createTimeBuilder.must(QueryBuilders.rangeQuery(CouponEntitySearchConstant.CREATEDTDATE)
					.includeLower(true).includeUpper(true).timeZone(ASIA_SHANGHAI)
					.from(this.dateFormat(infoSearchVo.getCreateDtStart()))
					.to(this.dateFormat(infoSearchVo.getCreateDtEnd())));
			builder.filter(createTimeBuilder);
		}
		 /**
     匹配所有文件
	     * 
	     * Bool Query 用于组合多个叶子或复合查询子句的默认查询
	     * 
		must 相当于 与 & =
		must not 相当于 非 ~   ！=
		should 相当于 或  |   or 
		filter  过滤
		boolQuery()
        .must(termQuery("content", "test1"))               
        .must(termQuery("content", "test4"))                 
        .mustNot(termQuery("content", "test2"))              
        .should(termQuery("content", "test3"))               
        .filter(termQuery("content", "test5"));
        
        
           * 使用QueryBuilder
	     * termQuery("key", obj) 完全匹配  不会对搜索词进行分词处理，
	     * termsQuery("key", obj1, obj2..)   一次匹配多个值
	     * matchQuery("key", Obj) 单个匹配, field不支持通配符, 前缀具高级特性 会分词
	     * multiMatchQuery("text", "field1", "field2"..);  匹配多个字段, field有通配符忒行
	     * matchAllQuery();    
	     */
//	    public static final String COUPONDEFINITIONID = "couponDefinitionId";
//	    public static final String COUPONCODE = "couponCode";
//	    public static final String COUPONNAME = "couponName";
//	    public static final String PREFERENTIALTYPE = "preferentialType";
//	    public static final String COUPONSTATUS = "couponStatus";
		
		
//	    public static final String CREATEDTSTART = "createDtStart";
//	    public static final String CREATEDTEND = "createDtEnd";

		return builder;
	}

	private static String dateFormat(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		return DateUtil.format(DateUtil.parse(str, YYYY_MM_DD_HH_MM_SS), YYYY_MM_DD_T_HH_MM_SS_SSS_0800);
	}
    /**
     * 券的发放记录数量查询
     * @return
     */
    @Override
    public ResponseData<Long> getCouponTotal(CouponEntityVO entityParam,CouponStatusEntitySuccessVO successVO){

        logger.info("enter CouponEntityServiceImpl getCouponTotal method");
        ResponseData<Long> responseData = new ResponseData<>();

        //查询券
        Long total = couponEntityPOMapper.findCouponEntityByConditions_COUNT(entityParam,successVO);

        responseData.setData(total);
        return responseData;
    }




    /**
     * 券的发放记录分页接口
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<PageInfo<CouponEntityVO>> getListRpc(CouponEntityVO vo, PageFormUtil pageForm) {
        logger.info("enter CouponEntityServiceImpl getList method");
        ResponseData<PageInfo<CouponEntityVO>> responseData = new ResponseData<>();

        if(null == vo.getSysBrandId()){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYS_BRAND_ID_NOT_NULL.getMessage());
            return responseData;
        }

        CouponStatusEntitySuccessVO successVO = new CouponStatusEntitySuccessVO();
        //successVO.setCouponStatusSyncSuccess(SystemConstants.COUPON_STATUS_SYNC_SUCCESS);
        successVO.setCouponStatusUnused(SystemConstants.COUPON_STATUS_UNUSED);
        successVO.setCouponStatusOverdue(SystemConstants.COUPON_STATUS_OVERDUE);
        successVO.setCouponStatusUsed(SystemConstants.COUPON_STATUS_USED);

        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        List<CouponEntityVO> list = couponEntityPOMapper.findCouponEntityByConditions(vo,successVO);

        PageInfo<CouponEntityVO> pageInfo = new PageInfo<>(list);

        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 券的发放记录分页
     *
     * @param vo
     * @return
     */
    @Override
    public List<CouponSendLogExportVO> getListExport(CouponEntityVO vo,SysAccountPo accountPo) {
        logger.info("enter CouponEntityServiceImpl getList method");

       // List<CouponSendLogExportVO> list = couponEntityPOMapper.findListExportByConditions(vo,null,accountPo.getBrandId(),null,null);

        return null;
    }


    /**
     * 券的发放记录详细查询
     * @param couponEntityId
     * @return
     */
    @Override
    public ResponseData<CouponDetailResponseVO> getCouponEntityAndDefinitionByEntityId(Long couponEntityId) {
        logger.info("enter CouponEntityServiceImpl getCouponEntityAndDefinitionByEntityId method");
        ResponseData<CouponDetailResponseVO> responseData = new ResponseData<>();

        if(null == couponEntityId){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_ENTITY_ID_NOT_NULL.getMessage());
            return responseData;
        }

        CouponEntityPO couponEntityPO = couponEntityPOMapper.selectByPrimaryKey(couponEntityId);

        if(StringUtils.isBlank(couponEntityPO.getBarcodeUrl())) {
            //查询券详情，更新条形码
            sendCouponService.updateBarcodeUrl(couponEntityPO);
            couponEntityPO = couponEntityPOMapper.selectByPrimaryKey(couponEntityId);
        }

        if(null == couponEntityPO){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }

        CouponDefinitionPO definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(couponEntityPO.getCouponDefinitionId()));

//        //查询会员信息
//        WxChannelInfoVo channelInfoVo = new WxChannelInfoVo();
//        channelInfoVo.setMemberCode(couponEntityPO.getMemberCode());
//        ResponseData<WxChannelInfoVo> channelResult = wxChannelInfoApiService.getWxChannelInfo(channelInfoVo);
        
        
        //查询会员信息 新接口
        WxChannelInfoVo channelVO = new WxChannelInfoVo();
        channelVO.setMemberCode(couponEntityPO.getMemberCode());
        channelVO.setBrandId(couponEntityPO.getSysBrandId());
        channelVO.setMiniProgram(1);
        ResponseData<WxChannelAndMemberVo> channelResult = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVO);

        if(SysResponseEnum.SUCCESS.getCode() != channelResult.getCode()){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(channelResult.getMessage());
            return responseData;
        }

        //将查询结果放入实体类
        CouponDetailResponseVO responseVO = new CouponDetailResponseVO();

        responseVO.setWxChannelInfoVo(channelResult.getData().getWxChannelInfoVo());
        responseVO.setCouponDefinitionPO(definitionPO);
        responseVO.setCouponEntityPO(couponEntityPO);

        //查询券状态变更流水
        CouponStatusLogPOExample statusLogPOExample = new CouponStatusLogPOExample();
        statusLogPOExample.createCriteria().andCouponEntityIdEqualTo(couponEntityId).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
        List<CouponStatusLogPO> logPOList = couponStatusLogPOMapper.selectByExample(statusLogPOExample);
        responseVO.setCouponStatusLogList(logPOList);

       responseData.setData(responseVO);
        return responseData;
    }


    /**
     * 查询券详情（根据实例id）
     * @param couponEntityId
     * @return
     */
    @Override
    public ResponseData<CouponDetailResponseVO> getAllDetailRpc(Long couponEntityId) {

        logger.info("enter CouponEntityServiceImpl getAllDetailRpc method");
        ResponseData<CouponDetailResponseVO> responseData = new ResponseData<>();

        if(null == couponEntityId){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_ENTITY_ID_NOT_NULL.getMessage());
            return responseData;
        }

        CouponEntityPO couponEntityPO = couponEntityPOMapper.selectByPrimaryKey(couponEntityId);

        if(null == couponEntityPO){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }

        CouponDefinitionPO definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(couponEntityPO.getCouponDefinitionId()));


        //将查询结果放入实体类
        CouponDetailResponseVO responseVO = new CouponDetailResponseVO();

        responseVO.setCouponDefinitionPO(definitionPO);
        responseVO.setCouponEntityPO(couponEntityPO);

        responseData.setData(responseVO);
        return responseData;


    }



    /**
     * 查询会员是否有某个券
     * @param date
     * @param memberCode
     * @param sendBusinessId
     * @return
     */
    @Override
    public ResponseData<List<CouponEntityPO>> finCouponHave(String memberCode, Long sendBusinessId,String date) {
        logger.info("enter CouponEntityServiceImpl finCouponHave method !");
        ResponseData<List<CouponEntityPO>> responseData = new ResponseData<>();

        if(null == memberCode){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_MEMBER_CODE_NOT_NULL.getMessage());
            return responseData;
        }
        if(null == sendBusinessId){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setCode(SysResponseEnum.COUPON_SEND_BUSINESS_ID_NOT_NULL.getCode());
            return responseData;
        }
        if(null == date){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.DATE_NOT_NULL.getMessage());
            return responseData;
        }

        List<CouponEntityPO> entityPOList = couponEntityPOMapper.findCouponHave(memberCode,sendBusinessId,date);

        responseData.setData(entityPOList);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }


    /**
     * 单张发券收到线下处理结果(补发可能存在-批量发券单张补发)
     * @param couponCode
     * @param couponStatus
     * @return
     */
    @Transactional
    @Override
    public ResponseData<Integer> updateCouponStatus(String couponCode, Byte couponStatus,Integer ifSendAgain) {
        ResponseData<Integer> responseData = new ResponseData<>();


        //兑换券全部成功
        CouponEntityPOExample entityPOExampleRequest = new CouponEntityPOExample();
        entityPOExampleRequest.createCriteria().andCouponCodeEqualTo(couponCode).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
        CouponEntityPO entityPOResult = couponEntityPOMapper.selectByExample(entityPOExampleRequest).get(0);
        CouponDefinitionPOWithBLOBs definitionPOResult = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(entityPOResult.getCouponDefinitionId()));
        if(definitionPOResult.getPreferentialType().equals(SystemConstants.PREFERENTIAL_TYPE_EXCHANGE)){
            couponStatus = SystemConstants.COUPON_ERP_SUCCESS;
        }



        if(StringUtils.isBlank(couponCode)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_CODE_NOT_NULL.getMessage());
            return responseData;
        }

        if(null == couponStatus){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_STATUS_NOT_NULL.getMessage());
            return responseData;
        }

        if(null == ifSendAgain){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.IF_SEND_AGAIN_NOT_NULL.getMessage());
            return responseData;
        }

        if(couponStatus.equals(SystemConstants.COUPON_ERP_FAIL)){
            //发券失败
            couponStatus = SystemConstants.COUPON_STATUS_SYNC_FAIL;
        }

        if(couponStatus.equals(SystemConstants.COUPON_ERP_SUCCESS)){
            //发券成功
            couponStatus = SystemConstants.COUPON_STATUS_UNUSED;
        }

        //更新券状态-券实例表
        CouponEntityPO entityPO = new CouponEntityPO();
        entityPO.setCouponStatus(couponStatus);
        CouponEntityPOExample entityPOExample = new CouponEntityPOExample();
        entityPOExample.createCriteria().andCouponCodeEqualTo(couponCode).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
        couponEntityPOMapper.updateByExampleSelective(entityPO,entityPOExample);

        if(SystemConstants.COUPON_SEND_AGAIN_YES.equals(ifSendAgain)){
            //补发

            CouponSendFailLogPOExample failLogPOExample = new CouponSendFailLogPOExample();
            failLogPOExample.createCriteria().andCouponCodeEqualTo(couponCode).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
            CouponSendFailLogPO failLogPO = couponSendFailLogPOMapper.selectByExample(failLogPOExample).get(0);

            //如果是补发，且成功，更新失败表状态为已补发
            if(SystemConstants.COUPON_STATUS_UNUSED.equals(couponStatus)){

                couponSendFailLogService.updateSendStatus(SystemConstants.COUPON_SEND_YES,couponCode);

            }
            //如果失败，更新失败表状态为待补发
            if(SystemConstants.COUPON_STATUS_SYNC_FAIL.equals(couponStatus)){

                couponSendFailLogService.updateSendStatus(SystemConstants.COUPON_SEND_NO,couponCode);
            }


            if(StringUtils.isNotBlank(failLogPO.getBatchSendCode())){
                //批次code不为空 - 批量发券单张补发

                //查找批次信息
                CouponBatchSendRecordPO batchSendRecordResult = couponBatchSendRecordService.findBatchSendRecord(failLogPO.getBatchSendCode());

                //发送成功
                if(couponStatus.equals(SystemConstants.COUPON_STATUS_UNUSED)){

                    //更新批次失败数量
                    batchSendRecordResult.setFailNum(batchSendRecordResult.getFailNum()-1);
                    couponBatchSendRecordPOMapper.updateByPrimaryKeySelective(batchSendRecordResult);


                    //如果业务类型是手动发券
                    if (SendTypeEnum.SEND_COUPON_BATCH.getCode().equals(batchSendRecordResult.getBizType())) {

                        //更新手动发券数量和状态
                        String manualId = batchSendRecordResult.getBizCode();
                        CouponManualPO manualPO = couponManualPOMapper.selectByPrimaryKey(Long.parseLong(manualId));

                        //成功数量 = 原本成功数量+本次成功数量
                        int successCount = manualPO.getSuccessCount()+1;
                        //失败数量 = 原有失败数量-本次成功数量
                        int failCount = manualPO.getFailCount()-1;

                        manualPO.setSuccessCount(successCount);
                        manualPO.setFailCount(failCount);
                        manualPO.setSyncFailCount(failCount);
                        //更新手动发券数量
                        couponManualPOMapper.updateByPrimaryKeySelective(manualPO);


                        //更新手动发券表状态
                        if(manualPO.getMemberCount().equals(manualPO.getSuccessCount())){
                            //如果发送数量和成功数量相等，则为发送完成

                            updateCouponManualTaskStatusById(Long.parseLong(manualId),CouponManualTaskStatusEnum.TASK_STATUS_SEND_SUCCESS.getCode().byteValue());
                        }


                        if (manualPO.getFailCount()>0) {
                            //有失败-则手动发券表状态为部分失败
                            updateCouponManualTaskStatusById(Long.parseLong(manualId),CouponManualTaskStatusEnum.TASK_STATUS_PART_FAIL.getCode().byteValue());

                        }


                    }

                }

            }



        }else if(SystemConstants.COUPON_SEND_AGAIN_NO.equals(ifSendAgain)){
            //非补发

            //如果是初次发，且失败，向失败表中插入一条记录
            if(SystemConstants.COUPON_STATUS_SYNC_FAIL.equals(couponStatus)){

                CouponEntityPOExample entityExample = new CouponEntityPOExample();
                entityExample.createCriteria().andCouponCodeEqualTo(couponCode).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
                List<CouponEntityPO> entityResult = couponEntityPOMapper.selectByExample(entityExample);
                CouponEntityPO couponEntityPO = entityResult.get(0);

                CouponDefinitionPO definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(couponEntityPO.getCouponDefinitionId()));

                couponSendFailLogService.saveCouponSendFailLog(definitionPO,couponEntityPO);

            }
        }

        
        //发送成功的券，发送微信和短信消息
        if(SystemConstants.COUPON_STATUS_UNUSED.equals(couponStatus)){

            sendCouponService.sendCouponOnline(definitionPOResult,entityPOResult);

        }


        return responseData;
    }


    /**
     * 批量发券收到线下处理结果(补发可能存在单张-批量补发的情况)
     * @param param
     * @return
     */
    @Override
    public ResponseData<Integer> updateCouponStatusBatch(CouponStatusUpdateBatchRequestVO param) {
        logger.info("enter CouponEntityServiceImpl updateCouponStatusBatch method ! param:{}",JSONObject.toJSONString(param));
        ResponseData<Integer> responseData = new ResponseData<>();

        if(null == param){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
            return responseData;
        }


        //兑换券全部成功
        if(CollectionUtils.isNotEmpty(param.getCouponFailList())) {
            String couponCode = param.getCouponFailList().get(0);
            CouponEntityPOExample entityPOExample = new CouponEntityPOExample();
            entityPOExample.createCriteria().andCouponCodeEqualTo(couponCode).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
            CouponEntityPO entityPO = couponEntityPOMapper.selectByExample(entityPOExample).get(0);
            CouponDefinitionPO definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(entityPO.getCouponDefinitionId()));
            if (definitionPO.getPreferentialType().equals(SystemConstants.PREFERENTIAL_TYPE_EXCHANGE)) {
                param.setCouponSuccessList(param.getCouponFailList());
                param.setCouponFailList(new ArrayList<>());
            }
        }

        //更新券实例表-成功信息
        if (CollectionUtils.isNotEmpty(param.getCouponSuccessList())) {
            couponEntityPOMapper.updateCouponStatusBatch(param.getCouponSuccessList(), SystemConstants.COUPON_STATUS_UNUSED);
        }
        //更新券实例表-失败信息
        if (CollectionUtils.isNotEmpty(param.getCouponFailList())) {
            couponEntityPOMapper.updateCouponStatusBatch(param.getCouponFailList(), SystemConstants.COUPON_STATUS_SYNC_FAIL);
        }

        if(StringUtils.isNotBlank(param.getBatchSendCode())) {
            //如果批次code不为空,则为批量发券

            //根据批次code查询批次信息
            CouponBatchSendRecordPO batchPOResult = couponBatchSendRecordService.findBatchSendRecord(param.getBatchSendCode());

            if (param.getIfSendAgain().equals(SystemConstants.COUPON_SEND_AGAIN_YES)) {
                //补发

                //补发成功，失败日志表更新为已补发
                if (CollectionUtils.isNotEmpty(param.getCouponSuccessList())) {
                    couponSendFailLogPOMapper.updateSendStatusByCouponCodeList(param.getCouponSuccessList(), SystemConstants.COUPON_SEND_YES);
                }

                //补发失败，失败日志表更新为待补发
                if (CollectionUtils.isNotEmpty(param.getCouponFailList())) {
                    couponSendFailLogPOMapper.updateSendStatusByCouponCodeList(param.getCouponFailList(), SystemConstants.COUPON_SEND_NO);
                }

                //更新批次失败数量
                CouponBatchSendRecordPO recordPORequest = new CouponBatchSendRecordPO();
                int batchFailNum = batchPOResult.getFailNum() == null?0:batchPOResult.getFailNum();
                recordPORequest.setFailNum(batchFailNum - param.getCouponSuccessList().size());
                recordPORequest.setCouponBatchSendRecordId(batchPOResult.getCouponBatchSendRecordId());
                couponBatchSendRecordPOMapper.updateByPrimaryKeySelective(recordPORequest);

                //如果业务类型是手动发券
                if (SendTypeEnum.SEND_COUPON_BATCH.getCode().equals(batchPOResult.getBizType())) {

                    //更新手动发券数量和状态
                    String manualId = batchPOResult.getBizCode();
                    updateManualCountAndStatusSendAgain(Long.parseLong(manualId),param);


                }


            } else if (param.getIfSendAgain().equals(SystemConstants.COUPON_SEND_AGAIN_NO)) {
                //初次发

                //更新批次失败数量
                couponBatchSendRecordPOMapper.updateFailNum(param.getCouponFailList().size(),batchPOResult.getCouponBatchSendRecordId());

                //插入失败表
                saveCouponSendFail(batchPOResult,param);

                //如果业务类型是手动发券
                if (SendTypeEnum.SEND_COUPON_BATCH.getCode().equals(batchPOResult.getBizType())) {

                    String manualId = batchPOResult.getBizCode();

                    CouponEntityServiceImpl couponEntityServiceImpl = CouponSpringContextUtil.getBean(this.getClass());
                    couponEntityServiceImpl.updateManualCountAndStatus(Long.parseLong(manualId),param);

                }

            } else {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.COUPON_SEND_AGAIN_EMPTY.getMessage());
                return responseData;
            }

        }else{

            //如果批次code为空，则为单张券的批量补发

            if (param.getIfSendAgain().equals(SystemConstants.COUPON_SEND_AGAIN_YES)) {
                //更新失败表状态

                //补发成功，失败日志表更新为已补发
                if (CollectionUtils.isNotEmpty(param.getCouponSuccessList())) {
                    couponSendFailLogPOMapper.updateSendStatusByCouponCodeList(param.getCouponSuccessList(), SystemConstants.COUPON_SEND_YES);
                }

                //补发失败，失败日志表更新为待补发
                if (CollectionUtils.isNotEmpty(param.getCouponFailList())) {
                    couponSendFailLogPOMapper.updateSendStatusByCouponCodeList(param.getCouponFailList(), SystemConstants.COUPON_SEND_NO);
                }

            }

        }


        //发送成功的券，发送微信和短信消息
        if(CollectionUtils.isNotEmpty(param.getCouponSuccessList())){

            //查找券实例list
            List<CouponEntityPO> entityPOList = couponEntityPOMapper.findByCouponCodeList(param.getCouponSuccessList());

            //根据品牌id分组
            Map<String, List<CouponEntityPO>> entityMap = new HashMap<>();

            for (CouponEntityPO po : entityPOList) {

                if (entityMap.containsKey(po.getCouponDefinitionId())) {
                    entityMap.get(po.getCouponDefinitionId()).add(po);
                } else {
                    List<CouponEntityPO> list = new ArrayList<>();
                    list.add(po);
                    entityMap.put(po.getCouponDefinitionId(), list);
                }

            }

            //遍历品牌id，根据发券批次号分组
            for (Map.Entry<String, List<CouponEntityPO>> entityEntry : entityMap.entrySet()) {
                CouponDefinitionPO definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(entityEntry.getKey()));
                sendCouponService.sendCouponBatchOnline(definitionPO,entityMap.get(entityEntry.getKey()));
            }

        }


        return responseData;
    }


    /**
     * 更新手动发券表数量和状态(补发券)
     * @param manualId
     * @param param
     */
    public void updateManualCountAndStatusSendAgain(Long manualId,CouponStatusUpdateBatchRequestVO param){

        logger.info("enter updateManualCountAndStatusSendAgain param:{}",JSONObject.toJSONString(param));

        CouponManualPO manualPO = couponManualPOMapper.selectByPrimaryKey(manualId);

        //成功数量 = 原本成功数量+本次成功数量
        int successCount = manualPO.getSuccessCount()+param.getCouponSuccessList().size();
        //失败数量 = 原有失败数量-本次成功数量
        int failCount = manualPO.getFailCount()-param.getCouponSuccessList().size();

        manualPO.setSuccessCount(successCount);
        manualPO.setFailCount(failCount);
        manualPO.setSyncFailCount(failCount);
        //更新手动发券数量
        couponManualPOMapper.updateByPrimaryKeySelective(manualPO);


        //更新手动发券表状态
        if(manualPO.getMemberCount().equals(manualPO.getSuccessCount())){
            //如果发送数量和成功数量相等，则为发送完成

            updateCouponManualTaskStatusById(manualId,CouponManualTaskStatusEnum.TASK_STATUS_SEND_SUCCESS.getCode().byteValue());
        }


        if (manualPO.getFailCount()>0) {
            //有失败-则手动发券表状态为部分失败
            updateCouponManualTaskStatusById(manualId,CouponManualTaskStatusEnum.TASK_STATUS_PART_FAIL.getCode().byteValue());

        }

    }



    /**
     * 批量发券收到线下处理结果存入失败信息
     * @param batchPOResult
     * @param param
     */
    public void saveCouponSendFail(CouponBatchSendRecordPO batchPOResult,CouponStatusUpdateBatchRequestVO param){

        if (CollectionUtils.isNotEmpty(param.getCouponFailList())) {
            List<CouponSendFailLogPO> failPOList = couponSendFailLogPOMapper.selectByCouponCodeList(param.getCouponFailList());

            for (int i = 0; i < failPOList.size(); i++) {
                failPOList.get(i).setBatchSendCode(batchPOResult.getBatchSendCode());
                failPOList.get(i).setSendStatus(SystemConstants.COUPON_SEND_NO);
                failPOList.get(i).setValid(SystemConstants.TABLE_VALID_EFFECTIVE);
                failPOList.get(i).setCreateDate(TimeUtils.getNowTime());
                failPOList.get(i).setBizCode(batchPOResult.getBizCode());
                failPOList.get(i).setBizType(batchPOResult.getBizType());
                failPOList.get(i).setFailReason(SystemConstants.SEND_COUPON_FAIL_REASON_ERP);
                failPOList.get(i).setFailTimes(0);
            }

            //非补发，批量插入
            couponSendFailLogPOMapper.insertBatch(failPOList);
        }

    }

    /**
     * 更新手动发券表数量和状态(首次发券)
     * @param manualId
     * @param param
     */
    @Transactional
    public void updateManualCountAndStatus(Long manualId,CouponStatusUpdateBatchRequestVO param){

        int successCount = param.getCouponSuccessList().size();
        int failCount = param.getCouponFailList().size();
        int syncFailCount = param.getCouponFailList().size();

        //更新手动发券数量
        couponManualPOMapper.updateCouponManualCount(manualId,successCount,failCount,syncFailCount);

        CouponManualPO manualPO = couponManualPOMapper.selectByPrimaryKey(manualId);

        logger.info("enter jjjjjjjjj updateManualCountAndStatus manualPO:{}",JSONObject.toJSONString(manualPO));

        logger.info("enter updateManualCountAndStatus MemberCount:{},SuccessCount:{},FailCount:{}",manualPO.getMemberCount(),
                                                            manualPO.getSuccessCount(),manualPO.getFailCount());

        //更新手动发券表状态
        if((manualPO.getMemberCount()+"").equals(manualPO.getSuccessCount()+"")){
            //如果发送数量和成功数量相等，则为发送完成
            logger.info("进来了----------");
            updateCouponManualTaskStatusById(manualId,CouponManualTaskStatusEnum.TASK_STATUS_SEND_SUCCESS.getCode().byteValue());
        }


        if (manualPO.getFailCount()>0) {
            //有失败-则手动发券表状态为部分失败
            updateCouponManualTaskStatusById(manualId,CouponManualTaskStatusEnum.TASK_STATUS_PART_FAIL.getCode().byteValue());

        }

    }


    /**
     * 更新手动发券状态
     * @param manualId
     * @param couponStatus
     */
    public void updateCouponManualTaskStatusById(Long manualId,Byte couponStatus){

        logger.info("enter CouponEntityServiceImpl updateCouponManualTaskStatusById method ! manualId:{},couponStatus:{}",manualId,couponStatus);

        CouponManualPO manualPORequest = new CouponManualPO();
        manualPORequest.setCouponManualId(manualId);
        manualPORequest.setTaskStatus(couponStatus);
        couponManualPOMapper.updateByPrimaryKeySelective(manualPORequest);
    }

    /**
     * 券的发放记录详细查询
     * @return
     */
    @Override
    public ResponseData<CouponDetailResponseVO> getCouponEntityAndDefinitionById(Long couponEntityId, Long couponDefinitionId) {

        logger.info("enter CouponEntityServiceImpl getCouponEntityAndDefinitionById method");
        ResponseData<CouponDetailResponseVO> responseData = new ResponseData<>();

        //将查询结果放入实体类
        CouponDetailResponseVO responseVO = new CouponDetailResponseVO();

        if(null == couponDefinitionId){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_DEFINITION_ID_NOT_NULL.getMessage());
            return responseData;
        }

        CouponDefinitionPO definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(couponDefinitionId);
        responseVO.setCouponDefinitionPO(definitionPO);

        if(couponEntityId != null){

            CouponEntityPO couponEntityPO = couponEntityPOMapper.selectByPrimaryKey(couponEntityId);

            //查询会员信息
//            WxChannelInfoVo channelInfoVo = new WxChannelInfoVo();
//            channelInfoVo.setMemberCode(couponEntityPO.getMemberCode());
//            ResponseData<WxChannelInfoVo> channelResult = wxChannelInfoApiService.getWxChannelInfo(channelInfoVo);
            
            //查询会员信息 新接口
            WxChannelInfoVo channelVO = new WxChannelInfoVo();
            channelVO.setMemberCode(couponEntityPO.getMemberCode());
            channelVO.setBrandId(couponEntityPO.getSysBrandId());
            channelVO.setMiniProgram(1);
            ResponseData<WxChannelAndMemberVo> channelResult = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVO);

            if(SysResponseEnum.SUCCESS.getCode() != channelResult.getCode()){
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(channelResult.getMessage());
                return responseData;
            }

            //查询券状态变更流水
            CouponStatusLogPOExample statusLogPOExample = new CouponStatusLogPOExample();
            statusLogPOExample.createCriteria().andCouponEntityIdEqualTo(couponEntityId).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
            List<CouponStatusLogPO> logPOList = couponStatusLogPOMapper.selectByExample(statusLogPOExample);

            responseVO.setWxChannelInfoVo(channelResult.getData().getWxChannelInfoVo());
            responseVO.setCouponEntityPO(couponEntityPO);
            responseVO.setCouponStatusLogList(logPOList);

        }


        responseData.setData(responseVO);
        return responseData;
    }


    /**
     * 查询单张券定义信息
     * @param couponDefinitionId
     * @return
     */
    @Override
    public ResponseData<CouponDetailResponseVO> getCouponDefinition(Long couponDefinitionId) {
        ResponseData<CouponDetailResponseVO> responseData = new ResponseData();
        if(null == couponDefinitionId){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_DEFINITION_ID_NOT_NULL.getMessage());
            return responseData;
        }

        CouponDefinitionPO definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(couponDefinitionId);

        CouponDetailResponseVO vo = new CouponDetailResponseVO();
        vo.setCouponDefinitionPO(definitionPO);
        responseData.setData(vo);
        return responseData;
    }


    /**
     * 查询活动/任务发送的券的会员列表
     *
     * @param param
     * @return
     */
    @Override
    public ResponseData<PageInfo<CouponSendMemberListResponseVO>> findCouponSendMemberList(CouponSendMemberListRequestVO param) {

        ResponseData<PageInfo<CouponSendMemberListResponseVO>> responseData = new ResponseData();

        if(null == param){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
            return responseData;
        }

        if(null == param.getSendBusinessId()){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_BUSINESS_ID_NOT_NULL.getMessage());
            return responseData;
        }

        if(StringUtils.isBlank(param.getSendType())){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_TYPE_NOT_NULL.getMessage());
            return responseData;
        }

        if(null == param.getBrandId()){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYS_BRAND_ID_NOT_NULL.getMessage());
            return responseData;
        }

        List<Byte> couponStatusList = new ArrayList<>();
        couponStatusList.add(SystemConstants.COUPON_STATUS_UNUSED);
        couponStatusList.add(SystemConstants.COUPON_STATUS_OVERDUE);
        couponStatusList.add(SystemConstants.COUPON_STATUS_USED);

        CouponEntityPOExample entityPOExample = new CouponEntityPOExample();
        entityPOExample.createCriteria().andSendBusinessIdEqualTo(param.getSendBusinessId())
                .andSendTypeEqualTo(param.getSendType()).andSysBrandIdEqualTo(param.getBrandId())
                .andCouponStatusIn(couponStatusList);

        PageHelper.startPage(param.getPageNumber(),param.getPageSize());

        //查询券
        List<CouponEntityPO> entitylist = couponEntityPOMapper.selectByExample(entityPOExample);

        if(CollectionUtils.isEmpty(entitylist)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
            return responseData;
        }

        //取出memberCode集合
        List<String> memberCodeList = new ArrayList<>();

        for(CouponEntityPO entityPO : entitylist){
            memberCodeList.add(entityPO.getMemberCode());
        }

        //查询会员
        CouponMemberPo couponMemberPo = new CouponMemberPo();
        couponMemberPo.setMemberCodeList(memberCodeList);
        couponMemberPo.setName(param.getName());
        couponMemberPo.setCardNo(param.getCardNo());
        ResponseData<List<MemberInfoModel>> memberListResult = memberInfoApiService.getMemberInfoByCodeList(couponMemberPo);

        if(CollectionUtils.isEmpty(memberListResult.getData())){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MEMBER_IS_EMPTY.getMessage());
            return responseData;
        }

        List<MemberInfoModel> memberList = memberListResult.getData();

        //返回的数据集合
        List<CouponSendMemberListResponseVO> responseList = new ArrayList<>();

        //遍历拼接数据
        for(MemberInfoModel member : memberList){
            for(CouponEntityPO entityPO : entitylist){
                if(member.getMemberCode().equals(entityPO.getMemberCode())){
                    CouponSendMemberListResponseVO vo = new CouponSendMemberListResponseVO();
                    vo.setCardNo(member.getCardNo());
                    vo.setMemberName(member.getName());
                    vo.setLevelName(member.getLevelName());
                    vo.setSendDate(entityPO.getCreateDate());
                    responseList.add(vo);
                }
            }
        }

        PageInfo<CouponSendMemberListResponseVO> pageInfo = new PageInfo<>(responseList);

        responseData.setData(pageInfo);
        return responseData;
    }


}
