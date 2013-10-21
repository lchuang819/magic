/**
 * Powered by Chuang.Liu @2011-10-23
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.party.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.apps.party.entitymodel.Geo;
import com.magic.entity.GenericEntityException;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-10-23
 */
public class GeoService extends BaseService {

	public static final String module = GeoService.class.getName();
	
	public Map loadGeoService(Map context) throws ExecuteServiceException{
		String geoId = (String) context.get("geoId");
		String geoTypeId = (String) context.get("geoTypeId");
		String geoSecCode = (String) context.get("geoSecCode");
		String geoName = (String) context.get("geoName");
		Map fields = new HashMap();
		
		if(UtilValidate.isNotEmpty(geoSecCode)){
			
			fields.put("geoSecCode", geoSecCode);
		}
//		if(UtilValidate.isNotEmpty(geoName)){
//			
//			fields.put("geoName", geoName);
//		}
		fields.put("geoTypeId", geoTypeId);
		
		List<Geo> geos = null;
		try {
			geos = delegator.findByCondition(Geo.class, fields);
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			return ServiceUtil.returnError("查询GEO错误，操作数据库时出现异常");
		}
		
		JSONArray geoArray = new JSONArray();
		for(Geo geo : geos){
			geoArray.add(geo);
		}
		
		JSONObject json = new JSONObject();
		json.put("dataset", geoArray);
		json.put("totalCount", geoArray.size());
		
		Map returnMap = ServiceUtil.returnSuccess();
		returnMap.put("returnData", json);
		return returnMap;
	}
	
	private JSONObject getGeoJson(Geo geo){
		JSONObject jsonData = new JSONObject();
		jsonData.put("geoId", geo.getGeoId());
		jsonData.put("geoTypeId", geo.getGeoTypeId());
		jsonData.put("geoName", geo.getGeoName());
		jsonData.put("geoCode", geo.getGeoCode());
		jsonData.put("geoSecCode", geo.getGeoSecCode());
		return jsonData;
	}
}
