/**
 * Powered by Chuang.Liu @2011-10-17
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.common.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Qualifier;

import com.frm.common.service.LoadParamsService;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-10-17
 */
public class LoadParamsAction extends ActionSupport {

	public static final String module = LoadParamsAction.class.getName();
	@Qualifier("loadParamsService")
	private LoadParamsService loadParamsService;
	
	/**
	 * @return the loadParamsService
	 */
	public LoadParamsService getLoadParamsService() {
		return loadParamsService;
	}

	/**
	 * @param loadParamsService the loadParamsService to set
	 */
	public void setLoadParamsService(LoadParamsService loadParamsService) {
		this.loadParamsService = loadParamsService;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String actionType = request.getParameter("actionType");
		Debug.logInfo("LoadParamsAction actionType:"+actionType, module);
		
		Map context = new HashMap();
		context.put("actionType", actionType);
		
		try {
			Map resultMap = loadParamsService.execute(context);
			
			JSONObject json = (JSONObject)resultMap.get("returnData");
			CommonUtil.outJson(response, JSONObject.fromObject(json));
			
		} catch (Exception e) {
			Debug.logError(e, module);
		}
		
		return null;
	}
}
