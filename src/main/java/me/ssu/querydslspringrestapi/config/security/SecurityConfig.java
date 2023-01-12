package me.ssu.querydslspringrestapi.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/h2-console/**", "/api-docs/**", "/favicon.ico");
		web.ignoring().antMatchers(HttpMethod.OPTIONS);
		web.ignoring().antMatchers("/v3/api-docs");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable()
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
//				.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
//				.accessDeniedHandler(jwtAccessDeniedHandler)
//				.and()
				.headers().frameOptions().disable()
				.and()
				.authorizeRequests()
				.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
				.antMatchers("/v1/member/sign-up/**").permitAll()
				.antMatchers("/api-docs/**", "/v3/api-docs/**").permitAll()
				.anyRequest().authenticated();
	}
}