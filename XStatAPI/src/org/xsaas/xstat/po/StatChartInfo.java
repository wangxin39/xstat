package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 部分分数信息
 */
public class StatChartInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1949876341978769854L;
	/**
	 * 分数编号
	 */
	private Long chartID = null;
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
	 *  客户编号
	 */
	private Long smgkID = null;
	/**
	 * 被调查对象编号
	 */
	private Long informantID = null;

	/**
	 * 调查问卷编号
	 */
	private String savePath = null;

	/**
	 * 调查问卷编号
	 */
	private String fileName = null;
	
	/**
	 * 年度
	 */
	private Integer type = null;

	public StatChartInfo() {
		super();
		
	}


	public StatChartInfo(Long chartID, Integer year, Integer month,
			Integer day, Timestamp checkTime, Long clientID, Long projectID,
			Long issueID, Long smgkID, Long informantID, String savePath,
			String fileName, Integer type) {
		super();
		this.chartID = chartID;
		this.year = year;
		this.month = month;
		this.day = day;
		this.checkTime = checkTime;
		this.clientID = clientID;
		this.projectID = projectID;
		this.issueID = issueID;
		this.smgkID = smgkID;
		this.informantID = informantID;
		this.savePath = savePath;
		this.fileName = fileName;
		this.type = type;
	}


	public Long getChartID() {
		return chartID;
	}

	public void setChartID(Long chartID) {
		this.chartID = chartID;
	}

	public Long getIssueID() {
		return issueID;
	}

	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

}
