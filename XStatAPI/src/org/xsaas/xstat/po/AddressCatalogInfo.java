package org.xsaas.xstat.po;

import java.io.Serializable;

/**
 * 通讯录分类信息
 * @author wangxin
 *
 */
public class AddressCatalogInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2859484315625551752L;
	/**
	 * 分类编号
	 */
	private Long acID = null;
	/**
	 * 分类名称
	 */
	private String name = null;
	/**
	 * 国家
	 */
	private String country = null;
	/**
	 * 语言
	 */
	private String lang = null;
	
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 
	 */
	public AddressCatalogInfo() {
		super();
	}
	
	public AddressCatalogInfo(Long acID, String name, String country,
			String lang, Integer status) {
		super();
		this.acID = acID;
		this.name = name;
		this.country = country;
		this.lang = lang;
		this.status = status;
	}
	/**
	 * 获取编号
	 */
	public Long getAcID() {
		return acID;
	}
	/**
	 * 设置分类编号
	 */
	public void setAcID(Long acID) {
		this.acID = acID;
	}
	/**
	 * 获取分类名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置分类名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取国家
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置国家
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取语言
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * 设置语言
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	

	
}
