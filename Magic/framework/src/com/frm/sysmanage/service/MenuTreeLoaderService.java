/**
 * Powered by Chuang.Liu @2011-9-29
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.sysmanage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.frm.content.ContentConstant;
import com.frm.content.entitymodel.Content;
import com.magic.entity.GenericEntityException;
import com.magic.model.MenuTree;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;

/**
 * @author lchuang
 * @2011-9-29
 */
public class MenuTreeLoaderService extends BaseService{

	public static final String module = MenuTreeLoaderService.class.getName();
	
	/**
	 * 菜单管理中菜单树加载服务
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {

		ArrayList menuTrees = new ArrayList();
		
		//查询所有根节点
		List<Content> rootContents = null;
		try {
			rootContents = delegator.findByProperty(Content.class, "contentTypeId", ContentConstant.CONTENT_TYPE_MENU_ROOT);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("查询菜单失败");
		}
		
		for(Content rootContent : rootContents){
//			boolean isLeaf = Boolean.valueOf(rootContent.getIsroot());
			String rootContentId = rootContent.getContentId();
			MenuTree tree = new MenuTree(rootContentId, rootContent.getContentName(), false, "#", rootContent.getMimeTypeId(), null, "#");
			Debug.logInfo("Load root content : " + rootContent.getContentName(), module);
			
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
				Debug.logInfo("Load leaf menu : " + childContent.getContentName(), module);
				MenuTree leaf = new MenuTree(childContent.getContentId(), childContent.getContentName(), true, "#", childContent.getMimeTypeId(), null, childContent.getDescription());
				children.add(leaf);
			}
			
			//为根添加子节点集合
			tree.setChildren(children);
			menuTrees.add(tree);
		}
		
		context.put("menuTrees", menuTrees);
		return context;
	}

}
