package com.bizvane.couponservice.common.system;

import com.bizvane.couponservice.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DictInit implements ApplicationRunner{

	@Autowired
	private DictService dictService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
//		dictService.init();
	}

}
