package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 调查问卷部分信息
 */
public class PartQuestionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1374712212981326834L;
	/**
	 * 部分问题编号
	 */
	private Long partQuestionID = null;
	/**
	 * 部分编号
	 */
	private Long partID = null;
	/**
	 * 问题编号
	 */
	private Long questionID = null;
	/**
	 * 问题类型
	 */
	private Integer questionType = null;
	/**
	 * 调查问卷编号
	 */
	private Long inquisitionID = null;
	/**
	 * 显示顺序
	 */
	private Integer showNum = null;
	/**
	 * 显示顺序
	 */
	private Integer validation = null;
	/**
	 * 上级部分问题编号
	 */
	private Long fatherPqID = null;
	/**
	 * 字段名称
	 */
	private String fieldName = null;
	/**
	 * 状态
	 * 1：正常
	 * 2：删除
	 */
	private Integer status = null;
	/**
	 * 选项类型
	 * 1：选项模板
	 * 2：选项定义
	 * 0：非选择题
	 */
	private Integer selectType = null;
	/**
	 * 选项模板编号
	 */
	private Long optionTemplateID = null;
	
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public PartQuestionInfo() {
		super();
		
	}

	/**
	 * 获取部分编号
	 * @return partID
	 */
	public Long getPartID() {
		return partID;
	}
	/**
	 * 设置部分编号
	 * @param partID
	 */
	public void setPartID(Long partID) {
		this.partID = partID;
	}
	
    /**
     * 获取调查问卷编号
     * @return inquisitionID
     */
	public Long getInquisitionID() {
		return inquisitionID;
	}
	/**
	 * 设置调查问卷编号
	 * @param inquisitionID
	 */
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}
	/**
	 * 获取显示顺序
	 * @return showNum
	 */
	public Integer getShowNum() {
		return showNum;
	}
	/**
	 * 设置显示顺序
	 * @param showNum
	 */
	public void setShowNum(Integer showNum) {
		this.showNum = showNum;
	}

	   /**
     * 获取问题编号
     * @return questionID
     */

	public Long getQuestionID() {
		return questionID;
	}

	/**
     * 设置问题编号
     *  @param questionID
     */
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}



	/**
     * 获取部分问题编号
     * @return partQuestionID
     */
	

	public Long getPartQuestionID() {
		return partQuestionID;
	}

    /**
     * 设置部分问题编号
     * @param partQuestionID
     */


	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}

	/**
	 * 获取字段名称
	 * @return fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * 设置字段名称
	 * @param fieldName
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * 获取上级部分问题编号
	 * @return fatherPqID
	 */
	public Long getFatherPqID() {
		return fatherPqID;
	}
	/**
	 * 设置上级部分问题编号
	 * @param fatherPqID
	 */

	public void setFatherPqID(Long fatherPqID) {
		this.fatherPqID = fatherPqID;
	}


	public Integer getQuestionType() {
		return questionType;
	}


	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public Integer getValidation() {
		return validation;
	}

	public void setValidation(Integer validation) {
		this.validation = validation;
	}
	public Integer getSelectType() {
		return selectType;
	}
	public void setSelectType(Integer selectType) {
		this.selectType = selectType;
	}
	public Long getOptionTemplateID() {
		return optionTemplateID;
	}
	public void setOptionTemplateID(Long optionTemplateID) {
		this.optionTemplateID = optionTemplateID;
	}
	public PartQuestionInfo(Long fatherPqID, String fieldName,
			Long inquisitionID, Long optionTemplateID, Long partID,
			Long partQuestionID, Long questionID, Integer questionType,
			Integer selectType, Integer showNum, Integer status,
			Integer validation) {
		super();
		this.fatherPqID = fatherPqID;
		this.fieldName = fieldName;
		this.inquisitionID = inquisitionID;
		this.optionTemplateID = optionTemplateID;
		this.partID = partID;
		this.partQuestionID = partQuestionID;
		this.questionID = questionID;
		this.questionType = questionType;
		this.selectType = selectType;
		this.showNum = showNum;
		this.status = status;
		this.validation = validation;
	}



}
