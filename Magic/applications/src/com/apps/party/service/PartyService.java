/**
 * Powered by Chuang.Liu @2011-10-19
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.service;

import java.util.Map;

import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-10-19
 */
public class PartyService extends BaseService{

	/* (non-Javadoc)
	 * @see com.magic.service.IService#execute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map createIndividualCustomerService(Map context) throws ExecuteServiceException {
		
		String partyId = (String) context.get("partyId");
		
		if(UtilValidate.isEmpty(partyId)){
			partyId = delegator.getNextSeqId("Party");
		}
		
		return null;
	}

}
