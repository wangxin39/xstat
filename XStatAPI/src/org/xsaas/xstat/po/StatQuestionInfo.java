package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 部分分数信息
 */
public class StatQuestionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1949876341978769854L;
	/**
	 * 统计编号
	 */
	private Long statID = null;
	/**
	 * 年
	 */
	private Integer year = null;
	/**
	 * 月
	 */
	private Integer month = null;
	/**
	 * 日
	 */
	private Integer day = null;
	/**
	 * 检测时间
	 */
	private Timestamp checkTime = null;
	/**
	 * 客户编号
	 */
	private Long clientID = null;
	/**
	 * 项目编号
	 */
	private Long projectID = null;
	/**
	 * 期次编号
	 */
	private Long issueID = null;
	/**
	 * 轮次
	 */
	private Integer round = null;
	/**
	 * 调查问卷编号
	 */
	private Long smgkID = null;
	/**
	 * 被调查对象编号
	 */
	private Long informantID = null;
	/**
	 * 被调查对象编号
	 */
	private Long inquisitionID = null;
	/**
	 * 被调查对象编号
	 */
	private Long planID = null;
	/**
	 * 被调查对象编号
	 */
	private Long partID = null;
	/**
	 * 调查问卷编号
	 */
	private Long partQuestionID = null;
	/**
	 * 选项关系编号
	 */
	private Long optionRelationID = null;

	/**
	 * 部分问题选项编号
	 */
	private Long partSelectID = null;
	/**
	 * 权重
	 */
	private Integer weight = null;
	/**
	 * 分数
	 */
	private Integer marks = null;
	/**
	 * 状态
	 */
	private Integer status = null;
	
	public StatQuestionInfo() {
		super();
		
	}


	public Long getStatID() {
		return statID;
	}

	public void setStatID(Long statID) {
		this.statID = statID;
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

	public Long getPlanID() {
		return planID;
	}

	public void setPlanID(Long planID) {
		this.planID = planID;
	}

	public Long getPartID() {
		return partID;
	}

	public void setPartID(Long partID) {
		this.partID = partID;
	}

	public Long getPartQuestionID() {
		return partQuestionID;
	}

	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}

	public Long getPartSelectID() {
		return partSelectID;
	}

	public void setPartSelectID(Long partSelectID) {
		this.partSelectID = partSelectID;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getOptionRelationID() {
		return optionRelationID;
	}

	public void setOptionRelationID(Long optionRelationID) {
		this.optionRelationID = optionRelationID;
	}


	public StatQuestionInfo(Timestamp checkTime, Long clientID, Integer day,
			Long informantID, Long inquisitionID, Long issueID, Integer marks,
			Integer month, Long optionRelationID, Long partID,
			Long partQuestionID, Long partSelectID, Long planID,
			Long projectID, Integer round, Long smgkID, Long statID,
			Integer status, Integer weight, Integer year) {
		super();
		this.checkTime = checkTime;
		this.clientID = clientID;
		this.day = day;
		this.informantID = informantID;
		this.inquisitionID = inquisitionID;
		this.issueID = issueID;
		this.marks = marks;
		this.month = month;
		this.optionRelationID = optionRelationID;
		this.partID = partID;
		this.partQuestionID = partQuestionID;
		this.partSelectID = partSelectID;
		this.planID = planID;
		this.projectID = projectID;
		this.round = round;
		this.smgkID = smgkID;
		this.statID = statID;
		this.status = status;
		this.weight = weight;
		this.year = year;
	}

}
