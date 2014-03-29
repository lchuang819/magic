/**
 * Powered by Chuang.Liu @2011-10-18
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apps.party.constant.PartyConstant;
import com.apps.party.entitymodel.Party;
import com.apps.party.entitymodel.PartyGroup;
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
public class PartyGroupService extends BaseService{

	public static final String module = PartyGroupService.class.getName();
	
	@Autowired
	@Qualifier("partyManagerService")
	private PartyManagerService partyManagerService;
	

	/* (non-Javadoc)
	 * @see com.magic.service.IService#execute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		Debug.logInfo("PartyGroupService...", module);
		
		
		return null;
	}
	
	public Map executeCreatePartyGroup(Map context) throws ExecuteServiceException {
		
		PartyGroup partyGroup = (PartyGroup) context.get("partyGroup");
		Party party = (Party) context.get("party");
		
		if(UtilValidate.isEmpty(partyGroup)){
			Debug.logError("Create PartyGroup error input partyGroup object is empty.", module);
			return ServiceUtil.returnError("创建成员组失败");
		}
		String partyId = partyGroup.getPartyId();
		
		if(UtilValidate.isEmpty(partyId)){
			partyId = delegator.getNextSeqId("Party");
		}
		
		Debug.logInfo("executeCreatePartyGroup partyId:" + partyId, module);
		
		try {
			partyGroup.setPartyId(partyId);
			delegator.saveEntity(partyGroup);
			
			party.setPartyId(partyId);
			party.setStatusId(PartyConstant.PARTY_STATUS_ENABLED);
			
			delegator.saveEntity(party);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("创建成员组失败");
		}
		
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("partyId", partyId);
		return returnMap;
	}
	
	/**
	 * 
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map executeLoadPartyGroup(Map context) throws ExecuteServiceException {
		
		String partyTypeId = (String) context.get("partyTypeId");
		
		String limit = (String)context.get("limit");
		String sort = (String)context.get("sort");
		String start = (String)context.get("start");
		String dir = (String)context.get("dir");
		String callback = (String)context.get("callback");
		String _dc = (String)context.get("_dc");
		
		int limitI = 10;
		int startI = 0;
		if(UtilValidate.isNotEmpty(limit)){
			limitI = Integer.parseInt(limit);
		}
		
		if(UtilValidate.isNotEmpty(start)){
			startI = Integer.parseInt(start);
		}
		
//		List<Party> partyList = delegator.findByProperty(Party.class, "partyTypeId", partyTypeId);
		
		Session session = this.getSession();
		
		Query partyGroupQuery = session.createQuery("from PartyGroup grp, Party prt where prt.partyId = grp.partyId and prt.partyTypeId = '" + partyTypeId + "'");
		partyGroupQuery.setFirstResult(startI);
		partyGroupQuery.setMaxResults(limitI);
		
		Query totalQuery = session.createQuery("select count(prt.partyId) from PartyGroup grp, Party prt where prt.partyId = grp.partyId and prt.partyTypeId = '" + partyTypeId + "'");
		
		int totalCount = ((Long)totalQuery.uniqueResult()).intValue();
		
		Debug.logInfo("PartyGroup totalCount:" + totalCount, module);
		
		List<Object[]> partyList = partyGroupQuery.list();
		
		if(partyList != null){
			Debug.logInfo("PartyGroup size:" + partyList.size(), module);
		}
		
		JSONArray array = new JSONArray();
		
		try {
			
			for(Object[] items : partyList){
				PartyGroup partyGroup = (PartyGroup)items[0];
				
				Map partyGroupMap = BeanUtils.describe(partyGroup);
				
				JSONObject jsonData = JSONObject.fromObject(partyGroupMap);
				array.add(jsonData);
				
			}
			
		} catch (Exception e) {
			Debug.logError(e, partyTypeId);
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", totalCount);
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		returnMap.put("partyList", array);
		return returnMap;
	}

}
