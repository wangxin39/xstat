package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * ���ַ�����Ϣ
 */
public class InformantEvaluationInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1949876341978769854L;
	/**
	 * �������
	 */
	private Long evaluationID = null;
	/**
	 * ���
	 */
	private Integer year = null;
	/**
	 * ���
	 */
	private Integer month = null;

	private Integer day = null;
	private Timestamp checkTime = null;

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
	 * �������
	 */
	private Long partID = null;
	
	/**
	 * ����
	 */
	private Integer evaluation = null;
	
	public InformantEvaluationInfo() {
		super();
		
	}

	public Long getEvaluationID() {
		return evaluationID;
	}

	public void setEvaluationID(Long evaluationID) {
		this.evaluationID = evaluationID;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Timestamp getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
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

	public Long getInformantID() {
		return informantID;
	}

	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}

	public Long getPartID() {
		return partID;
	}

	public void setPartID(Long partID) {
		this.partID = partID;
	}

	public Integer getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}

	public InformantEvaluationInfo(Timestamp checkTime, Long clientID,
			Integer day, Integer evaluation, Long evaluationID,
			Long informantID, Long issueID, Integer month, Long partID,
			Long projectID, Integer year) {
		super();
		this.checkTime = checkTime;
		this.clientID = clientID;
		this.day = day;
		this.evaluation = evaluation;
		this.evaluationID = evaluationID;
		this.informantID = informantID;
		this.issueID = issueID;
		this.month = month;
		this.partID = partID;
		this.projectID = projectID;
		this.year = year;
	}



}
