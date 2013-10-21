/**
 * Powered by Chuang.Liu @2011-10-17
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apps.party.constant.PartyActionType;
import com.apps.party.constant.PartyConstant;
import com.apps.party.service.ContactMechService;
import com.apps.party.service.GeoService;
import com.apps.party.service.PartyLoaderService;
import com.apps.party.service.PostalAddressService;
import com.apps.party.service.TelecomNumberService;
import com.frm.security.entitymodel.UserLogin;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-10-17
 */
public class PartyLoaderAction extends ActionSupport {

	public static final String module = PartyLoaderAction.class.getName();
	
	public Map partyDetail = new HashMap();
	
	public Map errorResultMap = new HashMap();
	
	@Qualifier("partyLoaderService")
	private PartyLoaderService partyLoaderService;
	
	@Qualifier("postalAddressService")
	private PostalAddressService postalAddressService;
	
	@Qualifier("contactMechService")
	private ContactMechService contactMechService;
	
	@Qualifier("telecomNumberService")
	private TelecomNumberService telecomNumberService;
	@Qualifier("geoService")
	private GeoService geoService;
	
	/**
	 * @return the geoService
	 */
	public GeoService getGeoService() {
		return geoService;
	}

	/**
	 * @param geoService the geoService to set
	 */
	public void setGeoService(GeoService geoService) {
		this.geoService = geoService;
	}

	/**
	 * @return the telecomNumberService
	 */
	public TelecomNumberService getTelecomNumberService() {
		return telecomNumberService;
	}

	/**
	 * @param telecomNumberService the telecomNumberService to set
	 */
	public void setTelecomNumberService(TelecomNumberService telecomNumberService) {
		this.telecomNumberService = telecomNumberService;
	}

	/**
	 * @return the contactMechService
	 */
	public ContactMechService getContactMechService() {
		return contactMechService;
	}

	/**
	 * @param contactMechService the contactMechService to set
	 */
	public void setContactMechService(ContactMechService contactMechService) {
		this.contactMechService = contactMechService;
	}

	/**
	 * @return the postalAddressService
	 */
	public PostalAddressService getPostalAddressService() {
		return postalAddressService;
	}

	/**
	 * @param postalAddressService the postalAddressService to set
	 */
	public void setPostalAddressService(PostalAddressService postalAddressService) {
		this.postalAddressService = postalAddressService;
	}

	/**
	 * @return the partyLoaderService
	 */
	public PartyLoaderService getPartyLoaderService() {
		return partyLoaderService;
	}

	/**
	 * @param partyLoaderService the partyLoaderService to set
	 */
	public void setPartyLoaderService(PartyLoaderService partyLoaderService) {
		this.partyLoaderService = partyLoaderService;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String actionType = request.getParameter("actionType");
		Debug.logInfo("PartyLoaderAction actionType:"+actionType, module);
		
		String roleTypeId = request.getParameter("roleTypeId");
		Debug.logInfo("Load roleTypeId:"+roleTypeId, module);
		
		String partyId = request.getParameter("partyId");
		Debug.logInfo("Load partyId:"+partyId, module);
		
		Map context = new HashMap();
		
		String gridFilterList = request.getParameter("gridFilterList");
		Debug.logInfo("Party loader gridFilterList:"+gridFilterList, module);
		if(UtilValidate.isNotEmpty(gridFilterList)){
			
			Map filterMap = new HashMap();
			String[] fields = gridFilterList.split(",");
			for(String field : fields){
				filterMap.put(field, request.getParameter(field));
				context.put("filterMap", filterMap);
			}
		}

		String limit = request.getParameter("limit");
		String sort = request.getParameter("sort");
		String start = request.getParameter("start");
		String dir = request.getParameter("dir");
		String callback = request.getParameter("callback");
		String _dc = request.getParameter("_dc");
		
		
		
		context.put("limit", limit);
		context.put("sort", sort);
		context.put("start", start);
		context.put("dir", dir);
		context.put("callback", callback);
		context.put("_dc", _dc);
		
		try {
			
			Map resultMap = new HashMap();
			if(PartyActionType.LOAD_PARTY.equals(actionType)){
				context.put("statusId", PartyConstant.PARTY_STATUS_ENABLED);
				resultMap = partyLoaderService.loadPartyService(context);
			}else if(PartyActionType.LOAD_PARTY_BY_ROLE_TYPE.equals(actionType)){
				
				context.put("roleTypeId", roleTypeId);
				resultMap = partyLoaderService.executeLoadByRoleType(context);
				
			}else if(PartyActionType.LOAD_POSTAL_ADDRESS.equals(actionType)){
				
				context.put("partyId", partyId);
				resultMap = postalAddressService.executeLoadPartyPostalAddress(context);
				
			}else if(PartyActionType.LOAD_CONTACT_MECH_BY_PARTY.equals(actionType)){
				
				Debug.logInfo("PartyLoaderAction LOAD_CONTACT_MECH_BY_PARTY:"+partyId, module);
				context.put("partyId", partyId);
				resultMap = contactMechService.loadContactMechByPartyIdService(context);
				
			}else if(PartyActionType.LOAD_TELECOM_NUMBER_BY_PARTY.equals(actionType)){
				
				Debug.logInfo("PartyLoaderAction LOAD_TELECOM_NUMBER_BY_PARTY:"+partyId, module);
				context.put("partyId", partyId);
				resultMap = telecomNumberService.loadTelecomNumberByPartyIdService(context);
				
			}else if(PartyActionType.LOAD_CONTACT_MECH_TYPE.equals(actionType)){
				
				context.put("hasTable", request.getParameter("hasTable"));
				Debug.logInfo("PartyLoaderAction LOAD_CONTACT_MECH_TYPE", module);
				resultMap = contactMechService.loadContactMechTypeService(context);
				
			}else if(PartyActionType.LOAD_GEO.equals(actionType)){
				String geoId = request.getParameter("geoId");
				String geoTypeId = request.getParameter("geoTypeId");
				String geoSecCode = request.getParameter("geoSecCode");
				String geoName = request.getParameter("geoName");
				
				Map input = new HashMap();
				input.put("geoId", geoId);
				input.put("geoTypeId", geoTypeId);
				input.put("geoSecCode", geoSecCode);
				input.put("geoName", geoName);
				
				Debug.logInfo("loadGeo input params:" + input, module);
				resultMap = geoService.loadGeoService(input);
				
			}
			
			if(ServiceUtil.isError(resultMap)){
				CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(resultMap));
				return null;
			}
			
			JSONObject json = (JSONObject)resultMap.get("returnData");
			CommonUtil.outJson(response, JSONObject.fromObject(json));
			
		} catch (Exception e) {
			Debug.logError(e, module);
		}
		
		return null;
	}
	
	public String executeLoadParyById() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String partyId = request.getParameter("partyId");
		Map context = new HashMap();
		context.put("partyId", partyId);
		context.put("limit", "10");
		context.put("start", "0");
		
		Map results = partyLoaderService.loadPartyService(context);
		if(ServiceUtil.isError(results)){
			Debug.logError("Load party by id error:" + ServiceUtil.getErrorMessage(results), module);
			errorResultMap = results;
			return ERROR;
		}
		
		List partyList = (List) results.get("partys");
		if(UtilValidate.isEmpty(partyList)){
			Debug.logError("Load party is empty. parry id is " + partyId, module);
			errorResultMap.put("errorMessage", "Load party is empty. parry id is " + partyId);
			return ERROR;
		}
		
		partyDetail = (Map) partyList.get(0);
		
		return SUCCESS;
	}
	
	/**
	 * 加载PartyRole
	 * @return
	 * @throws Exception
	 */
	public String executeLoadParyRole() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String partyId = request.getParameter("partyId");
		
		Map context = new HashMap();
		context.put("partyId", partyId);
		
		try {
			
			Map results = partyLoaderService.loadPartyRoleService(context);
			
			if(ServiceUtil.isError(results)){
				CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
				return null;
			}
			
			JSONObject json = (JSONObject)results.get("returnData");
			CommonUtil.outJson(response, json);
		} catch (Exception e) {
			Debug.logError(e, module);
			CommonUtil.outFailureJson(response, e.getMessage());
		}
		
		return null;
	}
	
	public String executeLoadRoleType() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		Map context = new HashMap();
		
		try {
			
			Map results = partyLoaderService.loadRoleTypeService(context);
			
			if(ServiceUtil.isError(results)){
				CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
				return null;
			}
			
			JSONObject json = (JSONObject)results.get("returnData");
			CommonUtil.outJson(response, json);
		} catch (Exception e) {
			Debug.logError(e, module);
			CommonUtil.outFailureJson(response, e.getMessage());
		}
		
		return null;
		
	}
	
	/**
	 * 加载PartyRelationships
	 * @return
	 * @throws Exception
	 */
	public String executeLoadParyRelationship() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String partyId = request.getParameter("partyId");
		
		Map context = new HashMap();
		context.put("partyId", partyId);
		
		try {
			
			Map results = partyLoaderService.loadParyRelationshipService(context);
			
			if(ServiceUtil.isError(results)){
				CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
				return null;
			}
			
			JSONObject json = (JSONObject)results.get("returnData");
			CommonUtil.outJson(response, json);
		} catch (Exception e) {
			Debug.logError(e, module);
			CommonUtil.outFailureJson(response, e.getMessage());
		}
		
		return null;
	}
	
	/**
	 * 查询上级创建的所有成员
	 * @return
	 * @throws Exception
	 */
	public String executeLoadPartyBy() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		HttpSession session = request.getSession();
		
		UserLogin userLogin = (UserLogin) session.getAttribute("userLogin");
		
		String actionType = request.getParameter("actionType");
		Debug.logInfo("PartyLoaderAction actionType:"+actionType, module);
		
		String roleTypeId = request.getParameter("roleTypeId");
		Debug.logInfo("Load roleTypeId:"+roleTypeId, module);
		
		String partyId = request.getParameter("partyId");
		Debug.logInfo("Load partyId:"+partyId, module);
		
		Map context = new HashMap();
		
		Map results = null;
		
		if(UtilValidate.isNotEmpty(userLogin)){
			context.put("createdByUserLogin", userLogin.getPartyId());
			context.put("usePage", "false");
			results = partyLoaderService.loadPartyService(context);
			
			if(ServiceUtil.isError(results)){
				CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
				return null;
			}
			
			JSONObject json = (JSONObject)results.get("returnData");
			CommonUtil.outJson(response, JSONObject.fromObject(json));
		}
		
		return null;
	}
}
