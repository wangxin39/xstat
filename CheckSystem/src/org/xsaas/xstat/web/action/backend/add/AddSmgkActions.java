package org.xsaas.xstat.web.action.backend.add;

import java.sql.Timestamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddSmgkActions extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4628020941334025859L;
	private static Log logger = LogFactory.getLog(AddSmgkActions.class);
	private ISmgkInfoService smgkInfoService = null;
	private String loginName = null;
	private String passWord = null;
	private String email = null;
	private Integer province = null;
	private String realName = null;
	private String telephone = null;
	private String mobile = null;
	private Long cityID = null;
	private String birthDay = null;
	private String sex = null;
	private Integer nation = null;
	private String marriAge = null;
	private String stature = null;
	private String avoirdupois = null;
	private Integer education = null;
	private String speciality = null;
	private String vocation = null;
	private String job = null;
	private String company = null;
	private String postCode = null;
	private String QQ = null;
	private String MSN = null;
	private String address = null;
	private String edu = null;
	private String interest = null;
	private String device = null;
	private String possession = null;
	private String bank = null;
	private String bankID = null;
	private String bankUserName = null;
	private Timestamp regTime = null;
	private Integer status = null;
	

	public String execute() throws Exception {
		if(loginName == null || passWord == null || email == null || mobile == null || telephone == null)
		{
			return INPUT;
		}
		
		//"<a href=\"http://anima.kmip.net/customer/admin/act.do?code=222222dddss&id=1\">http://anima.kmip.net/customer/admin/</a>请点击此连接激活账户!"
		//text/html;charset=GBK
		

		try{
			String registerUser = (String)ActionContext.getContext().getSession().get("REGISTERUSER");
			if(registerUser != null && !"NOSAVE".equals(registerUser)) {
				return LOGIN;
			}
			boolean isRegister = smgkInfoService.isRegister(loginName);
			if(isRegister) {
				this.addActionError("confirm");
				return INPUT;
			}
			
			SmgkInfo info = new SmgkInfo();
			if(address != null) {
				info.setAddress(address);			
			}
			info.setAvoirdupois(avoirdupois);
			info.setBank(bank);
			info.setBankID(bankID);
			info.setBankUserName(bankUserName);
			info.setBirthDay(birthDay);
			info.setCompany(company);
			info.setDevice(device);
			if(cityID == null) {
				info.setCityID(new Long(0));
			}else{
				info.setCityID(cityID);			
			}
			info.setEdu(edu);
			info.setEducation(education);
			info.setVocation(vocation);
			info.setUserName(loginName);
			info.setTelephone(telephone);
			info.setStature(stature);
			info.setSpeciality(speciality);
			info.setSex(sex);
			info.setRealName(realName);
			info.setQQ(QQ);
			info.setProvince(province);
			info.setPostCode(postCode);
			info.setPossession(possession);
			info.setPassWord(passWord);
			info.setNation(nation);
			info.setMSN(MSN);
			info.setMobile(mobile);
			info.setMarriAge(marriAge);
			info.setJob(job);
			info.setInterest(interest);
			info.setRegTime(new Timestamp(System.currentTimeMillis()));
			info.setStatus(StatusConstants.ZHENGCHANG);
			info.setAuthStatus(StatusConstants.ZHENGZAISHENGHE);
			info.setRegStatus(StatusConstants.ZHUCEWEIYAZHENG);
			smgkInfoService.saveSmgkInfo(info);
		}catch(Exception e){
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getNation() {
		return nation;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	public String getMarriAge() {
		return marriAge;
	}

	public void setMarriAge(String marriAge) {
		this.marriAge = marriAge;
	}

	public String getAvoirdupois() {
		return avoirdupois;
	}

	public void setAvoirdupois(String avoirdupois) {
		this.avoirdupois = avoirdupois;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qq) {
		QQ = qq;
	}

	public String getMSN() {
		return MSN;
	}

	public void setMSN(String msn) {
		MSN = msn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getPossession() {
		return possession;
	}

	public void setPossession(String possession) {
		this.possession = possession;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	public String getBankUserName() {
		return bankUserName;
	}

	public void setBankUserName(String bankUserName) {
		this.bankUserName = bankUserName;
	}

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}
	public String getStature() {
		return stature;
	}

	public void setStature(String stature) {
		this.stature = stature;
	}

	public Timestamp getRegTime() {
		return regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Long getCityID() {
		return cityID;
	}

	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}

}
