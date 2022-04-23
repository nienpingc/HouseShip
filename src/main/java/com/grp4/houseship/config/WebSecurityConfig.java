package com.grp4.houseship.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.grp4.houseship.member.model.UserDetailsServiceImpl;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//private UserDetailsServiceImpl userDetailsServiceImpl;
	
	 @Bean
	 public UserDetailsService userDetailsService() {
	        return new UserDetailsServiceImpl();
	 }
	 
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	 }
	 
	 @Bean
	 public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	 }
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
//		auth
//		.userDetailsService(userDetailsServiceImpl)
//		.passwordEncoder(new BCryptPasswordEncoder());
	
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}
	//設定
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/member/**").hasAuthority("administrator")
		.antMatchers(HttpMethod.GET).permitAll()
		.antMatchers(HttpMethod.POST,"/member/**").authenticated()
		.antMatchers(HttpMethod.POST).permitAll()
		.anyRequest().authenticated()
		.and()
		.rememberMe().tokenValiditySeconds(86400).key("rememberMe-key")
		.and()
		.csrf().disable()
		//signIn.jsp的action必須是"/HouseShip/signinPage",spring security好像才能順利驗證
		.formLogin().loginPage("/signinPage")
		.defaultSuccessUrl("/welcomePage");
		
	}
	
	
}
