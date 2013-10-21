/**
 * Powered by Chuang.Liu @2011-11-18
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.facility.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.apps.facility.constant.FacilityActionType;
import com.apps.facility.entitymodel.Facility;
import com.apps.facility.service.FacilityService;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-11-18
 */
public class FacilityAction extends ActionSupport {

	public final static String module = FacilityAction.class.getName();
	
	private Facility facility;
	
	@Autowired
	private FacilityService facilityService;
	
	/**
	 * @return the facility
	 */
	public Facility getFacility() {
		return facility;
	}

	/**
	 * @param facility the facility to set
	 */
	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public String executeFacilityManager() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String actionType = request.getParameter("actionType");
		Debug.logInfo("executeFacilityManager ActionType:"+actionType, module);
		
		Map results = null;
		
		Map context = new HashMap();
		context.put("facility", facility);
		
		if(FacilityActionType.CREATE_FACILITY.equals(actionType)){
			
			results = facilityService.createFacilityService(context);
			
		}else if(FacilityActionType.UPDATE_FACILITY.equals(actionType)){
			
			results = facilityService.updateFacilityService(context);
			
		}else if(FacilityActionType.DELETE_FACILITY.equals(actionType)){
			
			results = facilityService.deleteFacilityService(context);
			
		}
		
		if(ServiceUtil.isError(results)){
			CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
			return null;
		}
		
		CommonUtil.outSuccessJson(response, "操作成功");
		return null;
	}
	
	/**
	 * 加载facility
	 * @param[request:{actionType, facilityType}]
	 * @return
	 * @throws Exception
	 */
	public String executeFacilityLoader() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String actionType = request.getParameter("actionType");
		Debug.logInfo("FacilityActionType:"+actionType, module);
		
		String facilityType = request.getParameter("facilityType");
		
		Map context = new HashMap();
		context.put("actionType", actionType);
		context.put("facilityType", facilityType);
		
		Map results = facilityService.loadFacilityService(context);
		
		if(ServiceUtil.isError(results)){
			CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
			return null;
		}
		
		JSONObject json = (JSONObject)results.get("returnData");
		CommonUtil.outJson(response, json);
		return null;
	}
	
	public String executeLoadFacilityParties() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String facilityId = request.getParameter("facilityId");
		
		Map context = new HashMap();
		context.put("facilityId", facilityId);
		Map results = facilityService.loadFacilityPartiesService(context);
		
		if(ServiceUtil.isError(results)){
			CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
			return null;
		}
		
		JSONObject json = (JSONObject)results.get("returnData");
		CommonUtil.outJson(response, json);
		return null;
	}
	
}
