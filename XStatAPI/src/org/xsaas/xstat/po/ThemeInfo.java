package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 报告信息
 */
public class ThemeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6637352219217225296L;
	/**
	 * 报告编号
	 */
	private Long themeID = null;

	/**
	 * 报告类型
	 */
	private Integer status = null;

	/**
	 * 描述
	 */
	private String description = null;
	/**
	 * 报告名称
	 */
	private String title = null;
	
	public ThemeInfo() {
		super();
		
	}

	public ThemeInfo(Long themeID, Integer status, String description,
			String title) {
		super();
		this.themeID = themeID;
		this.status = status;
		this.description = description;
		this.title = title;
	}

	public Long getThemeID() {
		return themeID;
	}

	public void setThemeID(Long themeID) {
		this.themeID = themeID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
	 * 获取报告名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置报告名称
	 */

	public void setTitle(String title) {
		this.title = title;
	}

}
