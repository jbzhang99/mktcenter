package com.bizvane;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.bizvane")
@EnableDiscoveryClient
@EnableSwagger2
@EnableScheduling
@EnableFeignClients(basePackages={"com.bizvane.centerstageservice.rpc","com.bizvane.members.facade.service.api",
"com.bizvane.connectorservice.interfaces.rpc", "com.bizvane.wechatfacade.interfaces","com.bizvane.appletservice.rpc",
		"com.bizvane.centercontrolservice.rpc","com.bizvane.fitmentservice.models.Rpc","com.bizvane.messagefacade.interfaces","com.bizvane.couponfacade.interfaces"})
@EnableElasticsearchRepositories(basePackages = "com.bizvane.couponservice.es.repository")
@MapperScan(basePackages={"com.bizvane.couponservice.mappers","com.bizvane.messageservice.mappers","com.bizvane.mktcenterservice.mappers"})
@EnableAutoConfiguration(exclude = {ElasticsearchAutoConfiguration.class, ElasticsearchDataAutoConfiguration.class})
//@ConditionalOnClass(JestClient.class)
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