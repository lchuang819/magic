/**
 * Powered by Lchuang @2011
 * Tel: 15810848558
 * E-mail: lchuang819@163.com
 */
package com.magic.test;

import com.magic.util.HashCrypt;

/**
 * @author lchuang
 *
 */
public class TestSecurity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String p = HashCrypt.getDigestHash("ofbiz", "SHA");
		//System.out.println(p);
		
		String webroot = "${web.root}/log";
		String r = "/Magic";
		webroot = webroot.replaceAll("${web.root}", r);
		System.out.println(webroot);

	}

}
