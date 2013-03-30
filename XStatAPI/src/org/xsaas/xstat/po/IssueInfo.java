package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * ��������
 */
public class IssueInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5339431922945403316L;

	private Long issueID = null;
	/**
	 * ��Ŀ���
	 */
	private Long projectID = null;
	/**
	 * �ͻ����
	 */
	private Long clientID = null;
	/**
	 * �����ʾ���
	 */
	private Long inquisitionID = null;
	/**
	 * �ڴ�
	 */
	private String issue = null;
	/**
	 * ��ʼ����
	 */
	private String startDay = null;
	/**
	 * ��������
	 */
	private String endDay = null;
	/**
	 * ��ʼʱ��
	 */
	private String startTime = null;
	/**
	 * ����ʱ��
	 */
	private String endTime = null;
	/**
	 * ���ʱ��
	 */
	private Timestamp checkTime = null;
	/**
	 * ��
	 */
	private Integer year = null;
	/**
	 * �Ƿ�ǰ���һ�ڼ��
	 */
	private Integer isFirst = null;
	/**
	 * �ڴ�ִ�ж���
	 * 1���ʾ����
	 * 2��ϵͳ����
	 * 3���˹�����
	 * 4�����洦��
	 */
	private Integer actions = null;
	/**
	 * ͳ��ͼ״̬
	 * 1��ĩ��ʼ
	 * 2��������
	 * 3�������
	 */
	private Integer chartStatus = null;
	/**
	 * ����״̬
	 * 1��ĩ��ʼ
	 * 2��������
	 * 3�������
	 */
	private Integer evaluationStatus = null;
	/**
	 * ͳ��״̬
	 * 1��ĩ��ʼ
	 * 2��������
	 * 3�������
	 * 
	 */
	private Integer statStatus = null;
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
	/**
	 * ����ʱ��
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
	 * ��ȡ��Ŀ���
	 */

	public Long getProjectID() {
		return projectID;
	}

	/**
	 * ������Ŀ���
	 */

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
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
