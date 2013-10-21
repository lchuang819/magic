/**
 * Powered by Chuang.Liu @2011-10-21
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.magic.test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.apps.party.entitymodel.PostalAddress;

/**
 * @author lchuang
 * @2011-10-21
 */
public class TestBeans {

	public static void main(String[] args) {
		PostalAddress p = new PostalAddress();
		//p.setContactMechId("130022");
		try {
			Map m = BeanUtils.describe(p);
			System.out.println(m);
			
			Map context = new HashMap();
			context.put("contactMechId2", "130023");
			
			BeanUtils.populate(p, context);
			System.out.println(p.getContactMechId());
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
