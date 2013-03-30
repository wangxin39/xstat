package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * �������
 */
public class ReqResultInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7963754895207894491L;
	/**
	 * ���߱��
	 */
	private Long resultID = null;
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
	private String title =null;
	/**
	 * ����
	 */
	private String content =null;
	/**
	 * ����ʱ��
	 */
	private Timestamp reqTime = null;

	
	/**
	 * Ա�����
	 */
	private Long employeeID = null;
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public ReqResultInfo() {
		super();
	}
	


	public ReqResultInfo(Long resultID, Long reqID, Long accountID,
			String title, String content, Timestamp reqTime, Long employeeID,
			Integer status) {
		super();
		this.resultID = resultID;
		this.reqID = reqID;
		this.accountID = accountID;
		this.title = title;
		this.content = content;
		this.reqTime = reqTime;
		this.employeeID = employeeID;
		this.status = status;
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

	public Long getResultID() {
		return resultID;
	}

	public void setResultID(Long resultID) {
		this.resultID = resultID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
