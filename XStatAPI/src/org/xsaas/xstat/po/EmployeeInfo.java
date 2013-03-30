package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 员工信息
 */
public class EmployeeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6431534716890176672L;
	/**
	 * 员工编号
	 */
	private Long employeeID = null;
	/**
	 * 真实姓名
	 */
	private String name = null;
	/**
	 * 性别
	 */
	private String sex = null;
	/**
	 * 部门
	 */
	private String depart = null;
	/**
	 * 职位
	 */
	private String job = null;
	/**
	 * 岗位描述
	 */
	private String description = null;
	/**
	 * 登录名称
	 */
	private String loginName = null;
	/**
	 * 添加时间
	 */
	private Timestamp addTime = null;
	/**
	 * 登录密码
	 */
	private String passWord = null;
	/**
	 * 状态
	 */
	private Integer status = null;
	
	
	public EmployeeInfo() {
		super();
		
	}

	public EmployeeInfo(Long employeeID, String name, String loginName,
			Timestamp addTime, String passWord, Integer status, String sex,
			String depart, String job, String description) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.loginName = loginName;
		this.addTime = addTime;
		this.passWord = passWord;
		this.status = status;
		this.sex = sex;
		this.depart = depart;
		this.job = job;
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
	 * 获取登录姓名
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * 设置登录姓名 
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * 获取时间
	 */
	public Timestamp getAddTime() {
		return addTime;
	}
	/**
	 * 设置时间
	 */
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取密码
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * 设置密码
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
	 * 获取性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取部门
	 */
	public String getDepart() {
		return depart;
	}
	/**
	 * 设置部门
	 */
	public void setDepart(String depart) {
		this.depart = depart;
	}
	/**
	 * 获取职位
	 */
	public String getJob() {
		return job;
	}
	/**
	 * 设置职位
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * 获取姓名
	 */

	public String getName() {
		return name;
	}

	/**
	 * 设置姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取岗位描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置岗位描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
}
