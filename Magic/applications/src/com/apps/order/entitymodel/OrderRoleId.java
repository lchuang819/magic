package com.apps.order.entitymodel;

/**
 * OrderRoleId generated by MyEclipse Persistence Tools
 */

public class OrderRoleId extends com.magic.entitymodel.GenericEntity implements
		java.io.Serializable {

	// Fields

	private String orderId;

	private String partyId;

	private String roleTypeId;

	// Constructors

	/** default constructor */
	public OrderRoleId() {
	}

	/** full constructor */
	public OrderRoleId(String orderId, String partyId, String roleTypeId) {
		this.orderId = orderId;
		this.partyId = partyId;
		this.roleTypeId = roleTypeId;
	}

	// Property accessors

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPartyId() {
		return this.partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getRoleTypeId() {
		return this.roleTypeId;
	}

	public void setRoleTypeId(String roleTypeId) {
		this.roleTypeId = roleTypeId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderRoleId))
			return false;
		OrderRoleId castOther = (OrderRoleId) other;

		return ((this.getOrderId() == castOther.getOrderId()) || (this
				.getOrderId() != null
				&& castOther.getOrderId() != null && this.getOrderId().equals(
				castOther.getOrderId())))
				&& ((this.getPartyId() == castOther.getPartyId()) || (this
						.getPartyId() != null
						&& castOther.getPartyId() != null && this.getPartyId()
						.equals(castOther.getPartyId())))
				&& ((this.getRoleTypeId() == castOther.getRoleTypeId()) || (this
						.getRoleTypeId() != null
						&& castOther.getRoleTypeId() != null && this
						.getRoleTypeId().equals(castOther.getRoleTypeId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOrderId() == null ? 0 : this.getOrderId().hashCode());
		result = 37 * result
				+ (getPartyId() == null ? 0 : this.getPartyId().hashCode());
		result = 37
				* result
				+ (getRoleTypeId() == null ? 0 : this.getRoleTypeId()
						.hashCode());
		return result;
	}

}