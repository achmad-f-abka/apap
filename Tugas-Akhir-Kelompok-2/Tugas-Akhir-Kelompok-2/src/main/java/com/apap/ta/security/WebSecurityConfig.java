package com.apap.ta.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		//vvv buat testing postman vvv
		/*
		 http
		 .csrf().disable()
         .authorizeRequests()
         .antMatchers("/**").permitAll();
		*/
		
		
		http
			.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/lab/kebutuhan/tambah").hasAnyAuthority("staff_lab","ADMIN")
			.antMatchers("/lab/kebutuhan/ubah/**").hasAnyAuthority("admin_lab","ADMIN")
			.antMatchers("/lab/jadwal-jaga/tambah").hasAnyAuthority("admin_lab","ADMIN")
			.antMatchers("/lab/jadwal-jaga/ubah/**").hasAnyAuthority("admin_lab","ADMIN")
			.antMatchers("/lab/stok/tambah").hasAnyAuthority("admin_lab","ADMIN")
			.antMatchers("/lab/stok/ubah/**").hasAnyAuthority("admin_lab","ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
			.permitAll();
	
		
	}
	
	/*
	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.passwordEncoder(encoder())
			.withUser("admin").password(encoder().encode("1234"))
			.roles("ADMIN");
	}
	*/
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Autowired
	public void configAuthentication (AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}
	

}
