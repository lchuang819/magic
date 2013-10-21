/**
 * Powered by Chuang.Liu @2011-11-18
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.facility.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;

import com.apps.facility.entitymodel.Facility;
import com.apps.facility.entitymodel.FacilityParty;
import com.apps.facility.entitymodel.FacilityPartyId;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-11-18
 */
public class FacilityService extends BaseService {

	public final static String module = FacilityService.class.getName();
	
	/**
	 * 创建设施
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createFacilityService(Map context) throws ExecuteServiceException{
		
		Facility facility = (Facility) context.get("facility");
		
		if(UtilValidate.isEmpty(facility) || UtilValidate.isEmpty(facility.getFacilityId())){
			Debug.logError("Input params facility is invalid.", module);
			return ServiceUtil.returnError("创建失败，服务参数错误");
		}
		
		delegator.saveEntity(facility);
		
		Map result = ServiceUtil.returnSuccess();
		return result;
	}
	
	/**
	 * 更新设施
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map updateFacilityService(Map context) throws ExecuteServiceException{
		
		Facility facility = (Facility) context.get("facility");
		
		if(UtilValidate.isEmpty(facility) || UtilValidate.isEmpty(facility.getFacilityId())){
			Debug.logError("Input params facility is invalid.", module);
			return ServiceUtil.returnError("更新失败，服务参数错误");
		}
		
		delegator.updateEntity(facility);
		
		Map result = ServiceUtil.returnSuccess();
		return result;
	}
	
	/**
	 * 删除设施
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map deleteFacilityService(Map context) throws ExecuteServiceException{
		
		Facility facility = (Facility) context.get("facility");
		
		if(UtilValidate.isEmpty(facility) || UtilValidate.isEmpty(facility.getFacilityId())){
			Debug.logError("Input params facility is invalid.", module);
			return ServiceUtil.returnError("更新失败，服务参数错误");
		}
		
		delegator.deleteEntity(facility);
		
		Map result = ServiceUtil.returnSuccess();
		return result;
	}
	
	/**
	 * 加载facility信息
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadFacilityService(Map context) throws ExecuteServiceException{
		
		String facilityType = (String) context.get("facilityType");
		
		Map fields = new HashMap();
		if(UtilValidate.isNotEmpty(facilityType)){
			fields.put("facilityTypeId", facilityType);
		}
		
		Debug.logInfo("Find facility by fields:" + fields, module);
		List<Facility> facilities = delegator.findByCondition(Facility.class, fields);
//		List<Facility> facilities = delegator.findByProperty(Facility.class, "facilityTypeId", facilityType);
//		List<Facility> facilities = delegator.findAll(Facility.class);
		Debug.logInfo("Find facility count:" + facilities.size(), module);
		
		JSONArray array = new JSONArray();
		
		try {
			for(Facility facility : facilities){
				array.add(BeanUtils.describe(facility));
			}
		} catch (Exception e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("describe facility bean exception.", e);
		} 
		
		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", array.size());
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		return returnMap;
	}
	
	private JSONObject describeFacility(Facility facility){
		
		
		return null;
	}
	
	/**
	 * 加载facilityParties信息
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadFacilityPartiesService(Map context) throws ExecuteServiceException{
		
		String facilityId = (String) context.get("facilityId");
		
		if(UtilValidate.isEmpty(facilityId)){
			return ServiceUtil.returnError("输入的参数为空");
		}
		
		List<FacilityParty> facilityParties = delegator.findByProperty(FacilityParty.class, "id.facilityId", facilityId);
		
		JSONArray array = new JSONArray();
		
		try {
			
			for(FacilityParty facilityParty : facilityParties){
				FacilityPartyId id = facilityParty.getId();
				
				Map idm = BeanUtils.describe(id);
				idm.put("thruDate", facilityParty.getThruDate());
				array.add(idm);
			}
		} catch (Exception e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("describe facility bean exception.", e);
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", array.size());
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		return returnMap;
	}
}
