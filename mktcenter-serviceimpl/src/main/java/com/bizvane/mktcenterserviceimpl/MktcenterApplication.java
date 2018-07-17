package com.bizvane.mktcenterserviceimpl;

import com.bizvane.mktcenterserviceimpl.common.utils.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.bizvane")
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients
@MapperScan("com.bizvane.mktcenterserviceimpl.mappers")
public class MktcenterApplication {

	// @Value("${swagger.show}")
	// private boolean swaggerShow;

//	@LoadBalanced
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(MktcenterApplication.class, args);
	}
}