package com.bizvane.mktcenterserviceimpl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.bizvane")
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients(basePackages={"com.bizvane.centerstageservice.rpc","com.bizvane.members.facade.service.api","com.bizvane.couponfacade.interfaces"})
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