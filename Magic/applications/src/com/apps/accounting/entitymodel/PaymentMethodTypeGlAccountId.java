package com.apps.accounting.entitymodel;

/**
 * PaymentMethodTypeGlAccountId generated by MyEclipse Persistence Tools
 */

public class PaymentMethodTypeGlAccountId extends
		com.magic.entitymodel.GenericEntity implements java.io.Serializable {

	// Fields

	private String paymentMethodTypeId;

	private String organizationPartyId;

	// Constructors

	/** default constructor */
	public PaymentMethodTypeGlAccountId() {
	}

	/** full constructor */
	public PaymentMethodTypeGlAccountId(String paymentMethodTypeId,
			String organizationPartyId) {
		this.paymentMethodTypeId = paymentMethodTypeId;
		this.organizationPartyId = organizationPartyId;
	}

	// Property accessors

	public String getPaymentMethodTypeId() {
		return this.paymentMethodTypeId;
	}

	public void setPaymentMethodTypeId(String paymentMethodTypeId) {
		this.paymentMethodTypeId = paymentMethodTypeId;
	}

	public String getOrganizationPartyId() {
		return this.organizationPartyId;
	}

	public void setOrganizationPartyId(String organizationPartyId) {
		this.organizationPartyId = organizationPartyId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PaymentMethodTypeGlAccountId))
			return false;
		PaymentMethodTypeGlAccountId castOther = (PaymentMethodTypeGlAccountId) other;

		return ((this.getPaymentMethodTypeId() == castOther
				.getPaymentMethodTypeId()) || (this.getPaymentMethodTypeId() != null
				&& castOther.getPaymentMethodTypeId() != null && this
				.getPaymentMethodTypeId().equals(
						castOther.getPaymentMethodTypeId())))
				&& ((this.getOrganizationPartyId() == castOther
						.getOrganizationPartyId()) || (this
						.getOrganizationPartyId() != null
						&& castOther.getOrganizationPartyId() != null && this
						.getOrganizationPartyId().equals(
								castOther.getOrganizationPartyId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getPaymentMethodTypeId() == null ? 0 : this
						.getPaymentMethodTypeId().hashCode());
		result = 37
				* result
				+ (getOrganizationPartyId() == null ? 0 : this
						.getOrganizationPartyId().hashCode());
		return result;
	}

}