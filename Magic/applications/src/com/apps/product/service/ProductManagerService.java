/**
 * Powered by Chuang.Liu @2011-10-16
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.product.service;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.apps.party.entitymodel.PostalAddress;
import com.apps.product.action.ProductManagerAction;
import com.apps.product.entitymodel.Product;
import com.apps.product.entitymodel.SupplierProduct;
import com.apps.product.entitymodel.SupplierProductId;
import com.apps.product.model.KeyWords;
import com.magic.entity.GenericEntityException;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilDateTime;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-10-16
 */
public class ProductManagerService extends BaseService{

	public static final String module = ProductManagerAction.class.getName();
	
	/**
	 * 创建产品基本信息
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createProductService(Map context) throws ExecuteServiceException {
		Product product = (Product)context.get("product");

		KeyWords productKeyWords = (KeyWords)context.get("productKeyWords");
		PostalAddress partyPostalAddr = (PostalAddress)context.get("partyPostalAddr");
		
		if(UtilValidate.isEmpty(product)){
			Debug.logError("Can not create product, input product is empty.", module);
			return ServiceUtil.returnError("产品创建失败，参数中的产品对象为空。");
		}
		
		String productId = product.getProductId();

		try {
			
			delegator.saveEntity(product);
		} catch (Exception e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("创建产品失败，出现数据库异常");
		}
		
//		Map results = this.createSupplierProductService(context);
//		if(ServiceUtil.isError(results)){
//			Debug.logError("Run createSupplierProductService error:" + ServiceUtil.getErrorMessage(results), module);
//			return results;
//		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("product", product);
		returnMap.put("productKeyWords", productKeyWords);
		returnMap.put("partyPostalAddr", partyPostalAddr);
		return returnMap;
	}
	
	/**
	 * 创建产品的供应商Product-Party
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createSupplierProductService(Map context)throws ExecuteServiceException {
		
		SupplierProduct supplierProduct = (SupplierProduct)context.get("supplierProduct");
		
		if(UtilValidate.isEmpty(supplierProduct)){
			Debug.logError("Input params 'supplierProduct' is empty.", module);
			return ServiceUtil.returnError("创建产品供应商失败，输入参数为空");
		}
		
		Date availableFromDate = supplierProduct.getId().getAvailableFromDate();
		if(UtilValidate.isEmpty(availableFromDate)){
			supplierProduct.getId().setAvailableFromDate(new Date());
		}
		
		try {
			
			delegator.saveEntity(supplierProduct);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("创建产品供应商关联失败，出现数据库异常");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("supplierProduct", supplierProduct);
		return returnMap;
	}

	/**
	 * 更新产品基本信息
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map updateProductService(Map context) throws ExecuteServiceException {
		Product product = (Product)context.get("product");
		SupplierProduct supplierProduct = (SupplierProduct)context.get("supplierProduct");
		SupplierProductId supplierProductId = (SupplierProductId)context.get("supplierProductId");
		KeyWords productKeyWords = (KeyWords)context.get("productKeyWords");
		PostalAddress partyPostalAddr = (PostalAddress)context.get("partyPostalAddr");
		
		if(UtilValidate.isEmpty(product)){
			Debug.logError("Can not create product, input product is empty.", module);
			return ServiceUtil.returnError("产品更新失败，参数中的产品对象为空。");
		}
		
		String productId = product.getProductId();
		if(UtilValidate.isNotEmpty(supplierProduct) && UtilValidate.isNotEmpty(supplierProductId)){
			supplierProductId.setPartyId(productId);
			supplierProductId.setProductId(productId);
			supplierProductId.setAvailableFromDate(UtilDateTime.nowDate());
			supplierProduct.setId(supplierProductId);
		}
		
		try {
			
			delegator.updateEntity(product);
		} catch (Exception e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("创建产品失败，出现数据库异常");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}
}
