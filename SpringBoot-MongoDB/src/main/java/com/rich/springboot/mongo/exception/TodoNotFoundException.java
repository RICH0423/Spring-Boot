/** 
 * Project Name:Spring-Boot-MongoDB 
 * File Name:TodoNotFoundException.java 
 * Package Name:com.rich.springboot.mongo.exception 
 * Date:2016年3月2日下午3:04:42 
 * 
*/  
  
package com.rich.springboot.mongo.exception;  

/** 
 * ClassName:TodoNotFoundException <br/> 
 * Function: This exception is thrown when the requested todo entry is not found. <br/> 
 * Date:     2016年3月2日 下午3:04:42 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(String id) {
        super(String.format("No todo entry found with id: <%s>", id));
    }
}
  