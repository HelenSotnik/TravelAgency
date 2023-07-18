package com.softserve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new WebAccessDeniedHandler();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new WebAuthenticationEntryPoint();
    }
    @Bean
    public WebAuthenticationProvider webAuthenticationProvider() {
        return new WebAuthenticationProvider();
    }
    @Bean
    public UsernamePasswordAuthenticationFilter authenticationFilter() {
        return new WebAuthenticationFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/login").permitAll()
                .antMatchers("/users/create").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID")
                .permitAll();

        http.addFilterAt(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint())
                .accessDeniedHandler(accessDeniedHandler());
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("manager@gmail.com").password("{noop}1111").roles("MANAGER");
//        auth.inMemoryAuthentication().withUser("user@gmail.com").password("{noop}2222").roles("USER");}


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select email, password, true from users where email=?;")
                .authoritiesByUsernameQuery("select u.email, r.name from users u inner join roles r on u.role_id = r.id where u.email=?;");
    }
}
