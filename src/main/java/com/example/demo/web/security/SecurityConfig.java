package com.example.demo.web.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		User.UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
				.withUser(users.username("test_admin").password("test").roles("ADMIN"))
				.withUser(users.username("test_user").password("test").roles("USER"));

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/resources/**").permitAll()
				.antMatchers("/panel").hasAnyRole("USER","ADMIN")
				.antMatchers("/updateForm/**","/showForm","/api/deleteCourse/**").hasAnyRole("ADMIN")
				.antMatchers("/api/saveCourse").hasAnyRole("ADMIN", "USER")
				.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/auth_user").permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access_denied")
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").deleteCookies("JSESSIONID")
				.invalidateHttpSession(true);
	}

}
