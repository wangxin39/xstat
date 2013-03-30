package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * ������Ϣ
 */
public class ThemeStyleInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6637352219217225296L;
	/**
	 * ������
	 */
	private Long themeID = null;
	/**
	 * ������
	 */
	private Long styleID = null;
	/**
	 * ������
	 */
	private Long reportTemplateID = null;
	/**
	 * ��������
	 */
	private Integer pageNum = null;

	/**
	 * ��������
	 */
	private Integer statType = null;

	/**
	 * ����
	 */
	private String statChart = null;
	/**
	 * ��������
	 */
	private String title = null;
	
	/**
	 * ��������
	 */
	private Integer isBackImage = null;

	/**
	 * ����
	 */
	private String content = null;
	
	/**
	 * ����
	 */
	private String imageName = null;
	/**
	 * ��������
	 */
	private String savePath = null;
	
	/**
	 * ��������
	 */
	private Integer status = null;
	
	public ThemeStyleInfo() {
		super();
		
	}

	public ThemeStyleInfo(Long themeID, Long styleID, Long reportTemplateID,
			Integer pageNum, Integer statType, String statChart, String title,
			Integer isBackImage, String content, String imageName,
			String savePath, Integer status) {
		super();
		this.themeID = themeID;
		this.styleID = styleID;
		this.reportTemplateID = reportTemplateID;
		this.pageNum = pageNum;
		this.statType = statType;
		this.statChart = statChart;
		this.title = title;
		this.isBackImage = isBackImage;
		this.content = content;
		this.imageName = imageName;
		this.savePath = savePath;
		this.status = status;
	}

	public Long getStyleID() {
		return styleID;
	}


	public Long getReportTemplateID() {
		return reportTemplateID;
	}

	public void setReportTemplateID(Long reportTemplateID) {
		this.reportTemplateID = reportTemplateID;
	}

	public void setStyleID(Long styleID) {
		this.styleID = styleID;
	}


	public Integer getPageNum() {
		return pageNum;
	}


	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}


	public Integer getStatType() {
		return statType;
	}


	public void setStatType(Integer statType) {
		this.statType = statType;
	}


	public String getStatChart() {
		return statChart;
	}


	public void setStatChart(String statChart) {
		this.statChart = statChart;
	}


	public Integer getIsBackImage() {
		return isBackImage;
	}


	public void setIsBackImage(Integer isBackImage) {
		this.isBackImage = isBackImage;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public String getSavePath() {
		return savePath;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	public Long getThemeID() {
		return themeID;
	}

	public void setThemeID(Long themeID) {
		this.themeID = themeID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * ��ȡ��������
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * ���ñ�������
	 */

	public void setTitle(String title) {
		this.title = title;
	}

}
