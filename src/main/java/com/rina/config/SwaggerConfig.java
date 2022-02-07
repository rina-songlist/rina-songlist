package com.rina.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerUI配置类
 * @author arvin
 * @date 2022/02/07
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * 创建api应用
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.rina.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * 创建该api的基本信息（此信息将会展现在文档中）
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("林莉奈RinaHayashi")
				.description("林莉奈歌单主要API")
				.contact(new Contact("arvin","","arvinjunior@163.com"))
				.version("1.0")
				.build();
	}

}
