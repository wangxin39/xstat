package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * �ʼ�������
 */
public class EmailSendInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5764474477231520811L;
	/**
	 * �ʼ����
	 */
	private Long sendID = null;
	/**
	 * ���͵�
	 */
	private String sendTo = null;
	/**
	 * ����ʱ��
	 */
	private Timestamp sendTime = null;
	/**
	 * ����
	 */
	private String att = null;
	/**
	 * ��������
	 */
	private String topic = null;
	/**
	 * ��������
	 */
	private String content = null;
	/**
	 * ״̬
	 */
	private Integer status = null;
	/**
	 * Ա�����
	 */
	private Long employeeID = null;
	/**
	 * ͨѶ¼���
	 */
	private Long addressID = null;
	/**
	 * ͨѶ¼������
	 */
	private Long acID = null;
	
	public EmailSendInfo() {
		super();
		
	}
	public EmailSendInfo(Long sendID, String sendTo, Timestamp sendTime,
			String att, String topic, String content, Integer status,
			Long employeeID, Long addressID, Long acID) {
		super();
		this.sendID = sendID;
		this.sendTo = sendTo;
		this.sendTime = sendTime;
		this.att = att;
		this.topic = topic;
		this.content = content;
		this.status = status;
		this.employeeID = employeeID;
		this.addressID = addressID;
		this.acID = acID;
	}
	/**
	 * ��ȡ�ʼ����
	 */
	public Long getSendID() {
		return sendID;
	}
	/**
	 * �����ʼ����
	 */
	public void setSendID(Long sendID) {
		this.sendID = sendID;
	}
	/**
	 * ��ȡ���͵�
	 */
	public String getSendTo() {
		return sendTo;
	}
	/**
	 * ���÷���
	 */
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	/**
	 * ��ȡ����ʱ��
	 */
	public Timestamp getSendTime() {
		return sendTime;
	}
	/**
	 * ���÷���ʱ��
	 */
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * ��ȡ����
	 */
	public String getAtt() {
		return att;
	}
	/**
	 * ���ø���
	 */
	public void setAtt(String att) {
		this.att = att;
	}
	/**
	 * ��ȡ��������
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * ���÷�������
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 * ��ȡ��������
	 */
	public String getContent() {
		return content;
	}
	/**
	 * ���÷�������
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * ��ȡԱ�����
	 */
	public Long getEmployeeID() {
		return employeeID;
	}
	/**
	 * ����Ա�����
	 */
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	/**
	 * ��ȡͨѶ¼���
	 */
	public Long getAddressID() {
		return addressID;
	}
	/**
	 * ����ͨѶ¼���
	 */
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}
	/**
	 * ��ȡͨѶ¼������
	 */
	public Long getAcID() {
		return acID;
	}
	/**
	 * ����ͨѶ¼������
	 */
	public void setAcID(Long acID) {
		this.acID = acID;
	}
	
}
