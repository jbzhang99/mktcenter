package com.bizvane.mktcenterserviceimpl;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.bizvane.mktcenterserviceimpl.mappers.MktActivityCountPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskCountPOMapper;

@Component
public class Test implements ApplicationRunner {

  @Autowired
  private MktActivityCountPOMapper mktActivityCountPOMapper;
  
  @Autowired
  private MktTaskCountPOMapper mktTaskCountPOMapper;
  
  @Override
  public void run(ApplicationArguments args) throws Exception {
    // TODO Auto-generated method stub
    
    mktActivityCountPOMapper.updateSum(1L, 1, new BigDecimal("10"), 10);
    mktActivityCountPOMapper.updateSum(1L, 1, new BigDecimal("10"), 0);
    mktActivityCountPOMapper.updateSum(1L, 1, new BigDecimal("0"), 0);
    mktActivityCountPOMapper.updateSum(1L, 0, new BigDecimal("0"), 0);
    mktActivityCountPOMapper.updateSum(1L, 0, new BigDecimal("10"), 10);
    mktActivityCountPOMapper.updateSum(1L, 0, new BigDecimal("0"), 10);
    mktActivityCountPOMapper.updateSum(1L, 0, new BigDecimal("0"), 0);

    
    mktTaskCountPOMapper.updateSum(1L, 1, new BigDecimal("10"), 10, 10, 10);
    mktTaskCountPOMapper.updateSum(1L, 1, new BigDecimal("10"), 10, 10, 0);
    mktTaskCountPOMapper.updateSum(1L, 1, new BigDecimal("10"), 10,  0, 0);
    mktTaskCountPOMapper.updateSum(1L, 1, new BigDecimal("10"),  0,  0, 0);
    mktTaskCountPOMapper.updateSum(1L, 1, new BigDecimal("0"),   0,  0, 0);
    mktTaskCountPOMapper.updateSum(1L, 0, new BigDecimal("0"),   0,  0, 0);
    mktTaskCountPOMapper.updateSum(1L, 0, new BigDecimal("10"), 10, 10, 10);
    mktTaskCountPOMapper.updateSum(1L, 0, new BigDecimal("0"),  10, 10, 10);
    mktTaskCountPOMapper.updateSum(1L, 0, new BigDecimal("0"),   0, 10, 10);
    mktTaskCountPOMapper.updateSum(1L, 0, new BigDecimal("0"),   0,  0, 10);
  }

}
