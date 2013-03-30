package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * �����ʾ�����Ϣ
 */
public class PartQuestionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1374712212981326834L;
	/**
	 * ����������
	 */
	private Long partQuestionID = null;
	/**
	 * ���ֱ��
	 */
	private Long partID = null;
	/**
	 * ������
	 */
	private Long questionID = null;
	/**
	 * ��������
	 */
	private Integer questionType = null;
	/**
	 * �����ʾ���
	 */
	private Long inquisitionID = null;
	/**
	 * ��ʾ˳��
	 */
	private Integer showNum = null;
	/**
	 * ��ʾ˳��
	 */
	private Integer validation = null;
	/**
	 * �ϼ�����������
	 */
	private Long fatherPqID = null;
	/**
	 * �ֶ�����
	 */
	private String fieldName = null;
	/**
	 * ״̬
	 * 1������
	 * 2��ɾ��
	 */
	private Integer status = null;
	/**
	 * ѡ������
	 * 1��ѡ��ģ��
	 * 2��ѡ���
	 * 0����ѡ����
	 */
	private Integer selectType = null;
	/**
	 * ѡ��ģ����
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
	 * ��ȡ���ֱ��
	 * @return partID
	 */
	public Long getPartID() {
		return partID;
	}
	/**
	 * ���ò��ֱ��
	 * @param partID
	 */
	public void setPartID(Long partID) {
		this.partID = partID;
	}
	
    /**
     * ��ȡ�����ʾ���
     * @return inquisitionID
     */
	public Long getInquisitionID() {
		return inquisitionID;
	}
	/**
	 * ���õ����ʾ���
	 * @param inquisitionID
	 */
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}
	/**
	 * ��ȡ��ʾ˳��
	 * @return showNum
	 */
	public Integer getShowNum() {
		return showNum;
	}
	/**
	 * ������ʾ˳��
	 * @param showNum
	 */
	public void setShowNum(Integer showNum) {
		this.showNum = showNum;
	}

	   /**
     * ��ȡ������
     * @return questionID
     */

	public Long getQuestionID() {
		return questionID;
	}

	/**
     * ����������
     *  @param questionID
     */
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}



	/**
     * ��ȡ����������
     * @return partQuestionID
     */
	

	public Long getPartQuestionID() {
		return partQuestionID;
	}

    /**
     * ���ò���������
     * @param partQuestionID
     */


	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}

	/**
	 * ��ȡ�ֶ�����
	 * @return fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * �����ֶ�����
	 * @param fieldName
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * ��ȡ�ϼ�����������
	 * @return fatherPqID
	 */
	public Long getFatherPqID() {
		return fatherPqID;
	}
	/**
	 * �����ϼ�����������
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
