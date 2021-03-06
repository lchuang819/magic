package com.frm.content.entitymodel;

import java.util.Date;

/**
 * Content generated by MyEclipse Persistence Tools
 */

public class Content extends com.magic.entitymodel.GenericEntity implements
		java.io.Serializable {

	// Fields

	private String contentId;

	private String contentTypeId;

	private String ownerContentId;

	private String decoratorContentId;

	private String instanceOfContentId;

	private String dataResourceId;

	private String templateDataResourceId;

	private String dataSourceId;

	private String statusId;

	private String privilegeEnumId;

	private String serviceName;

	private String contentName;

	private String description;

	private String localeString;

	private String mimeTypeId;

	private String characterSetId;

	private Long childLeafCount;

	private Long childBranchCount;

	private Date createdDate;

	private String createdByUserLogin;

	private Date lastModifiedDate;

	private String lastModifiedByUserLogin;

	private Date lastUpdatedStamp;

	private Date lastUpdatedTxStamp;

	private Date createdStamp;

	private Date createdTxStamp;

	// Constructors

	/** default constructor */
	public Content() {
	}

	/** minimal constructor */
	public Content(String contentId) {
		this.contentId = contentId;
	}

	/** full constructor */
	public Content(String contentId, String contentTypeId,
			String ownerContentId, String decoratorContentId,
			String instanceOfContentId, String dataResourceId,
			String templateDataResourceId, String dataSourceId,
			String statusId, String privilegeEnumId, String serviceName,
			String contentName, String description, String localeString,
			String mimeTypeId, String characterSetId, Long childLeafCount,
			Long childBranchCount, Date createdDate, String createdByUserLogin,
			Date lastModifiedDate, String lastModifiedByUserLogin,
			Date lastUpdatedStamp, Date lastUpdatedTxStamp, Date createdStamp,
			Date createdTxStamp) {
		this.contentId = contentId;
		this.contentTypeId = contentTypeId;
		this.ownerContentId = ownerContentId;
		this.decoratorContentId = decoratorContentId;
		this.instanceOfContentId = instanceOfContentId;
		this.dataResourceId = dataResourceId;
		this.templateDataResourceId = templateDataResourceId;
		this.dataSourceId = dataSourceId;
		this.statusId = statusId;
		this.privilegeEnumId = privilegeEnumId;
		this.serviceName = serviceName;
		this.contentName = contentName;
		this.description = description;
		this.localeString = localeString;
		this.mimeTypeId = mimeTypeId;
		this.characterSetId = characterSetId;
		this.childLeafCount = childLeafCount;
		this.childBranchCount = childBranchCount;
		this.createdDate = createdDate;
		this.createdByUserLogin = createdByUserLogin;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedByUserLogin = lastModifiedByUserLogin;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}

	// Property accessors

	public String getContentId() {
		return this.contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getContentTypeId() {
		return this.contentTypeId;
	}

	public void setContentTypeId(String contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

	public String getOwnerContentId() {
		return this.ownerContentId;
	}

	public void setOwnerContentId(String ownerContentId) {
		this.ownerContentId = ownerContentId;
	}

	public String getDecoratorContentId() {
		return this.decoratorContentId;
	}

	public void setDecoratorContentId(String decoratorContentId) {
		this.decoratorContentId = decoratorContentId;
	}

	public String getInstanceOfContentId() {
		return this.instanceOfContentId;
	}

	public void setInstanceOfContentId(String instanceOfContentId) {
		this.instanceOfContentId = instanceOfContentId;
	}

	public String getDataResourceId() {
		return this.dataResourceId;
	}

	public void setDataResourceId(String dataResourceId) {
		this.dataResourceId = dataResourceId;
	}

	public String getTemplateDataResourceId() {
		return this.templateDataResourceId;
	}

	public void setTemplateDataResourceId(String templateDataResourceId) {
		this.templateDataResourceId = templateDataResourceId;
	}

	public String getDataSourceId() {
		return this.dataSourceId;
	}

	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public String getStatusId() {
		return this.statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getPrivilegeEnumId() {
		return this.privilegeEnumId;
	}

	public void setPrivilegeEnumId(String privilegeEnumId) {
		this.privilegeEnumId = privilegeEnumId;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getContentName() {
		return this.contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocaleString() {
		return this.localeString;
	}

	public void setLocaleString(String localeString) {
		this.localeString = localeString;
	}

	public String getMimeTypeId() {
		return this.mimeTypeId;
	}

	public void setMimeTypeId(String mimeTypeId) {
		this.mimeTypeId = mimeTypeId;
	}

	public String getCharacterSetId() {
		return this.characterSetId;
	}

	public void setCharacterSetId(String characterSetId) {
		this.characterSetId = characterSetId;
	}

	public Long getChildLeafCount() {
		return this.childLeafCount;
	}

	public void setChildLeafCount(Long childLeafCount) {
		this.childLeafCount = childLeafCount;
	}

	public Long getChildBranchCount() {
		return this.childBranchCount;
	}

	public void setChildBranchCount(Long childBranchCount) {
		this.childBranchCount = childBranchCount;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedByUserLogin() {
		return this.createdByUserLogin;
	}

	public void setCreatedByUserLogin(String createdByUserLogin) {
		this.createdByUserLogin = createdByUserLogin;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedByUserLogin() {
		return this.lastModifiedByUserLogin;
	}

	public void setLastModifiedByUserLogin(String lastModifiedByUserLogin) {
		this.lastModifiedByUserLogin = lastModifiedByUserLogin;
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