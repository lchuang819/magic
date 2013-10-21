package com.frm.sysmanage.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.frm.sysmanage.service.CheckMenuTreeLoaderService;
import com.frm.sysmanage.service.MenuTreeLoaderService;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.opensymphony.xwork2.ActionSupport;

public class MenuTreeLoaderAction extends ActionSupport {

	public static final String module = MenuTreeLoaderAction.class.getName();
	
	private MenuTreeLoaderService menuTreeLoaderService;
	
	private CheckMenuTreeLoaderService checkMenuTreeLoaderService;
	
	/**
	 * @return the menuTreeLoaderService
	 */
	public MenuTreeLoaderService getMenuTreeLoaderService() {
		return menuTreeLoaderService;
	}

	/**
	 * @param menuTreeLoaderService the menuTreeLoaderService to set
	 */
	public void setMenuTreeLoaderService(MenuTreeLoaderService menuTreeLoaderService) {
		this.menuTreeLoaderService = menuTreeLoaderService;
	}

	/**
	 * @return the checkMenuTreeLoaderService
	 */
	public CheckMenuTreeLoaderService getCheckMenuTreeLoaderService() {
		return checkMenuTreeLoaderService;
	}

	/**
	 * @param checkMenuTreeLoaderService the checkMenuTreeLoaderService to set
	 */
	public void setCheckMenuTreeLoaderService(
			CheckMenuTreeLoaderService checkMenuTreeLoaderService) {
		this.checkMenuTreeLoaderService = checkMenuTreeLoaderService;
	}

	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Map userInfo = (Map)session.getAttribute("userInfo");
		
		Debug.logInfo("request map:"+request.getParameterMap(), module);
		
		String checkTree = request.getParameter("checkTree");
		String groupId = request.getParameter("groupId");
		String node = request.getParameter("node");
		
		Debug.logInfo("request map[node]:"+node, module);
		Debug.logInfo("request map[groupId]:"+groupId, module);
		boolean isCheckTree = Boolean.valueOf(checkTree);

		Map inputMap = new HashMap();
		inputMap.put("groupId", groupId);
		//inputMap.put("username", userInfo.get("username"));
		
		Map resultMap = null;
		
		if(isCheckTree){
			resultMap = checkMenuTreeLoaderService.execute(inputMap);
		}else{
			resultMap = menuTreeLoaderService.execute(inputMap);
		}
		
		
		JSONArray jsonObject = JSONArray.fromObject(resultMap.get("menuTrees"));
		
		//jsonObject.put("success", true);
		//System.out.println(jsonObject.toString());
		CommonUtil.outJson(ServletActionContext.getResponse(), jsonObject);
		return null;
	}
}
