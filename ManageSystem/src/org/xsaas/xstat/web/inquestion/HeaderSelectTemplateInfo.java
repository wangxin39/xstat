package org.xsaas.xstat.web.inquestion;

import java.io.Serializable;

public class HeaderSelectTemplateInfo implements Serializable {
	public HeaderSelectTemplateInfo(Long headerSelectID, Long inquisitionID,
			Long selectID, String fieldName, String fieldValue, String option,
			String showNum, Long optionRelationID) {
		super();
		this.headerSelectID = headerSelectID;
		this.inquisitionID = inquisitionID;
		this.selectID = selectID;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.option = option;
		this.showNum = showNum;
		this.optionRelationID = optionRelationID;
	}
	public HeaderSelectTemplateInfo() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1952567673792222633L;
	
	private Long headerSelectID = null;
	/**
	 * 问卷编号
	 */	
	private Long inquisitionID = null;
	/**
	 * 选项编号
	 */	
	private Long selectID = null;
	/**
	 * 表单中字段名称
	 */
	private String fieldName = null;
	/**
	 * 表单中字段值
	 */
	private String fieldValue = null;
	/**
	 * 选项值
	 */
	private String option = null;
	/**
	 * 显示编号
	 */
	private String showNum = null;
	/**
	 * 选项关系编号
	 */
	private Long optionRelationID = null;
	
	public Long getInquisitionID() {
		return inquisitionID;
	}
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
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
	public Long getHeaderSelectID() {
		return headerSelectID;
	}
	public void setHeaderSelectID(Long headerSelectID) {
		this.headerSelectID = headerSelectID;
	}
	public String getShowNum() {
		return showNum;
	}
	public void setShowNum(String showNum) {
		this.showNum = showNum;
	}
	public Long getOptionRelationID() {
		return optionRelationID;
	}
	public void setOptionRelationID(Long optionRelationID) {
		this.optionRelationID = optionRelationID;
	}	
}
