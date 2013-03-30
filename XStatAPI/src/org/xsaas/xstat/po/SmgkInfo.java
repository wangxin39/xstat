package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * ���ع˿���Ϣ
 */
public class SmgkInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8792122898811473511L;
	/**
	 * ���ع˿ͱ��
	 */
	private Long smgkID = null;
	/**
	 * �û�����
	 */
	private String userName = null;
	/**
	 * �û�����
	 */
	private String passWord = null;
	/**
	 * ���б��
	 */
	private Long cityID = null;
	/**
	 * ʡ��
	 */
	private Integer province = null;
	/**
	 * ��ʵ����
	 */
	private String realName = null;
	/**
	 * �绰����
	 */
	private String telephone = null;
	/**
	 * �ֻ�
	 */
	private String mobile = null;
	/**
	 * ��������
	 */
	private String birthDay = null;
	
	/**
	 * �Ա�
	 */
	private String sex = null;
	/**
	 * ����
	 */
	private Integer nation = null;
	/**
	 * ����״��
	 */
	private String marriAge = null;/**
	 * ���
	 */
	private String stature = null;
	/**
	 * ����
	 */
	private String avoirdupois = null;
	/**
	 * ���ѧ��
	 */
	private Integer education = null;
	/**
	 * רҵ
	 */
	private String speciality = null;
	/**
	 * ��˾������ҵ
	 */
	private String vocation = null;
	/**
	 * ְλ
	 */
	private String job = null;
	/**
	 * ��˾����
	 */
	private String company = null;
	/**
	 * �ʱ�
	 */
	private String postCode = null;
	/**
	 * QQ
	 */
	private String QQ = null;
	/**
	 * MSN
	 */
	private String MSN = null;
	/**
	 * ͨѶ��ַ
	 */
	private String address = null;
	/**
	 * �ܽ���״��
	 */
	private String edu = null;

	/**
	 * ��Ȥ������Ŀ
	 */
	private String interest = null;
	/**
	 * ӵ�е��豸
	 */
	private String device = null;
	/**
	 * �Ƿ�߱�
	 */
	private String possession = null;
	/**
	 * ������
	 */
	private String bank = null;
	/**
	 * �����ʺ�
	 */
	private String bankID = null;
	/**
	 * ����
	 */
	private String bankUserName = null;
	
	
	/**
	 * ״̬
	 */
	private Integer status = null;
	/**
	 * ע��ʱ��
	 */
	private Timestamp regTime = null;
	/**
	 * ��֤��
	 */
	private String code = null;
	/**
	 * ���֤�ļ�����
	 */
	private String idNumber = null;
	/**
	 * �ļ�����
	 */
	private Integer fileType = null;
	/**
	 * ���֤�ļ�����
	 */
	private String idFileName = null;
	/**
	 * ״̬
	 */
	private Integer authStatus = null;

	/**
	 * ״̬
	 */
	private Integer regStatus = null;
	
	public SmgkInfo() {
		super();
		
	}


	public Integer getRegStatus() {
		return regStatus;
	}


	public void setRegStatus(Integer regStatus) {
		this.regStatus = regStatus;
	}


	public SmgkInfo(Long smgkID, String userName, String passWord,
			Long cityID, Integer province, String realName,
			String telephone, String mobile, String birthDay, String sex,
			Integer nation, String marriAge, String stature,
			String avoirdupois, Integer education, String speciality,
			String vocation, String job, String company, String postCode,
			String qq, String msn, String address, String edu, String interest,
			String device, String possession, String bank, String bankID,
			String bankUserName, Integer status, Timestamp regTime,
			String code, String idNumber, Integer fileType, String idFileName,
			Integer authStatus, Integer regStatus) {
		super();
		this.smgkID = smgkID;
		this.userName = userName;
		this.passWord = passWord;
		this.cityID = cityID;
		this.province = province;
		this.realName = realName;
		this.telephone = telephone;
		this.mobile = mobile;
		this.birthDay = birthDay;
		this.sex = sex;
		this.nation = nation;
		this.marriAge = marriAge;
		this.stature = stature;
		this.avoirdupois = avoirdupois;
		this.education = education;
		this.speciality = speciality;
		this.vocation = vocation;
		this.job = job;
		this.company = company;
		this.postCode = postCode;
		QQ = qq;
		MSN = msn;
		this.address = address;
		this.edu = edu;
		this.interest = interest;
		this.device = device;
		this.possession = possession;
		this.bank = bank;
		this.bankID = bankID;
		this.bankUserName = bankUserName;
		this.status = status;
		this.regTime = regTime;
		this.code = code;
		this.idNumber = idNumber;
		this.fileType = fileType;
		this.idFileName = idFileName;
		this.authStatus = authStatus;
		this.regStatus = regStatus;
	}


	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public String getIdFileName() {
		return idFileName;
	}

	public void setIdFileName(String idFileName) {
		this.idFileName = idFileName;
	}

	public Integer getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(Integer authStatus) {
		this.authStatus = authStatus;
	}

	/**
	 * ��ȡ�˿ͱ��
	 */
	public Long getSmgkID() {
		return smgkID;
	}
	/**
	 * ���ù˿ͱ��
	 */
	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
	}
	/**
	 * ��ȡ�û�����
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * �����û�����
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * ��ȡ��ʵ����
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * ������ʵ����
	 */
	public void setRealName(String realName) {
		this.realName = realName;
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
	 * ��ȡ��������
	 */
	public String getBirthDay() {
		return birthDay;
	}
	/**
	 * ���ó�������
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	/**
	 * ��ȡ�Ա�
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * �����Ա�
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * ��ȡ����
	 */
	public Integer getNation() {
		return nation;
	}
	/**
	 * ��������
	 */
	public void setNation(Integer nation) {
		this.nation = nation;
	}
	/**
	 * ��ȡ����״��
	 */
	public String getMarriAge() {
		return marriAge;
	}
	/**
	 * ���û���״��
	 */
	public void setMarriAge(String marriAge) {
		this.marriAge = marriAge;
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
	 * ��ȡ�ܽ������
	 */
	public String getEdu() {
		return edu;
	}
	/**
	 * �����ܽ������
	 */
	public void setEdu(String edu) {
		this.edu = edu;
	}


	/**
	 * ��ȡӵ�е��豸
	 */
	public String getDevice() {
		return device;
	}
	/**
	 * ����ӵ�е��豸
	 */
	public void setDevice(String device) {
		this.device = device;
	}
	/**
	 * ��ȡ�Ƿ�߱�
	 */
	public String getPossession() {
		return possession;
	}
	/**
	 * �����Ƿ�߱�
	 */
	public void setPossession(String possession) {
		this.possession = possession;
	}
	/**
	 * ��ȡ������
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * ���ÿ�����
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * ��ȡ�����ʺ�
	 */
	public String getBankID() {
		return bankID;
	}
	/**
	 * ���������ʺ�
	 */
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	/**
	 * ��ȡ����
	 */
	public String getBankUserName() {
		return bankUserName;
	}
	/**
	 * ���û���
	 */
	public void setBankUserName(String bankUserName) {
		this.bankUserName = bankUserName;
	}
	/**
	 * ��ȡ���б�� 
	 */
	public Long getCityID() {
		return cityID;
	}
	/**
	 *  ���ó��б��
	 */
	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}
	/**
	 *  ��ȡ���
	 */
	public String getStature() {
		return stature;
	}
	/**
	 * �������
	 */
	public void setStature(String stature) {
		this.stature = stature;
	}
	/**
	 * ��ȡ����
	 */
	public String getAvoirdupois() {
		return avoirdupois;
	}
	/**
	 * ��������
	 */
	public void setAvoirdupois(String avoirdupois) {
		this.avoirdupois = avoirdupois;
	}
	/**
	 * ��ȡ���ѧ�� 
	 */
	public Integer getEducation() {
		return education;
	}
	/**
	 * �������ѧ��
	 */
	public void setEducation(Integer education) {
		this.education = education;
	}
	/**
	 * ��ȡרҵ
	 */
	public String getSpeciality() {
		return speciality;
	}
	/**
	 * ����רҵ
	 */
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	/**
	 * ��ȡ��˾������ҵ
	 */
	public String getVocation() {
		return vocation;
	}
	/**
	 * ���ù�˾��ҵ
	 */
	public void setVocation(String vocation) {
		this.vocation = vocation;
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
	 * ��ȡ��������
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * ������������
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	 * ��ȡ״̬
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * ����״̬
	 */

	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * ��ȡע��ʱ��
	 */
	public Timestamp getRegTime() {
		return regTime;
	}
	/**
	 * ����ע��ʱ��
	 */
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	
	/**
	 * ��ȡ��֤��
	 */
	public String getCode() {
		return code;
	}
	/**
	 * ������֤��
	 */

	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * ��ȡ��Ȥ������Ŀ
	 */
	public String getInterest() {
		return interest;
	}
	/**
	 * ������Ȥ������Ŀ
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}

}
