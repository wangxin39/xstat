package org.xsaas.xstat.po;

import java.io.Serializable;
/**
 * �ʼ�ͨѶ¼
 */
public class EmailAddressInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9004661157642885558L;
	
	/**
	 * ͨѶ¼���
	 */
	private Long addressID = null;
	/**
	 * ͨѶ¼������
	 */
	private Long acID = null;
	/**
	 * ����
	 */
	private String name = null;
	/**
	 * ��ϵ�绰
	 */
	private String telephone = null;
	/**
	 * ͨѶ��ַ
	 */
	private String address = null;
	/**
	 * �����ʼ�
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
	 * �ֻ�����
	 */
	private String mobile = null;
	/**
	 * ��˾
	 */
	private String company = null;
	/**
	 * ְλ
	 */
	private String job = null;
	/**
	 * ���б��
	 */
	private Long cityID = null;
	/**
	 * �ʱ�
	 */
	private String postCode = null;
	/**
	 * ��ע
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
	 * ��ȡͨѶ¼��� 
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
	 * ����ͨѶ¼���
	 */
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}
	/**
	 * ��ȡͨѶ¼������
	 */
	public Long getAcID() {
		return acID;
	}
	/**
	 * ����ͨѶ¼������
	 */
	public void setAcID(Long acID) {
		this.acID = acID;
	}

	/**
	 * ��ȡ��ϵ�绰
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * ������ϵ�绰
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * ��ȡͨѶ��ַ
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * ����ͨѶ��ַ
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * ��ȡ�����ʼ�
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * ���õ����ʼ�
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * ��ȡQQ
	 */
	public String getQQ() {
		return QQ;
	}
	/**
	 * ����QQ
	 */
	public void setQQ(String qq) {
		QQ = qq;
	}
	/**
	 * ��ȡMSN
	 */
	public String getMSN() {
		return MSN;
	}
	/**
	 * ����MSN
	 */
	public void setMSN(String msn) {
		MSN = msn;
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

	/**
	 * ��ȡ��˾����
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * ���ù�˾����
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * ��ȡְλ
	 */
	public String getJob() {
		return job;
	}

	/**
	 * ����ְλ
	 */
	public void setJob(String job) {
		this.job = job;
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
	 * ��ȡ�ʱ�
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * �����ʱ�
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * ��ȡ��ע
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * ���ñ�ע
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
