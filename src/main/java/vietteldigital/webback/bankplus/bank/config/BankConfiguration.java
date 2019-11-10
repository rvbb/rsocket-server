package vietteldigital.webback.bankplus.bank.config;

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
public class BankConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("vietteldigital.webback.bankplus.bank.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Webback/Bankplus#bank API",
				"Produce all APIs relate bank business logic of BankPlus project.", "1.0.0-DEV",
				"https://vietteldigital.vn/termofservice_license",
				new Contact("Viettel Digital Corporations - direct Viettel Group", "https://vietteldigital.vn",
						"api_cs@viettel.com.vn"),
				"© Viettel Digital Corps", "https://vietteldigital.vn/termofservice_license", Collections.emptyList());
	}

	/* enabling swagger-ui part for visual documentation */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
