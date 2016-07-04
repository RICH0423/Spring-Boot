/** 
 * Project Name:SpringBoot-REST 
 * File Name:SubscriberRepository.java 
 * Date:2015年11月30日下午4:14:16 
 * 
*/  
  
package com.rich.srping.swagger.repository;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.rich.srping.swagger.model.Subscriber;


/** 
 * ClassName:SubscriberRepository <br/> 
 * Function: Subscriber Repository. <br/> 
 * Date:     2015年11月30日 下午4:14:16 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Transactional(readOnly = true)
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer>{
    
    Long countByMsisdn(String msisdn);
    
    Subscriber findByMsisdn(String msisdn);
    
    @Modifying
    @Transactional
    Long deleteByMsisdn(String msisdn);
    
    @Modifying
    @Transactional
    @Query("update Subscriber s set s.msisdn = ?1 where s.msisdn = ?2")
    int updateMsisdn(String updateMsisdn, String msisdn);
    
}
  