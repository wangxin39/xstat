package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 计划信息表实体对象
 * 
 * 用于控制检测/测试
 * 
 * 
 */
public class PlanInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4425559861014281117L;
	/**
	 * 计划编号
	 */
	private Long planID = null;
	/**
	 * 计划名称
	 */
	private String name = null;
	/**
	 * 期次编号
	 */
	private Long issueID = null;
	/**
	 * 轮次
	 * 1：第一轮
	 * 2：第二轮
	 */
	private Integer round = null;
	/**
	 * 客户编号
	 */
	private Long clientID = null;
	
	/**
	 * 项目编号
	 */
	private Long projectID = null;
	/**
	 * 调查对象编号
	 */
	private Long informantID = null;
	/**
	 * 神秘客编号
	 */
	private Long smgkID = null;
	/**
	 * 任务编号
	 */
	private String jobID = null;
	/**
	 * 开始日期	
	 */
	private Timestamp startDay = null;
	/**
	 * 结束日期	
	 */	
	private Timestamp endDay = null;
	/**
	 * 开始时间	
	 */	
	private String startTime = null;
	/**
	 * 结束时间	
	 */	
	private String endTime = null;
	/**
	 * 权重模式
	 * 1：通用模式
	 * 2：个性模式	
	 */	
	private Integer weightPattern = null;
	/**
	 * 计划类型
	 * 1：调查
	 * 2：测试
	 */
	private Integer planType = null;
	/**
	 * 统计状态
	 * 1：末开始
	 * 2：进行中
	 * 3：已完成
	 */
	private Integer statStatus = null;
	/**
	 * 统计图状态
	 * 1：末开始
	 * 2：进行中
	 * 3：已完成
	 */
	private Integer chartStatus = null;
	/**
	 * 检测状态
	 * 1：正在检测
	 * 2：检测结束
	 * 3：检测作废
	 */	
	private Integer checkStatus = null;
	/**
	 * 评论状态
	 * 1：末开始
	 * 2：进行中
	 * 3：已完成
	 */
	private Integer evaluationStatus = null;
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
	
	

	public PlanInfo() {
		super();
	}



	public Integer getWeightPattern() {
		return weightPattern;
	}


	public void setWeightPattern(Integer weightPattern) {
		this.weightPattern = weightPattern;
	}


	public Integer getRound() {
		return round;
	}


	public void setRound(Integer round) {
		this.round = round;
	}


	public Integer getStatStatus() {
		return statStatus;
	}


	public void setStatStatus(Integer statStatus) {
		this.statStatus = statStatus;
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


	public Integer getReportStatus() {
		return reportStatus;
	}


	public void setReportStatus(Integer reportStatus) {
		this.reportStatus = reportStatus;
	}

	public Integer getCheckStatus() {
		return checkStatus;
	}


	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Timestamp getStartDay() {
		return startDay;
	}


	public void setStartDay(Timestamp startDay) {
		this.startDay = startDay;
	}


	public Timestamp getEndDay() {
		return endDay;
	}


	public void setEndDay(Timestamp endDay) {
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


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取顾客编号
	 */

	public Long getSmgkID() {
		return smgkID;
	}

	/**
	 * 设置顾客编号
	 */
	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
	}

	

	/**
	 * 获取计划编号
	 */

	public Long getPlanID() {
		return planID;
	}

	/**
	 * 设置计划编号
	 */

	public void setPlanID(Long planID) {
		this.planID = planID;
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


	public Long getProjectID() {
		return projectID;
	}


	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}


	public String getJobID() {
		return jobID;
	}


	public void setJobID(String jobID) {
		this.jobID = jobID;
	}


	public Long getInformantID() {
		return informantID;
	}


	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}



	public Integer getPlanType() {
		return planType;
	}



	public void setPlanType(Integer planType) {
		this.planType = planType;
	}



	public PlanInfo(Integer chartStatus, Integer checkStatus, Long clientID,
			Timestamp endDay, String endTime, Integer evaluationStatus,
			Long informantID, Long issueID, String jobID, String name,
			Long planID, Integer planType, Long projectID,
			Integer reportStatus, Integer round, Long smgkID,
			Timestamp startDay, String startTime, Integer statStatus,
			Integer status, Integer weightPattern) {
		super();
		this.chartStatus = chartStatus;
		this.checkStatus = checkStatus;
		this.clientID = clientID;
		this.endDay = endDay;
		this.endTime = endTime;
		this.evaluationStatus = evaluationStatus;
		this.informantID = informantID;
		this.issueID = issueID;
		this.jobID = jobID;
		this.name = name;
		this.planID = planID;
		this.planType = planType;
		this.projectID = projectID;
		this.reportStatus = reportStatus;
		this.round = round;
		this.smgkID = smgkID;
		this.startDay = startDay;
		this.startTime = startTime;
		this.statStatus = statStatus;
		this.status = status;
		this.weightPattern = weightPattern;
	}


}
