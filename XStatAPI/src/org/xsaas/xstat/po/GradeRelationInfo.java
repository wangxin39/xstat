package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * ���ֹ�ϵ��Ϣ��
 * @author ����
 * ʵ�ֹ�ϵʵ�����
 */
public class GradeRelationInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1792264206413360622L;
	/**
	 * ���ֹ�ϵ���
	 */
	private Long gradeRelationID = null;
	/**
	 * �ͻ����
	 */
	private Long clientID = null;
	/**
	 * �ڴα��
	 */	
	private Long issueID = null;
	/**
	 * ���������
	 */	
	private Long informantID = null;
	/**
	 * ���ֱ�׼���
	 */	
	private Long gradeStdID = null;
	/**
	 * ״̬
	 * 1������
	 * 2��ɾ��
	 */
	private Integer status = null;
	public Long getGradeRelationID() {
		return gradeRelationID;
	}
	public void setGradeRelationID(Long gradeRelationID) {
		this.gradeRelationID = gradeRelationID;
	}
	public Long getClientID() {
		return clientID;
	}
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	public Long getIssueID() {
		return issueID;
	}
	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}
	public Long getInformantID() {
		return informantID;
	}
	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}
	public Long getGradeStdID() {
		return gradeStdID;
	}
	public void setGradeStdID(Long gradeStdID) {
		this.gradeStdID = gradeStdID;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public GradeRelationInfo(Long clientID, Long gradeRelationID,
			Long gradeStdID, Long informantID, Long issueID, Integer status) {
		super();
		this.clientID = clientID;
		this.gradeRelationID = gradeRelationID;
		this.gradeStdID = gradeStdID;
		this.informantID = informantID;
		this.issueID = issueID;
		this.status = status;
	}
	public GradeRelationInfo() {
		super();
	}
}
