package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 项目信息
 */
public class ProjectInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8416261777586572836L;
	/**
	 * 项目编号
	 */
	private Long projectID = null;
	/**
	 * 客户编号
	 */
	private Long clientID = null;
	/**
	 * 描述
	 */
	private String description =null;
	/**
	 * 检测名称
	 */
	private String name =null;
	/**
	 * 检测名称
	 */
	private String englishName =null;
	/**
	 * 状态
	 */
	private Integer status = null;
	
	public ProjectInfo() {
		super();
	}


	public ProjectInfo(Long projectID, Long clientID, String description,
			String name, String englishName, Integer status) {
		super();
		this.projectID = projectID;
		this.clientID = clientID;
		this.description = description;
		this.name = name;
		this.englishName = englishName;
		this.status = status;
	}


	public String getEnglishName() {
		return englishName;
	}


	public void setEnglishName(String englishName) {
		this.englishName = englishName;
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
	/**
	 * 获取状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取检测名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置检测名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取项目编号
	 */
	public Long getProjectID() {
		return projectID;
	}
	/**
	 * 设置项目编号
	 */
	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}
	
}
