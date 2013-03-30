package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * ���ͻ���Ϣ
 */
public class ClientInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5657553607565414024L;
	/**
	 * �ͻ����
	 */
	private Long clientID = null;
	
	/**
	 * ��˾����
	 */
	private String company = null;
	/**
	 * ��˾����
	 */
	private String enCompany = null;
	/**
	 * ����
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
	 * ��ȡ��˾����
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * ���ù�˾����
	 */
	public void setCompany(String company) {
		this.company = company;
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
	public String getEnCompany() {
		return enCompany;
	}
	public void setEnCompany(String enCompany) {
		this.enCompany = enCompany;
	}
	
}
