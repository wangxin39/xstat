package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * �����ʾ�ģ����Ϣ
 */
public class ReportTemplateInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7963754895207894491L;
	/**
	 * ģ����
	 */
	private Long reportTemplateID = null;
	
	/**
	 * ģ������
	 */
	private String name =null;
	/**
	 * ����
	 */
	private String description =null;
	
	/**
	 * ģ���ļ�����
	 */
	private String fileName =null;
	/**
	 * ����·��
	 */
	private String path =null;

	
	/**
	 * �ļ�����
	 */
	private Timestamp addTime = null;
	
	/**
	 * ״̬
	 */
	private Integer status = null;
	/**
	 * ״̬
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
	
}
