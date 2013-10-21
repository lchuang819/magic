/**
 * Powered by Chuang.Liu @2011-10-17
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.apps.party.service.PartyLoaderService;
import com.apps.product.entitymodel.Product;
import com.apps.product.entitymodel.ProductPrice;
import com.apps.product.entitymodel.ProductType;
import com.apps.product.entitymodel.SupplierProduct;
import com.frm.common.entitymodel.Uom;
import com.magic.constant.ActionType;
import com.magic.entity.GenericEntityException;
import com.magic.model.SearchCondition;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-10-17
 */
public class ProductLoaderService extends BaseService {

	public static final String module = ProductLoaderService.class.getName();
	
	@Autowired
	private PartyLoaderService partyLoaderService;
	
	@Autowired
	private ProductPriceService productPriceService;
	/* (non-Javadoc)
	 * @see com.magic.service.IService#execute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		
		String limit = (String)context.get("limit");
		String sort = (String)context.get("sort");
		String start = (String)context.get("start");
		String dir = (String)context.get("dir");
		String callback = (String)context.get("callback");
		String _dc = (String)context.get("_dc");
		
		String actionType = (String)context.get("actionType");
		
		Map filterMap = (Map)context.get("filterMap");
		
		JSONArray array = new JSONArray();
		
		if(ActionType.LOAD_ALL.equals(actionType)){
			
			List<Product> products = null;
			try {
				
				if(UtilValidate.isEmpty(filterMap)){
					products = delegator.findListForPage(Product.class, start, limit, sort, dir);
				}else{
					products = delegator.findListForPage(Product.class, filterMap, start, limit, sort, dir);
				}
				
			} catch (GenericEntityException e) {
				Debug.logError(e, module);
				throw new ExecuteServiceException("查询产品失败");
			}
			array = iteratorProducts(products, start, limit);
			
		}else if(ActionType.LOAD_PART.equals(actionType)){
			SearchCondition searchCondition = (SearchCondition) context.get("searchCondition");
			Debug.logInfo("ConditionName:"+searchCondition.getConditionName(), module);
			Debug.logInfo("Condition:"+searchCondition.getCondition(), module);
			Debug.logInfo("SearchContent:"+searchCondition.getSearchContent(), module);
			List<Product> products = null;
			try {
				products = delegator.findByCondition(Product.class, searchCondition.getConditionName(), searchCondition.getCondition(), searchCondition.getSearchContent());
			} catch (GenericEntityException e) {
				Debug.logError(e, module);
				throw new ExecuteServiceException("查询产品失败");
			}
			
			array = iteratorProducts(products, start, limit);
		}
		
		JSONObject json = new JSONObject();
		json.put("topics", array);
		json.put("totalCount", delegator.getRecordCount(Product.class));
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		
		return returnMap;
	}
	
	private JSONArray iteratorProducts(List<Product> products, String start, String limit){
		
		JSONArray array = new JSONArray();
		
		if(UtilValidate.isEmpty(start)){
			start = "1";
		}
		
		if(UtilValidate.isEmpty(limit)){
			limit = "10";
		}
		
		int iStart = Integer.parseInt(start);
		int iLimit = Integer.parseInt(limit);
		
		int i = iStart;
		for(Product product : products){
			JSONObject jsonData = new JSONObject();
			jsonData.put("sequenceId", i++);
			jsonData.put("productId", product.getProductId());
			jsonData.put("brandName", product.getBrandName());
			jsonData.put("internalName", product.getInternalName());
			jsonData.put("comments", product.getComments());
			jsonData.put("productTypeId", product.getProductTypeId());
			jsonData.put("quantityUomId", product.getQuantityUomId());
			jsonData.put("quantityIncluded", product.getQuantityIncluded());
			jsonData.put("weight", product.getWeight());
			jsonData.put("weightUomId", product.getWeightUomId());
			jsonData.put("heightUomId", product.getHeightUomId());
			jsonData.put("productHeight", product.getProductHeight());
			jsonData.put("depthUomId", product.getProductDepth());
			jsonData.put("widthUomId", product.getWidthUomId());
			jsonData.put("productWidth", product.getProductWidth());
			
			Map priceCond = new HashMap();
			priceCond.put("id.productId", product.getProductId());
			priceCond.put("id.productPriceTypeId", "DEFAULT_PRICE");
			priceCond.put("id.productPricePurposeId", "PURCHASE");
			priceCond.put("id.currencyUomId", "CNY");
			priceCond.put("id.productStoreGroupId", "_NA_");
			
			List productPrices = delegator.findByCondition(ProductPrice.class, priceCond);
			if(UtilValidate.isNotEmpty(productPrices)){
				ProductPrice pp = (ProductPrice) productPrices.get(0);
				
				//获得产品缺省价格
				jsonData.put("defaultPrice", pp.getPrice());
			}
			
			array.add(jsonData);
		}
		
		return array;
	}
	
	/**
	 * 加载产品详细信息[产品基本信息，产品价格]
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadProductDetailService(Map context) throws ExecuteServiceException {
		
		String productId = (String) context.get("productId");
		if(UtilValidate.isEmpty(productId)){
			Debug.logError("Input productId is empty.", module);
			return ServiceUtil.returnError("Input productId is empty.");
		}
		
		JSONObject productDetail = new JSONObject();
		try {
			
			Product product = (Product) delegator.findById(Product.class, productId);
			if(UtilValidate.isEmpty(product)){
				Debug.logWarning("Can not find product:" + productId, module);
				return ServiceUtil.returnError("查询的产品"+productId+"不存在");
			}
			
			productDetail.putAll(BeanUtils.describe(product));
			
			//查询产品类型描述
			String productTypeId = product.getProductTypeId();
			ProductType productType = (ProductType) delegator.findById(ProductType.class, productTypeId);
			if(UtilValidate.isNotEmpty(productType)){
				String productTypeDesc = productType.getDescription();
				productDetail.put("productTypeDesc", productTypeDesc);
			}
			
			//查询产品供应商
			List<SupplierProduct> supplierProducts = delegator.findByProperty(SupplierProduct.class, "id.productId", productId);
			for(SupplierProduct supplierProduct : supplierProducts){
				String partyId = supplierProduct.getId().getPartyId();
				Map queryPartFields = new HashMap();
				queryPartFields.put("partyId", partyId);
				Map queryPartyResult = partyLoaderService.loadPartyService(queryPartFields);
				if(ServiceUtil.isError(queryPartyResult)){
					Debug.logError("Find product supplier infomation error " + ServiceUtil.getErrorMessage(queryPartyResult), module);
					return ServiceUtil.returnError("查询产品供应商失败");
				}
				
				List<JSONObject> partys = (JSONArray)queryPartyResult.get("partys");
				for(JSONObject party : partys){
					String partyFirstName = party.getString("firstName");
					String partyLastName = party.getString("lastName");
					String partyName = "";
					if(UtilValidate.isNotEmpty(partyFirstName)){
						partyName = partyName + partyFirstName;
					}
					if(UtilValidate.isNotEmpty(partyLastName)){
						partyName = partyName + partyLastName;
					}
					
					Debug.logInfo("Product["+productId+"]'s supplier is " + partyName+"["+partyId+"]", module);
				}
			}
			
//			String heightUomId = product.getHeightUomId();
//			Uom heightUom = queryUom(heightUomId);
//			if(UtilValidate.isNotEmpty(heightUom)){
//				productDetail.put("heightUomDesc", heightUom.getDescription());
//			}
			
			Debug.logInfo("productDetail:"+productDetail, module);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("查询产品时出现数据库异常");
		} catch (Exception e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("转换Bean异常");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", productDetail);
		return returnMap;
	}
	
	public Uom queryUom(String uomId) throws GenericEntityException{
		Uom uom = (Uom) delegator.findById(Uom.class, uomId);
		return uom;
	}

}
