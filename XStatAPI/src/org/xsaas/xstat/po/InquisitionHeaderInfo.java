package org.xsaas.xstat.po;

import java.io.Serializable;

/**
 * �����ʾ��ͷ��Ϣ
 */
public class InquisitionHeaderInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1374712212981326834L;
	
	/**
	 * ��ͷ���
	 */
	private Long headerID = null;
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
	private Integer showOrder = null;
	/**
	 * �ֶ�����
	 */
	private String fieldName = null;
	/**
	 * �Ƿ������д
	 */
	private Integer isinput = null;
	/**
	 * ѡ������
	 * 1��ѡ��ģ��
	 * 2��ѡ���
	 * 0����ֵ����ѡ����
	 */
	private Integer selectType = null;
	/**
	 * ѡ��ģ����
	 */
	private Long optionTemplateID = null;
	/**
	 * ״̬
	 * 1������
	 * 2��ɾ��
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
	 * ��ȡ��д��Ϣ
	 * @return IsInput
	 */
	
	public Integer getIsinput() {
		return isinput;
	}

	/**
	 * ���ñ�����д
	 * @param isinput
	 */
	public void setIsinput(Integer isinput) {
		this.isinput = isinput;
	}
	/**
	 * ��ȡ��ʾ˳��
	 */
	public Integer getShowOrder() {
		return showOrder;
	}

	/**
	 * ������ʾ˳��
	 */
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
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
     * ��ȡ������
     * @return questionID
     */

	public Long getQuestionID() {
		return questionID;
	}

    /**
     * ����������
     * @param questionID
     */
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
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
	 * ��ȡ��ͷ��Ϣ
	 * @return ihID
	 */
	public Long getHeaderID() {
		return headerID;
	}
	/**
	 * ���ñ�ͷ��Ϣ
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
