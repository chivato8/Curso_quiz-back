package com.jsh.quizback.config;

import org.dozer.DozerBeanMapper;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class DozerConfig {

	@Bean
	public DozerBeanMapper dozer()
	{
		return new DozerBeanMapper();
	}
}
