/**
 * Powered by Chuang.Liu @2011-10-21
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apps.party.constant.PartyConstant;
import com.apps.party.entitymodel.ContactMech;
import com.apps.party.entitymodel.Party;
import com.apps.party.entitymodel.PartyContactMech;
import com.apps.party.entitymodel.PostalAddress;
import com.apps.party.entitymodel.TelecomNumber;
import com.magic.entity.GenericEntityException;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;
import com.magic.util.hibernate.SequenceUtil;

/**
 * @author lchuang
 * @2011-10-21
 */
public class TelecomNumberService extends BaseService  {

	public static final String module = TelecomNumberService.class.getName();
	
	@Autowired
	@Qualifier("contactMech")
	private ContactMech contactMech;
	@Qualifier("contactMechService")
	private ContactMechService contactMechService;
	@Autowired
	private PartyManagerService partyManagerService;
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

	/* (non-Javadoc)
	 * @see com.magic.service.IService#execute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 创建Telecom
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createTelecomNumberService(Map context)throws ExecuteServiceException {
		
		TelecomNumber telecomNumber = (TelecomNumber) context.get("telecomNumber");
		
		if(UtilValidate.isEmpty(telecomNumber)){
			Debug.logError("必须的参数telecomNumber为空", module);
			return ServiceUtil.returnError("必须的参数telecomNumber为空");
		}
		
		Map contactMechInput = new HashMap();
		contactMechInput.put("contactMechTypeId", PartyConstant.CONTACT_MECH_TYPE_TELECOM_NUMBER);
		
		Map contactMechResult = contactMechService.createContactMechService(contactMechInput);
		if(ServiceUtil.isError(contactMechResult)){
			Debug.logError("创建PostalAddress时出现错误，未能创建ContactMech", module);
			return ServiceUtil.returnError("创建PostalAddress时出现错误，未能创建ContactMech");
		}
		
		String contactMechId = (String) contactMechResult.get("contactMechId");
		ContactMech contactMech = (ContactMech) contactMechResult.get("contactMech");
		
		try {
			
			telecomNumber.setContactMechId(contactMechId);
			delegator.saveEntity(telecomNumber);
			
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("创建邮政地址失败,出现了数据库异常");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("contactMechId", contactMechId);
		returnMap.put("contactMech", contactMech);
		returnMap.put("telecomNumber", telecomNumber);
		return returnMap;
	}
	
	/**
	 * 创建Party的TelecomNumber
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createPartyTelecomNumberService(Map context)throws ExecuteServiceException {
		Debug.logInfo("Start Run createPartyTelecomNumberService", module);
		TelecomNumber telecomNumber = (TelecomNumber) context.get("telecomNumber");
		Party party = (Party) context.get("party");
		
		Map postalInput = new HashMap();
		postalInput.put("telecomNumber", telecomNumber);
		
		Map postalResult = createTelecomNumberService(postalInput);
		if(ServiceUtil.isError(postalResult)){
			Debug.logError("创建PartyTelecomNumber时出现错误，未能创建telecomNumber", module);
			return ServiceUtil.returnError("创建PartyTelecomNumber时出现错误，未能创建telecomNumber");
		}
		
		String contactMechId = (String) postalResult.get("contactMechId");
		
		Map partyManagerInput = new HashMap();
		partyManagerInput.put("party", party);
		partyManagerInput.put("contactMechId", contactMechId);
		
		Map partyManagerResult = contactMechService.createPartyContactMechService(partyManagerInput);
		if(ServiceUtil.isError(partyManagerResult)){
			Debug.logError("创建PartyTelecomNumber时出现错误，未能创建telecomNumber", module);
			return ServiceUtil.returnError("创建PartyTelecomNumber时出现错误，未能创建telecomNumber");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("contactMechId", contactMechId);
		returnMap.put("telecomNumber", telecomNumber);
		returnMap.put("party", party);
		return returnMap;
	}

	/**
	 * 更新联系电话
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map updateTelecomNumberService(Map context)throws ExecuteServiceException{
		
		TelecomNumber newTelecomNumber = (TelecomNumber) context.get("telecomNumber");
		
		try {
			delegator.updateEntity(newTelecomNumber);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("更新联系电话失败，出现数据库错误。");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}
	
	/**
	 * 查询Telecom
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadTelecomNumberService(Map context)throws ExecuteServiceException{
		String contactMechId = (String)context.get("contactMechId");
		
		List<TelecomNumber> telecomNumbers = null;
		try {
			telecomNumbers = delegator.findByProperty(TelecomNumber.class, "contactMechId", contactMechId);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("查询联系电话失败");
		}
		
		JSONArray array = new JSONArray();
		for(TelecomNumber telecomNumber : telecomNumbers){
			
			array.add(getJsonData(telecomNumber));
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", array.size());
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		
		return returnMap;
	}
	
	/**
	 * 通过PartyId查询TelecomNumber
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadTelecomNumberByPartyIdService(Map context)throws ExecuteServiceException{
		String partyId = (String) context.get("partyId");
		if(UtilValidate.isEmpty(partyId)){
			Debug.logError("Find contactMech by partyId is empty.", module);
			return ServiceUtil.returnError("查询联系信息时的成员标识为空");
		}
		
		Map results = null;
		
		List<PartyContactMech> partyContacts;
		try {
			Debug.logInfo("Find PartyContactMech by partyId:"+partyId, module);
			partyContacts = delegator.findByProperty(PartyContactMech.class, "id.partyId", partyId);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("查询成员联系信息错误");
		}
		
		JSONArray contactMechArray = new JSONArray();
		
		try {
			for(PartyContactMech partyContactMech : partyContacts){
				
				String contactMechId = partyContactMech.getId().getContactMechId();
				Debug.logInfo("PartyContactMech mapping partyId["+partyId+"]:contactMechId["+contactMechId+"]", module);
				
				Map fields = new HashMap();
				fields.put("contactMechId", "contactMechId");
				fields.put("contactMechTypeId", PartyConstant.CONTACT_MECH_TYPE_TELECOM_NUMBER);
				List contactMechs = (List) delegator.findByCondition(ContactMech.class, fields);
				if(UtilValidate.isEmpty(contactMechs)){
					Debug.logWarning("contactMechId["+contactMechId+"] is in PartyContactMech, but not in ContactMech", module);
				}
				
				Map inputMap = new HashMap();
				inputMap.put("contactMechId", contactMechId);
				results = this.loadTelecomNumberService(inputMap);
				if(ServiceUtil.isError(results)){
					return results;
				}
				
				JSONObject returnData = (JSONObject) results.get("returnData");
				contactMechArray.addAll((JSONArray)returnData.get("dataset"));
				
			}
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("查询联系信息错误");
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", contactMechArray);
		json.put("totalCount", contactMechArray.size());
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		return returnMap;
	}
	
	private JSONObject getJsonData(TelecomNumber telecomNumber){
		JSONObject jsonData = new JSONObject();
		jsonData.put("contactMechId", telecomNumber.getContactMechId());
		jsonData.put("countryCode", telecomNumber.getCountryCode());
		jsonData.put("areaCode", telecomNumber.getAreaCode());
		jsonData.put("contactNumber", telecomNumber.getContactNumber());
		jsonData.put("askForName", telecomNumber.getAskForName());
		return jsonData;
	}
}
