package com.rich.srping.swagger;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAutoConfiguration
@EnableAsync
@ComponentScan
public class Application extends SpringBootServletInitializer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(final String[] args) {
    	LOGGER.info("Spring-Boot Server starting");
    	
    	ConfigurableApplicationContext applicationContext = null;
        try{
        	applicationContext = SpringApplication.run(Application.class, args);
        } catch(Exception e){
            LOGGER.error("Spring-Boot started failed!", e);
        }
        
        LOGGER.info("Spring-Boot start finished, is active:{}, start time: {}",
        		applicationContext.isActive(), new Date(applicationContext.getStartupDate()));
    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
