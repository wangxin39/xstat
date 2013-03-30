package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * ���ֱ�׼ѡ��Ȩ�ع�ϵ��Ϣ
 * @author ����
 * ���ֱ�׼��ѡ��Ȩ��֮���ϵӳ���
 */
public class GradeStdRelationInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5758574179396840233L;
	/**
	 * ���ֱ�׼��ϵ���
	 */
	private Long stdRelationID = null;
	/**
	 * ���ֱ�׼���
	 */
	private Long gradeStdID = null;
	/**
	 * ѡ��Ȩ�ر��
	 */
	private Long selectWeightID = null;
	/**
	 * ״̬
	 * 1������
	 * 2��ɾ��
	 */
	private Integer status = null;
	public Long getStdRelationID() {
		return stdRelationID;
	}
	public void setStdRelationID(Long stdRelationID) {
		this.stdRelationID = stdRelationID;
	}
	public Long getGradeStdID() {
		return gradeStdID;
	}
	public void setGradeStdID(Long gradeStdID) {
		this.gradeStdID = gradeStdID;
	}
	public Long getSelectWeightID() {
		return selectWeightID;
	}
	public void setSelectWeightID(Long selectWeightID) {
		this.selectWeightID = selectWeightID;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public GradeStdRelationInfo(Long gradeStdID, Long selectWeightID,
			Integer status, Long stdRelationID) {
		super();
		this.gradeStdID = gradeStdID;
		this.selectWeightID = selectWeightID;
		this.status = status;
		this.stdRelationID = stdRelationID;
	}
	public GradeStdRelationInfo() {
		super();
	}
	
}
