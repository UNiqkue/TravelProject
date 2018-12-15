package com.netcracker.travel.config;

import com.netcracker.travel.service.implementation.AdminServiceImpl;
import com.netcracker.travel.service.implementation.CustomerServiceImpl;
import com.netcracker.travel.service.implementation.TravelAgentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AdminServiceImpl adminService;

    private final TravelAgentServiceImpl travelAgentService;

    private final CustomerServiceImpl customerService;

    @Autowired
    public WebSecurityConfiguration(AdminServiceImpl adminService, TravelAgentServiceImpl travelAgentService, CustomerServiceImpl customerService) {
        this.adminService = adminService;
        this.travelAgentService = travelAgentService;
        this.customerService = customerService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/test").permitAll()
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
                .and()
                .csrf().disable();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(adminService).passwordEncoder(getPasswordEncoder());
//        auth.userDetailsService(travelAgentService).passwordEncoder(getPasswordEncoder());
//        auth.userDetailsService(customerService).passwordEncoder(getPasswordEncoder());
//    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(9);
    }

}
