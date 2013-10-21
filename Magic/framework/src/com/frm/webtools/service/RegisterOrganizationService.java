/**
 * Powered by Chuang.Liu @2012-2-16
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.webtools.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.apps.party.entitymodel.Party;
import com.apps.party.entitymodel.Person;
import com.apps.party.service.PartyManagerService;
import com.frm.security.entitymodel.UserLogin;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2012-2-16
 */
public class RegisterOrganizationService extends BaseService {

	public static final String module = RegisterOrganizationService.class.getName();
	
	@Autowired
	private PartyManagerService partyManagerService;
	
	@Autowired
	private UserLoginService userLoginService;
	
	/**
	 * 注册公司，关联系统管理员
	 * @param context[Party:organizationParty,UserLogin:userLogin]
	 * @return Map[Party:organizationParty]
	 * @throws ExecuteServiceException
	 */
	public Map registerOrganizationService(Map context) throws ExecuteServiceException {
		
		Party organizationParty = (Party) context.get("organizationParty");
		Person person = (Person) context.get("person");
		UserLogin systemUserLogin = (UserLogin) context.get("userLogin");
		
		//创建公司
		Map organizationMap = new HashMap();
		organizationMap.put("organizationParty", organizationParty);
		
		Map results = partyManagerService.createOrganizationService(organizationMap);
		if(ServiceUtil.isError(results)){
			return results;
		}
		
		organizationParty = (Party) results.get("organizationParty");
		
		if(UtilValidate.isEmpty(organizationParty)){
			return ServiceUtil.returnError("注册失败");
		}
		
		//创建公司系统管理员并与公司关联
		String organizationPartyId = organizationParty.getPartyId();
		
		Map personMap = new HashMap();
		personMap.put("person", person);
		personMap.put("isCreateUserLogin", "true");
		personMap.put("userLogin", systemUserLogin);
		
		results = partyManagerService.createPersonService(personMap);
		if(ServiceUtil.isError(results)){
			return results;
		}
		
		
		
		
		return results;
	}
	
}
