package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * ���ַ�����Ϣ
 */
public class StatPartInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1949876341978769854L;
	/**
	 * �������
	 */
	private Long statPartID = null;
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
	 * �����������
	 */
	private Long clientID = null;
	/**
	 * �����������
	 */
	private Long projectID = null;
	/**
	 * �����ʾ���
	 */
	private Long issueID = null;
	private Integer round = null;

	/**
	 * �����ʾ���
	 */
	private Long smgkID = null;
	/**
	 * �����������
	 */
	private Long informantID = null;
	/**
	 * �����������
	 */
	private Long inquisitionID = null;
	/**
	 * �����������
	 */
	private Long planID = null;
	
	/**
	 * �������
	 */
	private Long partID = null;
	
	/**
	 * ���
	 */
	private Integer weightedMark = null;
	/**
	 * ���
	 */
	private Integer actualMarks = null;
	
	/**
	 * ����ȫ������
	 */
	private Double percentage = null;
	
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	
	public StatPartInfo() {
		super();
		
	}

	public StatPartInfo(Long statPartID, Integer year, Integer month,
			Integer day, Timestamp checkTime, Long clientID, Long projectID,
			Long issueID, Integer round, Long smgkID, Long informantID,
			Long inquisitionID, Long planID, Long partID, Integer weightedMark,
			Integer actualMarks, Double percentage, Integer status) {
		super();
		this.statPartID = statPartID;
		this.year = year;
		this.month = month;
		this.day = day;
		this.checkTime = checkTime;
		this.clientID = clientID;
		this.projectID = projectID;
		this.issueID = issueID;
		this.round = round;
		this.smgkID = smgkID;
		this.informantID = informantID;
		this.inquisitionID = inquisitionID;
		this.planID = planID;
		this.partID = partID;
		this.weightedMark = weightedMark;
		this.actualMarks = actualMarks;
		this.percentage = percentage;
		this.status = status;
	}
	public Long getPartID() {
		return partID;
	}

	public void setPartID(Long partID) {
		this.partID = partID;
	}

	public Long getPlanID() {
		return planID;
	}

	public void setPlanID(Long planID) {
		this.planID = planID;
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
	public Integer getRound() {
		return round;
	}
	public void setRound(Integer round) {
		this.round = round;
	}
	public Long getSmgkID() {
		return smgkID;
	}
	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
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
	public Integer getWeightedMark() {
		return weightedMark;
	}

	public void setWeightedMark(Integer weightedMark) {
		this.weightedMark = weightedMark;
	}

	public Integer getActualMarks() {
		return actualMarks;
	}

	public void setActualMarks(Integer actualMarks) {
		this.actualMarks = actualMarks;
	}

	public Long getStatPartID() {
		return statPartID;
	}

	public void setStatPartID(Long statPartID) {
		this.statPartID = statPartID;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

}
