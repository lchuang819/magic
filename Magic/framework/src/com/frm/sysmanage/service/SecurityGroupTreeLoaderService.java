/**
 * Powered by Chuang.Liu @2011-10-8
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.sysmanage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.frm.security.entitymodel.SecurityGroup;
import com.magic.entity.GenericEntityException;
import com.magic.model.ExtTree;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;

/**
 * @author lchuang
 * @2011-10-8
 */
public class SecurityGroupTreeLoaderService extends BaseService {

	public static final String module = SecurityGroupTreeLoaderService.class.getName();
	/* (non-Javadoc)
	 * @see com.magic.service.IService#excute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		
		List<SecurityGroup> securityGroups = null;
		try {
			securityGroups = delegator.findAll(SecurityGroup.class);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("查询用户安全组失败");
		}
		
		ArrayList groupTrees = new ArrayList();
		
		
		for(SecurityGroup securityGroup : securityGroups){
			ExtTree gt = new ExtTree();
			gt.setId(securityGroup.getGroupId());
			gt.setLeaf(true);
			gt.setText(securityGroup.getDescription());
			groupTrees.add(gt);
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("groupTrees", groupTrees);
		return returnMap;
	}

}
