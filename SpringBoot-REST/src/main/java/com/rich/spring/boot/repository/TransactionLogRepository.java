/** 
 * Project Name:SpringBoot-REST 
 * File Name:TransactionLogRepository.java 
 * Date:2015年11月30日下午4:37:15 
 * 
*/  
  
package com.rich.spring.boot.repository;  

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.rich.spring.boot.repository.entity.TransactionLog;


/** 
 * ClassName:TransactionLogRepository <br/> 
 * Date:     2015年11月30日 下午4:37:15 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Transactional(readOnly = true)
public interface TransactionLogRepository extends JpaRepository<TransactionLog, String>{

    TransactionLog findByTxId(String txId);
    
    @Query("SELECT t FROM TransactionLog t WHERE t.createTime BETWEEN ?1 and ?2 "
            + "AND (t.interFace = 'IL' OR t.interFace = 'PGGUI') "
            + "AND t.operation != 'search' "
            + "AND t.operation2 IS NULL ORDER BY t.createTime")
    List<TransactionLog> findByStartDateBetweenAndOperation(Date startDate, Date endDate);
    
    List<TransactionLog> findByMsisdn(String msisdn);
    
    @Query("SELECT t.msisdn FROM TransactionLog t WHERE t.status = ?1 GROUP BY t.msisdn")
    List<String> findMsisdnByStatusGrouped(int status);
    
    /**
     * Select REQUEST_DN, REQUEST fields.
     * 
     * @param txId
     * @return
     */
    @Query(value = "SELECT REQUEST_DN, REQUEST FROM TRANSACTION_LOG WHERE TX_ID = ?1", nativeQuery = true)
    public List<Object[]> findRequest(String txId);
    
}
  