package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 被检测对象
 */
public class IssueInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5339431922945403316L;

	private Long issueID = null;
	/**
	 * 项目编号
	 */
	private Long projectID = null;
	/**
	 * 客户编号
	 */
	private Long clientID = null;
	/**
	 * 调查问卷编号
	 */
	private Long inquisitionID = null;
	/**
	 * 期次
	 */
	private String issue = null;
	/**
	 * 开始日期
	 */
	private String startDay = null;
	/**
	 * 结束日期
	 */
	private String endDay = null;
	/**
	 * 开始时间
	 */
	private String startTime = null;
	/**
	 * 结束时间
	 */
	private String endTime = null;
	/**
	 * 检测时间
	 */
	private Timestamp checkTime = null;
	/**
	 * 年
	 */
	private Integer year = null;
	/**
	 * 是否当前年第一期检测
	 */
	private Integer isFirst = null;
	/**
	 * 期次执行动作
	 * 1：问卷调查
	 * 2：系统评分
	 * 3：人工评论
	 * 4：报告处理
	 */
	private Integer actions = null;
	/**
	 * 统计图状态
	 * 1：末开始
	 * 2：进行中
	 * 3：已完成
	 */
	private Integer chartStatus = null;
	/**
	 * 评论状态
	 * 1：末开始
	 * 2：进行中
	 * 3：已完成
	 */
	private Integer evaluationStatus = null;
	/**
	 * 统计状态
	 * 1：末开始
	 * 2：进行中
	 * 3：已完成
	 * 
	 */
	private Integer statStatus = null;
	/**
	 * 报告状态
	 * 1：末开始
	 * 2：进行中
	 * 3：已完成
	 */
	private Integer reportStatus = null;
	/**
	 * 状态
	 * 1：正常
	 * 2：删除
	 */
	private Integer status = null;
	/**
	 * 增加时间
	 */
	private Timestamp addTime = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	public IssueInfo() {
		super();
		
	}

	/**
	 * 获取项目编号
	 */

	public Long getProjectID() {
		return projectID;
	}

	/**
	 * 设置项目编号
	 */

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	/**
	 * 获取客户编号
	 */

	public Long getClientID() {
		return clientID;
	}


	/**
	 * 设置客户编号
	 */
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public Long getIssueID() {
		return issueID;
	}

	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}

	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}
	
	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Integer getActions() {
		return actions;
	}

	public void setActions(Integer actions) {
		this.actions = actions;
	}

	public Integer getChartStatus() {
		return chartStatus;
	}
	public void setChartStatus(Integer chartStatus) {
		this.chartStatus = chartStatus;
	}
	public Integer getEvaluationStatus() {
		return evaluationStatus;
	}

	public void setEvaluationStatus(Integer evaluationStatus) {
		this.evaluationStatus = evaluationStatus;
	}

	public Integer getStatStatus() {
		return statStatus;
	}

	public void setStatStatus(Integer statStatus) {
		this.statStatus = statStatus;
	}

	public Integer getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(Integer reportStatus) {
		this.reportStatus = reportStatus;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Timestamp getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getIsFirst() {
		return isFirst;
	}
	public void setIsFirst(Integer isFirst) {
		this.isFirst = isFirst;
	}
	public IssueInfo(Integer actions, Timestamp addTime, Integer chartStatus,
			Timestamp checkTime, Long clientID, String endDay, String endTime,
			Integer evaluationStatus, Long inquisitionID, Integer isFirst,
			String issue, Long issueID, Long projectID, Integer reportStatus,
			String startDay, String startTime, Integer statStatus,
			Integer status, Integer year) {
		super();
		this.actions = actions;
		this.addTime = addTime;
		this.chartStatus = chartStatus;
		this.checkTime = checkTime;
		this.clientID = clientID;
		this.endDay = endDay;
		this.endTime = endTime;
		this.evaluationStatus = evaluationStatus;
		this.inquisitionID = inquisitionID;
		this.isFirst = isFirst;
		this.issue = issue;
		this.issueID = issueID;
		this.projectID = projectID;
		this.reportStatus = reportStatus;
		this.startDay = startDay;
		this.startTime = startTime;
		this.statStatus = statStatus;
		this.status = status;
		this.year = year;
	}
}
