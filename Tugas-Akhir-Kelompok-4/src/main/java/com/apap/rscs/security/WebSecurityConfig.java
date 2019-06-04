package com.apap.rscs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/login/**").permitAll()
			.antMatchers("/lab/kebutuhan").hasAnyAuthority("SUPERUSER", "Staff Laboratorium", "Admin Laboratorium")
			.antMatchers("/lab/kebutuhan/tambah").hasAnyAuthority("Staff Laboratorium","SUPERUSER")
			.antMatchers("/lab/kebutuhan/perencanaan").hasAnyAuthority("Admin Farmasi","SUPERUSER")
			.antMatchers("/lab/kebutuhan/ubah/**").hasAnyAuthority("Admin Laboratorium","SUPERUSER")
			.antMatchers("/lab/pemeriksaan/permintaan").hasAnyAuthority("Staff Laboratorium","Admin Laboratorium", "Admin Rawat Jalan", "SUPERUSER")
			.antMatchers("/lab/pemeriksaan/**").hasAnyAuthority("Staff Laboratorium","Admin Laboratorium","SUPERUSER")
			.antMatchers("/lab/jadwal-jaga/tambah").hasAnyAuthority("Admin Laboratorium","SUPERUSER")
			.antMatchers("/lab/jadwal-jaga/ubah/**").hasAnyAuthority("Admin Laboratorium","SUPERUSER")
			.antMatchers("/lab/jadwal-jaga/**").hasAnyAuthority("Admin Laboratorium", "Staf Laboratorium", "SUPERUSER")
			.antMatchers("/lab/stok/tambah").hasAnyAuthority("Admin Laboratorium","SUPERUSER")
			.antMatchers("/lab/stok").hasAnyAuthority("Staff Laboratorium","Admin Laboratorium","SUPERUSER")
			.antMatchers("/lab/stok/ubah/**").hasAnyAuthority("Admin Laboratorium","SUPERUSER")
			.antMatchers("/lab/user/tambah-user").hasAnyAuthority("SUPERUSER")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
			.permitAll();
	}
	
	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.passwordEncoder(encoder())
			.withUser("abas").password(encoder().encode("admin"))
			.roles("SUPERUSER");
		auth.inMemoryAuthentication()
			.passwordEncoder(encoder())
			.withUser("admin_labor").password(encoder().encode("admin"))
			.roles("Admin Laboratorium");
		auth.inMemoryAuthentication()
			.passwordEncoder(encoder())
			.withUser("staf_labor").password(encoder().encode("admin"))
			.roles("Staf Laboratorium");
		auth.inMemoryAuthentication()
			.passwordEncoder(encoder())
			.withUser("admin_farmasi").password(encoder().encode("admin"))
			.roles("Admin Farmasi");
		auth.inMemoryAuthentication()
			.passwordEncoder(encoder())
			.withUser("admin_rawat").password(encoder().encode("admin"))
			.roles("Admin Rawat Jalan");
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}