package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 部分分数信息
 */
public class FinalEvaluationInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1949876341978769854L;
	/**
	 * 分数编号
	 */
	private Long finalEvaluationID = null;
	/**
	 * 年度
	 */
	private Integer year = null;
	/**
	 * 年度
	 */
	private Integer month = null;

	private Integer day = null;
	private Timestamp checkTime = null;

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
	 * 可能全部分数
	 */
	private Integer passNum = null;

	private Integer failNum = null;
	private Integer informantNum = null;	
	/**
	 * 平均值
	 */
	private Double average = null;
	

	
	public FinalEvaluationInfo() {
		super();
		
	}



	public FinalEvaluationInfo(Double average, Timestamp checkTime,
			Long clientID, Integer day, Integer failNum,
			Long finalEvaluationID, Integer informantNum, Long issueID,
			Integer month, Integer passNum, Long projectID, Integer year) {
		super();
		this.average = average;
		this.checkTime = checkTime;
		this.clientID = clientID;
		this.day = day;
		this.failNum = failNum;
		this.finalEvaluationID = finalEvaluationID;
		this.informantNum = informantNum;
		this.issueID = issueID;
		this.month = month;
		this.passNum = passNum;
		this.projectID = projectID;
		this.year = year;
	}



	public Long getFinalEvaluationID() {
		return finalEvaluationID;
	}



	public void setFinalEvaluationID(Long finalEvaluationID) {
		this.finalEvaluationID = finalEvaluationID;
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



	public Integer getPassNum() {
		return passNum;
	}



	public void setPassNum(Integer passNum) {
		this.passNum = passNum;
	}



	public Integer getFailNum() {
		return failNum;
	}



	public void setFailNum(Integer failNum) {
		this.failNum = failNum;
	}



	public Integer getInformantNum() {
		return informantNum;
	}



	public void setInformantNum(Integer informantNum) {
		this.informantNum = informantNum;
	}



	public Double getAverage() {
		return average;
	}



	public void setAverage(Double average) {
		this.average = average;
	}


}
