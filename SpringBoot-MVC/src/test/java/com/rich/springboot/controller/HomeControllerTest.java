/** 
 * Project Name: Spring-Boot-MVC 
 * File Name: HomeControllerTest.java 
 * Date: 2015年9月25日下午5:44:44 
 * @author: rich
 */

package com.rich.springboot.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * ClassName:HomeControllerTest <br/>
 * Function: Test HomeController FUNCTION. <br/>
 * Date:     2015年9月25日 下午5:44:44 <br/>
 * @author   rich
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class HomeControllerTest {
    
    private MockMvc mvc;
    
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
    }

    /**
     * Test method for {@link com.rich.springboot.controller.HomeController#home()}.
     */
    @Test
    public void testHome() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello Spring Boot!")));
    }

}
