/**
 * Powered by Chuang.Liu @2011-10-16
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.product.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Qualifier;

import com.apps.party.entitymodel.Party;
import com.apps.party.entitymodel.PostalAddress;
import com.apps.product.constant.ProductActionType;
import com.apps.product.entitymodel.Product;
import com.apps.product.entitymodel.SupplierProduct;
import com.apps.product.entitymodel.SupplierProductId;
import com.apps.product.model.KeyWords;
import com.apps.product.service.ProductManagerService;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-10-16
 */
public class ProductManagerAction extends ActionSupport {

	public static final String module = ProductManagerAction.class.getName();
	
	private Product product;
	private Party party;
	private SupplierProduct supplierProduct;
	private SupplierProductId supplierProductId;
	private KeyWords productKeyWords;
	@Qualifier("partyPostalAddr")
	private PostalAddress partyPostalAddr;
	
	@Qualifier("productManagerService")
	private ProductManagerService productManagerService;
	
	/**
	 * @return the supplierProductId
	 */
	public SupplierProductId getSupplierProductId() {
		return supplierProductId;
	}

	/**
	 * @param supplierProductId the supplierProductId to set
	 */
	public void setSupplierProductId(SupplierProductId supplierProductId) {
		this.supplierProductId = supplierProductId;
	}

	/**
	 * @return the supplierProduct
	 */
	public SupplierProduct getSupplierProduct() {
		return supplierProduct;
	}

	/**
	 * @param supplierProduct the supplierProduct to set
	 */
	public void setSupplierProduct(SupplierProduct supplierProduct) {
		this.supplierProduct = supplierProduct;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	
	/**
	 * @return the party
	 */
	public Party getParty() {
		return party;
	}

	/**
	 * @param party the party to set
	 */
	public void setParty(Party party) {
		this.party = party;
	}

	/**
	 * @return the productKeyWords
	 */
	public KeyWords getProductKeyWords() {
		return productKeyWords;
	}

	/**
	 * @param productKeyWords the productKeyWords to set
	 */
	public void setProductKeyWords(KeyWords productKeyWords) {
		this.productKeyWords = productKeyWords;
	}
	
	/**
	 * @return the partyPostalAddr
	 */
	public PostalAddress getPartyPostalAddr() {
		return partyPostalAddr;
	}

	/**
	 * @param partyPostalAddr the partyPostalAddr to set
	 */
	public void setPartyPostalAddr(PostalAddress partyPostalAddr) {
		this.partyPostalAddr = partyPostalAddr;
	}

	/**
	 * @return the productManagerService
	 */
	public ProductManagerService getProductManagerService() {
		return productManagerService;
	}

	/**
	 * @param productManagerService the productManagerService to set
	 */
	public void setProductManagerService(ProductManagerService productManagerService) {
		this.productManagerService = productManagerService;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		Map paramsMap = request.getParameterMap();
		Debug.logInfo("ProductManagerAction params map:" + paramsMap, module);
		
		String productId = product.getProductId();
		Debug.logInfo("ProductManagerAction productId:" + productId, module);
		
		String productTypeId = product.getProductTypeId();
		Debug.logInfo("ProductManagerAction productTypeId:" + productTypeId, module);
		
		String partyId = party.getPartyId();
		Debug.logInfo("ProductManagerAction partyId:" + partyId, module);
		
		String pinyinCode = productKeyWords.getPinyinCode();
		Debug.logInfo("ProductManagerAction pinyinCode:" + pinyinCode, module);
		
		Map context = new HashMap();
		context.put("product", product);
		context.put("supplierProduct", supplierProduct);
		context.put("supplierProductId", supplierProductId);
		
		String actionType = request.getParameter("actionType");
		
		try {
			HttpSession session = request.getSession();
			Map resultMap = null;
			if(ProductActionType.CREATE_PRODUCT.equals(actionType)){
				resultMap = productManagerService.createProductService(context);
			}else if(ProductActionType.UPDATE_PRODUCT.equals(actionType)){
				resultMap = productManagerService.updateProductService(context);
			}else{
				Debug.logInfo("Product manager actionType:" + actionType, module);
			}
			
			if(ServiceUtil.isError(resultMap)){
				Debug.logError("Manager product error:" + ServiceUtil.getErrorMessage(resultMap), module);
				CommonUtil.outFailureJson(response, "操作失败："+ServiceUtil.getErrorMessage(resultMap));
				return null;
			}
			
		} catch (Exception e) {
			Debug.logError(e, module);
			CommonUtil.outFailureJson(response, "操作失败："+e.getMessage());
			return null;
		}
		
		CommonUtil.outSuccessJson(response, "操作成功");
		return null;
	}
}
