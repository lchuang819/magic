/**
 * Powered by Chuang.Liu @2011-10-16
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.product.model;

import com.apps.product.entitymodel.Product;

/**
 * @author lchuang
 * @2011-10-16
 */
public class ProductForm extends Product {

	private String supplier;
	private String pinyinCode;
	private String provenance;
	/**
	 * @return the supplier
	 */
	public String getSupplier() {
		return supplier;
	}
	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	/**
	 * @return the pinyinCode
	 */
	public String getPinyinCode() {
		return pinyinCode;
	}
	/**
	 * @param pinyinCode the pinyinCode to set
	 */
	public void setPinyinCode(String pinyinCode) {
		this.pinyinCode = pinyinCode;
	}
	/**
	 * @return the provenance
	 */
	public String getProvenance() {
		return provenance;
	}
	/**
	 * @param provenance the provenance to set
	 */
	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}
	
}
