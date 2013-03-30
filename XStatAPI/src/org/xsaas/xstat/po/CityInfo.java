package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 城市信息
 */
public class CityInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3493081738631649103L;
	/**
	 * 城市编号
	 */
	private Long cityID = null;
	/**
	 * 城市名称
	 */
	private String name = null;
	/**
	 * 省份
	 */
	private Integer province = null;
	/**
	 * 城市英文名称
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
	 * 获取城市英文名称
	 */
	public String getEnglishName() {
		return englishName;
	}
	/**
	 * 设置城市英文名称
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	/**
	 * 获取城市编号
	 */
	public Long getCityID() {
		return cityID;
	}
	/**
	 * 设置城市编号
	 */
	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}
	/**
	 * 获取城市名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置城市名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取省份
	 */
	public Integer getProvince() {
		return province;
	}
	/**
	 * 设置省份
	 */
	public void setProvince(Integer province) {
		this.province = province;
	}
	

}
