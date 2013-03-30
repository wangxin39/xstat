package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 神秘顾客权限
 */
public class SmgkPopedomInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6962822474760150371L;
	/**
	 * 神秘顾客权限编号
	 */
	private Long smgkPopedomID = null;
	/**
	 * 神秘顾客编号
	 */
	private Long smgkID = null;
	/**
	 * 权限编号
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
	 * 获取神秘顾客权限编号
	 */

	public Long getSmgkPopedomID() {
		return smgkPopedomID;
	}

	/**
	 * 设置神秘顾客权限编号
	 */
	public void setSmgkPopedomID(Long smgkPopedomID) {
		this.smgkPopedomID = smgkPopedomID;
	}
	/**
	 * 获取神秘顾客编号
	 */

	public Long getSmgkID() {
		return smgkID;
	}

	/**
	 * 设置神秘顾客编号
	 */
	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
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
