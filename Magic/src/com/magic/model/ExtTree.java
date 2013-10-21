/**
 * Powered by Lchuang @2011
 * Tel: 15810848558
 * E-mail: lchuang819@163.com
 */
package com.magic.model;

import java.io.Serializable;
import java.util.List;


/**
 * @author lchuang
 *
 */
/**
 * @author lchuang
 *
 */
public class ExtTree implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String text;
	
	private boolean leaf;
	
	private String href;
	
	private String iconCls;
	
	private List<MenuTree> children;

	/**
	 * @param id
	 * @param text
	 * @param leaf
	 * @param href
	 * @param iconCls
	 * @param children
	 * @param checked
	 */
	public ExtTree(String id, String text, boolean leaf, String href,
			String iconCls, List<MenuTree> children) {
		super();
		this.id = id;
		this.text = text;
		this.leaf = leaf;
		this.href = href;
		this.iconCls = iconCls;
		this.children = children;
	}

	/**
	 * 
	 */
	public ExtTree() {
		super();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the leaf
	 */
	public boolean isLeaf() {
		return leaf;
	}

	/**
	 * @param leaf the leaf to set
	 */
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	/**
	 * @return the href
	 */
	public String getHref() {
		return href;
	}

	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * @return the iconCls
	 */
	public String getIconCls() {
		return iconCls;
	}

	/**
	 * @param iconCls the iconCls to set
	 */
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	/**
	 * @return the children
	 */
	public List<MenuTree> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<MenuTree> children) {
		this.children = children;
	}

	
	
	
}
