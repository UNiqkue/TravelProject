package com.netcracker.travel.config;

import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.util.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfiguration(
            UserDetailsServiceImpl userDetailsService,
            PasswordEncoder passwordEncoder
    ) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/v2/api-docs",
                        "/swagger-resources/configuration/ui",
                        "/swagger-resources",
                        "/swagger-resources/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**")
                .permitAll()
                .and()

                .authorizeRequests()
                .antMatchers(
                        "/tours/all",
                        "/register"
                ).permitAll()

                .antMatchers(
                        "/agency/all/**",
                        "/customers/*",
                        "/tours/all/**",
                        "/tours/catalog/**",
                        "/tours/customer/**",
                        "/tours/booking/**"
                ).hasAuthority(Role.CUSTOMER.name())
                .antMatchers(
                        "/agency/all/**",
                        "/tours/**",
                        "/tours/all/**",
                        "/tours/catalog/**"
                ).hasAuthority(Role.TRAVELAGENT.name())
                .antMatchers(
                        "/tours/**",
                        "/tours/all/**",
                        "/tours/catalog/**",
                        "/agency/**",
                        "/agency/all/**",
                        "/users/**",
                        "/users/role/admin/**",
                        "/users/role/agent/**",
                        "/users/customer/**"
                ).hasAuthority(Role.ADMIN.name())


                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

}



















//                .antMatchers(
//                        "/agency/all",
//                        "/tours/all/**",
//                        "/tours/catalog/**"
//                ).hasAnyRole(Role.CUSTOMER.name(), Role.TRAVELAGENT.name(), Role.ADMIN.name())
//
//                .antMatchers(
//                        "/tours/customer/**",
//                        "/tours/booking/**",
//                        "/customers/*"
//                ).hasRole(Role.CUSTOMER.name())
//
//                .antMatchers(
//                        "/tours/**"
//                ).hasRole(Role.TRAVELAGENT.name())