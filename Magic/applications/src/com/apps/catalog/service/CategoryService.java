/**
 * Powered by Chuang.Liu @2011-10-28
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.catalog.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.apps.catalog.entitymodel.ProductCategory;
import com.apps.catalog.entitymodel.ProductCategoryType;
import com.magic.entity.GenericEntityException;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;

/**
 * @author lchuang
 * @2011-10-28
 */
public class CategoryService extends BaseService {

	public static final String module = CategoryService.class.getName();
	
	public Map categoryLoaderService(Map context)throws ExecuteServiceException{
		
		JSONArray array = new JSONArray();
		try {
			List<ProductCategory> productCategorys = delegator.findAll(ProductCategory.class);
			
			for(ProductCategory productCategory : productCategorys){
				
				String productCategoryTypeId = productCategory.getProductCategoryTypeId();
				ProductCategoryType productCategoryType = (ProductCategoryType) delegator.findById(ProductCategoryType.class, productCategoryTypeId);
				
				array.add(getCategoryJson(productCategory, productCategoryType));
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
	
	private JSONObject getCategoryJson(ProductCategory category, ProductCategoryType productCategoryType){
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("productCategoryId", category.getProductCategoryId());
		
		
		jsonData.put("productCategoryTypeId", productCategoryType.getProductCategoryTypeId());
		jsonData.put("productCategoryTypeDesc", productCategoryType.getDescription());
		jsonData.put("categoryName", category.getCategoryName());
		jsonData.put("description", category.getDescription());
		jsonData.put("categoryImageUrl", category.getCategoryImageUrl());
		jsonData.put("linkOneImageUrl", category.getLinkOneImageUrl());
		jsonData.put("linkTwoImageUrl", category.getLinkTwoImageUrl());
		jsonData.put("primaryParentCategoryId", category.getPrimaryParentCategoryId());
		return jsonData;
	}
}
