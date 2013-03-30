package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 网站权限
 */
public class SitePopedomInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6962822474760150371L;
	/**
	 * 网站权限编号
	 */
	private Long sitePopedomID = null;
	/**
	 * 员工编号
	 */
	private Long employeeID = null;
	/**
	 * 权限
	 */
	private Integer popedom = null;
	
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public SitePopedomInfo() {
		super();
		
	}


	public SitePopedomInfo(Long sitePopedomID, Long employeeID,
			Integer popedom, Integer status) {
		super();
		this.sitePopedomID = sitePopedomID;
		this.employeeID = employeeID;
		this.popedom = popedom;
		this.status = status;
	}
	/**
	 * 获取网站权限编号
	 */
	public Long getSitePopedomID() {
		return sitePopedomID;
	}
	/**
	 * 设置网站权限编号
	 */
	public void setSitePopedomID(Long sitePopedomID) {
		this.sitePopedomID = sitePopedomID;
	}
	/**
	 * 获取员工编号
	 */
	public Long getEmployeeID() {
		return employeeID;
	}
	/**
	 * 设置员工编号
	 */
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	/**
	 * 获取权限
	 */
	public Integer getPopedom() {
		return popedom;
	}
	/**
	 * 设置权限 
	 */
	public void setPopedom(Integer popedom) {
		this.popedom = popedom;
	}

}
