package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * �����ʾ�������Դ����
 */
public class ResourceInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2504498502626634133L;
	/**
	 * ��Դ���
	 */
	private Long resourceID = null;
	/**
	 * ����·��
	 */
	private String savePath = null;
	/**
	 * �ļ�����
	 */
	private String fileName = null;
	/**
	 * �ϴ�ʱ��
	 */
	private Timestamp uploadTime = null;
	/**
	 * ״̬
	 */
	private Integer status = null;
	/**
	 * �ļ�����
	 */
	private Integer fileType = null;

	public ResourceInfo() {
		super();
	}	
	/**
	 * ��ȡ״̬
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * ����״̬
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * ��ȡ�洢·��
	 */
	public String getSavePath() {
		return savePath;
	}
	/**
	 * ���ô洢·��
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	/**
	 * ��ȡ�ļ�����
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * �����ļ�����
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * ��ȡ�ϴ�ʱ��
	 */
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	/**
	 * �����ϴ�ʱ��
	 */
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}
	/**
	 * ��ȡ�ļ�����
	 */
	public Integer getFileType() {
		return fileType;
	}
	/**
	 * �����ļ�����
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
