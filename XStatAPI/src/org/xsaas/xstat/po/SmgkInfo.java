package org.xsaas.xstat.po;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 神秘顾客信息
 */
public class SmgkInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8792122898811473511L;
	/**
	 * 神秘顾客编号
	 */
	private Long smgkID = null;
	/**
	 * 用户名称
	 */
	private String userName = null;
	/**
	 * 用户密码
	 */
	private String passWord = null;
	/**
	 * 城市编号
	 */
	private Long cityID = null;
	/**
	 * 省份
	 */
	private Integer province = null;
	/**
	 * 真实姓名
	 */
	private String realName = null;
	/**
	 * 电话号码
	 */
	private String telephone = null;
	/**
	 * 手机
	 */
	private String mobile = null;
	/**
	 * 出生日期
	 */
	private String birthDay = null;
	
	/**
	 * 性别
	 */
	private String sex = null;
	/**
	 * 民族
	 */
	private Integer nation = null;
	/**
	 * 婚姻状况
	 */
	private String marriAge = null;/**
	 * 身高
	 */
	private String stature = null;
	/**
	 * 体重
	 */
	private String avoirdupois = null;
	/**
	 * 最高学历
	 */
	private Integer education = null;
	/**
	 * 专业
	 */
	private String speciality = null;
	/**
	 * 公司所属行业
	 */
	private String vocation = null;
	/**
	 * 职位
	 */
	private String job = null;
	/**
	 * 公司名称
	 */
	private String company = null;
	/**
	 * 邮编
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
	 * 通讯地址
	 */
	private String address = null;
	/**
	 * 受教育状况
	 */
	private String edu = null;

	/**
	 * 兴趣爱好项目
	 */
	private String interest = null;
	/**
	 * 拥有的设备
	 */
	private String device = null;
	/**
	 * 是否具备
	 */
	private String possession = null;
	/**
	 * 开户行
	 */
	private String bank = null;
	/**
	 * 银行帐号
	 */
	private String bankID = null;
	/**
	 * 户名
	 */
	private String bankUserName = null;
	
	
	/**
	 * 状态
	 */
	private Integer status = null;
	/**
	 * 注册时间
	 */
	private Timestamp regTime = null;
	/**
	 * 验证码
	 */
	private String code = null;
	/**
	 * 身份证文件名称
	 */
	private String idNumber = null;
	/**
	 * 文件类型
	 */
	private Integer fileType = null;
	/**
	 * 身份证文件名称
	 */
	private String idFileName = null;
	/**
	 * 状态
	 */
	private Integer authStatus = null;

	/**
	 * 状态
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
	 * 获取顾客编号
	 */
	public Long getSmgkID() {
		return smgkID;
	}
	/**
	 * 设置顾客编号
	 */
	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
	}
	/**
	 * 获取用户名称
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置用户名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * 获取真实姓名
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * 设置真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
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
	 * 获取出生日期
	 */
	public String getBirthDay() {
		return birthDay;
	}
	/**
	 * 设置出生日期
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	/**
	 * 获取性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取民族
	 */
	public Integer getNation() {
		return nation;
	}
	/**
	 * 设置民族
	 */
	public void setNation(Integer nation) {
		this.nation = nation;
	}
	/**
	 * 获取婚姻状况
	 */
	public String getMarriAge() {
		return marriAge;
	}
	/**
	 * 设置婚姻状况
	 */
	public void setMarriAge(String marriAge) {
		this.marriAge = marriAge;
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
	 * 获取受教育情况
	 */
	public String getEdu() {
		return edu;
	}
	/**
	 * 设置受教育情况
	 */
	public void setEdu(String edu) {
		this.edu = edu;
	}


	/**
	 * 获取拥有的设备
	 */
	public String getDevice() {
		return device;
	}
	/**
	 * 设置拥有的设备
	 */
	public void setDevice(String device) {
		this.device = device;
	}
	/**
	 * 获取是否具备
	 */
	public String getPossession() {
		return possession;
	}
	/**
	 * 设置是否具备
	 */
	public void setPossession(String possession) {
		this.possession = possession;
	}
	/**
	 * 获取开户行
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 设置开户行
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * 获取银行帐号
	 */
	public String getBankID() {
		return bankID;
	}
	/**
	 * 设置银行帐号
	 */
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	/**
	 * 获取户名
	 */
	public String getBankUserName() {
		return bankUserName;
	}
	/**
	 * 设置户名
	 */
	public void setBankUserName(String bankUserName) {
		this.bankUserName = bankUserName;
	}
	/**
	 * 获取城市编号 
	 */
	public Long getCityID() {
		return cityID;
	}
	/**
	 *  设置城市编号
	 */
	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}
	/**
	 *  获取身高
	 */
	public String getStature() {
		return stature;
	}
	/**
	 * 设置身高
	 */
	public void setStature(String stature) {
		this.stature = stature;
	}
	/**
	 * 获取体重
	 */
	public String getAvoirdupois() {
		return avoirdupois;
	}
	/**
	 * 设置体重
	 */
	public void setAvoirdupois(String avoirdupois) {
		this.avoirdupois = avoirdupois;
	}
	/**
	 * 获取最高学历 
	 */
	public Integer getEducation() {
		return education;
	}
	/**
	 * 设置最高学历
	 */
	public void setEducation(Integer education) {
		this.education = education;
	}
	/**
	 * 获取专业
	 */
	public String getSpeciality() {
		return speciality;
	}
	/**
	 * 设置专业
	 */
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	/**
	 * 获取公司所属行业
	 */
	public String getVocation() {
		return vocation;
	}
	/**
	 * 设置公司行业
	 */
	public void setVocation(String vocation) {
		this.vocation = vocation;
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
	 * 获取邮政编码
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 设置邮政编码
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	 * 获取状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置状态
	 */

	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取注册时间
	 */
	public Timestamp getRegTime() {
		return regTime;
	}
	/**
	 * 设置注册时间
	 */
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	
	/**
	 * 获取验证码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置验证码
	 */

	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * 获取兴趣爱好项目
	 */
	public String getInterest() {
		return interest;
	}
	/**
	 * 设置兴趣爱好项目
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}

}
