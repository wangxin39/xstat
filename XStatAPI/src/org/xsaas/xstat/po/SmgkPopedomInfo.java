package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * ���ع˿�Ȩ��
 */
public class SmgkPopedomInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6962822474760150371L;
	/**
	 * ���ع˿�Ȩ�ޱ��
	 */
	private Long smgkPopedomID = null;
	/**
	 * ���ع˿ͱ��
	 */
	private Long smgkID = null;
	/**
	 * Ȩ�ޱ��
	 */
	private Integer popedom = null;
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public SmgkPopedomInfo() {
		super();
		
	}
	
	public SmgkPopedomInfo(Long smgkPopedomID, Long smgkID, Integer popedom,
			Integer status) {
		super();
		this.smgkPopedomID = smgkPopedomID;
		this.smgkID = smgkID;
		this.popedom = popedom;
		this.status = status;
	}
	/**
	 * ��ȡ���ع˿�Ȩ�ޱ��
	 */

	public Long getSmgkPopedomID() {
		return smgkPopedomID;
	}

	/**
	 * �������ع˿�Ȩ�ޱ��
	 */
	public void setSmgkPopedomID(Long smgkPopedomID) {
		this.smgkPopedomID = smgkPopedomID;
	}
	/**
	 * ��ȡ���ع˿ͱ��
	 */

	public Long getSmgkID() {
		return smgkID;
	}

	/**
	 * �������ع˿ͱ��
	 */
	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
	}
	/**
	 * ��ȡȨ��
	 */

	
	public Integer getPopedom() {
		return popedom;
	}
	/**
	 * ����Ȩ��
	 */
	public void setPopedom(Integer popedom) {
		this.popedom = popedom;
	}

}
