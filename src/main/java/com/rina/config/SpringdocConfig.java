package com.rina.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springdoc 的配置类
 * @author arvin
 * @date 2022/11/28
 */
@Configuration
public class SpringdocConfig {

	@Bean
	public OpenAPI backendApi() {
		final String securitySchema = "Authorization";
		return new OpenAPI()
				.info(apiInfo())
				.components(new Components().addSecuritySchemes(securitySchema, new SecurityScheme()
						.type(SecurityScheme.Type.APIKEY)
						.in(SecurityScheme.In.HEADER)
						.name(securitySchema)));
	}

	private Info apiInfo() {
		return new Info()
				.title("林莉奈RinaHayashi")
				.description("林莉奈歌单主要API")
				.version("1.0")
				.contact(new Contact()
						.name("arvin")
						.email("arvinjunior@163.com"));
	}

}
