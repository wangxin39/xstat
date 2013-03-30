package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * ������Ϣ
 */
public class CityInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3493081738631649103L;
	/**
	 * ���б��
	 */
	private Long cityID = null;
	/**
	 * ��������
	 */
	private String name = null;
	/**
	 * ʡ��
	 */
	private Integer province = null;
	/**
	 * ����Ӣ������
	 */
	private String englishName = null;
	
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public CityInfo() {
		super();
	}
	
	public CityInfo(Long cityID, String name, Integer province,
			String englishName, Integer status) {
		super();
		this.cityID = cityID;
		this.name = name;
		this.province = province;
		this.englishName = englishName;
		this.status = status;
	}
	/**
	 * ��ȡ����Ӣ������
	 */
	public String getEnglishName() {
		return englishName;
	}
	/**
	 * ���ó���Ӣ������
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	/**
	 * ��ȡ���б��
	 */
	public Long getCityID() {
		return cityID;
	}
	/**
	 * ���ó��б��
	 */
	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}
	/**
	 * ��ȡ��������
	 */
	public String getName() {
		return name;
	}
	/**
	 * ���ó�������
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ��ȡʡ��
	 */
	public Integer getProvince() {
		return province;
	}
	/**
	 * ����ʡ��
	 */
	public void setProvince(Integer province) {
		this.province = province;
	}
	

}
