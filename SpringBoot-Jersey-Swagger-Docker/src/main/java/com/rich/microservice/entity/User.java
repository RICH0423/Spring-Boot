/** 
 * Project Name:SpringBoot-Docker-Swagger-Jersey 
 * File Name:User.java 
 * Package Name:com.rich.microservice.entity 
 * Date:2016年11月3日下午5:07:53 
 * 
*/  
  
package com.rich.microservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** 
 * ClassName:User <br/> 
 * Date:     2016年11月3日 下午5:07:53 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Entity
public class User {
	
	@Id
    @GeneratedValue
	private Long id;
	
	@Column (nullable = false )
	private String name;
	
	@Column (nullable = false )
	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
  