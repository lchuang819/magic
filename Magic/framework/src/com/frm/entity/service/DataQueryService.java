/**
 * Powered by Chuang.Liu @2011-9-29
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.entity.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.magic.entity.GenericEntityException;
import com.magic.entitymodel.CountryCode;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.service.IService;
import com.magic.util.Debug;

/**
 * @author lchuang
 * @2011-9-29
 */
public class DataQueryService extends BaseService{

	public static final String module = DataQueryService.class.getName();
	/* (non-Javadoc)
	 * @see com.magic.service.IService#excute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		
		String limit = (String)context.get("limit");
		String sort = (String)context.get("sort");
		String start = (String)context.get("start");
		String dir = (String)context.get("dir");
		String callback = (String)context.get("callback");
		String _dc = (String)context.get("_dc");
		Debug.logInfo("limit:"+limit, module);
		Debug.logInfo("sort:"+sort, module);
		Debug.logInfo("start:"+start, module);
		Debug.logInfo("dir:"+dir, module);
		Debug.logInfo("callback:"+callback, module);
		Debug.logInfo("_dc:"+_dc, module);
		JSONArray array = new JSONArray();
//		JSONObject jsonData = new JSONObject();
//		jsonData.put("title", "lclclclc");
//		jsonData.put("author", "lclclclc");
//		jsonData.put("replycount", 123);
//		
//		array.add(jsonData);
//		json.put("topics", array);
//		json.put("totalCount", 1);
		
		List<CountryCode> returnList = null;
		try {
			returnList = delegator.findListForPage(CountryCode.class, Integer.parseInt(start), Integer.parseInt(limit), sort, dir);
		} catch (NumberFormatException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("查询国家代码失败");
		} catch (GenericEntityException e) {
			Debug.logError(e, module);
			throw new ExecuteServiceException("查询国家代码失败");
		}
		
		for(CountryCode country : returnList){
			String countryCode = country.getCountryCode();
			String countryAbbr = country.getCountryAbbr();
			String countryName = country.getCountryName();
			String countryNumber = country.getCountryNumber();
			
			JSONObject jsonData = new JSONObject();
			jsonData.put("countryCode", countryCode);
			jsonData.put("countryAbbr", countryAbbr);
			jsonData.put("countryName", countryName);
			jsonData.put("countryNumber", countryNumber);
			
			array.add(jsonData);
		}
		JSONObject json = new JSONObject();
		json.put("topics", array);
		json.put("totalCount", 244);
		context.put("returnData", json);
		return context;
		
	}

}
