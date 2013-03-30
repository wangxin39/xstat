package org.xsaas.xstat.po;

import java.io.Serializable;

public class MenuInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8032807843802362618L;
	
	private Long menuID = null;
	
	private String menu = null;
	
	private Integer type = null;
	
	private Long parentID = null;
	
	private String url = null;
	
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	public MenuInfo(Long menuID, String menu, Integer type, Long parentID,
			String url, Integer status) {
		super();
		this.menuID = menuID;
		this.menu = menu;
		this.type = type;
		this.parentID = parentID;
		this.url = url;
		this.status = status;
	}
	public MenuInfo() {
		super();
	}
	
	public Long getMenuID() {
		return menuID;
	}
	
	public void setMenuID(Long menuID) {
		this.menuID = menuID;
	}
	
	public String getMenu() {
		return menu;
	}
	
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Long getParentID() {
		return parentID;
	}
	
	public void setParentID(Long parentID) {
		this.parentID = parentID;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
