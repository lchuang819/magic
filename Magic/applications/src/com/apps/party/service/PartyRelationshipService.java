/**
 * Powered by Chuang.Liu @2011-12-1
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.apps.party.entitymodel.PartyRelationship;
import com.apps.party.entitymodel.PartyRelationshipId;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilDateTime;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-12-1
 */
public class PartyRelationshipService extends BaseService {

	public static final String module = PartyRelationshipService.class.getName();
	
	/**
	 * 创建Party
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createPartyRelationshipService(Map context) throws ExecuteServiceException{
		
		PartyRelationshipId id = (PartyRelationshipId) context.get("partyRelationshipId");
		PartyRelationship partyRelationship = (PartyRelationship) context.get("partyRelationship");
		
		if(UtilValidate.isEmpty(partyRelationship)){
			partyRelationship = new PartyRelationship();
		}
		
		if(UtilValidate.isEmpty(id)){
			Debug.logError("createPartyRelationshipService input partyRelationshipId is empty.", module);
			return ServiceUtil.returnError("输入参数为空");
		}
		
		partyRelationship.setId(id);
		
		delegator.saveEntity(partyRelationship);
		
		Map results = ServiceUtil.returnSuccess();
		return results;
	}
	
	/**
	 * 删除Party
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map deletePartyRelationshipService(Map context) throws ExecuteServiceException{
		
		String partyIdFrom = (String) context.get("partyIdFrom");
		String partyIdTo = (String) context.get("partyIdTo");
		String roleTypeIdFrom = (String) context.get("roleTypeIdFrom");
		String roleTypeIdTo = (String) context.get("roleTypeIdTo");
		String fromDate = (String) context.get("fromDate");
		
		PartyRelationshipId id = new PartyRelationshipId(partyIdFrom, partyIdTo, roleTypeIdFrom, roleTypeIdTo, new Timestamp(new java.util.Date(fromDate).getTime()));
		
		try {
			Debug.logInfo("deletePartyRelationshipService context:" + context, module);
			Debug.logInfo("PartyRelationshipId Info:" + BeanUtils.describe(id), module);
			delegator.deleteById(PartyRelationship.class, id);
		} catch (Exception e) {
			Debug.logError(e, module);
		} 
		
		
		Map results = ServiceUtil.returnSuccess();
		return results;
	}
}
