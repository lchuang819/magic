/**
 * Powered by Chuang.Liu @2012-2-15
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.accounting.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.apps.accounting.entitymodel.GlAccount;
import com.apps.accounting.entitymodel.PaymentMethodTypeGlAccount;
import com.apps.party.entitymodel.Party;
import com.magic.constant.Constant;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2012-2-15
 */
public class GlAccountService extends BaseService {

	public static final String module = GlAccountService.class.getName();
	
	/**
	 * gl acount 管理服务
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map glAccountManagerService(Map context) throws ExecuteServiceException {
		
		String operationType = (String) context.get("operationType");
		
		GlAccount glAccount = (GlAccount) context.get("glAcount");
		
		String glAccountId = (String) context.get("glAccountId");
		
		if(UtilValidate.isNotEmpty(glAccount)){
			
			glAccountId = glAccount.getGlAccountId();
			
		}else{
			Debug.logError("Input GlAcount is empty.", module);
			return ServiceUtil.returnError("输入的GlAccount参数为空");
		}
		
		if(Constant.OPERATION_ADD.equals(operationType)){
			
			glAccountId = delegator.getNextSeqId("GlAccount");
			
			Debug.logInfo("新增GlAccount，id为" + glAccountId, module);
			
			if(UtilValidate.isEmpty(glAccount)){
				Debug.logError("Input GlAcountId is empty.", module);
				return ServiceUtil.returnError("输入的账户编号GlAcountId为空");
			}
			
			glAccount.setGlAccountId(glAccountId);
			
			delegator.saveEntity(glAccount);
			
		}else if(Constant.OPERATION_MOD.equals(operationType)){
			
			if(UtilValidate.isEmpty(glAccount)){
				Debug.logError("Input GlAcountId is empty.", module);
				return ServiceUtil.returnError("输入的账户编号GlAcountId为空");
			}
			
			delegator.updateEntity(glAccount);
			
		}else if(Constant.OPERATION_DEL.equals(operationType)){
			
			if(UtilValidate.isEmpty(glAccountId)){
				Debug.logError("Input GlAcountId is empty.", module);
				return ServiceUtil.returnError("输入参数GlAccountId为空");
			}
			
			delegator.deleteById(GlAccount.class, glAccountId);
			
		}
		
		
		return ServiceUtil.returnSuccess();
	}
	
	/**
	 * gl acount 加载服务
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map glAccountLoadService(Map context) throws ExecuteServiceException {
		
		String partyId = (String) context.get("partyId");
		
		List<PaymentMethodTypeGlAccount> paymentMethodGlAccounts = delegator.findByProperty(PaymentMethodTypeGlAccount.class, "id.organizationPartyId", partyId);
		
		JSONArray paymentMethodGlAccountsArray = new JSONArray();
		
		for(PaymentMethodTypeGlAccount paymentMethodTypeGlAccount : paymentMethodGlAccounts){
			
			String glAccountId = paymentMethodTypeGlAccount.getGlAccountId();
			
			GlAccount glAccount = delegator.findById(GlAccount.class, glAccountId);
			
			if(UtilValidate.isEmpty(glAccount)){
				Debug.logWarning("PaymentMethodTypeGlAccount's GlAccountId has not reference with GlAccount", module);
				continue;
			}
			
			JSONObject json = getPaymentMethodTypeGlAccountMap(paymentMethodTypeGlAccount, glAccount);
			
			if(UtilValidate.isNotEmpty(json)){
				paymentMethodGlAccountsArray.add(json);
			}
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", paymentMethodGlAccountsArray);
		json.put("totalCount", paymentMethodGlAccountsArray.size());
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		return returnMap;
	}
	
	/**
	 * @param paymentMethodTypeGlAccount
	 * @return
	 */
	private JSONObject getPaymentMethodTypeGlAccountMap(PaymentMethodTypeGlAccount paymentMethodTypeGlAccount, GlAccount glAccount){
		
		JSONObject jsonData = new JSONObject();
		try {
			
			jsonData.putAll(BeanUtils.describe(paymentMethodTypeGlAccount));
			jsonData.putAll(BeanUtils.describe(glAccount));
		} catch (Exception e) {
			Debug.logError(e, module);
			return null;
		}
		
		return jsonData;
	}
}
