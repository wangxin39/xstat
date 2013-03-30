package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * �����ʾ��˹�����
 */
public class RemarkInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8451804955699802244L;
	/**
	 * ������
	 */
	private Long remarkID = null;
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
	 * �����������
	 */
	private Long informantID = null;
	/**
	 *  �ͻ����
	 */
	private Long inquisitionID = null;
	/**
	 * ���ع˿ͱ��
	 */
	private Long partID = null;
	/**
	 * �����������
	 */
	private Long employeeID = null;
	/**
	 * �����������
	 */
	private String strengths = null;
	/**
	 * �����������
	 */
	private String enStrengths = null;
	/**
	 * �����ʾ���
	 */
	private String weaknesses = null;
	
	/**
	 * �����������
	 */
	private String enWeaknesses = null;
	/**
	 * ������
	 */
	private String conclusion = null;
	
	/**
	 * ����
	 */
	private String enConclusion = null;

	/**
	 * ���ʱ��
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
	 * ��ȡ������
	 */
	public Long getRemarkID() {
		return remarkID;
	}
	/**
	 * ����������
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
	 * ��ȡʱ��
	 */
	public Timestamp getAddTime() {
		return addTime;
	}
	/**
	 * ����ʱ��
	 */
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}
