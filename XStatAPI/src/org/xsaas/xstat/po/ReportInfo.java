package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * ������Ϣ
 */
public class ReportInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6637352219217225296L;
	/**
	 * ������
	 */
	private Long reportID = null;
	/**
	 * ����
	 */
	private String checkName = null;
	/**
	 * ��������
	 */
	private String reportTitle = null;
	/**
	 * ����
	 */
	private String enReportTitle = null;
	/**
	 * ��������
	 */
	private String quarterTitle = null;
	/**
	 * �����������
	 */
	private Long themeID = null;
	/**
	 * �����������
	 */
	private Long issueID = null;
	/**
	 * �����������
	 */
	private Long informantID = null;
	
	/**
	 * ��������
	 */
	private Integer reportType = null;
	/**
	 * ��������
	 */
	private Integer pageCount = null;
	/**
	 * ���ʱ��
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
	 * ��ȡʱ��
	 */
	public Timestamp getAddTime() {
		return addTime;
	}
	/**
	 * ����ʱ��
	 */
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	
	/**
	 * ��ȡ������
	 */
	public Long getReportID() {
		return reportID;
	}

	/**
	 * ���ñ�����
	 */
	public void setReportID(Long reportID) {
		this.reportID = reportID;
	}

	/**
	 * ��ȡ��������
	 */
	public Integer getReportType() {
		return reportType;
	}

	/**
	 * ���ñ�������
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
