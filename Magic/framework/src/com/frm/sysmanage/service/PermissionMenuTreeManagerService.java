/**
 * Powered by Chuang.Liu @2011-10-9
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.sysmanage.service;

import java.util.Map;

import com.frm.content.entitymodel.Content;
import com.frm.security.entitymodel.SecurityGroupPermission;
import com.frm.security.entitymodel.SecurityGroupPermissionId;
import com.magic.entitymodel.BuildGroupMenus;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;

/**
 * @author lchuang
 * @2011-10-9
 */
public class PermissionMenuTreeManagerService extends BaseService{

	public static final String module = PermissionMenuTreeManagerService.class.getName();
	/* (non-Javadoc)
	 * @see com.magic.service.IService#excute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		String groupId = (String) context.get("groupId");
		String menuId = (String) context.get("menuId");
		String checked = (String) context.get("checked");
		Debug.logInfo("excute groupId:"+groupId, module);
		Debug.logInfo("excute menuId:"+menuId, module);
		Debug.logInfo("excute checked:"+checked, module);
		
		boolean isChecked = Boolean.valueOf(checked);
		
		try {
			Content content = (Content)delegator.findById(Content.class, menuId);
			String menuName = content.getContentName();
			
			SecurityGroupPermissionId id = new SecurityGroupPermissionId(groupId, menuId);
			
			SecurityGroupPermission groupMenus = (SecurityGroupPermission) delegator.findById(SecurityGroupPermission.class, id);
			
			//如果用户组未分配该菜单，并且该菜单用户已选中
			//新增用户组菜单
			if(groupMenus == null && isChecked){
				groupMenus = new SecurityGroupPermission(id);
				boolean saveResult = delegator.saveOrUpdate(groupMenus);
				if(!saveResult){
					return ServiceUtil.returnError("用户添加菜单失败");
				}
			}
			
			//如果用户组已分配该菜单，并且该菜单用户不选中
			//撤销用户组菜单
			if(groupMenus != null && !isChecked){
				boolean saveResult = delegator.deleteEntity(groupMenus);
				if(!saveResult){
					return ServiceUtil.returnError("用户撤销菜单失败");
				}
			}
		} catch (Exception e) {
			Debug.logError(e, module);
		}
		
		return ServiceUtil.returnSuccess();
	}
}
