/**
 * Powered by Lchuang @2011
 * Tel: 15810848558
 * E-mail: lchuang819@163.com
 */
package com.magic.model;

import java.util.List;


/**
 * @author lchuang
 *
 */
public class CheckTree extends ExtTree {

	private boolean checked = false;
	
	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	/**
	 * @param id
	 * @param text
	 * @param leaf
	 * @param href
	 * @param iconCls
	 * @param children
	 * @param checked
	 */
	public CheckTree(String id, String text, boolean leaf, String href,
			String iconCls, List<MenuTree> children, boolean checked) {
		super(id, text, leaf, href, iconCls, children);
		this.checked = checked;
	}

	

	

	
}
