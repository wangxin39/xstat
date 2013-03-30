package org.xsaas.xstat.po;

import java.io.Serializable;

public class SmgkMenuInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8032807843802362618L;
	/**
	 * 菜单编号
	 */
	private Long menuID = null;
	/**
	 * 菜单名称
	 */
	private String menu = null;
	
	/**
	 * 链接地址
	 */
	private String url = null;
	
	public SmgkMenuInfo(Long menuID, String menu,
			String url) {
		super();
		this.menuID = menuID;
		this.menu = menu;
		this.url = url;
	}
	/**
	 * 
	 */
	public SmgkMenuInfo() {
		super();
	}
	/**
	 * 获取菜单编号
	 */
	public Long getMenuID() {
		return menuID;
	}
	/**
	 * 设置菜单编号
	 */
	public void setMenuID(Long menuID) {
		this.menuID = menuID;
	}
	/**
	 * 获取菜单名称
	 */
	public String getMenu() {
		return menu;
	}
	/**
	 * 设置菜单名称
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}
	/**
	 * 获取连接地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置链接地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
