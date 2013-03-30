package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 被检测对象
 */
public class InformantInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5339431922945403316L;
	/**
	 * 被检测对象编号
	 */
	private Long informantID = null;
	/**
	 * 客户编号
	 */
	private Long clientID = null;
	/**
	 * 名称
	 */
	private String aliasName = null;
	/**
	 * 经理邮件地址
	 */
	private String englishAliasName = null;
	/**
	 * 地址
	 */
	private String name = null;
	/**
	 * 地区
	 */
	private String englishName = null;
	/**
	 * 国家
	 */
	private String country = null;
	/**
	 * 省份
	 */
	private Integer province = null;
	/**
	 * 客户帐户
	 */
	private Long cityID = null;
	
	/**
	 * 电话号码
	 */
	private String telephone = null;
	/**
	 * 手机
	 */
	private String mobile = null;
	/**
	 * 电子邮件
	 */
	private String email = null;
	/**
	 * 通讯地址
	 */
	private String address = null;
	/**
	 * 邮编
	 */
	private String postCode = null;
	/**
	 * 注册时间
	 */
	private Timestamp serviceTime = null;
	/**
	 * 语言
	 */
	private String serviceLang = null;
	/**
	 * 注册时间
	 */
	private String serviceType = null;
	/**
	 * 注册时间
	 */
	private String area = null;
	
	private Integer status = null;
	
	public InformantInfo() {
		super();
		
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public Long getCityID() {
		return cityID;
	}

	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Timestamp getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Timestamp serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getServiceLang() {
		return serviceLang;
	}

	public void setServiceLang(String serviceLang) {
		this.serviceLang = serviceLang;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public InformantInfo(Long informantID, Long clientID, String aliasName,
			String englishAliasName, String name, String englishName,
			String country, Integer province, Long cityID, String telephone,
			String mobile, String email, String address, String postCode,
			Timestamp serviceTime, String serviceLang, String serviceType,
			String area, Integer status) {
		super();
		this.informantID = informantID;
		this.clientID = clientID;
		this.aliasName = aliasName;
		this.englishAliasName = englishAliasName;
		this.name = name;
		this.englishName = englishName;
		this.country = country;
		this.province = province;
		this.cityID = cityID;
		this.telephone = telephone;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.postCode = postCode;
		this.serviceTime = serviceTime;
		this.serviceLang = serviceLang;
		this.serviceType = serviceType;
		this.area = area;
		this.status = status;
	}

	/**
	 * 获取被检测对象编号
	 */
	public Long getInformantID() {
		return informantID;
	}
	/**
	 * 设置被检测对象编号
	 */
	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}
	/**
	 * 获取名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getEnglishAliasName() {
		return englishAliasName;
	}

	public void setEnglishAliasName(String englishAliasName) {
		this.englishAliasName = englishAliasName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取客户编号
	 */

	public Long getClientID() {
		return clientID;
	}


	/**
	 * 设置客户编号
	 */
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}


}
