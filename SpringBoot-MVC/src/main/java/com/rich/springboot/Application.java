package com.rich.springboot;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * 
 * ClassName: App <br/> 
 * date: 2015年9月25日 下午5:20:34 <br/> 
 * 
 * @author rich 
 * @version
 */
@Configuration  
@ComponentScan  
@EnableAutoConfiguration
public class Application {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        LOGGER.info("====== Inspect the beans provided by Spring Boot: ======");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
        	LOGGER.info("Initial Bean name:{}", beanName);
        }
    }
}
