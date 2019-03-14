package com.bizvane.couponservice.common.es;

import de.otto.flummi.Flummi;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlummiConfiguration {

	@Value("${spring.data.jest.uri}")
	private String elasticConfigUrl;
	@Value("${spring.data.jest.username}")
	private String username;
	@Value("${spring.data.jest.password}")
	private String password;

	@Bean
	public AsyncHttpClient asyncHttpClient() {
		return new DefaultAsyncHttpClient();
	}

	@Bean
	public Flummi flummi() {
		return new Flummi(asyncHttpClient(), elasticConfigUrl, username, password);
	}
}