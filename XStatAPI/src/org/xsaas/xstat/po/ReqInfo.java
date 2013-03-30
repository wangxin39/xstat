package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * �������
 */
public class ReqInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7963754895207894491L;
	/**
	 * ���߱��
	 */
	private Long reqID = null;
	/**
	 * �ͻ����
	 */
	private Long accountID = null;
	/**
	 * ����
	 */
	private String name =null;
	/**
	 * �����ʼ�
	 */
	private String email =null;
	/**
	 * �绰
	 */
	private String telephone =null;
	/**
	 * ״̬
	 */
	private Integer status = null;
	/**
	 * ����ʱ��
	 */
	private Timestamp reqTime = null;
	/**
	 * ����
	 */
	private String description =null;
	
	
	/**
	 * Ա�����
	 */
	private Long employeeID = null;
	
	/**
	 * ״̬
	 */
	private Integer reqStatus = null;
	
	
	public ReqInfo() {
		super();
	}
	
	
	public ReqInfo(Long reqID, Long accountID, String name, String email,
			String telephone, Integer status, Timestamp reqTime,
			String description, Long employeeID, Integer reqStatus) {
		super();
		this.reqID = reqID;
		this.accountID = accountID;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.status = status;
		this.reqTime = reqTime;
		this.description = description;
		this.employeeID = employeeID;
		this.reqStatus = reqStatus;
	}


	public Integer getReqStatus() {
		return reqStatus;
	}


	public void setReqStatus(Integer reqStatus) {
		this.reqStatus = reqStatus;
	}


	/**
	 * ��ȡ���߱��
	 */
	
	public Long getReqID() {
		return reqID;
	}

	/**
	 * �������߱��
	 */
	public void setReqID(Long reqID) {
		this.reqID = reqID;
	}
	
	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
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
	 * ��ȡ����ʱ��
	 */
	public Timestamp getReqTime() {
		return reqTime;
	}
	/**
	 * ��������ʱ��
	 */
	public void setReqTime(Timestamp reqTime) {
		this.reqTime = reqTime;
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
	 * ��ȡ����
	 */
	public String getName() {
		return name;
	}

	/**
	 * ��������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ�����ʼ�
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * ���õ����ʼ�
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * ��ȡ�绰
	 */

	public String getTelephone() {
		return telephone;
	}

	/**
	 * ���õ绰
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
