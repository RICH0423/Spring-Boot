/** 
 * Project Name:SpringBoot-REST 
 * File Name:ApiReturnCode.java 
 * Date:2015年12月9日下午2:20:29 
 * 
*/  
  
package com.rich.srping.swagger;  
/** 
 * ClassName:ApiReturnCode <br/> 
 * Date:     2015年12月9日 下午2:20:29 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
public class ApiReturnCode {
    
    public static final String SUCCESS = "0000";
    public static final String CONN_DB_FAIL = "2001";
    public static final String INTERNAL_ERROR = "2002";
    public static final String SUBSCRIBER_NOT_EXISTS = "2003";
    
    public static final String SUCCESS_MSG = "SUCCESSFUL";
    public static final String CONN_DB_FAIL_MSG = "CONN_DB_FAIL";
    public static final String INTERNAL_ERROR_MSG = "INTERNAL_ERROR";
    public static final String SUBSCRIBER_NOT_EXISTS_MSG = "SUBSCRIBER_NOT_EXISTS";
}
  