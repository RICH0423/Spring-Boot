/** 
 * Project Name:SpringBoot-REST 
 * File Name:SapcService.java 
 * Date:2015年12月15日上午10:44:23 
 * 
*/  
  
package com.rich.srping.swagger.service;  

import java.util.List;

import com.rich.srping.swagger.exception.ConnectDBException;
import com.rich.srping.swagger.exception.UserNotFoundException;
import com.rich.srping.swagger.model.Subscriber;


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
     * Find Subscriber by ID.
     * 
     * @param id
     * @return Subscriber
     * @throws ConnectDBException
     * @throws UserNotFoundException
     */
    Subscriber findById(int id) throws ConnectDBException, UserNotFoundException;
    

    /**
     * Add Subscriber into Database.
     * 
     * @param msisdn
     * @return Subscriber
     * @throws ConnectDBException
     */
    Subscriber addSubscriber(String msisdn) throws ConnectDBException;
    
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
     * 
     * @param id
     * @throws ConnectDBException
     * @throws UserNotFoundException
     */
    void deleteById(int id) throws ConnectDBException, UserNotFoundException;
    
    /**
     * Query all Subscriber.
     * 
     * @throws ConnectDBException
     */
    List<Subscriber> queryAllSubscriber()throws ConnectDBException;
}
  