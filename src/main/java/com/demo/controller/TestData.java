package com.demo.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangyb1
 * @date 2024/8/6
 */
//@Data
@Configuration(proxyBeanMethods = false)
@RefreshScope
@ConfigurationProperties(prefix = "k8s")
public class TestData {

	private String name = "default";


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
