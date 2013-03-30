package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 报告信息
 */
public class ThemeStyleInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6637352219217225296L;
	/**
	 * 报告编号
	 */
	private Long themeID = null;
	/**
	 * 报告编号
	 */
	private Long styleID = null;
	/**
	 * 报告编号
	 */
	private Long reportTemplateID = null;
	/**
	 * 报告类型
	 */
	private Integer pageNum = null;

	/**
	 * 报告类型
	 */
	private Integer statType = null;

	/**
	 * 描述
	 */
	private String statChart = null;
	/**
	 * 报告名称
	 */
	private String title = null;
	
	/**
	 * 报告类型
	 */
	private Integer isBackImage = null;

	/**
	 * 描述
	 */
	private String content = null;
	
	/**
	 * 描述
	 */
	private String imageName = null;
	/**
	 * 报告名称
	 */
	private String savePath = null;
	
	/**
	 * 报告类型
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
	 * 获取报告名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置报告名称
	 */

	public void setTitle(String title) {
		this.title = title;
	}

}
