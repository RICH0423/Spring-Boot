/** 
 * Project Name:SpringBoot-Docker-Swagger-Jersey 
 * File Name:UserRepository.java 
 * Package Name:com.rich.microservice.dao 
 * Date:2016年11月3日下午5:15:12 
 * 
*/  
  
package com.rich.microservice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rich.microservice.entity.User;

/** 
 * ClassName:UserRepository <br/> 
 * Date:     2016年11月3日 下午5:15:12 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
public interface UserRepository extends CrudRepository<User, Long>{
	
	List<User> findByName(String name);
}
  