package com.smartoscfintech.p2plending.lms.backend.loan.config;

import java.util.Collections;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableCaching
@EnableSwagger2
public class LoanConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.smartoscfintech.p2plending.lms.backend.loan.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("LMS#loan-service API",
				"SmartOSC Fintech JSC | P2P Lending | LMS | Loan Service.", "1.0.0-DEV",
				"https://developer.smartosc.com/policy",
				new Contact("LMS team", "https://developer.smartosc.com",
						"hoangnv01@gmail.com"),
				"©N.V Hoang", "https://developer.smartosc.com/license", Collections.emptyList());
	}

	/* enabling swagger-ui part for visual documentation */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
