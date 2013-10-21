/**
 * Powered by Lchuang @2011
 * Tel: 15810848558
 * E-mail: lchuang819@163.com
 */
package com.frm.sysmanage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.frm.sysmanage.service.SecurityGroupTreeLoaderService;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 *
 */
public class LoadGroupsAction extends ActionSupport {

	public static final String module = LoadGroupsAction.class.getName();
	
	private SecurityGroupTreeLoaderService securityGroupTreeLoaderService;
	
	/**
	 * @return the securityGroupTreeLoaderService
	 */
	public SecurityGroupTreeLoaderService getSecurityGroupTreeLoaderService() {
		return securityGroupTreeLoaderService;
	}

	/**
	 * @param securityGroupTreeLoaderService the securityGroupTreeLoaderService to set
	 */
	public void setSecurityGroupTreeLoaderService(
			SecurityGroupTreeLoaderService securityGroupTreeLoaderService) {
		this.securityGroupTreeLoaderService = securityGroupTreeLoaderService;
	}


	@Override
	public String execute() throws Exception {
		
		ArrayList groups = new ArrayList();
		
		String groupId = (String)ServletActionContext.getRequest().getAttribute("groupId");
		String groupId2 = ServletActionContext.getRequest().getParameter("groupId");
		Debug.logInfo("groupId:"+groupId, module);
		Debug.logInfo("groupId2:"+groupId2, module);
		
		Map resultMap = securityGroupTreeLoaderService.execute(new HashMap());
		groups = (ArrayList)resultMap.get("groupTrees");
		
		JSONArray jsonObject = JSONArray.fromObject(groups);
		
		//jsonObject.put("success", true);
		//System.out.println(jsonObject.toString());
		CommonUtil.outJson(ServletActionContext.getResponse(), jsonObject);
		
		return null;
	}
}
