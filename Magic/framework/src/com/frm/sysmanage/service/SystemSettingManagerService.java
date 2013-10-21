/**
 * Powered by Chuang.Liu @2011-10-10
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.sysmanage.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.frm.sysmanage.model.LogLevel;
import com.frm.sysmanage.model.LogParamsSetting;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.FileUtil;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-10-10
 */
public class SystemSettingManagerService extends BaseService {

	public static final String module = SystemSettingManagerService.class.getName();
	/* (non-Javadoc)
	 * @see com.magic.service.IService#execute(java.util.Map)
	 */
	@Override
	public Map execute(Map context) throws ExecuteServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public Map executeLogSetting(Map context) throws ExecuteServiceException {
		LogLevel logLevel = (LogLevel)context.get("logLevel");
		String name = logLevel.getLoggerName();
		String level = logLevel.getLevel();
		Debug.logInfo(name+" 's level is " + level, module);
		
		Logger logger = null;
        if ("root".equals(name)) {
            logger = Logger.getRootLogger();
        } else if(UtilValidate.isNotEmpty(name)){
            logger = Logger.getLogger(name);
        }else{
        	Map returnMap = ServiceUtil.returnError("级别名称为空");
    		return returnMap;
        }
        
        logger.setLevel(Level.toLevel(level));
        logger.setAdditivity(true);
        
        Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}
	
	public Map executeBaseParamsSetting(Map<String, Object> context) throws ExecuteServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map executeLoadLogSetting(Map context) throws ExecuteServiceException {
		
		Debug.logInfo("lexecuteLoadLogSetting", module);
		LogParamsSetting logParamsSetting = (LogParamsSetting)context.get("logParamsSetting");
		
		String configFilePath = logParamsSetting.getConfigFile();
		String configFileAbsolutePath = logParamsSetting.getConfigFileAbsolutePath();
		String configFileContent = logParamsSetting.getConfigFileContent();
		
		Debug.logInfo("logParamsSetting's configFileAbsolutePath:"+configFileAbsolutePath, module);
		Debug.logInfo("logParamsSetting's configFile:"+configFilePath, module);
		Debug.logInfo("logParamsSetting's configFileContent:"+configFileContent, module);

		
		Map returnMap = ServiceUtil.returnSuccess();
		
		File configFile = new File(configFileAbsolutePath);
		try {
			StringBuffer configFileContentBuffer = FileUtil.readTextFile(configFile, true);
			logParamsSetting.setConfigFileContent(configFileContentBuffer.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Logger	rootLogger = Logger.getRootLogger();
		
		JSONObject returnLog4jInfo = new JSONObject();
		JSONObject log4jInfo = new JSONObject();
		log4jInfo.put("configFile", logParamsSetting.getConfigFile());
		log4jInfo.put("configFileContent", logParamsSetting.getConfigFileContent());
		
		log4jInfo.put("loggerName", rootLogger.getName());
		log4jInfo.put("level", rootLogger.getLevel().toString());
		JSONArray dataArray = new JSONArray();
		dataArray.add(log4jInfo);
		
		returnLog4jInfo.put("logParamsSettingData", dataArray);
		returnLog4jInfo.put("totalCount", dataArray.size());
		
		returnMap.put("returnJson", returnLog4jInfo);
		//returnMap.put("returnRootLevelInfo", returnRootLevelInfo);
		return returnMap;
	}
	
	public Map executeLoadBaseParamsSetting(Map context) throws ExecuteServiceException {
		// TODO Auto-generated method stub
		return null;
	}
}
