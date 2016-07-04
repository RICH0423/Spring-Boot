/** 
 * Project Name:SpringBoot-REST 
 * File Name:UserNotFoundException.java 
 * Date:2015年12月18日上午11:09:15 
 * 
*/  
package com.rich.srping.swagger.exception;

public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = -7630066735832452688L;

    public UserNotFoundException(final String message) {
        super(message);
    }
}
