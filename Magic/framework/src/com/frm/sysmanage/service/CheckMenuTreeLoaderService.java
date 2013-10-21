/**
 * Powered by Chuang.Liu @2011-10-8
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.sysmanage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.frm.content.ContentConstant;
import com.frm.content.entitymodel.Content;
import com.frm.security.entitymodel.SecurityGroupPermission;
import com.frm.security.entitymodel.SecurityGroupPermissionId;
import com.magic.entity.GenericEntityException;
import com.magic.model.CheckTree;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-10-8
 */
public class CheckMenuTreeLoaderService extends BaseService {

	public static final String module = CheckMenuTreeLoaderService.class.getName();
	
	/* (non-Javadoc)
	 * @see com.magic.service.IService#excute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		

		String username = (String)context.get("username");
		
		String groupId = (String)context.get("groupId");
		
		if(UtilValidate.isEmpty(username) && UtilValidate.isEmpty(groupId)){
			Debug.logInfo("groupId and username is empty.", module);
			return ServiceUtil.returnSuccess();
		}
		
		Debug.logInfo("username is "+username, module);
		
		List<String> groupIds = null;
		try {
			groupIds = delegator.find("Select ulsg.id.groupId from UserLoginSecurityGroup as ulsg where ulsg.id.userLoginId=?", username);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("查询用户安全组失败");
		}
		
//		List groupIds = new ArrayList();
//		
//		for(UserLoginSecurityGroup userSecGroup : groupIds){
//			groupIds.add(userSecGroup.getId().getGroupId());
//		}
		
		if(UtilValidate.isNotEmpty(groupId)){
			if(!groupIds.contains(groupId)){
				groupIds.add(groupId);
			}
		}
		
		Debug.logInfo("username in group:"+groupIds, module);
		
		//查询所有根节点
		List<Content> rootContents = null;
		try {
			rootContents = delegator.findByProperty(Content.class, "contentTypeId", ContentConstant.CONTENT_TYPE_MENU_ROOT);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("查询菜单失败");
		}
		
		ArrayList menuTrees = new ArrayList();
		
		for(Content rootContent : rootContents){
//			boolean isLeaf = Boolean.valueOf(rootContent.getIsroot());
			String rootContentId = rootContent.getContentId();
			
			boolean checked = containsMenu(rootContent, groupIds);
			
			CheckTree tree = new CheckTree(rootContentId, rootContent.getContentName(), false, "#", rootContent.getMimeTypeId(), null, checked);
			Debug.logInfo("Load root menu : " + tree.getText(), module);
			
			//查询根节点下的所有子节点
			List<Content> childrenContent = null;
			try {
				childrenContent = delegator.findByProperty(Content.class, "ownerContentId", rootContentId);
			} catch (GenericEntityException e) {
				Debug.logError(e, module);
				throw new ExecuteServiceException("查询菜单失败");
			}
			
			ArrayList children = new ArrayList();
			for(Content childContent : childrenContent){
				
				String childMenuId = childContent.getContentId();
				checked = containsMenu(childContent, groupIds);
				
				CheckTree leaf = new CheckTree(childMenuId, childContent.getContentName(), true, "#", childContent.getMimeTypeId(), null, checked);
				children.add(leaf);
			}
			
			//为根添加子节点集合
			tree.setChildren(children);
			menuTrees.add(tree);
		}
		
		context.put("menuTrees", menuTrees);
		return context;
	}
	
	public boolean containsMenu(Content content, List<String> groupIds){
		boolean isExist = false;
		
		for(String groupId : groupIds){
			try {
				SecurityGroupPermissionId id = new SecurityGroupPermissionId(groupId, content.getContentId());
				SecurityGroupPermission groupMenu = (SecurityGroupPermission)delegator.findById(SecurityGroupPermission.class, id);
				if(groupMenu != null){
					isExist = true;
					Debug.logInfo("groupId["+groupId+"] and menuId[" +content.getContentId()+"] exist!", module);
				}
				
			} catch (Exception e) {
				Debug.logError(e, module);
			}
		}
		
		return isExist;
	}

}
