package com.sprint2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.ant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2        // This annotation is used to enable the swagger2 for your spring boot application
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)//.groupName("public-api")
	              .groupName("")
	                .directModelSubstitute(LocalDateTime.class, String.class)
	               .directModelSubstitute(LocalDate.class, String.class)
	               .directModelSubstitute(LocalTime.class, String.class)
	               .directModelSubstitute(ZonedDateTime.class, String.class)
	               .apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
	               .paths(pathsToBeDocumented()).build();
	
	}
	
	@SuppressWarnings("unchecked")
	private Predicate<String> pathsToBeDocumented() {
		return or(ant("/fms/m2/**"),ant("/fms/m1/**"),ant("/fms/m4/**"),ant("/Contract/**"),ant("/Land/**"),ant("/fms/m6/**"),ant("/fms/m5/**"),ant("/fms/m3/**"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Forest API").description("Forest Management REST API").license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0").build();
		
	}
}
