/** 
 * Project Name:SpringBoot-REST 
 * File Name:SapcService.java 
 * Date:2015年12月15日上午10:44:23 
 * 
*/  
  
package com.rich.spring.boot.service;  

import java.util.List;

import com.rich.spring.boot.exception.ConnectDBException;
import com.rich.spring.boot.exception.UserNotFoundException;
import com.rich.spring.boot.repository.entity.Subscriber;


/** 
 * ClassName:SapcService <br/> 
 * Function: SAPC Service Interface for IL. <br/> 
 * Date:     2015年12月15日 上午10:44:23 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
public interface SubscriberService {
    
	/**
	 * Add Subscriber into Database.
	 * This is asynchronous method.
	 * 
	 * @param msisdn
	 * 
	 * @throws ConnectDBException
	 */
    void addSubscriber(String msisdn) throws ConnectDBException;
    
    /**
     * Delete Subscriber from Database.
     * 
     * @param msisdn
     * 
     * @throws ConnectDBException
     * @throws UserNotFoundException
     */
    void deleteSubscriber(String msisdn) throws ConnectDBException, UserNotFoundException;
    
    /**
     * Query all Subscriber.
     * 
     * @throws ConnectDBException
     */
    List<Subscriber> queryAllSubscriber()throws ConnectDBException;
}
  