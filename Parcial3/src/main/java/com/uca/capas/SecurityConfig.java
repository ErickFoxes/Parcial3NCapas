package com.uca.capas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.uca.capas.services.UsuarioService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()          
          .antMatchers("/", "/login", "/logout", "/formLogin").permitAll()
          .anyRequest()          
          .authenticated()
          .and()
          .httpBasic();
       
        http.authorizeRequests().and().formLogin()//
        // Submit URL of login page.
        .loginProcessingUrl("/j_spring_security_check") // Submit URL
        .loginPage("/login")//
        .defaultSuccessUrl("/userAccountInfo")//
        .failureUrl("/login?error=true")//
        .usernameParameter("username")//
        .passwordParameter("pass")
        // Config for Logout Page
        .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
        
        
    }
    
}
