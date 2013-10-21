/**
 * Powered by Chuang.Liu @2011-10-28
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.catalog.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.apps.catalog.entitymodel.ProductCategory;
import com.apps.catalog.service.CategoryService;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-10-28
 */
public class CategoryAction extends ActionSupport {

	public static final String module = CategoryAction.class.getName();
	
	private ProductCategory productCategory;
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * @return the categoryService
	 */
	public CategoryService getCategoryService() {
		return categoryService;
	}

	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * @return the productCategory
	 */
	public ProductCategory getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	
	public String executeLoader()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String actionType = request.getParameter("actionType");
		
		try {
			
			Map inputMap = new HashMap();
			Map results = categoryService.categoryLoaderService(inputMap);
			if(ServiceUtil.isError(results)){
				Debug.logError("Run loadCatalogService Error:" + ServiceUtil.getErrorMessage(results), module);
				CommonUtil.outFailureJson(response, "加载分类错误"+ServiceUtil.getErrorMessage(results));
				return null;
			}
			
			JSONObject json = (JSONObject)results.get("returnData");
			CommonUtil.outJson(response, JSONObject.fromObject(json));
		} catch (Exception e) {
			Debug.logError(e, module);
			CommonUtil.outFailureJson(response, "操作出现异常："+e.getMessage());
		}
		return null;
	}
	
	public String executeManager()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String actionType = request.getParameter("actionType");
		Debug.logInfo("CategoryAction actionType:" + actionType, module);
		
		Map descMap = BeanUtils.describe(productCategory);
		Debug.logInfo("describe productCategory:" + descMap, module);
		
		CommonUtil.outSuccessJson(response, "操作成功");
		return null;
	}
}
