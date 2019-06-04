package com.apap.TA.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService1;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                //.antMatchers("/", "/login", "/kebutuhan").hasAnyAuthority("Admin", "Staf")

                //.antMatchers("/lab/kebutuhan/ubah/**", "/lab/jadwal-jaga/tambah","/lab/jadwal-jaga/ubah/**", "/lab/stok/tambah", "/lab/stok/ubah/**")
               // .hasAnyAuthority("Admin","GOD")
               // .antMatchers("/lab/kebutuhan", "/lab/pemeriksaan/permintaan", "/lab/pemeriksaan/**", "/lab/jadwal-jaga/all", "/lab/jadwal-jaga/**", "/lab/stok")
                //.hasAnyAuthority("Admin", "Staf","GOD")
                //.antMatchers("/lab/kebutuhan/tambah")
               // .hasAnyAuthority("Staf","GOD")

              //  .antMatchers("/kebutuhan/ubah").hasAnyAuthority("Admin")
                //.antMatchers("/lab/kebutuhan/ubah/**", "/lab/jadwal-jaga/tambah","/lab/jadwal-jaga/ubah/**", "/lab/stok/tambah", "/lab/stok/ubah/**")
                //.hasAnyAuthority("Admin", "GOD")
                //.antMatchers("/lab/kebutuhan", "/lab/pemeriksaan/permintaan", "/lab/pemeriksaan/**", "/lab/jadwal-jaga/all", "/lab/jadwal-jaga/**", "/lab/stok")
                //.hasAnyAuthority("Admin", "Staf", "GOD")
                //.antMatchers("/lab/kebutuhan/tambah")
                //.hasAnyAuthority("Staf", "GOD")
                //.antMatchers("/kebutuhan/ubah").hasAnyAuthority("Admin")
                
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
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.passwordEncoder(encoder())
	 		.withUser("admin").password(encoder().encode(""))
	 		.roles("ADMIN");
	 }

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService1).passwordEncoder(encoder());
    }
}

