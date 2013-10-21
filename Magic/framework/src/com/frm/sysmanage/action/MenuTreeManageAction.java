package com.frm.sysmanage.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.frm.content.entitymodel.Content;
import com.frm.sysmanage.service.MenuTreeManageService;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.opensymphony.xwork2.ActionSupport;

public class MenuTreeManageAction extends ActionSupport {
	
	public static final String module = MenuTreeManageAction.class.getName();

	private Content menus;

	private MenuTreeManageService menuTreeManageService;
	
	/**
	 * @return the menuTreeManageService
	 */
	public MenuTreeManageService getMenuTreeManageService() {
		return menuTreeManageService;
	}

	/**
	 * @param menuTreeManageService the menuTreeManageService to set
	 */
	public void setMenuTreeManageService(MenuTreeManageService menuTreeManageService) {
		this.menuTreeManageService = menuTreeManageService;
	}
	
	/**
	 * @return the menus
	 */
	public Content getMenus() {
		return menus;
	}

	/**
	 * @param menus the menus to set
	 */
	public void setMenus(Content menus) {
		this.menus = menus;
	}

	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Debug.logInfo("menus MenuName: " + menus.getContentName(), module);
		Debug.logInfo("menus ParentId: " + menus.getOwnerContentId(), module);
		boolean manageResult = menuTreeManageService.manageBuildMenus((String)request.getParameter("opn"), menus);
		
		if(manageResult){
			CommonUtil.outSuccessJson(ServletActionContext.getResponse(), "");
			return null;
		}else{
			CommonUtil.outFailureJson(ServletActionContext.getResponse(), "菜单处理失败");
			return null;
		}
		
	}
}
