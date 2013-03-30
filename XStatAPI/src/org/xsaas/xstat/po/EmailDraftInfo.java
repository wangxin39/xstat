package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 邮件草稿箱
 */
public class EmailDraftInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5764474477231520811L;
	/**
	 * 草稿编号
	 */
	private Long draftID = null;
	/**
	 * 发送到
	 */
	private String sendTo = null;
	/**
	 * 发送时间
	 */
	private Timestamp sendTime = null;
	/**
	 * 附件
	 */
	private String att = null;
	/**
	 * 发送主题
	 */
	private String topic = null;
	/**
	 * 发送内容
	 */
	private String content = null;
	/**
	 * 状态
	 */
	private Integer status = null;
	/**
	 * 员工编号
	 */
	private Long employeeID = null;
	/**
	 * 通讯录编号
	 */
	private Long addressID = null;
	/**
	 * 通讯录分类编号
	 */
	private Long acID = null;
	public EmailDraftInfo() {
		super();
		
	}
	public EmailDraftInfo(Long draftID, String sendTo, Timestamp sendTime,
			String att, String topic, String content, Integer status,
			Long employeeID, Long addressID, Long acID) {
		super();
		this.draftID = draftID;
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
	 * 获取草稿编号
	 */
	public Long getDraftID() {
		return draftID;
	}
	/**
	 * 设置草稿编号
	 */
	public void setDraftID(Long draftID) {
		this.draftID = draftID;
	}
	/**
	 * 获取发送到
	 */
	public String getSendTo() {
		return sendTo;
	}
	/**
	 * 设置发送
	 */
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	/**
	 * 获取发送时间
	 */
	public Timestamp getSendTime() {
		return sendTime;
	}
	/**
	 * 设置发送时间
	 */
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * 获取附件
	 */
	public String getAtt() {
		return att;
	}
	/**
	 * 设置附件
	 */
	public void setAtt(String att) {
		this.att = att;
	}
	/**
	 * 获取发送主题
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * 设置发送主题
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 * 获取发送内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置发送内容
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * 获取员工编号
	 */
	public Long getEmployeeID() {
		return employeeID;
	}
	/**
	 * 设置员工编号
	 */
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	/**
	 * 获取通讯录编号
	 */
	public Long getAddressID() {
		return addressID;
	}
	/**
	 * 设置通讯录编号
	 */
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}
	/**
	 * 获取通讯录分类编号
	 */
	public Long getAcID() {
		return acID;
	}
	/**
	 * 设置通讯录分类编号
	 */
	public void setAcID(Long acID) {
		this.acID = acID;
	}
	
}
