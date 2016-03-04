/** 
 * Project Name:Spring-Boot-MongoDB 
 * File Name:TodoRepository.java 
 * Package Name:com.rich.springboot.mongo.repositary 
 * Date:2016年3月1日下午3:40:36 
 * 
*/  
  
package com.rich.springboot.mongo.repositary;  

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;
import com.rich.springboot.mongo.entity.Todo;

/** 
 * ClassName:TodoRepository <br/> 
 * Date:     2016年3月1日 下午3:40:36 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
public interface TodoRepository extends Repository<Todo, String>{
	
	void delete(Todo deleted);
	 
    List<Todo> findAll();
 
    Optional<Todo> findOne(String id);
 
    Todo save(Todo saved);
    
}
  