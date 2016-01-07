/** 
 * Project Name:SpringBoot-REST 
 * File Name:SubscriberController.java 
 * Date:2015年12月25日下午4:51:18 
 * 
*/  
  
package com.rich.spring.boot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rich.spring.boot.ApiReturnCode;
import com.rich.spring.boot.controller.model.ApiRequest;
import com.rich.spring.boot.controller.model.ApiResponse;
import com.rich.spring.boot.exception.ConnectDBException;
import com.rich.spring.boot.exception.UserNotFoundException;
import com.rich.spring.boot.repository.entity.Subscriber;
import com.rich.spring.boot.service.SubscriberService;

/** 
 * ClassName:SubscriberController <br/> 
 * Date:     2015年12月25日 下午4:51:18 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@RestController
@RequestMapping(SubscriberController.SUBSCRIBER_API_MAPPING)
public class SubscriberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberController.class);

	public static final String SUBSCRIBER_API_MAPPING = "/sub";
	
	@Autowired
	SubscriberService subscriberService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> addSubscriber(@RequestBody ApiRequest apiRequest) {
        
		LOGGER.info("Add subscriber request body: {}", apiRequest);
        
        try {
        	subscriberService.addSubscriber(apiRequest.getParam());
        } catch (ConnectDBException e) {
            LOGGER.error("Connect PG DB failed: {}", e.getMessage(), e);
            return new ResponseEntity<ApiResponse>(new ApiResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
        }        
        
        return new ResponseEntity<ApiResponse>(new ApiResponse(ApiReturnCode.SUCCESS,
        		ApiReturnCode.SUCCESS_MSG), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> deleteSubscriber(@RequestParam String msisdn) {
        
		LOGGER.info("Delete subscriber request msisdn: {}", msisdn);
        
        try {
        	subscriberService.deleteSubscriber(msisdn);
        } catch (ConnectDBException e) {
            LOGGER.error("Connect PG DB failed: {}", e.getMessage(), e);
            return new ResponseEntity<ApiResponse>(new ApiResponse(
            		ApiReturnCode.CONN_DB_FAIL, ApiReturnCode.CONN_DB_FAIL_MSG), HttpStatus.INTERNAL_SERVER_ERROR);
        
        }    catch (UserNotFoundException e) {
            LOGGER.error("User Not Found error!", e);
            return new ResponseEntity<ApiResponse>(new ApiResponse(
            		ApiReturnCode.SUBSCRIBER_NOT_EXISTS, ApiReturnCode.SUBSCRIBER_NOT_EXISTS_MSG), HttpStatus.INTERNAL_SERVER_ERROR);
        }      
        
        return new ResponseEntity<ApiResponse>(new ApiResponse(ApiReturnCode.SUCCESS,
        		ApiReturnCode.SUCCESS_MSG), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/searchAll", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> searchAllSubscriber(@RequestParam String msisdn) {
        
		LOGGER.info("Search all subscriber request msisdn: {}", msisdn);
		
        List<Subscriber> allSubscriber = null;
        try {
        	allSubscriber = subscriberService.queryAllSubscriber();
        } catch (ConnectDBException e) {
            LOGGER.error("Connect PG DB failed: {}", e.getMessage(), e);
            return new ResponseEntity<ApiResponse>(
            		new ApiResponse(ApiReturnCode.CONN_DB_FAIL, ApiReturnCode.CONN_DB_FAIL_MSG), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        StringBuilder sb = new StringBuilder();
        for(Subscriber subscriber : allSubscriber){
        	sb.append(subscriber);
        }
        
        return new ResponseEntity<ApiResponse>(new ApiResponse(ApiReturnCode.SUCCESS,
        		sb.toString()), HttpStatus.OK);
    }
	
}
  