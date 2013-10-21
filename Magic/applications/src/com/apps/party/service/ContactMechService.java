/**
 * Powered by Chuang.Liu @2011-10-21
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.apps.party.constant.PartyConstant;
import com.apps.party.entitymodel.ContactMech;
import com.apps.party.entitymodel.ContactMechType;
import com.apps.party.entitymodel.Party;
import com.apps.party.entitymodel.PartyContactMech;
import com.apps.party.entitymodel.PartyContactMechId;
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
public class ContactMechService extends BaseService{

	public static final String module = ContactMechService.class.getName();
	
	/**
	 * 创建联系表 参数中传入contactMechId则使用该Id创建ContactMech,否则自动生成contactMechId，并在返回该Id同时返回有该Id生成的contectMech对象。
	 * 输入的参数为空，则创建默认的ContactMech(contactMechId自增，contactMechTypeId=ELECTRONIC_ADDRESS, infoString=ELECTRONIC_ADDRESS)
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createContactMechService(Map context) throws ExecuteServiceException {
		String contactMechId = (String)context.get("contactMechId");
		String contactMechTypeId = (String)context.get("contactMechTypeId");
		String infoString = (String)context.get("infoString");
		
		Map results = ServiceUtil.returnSuccess();
		
		if(UtilValidate.isEmpty(contactMechId)){
			contactMechId = delegator.getNextSeqId("ContactMech");
		}
		
		if(UtilValidate.isEmpty(contactMechTypeId)){
			contactMechTypeId = PartyConstant.CONTACT_MECH_TYPE_ELECTRONIC_ADDRESS;
		}
		
		ContactMech contactMech = new ContactMech();
		Debug.logInfo("createContactMechService for contactMechId["+contactMechId+"]", module);
		Debug.logInfo("createContactMechService contactMech hashcode["+contactMech.hashCode()+"]", module);
		contactMech.setContactMechId(contactMechId);
		contactMech.setContactMechTypeId(contactMechTypeId);
		contactMech.setInfoString(infoString);
		
		try {
			boolean saveResult = delegator.saveEntity(contactMech);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("创建联系表失败");
		}
		
		results.put("contactMech", contactMech);
		results.put("contactMechId", contactMechId);
		return results;
	}
	
	/**
	 * 更新ContactMech
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map updateContactMechService(Map context) throws ExecuteServiceException {
		ContactMech contactMech = (ContactMech) context.get("contactMech");
		
		try {
			
			if(UtilValidate.isNotEmpty(contactMech)){
				delegator.updateEntity(contactMech);
			}else{
				Debug.logError("Update ContactMech failure, because input params is null.", module);
				return ServiceUtil.returnError("更新联系表失败，操作对象不存在");
			}
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("更新联系表失败,操作数据库时出现异常");
		}
		
		Map results = ServiceUtil.returnSuccess();
		return results;
	}
	
	/**
	 * 创建PartyContactMech,如果输入的contactMechId为空自动生成contactMechId
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createPartyContactMechService(Map context) throws ExecuteServiceException {
		Party party = (Party) context.get("party");
		String contactMechId = (String) context.get("contactMechId");
		String contactMechTypeId = (String) context.get("contactMechTypeId");
		String infoString = (String) context.get("infoString");
		
		if(UtilValidate.isEmpty(party)){
			Debug.logError("必输的参数party为空", module);
			return ServiceUtil.returnError("创建成员联系表失败，所需的参数party为空");
		}
		
		Map results = ServiceUtil.returnSuccess();
		
		String partyId = party.getPartyId();
		
		if(UtilValidate.isEmpty(contactMechId)){
			//创建ContactMech,输入的参数为空，则创建默认的ContactMech(contactMechId自增，contactMechTypeId=ELECTRONIC_ADDRESS, infoString=ELECTRONIC_ADDRESS)
			Map contactMechInput = new HashMap();
			//Party与ContactMech为一对多每 一条ContactMech记录需要有一条PartyContactMech,每一条ContactMech都对应自己infoString或者PostalAddress或TelecomNumber
			contactMechInput.put("contactMechTypeId", contactMechTypeId);
			contactMechInput.put("infoString", infoString);
			
			Map contactMechResult = createContactMechService(contactMechInput);
			if(ServiceUtil.isError(contactMechResult)){
				Debug.logError("调用createContactMechService结果错误", module);
				return contactMechResult;
			}
			
			contactMechId = (String) contactMechResult.get("contactMechId");
			ContactMech contactMech = (ContactMech) contactMechResult.get("contactMech");
			results.put("contactMech", contactMech);
		}
		
		ContactMech contactMech = new ContactMech();
		PartyContactMech partyContactMech = new PartyContactMech();
		PartyContactMechId partyContactMechId = new PartyContactMechId();
		partyContactMechId.setPartyId(partyId);
		partyContactMechId.setContactMechId(contactMechId);
		partyContactMechId.setFromDate(new Date());
		partyContactMech.setId(partyContactMechId);
		
		try {
			delegator.saveEntity(partyContactMech);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("创建成员联系表失败,操作数据库时出现异常");
		}
		
		results.put("contactMechId", contactMechId);
		results.put("party", party);
		results.put("partyContactMech", partyContactMech);
		return results;
	}
	
	/**
	 * 加载联系信息 电子邮件 网址
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadContactMechService(Map<Object, Object> context) throws ExecuteServiceException {
		
		String contactMechId = (String)context.get("contactMechId");
//		String contactMechTypeId = (String)context.get("contactMechTypeId");
		String infoString = (String)context.get("infoString");
		
		Map<String, Object> fields = new HashMap<String, Object>();
		fields.put("contactMechId", contactMechId);
//		fields.put("contactMechTypeId", contactMechTypeId);
//		fields.put("infoString", infoString);
		
		List<ContactMech> contactMechs;
		try {
			Debug.logInfo("Find ContactMech by "+fields, module);
			contactMechs = delegator.findByCondition(ContactMech.class, fields);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("查询联系表失败");
		}
		
		Debug.logInfo("Query ContactMech condition:" + fields, module);
		
		JSONArray array = new JSONArray();
		
		for(ContactMech contactMech : contactMechs){
			
			String contactMechIdQ = contactMech.getContactMechId();
			String contactMechTypeId = contactMech.getContactMechTypeId();
			
			if(PartyConstant.CONTACT_MECH_TYPE_POSTAL_ADDRESS.equals(contactMechTypeId) || PartyConstant.CONTACT_MECH_TYPE_TELECOM_NUMBER.equals(contactMechTypeId)){
				continue;
			}
			
			ContactMechType contactMechType;
			try {
				contactMechType = (ContactMechType) delegator.findById(ContactMechType.class, contactMechTypeId);
				if(UtilValidate.isEmpty(contactMechType)){
					Debug.logError("ContactMech " + contactMechIdQ + " type is empty.", module);
					return ServiceUtil.returnError("联系信息无对应类型");
				}
			} catch (GenericEntityException e) {
				Debug.logError(e, module);
				throw new ExecuteServiceException("查询联系表失败");
			}
			array.add(getJsonData(contactMechIdQ, contactMech.getContactMechTypeId(), contactMechType.getDescription(), contactMech.getInfoString()));
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", array.size());
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		
		return returnMap;
	}
	
	/**
	 * 查找PartyId下所有ContactMech信息
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadContactMechByPartyIdService(Map<Object, Object> context) throws ExecuteServiceException {
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
		
		for(PartyContactMech partyContactMech : partyContacts){
			
			String contactMechId = partyContactMech.getId().getContactMechId();
			Debug.logInfo("PartyContactMech mapping partyId["+partyId+"]:contactMechId["+contactMechId+"]", module);
			
			Map inputMap = new HashMap();
			inputMap.put("contactMechId", contactMechId);
			results = this.loadContactMechService(inputMap);
			if(ServiceUtil.isError(results)){
				return results;
			}
			
			JSONObject returnData = (JSONObject) results.get("returnData");
			contactMechArray.addAll((JSONArray)returnData.get("dataset"));
			
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", contactMechArray);
		json.put("totalCount", contactMechArray.size());
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		return returnMap;
	}
	
	/**
	 * 
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadContactMechTypeService(Map<Object, Object> context) throws ExecuteServiceException {
		
		String hasTable = (String) context.get("hasTable");
		
		List<ContactMechType> contactMechTypes;
		try {
			contactMechTypes = delegator.findByProperty(ContactMechType.class, "hasTable", hasTable);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("查询联系信息类型错误，操作数据库时出现异常");
		}
		
		JSONArray contactMechArray = new JSONArray();
		for(ContactMechType contactMechType : contactMechTypes){
			contactMechArray.add(getContactMechTypeJson(contactMechType));
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", contactMechArray);
		json.put("totalCount", contactMechArray.size());
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		return returnMap;
	}
	
	/**
	 * 
	 * @param contactMechId
	 * @param contactMechTypeId
	 * @param infoString
	 * @return
	 */
	private JSONObject getJsonData(String contactMechId, String contactMechTypeId, String contactMechTypeDesc, String infoString){
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("contactMechId", contactMechId);
		jsonData.put("contactMechTypeId", contactMechTypeId);
		jsonData.put("contactMechTypeDesc", contactMechTypeDesc);
		jsonData.put("infoString", infoString);
		
		return jsonData;
	}
	
	/**
	 * 
	 * @param contactMechType
	 * @return
	 */
	private JSONObject getContactMechTypeJson(ContactMechType contactMechType){
		JSONObject jsonData = new JSONObject();
		jsonData.put("contactMechTypeId", contactMechType.getContactMechTypeId());
		jsonData.put("description", contactMechType.getDescription());
		jsonData.put("parentTypeId", contactMechType.getParentTypeId());
		jsonData.put("hasTable", contactMechType.getHasTable());
		return jsonData;
	}
}
