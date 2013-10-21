/**
 * P2owered by Chuang.Liu @2011-10-17
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.product.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apps.product.constant.ProductReturnType;
import com.apps.product.service.ProductLoaderService;
import com.magic.model.SearchCondition;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-10-17
 */
public class ProductLoaderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String module = ProductLoaderAction.class.getName();
	
	private JSONObject productDetail;
	
	private SearchCondition searchCondition;
	@Qualifier("productLoaderService")
	private ProductLoaderService productLoaderService;
	
	/**
	 * @return the productDetail
	 */
	public JSONObject getProductDetail() {
		return productDetail;
	}

	/**
	 * @param productDetail the productDetail to set
	 */
	public void setProductDetail(JSONObject productDetail) {
		this.productDetail = productDetail;
	}

	/**
	 * @return the searchCondition
	 */
	public SearchCondition getSearchCondition() {
		return searchCondition;
	}

	/**
	 * @param searchCondition the searchCondition to set
	 */
	public void setSearchCondition(SearchCondition searchCondition) {
		this.searchCondition = searchCondition;
	}

	/**
	 * @return the productLoaderService
	 */
	public ProductLoaderService getProductLoaderService() {
		return productLoaderService;
	}

	/**
	 * @param productLoaderService the productLoaderService to set
	 */
	public void setProductLoaderService(ProductLoaderService productLoaderService) {
		this.productLoaderService = productLoaderService;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		Debug.logInfo("Start load products.", module);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		Map paramsMap = request.getParameterMap();
		//product=, condition=, searchContent=, conditionName=, actionType=
		Debug.logInfo("ProductLoaderAction params map:" + paramsMap, module);
//		Debug.logInfo("ConditionName:"+searchCondition.getConditionName(), module);
//		Debug.logInfo("Condition:"+searchCondition.getCondition(), module);
//		Debug.logInfo("SearchContent:"+searchCondition.getSearchContent(), module);
		
		String actionType = request.getParameter("actionType");
		Debug.logInfo("actionType:"+actionType, module);
		
		String limit = request.getParameter("limit");
		String sort = request.getParameter("sort");
		String start = request.getParameter("start");
		String dir = request.getParameter("dir");
		String callback = request.getParameter("callback");
		String _dc = request.getParameter("_dc");
		
		String gridFilterList = request.getParameter("gridFilterList");
		Debug.logInfo("gridFilterList:"+gridFilterList, module);
		
		Map context = new HashMap();
		context.put("limit", limit);
		context.put("sort", sort);
		context.put("start", start);
		context.put("dir", dir);
		context.put("callback", callback);
		context.put("_dc", _dc);
		context.put("searchCondition", searchCondition);
		context.put("actionType", actionType);
		
		if(UtilValidate.isNotEmpty(gridFilterList)){
			
			Map filterMap = new HashMap();
			String[] fields = gridFilterList.split(",");
			for(String field : fields){
				filterMap.put(field, request.getParameter(field));
				context.put("filterMap", filterMap);
			}
		}
		
		Map result = null;
		try {
			
				result = productLoaderService.execute(context);
			
			if(ServiceUtil.isError(result)){
				CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(result));
				return null;
			}
		} catch (Exception e) {
			Debug.logError(e, module);
		}
		
		JSONObject json = (JSONObject)result.get("returnData");
		CommonUtil.outJson(response, JSONObject.fromObject(json));
		return null;
	}
	
	public String executeLoadProductDetail() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String productId = request.getParameter("productId");
		Map context = new HashMap();
		context.put("productId", productId);
		Debug.logInfo("Load product detail info by productId:"+productId, module);
		Map result = productLoaderService.loadProductDetailService(context);
		
		JSONObject json = (JSONObject)result.get("returnData");
		setProductDetail(json);
		
		return ProductReturnType.PRODUCT_DETAIL;
	}
	
	public String executeLoadProductPrice() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
//		String productId = request.getParameter("productId");
//		Map context = new HashMap();
//		context.put("productId", productId);
//		Debug.logInfo("Load product detail info by productId:"+productId, module);
//		Map result = productLoaderService.loadProductDetailService(context);
//		
//		JSONObject json = (JSONObject)result.get("returnData");
//		setProductDetail(json);
		
		return ProductReturnType.PRODUCT_PRICE;
	}
	
	public String executeLoadProductCosts() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
//		String productId = request.getParameter("productId");
//		Map context = new HashMap();
//		context.put("productId", productId);
//		Debug.logInfo("Load product detail info by productId:"+productId, module);
//		Map result = productLoaderService.loadProductDetailService(context);
//		
//		JSONObject json = (JSONObject)result.get("returnData");
//		setProductDetail(json);
		
		return ProductReturnType.PRODUCT_COSTS;
	}
}
