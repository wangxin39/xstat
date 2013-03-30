package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * ��ͷ����ѡ����Ϣ
 */
public class InquisitionHeaderSelectInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8051249576746234744L;
	/**
	 * ��ͷѡ����
	 */
	private Long headerSelectID = null;
	/**
	 * �ʾ���
	 */
	private Long inquisitionID = null;
	/**
	 * ��ͷ���
	 */
	private Long headerID = null;
	/**
	 * ѡ����
	 */
	private Long alterID = null;	
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
	 * �ֶ�����
	 */
	private String fieldName = null;
	/**
	 * ״̬
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
