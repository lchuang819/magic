/**
 * Powered by Chuang.Liu @2011-10-17
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.apps.party.constant.PartyConstant;
import com.apps.party.entitymodel.Party;
import com.apps.party.entitymodel.PartyGroup;
import com.apps.party.entitymodel.PartyRelationship;
import com.apps.party.entitymodel.PartyRelationshipId;
import com.apps.party.entitymodel.PartyRelationshipType;
import com.apps.party.entitymodel.PartyRole;
import com.apps.party.entitymodel.PartyRoleId;
import com.apps.party.entitymodel.PartyType;
import com.apps.party.entitymodel.Person;
import com.apps.party.entitymodel.RoleType;
import com.apps.product.entitymodel.Product;
import com.magic.entity.GenericEntityException;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilDateTime;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-10-17
 */
public class PartyLoaderService extends BaseService{

	public static final String module = PartyLoaderService.class.getName();
	/* (non-Javadoc)
	 * @see com.magic.service.IService#execute(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map execute(Map context) throws ExecuteServiceException {

		return null;
	}
	
	/**
	 * 默认分页加载Party信息
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadPartyService(Map context) throws ExecuteServiceException {
		
		String statusId = (String) context.get("statusId");
		String partyId = (String) context.get("partyId");
		String limit = (String)context.get("limit");
		String sort = (String)context.get("sort");
		String start = (String)context.get("start");
		String dir = (String)context.get("dir");
		String callback = (String)context.get("callback");
		String _dc = (String)context.get("_dc");
		
		Map filterMap = (Map)context.get("filterMap");
		
		String createdByUserLogin = (String)context.get("createdByUserLogin");
		String partyTypeId = (String)context.get("partyTypeId");
		
		String usePage = (String)context.get("usePage");
		
		boolean isUsePage = true;
		if(UtilValidate.isNotEmpty(usePage)){
			isUsePage = Boolean.valueOf(usePage);
		}
		
		Debug.logInfo("limit:"+limit, module);
		Debug.logInfo("sort:"+sort, module);
		Debug.logInfo("start:"+start, module);
		Debug.logInfo("dir:"+dir, module);
		Debug.logInfo("callback:"+callback, module);
		Debug.logInfo("_dc:"+_dc, module);
		
		Map fields = new HashMap();
		if(UtilValidate.isNotEmpty(statusId)){
			fields.put("statusId", statusId);
		}
		if(UtilValidate.isNotEmpty(partyId)){
			fields.put("partyId", partyId);
		}
		if(UtilValidate.isNotEmpty(createdByUserLogin)){
			fields.put("createdByUserLogin", createdByUserLogin);
		}
		if(UtilValidate.isNotEmpty(partyTypeId)){
			fields.put("partyTypeId", partyTypeId);
		}
		
		if(UtilValidate.isNotEmpty(filterMap)){
			fields.putAll(filterMap);
		}
		
		List<Party> partys;
		try {
			Debug.logInfo("Find Party by condition " + fields, module);
			if(isUsePage){
				partys = delegator.findListForPage(Party.class, fields, start, limit, sort, dir);
			}else{
				partys = delegator.findByCondition(Party.class, fields);
			}
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("创建成员失败");
		}
		
		JSONArray array = new JSONArray();
		for(Party party : partys){
			String partyIdQuery = party.getPartyId();
			String partyTypeIdQuery = party.getPartyTypeId();
			
			PartyType partyType = null;
			try {
				partyType = (PartyType) delegator.findById(PartyType.class, partyTypeIdQuery);
			} catch (GenericEntityException e) {
				Debug.logError(e, module);
				throw new ExecuteServiceException("查询成员类型失败");
			}
			
			if(partyType == null){
				continue;
			}
			
			String partyTypeDescription = partyType.getDescription();
			
			Debug.logInfo("partyId:"+partyIdQuery + ", party type is " + partyTypeIdQuery, module);
				
			if(PartyConstant.PARTY_TYPE_PERSON.equals(partyTypeIdQuery)){
				
				Person person = null;
				try {
					person = (Person) delegator.findById(Person.class, partyIdQuery);
				} catch (GenericEntityException e) {
					Debug.logError(e, module);
					throw new ExecuteServiceException("查询人员失败");
				}
				
				if(person == null){
					continue;
				}
				
				Debug.logInfo("add person " + partyIdQuery, module);
				array.add(getPersonJsonData(party, person, partyType));
				
			}else if(PartyConstant.PARTY_TYPE_PARTY_GROUP.equals(partyTypeIdQuery)){
				
				PartyGroup partyGroup = null;
				try {
					partyGroup = (PartyGroup)delegator.findById(PartyGroup.class, partyIdQuery);
				} catch (GenericEntityException e) {
					Debug.logError(e, module);
					throw new ExecuteServiceException("查询成员组失败");
				}
				
				
				array.add(getPartyGroupJsonData(party, partyGroup, partyType));
				
			}
			
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", delegator.getRecordCount(Party.class));
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		returnMap.put("partys", array);
		return returnMap;
	}
	
	public Map executeLoadByRoleType(Map context) throws ExecuteServiceException {
//		PartyRole partyRole = (PartyRole)context.get("partyRole");
		String roleTypeId = (String)context.get("roleTypeId");
//		String roleTypeId = partyRole.getId().getRoleTypeId();
		List<PartyRole> partyRoles = null;
		try {
			partyRoles = delegator.findByProperty(PartyRole.class, "id.roleTypeId", roleTypeId);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("查询成员角色失败");
		}
		
		if(UtilValidate.isEmpty(roleTypeId)){
			
		}
		
		JSONArray array = new JSONArray();
		for(PartyRole role : partyRoles){
			String partyId = role.getId().getPartyId();
			Debug.logInfo("partyRoles partyId:"+partyId, module);
				
			Person person = null;
			PartyGroup partyGroup = null;
			Party party = null;
			
			try {
//				party = (Party) delegator.findById(Party.class, partyId);
				Map queryMap = new HashMap();
				queryMap.put("partyId", partyId);
				queryMap.put("statusId", PartyConstant.PARTY_STATUS_ENABLED);
				
				List<Party> parties = delegator.findByCondition(Party.class, queryMap);
				if(CollectionUtils.isEmpty(parties)){
					continue;
				}
				
				party = parties.get(0);
				
				String partyType = null;
				
				if(party != null){
					partyType = party.getPartyTypeId();
				}
				
				if(PartyConstant.PARTY_TYPE_PERSON.equals(partyType)){
					
					person = (Person) delegator.findById(Person.class, partyId);
					
					if(person == null){
						continue;
					}
					
					String partyName = person.getFirstName();
					
					Map personMap = BeanUtils.describe(person);
					
					JSONObject jsonData = JSONObject.fromObject(personMap);
					jsonData.put("roleTypeId", role.getId().getRoleTypeId());
					array.add(jsonData);
					
				}else if(PartyConstant.PARTY_TYPE_PARTY_GROUP.equals(partyType)){
					
					partyGroup = (PartyGroup) delegator.findById(PartyGroup.class, partyId);
					
				}else if(PartyConstant.PARTY_TYPE_CORPORATION.equals(partyType)){
					partyGroup = (PartyGroup) delegator.findById(PartyGroup.class, partyId);
					
					Map personMap = BeanUtils.describe(partyGroup);
					JSONObject jsonData = JSONObject.fromObject(personMap);
					jsonData.put("roleTypeId", role.getId().getRoleTypeId());
					array.add(jsonData);
					
				}
			} catch (GenericEntityException e) {
				Debug.logError(e, module);
				throw new ExecuteServiceException("查询人员失败");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", array.size());
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		returnMap.put("partyList", array);
		return returnMap;
	}
	
	/**
	 * 'partyId', 'personTitle', 'partyName', 'lastName', 'partyTypeId', 'partyTypeDescription'
	 * @param party
	 * @param personData
	 * @param partyType
	 * @return
	 */
	private JSONObject getPersonJsonData(Party party, Person personData, PartyType partyType){
		JSONObject jsonData = new JSONObject();
		jsonData.put("partyId", party.getPartyId());
		jsonData.put("personalTitle", personData.getPersonalTitle());
		jsonData.put("firstName", personData.getFirstName());
		jsonData.put("lastName", personData.getLastName());
		jsonData.put("partyTypeId", party.getPartyTypeId());
		jsonData.put("partyTypeDescription", partyType.getDescription());
		jsonData.put("comments", personData.getComments());
		return jsonData;
	}
	
	/**
	 * 'partyId', 'personTitle', 'partyName', 'lastName', 'partyTypeId', 'partyTypeDescription'
	 * @param party
	 * @param partyGroup
	 * @param partyType
	 * @return
	 */
	private JSONObject getPartyGroupJsonData(Party party, PartyGroup partyGroup, PartyType partyType){
		JSONObject jsonData = new JSONObject();
		jsonData.put("partyId", party.getPartyId());
		jsonData.put("firstName", partyGroup.getGroupName());
		jsonData.put("lastName", "");
		jsonData.put("partyTypeId", party.getPartyTypeId());
		jsonData.put("partyTypeDescription", partyType.getDescription());
		jsonData.put("comments", partyGroup.getComments());
		return jsonData;
	}
	
	/**
	 * 加载PartyRole
	 * @param context:{partyId}
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadPartyRoleService(Map context) throws ExecuteServiceException {
		String partyId = (String) context.get("partyId");
		
		Map fields = new HashMap();
		if(UtilValidate.isNotEmpty(partyId)){
			fields.put("id.partyId", partyId);
		}
		
		
		JSONArray array = new JSONArray();
		
		try {
			
			List<PartyRole> partyRoles = delegator.findByCondition(PartyRole.class, fields);
			for(PartyRole partyRole : partyRoles){
				PartyRoleId id = partyRole.getId();
				Map partyRoleMap = BeanUtils.describe(id);
				String roleTypeId = id.getRoleTypeId();
				
				RoleType roleType = delegator.findById(RoleType.class, roleTypeId);
				if(UtilValidate.isNotEmpty(roleType)){
					partyRoleMap.put("description", roleType.getDescription());
				}
				
				array.add(partyRoleMap);
			}
		} catch (Exception e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("Bean转换异常", e);
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", array.size());
		Debug.logInfo("Get partyRole count:" + array.size(), module);
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		return returnMap;
	}
	
	/**
	 * 加载PartyRole
	 * @param context:{partyId}
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadRoleTypeService(Map context) throws ExecuteServiceException {
		JSONArray array = new JSONArray();
		
		List<RoleType> roleTypes = delegator.findAll(RoleType.class);
		
		try {
			
			for(RoleType roleType : roleTypes){
				array.add(BeanUtils.describe(roleType));
			}
		} catch (Exception e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("Bean转换异常", e);
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", array.size());
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		return returnMap;
	}
	
	/**
	 * 加载Relationship
	 * @param context:{partyId}
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadParyRelationshipService(Map context) throws ExecuteServiceException {
		
		String partyId = (String) context.get("partyId");
		
		JSONArray array = new JSONArray();
		
		List<PartyRelationship> partyRelationships = delegator.findByProperty(PartyRelationship.class, "id.partyIdFrom", partyId);
		
		try {
			
			for(PartyRelationship partyRelationship : partyRelationships){
				
				PartyRelationshipId id = partyRelationship.getId();
				
				Map partyRelationshipMap = BeanUtils.describe(id);
				partyRelationshipMap.put("fromDate", UtilDateTime.toDateString(id.getFromDate(), "yyyy/MM/dd HH:mm:ss"));

				String roleTypeIdFrom = id.getRoleTypeIdFrom();
				String roleTypeIdTo = id.getRoleTypeIdTo();
				
				RoleType roleTypeIdFromType = delegator.findById(RoleType.class, roleTypeIdFrom);
				String roleTypeIdFromDesc = roleTypeIdFromType.getDescription();
				partyRelationshipMap.put("roleTypeIdFromDesc", roleTypeIdFromDesc);
				
				
				RoleType roleTypeIdToType = delegator.findById(RoleType.class, roleTypeIdTo);
				String roleTypeIdToDesc = roleTypeIdToType.getDescription();
				partyRelationshipMap.put("roleTypeIdToDesc", roleTypeIdToDesc);
				
				String partyRelationshipTypeId = partyRelationship.getPartyRelationshipTypeId();
				if(UtilValidate.isNotEmpty(partyRelationshipTypeId)){
					
					PartyRelationshipType partyRelationshipType = delegator.findById(PartyRelationshipType.class, partyRelationshipTypeId);
					partyRelationshipMap.put("partyRelationshipTypeId", partyRelationshipTypeId);
					partyRelationshipMap.put("partyRelationshipTypeDesc", partyRelationshipType.getDescription());
				}
				
				array.add(partyRelationshipMap);
					
			}
		} catch (Exception e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("加载成员关系异常", e);
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", array.size());
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		return returnMap;
	}
	

}
