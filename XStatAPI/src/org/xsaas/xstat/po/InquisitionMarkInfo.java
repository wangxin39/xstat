package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 部分平均分数信息
 */
public class InquisitionMarkInfo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1949876341978769854L;
	/**
	 * 分数编号
	 */
	private Long inquisitionMarkID = null;
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
	private Long inquisitionID = null;
	
	private Long projectID = null;
	/**
	 * 被调查对象编号
	 */
	private Long issueID = null;

	/**
	 *  客户编号
	 */
	private Long smgkID = null;
	/**
	 * 被调查对象编号
	 */
	private Long informantID = null;

	private Integer weightMarkRound1 = null;
	private Integer actualMarkRound1 = null;
	private Double scoreMarkRound1 = null;
	private Integer weightMarkRound2 = null;
	private Integer actualMarkRound2 = null;
	private Double scoreMarkRound2 = null;
	private Double average = null;
	
	public InquisitionMarkInfo() {
		super();
		
	}
	public InquisitionMarkInfo(Integer actualMarkRound1,
			Integer actualMarkRound2, Double average, Timestamp checkTime,
			Long clientID, Integer day, Long informantID, Long inquisitionID,
			Long inquisitionMarkID, Long issueID, Integer month,
			Long projectID, Double scoreMarkRound1, Double scoreMarkRound2,
			Long smgkID, Integer weightMarkRound1, Integer weightMarkRound2,
			Integer year) {
		super();
		this.actualMarkRound1 = actualMarkRound1;
		this.actualMarkRound2 = actualMarkRound2;
		this.average = average;
		this.checkTime = checkTime;
		this.clientID = clientID;
		this.day = day;
		this.informantID = informantID;
		this.inquisitionID = inquisitionID;
		this.inquisitionMarkID = inquisitionMarkID;
		this.issueID = issueID;
		this.month = month;
		this.projectID = projectID;
		this.scoreMarkRound1 = scoreMarkRound1;
		this.scoreMarkRound2 = scoreMarkRound2;
		this.smgkID = smgkID;
		this.weightMarkRound1 = weightMarkRound1;
		this.weightMarkRound2 = weightMarkRound2;
		this.year = year;
	}
	public Long getInquisitionMarkID() {
		return inquisitionMarkID;
	}

	public void setInquisitionMarkID(Long inquisitionMarkID) {
		this.inquisitionMarkID = inquisitionMarkID;
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

	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
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

	public Integer getWeightMarkRound1() {
		return weightMarkRound1;
	}

	public void setWeightMarkRound1(Integer weightMarkRound1) {
		this.weightMarkRound1 = weightMarkRound1;
	}

	public Integer getActualMarkRound1() {
		return actualMarkRound1;
	}

	public void setActualMarkRound1(Integer actualMarkRound1) {
		this.actualMarkRound1 = actualMarkRound1;
	}

	public Double getScoreMarkRound1() {
		return scoreMarkRound1;
	}

	public void setScoreMarkRound1(Double scoreMarkRound1) {
		this.scoreMarkRound1 = scoreMarkRound1;
	}

	public Integer getWeightMarkRound2() {
		return weightMarkRound2;
	}

	public void setWeightMarkRound2(Integer weightMarkRound2) {
		this.weightMarkRound2 = weightMarkRound2;
	}

	public Integer getActualMarkRound2() {
		return actualMarkRound2;
	}

	public void setActualMarkRound2(Integer actualMarkRound2) {
		this.actualMarkRound2 = actualMarkRound2;
	}

	public Double getScoreMarkRound2() {
		return scoreMarkRound2;
	}

	public void setScoreMarkRound2(Double scoreMarkRound2) {
		this.scoreMarkRound2 = scoreMarkRound2;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	
}
