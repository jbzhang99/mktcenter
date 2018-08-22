package com.bizvane.mktcenterserviceimpl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.bizvane")
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients(basePackages={"com.bizvane.centerstageservice.rpc","com.bizvane.members.facade.service.api",
"com.bizvane.couponfacade.interfaces","com.bizvane.messagefacade.interfaces",
"com.bizvane.wechatfacade.interfaces","com.bizvane.fitmentservice.models.Rpc"})
@MapperScan("com.bizvane.mktcenterserviceimpl.mappers")
public class MktcenterApplication {

	// @Value("${swagger.show}")
	// private boolean swaggerShow;

	/**
	 * @LoadBalanced负载均衡的原理是需要请求的url为在注册中心进行注册过的某个服务的请求，e.x. postURL=http://HELLO-SERVICE/hello
	 * 如果请求的非注册的服务，将不能使用此负载注解，否则会报找不到服务
	 * @param restTemplateBuilder
	 * @return
	 */
//	@LoadBalanced
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(MktcenterApplication.class, args);
	}
}