package com.sher.api.secret.config;

import com.sher.api.secret.constant.Constants;
import com.sher.api.secret.filter.SecretFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;

/**
 * @author sherxia92
 */
@Configuration
public class WebConfig {

    @Bean
    public Filter secretFilter() {
        return new SecretFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DelegatingFilterProxy("secretFilter"));
        registration.setName("secretFilter");
        registration.addUrlPatterns(Constants.PREFIX + "/*");
        registration.setOrder(1);
        return registration;
    }
}
