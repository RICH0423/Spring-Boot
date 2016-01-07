/** 
 * Project Name:SpringBoot-REST 
 * File Name:StatusController.java 
 * Date:2015年11月17日下午2:11:04 
 * 
*/  
  
package com.rich.spring.boot.controller;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/** 
 * ClassName:StatusController <br/> 
 * Function: Check service status. <br/> 
 * Date:     2015年11月17日 下午2:11:04 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */

@RestController
@RequestMapping(value="/status")
public class StatusController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StatusController.class);

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    
    @RequestMapping(value = "/healthCheck", method = RequestMethod.GET)
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<String>("Check status ok", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/poolStatus", method = RequestMethod.GET)
    public ResponseEntity<String> getPoolStatus() {
        String status = genPoolStatus();
        LOGGER.info("ThreadPool status:{}", status);
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }
    
    private String genPoolStatus(){
        StringBuilder sb = new StringBuilder();
        sb.append("Max pool size: ").append(threadPoolTaskExecutor.getMaxPoolSize())
        .append(", Current pool size: ").append(threadPoolTaskExecutor.getPoolSize())
        .append(", Core pool size:").append(threadPoolTaskExecutor.getCorePoolSize())
        .append(", Active count: ").append(threadPoolTaskExecutor.getActiveCount());
        
        return sb.toString();
    }
    
}
  