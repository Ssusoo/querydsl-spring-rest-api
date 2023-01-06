package me.ssu.querydslspringrestapi.config.security;

import lombok.RequiredArgsConstructor;
import me.ssu.querydslspringrestapi.domains.member.application.SignUpMemberService;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final SignUpMemberService signUpMemberService;
	private final DataSource dataSource; // JPA를 사용하기 때문에 당연히 Datasource가 들어있음.

	// Spring Security(권한과 인증)-1
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 요청에 대한 권한(authorizeRequests)
		http.authorizeRequests()
				.mvcMatchers("/", "/login", "/sign-up").permitAll() // 전체 열람 권한(mvcMatchers)
				.mvcMatchers(HttpMethod.GET, "/profile/*").permitAll() // Get 요청 허용
				.anyRequest().authenticated(); // 다른 요청(anyRequest) & 인증을 필요로 함(authenticated)

		// 로그인 처리
		http.formLogin()
				.loginPage("/login").permitAll();

		// 로그아웃 처리
		http.logout()
				.logoutSuccessUrl("/");
	}
}