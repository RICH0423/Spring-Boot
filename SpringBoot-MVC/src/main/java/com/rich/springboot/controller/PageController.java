/** 
 * Project Name: Spring-Boot-MVC 
 * File Name: PageController.java 
 * Date: 2015年9月25日下午4:31:43 
 * @author: rich
 */

package com.rich.springboot.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/** 
 * ClassName: PageController <br/> 
 * date: 2015年9月25日 下午4:31:43 <br/> 
 * 
 * @author rich 
 * @version  
 */
@Controller
public class PageController {
    
    @Value("${application.message:Hello World}")
    private String message = "Hello World";
    
    @RequestMapping("/page")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", message);
        return "welcome";
    }
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        
        String str = "Hello World, This is Spring-Boot MVC!";
        mav.addObject("message", str);

        return mav;
    }

}
