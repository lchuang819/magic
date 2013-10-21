/**
 * Powered by Chuang.Liu @2012-2-16
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.accounting.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.apps.accounting.service.GlAccountService;
import com.magic.action.BaseAction;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;

/**
 * @author lchuang
 * @2012-2-16
 */
public class GlAccountAction extends BaseAction {

	public static final String module = GlAccountAction.class.getName();
	
	@Autowired
	private GlAccountService glAccountService;
	
	public String executeLoadOrganizationGlAccount() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String actionType = request.getParameter("actionType");
		
		Map context = new HashMap();
		
		Map results = glAccountService.glAccountLoadService(context);
		if(ServiceUtil.isError(results)){
			Debug.logError(ServiceUtil.getErrorMessage(results), module);
			CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
		}
		
		JSONObject returnData = (JSONObject) results.get("returnData");
		CommonUtil.outJson(response, returnData);
		
		return null;
	}
	
	
}
