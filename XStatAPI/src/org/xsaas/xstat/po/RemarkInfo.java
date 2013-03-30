package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 调查问卷人工评语
 */
public class RemarkInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8451804955699802244L;
	/**
	 * 评语编号
	 */
	private Long remarkID = null;
	/**
	 *  客户编号
	 */
	private Long clientID = null;
	
	/**
	 * 调查问卷编号
	 */
	private Long projectID = null;
	/**
	 * 被调查对象编号
	 */
	private Long issueID = null;

	/**
	 * 被调查对象编号
	 */
	private Long informantID = null;
	/**
	 *  客户编号
	 */
	private Long inquisitionID = null;
	/**
	 * 神秘顾客编号
	 */
	private Long partID = null;
	/**
	 * 被调查对象编号
	 */
	private Long employeeID = null;
	/**
	 * 被调查对象编号
	 */
	private String strengths = null;
	/**
	 * 被调查对象编号
	 */
	private String enStrengths = null;
	/**
	 * 调查问卷编号
	 */
	private String weaknesses = null;
	
	/**
	 * 被调查对象编号
	 */
	private String enWeaknesses = null;
	/**
	 * 问题编号
	 */
	private String conclusion = null;
	
	/**
	 * 评语
	 */
	private String enConclusion = null;

	/**
	 * 添加时间
	 */
	private Timestamp addTime = null;
	
	private Integer status = null;
	
	private Integer remarkStatus = null;
	
	public RemarkInfo() {
		super();
		
	}


	public RemarkInfo(Long remarkID, Long clientID, Long projectID,
			Long issueID, Long informantID, Long inquisitionID, Long partID,
			Long employeeID, String strengths, String enStrengths,
			String weaknesses, String enWeaknesses, String conclusion,
			String enConclusion, Timestamp addTime, Integer status,
			Integer remarkStatus) {
		super();
		this.remarkID = remarkID;
		this.clientID = clientID;
		this.projectID = projectID;
		this.issueID = issueID;
		this.informantID = informantID;
		this.inquisitionID = inquisitionID;
		this.partID = partID;
		this.employeeID = employeeID;
		this.strengths = strengths;
		this.enStrengths = enStrengths;
		this.weaknesses = weaknesses;
		this.enWeaknesses = enWeaknesses;
		this.conclusion = conclusion;
		this.enConclusion = enConclusion;
		this.addTime = addTime;
		this.status = status;
		this.remarkStatus = remarkStatus;
	}


	public Long getIssueID() {
		return issueID;
	}

	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}

	public Long getPartID() {
		return partID;
	}

	public Long getClientID() {
		return clientID;
	}


	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}


	public Long getProjectID() {
		return projectID;
	}


	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}


	public void setPartID(Long partID) {
		this.partID = partID;
	}

	public Long getInformantID() {
		return informantID;
	}

	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}

	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public Integer getRemarkStatus() {
		return remarkStatus;
	}


	public void setRemarkStatus(Integer remarkStatus) {
		this.remarkStatus = remarkStatus;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取评语编号
	 */
	public Long getRemarkID() {
		return remarkID;
	}
	/**
	 * 设置评语编号
	 */
	public void setRemarkID(Long remarkID) {
		this.remarkID = remarkID;
	}

	public String getStrengths() {
		return strengths;
	}

	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}

	public String getEnStrengths() {
		return enStrengths;
	}

	public void setEnStrengths(String enStrengths) {
		this.enStrengths = enStrengths;
	}

	public String getWeaknesses() {
		return weaknesses;
	}

	public void setWeaknesses(String weaknesses) {
		this.weaknesses = weaknesses;
	}

	public String getEnWeaknesses() {
		return enWeaknesses;
	}

	public void setEnWeaknesses(String enWeaknesses) {
		this.enWeaknesses = enWeaknesses;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getEnConclusion() {
		return enConclusion;
	}

	public void setEnConclusion(String enConclusion) {
		this.enConclusion = enConclusion;
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

}
