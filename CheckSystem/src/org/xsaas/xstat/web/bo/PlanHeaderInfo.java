package org.xsaas.xstat.web.bo;

import java.io.Serializable;

public class PlanHeaderInfo implements Serializable {

	public PlanHeaderInfo(String company, String informantName,
			String inquisition, String issue, String projectName,
			String userName) {
		super();
		this.company = company;
		this.informantName = informantName;
		this.inquisition = inquisition;
		this.issue = issue;
		this.projectName = projectName;
		this.userName = userName;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -6250224017844485100L;
	
	private String issue = null;
	private String informantName = null;
	private String company = null;
	private String projectName = null;
	private String userName = null;
	private String inquisition = null;
	
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
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

	public PlanHeaderInfo() {
		super();		
	}
	public String getInformantName() {
		return informantName;
	}
	public void setInformantName(String informantName) {
		this.informantName = informantName;
	}
}
