package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 检测客户权限信息
 */
public class ClientPopedomInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8416261777586572836L;
	/**
	 * 客户权限编号
	 */
	private Long clientPopedomID = null;
	/**
	 * 被调查对象编号
	 */
	private Long planID = null;

	/**
	 *  客户编号
	 */
	private Long clientID = null;
	/**
	 * 被调查对象编号
	 */
	private Long issueID = null;
	/**
	 * 被调查对象编号
	 */
	private Long accountID = null;
	/**
	 * 权限
	 */
	private Integer popedom = null;
	
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public ClientPopedomInfo() {
		super();
		
	}

	
	public Long getClientPopedomID() {
		return clientPopedomID;
	}
	public void setClientPopedomID(Long clientPopedomID) {
		this.clientPopedomID = clientPopedomID;
	}
	public ClientPopedomInfo(Long clientPopedomID, Long planID, Long clientID,
			Long issueID, Long accountID, Integer popedom, Integer status) {
		super();
		this.clientPopedomID = clientPopedomID;
		this.planID = planID;
		this.clientID = clientID;
		this.issueID = issueID;
		this.accountID = accountID;
		this.popedom = popedom;
		this.status = status;
	}
	public Long getPlanID() {
		return planID;
	}


	public void setPlanID(Long planID) {
		this.planID = planID;
	}


	public Long getClientID() {
		return clientID;
	}


	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}


	public Long getIssueID() {
		return issueID;
	}


	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}


	public Long getAccountID() {
		return accountID;
	}


	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}


	/**
	 * 获取权限
	 */
	public Integer getPopedom() {
		return popedom;
	}
	/**
	 * 设置权限
	 */
	public void setPopedom(Integer popedom) {
		this.popedom = popedom;
	}

}
