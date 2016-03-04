/** 
 * Project Name:Spring-Boot-MongoDB 
 * File Name:CustomerRepository.java 
 * Package Name:com.rich.spring.mongo.repositary 
 * Date:2015年10月1日下午4:38:08 
 * 
*/  
  
package com.rich.springboot.mongo.repositary;  

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rich.springboot.mongo.entity.Customer;

/** 
 * ClassName:CustomerRepository <br/> 
 * Function: Customer Repository. <br/> 
 * Date:     2015年10月1日 下午4:38:08 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    
    public List<Customer> findByLastName(String lastName);
    
}
  