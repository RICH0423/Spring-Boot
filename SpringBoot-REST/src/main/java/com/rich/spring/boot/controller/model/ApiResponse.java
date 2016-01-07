/** 
 * Project Name:SpringBoot-REST 
 * File Name:NotifyResponse.java 
 * Date:2015年11月27日上午10:07:38 
 * 
*/  
  
package com.rich.spring.boot.controller.model;  
/** 
 * ClassName:NotifyResponse <br/> 
 * Function: Notify API Response. <br/> 
 * Date:     2015年11月27日 上午10:07:38 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
public class ApiResponse {
	
    private String code;
    private String msg;
    
    public ApiResponse(){
        super();
    }
    
	public ApiResponse(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ApiResponse [code=" + code + ", msg=" + msg + "]";
	}
    
}
  