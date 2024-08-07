package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.kubernetes.fabric8.config.Fabric8ConfigMapPropertySourceLocator;
import org.springframework.cloud.kubernetes.fabric8.config.reload.EventBasedConfigMapChangeDetector;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linyf
 * @date 2023/5/29 17:15
 */
//@Slf4j
@RestController
public class MyAppController {

	@Autowired
	private TestData testData;
	@Autowired
	private ApplicationContext applicationContext;

	private static Logger log = LoggerFactory.getLogger(MyAppController.class);

	@GetMapping("/third/case/testk8s")
	public String testk8s() {
		try {
			//null here...
			EventBasedConfigMapChangeDetector bean = applicationContext.getBean(EventBasedConfigMapChangeDetector.class);
		} catch (Exception ex) {
			log.info("get EventBasedConfigMapChangeDetector bean error");
		}
		try {
			Fabric8ConfigMapPropertySourceLocator bean = applicationContext.getBean(Fabric8ConfigMapPropertySourceLocator.class);
		} catch (Exception ex) {
			log.info("get Fabric8ConfigMapPropertySourceLocator bean error");
		}
		return testData.getName();
	}

	@Scheduled(fixedDelay = 5000)
	public void hello() {
		log.info("The message is: " + testData.getName());
	}
}
