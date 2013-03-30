package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 客户帐户信息
 */
public class ClientAccountInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8792122898811473511L;
	/**
	 * 帐户编号
	 */
	private Long accountID = null;
	/**
	 * 客户帐户
	 */
	private Long clientID = null;
	/**
	 * 帐号类型
	 * 1：公司总部
	 * 2：片区经理
	 * 3：调查对象
	 */
	private Integer type = null;
	/**
	 * 客户帐户
	 */
	private Long informantID = null;
	
	/**
	 * 用户名称
	 */
	private String clientName = null;
	/**
	 * 用户密码
	 */
	private String passWord = null;
	
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
	private String loginName = null;

	/**
	 * 注册时间
	 */
	private Timestamp lastLogin = null;
	/**
	 * 最后登录IP
	 */
	private String lastIP = null;
	/**
	 * 注册时间
	 */
	private Long fatherID = null;
	
	private Integer status = null;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public ClientAccountInfo() {
		super();		
	}
	
	public ClientAccountInfo(Long accountID, Long cityID, Long clientID,
			String clientName, String country, Long fatherID, Long informantID,
			String lastIP, Timestamp lastLogin, String loginName,
			String mobile, String passWord, Integer province, Integer status,
			String telephone, Integer type) {
		super();
		this.accountID = accountID;
		this.cityID = cityID;
		this.clientID = clientID;
		this.clientName = clientName;
		this.country = country;
		this.fatherID = fatherID;
		this.informantID = informantID;
		this.lastIP = lastIP;
		this.lastLogin = lastLogin;
		this.loginName = loginName;
		this.mobile = mobile;
		this.passWord = passWord;
		this.province = province;
		this.status = status;
		this.telephone = telephone;
		this.type = type;
	}
	public Long getInformantID() {
		return informantID;
	}

	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}

	/**
	 * 获取密码
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * 设置密码
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
	
	/**
	 * 获取电话号码
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * 设置电话号码
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	 * 获取帐户编号
	 */
	public Long getAccountID() {
		return accountID;
	}
	/**
	 * 设置帐户编号
	 */
	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}
	
	/**
	 * 获取客户名称
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * 设置客户名称
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
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
	 * 获取最后登陆IP
	 */
	public String getLastIP() {
		return lastIP;
	}
	/**
	 * 设置最后登陆IP
	 */
	public void setLastIP(String lastIP) {
		this.lastIP = lastIP;
	}
	/**
	 * 获取最后登陆时间
	 */
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	/**
	 * 设置最后登陆时间
	 */
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}



	public Long getClientID() {
		return clientID;
	}



	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}



	public Long getCityID() {
		return cityID;
	}



	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}


	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Long getFatherID() {
		return fatherID;
	}



	public void setFatherID(Long fatherID) {
		this.fatherID = fatherID;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	
}
