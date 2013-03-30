package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 评分标准选项权重关系信息
 * @author 王鑫
 * 评分标准和选项权重之间关系映射表
 */
public class GradeStdRelationInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5758574179396840233L;
	/**
	 * 评分标准关系编号
	 */
	private Long stdRelationID = null;
	/**
	 * 评分标准编号
	 */
	private Long gradeStdID = null;
	/**
	 * 选项权重编号
	 */
	private Long selectWeightID = null;
	/**
	 * 状态
	 * 1：正常
	 * 2：删除
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
