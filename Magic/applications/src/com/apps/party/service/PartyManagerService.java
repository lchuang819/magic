/**
 * Powered by Chuang.Liu @2011-10-18
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apps.party.constant.PartyConstant;
import com.apps.party.entitymodel.ContactMech;
import com.apps.party.entitymodel.Party;
import com.apps.party.entitymodel.PartyContactMech;
import com.apps.party.entitymodel.PartyContactMechId;
import com.apps.party.entitymodel.Person;
import com.apps.party.entitymodel.PostalAddress;
import com.apps.party.entitymodel.TelecomNumber;
import com.frm.security.entitymodel.UserLogin;
import com.frm.webtools.service.UserLoginService;
import com.magic.entity.GenericEntityException;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-10-18
 */
public class PartyManagerService extends BaseService {

	public static final String module = PartyManagerService.class.getName();
	
	@Autowired
	@Qualifier("party")
	private Party party;
	
	@Qualifier("person")
	private Person person;
	
	@Qualifier("partyContactMech")
	private PartyContactMech partyContactMech;
	
	private PartyContactMechId partyContactMechId;
	
	@Qualifier("userLoginService")
	private UserLoginService userLoginService;
	@Qualifier("contactMechService")
	private ContactMechService contactMechService;
	@Qualifier("postalAddressService")
	private PostalAddressService postalAddressService;
	@Qualifier("telecomNumberService")
	private TelecomNumberService telecomNumberService;
	
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
	 * @return the userLoginService
	 */
	public UserLoginService getUserLoginService() {
		return userLoginService;
	}

	/**
	 * @param userLoginService the userLoginService to set
	 */
	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
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
	 * @return the partyContactMech
	 */
	public PartyContactMech getPartyContactMech() {
		return partyContactMech;
	}

	/**
	 * @param partyContactMech the partyContactMech to set
	 */
	public void setPartyContactMech(PartyContactMech partyContactMech) {
		this.partyContactMech = partyContactMech;
	}

	/**
	 * @return the partyContactMechId
	 */
	public PartyContactMechId getPartyContactMechId() {
		return partyContactMechId;
	}

	/**
	 * @param partyContactMechId the partyContactMechId to set
	 */
	public void setPartyContactMechId(PartyContactMechId partyContactMechId) {
		this.partyContactMechId = partyContactMechId;
	}

	/* (non-Javadoc)
	 * @see com.magic.service.IService#execute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 创建Party
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createPartyService(Map context) throws ExecuteServiceException{
		
		Party newParty = new Party();
		try {
			BeanUtils.populate(newParty, context);
		} catch (Exception e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("创建成员失败");
		}
		
		delegator.saveEntity(newParty);
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("party", newParty);
		return returnMap;
	}
	
	/**
	 * 创建公司
	 * @param context
	 * @return Map[Party:organizationParty]
	 * @throws ExecuteServiceException
	 */
	public Map createOrganizationService(Map context) throws ExecuteServiceException {
		
		Party organizationParty = (Party) context.get("organizationParty");
		
		if(UtilValidate.isEmpty(organizationParty)){
			Debug.logError("Input organizationParty is empty.", module);
			return ServiceUtil.returnError("输入参数organizationParty不可用");
		}
		
		String partyId = delegator.getNextSeqId("Party");
		organizationParty.setPartyId(partyId);
		organizationParty.setPartyTypeId(PartyConstant.PARTY_TYPE_CORPORATION);
		organizationParty.setStatusId(PartyConstant.PARTY_STATUS_ENABLED);
		organizationParty.setCreatedDate(new Date());
		
		Map results = ServiceUtil.returnSuccess();
		results.put("organizationParty", organizationParty);
		return results;
	}

	/**
	 * 创建Person实体
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createPersonService(Map context) throws ExecuteServiceException{
		Person newPerson = (Person) context.get("person");
		PostalAddress postalAddress = (PostalAddress) context.get("postalAddress");
		TelecomNumber telecomNumber = (TelecomNumber) context.get("telecomNumber");
		ContactMech contactMech = (ContactMech) context.get("contactMech");
		UserLogin userLogin = (UserLogin) context.get("userLogin");
		
		String partyType = (String) context.get("partyType");
		
		if(UtilValidate.isEmpty(newPerson)){
			Debug.logError("Required input parameters [person]", module);
			return ServiceUtil.returnError("无法创建人员，缺少必要的参数");
		}
		
		String partyId = newPerson.getPartyId();
		if(UtilValidate.isEmpty(partyId)){
			partyId = delegator.getNextSeqId("Party");
		}
		
		//是否为Person创建登陆信息
		String isCreateUserLogin = (String) context.get("isCreateUserLogin");
		
		//创建Party
		Map partyContext = new HashMap();
		partyContext.put("partyId", partyId);
		partyContext.put("partyTypeId", PartyConstant.PARTY_TYPE_PERSON);
		partyContext.put("description", newPerson.getComments());
		partyContext.put("statusId", PartyConstant.PARTY_STATUS_ENABLED);
		
		Debug.logInfo("Start executeCreateParty.", module);
		Map results = this.createPartyService(partyContext);
		if(ServiceUtil.isError(results)){
			Debug.logInfo("Start executeCreateParty error.", module);
			return ServiceUtil.returnError("创建Party成员失败");
//			throw new ExecuteServiceException("创建Party成员失败");
		}
		
		//返回创建的Party实体，后面创建邮政地址，联系电话时需要
		Party party = (Party) results.get("party");
		
		Debug.logInfo("Start save contactMech", module);
		
		String personId = newPerson.getPartyId();
		if(StringUtils.isEmpty(personId)){
			newPerson.setPartyId(partyId);
		}
		
		//创建Person
		try {
			delegator.saveEntity(newPerson);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("创建人员失败");
		}
		
		Map postalInput = new HashMap();
		postalInput.put("postalAddress", postalAddress);
		postalInput.put("party", party);
		
		Map postResults = postalAddressService.createPartyPostalAddressService(postalInput);
		if(ServiceUtil.isError(postResults)){
			return postResults;
		}
		
		Map teleInput = new HashMap();
		teleInput.put("telecomNumber", telecomNumber);
		teleInput.put("party", party);
		
		Map teleResults = telecomNumberService.createPartyTelecomNumberService(teleInput);
		if(ServiceUtil.isError(teleResults)){
			return teleResults;
		}
		
		
		//创建UserLogin
		Map userLoginMap = new HashMap();
		userLoginMap.put("party", party);
		userLoginMap.put("userLogin", userLogin);
		
		if(UtilValidate.isNotEmpty(isCreateUserLogin) && Boolean.valueOf(isCreateUserLogin)){
			Map createUserLoginResults = userLoginService.executeCreateUserLogin(userLoginMap);
			if(ServiceUtil.isError(createUserLoginResults)){
				return results;
			}
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("party", party);
		returnMap.put("person", newPerson);
		return returnMap;
	}
	
	/**
	 * 
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map updatePersonService(Map context) throws ExecuteServiceException{
		person = (Person) context.get("person");
		
		try {
			if(UtilValidate.isNotEmpty(person)){
				delegator.updateEntity(person);
			}
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("更新人员失败");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}
	
}
