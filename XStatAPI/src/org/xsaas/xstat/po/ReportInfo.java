package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 报告信息
 */
public class ReportInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6637352219217225296L;
	/**
	 * 报告编号
	 */
	private Long reportID = null;
	/**
	 * 描述
	 */
	private String checkName = null;
	/**
	 * 报告名称
	 */
	private String reportTitle = null;
	/**
	 * 描述
	 */
	private String enReportTitle = null;
	/**
	 * 报告名称
	 */
	private String quarterTitle = null;
	/**
	 * 被调查对象编号
	 */
	private Long themeID = null;
	/**
	 * 被调查对象编号
	 */
	private Long issueID = null;
	/**
	 * 被调查对象编号
	 */
	private Long informantID = null;
	
	/**
	 * 报告类型
	 */
	private Integer reportType = null;
	/**
	 * 报告语言
	 */
	private Integer pageCount = null;
	/**
	 * 添加时间
	 */
	private Timestamp addTime = null;
	
	
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public ReportInfo() {
		super();
		
	}

	public ReportInfo(Long reportID, String checkName, String reportTitle,
			String enReportTitle, String quarterTitle, Long themeID,
			Long issueID, Long informantID, Integer reportType,
			Integer pageCount, Timestamp addTime, Integer status) {
		super();
		this.reportID = reportID;
		this.checkName = checkName;
		this.reportTitle = reportTitle;
		this.enReportTitle = enReportTitle;
		this.quarterTitle = quarterTitle;
		this.themeID = themeID;
		this.issueID = issueID;
		this.informantID = informantID;
		this.reportType = reportType;
		this.pageCount = pageCount;
		this.addTime = addTime;
		this.status = status;
	}
	/**
	 * 获取时间
	 */
	public Timestamp getAddTime() {
		return addTime;
	}
	/**
	 * 设置时间
	 */
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	
	/**
	 * 获取报告编号
	 */
	public Long getReportID() {
		return reportID;
	}

	/**
	 * 设置报告编号
	 */
	public void setReportID(Long reportID) {
		this.reportID = reportID;
	}

	/**
	 * 获取报告类型
	 */
	public Integer getReportType() {
		return reportType;
	}

	/**
	 * 设置报告类型
	 */
	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}

	public String getCheckName() {
		return checkName;
	}
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getEnReportTitle() {
		return enReportTitle;
	}
	public void setEnReportTitle(String enReportTitle) {
		this.enReportTitle = enReportTitle;
	}
	public String getQuarterTitle() {
		return quarterTitle;
	}
	public void setQuarterTitle(String quarterTitle) {
		this.quarterTitle = quarterTitle;
	}
	public Long getThemeID() {
		return themeID;
	}
	public void setThemeID(Long themeID) {
		this.themeID = themeID;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
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


}
