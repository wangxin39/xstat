package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 调查问卷模板信息
 */
public class ReportTemplateInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7963754895207894491L;
	/**
	 * 模板编号
	 */
	private Long reportTemplateID = null;
	
	/**
	 * 模板名称
	 */
	private String name =null;
	/**
	 * 描述
	 */
	private String description =null;
	
	/**
	 * 模板文件名称
	 */
	private String fileName =null;
	/**
	 * 保存路径
	 */
	private String path =null;

	
	/**
	 * 文件类型
	 */
	private Timestamp addTime = null;
	
	/**
	 * 状态
	 */
	private Integer status = null;
	/**
	 * 状态
	 */
	private Integer type = null;
	
	
	public ReportTemplateInfo() {
		super();
	}
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public ReportTemplateInfo(Long reportTemplateID, String name,
			String description, String fileName, String path,
			Timestamp addTime, Integer status, Integer type) {
		super();
		this.reportTemplateID = reportTemplateID;
		this.name = name;
		this.description = description;
		this.fileName = fileName;
		this.path = path;
		this.addTime = addTime;
		this.status = status;
		this.type = type;
	}

	/**
	 * 获取状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getReportTemplateID() {
		return reportTemplateID;
	}


	public void setReportTemplateID(Long reportTemplateID) {
		this.reportTemplateID = reportTemplateID;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public Timestamp getAddTime() {
		return addTime;
	}


	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}


	/**
	 * 获取模板名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置模板名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取模板文件名称
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置模板文件名称
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
