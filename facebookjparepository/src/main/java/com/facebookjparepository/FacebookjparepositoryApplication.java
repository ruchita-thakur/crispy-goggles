package com.facebookjparepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FacebookjparepositoryApplication {
 
	//private static final Logger Logger=LogManager.getLogger(FacebookjparepositoryApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FacebookjparepositoryApplication.class, args);
		/*Logger.debug("Debugging log");
		Logger.info("Info log");
		Logger.warn("warning");
		Logger.error("Error");
		Logger.fatal("Fatal error");*/
		
	}
	
	@Bean
    public Docket productApi() {
       return new Docket(DocumentationType.SWAGGER_2).select()
          .apis(RequestHandlerSelectors.basePackage("com.facebookjparepository")).build();
    }

}
