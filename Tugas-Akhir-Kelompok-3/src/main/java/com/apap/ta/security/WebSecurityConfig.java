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
	
		http
			.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/lab/kebutuhan/tambah").hasAnyAuthority("staf_lab","admin_lab","ADMIN")
			.antMatchers("/lab/kebutuhan").hasAnyAuthority("staf_lab","admin_lab","admin_farmasi","ADMIN")
			.antMatchers("/lab/kebutuhan/ubah/**").hasAnyAuthority("admin_lab","ADMIN")
			.antMatchers("/lab/pemeriksaanLab/permintaan").hasAnyAuthority("staf_lab","admin_lab","admin_rawat","ADMIN")
			.antMatchers("/lab/pemeriksaanLab/**").hasAnyAuthority("staf_lab","admin_lab","ADMIN")
			.antMatchers("/lab/jadwal-jaga/tambah").hasAnyAuthority("admin_lab","ADMIN")
			.antMatchers("/lab/jadwal-jaga/ubah/**").hasAnyAuthority("admin_lab","ADMIN")
			.antMatchers("/lab/jadwal-jaga").hasAnyAuthority("admin_lab","ADMIN")
			.antMatchers("/lab/jadwal").hasAnyAuthority("admin_lab","ADMIN")
			.antMatchers("/lab/supplies").hasAnyAuthority("staf_lab","admin_lab","ADMIN")
			.antMatchers("/lab/stok/tambah").hasAnyAuthority("admin_lab","ADMIN")
			.antMatchers("/lab/stok").hasAnyAuthority("staf_lab","admin_lab","ADMIN")
			.antMatchers("/lab/stok/ubah/**").hasAnyAuthority("admin_lab","ADMIN")
			.antMatchers("/lab/user/tambah-user").hasAnyAuthority("admin_lab", "admin_rawat", "admin_farmasi","ADMIN")
			.antMatchers("/lab/user/update-password").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
			.permitAll();
	
	}
	
//	@Autowired
//	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//			.passwordEncoder(encoder())
//			.withUser("admin").password(encoder().encode("kelompok3"))
//			.roles("ADMIN");
//	}
	
	
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
