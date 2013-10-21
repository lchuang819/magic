/**
 * Powered by Chuang.Liu @2011-10-21
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.apps.party.constant.PartyConstant;
import com.apps.party.entitymodel.ContactMech;
import com.apps.party.entitymodel.Party;
import com.apps.party.entitymodel.PartyContactMech;
import com.apps.party.entitymodel.PostalAddress;
import com.magic.entity.GenericEntityException;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-10-21
 */
public class PostalAddressService extends BaseService{

	public static final String module = PostalAddressService.class.getName();
	
	@Autowired
	private PostalAddress postalAddress;
	@Autowired
	private ContactMechService contactMechService;
	@Autowired
	private PartyManagerService partyManagerService;

	/**
	 * PostalAddress与ContactMech为一对一
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createPostalAddressService(Map context) throws ExecuteServiceException {
		PostalAddress newPostalAddress = (PostalAddress) context.get("postalAddress");
		
		Map contactMechInput = new HashMap();
//		contactMechInput.put("contactMechId", "");
		contactMechInput.put("contactMechTypeId", PartyConstant.CONTACT_MECH_TYPE_POSTAL_ADDRESS);
		
		Map contactMechResult = contactMechService.createContactMechService(contactMechInput);
		if(ServiceUtil.isError(contactMechResult)){
			Debug.logError("创建PostalAddress时出现错误，未能创建ContactMech", module);
			return ServiceUtil.returnError("创建PostalAddress时出现错误，未能创建ContactMech");
		}
		
		String contactMechId = (String) contactMechResult.get("contactMechId");
		ContactMech contactMech = (ContactMech) contactMechResult.get("contactMech");
		
		try {
			
			postalAddress.setContactMechId(contactMechId);
			delegator.saveEntity(postalAddress);
			
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("创建邮政地址失败,出现了数据库异常");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("contactMechId", contactMechId);
		returnMap.put("contactMech", contactMech);
		returnMap.put("postalAddress", newPostalAddress);
		return returnMap;
	}
	
	/**
	 * 创建Party的邮政地址，先创建PostalAddress然后返回ContactMechId，与PartyId一起创建PartyContactMech
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createPartyPostalAddressService(Map context) throws ExecuteServiceException {
		Debug.logInfo("Start Run createPartyPostalAddressService", module);
		PostalAddress newPostalAddress = (PostalAddress) context.get("postalAddress");
		Party party = (Party) context.get("party");
		
		Map postalInput = new HashMap();
		postalInput.put("postalAddress", newPostalAddress);
		
		Map postalResult = createPostalAddressService(postalInput);
		if(ServiceUtil.isError(postalResult)){
			Debug.logError("创建PartyPostalAddress时出现错误，未能创建PostalAddress", module);
			return ServiceUtil.returnError("创建PartyPostalAddress时出现错误，未能创建PostalAddress");
		}
		
		String contactMechId = (String) postalResult.get("contactMechId");
		
		Map partyManagerInput = new HashMap();
		partyManagerInput.put("party", party);
		partyManagerInput.put("contactMechId", contactMechId);
		
		Map partyManagerResult = contactMechService.createPartyContactMechService(partyManagerInput);
		if(ServiceUtil.isError(partyManagerResult)){
			Debug.logError("创建PartyPostalAddress时出现错误，未能创建PartyContactMech", module);
			return ServiceUtil.returnError("创建PartyPostalAddress时出现错误，未能创建PartyContactMech");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("contactMechId", contactMechId);
		returnMap.put("postalAddress", postalAddress);
		returnMap.put("party", party);
		return returnMap;
	}
	
	public Map updatePartyPostalAddressService(Map context) throws ExecuteServiceException {
		PostalAddress newPostalAddress = (PostalAddress) context.get("postalAddress");
		
		try {
			delegator.updateEntity(newPostalAddress);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("更新邮政地址失败，出现数据库异常");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}

	public Map executeLoadPartyPostalAddress(Map context) throws ExecuteServiceException {
		
		String partyId = (String)context.get("partyId");
		String contactMechId = (String)context.get("contactMechId");
		
		List<PostalAddress> postalAddresses = new ArrayList();
		
		
		try {
			if(UtilValidate.isNotEmpty(partyId)){
				
				List<PartyContactMech> partyContactMechs = delegator.findByProperty(PartyContactMech.class, "id.partyId", partyId);
				for(PartyContactMech partyContactMech: partyContactMechs){
					
					List postals = getAllPostalAddress(partyContactMech.getId().getContactMechId());
					if(UtilValidate.isNotEmpty(postals)){
						
						postalAddresses.addAll(postals);
					}
				}
			}else{
				postalAddresses = getAllPostalAddress(contactMechId);
			}
			
			
			
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("查询邮政地址失败");
		}
		
		JSONArray array = new JSONArray();
		for(PostalAddress postal : postalAddresses){
			
			array.add(getJsonData(postal));
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", array.size());
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		return returnMap;
	}
	
	private JSONObject getJsonData(PostalAddress postalAddress){
		JSONObject jsonData = new JSONObject();
		jsonData.put("contactMechId", postalAddress.getContactMechId());
		jsonData.put("toName", postalAddress.getToName());
		jsonData.put("attnName", postalAddress.getAttnName());
		jsonData.put("address1", postalAddress.getAddress1());
		jsonData.put("address2", postalAddress.getAddress2());
		jsonData.put("directions", postalAddress.getDirections());
		jsonData.put("city", postalAddress.getCity());
		jsonData.put("postalCode", postalAddress.getPostalCode());
		jsonData.put("postalCodeExt", postalAddress.getPostalCodeExt());
		jsonData.put("countryGeoId", postalAddress.getCountryGeoId());
		jsonData.put("stateProvinceGeoId", postalAddress.getStateProvinceGeoId());
		jsonData.put("countyGeoId", postalAddress.getCountyGeoId());
		jsonData.put("postalCodeGeoId", postalAddress.getPostalCodeGeoId());
		jsonData.put("geoPointId", postalAddress.getGeoPointId());
		return jsonData;
	}
	
	private List<PostalAddress> getAllPostalAddress(String contactMechId) throws GenericEntityException{
		
		List<PostalAddress> postals = new ArrayList();
		if(UtilValidate.isNotEmpty(contactMechId)){
			
			postals = delegator.findByProperty(PostalAddress.class, "contactMechId", contactMechId);
		}else{
			postals = delegator.findAll(PostalAddress.class);
		}
		
		return postals;

	}
}
