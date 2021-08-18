package com.encora.dreambox.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.encora.dreambox.client.DataServicesClient;
import com.encora.dreambox.filter.TokenRequestFilter;

@Configuration
public class Config {

	@Value("${token}")
	private String token;

	@Bean
	public DataServicesClient getDataServiceClient() {
		return new DataServicesClient();
	}

	@Bean
	public FilterRegistrationBean<TokenRequestFilter> tokenFilter() {
		FilterRegistrationBean<TokenRequestFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new TokenRequestFilter(token));
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}
}
