/**
 * Powered by Chuang.Liu @2011-11-3
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.frm.common.entitymodel.Uom;
import com.magic.entity.GenericEntityException;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-11-3
 */
public class CommonService extends BaseService {

	public static final String module = CommonService.class.getName();
	
	/**
	 * 查询UOM信息
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map findUomInfoService(Map context) throws ExecuteServiceException{
		String uomId = (String) context.get("uomId");
		String uomTypeId = (String) context.get("uomTypeId");
		
		Map fields = new HashMap();
		
		if(UtilValidate.isNotEmpty(uomId)){
			fields.put("uomId", uomId);
		}
		if(UtilValidate.isNotEmpty(uomTypeId)){
			fields.put("uomTypeId", uomTypeId);
		}
		
		List<Uom> uoms = null;
		try {
			Debug.logInfo("Find Uom by condition " + fields, module);
			uoms = delegator.findByCondition(Uom.class, fields);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("查询UOM信息出现数据库异常");
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("uomList", uoms);
		return returnMap;
	}
}
