/** 
 * Project Name:Spring-Boot-MongoDB 
 * File Name:Application.java 
 * Package Name:com.rich.spring 
 * Date:2015年10月1日下午4:40:54 
 * 
*/  
  
package com.rich.springboot;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.rich.springboot.mongo.entity.Todo;
import com.rich.springboot.mongo.repositary.TodoRepository;

/** 
 * ClassName:Application <br/> 
 * Date:     2015年10月1日 下午4:40:54 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    	LOGGER.info("Initial Data into MongoDB start...");
        initMongoData();
    }

	private void initMongoData() {
		Todo todo = Todo.getBuilder()
                .title("Todo title")
                .description("This is init todo data")
                .build();

		todo = todoRepository.save(todo);
		
        LOGGER.info("Initial Data into MongoDB finished, todo ID: {}", todo.getId());
	}

}
  