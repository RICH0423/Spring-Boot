/** 
 * Project Name: Spring-Boot 
 * File Name: UserController.java 
 * Package Name: com.rich.springboot.controller 
 * Date: 2015年9月25日下午3:40:28 
 * @author: rich
 */

package com.rich.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rich.springboot.model.User;

/** 
 * ClassName: UserController <br/> 
 * date: 2015年9月25日 下午3:40:28 <br/> 
 * 
 * @author rich 
 * @version  
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @RequestMapping("/{id}")
    public User view(@PathVariable("id") Long id) {
        
        User user = new User();
        user.setId(id);
        user.setName("RICH");
        return user;
    }

}
