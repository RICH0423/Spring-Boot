/** 
 * Project Name:Spring-Boot-MongoDB 
 * File Name:SampleMongoApplicationTest.java 
 * Package Name:com.rich.spring 
 * Date:2015年10月1日下午5:28:59 
 * 
*/  
  
package com.rich.spring;  

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rich.springboot.Application;

import static org.junit.Assert.assertTrue;

/** 
 * ClassName:SampleMongoApplicationTest <br/> 
 * Date:     2015年10月1日 下午5:28:59 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest
public class SampleMongoApplicationTest {

    @ClassRule
    public static OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultSettings() throws Exception {
        String output = SampleMongoApplicationTest.outputCapture.toString();
        assertTrue("Wrong output: " + output,
                output.contains("firstName='Alice', lastName='Smith'"));
    }

}
  