/**
 * Powered by Chuang.Liu @2011-10-20
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.magic.test;

import java.io.SequenceInputStream;

import org.hibernate.id.SequenceGenerator;
import org.hibernate.id.SequenceHiLoGenerator;
import org.hibernate.id.SequenceIdentityGenerator;

/**
 * @author lchuang
 * @2011-10-20
 */
public class TestSequenceUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SequenceHiLoGenerator();
		new SequenceGenerator().getSequenceName();
		new SequenceIdentityGenerator();
	}

}
