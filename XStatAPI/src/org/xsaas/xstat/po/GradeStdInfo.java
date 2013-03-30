package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * ���ֱ�׼��Ϣ��
 * @author ����
 * ���ֱ�׼ʵ��
 */
public class GradeStdInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3955013732011110988L;
	/**
	 * ���ֱ�׼���
	 */
	private Long gradeStdID = null;
	/**
	 * �����ʾ���
	 */
	private Long inquisitionID = null;
	/**
	 * ����
	 */
	private String title = null;
	/**
	 * ����
	 */
	private String description = null;
	/**
	 * ״̬
	 * 1������
	 * 2��ɾ��
	 */
	private Integer status = null;
	public Long getGradeStdID() {
		return gradeStdID;
	}
	public void setGradeStdID(Long gradeStdID) {
		this.gradeStdID = gradeStdID;
	}
	public Long getInquisitionID() {
		return inquisitionID;
	}
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public GradeStdInfo(String description, Long gradeStdID,
			Long inquisitionID, Integer status, String title) {
		super();
		this.description = description;
		this.gradeStdID = gradeStdID;
		this.inquisitionID = inquisitionID;
		this.status = status;
		this.title = title;
	}
	public GradeStdInfo() {
		super();
	}	
}
