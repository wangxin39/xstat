package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 调查问卷选项信息
 */
public class PartSelectInfo implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 8051249576746234744L;
	/**
	 * 部分问题选项编号
	 */
	private Long partSelectID = null;
	/**
	 * 问卷编号
	 */
	private Long inquisitionID = null;
	
	/**
	 * 部分问题编号
	 */
	private Long partQuestionID = null;
	/**
	 * 选择编号
	 */
	private Long alterID = null;	
	/**
	 * 选项值类型
	 */
	private Integer optionType = null;
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
	 * 注释
	 */
	private String comment = null;
	/**
	 * 英语注释
	 */
	private String englishComment = null;
	/**
	 * 状态
	 */
	private Integer status = null;

	public PartSelectInfo() {
		super();

	}

	public PartSelectInfo(String comment, String englishComment,
			Long inquisitionID, Long optionID, Integer optionType,
			Long partQuestionID, Long partSelectID, Long alterID,
			String showNum, Integer showOrder, Integer status) {
		super();
		this.comment = comment;
		this.englishComment = englishComment;
		this.inquisitionID = inquisitionID;
		this.optionID = optionID;
		this.optionType = optionType;
		this.partQuestionID = partQuestionID;
		this.partSelectID = partSelectID;
		this.alterID = alterID;
		this.showNum = showNum;
		this.showOrder = showOrder;
		this.status = status;
	}

	public Long getPartSelectID() {
		return partSelectID;
	}

	public void setPartSelectID(Long partSelectID) {
		this.partSelectID = partSelectID;
	}

	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	public Long getPartQuestionID() {
		return partQuestionID;
	}

	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}

	public Long getAlterID() {
		return alterID;
	}

	public void setAlterID(Long alterID) {
		this.alterID = alterID;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
