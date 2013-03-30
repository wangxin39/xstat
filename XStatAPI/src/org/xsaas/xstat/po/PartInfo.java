package org.xsaas.xstat.po;

import java.io.Serializable;

/**
 * 调查问卷部分
 */
public class PartInfo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4994708019476271815L;
	/**
	 * 部分编号
	 */
	private Long partID = null;
	/**
	 * 调查问卷编号
	 */
	private Long inquisitionID = null;

	/**
	 * 显示顺序
	 */
	private Integer showOrder = null;

	/**
	 * 部分名称
	 */
	private String name = null;
	/**
	 * 英语部分名称
	 */
	private String englishName = null;
	
	/**
	 * 显示编号
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
	 * 获取部分编号
	 */
	public Long getPartID() {
		return partID;
	}

	/**
	 * 设置部分编号
	 */
	public void setPartID(Long partID) {
		this.partID = partID;
	}

	/**
	 * 获取问卷编号
	 */
	public Long getInquisitionID() {
		return inquisitionID;
	}

	/**
	 * 设置问卷编号
	 */
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	/**
	 * 获取显示顺序
	 */
	public Integer getShowOrder() {
		return showOrder;
	}

	/**
	 * 设置显示顺序
	 */
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	/**
	 * 获取部分名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置部分名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取显示编号
	 */
	public String getShowNum() {
		return showNum;
	}

	/**
	 * 设置显示编号
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
