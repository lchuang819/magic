/**
 * Powered by Chuang.Liu @2011-10-25
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.catalog.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.apps.catalog.entitymodel.ProdCatalog;
import com.apps.product.entitymodel.Product;
import com.magic.entity.GenericEntityException;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;

/**
 * @author lchuang
 * @2011-10-25
 */
public class CatalogService extends BaseService {

	public static final String module = CatalogService.class.getName();
	
	/**
	 * 
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadCatalogService(Map context) throws ExecuteServiceException{
		
		JSONArray array = new JSONArray();
		try {
			List<ProdCatalog> prodCatalogs = delegator.findAll(ProdCatalog.class);
			
			for(ProdCatalog prodCatalog : prodCatalogs){
				array.add(getProdCatalogJson(prodCatalog));
			}
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("查询目录失败");
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", array.size());
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		
		return returnMap;
	}
	
	public Map createProdCatalogService(Map context)throws ExecuteServiceException{
		
		ProdCatalog prodCatalog = (ProdCatalog) context.get("prodCatalog");
		
		try {
			delegator.saveEntity(prodCatalog);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("创建目录失败");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}
	
	public Map updateProdCatalogService(Map context)throws ExecuteServiceException{
		
		ProdCatalog prodCatalog = (ProdCatalog) context.get("prodCatalog");
		
		try {
			delegator.updateEntity(prodCatalog);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("创建目录失败");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}
	
	public Map deleteProdCatalogService(Map context)throws ExecuteServiceException{
		
		ProdCatalog prodCatalog = (ProdCatalog) context.get("prodCatalog");
		
		try {
			delegator.deleteEntity(prodCatalog);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("删除目录出现数据库异常");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}
	
	private JSONObject getProdCatalogJson(ProdCatalog catalog){
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("prodCatalogId", catalog.getProdCatalogId());
		jsonData.put("catalogName", catalog.getCatalogName());
		jsonData.put("useQuickAdd", catalog.getUseQuickAdd());
		jsonData.put("styleSheet", catalog.getStyleSheet());
		jsonData.put("headerLogo", catalog.getHeaderLogo());
		jsonData.put("contentPathPrefix", catalog.getContentPathPrefix());
		jsonData.put("templatePathPrefix", catalog.getTemplatePathPrefix());
		
		return jsonData;
	}
}
