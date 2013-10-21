/**
 * Powered by Chuang.Liu @2011-10-9
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.sysmanage.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.frm.sysmanage.service.PermissionUsergroupManagerService;
import com.magic.constant.Constant;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-10-9
 */
public class PermissionUsergroupManagerAction extends ActionSupport {

	public static final String module = PermissionUsergroupManagerAction.class.getName();
	
	private PermissionUsergroupManagerService permissionUsergroupManagerService;
	
	/**
	 * @return the permissionUsergroupManagerService
	 */
	public PermissionUsergroupManagerService getPermissionUsergroupManagerService() {
		return permissionUsergroupManagerService;
	}

	/**
	 * @param permissionUsergroupManagerService the permissionUsergroupManagerService to set
	 */
	public void setPermissionUsergroupManagerService(
			PermissionUsergroupManagerService permissionUsergroupManagerService) {
		this.permissionUsergroupManagerService = permissionUsergroupManagerService;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		Map inputMap = new HashMap();
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String groupId = request.getParameter("groupId");
			String operation = request.getParameter("operation");
			String checked = request.getParameter("checked");
			String userId = request.getParameter("userId");
			
			inputMap.put("groupId", groupId);
			inputMap.put("userId", userId);
			inputMap.put("checked", checked);
			if(!Constant.OPERATION_LOAD.equals(operation)){
				Map resultMap = permissionUsergroupManagerService.execute(inputMap);
			}else{
				Map resultMap = permissionUsergroupManagerService.executeLoadUsertree(inputMap);
				JSONArray jsonObject = JSONArray.fromObject(resultMap.get("userTrees"));
				
				//jsonObject.put("success", true);
				//System.out.println(jsonObject.toString());
				CommonUtil.outJson(ServletActionContext.getResponse(), jsonObject);
			}
			
		} catch (Exception e) {
			Debug.logError(e, module);
		}
		
		return null;
	}
}
