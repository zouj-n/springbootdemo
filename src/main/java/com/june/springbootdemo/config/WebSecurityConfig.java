package com.june.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String[] WHITE_LIST = {
            "/swagger**/**",
            "/webjars/**",
            "/doc.html",
            "classpath:/META-INF/resources/"
    };

    /**
     * intercept configure
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http    // http basic authentication
                .httpBasic().and()
                // cross-domain .csrf().ignoringAntMatchers(WHITE_LIST).and()
                .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

}