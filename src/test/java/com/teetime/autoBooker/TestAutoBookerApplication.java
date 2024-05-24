package com.teetime.autoBooker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestAutoBookerApplication {

	public static void main(String[] args) {
		SpringApplication.from(AutoBookerApplication::main).with(TestAutoBookerApplication.class).run(args);
	}

}
