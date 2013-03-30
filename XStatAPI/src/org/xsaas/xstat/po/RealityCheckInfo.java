package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * �ʼ�ͨѶ¼
 */
public class RealityCheckInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9004661157642885558L;
	
	/**
	 * ͨѶ¼���
	 */
	private Long realityCheckID = null;
	/**
	 *  �ͻ����
	 */
	private Long clientID = null;
	
	/**
	 * �����ʾ���
	 */
	private Long projectID = null;
	/**
	 * �����������
	 */
	private Long issueID = null;

	/**
	 * ���б��
	 */
	private Long inquisitionID = null;
	/**
	 * ����
	 */
	private String thisTime = null;
	/**
	 * ��ϵ�绰
	 */
	private String enThisTime = null;
	/**
	 * ͨѶ��ַ
	 */
	private String soFarTime = null;
	/**
	 * �����ʼ�
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
