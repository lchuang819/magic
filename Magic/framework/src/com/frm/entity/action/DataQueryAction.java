/**
 * Powered by Chuang.Liu @2011-9-28
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.entity.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.frm.entity.model.EntityModel;
import com.frm.entity.service.DataQueryService;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-9-28
 */
public class DataQueryAction extends ActionSupport {

	public static final String module = DataQueryAction.class.getName();
	
	private EntityModel entityModel;
	
	private DataQueryService dataQueryService;
	
	/**
	 * @return the entityModel
	 */
	public EntityModel getEntityModel() {
		return entityModel;
	}

	/**
	 * @param entityModel the entityModel to set
	 */
	public void setEntityModel(EntityModel entityModel) {
		this.entityModel = entityModel;
	}
	
	/**
	 * @return the dataQueryService
	 */
	public DataQueryService getDataQueryService() {
		return dataQueryService;
	}

	/**
	 * @param dataQueryService the dataQueryService to set
	 */
	public void setDataQueryService(DataQueryService dataQueryService) {
		this.dataQueryService = dataQueryService;
	}

	/*
	 * {limit=[Ljava.lang.String;@62be97, 
	 * sort=[Ljava.lang.String;@cee41f, 
	 * start=[Ljava.lang.String;@e2b9e5, 
	 * dir=[Ljava.lang.String;@11a772d, 
	 * callback=[Ljava.lang.String;@863941, 
	 * _dc=[Ljava.lang.String;@190efc}
	 */
	@Override
	public String execute() throws Exception {
		//String entityName = entityModel.getEntityName();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Map requestMap = request.getParameterMap();
		Debug.logInfo("requestMap:"+requestMap, module);
		
		String limit = request.getParameter("limit");
		String sort = request.getParameter("sort");
		String start = request.getParameter("start");
		String dir = request.getParameter("dir");
		String callback = request.getParameter("callback");
		String _dc = request.getParameter("_dc");
		
		Map inputMap = new HashMap();
		inputMap.put("limit", limit);
		inputMap.put("sort", sort);
		inputMap.put("start", start);
		inputMap.put("dir", dir);
		inputMap.put("callback", callback);
		inputMap.put("_dc", _dc);
		
		Map result = null;
		try {
			result = dataQueryService.execute(inputMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		JSONObject json = (JSONObject)result.get("returnData");
		
		
		
		Debug.logInfo("out json data:"+JSONObject.fromObject(json), module);
		//request.getSession().setAttribute("topics", dataMap);
		HttpServletResponse response = ServletActionContext.getResponse();
		//CommonUtil.outSuccessJson(response, "");
		CommonUtil.outJson(response, JSONObject.fromObject(json));
		return null;
		
	}
}
