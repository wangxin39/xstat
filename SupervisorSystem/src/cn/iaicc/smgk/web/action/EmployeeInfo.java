package cn.iaicc.smgk.web.action;

import java.io.Serializable;
import java.sql.Timestamp;


public class EmployeeInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8160532430119042792L;
	private Long id = null;
	private String employeeName = null;
	private String jobTitle = null;
	private Timestamp hireDate = null;
	private Boolean isActive = false;
	
	public EmployeeInfo() {
		super();
	}
	public EmployeeInfo(Long id,String employeeName,String jobTitle, Timestamp hireDate,Boolean isActive) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.jobTitle = jobTitle;
		this.hireDate = hireDate;
		this.isActive = isActive;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Timestamp getHireDate() {
		return hireDate;
	}
	public void setHireDate(Timestamp hireDate) {
		this.hireDate = hireDate;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
