/**
 * Powered by Chuang.Liu @2011-10-21
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.magic.entity;

import org.springframework.dao.DataAccessException;

/**
 * @author lchuang
 * @2011-10-21
 */
public class GenericEntityException extends DataAccessException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenericEntityException(String str) {
        super(str);
    }

    public GenericEntityException(String str, Throwable nested) {
        super(str, nested);
    }
}
