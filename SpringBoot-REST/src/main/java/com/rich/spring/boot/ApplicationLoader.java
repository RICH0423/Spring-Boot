/** 
 * Project Name:SpringBoot-REST 
 * File Name:ApplicationLoader.java 
 * Date:2015年12月28日下午4:15:48 
 * 
*/  
  
package com.rich.spring.boot;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rich.spring.boot.repository.entity.Subscriber;
import com.rich.spring.boot.service.SubscriberService;

/** 
 * ClassName:ApplicationLoader <br/> 
 * Function: Perform tasks after all Spring Beans are created and 
 * the Application Context has been created.
 * 
 * Date:     2015年12月28日 下午4:15:48 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Component
public class ApplicationLoader implements CommandLineRunner {
 
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationLoader.class);
 
	@Autowired
    private SubscriberService subscriberService;
	
    @Override
    public void run(String... strings) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (String option : strings) {
            sb.append(" ").append(option);
        }
        sb = sb.length() == 0 ? sb.append("No Options Specified") : sb;
        LOGGER.info("WAR launched with following options: %s", sb.toString());
        
        LOGGER.info("----- queryAllSubscriber -----");
        List<Subscriber> allSubscriber = subscriberService.queryAllSubscriber();
        LOGGER.info("allSubscriber size: {}", allSubscriber.size());
        
        for(Subscriber sub : allSubscriber){
        	LOGGER.info("Subscriber: {}", sub);
        }
        
        subscriberService.addSubscriber("0999000001");
    }
}
  