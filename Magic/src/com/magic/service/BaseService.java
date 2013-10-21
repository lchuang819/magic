/**
 * Powered by Chuang.Liu @2011-9-28
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.magic.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.magic.entity.HibernateDelegatorInterface;

/**
 * @author lchuang
 * @2011-9-28
 */
public class BaseService {

	@Autowired
	@Qualifier("delegator")
	public HibernateDelegatorInterface delegator;
	

	public HibernateDelegatorInterface getDelegator() {
		return delegator;
	}

	public void setDelegator(HibernateDelegatorInterface delegator) {
		this.delegator = delegator;
	}
	
	public Map execute(Map context)  throws ExecuteServiceException{
		
		return null;
	}
}
