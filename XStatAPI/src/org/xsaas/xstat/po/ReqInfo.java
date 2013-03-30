package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 检测申诉
 */
public class ReqInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7963754895207894491L;
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
	private String name =null;
	/**
	 * 电子邮件
	 */
	private String email =null;
	/**
	 * 电话
	 */
	private String telephone =null;
	/**
	 * 状态
	 */
	private Integer status = null;
	/**
	 * 申诉时间
	 */
	private Timestamp reqTime = null;
	/**
	 * 描述
	 */
	private String description =null;
	
	
	/**
	 * 员工编号
	 */
	private Long employeeID = null;
	
	/**
	 * 状态
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

	/**
	 * 获取名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取电子邮件
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置电子邮件
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取电话
	 */

	public String getTelephone() {
		return telephone;
	}

	/**
	 * 设置电话
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
