package com.avesena.webservice.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

//import com.avesena.webservice.service.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	UserDetailsService myUserDetailsService;
	
	@Autowired
	private DataSource dataSource;
	
	@SuppressWarnings("deprecation")
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
		//return NoOpPasswordEncoder.getInstance();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .authorizeRequests()
        		.antMatchers("/","/logout").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/userInfo").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/admin").hasAuthority("ADMIN")
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedPage("/accessdenied")
                .and().authorizeRequests().and()
                .formLogin().permitAll().loginPage("/login")
                //.loginProcessingUrl("/dashboard")
                .defaultSuccessUrl("/userInfo")
                .failureForwardUrl("/error")
                .and().logout().logoutUrl("/logout")
                .invalidateHttpSession(true).logoutSuccessUrl("/index")
                .and()
                .exceptionHandling().accessDeniedPage("/accessdenied")
                .and()
        		.rememberMe().tokenRepository(this.persistentTokenRepository())
        		.tokenValiditySeconds(7*24*60*60); //7 days
    }
    
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
    	JdbcTokenRepositoryImpl dbToken = new JdbcTokenRepositoryImpl();
    	dbToken.setDataSource(dataSource);
    	return dbToken;
    }
}
