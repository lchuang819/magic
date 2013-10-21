/**
 * Powered by Lchuang @2011
 * Tel: 15810848558
 * E-mail: lchuang819@163.com
 */
package com.frm.webtools.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.magic.entitymodel.BuildGroupMenus;
import com.magic.entitymodel.BuildMenus;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 *
 */
public class LoadUserMenusService extends BaseService{
	
	public static final String module = LoadUserMenusService.class.getName();

	/* (non-Javadoc)
	 * @see com.magic.service.IService#excute(java.util.Map)
	 */
	public Map loadMenusService(Map context) throws ExecuteServiceException{
		
		String userLoginId = (String)context.get("userLoginId");
		Debug.logInfo("LoadUserMenusService input userLoginId "+userLoginId, module);
		if(UtilValidate.isEmpty(userLoginId)){
			return ServiceUtil.returnError("用户名为空");
		}
		
		List labelList = new ArrayList();
		
		try {
			
			List<BuildGroupMenus> buildGroupMenus = delegator.find("from BuildGroupMenus as bgm where bgm.id.groupId in (select ulsg.id.groupId from UserLoginSecurityGroup as ulsg where ulsg.id.userLoginId=?)", userLoginId);
			if(buildGroupMenus == null || buildGroupMenus.size() ==0){
				ServiceUtil.returnError("查询用户菜单失败");
			}
			
			List menuIds = new LinkedList();
			
			for(BuildGroupMenus groupMenu : buildGroupMenus){
				String groupMenuId = groupMenu.getId().getMenuId();
				BuildMenus buildMenu = (BuildMenus)delegator.findById(BuildMenus.class, groupMenuId);
				if(UtilValidate.isEmpty(buildMenu)){
					Debug.logWarning("Menu " + groupMenuId +" in BuildGroupMenus but not in BuildMenus", module);
					continue;
				}
				//MenuTree tree = new MenuTree(buildMenu.getMenuId(), buildMenu.getMenuName(), Boolean.valueOf(buildMenu.getIsroot()), buildMenu.getContentPath(), buildMenu.getIconCls(), new ArrayList(), "");
				Map tree = new HashMap();
				
				String menuId = buildMenu.getMenuId();
				tree.put("id", menuId);
				tree.put("text", buildMenu.getMenuName());
				tree.put("iconCls", buildMenu.getIconCls());
				tree.put("isroot", buildMenu.getIsroot());
				tree.put("html", buildMenu.getContentPath());
				tree.put("jsPath", "");
				
				if(!menuIds.contains(menuId)){
					labelList.add(tree);
					menuIds.add(menuId);
				}
			}
			
		} catch (Exception e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException(e.getMessage());
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("labelList", labelList);
		return returnMap;
	}
	
	/**
	 * 加载用户菜单
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map loadUsersMenuService(Map context) throws ExecuteServiceException {
		String userLoginId = (String)context.get("userLoginId");
		Debug.logInfo("LoadUserMenusService input userLoginId "+userLoginId, module);
		if(UtilValidate.isEmpty(userLoginId)){
			return ServiceUtil.returnError("用户名为空，无法加载用户菜单");
		}
		
		List<BuildGroupMenus> buildGroupMenus = delegator.find("from BuildGroupMenus as bgm where bgm.id.groupId in (select ulsg.id.groupId from UserLoginSecurityGroup as ulsg where ulsg.id.userLoginId=?)", userLoginId);
		if(UtilValidate.isEmpty(buildGroupMenus)){
			Debug.logError("User " + userLoginId +" no menu.", module);
			ServiceUtil.returnError("查询用户菜单失败");
		}
		
		List menuIds = new LinkedList();
		
		for(BuildGroupMenus groupMenu : buildGroupMenus){
			String groupMenuId = groupMenu.getId().getMenuId();
			menuIds.add(groupMenuId);
		}
		
		Debug.logInfo("User "+userLoginId + " have menu: " + menuIds, module);
		
		List<BuildMenus> menus = delegator.findByProperty(BuildMenus.class, "isroot", "true");
		
		List labelList = new ArrayList();
		
		for(BuildMenus rootMenu : menus){
			String rootMenuId = rootMenu.getMenuId();
			
			if(!menuIds.contains(rootMenuId)){
				continue;
			}
			Debug.logInfo("User "+userLoginId + " have rootMenu: " + rootMenuId, module);
			labelList.add(getMenuMap(rootMenu));
			
			List<BuildMenus> childrenMenus = delegator.findByProperty(BuildMenus.class, "parentId", rootMenuId);
			for(BuildMenus childMenu : childrenMenus){
				String childMenuId = childMenu.getMenuId();
				if(!menuIds.contains(childMenuId)){
					continue;
				}
				Debug.logInfo("User "+userLoginId + "has childMenuId: " + childMenuId, module);
				labelList.add(getMenuMap(childMenu));
			}
			
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("labelList", labelList);
		return returnMap;
	}
	
	private Map getMenuMap(BuildMenus menu){
		Map menuMap = new HashMap();
		menuMap.put("id", menu.getMenuId());
		menuMap.put("text", menu.getMenuName());
		menuMap.put("iconCls", menu.getIconCls());
		menuMap.put("isroot", menu.getIsroot());
		menuMap.put("html", menu.getContentPath());
		menuMap.put("jsPath", "");
		return menuMap;
	}

}
