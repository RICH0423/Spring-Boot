/**
 * Project Name:SpringMVC-REST
 * File Name:HomeController.java
 * Package Name:com.rich.springmvc.controller
 * Date:2015年9月25日下午3:59:38
 *
 *
*/

package com.rich.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/** 
 * ClassName: HomeController <br/> 
 * date: 2015年9月25日 下午3:59:38 <br/> 
 * 
 * @author rich 
 * @version  
 */
@RestController
public class HomeController {
    
    @RequestMapping("/")
    String home() {
        return "Hello Spring Boot!";
    }
    
}
