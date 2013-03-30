package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * �����ʾ�ѡ����Ϣ
 */
public class PartSelectInfo implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 8051249576746234744L;
	/**
	 * ��������ѡ����
	 */
	private Long partSelectID = null;
	/**
	 * �ʾ���
	 */
	private Long inquisitionID = null;
	
	/**
	 * ����������
	 */
	private Long partQuestionID = null;
	/**
	 * ѡ����
	 */
	private Long alterID = null;	
	/**
	 * ѡ��ֵ����
	 */
	private Integer optionType = null;
	/**
	 * ѡ��ֵ
	 */
	private Long optionID = null;
	/**
	 * ��ʾ���
	 */
	private String showNum = null;
	/**
	 * ��ʾ˳��
	 */
	private Integer showOrder = null;
	/**
	 * ע��
	 */
	private String comment = null;
	/**
	 * Ӣ��ע��
	 */
	private String englishComment = null;
	/**
	 * ״̬
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
