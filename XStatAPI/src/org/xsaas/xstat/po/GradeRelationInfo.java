package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 评分关系信息表
 * @author 王鑫
 * 实分关系实体对象
 */
public class GradeRelationInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1792264206413360622L;
	/**
	 * 评分关系编号
	 */
	private Long gradeRelationID = null;
	/**
	 * 客户编号
	 */
	private Long clientID = null;
	/**
	 * 期次编号
	 */	
	private Long issueID = null;
	/**
	 * 调查对象编号
	 */	
	private Long informantID = null;
	/**
	 * 评分标准编号
	 */	
	private Long gradeStdID = null;
	/**
	 * 状态
	 * 1：正常
	 * 2：删除
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
