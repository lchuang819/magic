/**
 * Powered by Chuang.Liu @2011-10-19
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.webtools.service;

import java.util.Map;

import com.apps.party.entitymodel.Party;
import com.frm.security.entitymodel.UserLogin;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.HashCrypt;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-10-19
 */
public class UserLoginService extends BaseService {

	public static final String module = UserLoginService.class.getName();
	
	private UserLogin userLogin;
	
	/**
	 * @return the userLogin
	 */
	public UserLogin getUserLogin() {
		return userLogin;
	}

	/**
	 * @param userLogin the userLogin to set
	 */
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	/* (non-Javadoc)
	 * @see com.magic.service.IService#execute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 创建用户登陆，如果有party信息则关联UserLogin与Party
	 * @param context[UserLogin:userLogin, Party:party]
	 * @return Map
	 * @throws ExecuteServiceException
	 */
	public Map executeCreateUserLogin(Map context) throws ExecuteServiceException {
		UserLogin newUserLogin = (UserLogin) context.get("userLogin");
		Party party = (Party) context.get("party");
		
		if(UtilValidate.isEmpty(newUserLogin)){
			return ServiceUtil.returnError("输入参数userLogin不可用");
		}
		
		if(UtilValidate.isNotEmpty(party)){
			newUserLogin.setPartyId(party.getPartyId());
		}
		
		String password = newUserLogin.getCurrentPassword();
		
		String newPassword = HashCrypt.getDigestHash(password);
		newUserLogin.setCurrentPassword(newPassword);
		newUserLogin.setEnabled("Y");
		
		delegator.saveEntity(newUserLogin);
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}
}
