package org.xsaas.xstat.po;

import java.io.Serializable;

/**
 * ͨѶ¼������Ϣ
 * @author wangxin
 *
 */
public class AddressCatalogInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2859484315625551752L;
	/**
	 * ������
	 */
	private Long acID = null;
	/**
	 * ��������
	 */
	private String name = null;
	/**
	 * ����
	 */
	private String country = null;
	/**
	 * ����
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
	 * ��ȡ���
	 */
	public Long getAcID() {
		return acID;
	}
	/**
	 * ���÷�����
	 */
	public void setAcID(Long acID) {
		this.acID = acID;
	}
	/**
	 * ��ȡ��������
	 */
	public String getName() {
		return name;
	}
	/**
	 * ���÷�������
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ��ȡ����
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * ���ù���
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * ��ȡ����
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * ��������
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	

	
}
