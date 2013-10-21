/**
 * Powered by Chuang.Liu @2011-10-25
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.catalog.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.apps.catalog.contant.CatalogActionType;
import com.apps.catalog.entitymodel.ProdCatalog;
import com.apps.catalog.service.CatalogService;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-10-25
 */
public class CatalogAction extends ActionSupport {

	public static final String module = CatalogAction.class.getName();
	
	private ProdCatalog prodCatalog;
	
	@Autowired
	private CatalogService catalogService;
	
	/**
	 * @return the prodCatalog
	 */
	public ProdCatalog getProdCatalog() {
		return prodCatalog;
	}

	/**
	 * @param prodCatalog the prodCatalog to set
	 */
	public void setProdCatalog(ProdCatalog prodCatalog) {
		this.prodCatalog = prodCatalog;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		return null;
	}
	
	public String executeLoader() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		
		try {
			
			Map inputMap = new HashMap();
			Map results = catalogService.loadCatalogService(inputMap);
			if(ServiceUtil.isError(results)){
				Debug.logError("Run loadCatalogService Error:" + ServiceUtil.getErrorMessage(results), module);
				CommonUtil.outFailureJson(response, "加载目录列表"+ServiceUtil.getErrorMessage(results));
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
	
	public String executeManager() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String actionType = request.getParameter("actionType");
		
		Debug.logInfo("execute Catalog Manager actionType:" + actionType, module);
		
		Map context = new HashMap();
		context.put("prodCatalog", prodCatalog);
		
		Debug.logInfo("prodCatalog id is : " + prodCatalog.getProdCatalogId(), module);
		Map results = null;
		try {
			if(CatalogActionType.UPDATE_PROD_CATALOG.equals(actionType)){
				
				results = catalogService.updateProdCatalogService(context);
			}else if(CatalogActionType.CREATE_PROD_CATALOG.equals(actionType)){

				results = catalogService.createProdCatalogService(context);
			}else if(CatalogActionType.DELETE_PROD_CATALOG.equals(actionType)){
				
				results = catalogService.deleteProdCatalogService(context);
			}
			
			if(ServiceUtil.isError(results)){
				Debug.logError(actionType+" error :" + ServiceUtil.getErrorMessage(results), module);
				CommonUtil.outFailureJson(response, actionType + " error!");
				return null;
			}
			
			
		} catch (Exception e) {
			CommonUtil.outFailureJson(response, "更新目录失败");
			Debug.logError(e, module);
			return null;
		}
		
		CommonUtil.outSuccessJson(response, "操作成功");
		return null;
	}
}
