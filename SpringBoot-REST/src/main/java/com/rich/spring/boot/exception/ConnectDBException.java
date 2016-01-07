/** 
 * Project Name:SpringBoot-REST 
 * File Name:ConnectDBError.java 
 * Date:2015年12月18日上午11:09:15 
 * 
*/  
  
package com.rich.spring.boot.exception;  
/** 
 * ClassName:ConnectDBError <br/> 
 * Function: Connect PG DB error. <br/> 
 * Date:     2015年12月18日 上午11:09:15 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
public class ConnectDBException extends Exception{
    
	private static final long serialVersionUID = 1915004731212132237L;

	public ConnectDBException(String message){
        super(message);
    }
    
    public ConnectDBException(Throwable throwable){
        super(throwable);
    }

}
  