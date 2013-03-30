package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 调查问卷试题资源类型
 */
public class ResourceInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2504498502626634133L;
	/**
	 * 资源编号
	 */
	private Long resourceID = null;
	/**
	 * 保存路径
	 */
	private String savePath = null;
	/**
	 * 文件名称
	 */
	private String fileName = null;
	/**
	 * 上传时间
	 */
	private Timestamp uploadTime = null;
	/**
	 * 状态
	 */
	private Integer status = null;
	/**
	 * 文件类型
	 */
	private Integer fileType = null;

	public ResourceInfo() {
		super();
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
	 * 获取存储路径
	 */
	public String getSavePath() {
		return savePath;
	}
	/**
	 * 设置存储路径
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	/**
	 * 获取文件名称
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置文件名称
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取上传时间
	 */
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	/**
	 * 设置上传时间
	 */
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
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
	public Long getResourceID() {
		return resourceID;
	}
	public void setResourceID(Long resourceID) {
		this.resourceID = resourceID;
	}
	public ResourceInfo(String fileName, Integer fileType, Long resourceID,
			String savePath, Integer status, Timestamp uploadTime) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.resourceID = resourceID;
		this.savePath = savePath;
		this.status = status;
		this.uploadTime = uploadTime;
	}
}
