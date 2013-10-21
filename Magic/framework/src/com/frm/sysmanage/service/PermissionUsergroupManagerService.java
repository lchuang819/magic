/**
 * Powered by Chuang.Liu @2011-10-9
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.sysmanage.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.apps.party.constant.PartyConstant;
import com.apps.party.entitymodel.Party;
import com.apps.party.entitymodel.PartyGroup;
import com.apps.party.entitymodel.Person;
import com.frm.security.entitymodel.UserLogin;
import com.frm.security.entitymodel.UserLoginSecurityGroup;
import com.frm.security.entitymodel.UserLoginSecurityGroupId;
import com.magic.entity.GenericEntityException;
import com.magic.model.CheckTree;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-10-9
 */
public class PermissionUsergroupManagerService extends BaseService  {

	public static final String module = PermissionUsergroupManagerService.class.getName();

	/**
	 * 为用户非配组，即设置用户角色
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		
		String groupId = (String)context.get("groupId");
		String operation = (String)context.get("operation");
		String checked = (String)context.get("checked");
		String userId = (String)context.get("userId");
		boolean isChecked = Boolean.valueOf(checked);
		
		try {
			
			List userGroups = delegator.find("from UserLoginSecurityGroup as ulsg where ulsg.id.userLoginId=? and ulsg.id.groupId=?", userId, groupId);
			//新增
			if(UtilValidate.isEmpty(userGroups) && isChecked){
				UserLoginSecurityGroupId id = new UserLoginSecurityGroupId(userId, groupId, new Date());
				UserLoginSecurityGroup userGroup = new UserLoginSecurityGroup(id);
				delegator.saveOrUpdate(userGroup);
				
			}else if(!UtilValidate.isEmpty(userGroups) && !isChecked){
				UserLoginSecurityGroup userGroup = (UserLoginSecurityGroup)userGroups.get(0);
				delegator.deleteEntity(userGroup);
			}
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("查询用户安全组失败");
		}
		
		return null;
	}
	
	/**
	 * 加载用户树
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map executeLoadUsertree(Map context)throws ExecuteServiceException {
		
		String groupId = (String)context.get("groupId");
		Debug.logInfo("executeLoadUsertree groupId:"+groupId, module);
		
		try {
			
			//查询所有根节点
			List<UserLogin> userLogins = delegator.find("from UserLogin bm where bm.enabled<>?", "N");
			
			ArrayList userTrees = new ArrayList();
			
			for(UserLogin userLogin : userLogins){
				String userLoginId = userLogin.getUserLoginId();
				String nickName = "";
				String partyId = userLogin.getPartyId();
				
				//如果UserLogin存在PartyId则查询party name.
				if(UtilValidate.isNotEmpty(partyId)){
					Party party = delegator.findById(Party.class, partyId);
					if(UtilValidate.isNotEmpty(party)){
						nickName = getUserLoginName(party);
					}
				}
				
				if(UtilValidate.isEmpty(nickName)){
					nickName = userLoginId;
				}
				
				boolean checked = containsUser(userLogin, groupId);
				
				CheckTree usertree = new CheckTree(userLoginId, "["+userLoginId+"]"+nickName, true, "#", "icon-plugin", null, checked);
				userTrees.add(usertree);
			}
			context.put("userTrees", userTrees);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("查询用户登陆信息失败");
		}
		
		
		
		return context;
	}

	public boolean containsUser(UserLogin userLogin, String groupId){
		boolean isExist = false;
		
		try {
			
			List userGroups = delegator.find("from UserLoginSecurityGroup as ulsg where ulsg.id.userLoginId=? and ulsg.id.groupId=?", userLogin.getUserLoginId(), groupId);
			if(userGroups == null || userGroups.size() == 0){
				 return isExist;
			}else{
				isExist = true;
			}
		} catch (Exception e) {
			Debug.logError(e, module);
		}
		
		return isExist;
	}
	
	/**
	 * 如果UserLogin中创建了partyId则根据PartyId查询party name
	 * @param party
	 * @return
	 */
	private String getUserLoginName(Party party){
		String nickName = "";
		String partyType = party.getPartyTypeId();
		if(PartyConstant.PARTY_TYPE_PERSON.equals(partyType)){
			Person person = delegator.findById(Person.class, party.getPartyId());
			if(UtilValidate.isEmpty(person)){
				return nickName;
			}
			
			String firstName = person.getFirstName();
			String lastName = person.getLastName();
			if(UtilValidate.isNotEmpty(firstName)){
				nickName = firstName;
			}
			if(UtilValidate.isNotEmpty(lastName)){
				nickName = nickName + lastName;
			}
			
		}else if(PartyConstant.PARTY_TYPE_PARTY_GROUP.equals(partyType)){
			PartyGroup partyGroup = delegator.findById(PartyGroup.class, party.getPartyId());
			if(UtilValidate.isEmpty(partyGroup)){
				return nickName;
			}
			
			String groupName = partyGroup.getGroupName();
			if(UtilValidate.isNotEmpty(groupName)){
				nickName = groupName;
			}
		}
		
		return nickName;
	}
}
