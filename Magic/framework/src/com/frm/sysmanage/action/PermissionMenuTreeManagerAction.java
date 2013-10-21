/**
 * Powered by Chuang.Liu @2011-9-30
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.sysmanage.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.frm.sysmanage.service.PermissionMenuTreeManagerService;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-9-30
 */
public class PermissionMenuTreeManagerAction extends ActionSupport {

	public static final String module = PermissionMenuTreeManagerAction.class.getName();
	
	private PermissionMenuTreeManagerService permissionMenuTreeManagerService;
	
	/**
	 * @return the permissionMenuTreeManagerService
	 */
	public PermissionMenuTreeManagerService getPermissionMenuTreeManagerService() {
		return permissionMenuTreeManagerService;
	}

	/**
	 * @param permissionMenuTreeManagerService the permissionMenuTreeManagerService to set
	 */
	public void setPermissionMenuTreeManagerService(
			PermissionMenuTreeManagerService permissionMenuTreeManagerService) {
		this.permissionMenuTreeManagerService = permissionMenuTreeManagerService;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String groupId = request.getParameter("groupId");
		String menuId = request.getParameter("menuId");
		String checked = request.getParameter("checked");
		
		Map context = new HashMap();
		context.put("groupId", groupId);
		context.put("menuId", menuId);
		context.put("checked", checked);
		try {
			Map resultMap = permissionMenuTreeManagerService.execute(context);
			if(ServiceUtil.isError(resultMap)){
				CommonUtil.outFailureJson(ServletActionContext.getResponse(), ServiceUtil.getErrorMessage(resultMap));
				return null;
			}
		} catch (Exception e) {
			Debug.logError(e, module);
			CommonUtil.outFailureJson(ServletActionContext.getResponse(), e.getMessage());
		}
		
		
		CommonUtil.outSuccessJson(ServletActionContext.getResponse(), "");
		return null;
	}
}
