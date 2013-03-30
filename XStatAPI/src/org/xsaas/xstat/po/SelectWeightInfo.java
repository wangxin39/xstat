package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 部分权重信息
 */
public class SelectWeightInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1949876341978769854L;
	/**
	 * 权重编号
	 */
	private Long selectWeightID = null;
	/**
	 * 调查问卷类型
	 */	
	private Long inquisitionID = null;
	/**
	 * 部分编号
	 */
	private Long partID = null;
	/**
	 * 部分问题编号
	 */
	private Long partQuestionID = null;
	/**
	 * 选项关系编号
	 */
	private Long optionRelationID = null;
	/**
	 * 部分问题选项编号
	 */
	private Long partSelectID = null;
	/**
	 * 权重分数
	 */
	private Integer weight = null;
	/**
	 * 状态
	 */
	private Integer status = null;
	

	public SelectWeightInfo() {
		super();
		
	}

	public Long getSelectWeightID() {
		return selectWeightID;
	}


	public void setSelectWeightID(Long selectWeightID) {
		this.selectWeightID = selectWeightID;
	}


	public Long getInquisitionID() {
		return inquisitionID;
	}


	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}


	public Long getPartID() {
		return partID;
	}


	public void setPartID(Long partID) {
		this.partID = partID;
	}


	public Long getPartQuestionID() {
		return partQuestionID;
	}


	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}


	public Long getPartSelectID() {
		return partSelectID;
	}


	public void setPartSelectID(Long partSelectID) {
		this.partSelectID = partSelectID;
	}


	public Integer getWeight() {
		return weight;
	}


	public void setWeight(Integer weight) {
		this.weight = weight;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Long getOptionRelationID() {
		return optionRelationID;
	}


	public void setOptionRelationID(Long optionRelationID) {
		this.optionRelationID = optionRelationID;
	}

	public SelectWeightInfo(Long inquisitionID, Long optionRelationID,
			Long partID, Long partQuestionID, Long partSelectID,
			Long selectWeightID, Integer status, Integer weight) {
		super();
		this.inquisitionID = inquisitionID;
		this.optionRelationID = optionRelationID;
		this.partID = partID;
		this.partQuestionID = partQuestionID;
		this.partSelectID = partSelectID;
		this.selectWeightID = selectWeightID;
		this.status = status;
		this.weight = weight;
	}

}
