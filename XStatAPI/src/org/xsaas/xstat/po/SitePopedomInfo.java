package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * ��վȨ��
 */
public class SitePopedomInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6962822474760150371L;
	/**
	 * ��վȨ�ޱ��
	 */
	private Long sitePopedomID = null;
	/**
	 * Ա�����
	 */
	private Long employeeID = null;
	/**
	 * Ȩ��
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
	 * ��ȡ��վȨ�ޱ��
	 */
	public Long getSitePopedomID() {
		return sitePopedomID;
	}
	/**
	 * ������վȨ�ޱ��
	 */
	public void setSitePopedomID(Long sitePopedomID) {
		this.sitePopedomID = sitePopedomID;
	}
	/**
	 * ��ȡԱ�����
	 */
	public Long getEmployeeID() {
		return employeeID;
	}
	/**
	 * ����Ա�����
	 */
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	/**
	 * ��ȡȨ��
	 */
	public Integer getPopedom() {
		return popedom;
	}
	/**
	 * ����Ȩ�� 
	 */
	public void setPopedom(Integer popedom) {
		this.popedom = popedom;
	}

}
