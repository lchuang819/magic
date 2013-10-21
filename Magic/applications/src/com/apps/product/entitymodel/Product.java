package com.apps.product.entitymodel;

import java.util.Date;

/**
 * Product generated by MyEclipse Persistence Tools
 */

public class Product extends com.magic.entitymodel.GenericEntity implements
		java.io.Serializable {

	// Fields

	private String productId;

	private String productTypeId;

	private String primaryProductCategoryId;

	private String manufacturerPartyId;

	private String facilityId;

	private Date introductionDate;

	private Date supportDiscontinuationDate;

	private Date salesDiscontinuationDate;

	private String salesDiscWhenNotAvail;

	private String internalName;

	private String brandName;

	private String comments;

	private String productName;

	private String description;

	private String longDescription;

	private String priceDetailText;

	private String smallImageUrl;

	private String mediumImageUrl;

	private String largeImageUrl;

	private String detailImageUrl;

	private String originalImageUrl;

	private String detailScreen;

	private String inventoryMessage;

	private String requireInventory;

	private String quantityUomId;

	private Double quantityIncluded;

	private Long piecesIncluded;

	private String requireAmount;

	private Double fixedAmount;

	private String amountUomTypeId;

	private String weightUomId;

	private Double weight;

	private String heightUomId;

	private Double productHeight;

	private Double shippingHeight;

	private String widthUomId;

	private Double productWidth;

	private Double shippingWidth;

	private String depthUomId;

	private Double productDepth;

	private Double shippingDepth;

	private Double productRating;

	private String ratingTypeEnum;

	private String returnable;

	private String taxable;

	private String chargeShipping;

	private String autoCreateKeywords;

	private String includeInPromotions;

	private String isVirtual;

	private String isVariant;

	private String virtualVariantMethodEnum;

	private String originGeoId;

	private String requirementMethodEnumId;

	private Long billOfMaterialLevel;

	private Double reservMaxPersons;

	private Double reserv2ndPPPerc;

	private Double reservNthPPPerc;

	private String configId;

	private Date createdDate;

	private String createdByUserLogin;

	private Date lastModifiedDate;

	private String lastModifiedByUserLogin;

	private String inShippingBox;

	private String defaultShipmentBoxTypeId;

	private Date lastUpdatedStamp;

	private Date lastUpdatedTxStamp;

	private Date createdStamp;

	private Date createdTxStamp;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String productId) {
		this.productId = productId;
	}

	/** full constructor */
	public Product(String productId, String productTypeId,
			String primaryProductCategoryId, String manufacturerPartyId,
			String facilityId, Date introductionDate,
			Date supportDiscontinuationDate, Date salesDiscontinuationDate,
			String salesDiscWhenNotAvail, String internalName,
			String brandName, String comments, String productName,
			String description, String longDescription, String priceDetailText,
			String smallImageUrl, String mediumImageUrl, String largeImageUrl,
			String detailImageUrl, String originalImageUrl,
			String detailScreen, String inventoryMessage,
			String requireInventory, String quantityUomId,
			Double quantityIncluded, Long piecesIncluded, String requireAmount,
			Double fixedAmount, String amountUomTypeId, String weightUomId,
			Double weight, String heightUomId, Double productHeight,
			Double shippingHeight, String widthUomId, Double productWidth,
			Double shippingWidth, String depthUomId, Double productDepth,
			Double shippingDepth, Double productRating, String ratingTypeEnum,
			String returnable, String taxable, String chargeShipping,
			String autoCreateKeywords, String includeInPromotions,
			String isVirtual, String isVariant,
			String virtualVariantMethodEnum, String originGeoId,
			String requirementMethodEnumId, Long billOfMaterialLevel,
			Double reservMaxPersons, Double reserv2ndPPPerc,
			Double reservNthPPPerc, String configId, Date createdDate,
			String createdByUserLogin, Date lastModifiedDate,
			String lastModifiedByUserLogin, String inShippingBox,
			String defaultShipmentBoxTypeId, Date lastUpdatedStamp,
			Date lastUpdatedTxStamp, Date createdStamp, Date createdTxStamp) {
		this.productId = productId;
		this.productTypeId = productTypeId;
		this.primaryProductCategoryId = primaryProductCategoryId;
		this.manufacturerPartyId = manufacturerPartyId;
		this.facilityId = facilityId;
		this.introductionDate = introductionDate;
		this.supportDiscontinuationDate = supportDiscontinuationDate;
		this.salesDiscontinuationDate = salesDiscontinuationDate;
		this.salesDiscWhenNotAvail = salesDiscWhenNotAvail;
		this.internalName = internalName;
		this.brandName = brandName;
		this.comments = comments;
		this.productName = productName;
		this.description = description;
		this.longDescription = longDescription;
		this.priceDetailText = priceDetailText;
		this.smallImageUrl = smallImageUrl;
		this.mediumImageUrl = mediumImageUrl;
		this.largeImageUrl = largeImageUrl;
		this.detailImageUrl = detailImageUrl;
		this.originalImageUrl = originalImageUrl;
		this.detailScreen = detailScreen;
		this.inventoryMessage = inventoryMessage;
		this.requireInventory = requireInventory;
		this.quantityUomId = quantityUomId;
		this.quantityIncluded = quantityIncluded;
		this.piecesIncluded = piecesIncluded;
		this.requireAmount = requireAmount;
		this.fixedAmount = fixedAmount;
		this.amountUomTypeId = amountUomTypeId;
		this.weightUomId = weightUomId;
		this.weight = weight;
		this.heightUomId = heightUomId;
		this.productHeight = productHeight;
		this.shippingHeight = shippingHeight;
		this.widthUomId = widthUomId;
		this.productWidth = productWidth;
		this.shippingWidth = shippingWidth;
		this.depthUomId = depthUomId;
		this.productDepth = productDepth;
		this.shippingDepth = shippingDepth;
		this.productRating = productRating;
		this.ratingTypeEnum = ratingTypeEnum;
		this.returnable = returnable;
		this.taxable = taxable;
		this.chargeShipping = chargeShipping;
		this.autoCreateKeywords = autoCreateKeywords;
		this.includeInPromotions = includeInPromotions;
		this.isVirtual = isVirtual;
		this.isVariant = isVariant;
		this.virtualVariantMethodEnum = virtualVariantMethodEnum;
		this.originGeoId = originGeoId;
		this.requirementMethodEnumId = requirementMethodEnumId;
		this.billOfMaterialLevel = billOfMaterialLevel;
		this.reservMaxPersons = reservMaxPersons;
		this.reserv2ndPPPerc = reserv2ndPPPerc;
		this.reservNthPPPerc = reservNthPPPerc;
		this.configId = configId;
		this.createdDate = createdDate;
		this.createdByUserLogin = createdByUserLogin;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedByUserLogin = lastModifiedByUserLogin;
		this.inShippingBox = inShippingBox;
		this.defaultShipmentBoxTypeId = defaultShipmentBoxTypeId;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}

	// Property accessors

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductTypeId() {
		return this.productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getPrimaryProductCategoryId() {
		return this.primaryProductCategoryId;
	}

	public void setPrimaryProductCategoryId(String primaryProductCategoryId) {
		this.primaryProductCategoryId = primaryProductCategoryId;
	}

	public String getManufacturerPartyId() {
		return this.manufacturerPartyId;
	}

	public void setManufacturerPartyId(String manufacturerPartyId) {
		this.manufacturerPartyId = manufacturerPartyId;
	}

	public String getFacilityId() {
		return this.facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public Date getIntroductionDate() {
		return this.introductionDate;
	}

	public void setIntroductionDate(Date introductionDate) {
		this.introductionDate = introductionDate;
	}

	public Date getSupportDiscontinuationDate() {
		return this.supportDiscontinuationDate;
	}

	public void setSupportDiscontinuationDate(Date supportDiscontinuationDate) {
		this.supportDiscontinuationDate = supportDiscontinuationDate;
	}

	public Date getSalesDiscontinuationDate() {
		return this.salesDiscontinuationDate;
	}

	public void setSalesDiscontinuationDate(Date salesDiscontinuationDate) {
		this.salesDiscontinuationDate = salesDiscontinuationDate;
	}

	public String getSalesDiscWhenNotAvail() {
		return this.salesDiscWhenNotAvail;
	}

	public void setSalesDiscWhenNotAvail(String salesDiscWhenNotAvail) {
		this.salesDiscWhenNotAvail = salesDiscWhenNotAvail;
	}

	public String getInternalName() {
		return this.internalName;
	}

	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLongDescription() {
		return this.longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getPriceDetailText() {
		return this.priceDetailText;
	}

	public void setPriceDetailText(String priceDetailText) {
		this.priceDetailText = priceDetailText;
	}

	public String getSmallImageUrl() {
		return this.smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}

	public String getMediumImageUrl() {
		return this.mediumImageUrl;
	}

	public void setMediumImageUrl(String mediumImageUrl) {
		this.mediumImageUrl = mediumImageUrl;
	}

	public String getLargeImageUrl() {
		return this.largeImageUrl;
	}

	public void setLargeImageUrl(String largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}

	public String getDetailImageUrl() {
		return this.detailImageUrl;
	}

	public void setDetailImageUrl(String detailImageUrl) {
		this.detailImageUrl = detailImageUrl;
	}

	public String getOriginalImageUrl() {
		return this.originalImageUrl;
	}

	public void setOriginalImageUrl(String originalImageUrl) {
		this.originalImageUrl = originalImageUrl;
	}

	public String getDetailScreen() {
		return this.detailScreen;
	}

	public void setDetailScreen(String detailScreen) {
		this.detailScreen = detailScreen;
	}

	public String getInventoryMessage() {
		return this.inventoryMessage;
	}

	public void setInventoryMessage(String inventoryMessage) {
		this.inventoryMessage = inventoryMessage;
	}

	public String getRequireInventory() {
		return this.requireInventory;
	}

	public void setRequireInventory(String requireInventory) {
		this.requireInventory = requireInventory;
	}

	public String getQuantityUomId() {
		return this.quantityUomId;
	}

	public void setQuantityUomId(String quantityUomId) {
		this.quantityUomId = quantityUomId;
	}

	public Double getQuantityIncluded() {
		return this.quantityIncluded;
	}

	public void setQuantityIncluded(Double quantityIncluded) {
		this.quantityIncluded = quantityIncluded;
	}

	public Long getPiecesIncluded() {
		return this.piecesIncluded;
	}

	public void setPiecesIncluded(Long piecesIncluded) {
		this.piecesIncluded = piecesIncluded;
	}

	public String getRequireAmount() {
		return this.requireAmount;
	}

	public void setRequireAmount(String requireAmount) {
		this.requireAmount = requireAmount;
	}

	public Double getFixedAmount() {
		return this.fixedAmount;
	}

	public void setFixedAmount(Double fixedAmount) {
		this.fixedAmount = fixedAmount;
	}

	public String getAmountUomTypeId() {
		return this.amountUomTypeId;
	}

	public void setAmountUomTypeId(String amountUomTypeId) {
		this.amountUomTypeId = amountUomTypeId;
	}

	public String getWeightUomId() {
		return this.weightUomId;
	}

	public void setWeightUomId(String weightUomId) {
		this.weightUomId = weightUomId;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getHeightUomId() {
		return this.heightUomId;
	}

	public void setHeightUomId(String heightUomId) {
		this.heightUomId = heightUomId;
	}

	public Double getProductHeight() {
		return this.productHeight;
	}

	public void setProductHeight(Double productHeight) {
		this.productHeight = productHeight;
	}

	public Double getShippingHeight() {
		return this.shippingHeight;
	}

	public void setShippingHeight(Double shippingHeight) {
		this.shippingHeight = shippingHeight;
	}

	public String getWidthUomId() {
		return this.widthUomId;
	}

	public void setWidthUomId(String widthUomId) {
		this.widthUomId = widthUomId;
	}

	public Double getProductWidth() {
		return this.productWidth;
	}

	public void setProductWidth(Double productWidth) {
		this.productWidth = productWidth;
	}

	public Double getShippingWidth() {
		return this.shippingWidth;
	}

	public void setShippingWidth(Double shippingWidth) {
		this.shippingWidth = shippingWidth;
	}

	public String getDepthUomId() {
		return this.depthUomId;
	}

	public void setDepthUomId(String depthUomId) {
		this.depthUomId = depthUomId;
	}

	public Double getProductDepth() {
		return this.productDepth;
	}

	public void setProductDepth(Double productDepth) {
		this.productDepth = productDepth;
	}

	public Double getShippingDepth() {
		return this.shippingDepth;
	}

	public void setShippingDepth(Double shippingDepth) {
		this.shippingDepth = shippingDepth;
	}

	public Double getProductRating() {
		return this.productRating;
	}

	public void setProductRating(Double productRating) {
		this.productRating = productRating;
	}

	public String getRatingTypeEnum() {
		return this.ratingTypeEnum;
	}

	public void setRatingTypeEnum(String ratingTypeEnum) {
		this.ratingTypeEnum = ratingTypeEnum;
	}

	public String getReturnable() {
		return this.returnable;
	}

	public void setReturnable(String returnable) {
		this.returnable = returnable;
	}

	public String getTaxable() {
		return this.taxable;
	}

	public void setTaxable(String taxable) {
		this.taxable = taxable;
	}

	public String getChargeShipping() {
		return this.chargeShipping;
	}

	public void setChargeShipping(String chargeShipping) {
		this.chargeShipping = chargeShipping;
	}

	public String getAutoCreateKeywords() {
		return this.autoCreateKeywords;
	}

	public void setAutoCreateKeywords(String autoCreateKeywords) {
		this.autoCreateKeywords = autoCreateKeywords;
	}

	public String getIncludeInPromotions() {
		return this.includeInPromotions;
	}

	public void setIncludeInPromotions(String includeInPromotions) {
		this.includeInPromotions = includeInPromotions;
	}

	public String getIsVirtual() {
		return this.isVirtual;
	}

	public void setIsVirtual(String isVirtual) {
		this.isVirtual = isVirtual;
	}

	public String getIsVariant() {
		return this.isVariant;
	}

	public void setIsVariant(String isVariant) {
		this.isVariant = isVariant;
	}

	public String getVirtualVariantMethodEnum() {
		return this.virtualVariantMethodEnum;
	}

	public void setVirtualVariantMethodEnum(String virtualVariantMethodEnum) {
		this.virtualVariantMethodEnum = virtualVariantMethodEnum;
	}

	public String getOriginGeoId() {
		return this.originGeoId;
	}

	public void setOriginGeoId(String originGeoId) {
		this.originGeoId = originGeoId;
	}

	public String getRequirementMethodEnumId() {
		return this.requirementMethodEnumId;
	}

	public void setRequirementMethodEnumId(String requirementMethodEnumId) {
		this.requirementMethodEnumId = requirementMethodEnumId;
	}

	public Long getBillOfMaterialLevel() {
		return this.billOfMaterialLevel;
	}

	public void setBillOfMaterialLevel(Long billOfMaterialLevel) {
		this.billOfMaterialLevel = billOfMaterialLevel;
	}

	public Double getReservMaxPersons() {
		return this.reservMaxPersons;
	}

	public void setReservMaxPersons(Double reservMaxPersons) {
		this.reservMaxPersons = reservMaxPersons;
	}

	public Double getReserv2ndPPPerc() {
		return this.reserv2ndPPPerc;
	}

	public void setReserv2ndPPPerc(Double reserv2ndPPPerc) {
		this.reserv2ndPPPerc = reserv2ndPPPerc;
	}

	public Double getReservNthPPPerc() {
		return this.reservNthPPPerc;
	}

	public void setReservNthPPPerc(Double reservNthPPPerc) {
		this.reservNthPPPerc = reservNthPPPerc;
	}

	public String getConfigId() {
		return this.configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
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

	public String getInShippingBox() {
		return this.inShippingBox;
	}

	public void setInShippingBox(String inShippingBox) {
		this.inShippingBox = inShippingBox;
	}

	public String getDefaultShipmentBoxTypeId() {
		return this.defaultShipmentBoxTypeId;
	}

	public void setDefaultShipmentBoxTypeId(String defaultShipmentBoxTypeId) {
		this.defaultShipmentBoxTypeId = defaultShipmentBoxTypeId;
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