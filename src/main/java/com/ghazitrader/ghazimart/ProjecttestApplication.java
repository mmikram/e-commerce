package com.ghazitrader.ghazimart;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.ghazitrader.ghazimart*"})
@EntityScan("com.ghazitrader.ghazimart*")
@EnableJpaRepositories("com.ghazitrader.ghazimart*")

public class ProjecttestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjecttestApplication.class, args);
	}

}
