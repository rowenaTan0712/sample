package com.vuejs.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@EnableJpaRepositories(basePackages = {"mz.server.spring.repository"})
@EntityScan(basePackages = "mz.server.hibernate.model")
@EnableTransactionManagement
@EnableScheduling*/
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
