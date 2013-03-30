package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * 邮件通讯录
 */
public class EmailAddressInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9004661157642885558L;
	
	/**
	 * 通讯录编号
	 */
	private Long addressID = null;
	/**
	 * 通讯录分类编号
	 */
	private Long acID = null;
	/**
	 * 姓名
	 */
	private String name = null;
	/**
	 * 联系电话
	 */
	private String telephone = null;
	/**
	 * 通讯地址
	 */
	private String address = null;
	/**
	 * 电子邮件
	 */
	private String email = null;
	/**
	 * QQ
	 */
	private String QQ = null;
	/**
	 * MSN
	 */
	private String MSN = null;
	/**
	 * 手机号码
	 */
	private String mobile = null;
	/**
	 * 公司
	 */
	private String company = null;
	/**
	 * 职位
	 */
	private String job = null;
	/**
	 * 城市编号
	 */
	private Long cityID = null;
	/**
	 * 邮编
	 */
	private String postCode = null;
	/**
	 * 备注
	 */
	private String notes = null;
	
	
	private Integer status = null;
	
	private Integer province = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public EmailAddressInfo() {
		super();
		
	}
	
	public EmailAddressInfo(Long addressID, Long acID, String name,
			String telephone, String address, String email, String qq,
			String msn, String mobile, String company, String job, Long cityID,
			String postCode, String notes, Integer status, Integer province) {
		super();
		this.addressID = addressID;
		this.acID = acID;
		this.name = name;
		this.telephone = telephone;
		this.address = address;
		this.email = email;
		QQ = qq;
		MSN = msn;
		this.mobile = mobile;
		this.company = company;
		this.job = job;
		this.cityID = cityID;
		this.postCode = postCode;
		this.notes = notes;
		this.status = status;
		this.province = province;
	}
	/**
	 * 获取通讯录编号 
	 */
	public Long getAddressID() {
		return addressID;
	}
	public Integer getProvince() {
		return province;
	}
	public void setProvince(Integer province) {
		this.province = province;
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

	/**
	 * 获取联系电话
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * 设置联系电话
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * 获取通讯地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置通讯地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取电子邮件
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置电子邮件
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取QQ
	 */
	public String getQQ() {
		return QQ;
	}
	/**
	 * 设置QQ
	 */
	public void setQQ(String qq) {
		QQ = qq;
	}
	/**
	 * 获取MSN
	 */
	public String getMSN() {
		return MSN;
	}
	/**
	 * 设置MSN
	 */
	public void setMSN(String msn) {
		MSN = msn;
	}
	/**
	 * 获取手机号码
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置手机号码
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取姓名
	 */

	public String getName() {
		return name;
	}

	/**
	 * 设置姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取公司名称
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * 设置公司名称
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 获取职位
	 */
	public String getJob() {
		return job;
	}

	/**
	 * 设置职位
	 */
	public void setJob(String job) {
		this.job = job;
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
	 * 获取邮编
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * 设置邮编
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * 获取备注
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * 设置备注
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
