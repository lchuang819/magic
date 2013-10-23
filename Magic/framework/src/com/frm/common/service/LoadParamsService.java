/**
 * Powered by Chuang.Liu @2011-10-17
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.common.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.apps.product.entitymodel.ProductType;
import com.frm.common.ParamsConstant;
import com.magic.entity.GenericEntityException;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;

/**
 * @author lchuang
 * @2011-10-17
 */
public class LoadParamsService extends BaseService{

	public static final String module = LoadParamsService.class.getName();
	
	/* (non-Javadoc)
	 * @see com.magic.service.IService#execute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		String actionType = (String) context.get("actionType");
		Debug.logInfo("LoadParamsService actionType:"+actionType, module);
	
		JSONArray array = new JSONArray();
		
		if(ParamsConstant.PRODUCT_TYPE.equals(actionType)){
			List<ProductType> productTypes = null;
			try {
				productTypes = delegator.findAll(ProductType.class);
			} catch (GenericEntityException e) {
				Debug.logError(e, module);
				throw new ExecuteServiceException("查询产品类型失败");
			}
			
			for(ProductType productType : productTypes){
				JSONObject jsonData = new JSONObject();
				jsonData.put("productTypeId", productType.getProductTypeId());
				jsonData.put("description", productType.getDescription());
				array.add(jsonData);
			}
		}

		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", array.size());
		
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
	public Map getSelectionDropdownService(Map context) throws ExecuteServiceException {
		String codeIndex = (String) context.get("codeIndex");
		String label = (String) context.get("Label");
		String value = (String) context.get("Value");
		Debug.logInfo("LoadParamsService actionType:" + codeIndex, module);
		
		JSONArray array = new JSONArray();
		
		
		return null;
	}

}
