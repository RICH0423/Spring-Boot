/** 
 * Project Name:SpringBoot-REST 
 * File Name:SapcService.java 
 * Date:2015年11月20日上午11:20:31 
 * 
*/  
  
package com.rich.spring.boot.service;  

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.annotation.Transactional;

import com.rich.spring.boot.exception.ConnectDBException;
import com.rich.spring.boot.exception.UserNotFoundException;
import com.rich.spring.boot.repository.SubscriberRepository;
import com.rich.spring.boot.repository.entity.Subscriber;

/** 
 * ClassName:SapcService <br/> 
 * Date:     2015年11月20日 上午11:20:31 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Service
public class SubscriberServiceImpl implements SubscriberService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberServiceImpl.class);
    
    @Autowired
    private SubscriberRepository subRepository;

    @Transactional
    @Async
	@Override
	public void addSubscriber(String msisdn) throws ConnectDBException {
		Date createDate = new Date();
		Subscriber sub = new Subscriber(msisdn, createDate, createDate);
		
		try{
			subRepository.save(sub);
        } catch(CannotCreateTransactionException e){
            LOGGER.error("Connect DB failed: {}", e.getMessage(), e);
            throw new ConnectDBException(e);
        }
		
		LOGGER.info("Save Subscriber success, MSISDN: {}, ID: {}", msisdn, sub.getId());
	}


	@Override
	public void deleteSubscriber(String msisdn) throws ConnectDBException, UserNotFoundException {
		if(subRepository.findByMsisdn(msisdn) == null){
			throw new UserNotFoundException("Msisdn: " + msisdn);
		}
		
		try{
			subRepository.deleteByMsisdn(msisdn);
        } catch(CannotCreateTransactionException e){
            LOGGER.error("Connect DB failed: {}", e.getMessage(), e);
            throw new ConnectDBException(e);
        }
		
		LOGGER.info("Delete Subscriber success, MSISDN: {}", msisdn);
	}


	@Override
	public List<Subscriber> queryAllSubscriber() throws ConnectDBException {
		List<Subscriber> allSubscriber = subRepository.findAll();
		LOGGER.info("Search all Subscriber count: {}", allSubscriber.size());
		
		return allSubscriber;
	}
    
    

}
  