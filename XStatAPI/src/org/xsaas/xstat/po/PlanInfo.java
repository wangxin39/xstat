package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * �ƻ���Ϣ��ʵ�����
 * 
 * ���ڿ��Ƽ��/����
 * 
 * 
 */
public class PlanInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4425559861014281117L;
	/**
	 * �ƻ����
	 */
	private Long planID = null;
	/**
	 * �ƻ�����
	 */
	private String name = null;
	/**
	 * �ڴα��
	 */
	private Long issueID = null;
	/**
	 * �ִ�
	 * 1����һ��
	 * 2���ڶ���
	 */
	private Integer round = null;
	/**
	 * �ͻ����
	 */
	private Long clientID = null;
	
	/**
	 * ��Ŀ���
	 */
	private Long projectID = null;
	/**
	 * ���������
	 */
	private Long informantID = null;
	/**
	 * ���ؿͱ��
	 */
	private Long smgkID = null;
	/**
	 * ������
	 */
	private String jobID = null;
	/**
	 * ��ʼ����	
	 */
	private Timestamp startDay = null;
	/**
	 * ��������	
	 */	
	private Timestamp endDay = null;
	/**
	 * ��ʼʱ��	
	 */	
	private String startTime = null;
	/**
	 * ����ʱ��	
	 */	
	private String endTime = null;
	/**
	 * Ȩ��ģʽ
	 * 1��ͨ��ģʽ
	 * 2������ģʽ	
	 */	
	private Integer weightPattern = null;
	/**
	 * �ƻ�����
	 * 1������
	 * 2������
	 */
	private Integer planType = null;
	/**
	 * ͳ��״̬
	 * 1��ĩ��ʼ
	 * 2��������
	 * 3�������
	 */
	private Integer statStatus = null;
	/**
	 * ͳ��ͼ״̬
	 * 1��ĩ��ʼ
	 * 2��������
	 * 3�������
	 */
	private Integer chartStatus = null;
	/**
	 * ���״̬
	 * 1�����ڼ��
	 * 2��������
	 * 3���������
	 */	
	private Integer checkStatus = null;
	/**
	 * ����״̬
	 * 1��ĩ��ʼ
	 * 2��������
	 * 3�������
	 */
	private Integer evaluationStatus = null;
	/**
	 * ����״̬
	 * 1��ĩ��ʼ
	 * 2��������
	 * 3�������
	 */	
	private Integer reportStatus = null;
	/**
	 * ״̬
	 * 1������
	 * 2��ɾ��
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
	 * ��ȡ�˿ͱ��
	 */

	public Long getSmgkID() {
		return smgkID;
	}

	/**
	 * ���ù˿ͱ��
	 */
	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
	}

	

	/**
	 * ��ȡ�ƻ����
	 */

	public Long getPlanID() {
		return planID;
	}

	/**
	 * ���üƻ����
	 */

	public void setPlanID(Long planID) {
		this.planID = planID;
	}

	/**
	 * ��ȡ�ͻ����
	 */

	public Long getClientID() {
		return clientID;
	}

	/**
	 * ���ÿͻ����
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
