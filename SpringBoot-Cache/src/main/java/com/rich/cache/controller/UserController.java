/** 
 * Project Name:SpringBoot-Cache 
 * File Name:BookController.java 
 * Package Name:com.rich.cache.controller 
 * Date:2017年2月2日下午1:42:37 
 * 
*/  
  
package com.rich.cache.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rich.cache.entity.User;
import com.rich.cache.service.UserService;

/** 
 * ClassName:BookController <br/> 
 * Date:     2017年2月2日 下午1:42:37 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@RestController
@RequestMapping("/v1/users")
public class UserController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> getAllUser() {
        return userService.findAll();
    }
    
    @GetMapping("/{username}")
    public List<User> getUser(@PathVariable("username") String username) {
        return userService.findByUserName(username);
    }
    
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteById(userId);
    }
}
  