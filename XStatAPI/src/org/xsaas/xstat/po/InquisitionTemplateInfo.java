package org.xsaas.xstat.po;

import java.io.Serializable;

/**
 * �����ʾ�ģ����Ϣ
 */
public class InquisitionTemplateInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7963754895207894491L;
	/**
	 * ģ����
	 */
	private Long templateID = null;
	
	/**
	 * ״̬
	 */
	private Integer status = null;
	/**
	 * �ļ�����
	 */
	private Integer fileType = null;
	
	/**
	 * ����
	 */
	private String description =null;
	/**
	 * ģ������
	 */
	private String name =null;
	/**
	 * ģ���ļ�����
	 */
	private String fileName =null;
	/**
	 * ����·��
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
	 * ��ȡ����
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * ��������
	 */
	public void setDescription(String description) {
		this.description = description;
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
	/**
	 * ��ȡģ����
	 */
	public Long getTemplateID() {
		return templateID;
	}
	/**
	 * ����ģ����
	 */
	public void setTemplateID(Long templateID) {
		this.templateID = templateID;
	}
	/**
	 * ��ȡģ������
	 */
	public String getName() {
		return name;
	}
	/**
	 * ����ģ������
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ��ȡģ���ļ�����
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * ����ģ���ļ�����
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * ��ȡ����·��
	 */


	public String getSavePath() {
		return savePath;
	}

	/**
	 * ���ñ���·��
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	
	
	
}
