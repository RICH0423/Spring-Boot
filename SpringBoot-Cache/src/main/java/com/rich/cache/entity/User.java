/** 
 * Project Name:SpringBoot-Cache 
 * File Name:User.java 
 * Package Name:com.rich.cache.entity 
 * Date:2017年1月23日下午4:59:36 
 * 
*/  
  
package com.rich.cache.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** 
 * ClassName:User <br/> 
 * Date:     2017年1月23日 下午4:59:36 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Entity
public class User {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable=false)
    private String userName;
    
    @Column(nullable=false)
    private String firstName;
    
    @Column(nullable=false)
    private String lastName;
    
    public User(){
        super();
    }
    
    public User(String userName, String firstName, String lastName) {
        this();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
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
}
  