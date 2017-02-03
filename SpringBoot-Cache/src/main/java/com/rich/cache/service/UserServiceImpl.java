/** 
 * Project Name:SpringBoot-Cache 
 * File Name:UserServiceImpl.java 
 * Package Name:com.rich.cache.service 
 * Date:2017年2月2日下午1:55:29 
 * 
*/  
  
package com.rich.cache.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rich.cache.LoaclCacheEvict;
import com.rich.cache.entity.User;
import com.rich.cache.repository.UserRepository;

/** 
 * ClassName:UserServiceImpl <br/> 
 * Date:     2017年2月2日 下午1:55:29 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Service
public class UserServiceImpl implements UserService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoaclCacheEvict loaclCacheEvict;

    @Override
    @Cacheable("allUser")
    public List<User> findAll() {
        LOGGER.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "userCache", key = "{#username}")
    public List<User> findByUserName(String username) {
        LOGGER.info("Fetching users by username");
        return userRepository.findByUserName(username);
    }
    
    @Override
    @Cacheable(cacheNames = "userCache", key = "#root.methodName")
    public User firstUser() {
        LOGGER.info("Fetching first user");
        
        User user = userRepository.findAll().stream().findFirst().orElse(new User("", "", ""));
        
        return user;
    }

    @Override
    public void create(String userName, String firstName, String lastName) {
        userRepository.save(new User(userName, firstName, lastName));
    }

    @Override
    public void deleteById(Long userId) {
        if(userRepository.exists(userId)) {
            userRepository.delete(userId);
            LOGGER.info("Delete user id: {}", userId);
            
            loaclCacheEvict.evictAllUsersCache();
            loaclCacheEvict.evictUserCache();
        }
    }

}
  