package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * �ͻ��ʻ���Ϣ
 */
public class ClientAccountInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8792122898811473511L;
	/**
	 * �ʻ����
	 */
	private Long accountID = null;
	/**
	 * �ͻ��ʻ�
	 */
	private Long clientID = null;
	/**
	 * �ʺ�����
	 * 1����˾�ܲ�
	 * 2��Ƭ������
	 * 3���������
	 */
	private Integer type = null;
	/**
	 * �ͻ��ʻ�
	 */
	private Long informantID = null;
	
	/**
	 * �û�����
	 */
	private String clientName = null;
	/**
	 * �û�����
	 */
	private String passWord = null;
	
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
	private String loginName = null;

	/**
	 * ע��ʱ��
	 */
	private Timestamp lastLogin = null;
	/**
	 * ����¼IP
	 */
	private String lastIP = null;
	/**
	 * ע��ʱ��
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
	 * ��ȡ����
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * ��������
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
	
	/**
	 * ��ȡ�绰����
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * ���õ绰����
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * ��ȡ�ֻ�����
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * �����ֻ�����
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * ��ȡ�ʻ����
	 */
	public Long getAccountID() {
		return accountID;
	}
	/**
	 * �����ʻ����
	 */
	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}
	
	/**
	 * ��ȡ�ͻ�����
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * ���ÿͻ�����
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
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
	 * ��ȡ����½IP
	 */
	public String getLastIP() {
		return lastIP;
	}
	/**
	 * ��������½IP
	 */
	public void setLastIP(String lastIP) {
		this.lastIP = lastIP;
	}
	/**
	 * ��ȡ����½ʱ��
	 */
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	/**
	 * ��������½ʱ��
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
