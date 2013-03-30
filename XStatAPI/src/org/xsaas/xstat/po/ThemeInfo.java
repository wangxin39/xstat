package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * ������Ϣ
 */
public class ThemeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6637352219217225296L;
	/**
	 * ������
	 */
	private Long themeID = null;

	/**
	 * ��������
	 */
	private Integer status = null;

	/**
	 * ����
	 */
	private String description = null;
	/**
	 * ��������
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
	 * ��ȡ����
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * ��������
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ��ȡ��������
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * ���ñ�������
	 */

	public void setTitle(String title) {
		this.title = title;
	}

}
