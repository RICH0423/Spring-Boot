/** 
 * Project Name:SpringBoot-REST 
 * File Name:Subscriber.java 
 * Date:2015年11月30日下午2:56:52 
 * 
*/  
  
package com.rich.srping.swagger.model;  

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/** 
 * ClassName:Subscriber <br/> 
 * Date:     2015年11月30日 下午2:56:52 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Entity
@Table(name="SUBSCRIBER")
public class Subscriber {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Size(max = 30)
    @Column(name = "MSISDN", nullable = false)
    private String msisdn;
    
    @Column(name = "CREATE_TIME", nullable = false)
    private Date createTime;
    
    @Column(name = "MODIFY_TIME", nullable = false)
    private Date modifyTime;
    
    public Subscriber(){
        super();
    }

    public Subscriber(String msisdn, Date createTime,
            Date modifyTime) {
        this();
        this.msisdn = msisdn;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "Subscriber [id=" + id + ", msisdn=" + msisdn + 
        		", createTime=" + createTime + ", modifyTime=" + modifyTime
                + "]";
    }

}
  