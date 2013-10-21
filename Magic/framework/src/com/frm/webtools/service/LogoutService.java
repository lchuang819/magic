/**
 * Powered by Chuang.Liu @2012-2-14
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.webtools.service;

import java.util.Date;
import java.util.Map;

import com.frm.security.entitymodel.UserLogin;
import com.frm.security.entitymodel.Visit;
import com.magic.service.BaseService;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2012-2-14
 */
public class LogoutService extends BaseService{

	public static final String module = LogoutService.class.getName();
	
	/**
	 * 退出服务
	 * @param context
	 * @return
	 */
	public Map logoutSevice(Map context){
		
		UserLogin userLogin = (UserLogin) context.get("userLogin");
		String visitId = (String) context.get("visitId");
		
		//设置UserLogin为退出状态
		if(UtilValidate.isNotEmpty(userLogin)){
			
			String userLoginId = userLogin.getUserLoginId();
			
			Debug.logInfo("Logout userLoginId " + userLoginId, module);
			
			UserLogin dbUserLogin = delegator.findById(UserLogin.class, userLoginId);
			
			if(UtilValidate.isNotEmpty(dbUserLogin)){
				
				dbUserLogin.setHasLoggedOut("Y");
				delegator.updateEntity(dbUserLogin);
			}
		}
		
		//设置访问表Visit为退出状态
		if(UtilValidate.isNotEmpty(visitId)){
			Visit visit = delegator.findById(Visit.class, visitId);
			
			Debug.logInfo("Logout visitId " + visitId, module);
			
			if(UtilValidate.isNotEmpty(visit)){
				visit.setThruDate(new Date());
				delegator.updateEntity(visit);
			}
		}
		
		
		return ServiceUtil.returnSuccess();
	}
	
}
