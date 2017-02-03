/** 
 * Project Name:SpringBoot-Cache 
 * File Name:WebConfiguration.java 
 * Package Name:com.rich.cache 
 * Date:2017年1月25日下午3:54:55 
 * 
*/

package com.rich.cache;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:WebConfiguration <br/>
 * Date: 2017年1月25日 下午3:54:55 <br/>
 * 
 * @author rich
 * @version
 * @since
 * @see
 */
@Configuration
public class WebConfiguration {

    /**
     * H2 web console, url: http://localhost:8088/console
     * 
     * @return
     */
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        registration.addInitParameter("webAllowOthers", "true");
        return registration;
    }

}
