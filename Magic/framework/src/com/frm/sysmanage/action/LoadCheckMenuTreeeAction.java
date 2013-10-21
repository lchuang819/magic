/**
 * Powered by Lchuang @2011
 * Tel: 15810848558
 * E-mail: lchuang819@163.com
 */
package com.frm.sysmanage.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 *
 */
public class LoadCheckMenuTreeeAction extends ActionSupport {

	public static final String module = LoadCheckMenuTreeeAction.class.getName();
	
	@Override
	public String execute() throws Exception {
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String checkedStr = request.getParameter("expanded");
		boolean checked = Boolean.valueOf(checkedStr);
		
		return "success";
	}
}
