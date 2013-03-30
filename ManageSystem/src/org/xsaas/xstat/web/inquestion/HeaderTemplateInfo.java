package org.xsaas.xstat.web.inquestion;

import java.io.Serializable;
import java.util.List;

public class HeaderTemplateInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1971037942718939433L;
	/**
	 * 标签
	 */
	private String label = null;
	/**
	 * 字段名称
	 */
	private String fieldName = null;
	/**
	 * 字段值
	 */
	private String fieldValue = null;
	/**
	 * 字段类型,1：填空，2：选择
	 * 
	 */
	private int fieldType = 0;
	/**
	 * 选项类型
	 * 1:选项模板
	 * 2:表头选项
	 */
	private int selectType = 0;
	/**
	 * 是否必须填写
	 */
	private int isInput = 0;
	/**
	 * 表头问题选项
	 */
	private List<HeaderSelectTemplateInfo> selectList = null;

	public HeaderTemplateInfo() {
		super();
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
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
	public int getFieldType() {
		return fieldType;
	}
	public void setFieldType(int fieldType) {
		this.fieldType = fieldType;
	}
	public List<HeaderSelectTemplateInfo> getSelectList() {
		return selectList;
	}
	public void setSelectList(List<HeaderSelectTemplateInfo> selectList) {
		this.selectList = selectList;
	}
	public int getIsInput() {
		return isInput;
	}
	public void setIsInput(int isInput) {
		this.isInput = isInput;
	}
	public int getSelectType() {
		return selectType;
	}
	public void setSelectType(int selectType) {
		this.selectType = selectType;
	}

}
