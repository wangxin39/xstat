package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 检测客户信息
 */
public class ClientInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5657553607565414024L;
	/**
	 * 客户编号
	 */
	private Long clientID = null;
	
	/**
	 * 公司名称
	 */
	private String company = null;
	/**
	 * 公司名称
	 */
	private String enCompany = null;
	/**
	 * 描述
	 */
	private String description = null;

	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public ClientInfo() {
		super();
	}
	
	
	public ClientInfo(Long clientID, String company, String enCompany,
			String description, Integer status) {
		super();
		this.clientID = clientID;
		this.company = company;
		this.enCompany = enCompany;
		this.description = description;
		this.status = status;
	}
	/**
	 * 获取客户编号
	 */
	public Long getClientID() {
		return clientID;
	}
	/**
	 * 设置客户编号
	 */
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	
	/**
	 * 获取公司名称
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * 设置公司名称
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 获取描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEnCompany() {
		return enCompany;
	}
	public void setEnCompany(String enCompany) {
		this.enCompany = enCompany;
	}
	
}
