package com.magic.entitymodel;

// Generated 2011-6-16 23:59:51 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * BuildGroupMenus generated by hbm2java
 */
public class BuildGroupMenus extends GenericEntity implements java.io.Serializable {

	private BuildGroupMenusId id;
	private String menuName;
	private Date lastUpdatedStamp;
	private Date lastUpdatedTxStamp;
	private Date createdStamp;
	private Date createdTxStamp;

	public BuildGroupMenus() {
		this.createdStamp = new Date();
	}

	public BuildGroupMenus(BuildGroupMenusId id) {
		this.id = id;
	}

	public BuildGroupMenus(BuildGroupMenusId id, String menuName,
			Date lastUpdatedStamp, Date lastUpdatedTxStamp, Date createdStamp,
			Date createdTxStamp) {
		this.id = id;
		this.menuName = menuName;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = new Date();
		this.createdTxStamp = createdTxStamp;
	}

	public BuildGroupMenusId getId() {
		return this.id;
	}

	public void setId(BuildGroupMenusId id) {
		this.id = id;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Date getLastUpdatedStamp() {
		return this.lastUpdatedStamp;
	}

	public void setLastUpdatedStamp(Date lastUpdatedStamp) {
		this.lastUpdatedStamp = lastUpdatedStamp;
	}

	public Date getLastUpdatedTxStamp() {
		return this.lastUpdatedTxStamp;
	}

	public void setLastUpdatedTxStamp(Date lastUpdatedTxStamp) {
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
	}

	public Date getCreatedStamp() {
		return this.createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	public Date getCreatedTxStamp() {
		return this.createdTxStamp;
	}

	public void setCreatedTxStamp(Date createdTxStamp) {
		this.createdTxStamp = createdTxStamp;
	}

}
