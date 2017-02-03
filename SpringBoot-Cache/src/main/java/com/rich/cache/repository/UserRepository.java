/** 
 * Project Name:SpringBoot-Cache 
 * File Name:UserRepository.java 
 * Package Name:com.rich.cache.repository 
 * Date:2017年2月2日下午1:50:48 
 * 
*/  
  
package com.rich.cache.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rich.cache.entity.User;

/** 
 * ClassName:UserRepository <br/> 
 * Date:     2017年2月2日 下午1:50:48 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByUserName(String username);
}
  