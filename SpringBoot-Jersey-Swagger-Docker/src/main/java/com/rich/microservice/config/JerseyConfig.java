/** 
 * Project Name:springboot-jersey-swagger-docker 
 * File Name:JerseyConfig.java 
 * Package Name:com.rich.microservice.config 
 * Date:2016年10月12日下午1:26:27 
 * 
*/  
  
package com.rich.microservice.config;  

import javax.annotation.PostConstruct;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.rich.microservice.resource.CustomerResource;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

/** 
 * ClassName:JerseyConfig <br/> 
 * Date:     2016年10月12日 下午1:26:27 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Component
public class JerseyConfig extends ResourceConfig {

	@Value("${spring.jersey.application-path:/}")
	private String apiPath;

	public JerseyConfig() {
		this.registerEndpoints();
	}

	@PostConstruct
	public void init() {
		this.configureSwagger();
	}

	private void registerEndpoints() {
		this.register(CustomerResource.class);
		// Access through /<Jersey's servlet path>/application.wadl
		this.register(WadlResource.class);
	}

	private void configureSwagger() {
		// Available at localhost:port/swagger.json
		this.register(ApiListingResource.class);
		this.register(SwaggerSerializers.class);

		BeanConfig config = new BeanConfig();
		config.setConfigId("Springboot-jersey-swagger-docker");
		config.setTitle("Spring Boot + Jersey + Swagger + Docker Example");
		config.setVersion("v1");
		config.setContact("RICH LEE");
		config.setSchemes(new String[] { "http", "https" });
		config.setBasePath(this.apiPath);
		config.setResourcePackage("com.rich.microservice.resource");
		config.setPrettyPrint(true);
		config.setScan(true);
	}
}