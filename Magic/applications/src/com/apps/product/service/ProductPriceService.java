/**
 * Powered by Chuang.Liu @2011-11-3
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.product.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;

import com.apps.product.entitymodel.ProductPrice;
import com.apps.product.entitymodel.ProductPriceId;
import com.apps.product.entitymodel.ProductPricePurpose;
import com.apps.product.entitymodel.ProductPriceType;
import com.frm.security.entitymodel.UserLogin;
import com.magic.entity.GenericEntityException;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilDateTime;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-11-3
 */
public class ProductPriceService extends BaseService {

	public static final String module = ProductPriceService.class.getName();
	
	/**
	 * 创建产品价格
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map createProductPriceService(Map context) throws ExecuteServiceException {
		ProductPrice productPrice = (ProductPrice) context.get("productPrice");
		ProductPriceId productPriceId = (ProductPriceId) context.get("productPriceId");
		UserLogin userLogin = (UserLogin) context.get("userLogin");
		
		if(UtilValidate.isEmpty(productPrice)){
			Debug.logError("Input params productPrice is empty.", module);
			return ServiceUtil.returnError("输入的参数为空");
		}
		
		if(UtilValidate.isEmpty(productPriceId)){
			Debug.logError("Input params productPriceId is empty.", module);
			return ServiceUtil.returnError("输入的参数为空");
		}
		
		productPriceId.setProductPricePurposeId("PURCHASE");
		productPriceId.setCurrencyUomId("CNY");
		productPriceId.setProductStoreGroupId("_NA_");
		
		Date fromDate = productPriceId.getFromDate();
		if(UtilValidate.isEmpty(fromDate)){
			productPriceId.setFromDate(new Date());
		}
		
		productPrice.setId(productPriceId);
		productPrice.setCreatedByUserLogin(userLogin.getUserLoginId());
		productPrice.setCreatedDate(new Date());
		
		try {
			
			delegator.saveEntity(productPrice);
		} catch (Exception e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("创建产品失败，出现数据库异常");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}
	
	/**
	 * 更新产品价格
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map updateProductPriceService(Map context) throws ExecuteServiceException {
		ProductPrice productPrice = (ProductPrice) context.get("productPrice");
		ProductPriceId productPriceId = (ProductPriceId) context.get("productPriceId");
		UserLogin userLogin = (UserLogin) context.get("userLogin");
		
		if(UtilValidate.isEmpty(productPrice)){
			Debug.logError("Input params productPrice is empty.", module);
			return ServiceUtil.returnError("输入的参数为空");
		}
		
		if(UtilValidate.isEmpty(productPriceId)){
			Debug.logError("Input params productPriceId is empty.", module);
			return ServiceUtil.returnError("输入的参数为空");
		}
		
//		productPriceId.setProductPricePurposeId("PURCHASE");
//		productPriceId.setCurrencyUomId("CNY");
//		productPriceId.setProductStoreGroupId("_NA_");
		
		String productId = productPriceId.getProductId();
		
		Map productPriceIdMap = new HashMap();
		productPriceIdMap.put("id.productId", productId);
		productPriceIdMap.put("id.productPriceTypeId", productPriceId.getProductPriceTypeId());
		productPriceIdMap.put("id.productPricePurposeId", "PURCHASE");
		productPriceIdMap.put("id.currencyUomId", "CNY");
		productPriceIdMap.put("id.productStoreGroupId", "_NA_");
		
		ProductPrice pp = delegator.findOne(ProductPrice.class, productPriceIdMap);
		if(UtilValidate.isEmpty(pp)){
			Debug.logError("更新产品价格失败，未找到产品["+productId+"]的价格", module);
			return ServiceUtil.returnError("更新产品价格失败，未找到产品["+productId+"]的价格");
		}
		
		pp.setPrice(productPrice.getPrice());
		pp.setLastModifiedDate(new Date());
		pp.setLastModifiedByUserLogin(userLogin.getUserLoginId());
		
		delegator.updateEntity(pp);
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}

	/**
	 * 删除产品价格
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map deleteProductPriceService(Map context) throws ExecuteServiceException {
		
		String productId = (String) context.get("productId");
		String productPriceTypeId = (String) context.get("productPriceTypeId");
		String fromDate = (String) context.get("fromDate");
		Debug.logInfo("Input params deleteProductPriceService:" + context, module);

		
		
		ProductPriceId id = new ProductPriceId(productId, productPriceTypeId, "PURCHASE", "CNY", "_NA_", new Timestamp(new Date(fromDate).getTime()));
		try {
			Debug.logInfo("Find ProductPriceId:" + BeanUtils.describe(id), module);
			delegator.deleteById(ProductPrice.class, id);
//			Debug.logInfo("Find ProductPrice:" + BeanUtils.describe(ppp), module);
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
		
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}
	
	/**
	 * 根据productId获得产品价格配置
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadProductPriceService(Map context) throws ExecuteServiceException {
		String productId = (String)context.get("productId");
		Debug.logInfo("Load product by productId " + productId, module);
		JSONArray array = new JSONArray();
		try {
			List<ProductPrice> productPrices = delegator.findByProperty(ProductPrice.class, "id.productId", productId);
			for(ProductPrice productPrice : productPrices){
				array.add(getProductPriceJson(productPrice));
			}
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("创建产品失败，出现数据库异常");
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", array);
		json.put("totalCount", array.size());
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		
		return returnMap;
	}
	
	/**
	 * 返回ProductPrice的Json结构
	 * @param productPrice
	 * @return
	 * @throws GenericEntityException
	 */
	private JSONObject getProductPriceJson(ProductPrice productPrice) throws GenericEntityException{
		
		JSONObject jsonData = new JSONObject();
		
		jsonData.put("productId", productPrice.getId().getProductId());

		String productPriceTypeId = productPrice.getId().getProductPriceTypeId();
		jsonData.put("productPriceTypeId", productPriceTypeId);
		
		ProductPriceType productPriceType = (ProductPriceType) delegator.findById(ProductPriceType.class, productPriceTypeId);
		if(UtilValidate.isNotEmpty(productPriceType)){
			jsonData.put("productPriceTypeDesc", productPriceType.getDescription());
		}

		String productPricePurposeId = productPrice.getId().getProductPricePurposeId();
		jsonData.put("productPricePurposeId", productPricePurposeId);
		
		ProductPricePurpose productPricePurpose = (ProductPricePurpose) delegator.findById(ProductPricePurpose.class, productPricePurposeId);
		if(UtilValidate.isNotEmpty(productPricePurpose)){
			jsonData.put("productPricePurposeDesc", productPricePurpose.getDescription());
		}
		
		jsonData.put("fromDate", UtilDateTime.toDateString(productPrice.getId().getFromDate(), "yyyy/MM/dd HH:mm:ss"));

		jsonData.put("currencyUomId", productPrice.getId().getCurrencyUomId());

		jsonData.put("price", productPrice.getPrice());

		jsonData.put("thruDate", UtilDateTime.toDateString(productPrice.getThruDate(), "yyyy/MM/dd HH:mm:ss"));

		return jsonData;
	}
}
