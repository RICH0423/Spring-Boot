/** 
 * Project Name:Spring-Boot-MongoDB 
 * File Name:Customer.java 
 * Package Name:com.rich.spring.mongo.model 
 * Date:2015年10月1日下午4:36:09 
 * 
*/  
  
package com.rich.springboot.mongo.entity;  

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/** 
 * ClassName:Customer <br/> 
 * Date:     2015年10月1日 下午4:36:09 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Document(collection="customer")
public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
  