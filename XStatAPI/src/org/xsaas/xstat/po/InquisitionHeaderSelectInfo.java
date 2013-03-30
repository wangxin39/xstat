package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 表头问题选项信息
 */
public class InquisitionHeaderSelectInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8051249576746234744L;
	/**
	 * 表头选项编号
	 */
	private Long headerSelectID = null;
	/**
	 * 问卷编号
	 */
	private Long inquisitionID = null;
	/**
	 * 表头编号
	 */
	private Long headerID = null;
	/**
	 * 选择编号
	 */
	private Long alterID = null;	
	/**
	 * 选项值
	 */
	private Long optionID = null;
	/**
	 * 显示编号
	 */
	private String showNum = null;
	/**
	 * 显示顺序
	 */
	private Integer showOrder = null;
	/**
	 * 字段名称
	 */
	private String fieldName = null;
	/**
	 * 状态
	 */
	private Integer status = null;	
	
	public InquisitionHeaderSelectInfo() {
		super();

	}

	public Long getHeaderSelectID() {
		return headerSelectID;
	}

	public void setHeaderSelectID(Long headerSelectID) {
		this.headerSelectID = headerSelectID;
	}

	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	public Long getHeaderID() {
		return headerID;
	}

	public void setHeaderID(Long headerID) {
		this.headerID = headerID;
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

	public Integer getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getAlterID() {
		return alterID;
	}

	public void setAlterID(Long alterID) {
		this.alterID = alterID;
	}

	public InquisitionHeaderSelectInfo(Long alterID, String fieldName,
			Long headerID, Long headerSelectID, Long inquisitionID,
			Long optionID, String showNum, Integer showOrder, Integer status) {
		super();
		this.alterID = alterID;
		this.fieldName = fieldName;
		this.headerID = headerID;
		this.headerSelectID = headerSelectID;
		this.inquisitionID = inquisitionID;
		this.optionID = optionID;
		this.showNum = showNum;
		this.showOrder = showOrder;
		this.status = status;
	}

}
