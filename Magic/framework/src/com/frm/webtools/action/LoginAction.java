package com.frm.webtools.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.frm.content.service.ContentService;
import com.frm.security.entitymodel.UserLogin;
import com.frm.security.entitymodel.Visit;
import com.frm.webtools.service.LoadUserMenusService;
import com.frm.webtools.service.LoginService;
import com.magic.action.BaseAction;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;

public class LoginAction extends BaseAction {
	
	public static final String module = LoginAction.class.getName();

	private UserLogin user;
	
	private List labelList;
	
	private Map userInfo = new HashMap();
	
	@Qualifier("loginService")
	private LoginService loginService;
	
	@Qualifier("loadUserMenusService")
	private LoadUserMenusService loadUserMenusService;
	
	@Autowired
	private ContentService contentService;
	
	/**
	 * @return the user
	 */
	public UserLogin getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserLogin user) {
		this.user = user;
	}

	/**
	 * @return the loginService
	 */
	public LoginService getLoginService() {
		return loginService;
	}

	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	

	/**
	 * @return the loadUserMenusService
	 */
	public LoadUserMenusService getLoadUserMenusService() {
		return loadUserMenusService;
	}

	/**
	 * @param loadUserMenusService the loadUserMenusService to set
	 */
	public void setLoadUserMenusService(LoadUserMenusService loadUserMenusService) {
		this.loadUserMenusService = loadUserMenusService;
	}



	private boolean success;

	private String message;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		String sessionId = session.getId();
		
		String clientIpAddress = request.getRemoteAddr();
		String clientHostName = request.getRemoteHost();
		String serverIpAddress = request.getLocalAddr();
		String serverHostName = request.getLocalName();
		Locale locale = request.getLocale();
		
		String initialUserAgent = request.getHeader("User-Agent");
		String initialReferrer = request.getHeader("Referer");
		
		JSONObject json = new JSONObject();
		
		Map inputMap = new HashMap();
		inputMap.put("userLoginId", user.getUserLoginId());
		inputMap.put("password", user.getCurrentPassword());
		inputMap.put("clientIpAddress", clientIpAddress);
		inputMap.put("clientHostName", clientHostName);
		inputMap.put("serverIpAddress", serverIpAddress);
		inputMap.put("serverHostName", serverHostName);
		inputMap.put("locale", locale);
		inputMap.put("initialUserAgent", initialUserAgent);
		inputMap.put("initialReferrer", initialReferrer);
		inputMap.put("sessionId", sessionId);
		
		//登陆
		Map results = null;
		
		try {
			results = loginService.userLoginService(inputMap);
		} catch (Exception e) {
			Debug.logError(e, module);
			return ERROR;
		}
		
		if(ServiceUtil.isError(results)){
			Debug.logError("loginService result:" + results, module);
			CommonUtil.outFailureJson(ServletActionContext.getResponse(), ServiceUtil.getErrorMessage(results));
			return ERROR;
		}
		//BuildUserInfo buildUserInfo = (BuildUserInfo)results.get("userInfo");
		
		Map menusResults = contentService.loadMenuService(inputMap);
		if(ServiceUtil.isError(menusResults)){
			errorResultMap = menusResults;
			return ERROR;
		}
		
		Debug.logInfo("Run loadUserMenusService Success.", module);
		labelList = (ArrayList)menusResults.get("labelList");
		Debug.logInfo("Return labelList:" + labelList, module);
	
		session.setAttribute("labelList", labelList);
		session.setAttribute("userLogin", results.get("userLogin"));
		
		Visit currentVisit = (Visit) results.get("currentVisit");
		Visit lastVisit = (Visit) results.get("lastVisit");
		
		userInfo.put("userLoginId", user.getUserLoginId());
		
		userInfo.put("userLoginId", user.getUserLoginId());
		userInfo.put("clientIpAddress", clientIpAddress);
		userInfo.put("clientHostName", clientHostName);
		userInfo.put("locale", locale);
		userInfo.put("initialUserAgent", initialUserAgent);
		userInfo.put("initialReferrer", initialReferrer);
		userInfo.put("sessionId", sessionId);
		
		userInfo.put("lastClientIpAddress", lastVisit.getClientIpAddress());
		userInfo.put("clientIpAddress", clientIpAddress);
		
		userInfo.put("lastLoginDate", lastVisit.getFromDate());
		userInfo.put("loginDate", currentVisit.getFromDate());
		
		userInfo.put("lastLogoutDate", lastVisit.getThruDate() == null ? "" : lastVisit.getThruDate());
		
		session.setAttribute("userInfo", userInfo);
		session.setAttribute("visitId", currentVisit.getVisitId());
		
		CommonUtil.outSuccessJson(response, "登陆成功");
		return null;
	}

}
