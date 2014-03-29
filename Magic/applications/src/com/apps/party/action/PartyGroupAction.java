/**
 * Powered by Chuang.Liu @2011-10-18
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.apps.party.constant.PartyActionType;
import com.apps.party.entitymodel.Party;
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
@Controller
public class PartyGroupAction extends ActionSupport {

	public static final String module = PartyGroupAction.class.getName();

	@Autowired
	@Qualifier("partyGroup")
	private PartyGroup partyGroup;

	@Autowired
	@Qualifier("party")
	private Party party;

	public PartyGroup getPartyGroup() {
		return partyGroup;
	}

	public void setPartyGroup(PartyGroup partyGroup) {
		this.partyGroup = partyGroup;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	@Qualifier("partyGroupService")
	private PartyGroupService partyGroupService;

	/**
	 * @return the partyGroupService
	 */
	public PartyGroupService getPartyGroupService() {
		return partyGroupService;
	}

	/**
	 * @param partyGroupService
	 *            the partyGroupService to set
	 */
	public void setPartyGroupService(PartyGroupService partyGroupService) {
		this.partyGroupService = partyGroupService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		Map params = request.getParameterMap();
		Debug.logInfo("PartyGroupAction params:" + params, module);

		//partyGroup.groupNameLocal
		String actionType = request.getParameter("actionType");

		String limit = request.getParameter("limit");
		String sort = request.getParameter("sort");
		String start = request.getParameter("start");
		String dir = request.getParameter("dir");
		String callback = request.getParameter("callback");
		String _dc = request.getParameter("_dc");
		
		Debug.logInfo("PartyGroupAction actionType:" + actionType, module);

		Map context = new HashMap();
		context.put("partyGroup", partyGroup);
		context.put("party", party);
		
		context.put("limit", limit);
		context.put("sort", sort);
		context.put("start", start);
		context.put("dir", dir);
		context.put("callback", callback);
		context.put("_dc", _dc);

		Map results = null;

		try {

			if (PartyActionType.CREATE_PARTY_GROUP.equals(actionType)) {

				results = partyGroupService.executeCreatePartyGroup(context);
				if (ServiceUtil.isError(results)) {
					CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
					return null;
				}

			} else if (PartyActionType.UPDATE_PARTY_GROUP.equals(actionType)) {

			} else if (PartyActionType.DELETE_PARTY.equals(actionType)) {

			} else if (PartyActionType.LOAD_PARTY_GROUP.equals(actionType)) {
				
				String partyTypeId = request.getParameter("partyTypeId");
				Debug.logInfo("PartyGroupAction partyTypeId:" + partyTypeId, module);
				
				context.put("partyTypeId", partyTypeId);
				
				results = partyGroupService.executeLoadPartyGroup(context);
				
				JSONObject json = (JSONObject)results.get("returnData");
				CommonUtil.outJson(response, JSONObject.fromObject(json));
				
				return null;
				
			}

		} catch (Exception e) {
			Debug.logError(e, module);
			CommonUtil.outFailureJson(response, e.getMessage());
			return null;
		}

		JSONObject responseData = JSONObject.fromObject(results);
		Debug.logInfo("Response Data:" + responseData, module);
		CommonUtil.outSuccessJson(response, "操作成功", responseData);
		return null;
	}
}
