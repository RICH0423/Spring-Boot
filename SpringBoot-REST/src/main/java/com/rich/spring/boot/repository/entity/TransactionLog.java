/** 
 * Project Name:SpringBoot-REST 
 * File Name:TransactionLog.java 
 * Date:2015年11月30日下午2:57:40 
 * 
*/  
  
package com.rich.spring.boot.repository.entity;  

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/** 
 * ClassName:TransactionLog <br/> 
 * Date:     2015年11月30日 下午2:57:40 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Entity
@Table(name="TRANSACTION_LOG")
public class TransactionLog {
    
    @Id
    @Size(max = 50)
    @Column(name = "TX_ID", nullable = false)
    private String txId;
    
    @Size(max = 30)
    @Column(name = "MSISDN", nullable = false)
    private String msisdn;
    
    @Size(max = 20)
    @Column(name = "INTERFACE", nullable = false)
    private String interFace;
    
    @Size(max = 50)
    @Column(name = "OPERATION", nullable = false)
    private String operation;
    
    @Size(max = 50)
    @Column(name = "OPERATION2")
    private String operation2;
    
    @Size(max = 100)
    @Column(name = "REQUEST_NODENAME")
    private String requestNodeName;
    
    @Size(max = 300)
    @Column(name = "REQUEST_DN")
    private String requestDn;
    
    @Size(max = 2000)
    @Column(name = "REQUEST")
    private String request;
    
    @Size(max = 2000)
    @Column(name = "RESPONSE")
    private String response;
    
    @Size(max = 10)
    @Column(name = "RESULT_CODE")
    private String resultCode;
    
    @Size(max = 1000)
    @Column(name = "RESULT_MSG")
    private String resultMsg;
    
    @Size(max = 10)
    @Column(name = "O_RESULT_CODE")
    private String originalResultCode;
    
    @Size(max = 1000)
    @Column(name = "O_RESULT_MSG")
    private String originalResultMsg;
    
    @Column(name = "IS_SEND_ALARM", nullable = false)
    private Integer isSendAlarm;
    
    @Column(name = "ACCESS_TIME", nullable = false)
    private Date accessTime;
    
    @Column(name = "SPEND_TIME")
    private Long spendTime;
    
    @Column(name = "STATUS", nullable = false)
    private Integer status;
    
    @Size(max = 50)
    @Column(name = "P_TX_ID")
    private String primaryTxID;
    
    @Size(max = 1000)
    @Column(name = "HOST_NAME")
    private String hostname;
    
    @Column(name = "CREATE_USER")
    private Integer createUser;
    
    @Column(name = "CREATE_TIME", nullable = false)
    private Date createTime;
    

    public TransactionLog() {
        super();
    }
    
    /**
     * TransactionLog constructor.
     * @param txId
     * @param msisdn
     * @param interFace
     * @param operation
     * @param request
     * @param isSendAlarm
     * @param accessTime
     * @param status
     * @param createTime
     */
    public TransactionLog(String txId, String msisdn, String interFace,
            String operation, String request, Integer isSendAlarm,
            Date accessTime, Integer status, Date createTime) {
        super();
        this.txId = txId;
        this.msisdn = msisdn;
        this.interFace = interFace;
        this.operation = operation;
        this.request = request;
        this.isSendAlarm = isSendAlarm;
        this.accessTime = accessTime;
        this.status = status;
        this.createTime = createTime;
    }

    public TransactionLog(String txId, String msisdn, String interFace,
            String operation, String requestNodeName, String requestDn,
            Integer isSendAlarm, Long spendTime, Integer status, Date createTime, 
            String resultCode, String resultMsg) {
        
        this(txId, msisdn, interFace, operation, "", isSendAlarm, createTime, status, createTime);
        this.requestNodeName = requestNodeName;
        this.requestDn = requestDn;
        this.spendTime = spendTime;
        this.status = status;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getTxId() {
        return txId;
    }
    
    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getInterFace() {
        return interFace;
    }

    public void setInterFace(String interFace) {
        this.interFace = interFace;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation2() {
        return operation2;
    }

    public void setOperation2(String operation2) {
        this.operation2 = operation2;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Integer getIsSendAlarm() {
        return isSendAlarm;
    }

    public void setIsSendAlarm(Integer isSendAlarm) {
        this.isSendAlarm = isSendAlarm;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public Long getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Long spendTime) {
        this.spendTime = spendTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPrimaryTxID() {
        return primaryTxID;
    }

    public void setPrimaryTxID(String primaryTxID) {
        this.primaryTxID = primaryTxID;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getOriginalResultCode() {
        return originalResultCode;
    }

    public void setOriginalResultCode(String originalResultCode) {
        this.originalResultCode = originalResultCode;
    }

    public String getOriginalResultMsg() {
        return originalResultMsg;
    }

    public void setOriginalResultMsg(String originalResultMsg) {
        this.originalResultMsg = originalResultMsg;
    }
    
    public String getRequestNodeName() {
        return requestNodeName;
    }

    public void setRequestNodeName(String requestNodeName) {
        this.requestNodeName = requestNodeName;
    }

    public String getRequestDn() {
        return requestDn;
    }

    public void setRequestDn(String requestDn) {
        this.requestDn = requestDn;
    }

    @Override
    public String toString() {
        return "TransactionLog [txId=" + txId + ", msisdn=" + msisdn
                + ", interFace=" + interFace + ", operation=" + operation
                + ", request=" + request + ", resultCode=" + resultCode + "]";
    }
    
}
  