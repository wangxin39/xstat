package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 检测申诉
 */
public class ReqResultInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7963754895207894491L;
	/**
	 * 申诉编号
	 */
	private Long resultID = null;
	/**
	 * 申诉编号
	 */
	private Long reqID = null;
	/**
	 * 客户编号
	 */
	private Long accountID = null;
	
	/**
	 * 名称
	 */
	private String title =null;
	/**
	 * 名称
	 */
	private String content =null;
	/**
	 * 申诉时间
	 */
	private Timestamp reqTime = null;

	
	/**
	 * 员工编号
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
	 * 获取申诉编号
	 */
	
	public Long getReqID() {
		return reqID;
	}

	/**
	 * 设置申诉编号
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
	 * 获取申诉时间
	 */
	public Timestamp getReqTime() {
		return reqTime;
	}
	/**
	 * 设置申诉时间
	 */
	public void setReqTime(Timestamp reqTime) {
		this.reqTime = reqTime;
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
