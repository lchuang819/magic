/**
 * Powered by Chuang.Liu @2011-9-28
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.magic.service;

import com.magic.exception.GeneralRuntimeException;

/**
 * @author lchuang
 * @2011-9-28
 */
public class ExecuteServiceException extends GeneralRuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExecuteServiceException(String str) {
        super(str);
    }

    public ExecuteServiceException(String str, Throwable nested) {
        super(str, nested);
    }
}
