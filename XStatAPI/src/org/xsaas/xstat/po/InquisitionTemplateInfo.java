package org.xsaas.xstat.po;

import java.io.Serializable;

/**
 * 调查问卷模板信息
 */
public class InquisitionTemplateInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7963754895207894491L;
	/**
	 * 模板编号
	 */
	private Long templateID = null;
	
	/**
	 * 状态
	 */
	private Integer status = null;
	/**
	 * 文件类型
	 */
	private Integer fileType = null;
	
	/**
	 * 描述
	 */
	private String description =null;
	/**
	 * 模板名称
	 */
	private String name =null;
	/**
	 * 模板文件名称
	 */
	private String fileName =null;
	/**
	 * 保存路径
	 */
	private String savePath =null;
	
	
	
	public InquisitionTemplateInfo() {
		super();
	}
	
	public InquisitionTemplateInfo(Long templateID, Integer status, Integer fileType,
			String description, String name, String fileName, String savePath) {
		super();
		this.templateID = templateID;
		this.status = status;
		this.fileType = fileType;
		this.description = description;
		this.name = name;
		this.fileName = fileName;
		this.savePath = savePath;
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
	/**
	 * 获取文件类型
	 */
	public Integer getFileType() {
		return fileType;
	}
	/**
	 * 设置文件类型
	 */
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	/**
	 * 获取模板编号
	 */
	public Long getTemplateID() {
		return templateID;
	}
	/**
	 * 设置模板编号
	 */
	public void setTemplateID(Long templateID) {
		this.templateID = templateID;
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
	/**
	 * 获取保存路径
	 */


	public String getSavePath() {
		return savePath;
	}

	/**
	 * 设置保存路径
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	
	
	
}
