/** 
 * Project Name:SpringBoot-Cache 
 * File Name:LocalCacheEvict.java 
 * Package Name:com.rich.cache 
 * Date:2017年2月3日下午4:46:05 
 * 
*/  
  
package com.rich.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

/** 
 * ClassName:LocalCacheEvict <br/> 
 * Date:     2017年2月3日 下午4:46:05 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Component
public class LoaclCacheEvict {
    
    @CacheEvict(cacheNames = "allUser",allEntries = true)
    public void evictAllUsersCache() {
    }
    
    @CacheEvict(cacheNames = "userCache",allEntries = true)
    public void evictUserCache() {
    }
}
  