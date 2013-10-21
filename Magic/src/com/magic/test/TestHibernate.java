package com.magic.test;

import com.frm.security.entitymodel.UserLogin;
import com.frm.security.entitymodel.UserLoginHome;

public class TestHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//BuildMenusHome dao = new BuildMenusHome();
		//dao.
		//dao.findById("setting");
		UserLoginHome dao = new UserLoginHome();
		UserLogin userLogin = dao.findById("appuser");
		String pa = userLogin.getCurrentPassword();
		System.out.println(pa);
	}

}
