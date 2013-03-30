package org.xsaas.xstat.po;

import java.io.Serializable;

/**
 * 调查问卷表头信息
 */
public class InquisitionHeaderInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1374712212981326834L;
	
	/**
	 * 表头编号
	 */
	private Long headerID = null;
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
	private Integer showOrder = null;
	/**
	 * 字段名称
	 */
	private String fieldName = null;
	/**
	 * 是否必须填写
	 */
	private Integer isinput = null;
	/**
	 * 选项类型
	 * 1：选项模板
	 * 2：选项定义
	 * 0：空值，非选择题
	 */
	private Integer selectType = null;
	/**
	 * 选项模板编号
	 */
	private Long optionTemplateID = null;
	/**
	 * 状态
	 * 1：正常
	 * 2：删除
	 */
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public InquisitionHeaderInfo() {
		super();
		
	}	
	/**
	 * 获取填写信息
	 * @return IsInput
	 */
	
	public Integer getIsinput() {
		return isinput;
	}

	/**
	 * 设置必须填写
	 * @param isinput
	 */
	public void setIsinput(Integer isinput) {
		this.isinput = isinput;
	}
	/**
	 * 获取显示顺序
	 */
	public Integer getShowOrder() {
		return showOrder;
	}

	/**
	 * 设置显示顺序
	 */
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
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
     * 获取问题编号
     * @return questionID
     */

	public Long getQuestionID() {
		return questionID;
	}

    /**
     * 设置问题编号
     * @param questionID
     */
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
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
	 * 获取表头信息
	 * @return ihID
	 */
	public Long getHeaderID() {
		return headerID;
	}
	/**
	 * 设置表头信息
	 * @param ihID
	 */
	public void setHeaderID(Long headerID) {
		this.headerID = headerID;
	}
	public Integer getQuestionType() {
		return questionType;
	}
	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
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
	public InquisitionHeaderInfo(String fieldName, Long headerID,
			Long inquisitionID, Integer isinput, Long optionTemplateID,
			Long questionID, Integer questionType, Integer selectType,
			Integer showOrder, Integer status) {
		super();
		this.fieldName = fieldName;
		this.headerID = headerID;
		this.inquisitionID = inquisitionID;
		this.isinput = isinput;
		this.optionTemplateID = optionTemplateID;
		this.questionID = questionID;
		this.questionType = questionType;
		this.selectType = selectType;
		this.showOrder = showOrder;
		this.status = status;
	}
}
