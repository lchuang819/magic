/**
 * Powered by Chuang.Liu @2012-2-10
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.content.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.frm.content.ContentConstant;
import com.frm.content.entitymodel.Content;
import com.frm.security.entitymodel.SecurityGroupPermission;
import com.magic.entitymodel.BuildMenus;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * 内容服务
 * @2012-2-10
 */
public class ContentService extends BaseService {

	public static final String module = ContentService.class.getName();
	
	/**
	 * 加载用户菜单
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadMenuService(Map context) throws ExecuteServiceException{
		
		String userLoginId = (String)context.get("userLoginId");
		Debug.logInfo("Load menus for userLoginId "+userLoginId, module);
		
		if(UtilValidate.isEmpty(userLoginId)){
			return ServiceUtil.returnError("用户名为空，无法加载用户菜单");
		}
		
		List<String> contentIds = delegator.find("Select bgm.id.permissionId from SecurityGroupPermission as bgm where bgm.id.groupId in (select ulsg.id.groupId from UserLoginSecurityGroup as ulsg where ulsg.id.userLoginId=?)", userLoginId);
		if(UtilValidate.isEmpty(contentIds)){
			Debug.logError("User " + userLoginId +" no content.", module);
			ServiceUtil.returnError("查询用户菜单失败");
		}
		
//		List contentIds = new LinkedList();
//		
//		for(SecurityGroupPermission groupPermission : securityGroupPermission){
//			String groupContentId = groupPermission.getId().getPermissionId();
//			contentIds.add(groupContentId);
//		}
		
		Debug.logInfo("User "+userLoginId + " have content: " + contentIds, module);
		
		List<Content> rootContents = delegator.findByProperty(Content.class, "contentTypeId", ContentConstant.CONTENT_TYPE_MENU_ROOT);
		
		List labelList = new ArrayList();
		
		for(Content rootContent : rootContents){
			String rootContentId = rootContent.getContentId();
			
			if(!contentIds.contains(rootContentId)){
				continue;
			}
			Debug.logInfo("User "+userLoginId + " have rootContentId: " + rootContentId, module);
			labelList.add(getMenuMap(rootContent));
			
			List<Content> childrenContent = delegator.findByProperty(Content.class, "ownerContentId", rootContentId);
			for(Content childContent : childrenContent){
				String childContentId = childContent.getContentId();
				if(!contentIds.contains(childContentId)){
					continue;
				}
				Debug.logInfo("User "+userLoginId + "has childContentId: " + childContentId, module);
				labelList.add(getMenuMap(childContent));
			}
			
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("labelList", labelList);
		return returnMap;
	}
	
	private Map getMenuMap(Content content){
		Map menuMap = new HashMap();
		menuMap.put("id", content.getContentId());
		menuMap.put("text", content.getContentName());
		menuMap.put("iconCls", content.getMimeTypeId());
		menuMap.put("isroot", ContentConstant.CONTENT_TYPE_MENU_ROOT.equals(content.getContentTypeId()) ? "true" : "false");
		menuMap.put("html", content.getDescription());
		menuMap.put("jsPath", "");
		return menuMap;
	}
}
