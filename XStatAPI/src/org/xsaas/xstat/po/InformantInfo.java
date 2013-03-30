package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * ��������
 */
public class InformantInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5339431922945403316L;
	/**
	 * ����������
	 */
	private Long informantID = null;
	/**
	 * �ͻ����
	 */
	private Long clientID = null;
	/**
	 * ����
	 */
	private String aliasName = null;
	/**
	 * �����ʼ���ַ
	 */
	private String englishAliasName = null;
	/**
	 * ��ַ
	 */
	private String name = null;
	/**
	 * ����
	 */
	private String englishName = null;
	/**
	 * ����
	 */
	private String country = null;
	/**
	 * ʡ��
	 */
	private Integer province = null;
	/**
	 * �ͻ��ʻ�
	 */
	private Long cityID = null;
	
	/**
	 * �绰����
	 */
	private String telephone = null;
	/**
	 * �ֻ�
	 */
	private String mobile = null;
	/**
	 * �����ʼ�
	 */
	private String email = null;
	/**
	 * ͨѶ��ַ
	 */
	private String address = null;
	/**
	 * �ʱ�
	 */
	private String postCode = null;
	/**
	 * ע��ʱ��
	 */
	private Timestamp serviceTime = null;
	/**
	 * ����
	 */
	private String serviceLang = null;
	/**
	 * ע��ʱ��
	 */
	private String serviceType = null;
	/**
	 * ע��ʱ��
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
	 * ��ȡ����������
	 */
	public Long getInformantID() {
		return informantID;
	}
	/**
	 * ���ñ���������
	 */
	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}
	/**
	 * ��ȡ����
	 */
	public String getName() {
		return name;
	}
	/**
	 * ��������
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
	 * ��ȡ�ͻ����
	 */

	public Long getClientID() {
		return clientID;
	}


	/**
	 * ���ÿͻ����
	 */
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}


}
