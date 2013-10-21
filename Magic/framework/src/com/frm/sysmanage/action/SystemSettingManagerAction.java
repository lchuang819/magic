/**
 * Powered by Chuang.Liu @2011-10-10
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.sysmanage.action;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.util.WebUtils;

import com.frm.sysmanage.model.LogLevel;
import com.frm.sysmanage.model.LogParamsSetting;
import com.frm.sysmanage.service.SystemSettingManagerService;
import com.magic.constant.Constant;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-10-10
 */
@SuppressWarnings("serial")
public class SystemSettingManagerAction extends ActionSupport {

	public static final String module = SystemSettingManagerAction.class.getName();
	
	private LogParamsSetting logParamsSetting;
	
	private LogLevel logLevel;
	
	private SystemSettingManagerService systemSettingManagerService;
	
	/**
	 * @return the logParamsSetting
	 */
	public LogParamsSetting getLogParamsSetting() {
		return logParamsSetting;
	}

	/**
	 * @param logParamsSetting the logParamsSetting to set
	 */
	public void setLogParamsSetting(LogParamsSetting logParamsSetting) {
		this.logParamsSetting = logParamsSetting;
	}
	
	/**
	 * @return the logLevel
	 */
	public LogLevel getLogLevel() {
		return logLevel;
	}

	/**
	 * @param logLevel the logLevel to set
	 */
	public void setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
	}

	/**
	 * @return the systemSettingManagerService
	 */
	public SystemSettingManagerService getSystemSettingManagerService() {
		return systemSettingManagerService;
	}

	/**
	 * @param systemSettingManagerService the systemSettingManagerService to set
	 */
	public void setSystemSettingManagerService(
			SystemSettingManagerService systemSettingManagerService) {
		this.systemSettingManagerService = systemSettingManagerService;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext servletContext = ServletActionContext.getServletContext();
		
		Map paramMap = request.getParameterMap();
		Debug.logInfo("paramMap:"+paramMap, module);
		
		String rootLevel = request.getParameter("rootLevel");
		logLevel.setLoggerName("root");
		logLevel.setLevel(rootLevel);
		
		
		String actionType = request.getParameter("actionType");
		Debug.logInfo("actionType:"+actionType, module);

		//web.xml中日志文件配置路径
		String log4jConfigLocation = servletContext.getInitParameter("log4jConfigLocation");
		//日志配置文件绝对路径
		String log4jConfigAbsolutePath = dealConfigFilePath(servletContext, log4jConfigLocation);
	    try {
	    	Map inputMap = new HashMap();
			
			//保存页面对配置文件的修改
			if(Constant.ACTIONTYPE_LOG.equals(actionType)){
				
				logParamsSetting.setConfigFileAbsolutePath(log4jConfigAbsolutePath);
				inputMap.put("logParamsSetting", logParamsSetting);
				inputMap.put("logLevel", logLevel);
				Map resultMap = systemSettingManagerService.executeLogSetting(inputMap);
				if(ServiceUtil.isError(resultMap)){
					CommonUtil.outFailureJson(ServletActionContext.getResponse(), ServiceUtil.getErrorMessage(resultMap));
					return null;
				}
				
			}else if(Constant.ACTIONTYPE_BASEPARAMS.equals(actionType)){
				//保存页面对基本参数的修改
				systemSettingManagerService.executeBaseParamsSetting(inputMap);
				
			}else if(Constant.ACTIONTYPE_LOG_LOAD.equals(actionType)){
				
				Debug.logInfo("Constant.ACTIONTYPE_LOG_LOAD actionType:"+Constant.ACTIONTYPE_LOG_LOAD, module);
				
				LogParamsSetting logParamsSetting = new LogParamsSetting();
				logParamsSetting.setConfigFile(log4jConfigLocation);
				logParamsSetting.setConfigFileAbsolutePath(log4jConfigAbsolutePath);
				
				inputMap.put("logParamsSetting", logParamsSetting);
				//调用配置文件加载服务
				Map resultMap = systemSettingManagerService.executeLoadLogSetting(inputMap);
				if(ServiceUtil.isError(resultMap)){
					CommonUtil.outFailureJson(ServletActionContext.getResponse(), ServiceUtil.getErrorMessage(resultMap));
					return null;
				}
				
				JSONObject json = JSONObject.fromObject(resultMap.get("returnJson"));
				CommonUtil.outJson(ServletActionContext.getResponse(), json);
				
				
			}
			
		} catch (Exception e) {
			Debug.logInfo(e, module);
		}
		
		
		return null;
	}
	
	/**
	 * 使用Spring工具处理日志配置文件路径
	 * @param servletContext
	 * @param location
	 * @return
	 */
	public String dealConfigFilePath(ServletContext servletContext, String location){
		
		if (location != null){
			
	      try{
	        if (!ResourceUtils.isUrl(location)){
	          location = SystemPropertyUtils.resolvePlaceholders(location);
	          location = WebUtils.getRealPath(servletContext, location);
	          
	          Debug.logInfo("WebUtils getRealPath location:"+location, module);
	        }

	      }
	      catch (FileNotFoundException ex){
	    	  Debug.logInfo(ex, module);
	    	  throw new IllegalArgumentException("Invalid 'log4jConfigLocation' parameter: " + ex.getMessage());
	      }
	      
	    }
		
		return location;
	}
}
