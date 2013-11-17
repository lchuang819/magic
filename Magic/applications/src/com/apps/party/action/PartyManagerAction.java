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

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apps.party.constant.PartyActionType;
import com.apps.party.entitymodel.ContactMech;
import com.apps.party.entitymodel.Party;
import com.apps.party.entitymodel.PartyGroup;
import com.apps.party.entitymodel.PartyRelationship;
import com.apps.party.entitymodel.PartyRelationshipId;
import com.apps.party.entitymodel.PartyRole;
import com.apps.party.entitymodel.PartyRoleId;
import com.apps.party.entitymodel.Person;
import com.apps.party.entitymodel.PostalAddress;
import com.apps.party.entitymodel.TelecomNumber;
import com.apps.party.service.ContactMechService;
import com.apps.party.service.PartyManagerService;
import com.apps.party.service.PartyRelationshipService;
import com.apps.party.service.PostalAddressService;
import com.apps.party.service.PartyRoleService;
import com.apps.party.service.TelecomNumberService;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-10-18
 */
public class PartyManagerAction extends ActionSupport {

	public static final String module = PartyLoaderAction.class.getName();
	
	@Autowired
	public Person person;
	
	@Autowired
	@Qualifier("partyRoleId")
	private PartyRoleId partyRoleId;
	
	public PartyRoleId getPartyRoleId() {
		return partyRoleId;
	}

	public void setPartyRoleId(PartyRoleId partyRoleId) {
		this.partyRoleId = partyRoleId;
	}

	private Party party;
	private PartyGroup partyGroup;
	private PostalAddress postalAddress;
	private TelecomNumber telecomNumber;
	private ContactMech contactMech;
	private PartyRelationshipId partyRelationshipId;
	private PartyRelationship partyRelationship;
	
	@Autowired
	private PartyRelationshipService partyRelationshipService;
	
	@Autowired
	private PartyRoleService roleService;
	
	@Qualifier("postalAddressService")
	private PostalAddressService postalAddressService;

	@Qualifier("partyManagerService")
	private PartyManagerService partyManagerService;
	
	@Qualifier("contactMechService")
	private ContactMechService contactMechService;
	
	@Qualifier("telecomNumberService")
	private TelecomNumberService telecomNumberService;
	
	/**
	 * @return the partyRelationshipId
	 */
	public PartyRelationshipId getPartyRelationshipId() {
		return partyRelationshipId;
	}

	/**
	 * @param partyRelationshipId the partyRelationshipId to set
	 */
	public void setPartyRelationshipId(PartyRelationshipId partyRelationshipId) {
		this.partyRelationshipId = partyRelationshipId;
	}

	/**
	 * @return the partyRelationship
	 */
	public PartyRelationship getPartyRelationship() {
		return partyRelationship;
	}

	/**
	 * @param partyRelationship the partyRelationship to set
	 */
	public void setPartyRelationship(PartyRelationship partyRelationship) {
		this.partyRelationship = partyRelationship;
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
	 * @return the partyManagerService
	 */
	public PartyManagerService getPartyManagerService() {
		return partyManagerService;
	}

	/**
	 * @param partyManagerService the partyManagerService to set
	 */
	public void setPartyManagerService(PartyManagerService partyManagerService) {
		this.partyManagerService = partyManagerService;
	}

	/**
	 * @return the telecomNumber
	 */
	public TelecomNumber getTelecomNumber() {
		return telecomNumber;
	}

	/**
	 * @param telecomNumber the telecomNumber to set
	 */
	public void setTelecomNumber(TelecomNumber telecomNumber) {
		this.telecomNumber = telecomNumber;
	}

	/**
	 * @return the contactMech
	 */
	public ContactMech getContactMech() {
		return contactMech;
	}

	/**
	 * @param contactMech the contactMech to set
	 */
	public void setContactMech(ContactMech contactMech) {
		this.contactMech = contactMech;
	}

	/**
	 * @return the postalAddress
	 */
	public PostalAddress getPostalAddress() {
		return postalAddress;
	}

	/**
	 * @param postalAddress the postalAddress to set
	 */
	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}

	/**
	 * @return the party
	 */
	public Party getParty() {
		return party;
	}

	/**
	 * @param party the party to set
	 */
	public void setParty(Party party) {
		this.party = party;
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
		String actionType = request.getParameter("actionType");
		String partyType = request.getParameter("partyType");
		String roleTypeId = request.getParameter("partyRoleId.roleTypeId");
		Debug.logInfo("actionType:"+actionType, module);
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("person", person);
		context.put("partyType", partyType);
		context.put("postalAddress", postalAddress);
		context.put("telecomNumber", telecomNumber);
		context.put("contactMech", contactMech);
		context.put("partyRoleId", partyRoleId);
		
		Map results = null;
		try {
			
			//创建人员
			if(PartyActionType.NEW_PERSON.equals(actionType)){
				
				results = partyManagerService.createPersonService(context);
			}else if(PartyActionType.UPDATE_PERSON.equals(actionType)){
				//更新人员
				context.put("person", person);
				results = partyManagerService.updatePersonService(context);
				
			}else if(PartyActionType.CREATE_CONTACTMECH.equals(actionType)){
				//创建Party的ContactMech 如电子邮件地址 网址
				context.put("party", party);
				context.putAll(BeanUtils.describe(contactMech));
				results = contactMechService.createPartyContactMechService(context);
				
			}else if(PartyActionType.UPDATE_CONTACTMECH.equals(actionType)){
				//更新Party的ContactMech
				context.put("contactMech", contactMech);
				results = contactMechService.updateContactMechService(context);
				
			}else if(PartyActionType.CREATE_TELECOM_NUMBER.equals(actionType)){
				//创建Party的TelecomNumber
				context.put("party", party);
				context.put("telecomNumber", telecomNumber);
				results = telecomNumberService.createPartyTelecomNumberService(context);
				
			}else if(PartyActionType.UPDATE_TELECOM_NUMBER.equals(actionType)){
				//更新Party的TelecomNumber
				context.put("party", party);
				context.put("telecomNumber", telecomNumber);
				results = telecomNumberService.updateTelecomNumberService(context);
			
			}else if(PartyActionType.CREATE_POSTAL_ADDRESS.equals(actionType)){
				//创建Party的PostalAddress
				context.put("party", party);
				context.put("postalAddress", postalAddress);
				results = postalAddressService.createPartyPostalAddressService(context);
				
			}else if(PartyActionType.UPDATE_POSTAL_ADDRESS.equals(actionType)){
				//更新Party的PostalAddress
				Debug.logInfo("Execute UPDATE_POSTAL_ADDRESS service.", module);
				context.put("postalAddress", postalAddress);
				results = postalAddressService.updatePartyPostalAddressService(context);
			}else if(PartyActionType.UPDATE_PARTY_GROUP.equals(actionType)){
				Debug.logInfo("Execute UPDATE_PARTY_GROUP service.", module);
			}
			
			if(ServiceUtil.isError(results)){
				
				Debug.logError("Execute actionType error:"+ServiceUtil.getErrorMessage(results), module);
				CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
				return null;
			}
		} catch (Exception e) {
			Debug.logError(e, module);
			CommonUtil.outFailureJson(response, "创建成员时出现异常:"+e.getMessage());
			return null;
		}
		
		JSONObject responseData = JSONObject.fromObject(results);
		Debug.logInfo("Response Data:" + responseData, module);
		CommonUtil.outSuccessJson(response, "操作成功", responseData);
		return null;
	}
	
	/**
	 * PartyRole Manager
	 * @return
	 * @throws Exception
	 */
	public String executePartyRoleManager() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String actionType = request.getParameter("actionType");
		Debug.logInfo("executePartyRoleManager actionType:"+actionType, module);
		
		String partyId = request.getParameter("partyId");
		String roleTypeId = request.getParameter("roleTypeId");
		
		Map context = new HashMap();
		context.put("partyId", partyId);
		context.put("roleTypeId", roleTypeId);
		context.put("partyRoleId", partyRoleId);
		
		Map results = null;
		
		if(PartyActionType.CREATE_PARTY_ROLE.equals(actionType)){
			
			results = roleService.createPartyRoleService(context);
			
		}else if(PartyActionType.DELETE_PARTY_ROLE.equals(actionType)){
			
			results = roleService.deletePartyRoleService(context);
			
		}
		
		if(ServiceUtil.isError(results)){
			Debug.logError("Execute actionType error:"+ServiceUtil.getErrorMessage(results), module);
			CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
			return null;
		}
		
		CommonUtil.outSuccessJson(response, "操作成功");
		return null;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String executeParyRelationshipManager() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String actionType = request.getParameter("actionType");
		Debug.logInfo("executePartyRoleManager actionType:"+actionType, module);
		
		String partyIdFrom = request.getParameter("partyIdFrom");
		String partyIdTo = request.getParameter("partyIdTo");
		String roleTypeIdFrom = request.getParameter("roleTypeIdFrom");
		String roleTypeIdTo = request.getParameter("roleTypeIdTo");
		String fromDate = request.getParameter("fromDate");
		
		Map context = new HashMap();
		
		Map results = null;
		
		if(PartyActionType.DELETE_PARTY_RELATIONSHIP.equals(actionType)){
			
			context.put("partyIdFrom", partyIdFrom);
			context.put("partyIdTo", partyIdTo);
			context.put("roleTypeIdFrom", roleTypeIdFrom);
			context.put("roleTypeIdTo", roleTypeIdTo);
			context.put("fromDate", fromDate);
			results = partyRelationshipService.deletePartyRelationshipService(context);
			
		}else if(PartyActionType.CREATE_PARTY_RELATIONSHIP.equals(actionType)){
			
			context.put("partyRelationship", partyRelationship);
			context.put("partyRelationshipId", partyRelationshipId);
			results = partyRelationshipService.createPartyRelationshipService(context);
			
		}
		
		if(ServiceUtil.isError(results)){
			Debug.logError("Execute actionType error:"+ServiceUtil.getErrorMessage(results), module);
			CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
			return null;
		}
		
		CommonUtil.outSuccessJson(response, "操作成功");
		return null;
	}
}
