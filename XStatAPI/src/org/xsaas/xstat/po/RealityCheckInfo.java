package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 邮件通讯录
 */
public class RealityCheckInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9004661157642885558L;
	
	/**
	 * 通讯录编号
	 */
	private Long realityCheckID = null;
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
	 * 城市编号
	 */
	private Long inquisitionID = null;
	/**
	 * 姓名
	 */
	private String thisTime = null;
	/**
	 * 联系电话
	 */
	private String enThisTime = null;
	/**
	 * 通讯地址
	 */
	private String soFarTime = null;
	/**
	 * 电子邮件
	 */
	private String enSoFarTime = null;
	/**
	 * QQ
	 */
	private String markReal = null;
	/**
	 * MSN
	 */
	private String enMarkReal = null;
	
	private Integer status = null;
	
	private Timestamp addTime = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public RealityCheckInfo() {
		super();
		
	}
	
	public RealityCheckInfo(Long realityCheckID, Long clientID, Long projectID,
			Long issueID, Long inquisitionID, String thisTime,
			String enThisTime, String soFarTime, String enSoFarTime,
			String markReal, String enMarkReal, Integer status,
			Timestamp addTime) {
		super();
		this.realityCheckID = realityCheckID;
		this.clientID = clientID;
		this.projectID = projectID;
		this.issueID = issueID;
		this.inquisitionID = inquisitionID;
		this.thisTime = thisTime;
		this.enThisTime = enThisTime;
		this.soFarTime = soFarTime;
		this.enSoFarTime = enSoFarTime;
		this.markReal = markReal;
		this.enMarkReal = enMarkReal;
		this.status = status;
		this.addTime = addTime;
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
	public Long getIssueID() {
		return issueID;
	}
	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}
	public Long getRealityCheckID() {
		return realityCheckID;
	}
	public void setRealityCheckID(Long realityCheckID) {
		this.realityCheckID = realityCheckID;
	}
	
	public Long getInquisitionID() {
		return inquisitionID;
	}
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}
	
	public String getThisTime() {
		return thisTime;
	}
	public void setThisTime(String thisTime) {
		this.thisTime = thisTime;
	}
	public String getEnThisTime() {
		return enThisTime;
	}
	public void setEnThisTime(String enThisTime) {
		this.enThisTime = enThisTime;
	}
	public String getSoFarTime() {
		return soFarTime;
	}
	public void setSoFarTime(String soFarTime) {
		this.soFarTime = soFarTime;
	}
	public String getEnSoFarTime() {
		return enSoFarTime;
	}
	public void setEnSoFarTime(String enSoFarTime) {
		this.enSoFarTime = enSoFarTime;
	}
	public String getMarkReal() {
		return markReal;
	}
	public void setMarkReal(String markReal) {
		this.markReal = markReal;
	}
	public String getEnMarkReal() {
		return enMarkReal;
	}
	public void setEnMarkReal(String enMarkReal) {
		this.enMarkReal = enMarkReal;
	}
	public Timestamp getAddTime() {
		return addTime;
	}
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	
}
