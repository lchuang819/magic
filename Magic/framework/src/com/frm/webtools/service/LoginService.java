/**
 * Powered by Lchuang @2011
 * Tel: 15810848558
 * E-mail: lchuang819@163.com
 */
package com.frm.webtools.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.frm.security.entitymodel.UserLogin;
import com.frm.security.entitymodel.UserLoginHistory;
import com.frm.security.entitymodel.UserLoginHistoryId;
import com.frm.security.entitymodel.Visit;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.HashCrypt;
import com.magic.util.ServiceUtil;

/**
 * @author lchuang
 *
 */
public class LoginService extends BaseService {

	public static final String module = LoginService.class.getName();

	/* (non-Javadoc)
	 * @see com.magic.service.IService#excute(java.util.Map)
	 */
	public Map userLoginService(Map context)  throws ExecuteServiceException{
		
		String userLoginId = (String)context.get("userLoginId");
		String password = (String)context.get("password");
		
		String clientIpAddress = (String)context.get("clientIpAddress");
		String clientHostName = (String)context.get("clientHostName");
		String serverIpAddress = (String)context.get("serverIpAddress");
		String serverHostName = (String)context.get("serverHostName");
		Locale locale = (Locale)context.get("locale");
		String initialUserAgent = (String)context.get("initialUserAgent");
		String initialReferrer = (String)context.get("initialReferrer");
		String sessionId = (String)context.get("sessionId");
		
		Debug.logInfo("User "+userLoginId + "start login system.", module);
		Debug.logInfo("Login clientIpAddress :" + clientIpAddress, module);
		Debug.logInfo("Login remoteHost :" + clientHostName, module);
//		Debug.logInfo("Login remoteUser :" + remoteUser, module);
		
		Date loginDate = new Date();
		
		Map resultMap = ServiceUtil.returnSuccess();
		UserLogin userLogin = null;
		try {
			userLogin = (UserLogin)delegator.findById(UserLogin.class, userLoginId);
			if(userLogin == null){
				return ServiceUtil.returnError("用户尚未注册");
			}
			
//			BuildUserInfo userInfo = (BuildUserInfo) delegator.findById(BuildUserInfo.class, userLoginId);
//			if(userInfo == null){
//				return ServiceUtil.returnError("查询注册信息失败");
//			}
//			resultMap.put("userInfo", userInfo);
		} catch (Exception e) {
			Debug.logInfo("LoginService find login user exception:"+e.getMessage(), module);
			e.printStackTrace();
		}
		
		
		String currentPassword = userLogin.getCurrentPassword();
		
		String encodedPassword = HashCrypt.getDigestHash(password, "SHA");
		
		
		Debug.logInfo("Query currentPassword:"+currentPassword, module);
		Debug.logInfo("HashCrypt encodedPassword:"+encodedPassword, module);
		
		//查询上次访问
		Map lastVistCond = new HashMap();
		lastVistCond.put("userLoginId", userLoginId);
		
		Visit lastVisit = delegator.findOne(Visit.class, lastVistCond, "fromDate", "DESC");
		
		//创建本次访问
		String visitId = delegator.getNextSeqId("Visit");
		
		Visit visit = new Visit();
		visit.setVisitId(visitId);
		visit.setSessionId(sessionId);
		visit.setClientIpAddress(clientIpAddress);
		visit.setClientHostName(clientHostName);
		visit.setUserLoginId(userLoginId);
		visit.setUserCreated("N");
		visit.setServerIpAddress(serverIpAddress);
		visit.setServerHostName(serverHostName);
		visit.setInitialLocale(locale.toString());
		visit.setInitialUserAgent(initialUserAgent);
		visit.setInitialReferrer(initialReferrer);
		visit.setFromDate(loginDate);
		delegator.saveEntity(visit);
		
		//查询上次登陆历史
		Map lastHistoryCond = new HashMap();
		lastHistoryCond.put("id.userLoginId", userLoginId);
		
		UserLoginHistory lastHistory = delegator.findOne(UserLoginHistory.class, lastHistoryCond, "id.fromDate", "DESC");
		
		//创建用户登陆历史
		UserLoginHistoryId currentHistoryId = new UserLoginHistoryId(userLoginId, loginDate);
		UserLoginHistory currentHistory = new UserLoginHistory(currentHistoryId);
		currentHistory.setVisitId(visitId);
		
		currentHistory.setSuccessfulLogin("Y");
		currentHistory.setPasswordUsed(currentPassword);
		
		delegator.saveEntity(currentHistory);
		
		resultMap.put("userLogin", userLogin);
		resultMap.put("currentHistory", currentHistory);
		resultMap.put("lastHistory", lastHistory);
		resultMap.put("visitId", visitId);
		resultMap.put("currentVisit", visit);
		resultMap.put("lastVisit", lastVisit);
		
		return resultMap;
	}

}
