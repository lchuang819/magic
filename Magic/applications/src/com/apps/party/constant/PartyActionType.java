/**
 * Powered by Chuang.Liu @2011-10-18
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.constant;

/**
 * @author lchuang
 * @2011-10-18
 */
public interface PartyActionType {

	public static final String CREATE_PARTY_GROUP = "CreatePartyGroup";
	public static final String LOAD_PARTY_GROUP = "LoadPartyGroup";
	public static final String NEW_CUSTOMER = "NewCustomer";
	public static final String NEW_PERSON = "NewPerson";
	public static final String UPDATE_PARTY = "UpdateParty";
	public static final String UPDATE_PERSON = "UpdatePerson";
	public static final String UPDATE_PARTY_GROUP = "UpdatePartyGroup";
	public static final String DELETE_PARTY = "DeleteParty";
	
	public static final String CREATE_TELECOM_NUMBER = "CreateTelecomNumber";
	public static final String UPDATE_TELECOM_NUMBER = "UpdateTelecomNumber";
	public static final String CREATE_POSTAL_ADDRESS = "CreatePostalAddress";
	public static final String UPDATE_POSTAL_ADDRESS = "UpdatePostalAddress";
	public static final String CREATE_CONTACTMECH = "CreateContactMech";
	public static final String UPDATE_CONTACTMECH = "UpdateContactMech";
	
	public static final String CREATE_PARTY_ROLE = "CreatePartyRole";
	public static final String UPDATE_PARTY_ROLE = "UpdatePartyRole";
	public static final String DELETE_PARTY_ROLE = "DeletePartyRole";
	
	public static final String CREATE_PARTY_RELATIONSHIP = "CreatePartyRelationship";
	public static final String UPDATE_PARTY_RELATIONSHIP = "UpdatePartyRelationship";
	public static final String DELETE_PARTY_RELATIONSHIP = "DeletePartyRelationship";
	
	public static final String LOAD_PARTY_ENABLED = "LoadPartyEnabled";
	public static final String LOAD_PARTY_DISABLED = "LoadPartyDisabled";
	public static final String LOAD_PARTY = "LoadParty";
	public static final String LOAD_PARTY_BY_ROLE_TYPE = "LoadPartyByRoleType";
	public static final String LOAD_POSTAL_ADDRESS = "LoadPostalAddress";
	
	public static final String LOAD_CONTACT_MECH = "LoadContactMech";
	public static final String LOAD_CONTACT_MECH_TYPE = "LoadContactMechType";
	public static final String LOAD_CONTACT_MECH_BY_PARTY = "LoadContactMechByParty";
	
	public static final String LOAD_TELECOM_NUMBER = "LoadTelecomNumber";
	public static final String LOAD_TELECOM_NUMBER_BY_PARTY = "LoadTelecomNumberByParty";
	
	public static final String LOAD_GEO = "LoadGeo";
}
