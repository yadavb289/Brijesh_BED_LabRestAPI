package com.lab6.restapi.config;

import com.lab6.restapi.service.DomainUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DomainUserDetailsService domainUserDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2-console/**");

    }

    //User authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.domainUserDetailsService).passwordEncoder(passwordEncoder());
    }

    //User authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/h2-console/**", "/h2-console**", "/h2-console/login**")
                .permitAll().antMatchers("/student/showFormForAdd", "/student/403", "/student/delete")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/student/save**")
                .hasAnyRole("ADMIN", "USER")
                .antMatchers("/student/showFormForUpdate", "/student/save**")
                .hasAnyRole("ADMIN", "USER").anyRequest()
                .authenticated().and().formLogin().loginProcessingUrl("/login")
                .successForwardUrl("/student/list")
                .permitAll().and().logout().logoutSuccessUrl("/login")
                .permitAll().and().exceptionHandling()
                .accessDeniedPage("/student/403").and()
                .cors().disable()
                .csrf().disable()
                .headers().frameOptions().disable();

    }

}
