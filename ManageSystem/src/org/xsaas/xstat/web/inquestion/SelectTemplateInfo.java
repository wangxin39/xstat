package org.xsaas.xstat.web.inquestion;

import java.io.Serializable;

public class SelectTemplateInfo implements Serializable {

	public SelectTemplateInfo(Long partSelectID, Long partID,
			Long partQuestionID, Long selectID, String alterText,
			String fieldName, String fieldValue, Integer optionType,
			Long optionID, String option, String showNum, Integer showOrder,
			String comment, String englishComment, Long optionRelationID) {
		super();
		this.partSelectID = partSelectID;
		this.partID = partID;
		this.partQuestionID = partQuestionID;
		this.selectID = selectID;
		this.alterText = alterText;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.optionType = optionType;
		this.optionID = optionID;
		this.option = option;
		this.showNum = showNum;
		this.showOrder = showOrder;
		this.comment = comment;
		this.englishComment = englishComment;
		this.optionRelationID = optionRelationID;
	}
	public SelectTemplateInfo() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1952567673792222633L;
	
	private Long partSelectID = null;
	/**
	 * 部分编号
	 */	
	private Long partID = null;
	/**
	 * 部分问题编号
	 */	
	private Long partQuestionID = null;
	/**
	 * 选项编号
	 */	
	private Long selectID = null;
	/**
	 * 提示文本	 
	 */
	private String alterText = null;
	/**
	 * 表单中字段名称
	 */
	private String fieldName = null;
	/**
	 * 表单中字段值
	 */
	private String fieldValue = null;
	/**
	 * 选项值类型
	 */
	private Integer optionType = null;
	/**
	 * 选项值编号
	 */
	private Long optionID = null;	
	/**
	 * 选项值
	 */
	private String option = null;
	/**
	 * 显示编号
	 */
	private String showNum = null;
	/**
	 * 显示顺序
	 */
	private Integer showOrder = null;
	/**
	 * 注释
	 */
	private String comment = null;
	/**
	 * 英语注释
	 */
	private String englishComment = null;
	/**
	 * 选项关系编号
	 */
	private Long optionRelationID = null;

	public Long getPartID() {
		return partID;
	}
	public void setPartID(Long partID) {
		this.partID = partID;
	}

	public Long getSelectID() {
		return selectID;
	}
	public void setSelectID(Long selectID) {
		this.selectID = selectID;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public Integer getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getEnglishComment() {
		return englishComment;
	}
	public void setEnglishComment(String englishComment) {
		this.englishComment = englishComment;
	}
	public Long getPartQuestionID() {
		return partQuestionID;
	}
	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}
	public Integer getOptionType() {
		return optionType;
	}
	public void setOptionType(Integer optionType) {
		this.optionType = optionType;
	}
	public Long getOptionID() {
		return optionID;
	}
	public void setOptionID(Long optionID) {
		this.optionID = optionID;
	}
	public String getShowNum() {
		return showNum;
	}
	public void setShowNum(String showNum) {
		this.showNum = showNum;
	}
	public Long getPartSelectID() {
		return partSelectID;
	}
	public void setPartSelectID(Long partSelectID) {
		this.partSelectID = partSelectID;
	}

	public String getAlterText() {
		return alterText;
	}
	public void setAlterText(String alterText) {
		this.alterText = alterText;
	}
	public Long getOptionRelationID() {
		return optionRelationID;
	}
	public void setOptionRelationID(Long optionRelationID) {
		this.optionRelationID = optionRelationID;
	}
	
}
