/** 
 * Project Name:SpringBoot-Cache 
 * File Name:EvictScheduler.java 
 * Package Name:com.rich.cache 
 * Date:2017年2月3日下午4:52:38 
 * 
*/  
  
package com.rich.cache.repository.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rich.cache.LoaclCacheEvict;

/** 
 * ClassName:EvictScheduler <br/> 
 * Date:     2017年2月3日 下午4:52:38 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Component
public class EvictScheduler {

    @Autowired
    private LoaclCacheEvict cacheEvict;
    
    @Autowired
    private CacheManager cacheManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(EvictScheduler.class);

    @Scheduled(fixedDelay = 5000)
    public void showCacheInfo() {
        LOGGER.info("All cache name: {}", cacheManager.getCacheNames());;
        
        Cache cache = cacheManager.getCache("allUser");
        ValueWrapper valueWrapper = cache.get("allUser");
        if(valueWrapper != null) {
            LOGGER.info("AllUser cache data: {}", valueWrapper.get());
        }
    }


}
  