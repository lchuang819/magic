/**
 * Powered by Chuang.Liu @2011-10-13
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.magic.test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.util.Map;
import java.util.Properties;



/**
 * @author lchuang
 * @2011-10-13
 */
public class TestJVM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties prop = System.getProperties();
		Map env = System.getenv();
		Runtime runtime = Runtime.getRuntime();
		int availableProcessors = runtime.availableProcessors();
		int totalMemory = (int)runtime.totalMemory()/1024;
		int freeMemory = (int)runtime.freeMemory()/1024;//虚拟机空闲内存量
		int maxMemory = (int)runtime.maxMemory()/1024;
		System.out.println(maxMemory);
		
		OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
		String arch = osBean.getArch();
		String name = osBean.getName();
		String version = osBean.getVersion();
		double systemLoadAverage = osBean.getSystemLoadAverage();
		
		MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
		
		System.out.println(systemLoadAverage);
		
	}

}
