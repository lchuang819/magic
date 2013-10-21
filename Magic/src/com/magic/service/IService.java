/**
 * Powered by Lchuang @2011
 * Tel: 15810848558
 * E-mail: lchuang819@163.com
 */
package com.magic.service;

import java.util.Map;

/**
 * @author lchuang
 *
 */
public interface IService {

	public abstract Map execute2(Map context) throws ExecuteServiceException;
}
