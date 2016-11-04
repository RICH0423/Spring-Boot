/** 
 * Project Name:SpringBoot-Docker-Swagger-Jersey 
 * File Name:CustomerService.java 
 * Package Name:com.rich.microservice.resource 
 * Date:2016年11月3日下午5:20:34 
 * 
*/  
  
package com.rich.microservice.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rich.microservice.dao.UserRepository;
import com.rich.microservice.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

/** 
 * ClassName: CustomerResource <br/> 
 * Date:     2016年11月3日 下午5:20:34 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */

@Component
@Path("/Customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Customer resource", produces = "application/json")
public class CustomerResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerResource.class);
	
	@Inject
    private UserRepository userRepository;
	
	@GET
	@ApiOperation(value = "Gets all Customers.", response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Get Customer resource success") })
	public Response getAllCustomer() {
		List<User> allUsers = (List<User>) userRepository.findAll();
		LOGGER.info("All user count: {}", allUsers.size());
		return Response.status(Status.OK).entity(allUsers).build();
	}
	
	@GET
	@Path("/{id}")
	@ApiOperation(value = "Gets Customer by id.", response = User.class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Customer resource found"),
	    @ApiResponse(code = 404, message = "Customer resource not found")
	})
	public Response getCustomerByName(@PathParam("id") Long id) {
		LOGGER.info("ID {}", id);
		User user = userRepository.findOne(id);
		if(user == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.status(Status.OK).entity(user).build();
	}

	@POST
	@ApiOperation(value = "Create Customer.", response = User.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Customer resource created", responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created Customer", response = String.class) }) })
	public Response createCustomer(User user, @Context UriInfo uriInfo) {
		User savedUser = userRepository.save(user);
		
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(String.valueOf(savedUser.getId()));
		return Response.created(builder.build()).build();
	}
	
	@DELETE
	@Path("/{id}")
	@ApiOperation(value = "Delete Customer.", response = User.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Customer resource deleted"),
			@ApiResponse(code = 404, message = "Customer resource not found") })
	public Response deleteCustomer(@PathParam("id") Long id) {
		User user = userRepository.findOne(id);
		if(user == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		userRepository.delete(user);
		
		return Response.ok().build();
	}

}
  