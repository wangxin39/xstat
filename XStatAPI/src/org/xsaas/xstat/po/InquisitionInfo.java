package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * �����ʾ���Ϣ
 */
public class InquisitionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1374712212981326834L;
	
	/**
	 * �����ʾ���
	 */
	private Long inquisitionID = null;
	/**
	 * �ͻ����
	 */
	private Long clientID = null;
	/**
	 * ģ����
	 */
	private Long templateID = null;
	/**
	 * ����
	 */
	private String title = null;
	/**
	 * ״̬
	 */
	private Integer status = null;	
	/**
	 * ״̬
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
	 * ��ȡ�ͻ����
	 * @return clientID
	 */
    public Long getClientID() {
		return clientID;
	}
    /**
     * ���ÿͻ����
     * @param clientID
     */
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	
	/**
	 * ��ȡģ����
	 */
	public Long getTemplateID() {
		return templateID;
	}
	/**
	 * ����ģ����
	 */
	public void setTemplateID(Long templateID) {
		this.templateID = templateID;
	}
	/**
	 * ��ȡ״̬
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * ����״̬
	 */
	public void setStatus(Integer status) {
		this.status = status;
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
	 * ��ȡ����
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * ���ñ���
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	
}
