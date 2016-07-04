package com.rich.srping.swagger.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rich.srping.swagger.ApiReturnCode;
import com.rich.srping.swagger.exception.ConnectDBException;
import com.rich.srping.swagger.exception.UserNotFoundException;
import com.rich.srping.swagger.model.ApiRequest;
import com.rich.srping.swagger.model.ApiResponse;
import com.rich.srping.swagger.model.Subscriber;
import com.rich.srping.swagger.service.SubscriberService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;


/** 
 * ClassName:SubscriberController <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Api(basePath = SubscriberController.SUBSCRIBER_API_MAPPING, value = "Subscriber Resource", description = "Operations with Subscriber", produces = "application/json")
@RestController
@RequestMapping(SubscriberController.SUBSCRIBER_API_MAPPING)
public class SubscriberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberController.class);

	public static final String SUBSCRIBER_API_MAPPING = "/subscriber";
	
	@Autowired
	SubscriberService subscriberService;
	
	@ApiOperation(value="Create new subscriber")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public Subscriber addSubscriber(@RequestBody ApiRequest apiRequest) {
        
		LOGGER.info("Add subscriber request body: {}", apiRequest);
        
		Subscriber savedSub = null;
        try {
            savedSub = subscriberService.addSubscriber(apiRequest.getParam());
        } catch (ConnectDBException e) {
            LOGGER.error("Connect DB failed: {}", e.getMessage(), e);
        }        
        
        return savedSub;
    }
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ApiResponse> deleteSubscriber(@PathVariable("id") Integer id) {
        
		LOGGER.info("Delete subscriber id: {}", id);
        
        try {
        	subscriberService.deleteById(id);
        } catch (ConnectDBException e) {
            LOGGER.error("Connect DB failed: {}", e.getMessage(), e);
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
	
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Subscriber findById(@PathVariable("id") Integer id) throws ConnectDBException, UserNotFoundException {
        LOGGER.info("Finding todo entry with id: {}", id);

        return subscriberService.findById(id);
    }
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Subscriber> searchAllSubscriber() {
        
        List<Subscriber> allSubscriber = null;
        try {
        	allSubscriber = subscriberService.queryAllSubscriber();
        } catch (ConnectDBException e) {
            LOGGER.error("Connect DB failed: {}", e.getMessage(), e);
        }
        
        return allSubscriber;
    }
	

	
}
  