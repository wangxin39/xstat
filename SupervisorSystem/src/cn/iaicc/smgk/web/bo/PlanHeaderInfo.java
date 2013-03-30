package cn.iaicc.smgk.web.bo;

import java.io.Serializable;

public class PlanHeaderInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6250224017844485100L;
	
	private String issue = null;
	private String clientName = null;
	private String company = null;
	private String projectName = null;
	private String userName = null;
	private String inquisition = null;
	private String name = null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getInquisition() {
		return inquisition;
	}
	public void setInquisition(String inquisition) {
		this.inquisition = inquisition;
	}
	public PlanHeaderInfo(String issue, String clientName, String company,
			String projectName, String userName, String inquisition, String name) {
		super();
		this.issue = issue;
		this.clientName = clientName;
		this.company = company;
		this.projectName = projectName;
		this.userName = userName;
		this.inquisition = inquisition;
		this.name = name;
	}
	public PlanHeaderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
