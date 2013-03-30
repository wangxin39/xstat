package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * ��Ŀ��Ϣ
 */
public class ProjectInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8416261777586572836L;
	/**
	 * ��Ŀ���
	 */
	private Long projectID = null;
	/**
	 * �ͻ����
	 */
	private Long clientID = null;
	/**
	 * ����
	 */
	private String description =null;
	/**
	 * �������
	 */
	private String name =null;
	/**
	 * �������
	 */
	private String englishName =null;
	/**
	 * ״̬
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
	 * ��ȡ�ͻ����
	 */
	public Long getClientID() {
		return clientID;
	}
	/**
	 * ���ÿͻ����
	 */
	public void setClientID(Long clientID) {
		this.clientID = clientID;
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
	 * ��ȡ״̬
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * ����״̬
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * ��ȡ�������
	 */
	public String getName() {
		return name;
	}
	/**
	 * ���ü������
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ��ȡ��Ŀ���
	 */
	public Long getProjectID() {
		return projectID;
	}
	/**
	 * ������Ŀ���
	 */
	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}
	
}
