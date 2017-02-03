/** 
 * Project Name:SpringBoot-Cache 
 * File Name:UserService.java 
 * Package Name:com.rich.cache.service 
 * Date:2017年2月2日下午1:52:42 
 * 
*/  
  
package com.rich.cache.service;

import java.util.List;

import com.rich.cache.entity.User;

/** 
 * ClassName:UserService <br/> 
 * Date:     2017年2月2日 下午1:52:42 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
public interface UserService {
    
    void create(String userName, String firstName, String lastName);
    
    List<User> findAll();
    
    List<User> findByUserName(String username);
    
    void deleteById(Long userId);
    
    User firstUser();

}
  