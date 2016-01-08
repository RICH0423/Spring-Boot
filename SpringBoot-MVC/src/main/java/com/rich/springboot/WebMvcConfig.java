/** 
 * Project Name: Spring-Boot-MVC 
 * File Name: WebMvcConfig.java 
 * Date: 2015年9月25日下午4:14:47 
 * @author: rich
 */

package com.rich.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/** 
 * ClassName: WebMvcConfig <br/> 
 * Function: Web Mvc Config. <br/> 
 * date: 2015年9月25日 下午4:14:47 <br/> 
 * 
 * @author rich 
 * @version  
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}