/**
 * Powered by Chuang.Liu @2011-10-18
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.service;

import java.util.HashMap;
import java.util.Map;

import com.apps.party.entitymodel.PartyGroup;
import com.magic.entity.GenericEntityException;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-10-18
 */
public class PartyGroupService extends BaseService{

	public static final String module = PartyGroupService.class.getName();
	
	private PartyManagerService partyManagerService;
	
	/**
	 * @return the partyManagerService
	 */
	public PartyManagerService getPartyManagerService() {
		return partyManagerService;
	}

	/**
	 * @param partyManagerService the partyManagerService to set
	 */
	public void setPartyManagerService(PartyManagerService partyManagerService) {
		this.partyManagerService = partyManagerService;
	}

	/* (non-Javadoc)
	 * @see com.magic.service.IService#execute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		Debug.logInfo("PartyGroupService...", module);
		
		
		return null;
	}
	
	public Map executeCreatePartyGroup(Map context) throws ExecuteServiceException {
		
		PartyGroup partyGroup = (PartyGroup) context.get("partyGroup");
		if(UtilValidate.isEmpty(partyGroup)){
			Debug.logError("Create PartyGroup error input partyGroup object is empty.", module);
			return ServiceUtil.returnError("创建成员组失败");
		}
		String partyId = partyGroup.getPartyId();
		Debug.logInfo("executeCreatePartyGroup partyId:" + partyId, module);
		
		try {
			delegator.saveEntity(partyGroup);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("创建成员组失败");
		}
		
		Map inputMap = new HashMap();
		inputMap.put("partyId", partyId);
		inputMap.put("partyTypeId", "PARTY_GROUP");
		inputMap.put("statusId", "PARTY_ENABLED");
		
		
		partyManagerService.createPartyService(inputMap);
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}

}
