package org.xsaas.xstat.po;

import java.io.Serializable;

/**
 * �����ʾ���
 */
public class PartInfo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4994708019476271815L;
	/**
	 * ���ֱ��
	 */
	private Long partID = null;
	/**
	 * �����ʾ���
	 */
	private Long inquisitionID = null;

	/**
	 * ��ʾ˳��
	 */
	private Integer showOrder = null;

	/**
	 * ��������
	 */
	private String name = null;
	/**
	 * Ӣ�ﲿ������
	 */
	private String englishName = null;
	
	/**
	 * ��ʾ���
	 */
	private String showNum = null;
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public PartInfo() {
		super();

	}

	public PartInfo(Long partID, Long inquisitionID, Integer showOrder,
			String name, String englishName, String showNum, Integer status) {
		super();
		this.partID = partID;
		this.inquisitionID = inquisitionID;
		this.showOrder = showOrder;
		this.name = name;
		this.englishName = englishName;
		this.showNum = showNum;
		this.status = status;
	}
	/**
	 * ��ȡ���ֱ��
	 */
	public Long getPartID() {
		return partID;
	}

	/**
	 * ���ò��ֱ��
	 */
	public void setPartID(Long partID) {
		this.partID = partID;
	}

	/**
	 * ��ȡ�ʾ���
	 */
	public Long getInquisitionID() {
		return inquisitionID;
	}

	/**
	 * �����ʾ���
	 */
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
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
	 * ��ȡ��������
	 */
	public String getName() {
		return name;
	}

	/**
	 * ���ò�������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ��ʾ���
	 */
	public String getShowNum() {
		return showNum;
	}

	/**
	 * ������ʾ���
	 */
	public void setShowNum(String showNum) {
		this.showNum = showNum;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
}
