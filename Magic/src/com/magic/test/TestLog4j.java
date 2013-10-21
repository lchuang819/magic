/**
 * Powered by Chuang.Liu @2011-10-13
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.magic.test;

import java.io.FileNotFoundException;
import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.AsyncAppender;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.spi.LoggerRepository;
import org.springframework.util.Log4jConfigurer;

/**
 * @author lchuang
 * @2011-10-13
 */
public class TestLog4j {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Log4jConfigurer.initLogging("E:/workspace/Magic/Magic/WEB-INF/env/log4j.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Logger logger = Logger.getRootLogger();
		logger.setLevel(Level.INFO);
		

	}

}
