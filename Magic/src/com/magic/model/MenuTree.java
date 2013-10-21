package com.magic.model;

import java.util.List;


public class MenuTree extends ExtTree{
	
	private static final long serialVersionUID = 1L;
	
	private String path;
	
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @param id
	 * @param text
	 * @param leaf
	 * @param href
	 * @param iconCls
	 * @param children
	 * @param path
	 */
	public MenuTree(String id, String text, boolean leaf, String href,
			String iconCls, List<MenuTree> children, String path) {
		super(id, text, leaf, href, iconCls, children);
		this.path = path;
	}
	
}
