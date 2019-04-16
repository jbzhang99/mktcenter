package com.bizvane.couponservice.service.impl;

import com.bizvane.messageservice.common.thread.ThreadExtend;
import com.bizvane.messageservice.common.thread.ThreadPool;
import com.bizvane.couponservice.service.OtherModulesService;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.service.api.MembersAdvancedSearchApiService;
import com.bizvane.members.facade.vo.MemberInfoVo;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunjie.tian on 2018/9/7.
 */
@Service
public class OtherModulesServiceImpl implements OtherModulesService{

    @Autowired
    private MembersAdvancedSearchApiService membersAdvancedSearchApiService;


    /**
     * 根据高级搜索条件查找会员
     *
     * @return
     */
    @Override
    public ResponseData<List<MemberInfoVo>> searchMembers(MembersInfoSearchVo memberVO)throws Exception{

        Runnable runnable = new ThreadExtend("otherModulesServiceImpl", "ss", memberVO);
        ThreadPool.run(runnable);

        return null;
    }

    public ResponseData<List<MemberInfoVo>> ss(Object memberVO){

        ResponseData<List<MemberInfoVo>> responseData = new ResponseData<>();

        //存放数据的集合
        List<MemberInfoVo> allList = new ArrayList<>();

        int count = 0;

        //线程池
        //ExecutorService executor = Executors.newFixedThreadPool(5);

        MembersInfoSearchVo memberVO1 = (MembersInfoSearchVo)memberVO;
        memberVO1.setPageNumber(1);
        memberVO1.setPageSize(10);
        //初次查询
        ResponseData<PageInfo<MemberInfoVo>> memberResult = membersAdvancedSearchApiService.search(memberVO1);

        allList.addAll(memberResult.getData().getList());

        //     CountDownLatch countDownLatch = new CountDownLatch(memberResult.getData().getPages()-100);
        //从第二页开始查询
        for(int i=2;i<=memberResult.getData().getPages();i++){

            memberVO1.setPageNumber(i);
            final MembersInfoSearchVo memberRequest = memberVO1;

            System.out.println(Thread.currentThread().getName());

            ResponseData<PageInfo<MemberInfoVo>> perMemberResult = membersAdvancedSearchApiService.search(memberRequest);
            allList.addAll(perMemberResult.getData().getList());
            /*executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());

                    ResponseData<PageInfo<MemberInfoVo>> perMemberResult = membersAdvancedSearchApiService.search(memberRequest);
                    allList.addAll(perMemberResult.getData().getList());
                   // countDownLatch.countDown();
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){}

                }
            });*/


        }

        //countDownLatch.await();

        System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");

        return responseData;

    }
}
