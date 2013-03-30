package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 调查问卷信息
 */
public class InquisitionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1374712212981326834L;
	
	/**
	 * 调查问卷编号
	 */
	private Long inquisitionID = null;
	/**
	 * 客户编号
	 */
	private Long clientID = null;
	/**
	 * 模板编号
	 */
	private Long templateID = null;
	/**
	 * 标题
	 */
	private String title = null;
	/**
	 * 状态
	 */
	private Integer status = null;	
	/**
	 * 状态
	 */
	private Integer inquisitionStatus = null;
	
	

	public InquisitionInfo(Long inquisitionID, Long clientID, Long templateID,
			String title, Integer status, Integer inquisitionStatus) {
		super();
		this.inquisitionID = inquisitionID;
		this.clientID = clientID;
		this.templateID = templateID;
		this.title = title;
		this.status = status;
		this.inquisitionStatus = inquisitionStatus;
	}


	public InquisitionInfo() {
		super();
		
	}
	

	public Integer getInquisitionStatus() {
		return inquisitionStatus;
	}


	public void setInquisitionStatus(Integer inquisitionStatus) {
		this.inquisitionStatus = inquisitionStatus;
	}


	/**
	 * 获取客户编号
	 * @return clientID
	 */
    public Long getClientID() {
		return clientID;
	}
    /**
     * 设置客户编号
     * @param clientID
     */
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	
	/**
	 * 获取模板编号
	 */
	public Long getTemplateID() {
		return templateID;
	}
	/**
	 * 设置模板编号
	 */
	public void setTemplateID(Long templateID) {
		this.templateID = templateID;
	}
	/**
	 * 获取状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
     * 获取调查问卷编号
     * @return inquisitionID
     */
	public Long getInquisitionID() {
		return inquisitionID;
	}
	/**
	 * 设置调查问卷编号
	 * @param inquisitionID
	 */
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	/**
	 * 获取标题
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置标题
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	
}
