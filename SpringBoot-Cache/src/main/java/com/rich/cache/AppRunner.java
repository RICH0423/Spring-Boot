package com.rich.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rich.cache.service.UserService;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private UserService userService;
    

    @Override
    public void run(String... args) throws Exception {
        
        //Creates user information for demo
        userService.create("Rich", "rich", "rich");
        userService.create("Tom", "tom", "tom");
        userService.create("Jack", "jack", "jack");
        
        LOGGER.info("Initial data finished!");
    }

}