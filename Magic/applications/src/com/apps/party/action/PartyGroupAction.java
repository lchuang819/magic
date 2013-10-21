/**
 * Powered by Chuang.Liu @2011-10-18
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apps.party.constant.PartyActionType;
import com.apps.party.entitymodel.PartyGroup;
import com.apps.party.service.PartyGroupService;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-10-18
 */
public class PartyGroupAction extends ActionSupport {

	public static final String module = PartyGroupAction.class.getName();
	
	private PartyGroup partyGroup;
	
	@Qualifier("partyGroupService")
	private PartyGroupService partyGroupService; 
	
	/**
	 * @return the partyGroupService
	 */
	public PartyGroupService getPartyGroupService() {
		return partyGroupService;
	}

	/**
	 * @param partyGroupService the partyGroupService to set
	 */
	public void setPartyGroupService(PartyGroupService partyGroupService) {
		this.partyGroupService = partyGroupService;
	}

	/**
	 * @return the partyGroup
	 */
	public PartyGroup getPartyGroup() {
		return partyGroup;
	}

	/**
	 * @param partyGroup the partyGroup to set
	 */
	public void setPartyGroup(PartyGroup partyGroup) {
		this.partyGroup = partyGroup;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		Map params = request.getParameterMap();
		Debug.logInfo("PartyGroupAction params:"+params, module);
		
		String actionType = request.getParameter("actionType");
		Debug.logInfo("PartyGroupAction actionType:"+actionType, module);
		
		Map context = new HashMap();
		context.put("partyGroup", partyGroup);
		try {
			
			if(PartyActionType.CREATE_PARTY_GROUP.equals(actionType)){
				
				Map results = partyGroupService.executeCreatePartyGroup(context);
				if(ServiceUtil.isError(results)){
					CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
					return null;
				}
			}else{
				
			}
		} catch (Exception e) {
			Debug.logError(e, module);
			CommonUtil.outFailureJson(response, e.getMessage());
		}
		
		CommonUtil.outSuccessJson(response, "成功");
		return null;
	}
}
