package com.apps.product.entitymodel;

import java.util.Date;

/**
 * SupplierProductId generated by MyEclipse Persistence Tools
 */

public class SupplierProductId implements java.io.Serializable {

	// Fields

	private String productId;

	private String partyId;

	private String currencyUomId;

	private Double minimumOrderQuantity;

	private Date availableFromDate;

	// Constructors

	/** default constructor */
	public SupplierProductId() {
	}

	/** full constructor */
	public SupplierProductId(String productId, String partyId,
			String currencyUomId, Double minimumOrderQuantity,
			Date availableFromDate) {
		this.productId = productId;
		this.partyId = partyId;
		this.currencyUomId = currencyUomId;
		this.minimumOrderQuantity = minimumOrderQuantity;
		this.availableFromDate = availableFromDate;
	}

	// Property accessors

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getPartyId() {
		return this.partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getCurrencyUomId() {
		return this.currencyUomId;
	}

	public void setCurrencyUomId(String currencyUomId) {
		this.currencyUomId = currencyUomId;
	}

	public Double getMinimumOrderQuantity() {
		return this.minimumOrderQuantity;
	}

	public void setMinimumOrderQuantity(Double minimumOrderQuantity) {
		this.minimumOrderQuantity = minimumOrderQuantity;
	}

	public Date getAvailableFromDate() {
		return this.availableFromDate;
	}

	public void setAvailableFromDate(Date availableFromDate) {
		this.availableFromDate = availableFromDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SupplierProductId))
			return false;
		SupplierProductId castOther = (SupplierProductId) other;

		return ((this.getProductId() == castOther.getProductId()) || (this
				.getProductId() != null
				&& castOther.getProductId() != null && this.getProductId()
				.equals(castOther.getProductId())))
				&& ((this.getPartyId() == castOther.getPartyId()) || (this
						.getPartyId() != null
						&& castOther.getPartyId() != null && this.getPartyId()
						.equals(castOther.getPartyId())))
				&& ((this.getCurrencyUomId() == castOther.getCurrencyUomId()) || (this
						.getCurrencyUomId() != null
						&& castOther.getCurrencyUomId() != null && this
						.getCurrencyUomId()
						.equals(castOther.getCurrencyUomId())))
				&& ((this.getMinimumOrderQuantity() == castOther
						.getMinimumOrderQuantity()) || (this
						.getMinimumOrderQuantity() != null
						&& castOther.getMinimumOrderQuantity() != null && this
						.getMinimumOrderQuantity().equals(
								castOther.getMinimumOrderQuantity())))
				&& ((this.getAvailableFromDate() == castOther
						.getAvailableFromDate()) || (this
						.getAvailableFromDate() != null
						&& castOther.getAvailableFromDate() != null && this
						.getAvailableFromDate().equals(
								castOther.getAvailableFromDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getProductId() == null ? 0 : this.getProductId().hashCode());
		result = 37 * result
				+ (getPartyId() == null ? 0 : this.getPartyId().hashCode());
		result = 37
				* result
				+ (getCurrencyUomId() == null ? 0 : this.getCurrencyUomId()
						.hashCode());
		result = 37
				* result
				+ (getMinimumOrderQuantity() == null ? 0 : this
						.getMinimumOrderQuantity().hashCode());
		result = 37
				* result
				+ (getAvailableFromDate() == null ? 0 : this
						.getAvailableFromDate().hashCode());
		return result;
	}

}