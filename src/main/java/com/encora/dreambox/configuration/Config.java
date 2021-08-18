package com.encora.dreambox.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.encora.dreambox.client.DataServicesClient;

@Configuration
public class Config {

	@Bean
	public DataServicesClient getDataServiceClient() {
		return new DataServicesClient();
	}

}
