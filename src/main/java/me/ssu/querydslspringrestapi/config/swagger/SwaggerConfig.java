package me.ssu.querydslspringrestapi.config.swagger;

import io.micrometer.core.instrument.util.StringUtils;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.SpringDocUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
	@Value("${env.domain}")
	private String domain;

	@Bean
	public OpenAPI swaggerOpenAPI() {
		SpringDocUtils.getConfig().replaceWithClass(org.springframework.data.domain.Pageable.class,
				org.springdoc.core.converters.models.Pageable.class);

		Info info = new Info().title("SSU API")
				.description("Member API")
				.version("v1");

		SecurityScheme securityScheme = new SecurityScheme()
				.type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
				.in(SecurityScheme.In.HEADER).name("Authorization");
		SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");

		return new OpenAPI()
				.info(info)
				.servers(!StringUtils.isEmpty(domain) ? Collections.singletonList(new Server().url(domain)) : null)
				.components(new Components().addSecuritySchemes("bearerAuth",securityScheme))
				.security(Collections.singletonList(securityRequirement))
				.externalDocs(new ExternalDocumentation()
						.description("API 상세 명세서 (준비중)")
						.url("/api-docs/index.html"));
	}
}