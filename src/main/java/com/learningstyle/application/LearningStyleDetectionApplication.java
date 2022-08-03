package com.learningstyle.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication(scanBasePackages={"com.learningstyle.application"})
//@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
//@EnableMongoRepositories(basePackageClasses = SignInRepository.class)
@SpringBootApplication
public class LearningStyleDetectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningStyleDetectionApplication.class, args);
	}

}
