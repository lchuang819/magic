/**
 * Powered by Chuang.Liu @2011-11-4
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.magic.action;

import java.util.Collection;
import java.util.Map;

import com.magic.util.ModelService;
import com.magic.util.ServiceUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-11-4
 */
public class BaseAction extends ActionSupport{
	
	public Map errorResultMap = ServiceUtil.returnError("");

	/**
	 * @return the errorResultMap
	 */
	public Map getErrorResultMap() {
		return errorResultMap;
	}

	/**
	 * @param errorResultMap the errorResultMap to set
	 */
	public void setErrorResultMap(Map errorResultMap) {
		this.errorResultMap = errorResultMap;
	}
	
	public void setErrorMessage(String errorMsg){
		if(errorMsg != null){
			errorResultMap.put(ModelService.ERROR_MESSAGE, errorMsg);
		}
	}
	
	public void setResultMessage(Collection<String> errorMessageList){
		
	}
}
