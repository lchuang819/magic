/**
 * Powered by Chuang.Liu @2011-10-10
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.frm.sysmanage.model;

/**
 * @author lchuang
 * @2011-10-10
 */
public class LogParamsSetting {

	private String logpath;
	
	private String configFile;
	
	private String configFileAbsolutePath;
	
	private String configFileContent;

	/**
	 * @return the logpath
	 */
	public String getLogpath() {
		return logpath;
	}

	/**
	 * @param logpath the logpath to set
	 */
	public void setLogpath(String logpath) {
		this.logpath = logpath;
	}

	/**
	 * @return the configFile
	 */
	public String getConfigFile() {
		return configFile;
	}

	/**
	 * @param configFile the configFile to set
	 */
	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

	/**
	 * @return the configFileContent
	 */
	public String getConfigFileContent() {
		return configFileContent;
	}

	/**
	 * @param configFileContent the configFileContent to set
	 */
	public void setConfigFileContent(String configFileContent) {
		this.configFileContent = configFileContent;
	}

	/**
	 * @return the configFileAbsolutePath
	 */
	public String getConfigFileAbsolutePath() {
		return configFileAbsolutePath;
	}

	/**
	 * @param configFileAbsolutePath the configFileAbsolutePath to set
	 */
	public void setConfigFileAbsolutePath(String configFileAbsolutePath) {
		this.configFileAbsolutePath = configFileAbsolutePath;
	}
	
}
