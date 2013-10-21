/**
 * Powered by Chuang.Liu @2011-9-29
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.sysmanage.service;

import java.util.Map;

import com.frm.content.entitymodel.Content;
import com.magic.constant.Constant;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;

/**
 * @author lchuang
 * @2011-9-29
 */
public class MenuTreeManageService extends BaseService  {

	public static final String module = MenuTreeManageService.class.getName();
	/* (non-Javadoc)
	 * @see com.magic.service.IService#excute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean manageBuildMenus(String operation, Content content){
		
		try {
			
			if(Constant.OPERATION_ADD.equals(operation) || Constant.OPERATION_MOD.equals(operation)){
				
				return delegator.saveOrUpdate(content);
			}else if(Constant.OPERATION_DEL.equals(operation)){
				
				return delegator.deleteEntity(content);
			}
		} catch (Exception e) {
			Debug.logError(e, module);
			return false;
		}
		
		return true;
	}

}
