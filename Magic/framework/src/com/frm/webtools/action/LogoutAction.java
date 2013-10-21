/**
 * Powered by Chuang.Liu @2012-2-14
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.webtools.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.frm.security.entitymodel.UserLogin;
import com.frm.webtools.service.LogoutService;
import com.magic.action.BaseAction;
import com.magic.util.Debug;

/**
 * @author lchuang
 * @2012-2-14
 */
public class LogoutAction extends BaseAction {

	public static final String module = LogoutAction.class.getName();
	
	@Autowired
	private LogoutService logoutService;
	
	public String executeLogout() throws Exception {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		String sessionId = session.getId();
		
		
		UserLogin userLogin = (UserLogin) session.getAttribute("userLogin");
		String visitId = (String) session.getAttribute("visitId");
		
		Debug.logInfo("Logout visit id " + visitId, module);
		
		Map context = new HashMap();
		context.put("userLogin", userLogin);
		context.put("visitId", visitId);
		
		try {
			
			Map results = logoutService.logoutSevice(context);
		} catch (Exception e) {
			Debug.logError(e, module);
		}
		
		session.removeAttribute("userInfo");
		session.removeAttribute("labelList");
		session.removeAttribute("visitId");
		session.removeAttribute("userLogin");
		
		return SUCCESS;
	}
}
