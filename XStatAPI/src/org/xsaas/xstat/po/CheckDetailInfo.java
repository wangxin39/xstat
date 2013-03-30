package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * �ʼ�ͨѶ¼
 */
public class CheckDetailInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9004661157642885558L;
	
	/**
	 * ͨѶ¼���
	 */
	private Long checkDetailID = null;
	/**
	 *  �ͻ����
	 */
	private Long clientID = null;
	
	/**
	 * �����ʾ���
	 */
	private Long projectID = null;
	/**
	 * �����������
	 */
	private Long issueID = null;

	/**
	 * ���б��
	 */
	private Long inquisitionID = null;
	
	/**
	 * �ֻ�����
	 */
	private String what = null;
	/**
	 * ��˾
	 */
	private String enWhat = null;
	
	/**
	 * �ʱ�
	 */
	private Integer type = null;
	
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public CheckDetailInfo() {
		super();
		
	}
	
	public CheckDetailInfo(Long checkDetailID, Long clientID, Long projectID,
			Long issueID, Long inquisitionID, String what, String enWhat,
			Integer type, Integer status) {
		super();
		this.checkDetailID = checkDetailID;
		this.clientID = clientID;
		this.projectID = projectID;
		this.issueID = issueID;
		this.inquisitionID = inquisitionID;
		this.what = what;
		this.enWhat = enWhat;
		this.type = type;
		this.status = status;
	}
	public Long getIssueID() {
		return issueID;
	}
	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}
	public Long getInquisitionID() {
		return inquisitionID;
	}
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	public Long getClientID() {
		return clientID;
	}
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	public Long getProjectID() {
		return projectID;
	}
	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}
	public Long getCheckDetailID() {
		return checkDetailID;
	}
	public void setCheckDetailID(Long checkDetailID) {
		this.checkDetailID = checkDetailID;
	}
	public String getWhat() {
		return what;
	}
	public void setWhat(String what) {
		this.what = what;
	}
	public String getEnWhat() {
		return enWhat;
	}
	public void setEnWhat(String enWhat) {
		this.enWhat = enWhat;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

}
