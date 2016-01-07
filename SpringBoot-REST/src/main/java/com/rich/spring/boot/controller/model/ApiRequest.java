/** 
 * Project Name:SpringBoot-REST 
 * File Name:ApiRequest.java 
 * Date:2015年11月26日下午2:30:12 
 * 
*/  
  
package com.rich.spring.boot.controller.model;  
/** 
 * ClassName:ApiRequest <br/> 
 * Function: Notify API Request. <br/> 
 * Date:     2015年11月26日 下午2:30:12 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
public class ApiRequest {
    
    private Integer type;
    private String name;
    private String param;
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
	@Override
	public String toString() {
		return "ApiRequest [type=" + type + ", name=" + name + ", param=" + param + "]";
	}
    
}
  