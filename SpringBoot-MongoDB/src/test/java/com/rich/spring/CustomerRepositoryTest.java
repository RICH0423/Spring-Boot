/** 
 * Project Name:Spring-Boot-MongoDB 
 * File Name:SampleMongoApplicationTest.java 
 * Package Name:com.rich.spring 
 * Date:2015年10月1日下午5:28:59 
 * 
*/  
  
package com.rich.spring;  

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rich.springboot.Application;
import com.rich.springboot.EmbedMongoDBConfig;
import com.rich.springboot.mongo.entity.Customer;
import com.rich.springboot.mongo.repositary.CustomerRepository;

/** 
 * ClassName:SampleMongoApplicationTest <br/> 
 * Date:     2015年10月1日 下午5:28:59 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, EmbedMongoDBConfig.class})
@IntegrationTest
public class CustomerRepositoryTest {

	@Autowired
    private CustomerRepository customerRepository;

    @Test
    public void shouldCreateGame() {
    	Customer savedCustomer = customerRepository.save(new Customer("Alice", "Smith"));
    
    }

}
  