/**
 * Powered by Chuang.Liu @2011-11-3
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.product.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.apps.product.constant.ProductActionType;
import com.apps.product.constant.ProductReturnType;
import com.apps.product.entitymodel.ProductPrice;
import com.apps.product.entitymodel.ProductPriceId;
import com.apps.product.service.ProductLoaderService;
import com.apps.product.service.ProductPriceService;
import com.frm.security.entitymodel.UserLogin;
import com.magic.action.BaseAction;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;

/**
 * @author lchuang
 * @2011-11-3
 */
public class ProductPriceAction extends BaseAction {

	public static final String module = ProductPriceAction.class.getName();
	
	private ProductPrice productPrice;
	
	private ProductPriceId productPriceId;
	
	public Map productDetail = new HashMap();
	
	@Autowired
	private ProductLoaderService productLoaderService;
	
	@Autowired
	private ProductPriceService productPriceService;
	
	/**
	 * @return the productPrice
	 */
	public ProductPrice getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(ProductPrice productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the productPriceId
	 */
	public ProductPriceId getProductPriceId() {
		return productPriceId;
	}

	/**
	 * @param productPriceId the productPriceId to set
	 */
	public void setProductPriceId(ProductPriceId productPriceId) {
		this.productPriceId = productPriceId;
	}

	public String executeProductPriceManager() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Map session = ServletActionContext.getContext().getSession();
//		HttpSession session = request.getSession();
		UserLogin userLogin = (UserLogin) session.get("userLogin");
		
		String actionType = request.getParameter("actionType");
		Debug.logInfo("actionType:" + actionType, module);
		
		Map context = new HashMap();
		context.put("productPrice", productPrice);
		context.put("productPriceId", productPriceId);
		context.put("userLogin", userLogin);
		
		Map results = null;
		
		try {
			
			if(ProductActionType.CREATE_PRODUCT_PRICE.equals(actionType)){
				
				results = productPriceService.createProductPriceService(context);
			}else if(ProductActionType.UPDATE_PRODUCT_PRICE.equals(actionType)){
				
				results = productPriceService.updateProductPriceService(context);
			}else if(ProductActionType.DELETE_PRODUCT_PRICE.equals(actionType)){
				
				String productId = request.getParameter("productId");
				String productPriceTypeId = request.getParameter("productPriceTypeId");
				String fromDate = request.getParameter("fromDate");
				context.put("productId", productId);
				context.put("productPriceTypeId", productPriceTypeId);
				context.put("fromDate", fromDate);
				
				results = productPriceService.deleteProductPriceService(context);
			}
			
			if(ServiceUtil.isError(results)){
				Debug.logError("Manage product price error " + ServiceUtil.getErrorMessage(results), module);
				CommonUtil.outFailureJson(response, "操作失败:" + ServiceUtil.getErrorMessage(results));
				return null;
			}
		} catch (Exception e) {
			Debug.logError(e, module);
			CommonUtil.outFailureJson(response, "产品价格管理异常" + e.getMessage());
			return null;
		}
		
		CommonUtil.outSuccessJson(response, "操作成功");
		return null;
	}
	
	public String executeProductPriceLoader() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String productId = request.getParameter("productId");
		Map context = new HashMap();
		context.put("productId", productId);
		
		Map results = null;
		try {
			
			results = productPriceService.loadProductPriceService(context);
			
			if(ServiceUtil.isError(results)){
				CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
				return null;
			}
		} catch (Exception e) {
			Debug.logError(e, module);
			CommonUtil.outFailureJson(response, "产品价格管理异常" + e.getMessage());
			return null;
		}
		
		JSONObject json = (JSONObject)results.get("returnData");
		CommonUtil.outJson(response, JSONObject.fromObject(json));
		return null;
	}
	
	public String executeProductPrice() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String productId = request.getParameter("productId");
		
		Map context = new HashMap();
		context.put("productId", productId);
		
		Map results = null;
		try {
			
			results = productLoaderService.loadProductDetailService(context);
			if(ServiceUtil.isError(results)){
				Debug.logError("Run loadProductDetailService error:" + ServiceUtil.getErrorMessage(results), module);
				setErrorResultMap(results);
				return ERROR;
			}
			
			productDetail = (Map) results.get("returnData");
			
		} catch (Exception e) {
			Debug.logError(e, module);
			setErrorMessage("调用产品详细信息服务异常" + e.getMessage());
			return ERROR;
		}
		
		return ProductReturnType.PRODUCT_PRICE;
	}
}
