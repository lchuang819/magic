/**
 * Powered by Chuang.Liu @2011-11-28
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.service;

import java.util.Map;

import com.apps.party.entitymodel.PartyRole;
import com.apps.party.entitymodel.PartyRoleId;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-11-28
 */
public class RoleService extends BaseService {

	/**
	 * 创建PartyRole
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createPartyRoleService(Map context) throws ExecuteServiceException {
		PartyRoleId id = (PartyRoleId) context.get("partyRoleId");
		if(UtilValidate.isEmpty(id)){
			throw new ExecuteServiceException("输入的参数为空");
		}
		
		PartyRole role = new PartyRole(id);
		
		delegator.saveEntity(role);
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}
	
	/**
	 * 删除PartyRole
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map deletePartyRoleService(Map context) throws ExecuteServiceException {
		String partyId = (String) context.get("partyId");
		String roleTypeId = (String) context.get("roleTypeId");
		
		PartyRoleId id = new PartyRoleId(partyId, roleTypeId);
		
		delegator.deleteById(PartyRole.class, id);
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}
}
