/** 
 * Project Name: Spring-Boot 
 * File Name: User.java 
 * Package Name: User 
 * Date: 2015年9月25日下午3:41:40 
 * @author: rich
 */

package com.rich.springboot.model;

import java.io.Serializable;


/** 
 * ClassName: User <br/> 
 * date: 2015年9月25日 下午3:41:40 <br/> 
 * 
 * @author rich 
 * @version  
 */
public class User implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
}
