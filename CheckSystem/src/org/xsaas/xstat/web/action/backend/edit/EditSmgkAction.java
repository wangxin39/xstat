package org.xsaas.xstat.web.action.backend.edit;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.EducationConstants;
import org.xsaas.xstat.web.conf.NationsConstants;
import org.xsaas.xstat.web.conf.ProvinceConstants;

import org.xsaas.xstat.business.ICityInfoService;
import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.CityInfo;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditSmgkAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4628020941334025859L;
	private static Log logger = LogFactory.getLog(EditSmgkAction.class);
	private ISmgkInfoService smgkInfoService = null;

	private Integer province = null;
	private Long cityID = null;
	private Integer nation = null;
	private String marriAge = null;
	private String stature = null;
	private String avoirdupois = null;
	private String speciality = null;
	private String edu = null;
	private String company = null;
	private String vocation = null;
	private String job = null;
	private String postCode = null;
	private String qq = null;
	private String msn = null;
	private String address = null;
	private String interest = null;
	private String device = null;
	private String possession = null;
	private String bank = null;
	private String bankID =null;
	private String bankUserName = null;
	private String passWord = null;
	private Integer education = null;
	private String realName = null;
	private String telephone = null;
	private String mobile = null;
	private String birthDay = null;
	private String sex = null;
	
	public String execute() throws Exception {
		try{	
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}			
			SmgkInfo info = (SmgkInfo)ActionContext.getContext().getSession().get("SMGKEDIT");
			if(info != null) {
				if(nation != null) {
					info.setNation(nation);					
				}
				if(marriAge != null) {
					info.setMarriAge(marriAge);					
				}
				if(stature != null) {
					info.setStature(stature);					
				}
				if(avoirdupois != null) {
					info.setAvoirdupois(avoirdupois);					
				}
				if(speciality != null) {
					info.setSpeciality(speciality);					
				}
				if(edu != null) {
					info.setEdu(edu);					
				}
				if(company != null) {
					info.setCompany(company);					
				}
				if(vocation != null) {
					info.setVocation(vocation);					
				}
				if(job != null) {
					info.setJob(job);					
				}
				if(postCode != null) {
					info.setPostCode(postCode);					
				}
				if(qq != null) {
					info.setQQ(qq);					
				}
				if(msn != null) {
					info.setMSN(msn);					
				}
				if(address != null) {
					info.setAddress(address);					
				}
				if(interest != null) {
					info.setInterest(interest);					
				}
				if(device != null) {
					info.setDevice(device);					
				}
				if(possession != null) {
					info.setPossession(possession);					
				}
				if(bank != null) {
					info.setBank(bank);					
				}
				if(bankID != null) {
					info.setBankID(bankID);					
				}
				if(bankUserName != null) {
					info.setBankUserName(bankUserName);					
				}
				smgkInfoService.updateSmgkInfo(info);
			}			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		

		return SUCCESS;
		
	}
	@SuppressWarnings("unchecked")
	public String edit() {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}				
			ActionContext.getContext().getSession().put("NATION",NationsConstants.nationDict);
			ActionContext.getContext().getSession().put("EDUCATION",EducationConstants.educationDict);
//			int selectProvince = 0;
//			if(province == null){
//				cityList = cityInfoService.getCityInfoList();
//				if(cityList.size()>0){
//					CityInfo city = cityList.get(0);
//					if(city!=null && city.getProvince()!=null){
//						selectProvince = city.getProvince().intValue();
//						ActionContext.getContext().getSession().put("PROVINCE",selectProvince);//初始化省份信息
//					}
//				}
//				ActionContext.getContext().getSession().put("PROVINCELIST",ProvinceConstants.provinceDict); //获取数据库中的省份
//			}else{
//				selectProvince = province.intValue();
//			}
//			cityList = cityInfoService.getCityInfoList(selectProvince);
//			ActionContext.getContext().getSession().put("CITYLIST",cityList);				
			
			Long smgkID = (Long)ActionContext.getContext().getSession().get("LOGINID");
			SmgkInfo smgkInfo = smgkInfoService.getSmgkInfo(smgkID);			
			ActionContext.getContext().getSession().put("SMGKEDIT",smgkInfo);			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
	
		return SUCCESS;
	}

	public String getBankUserName() {
		return bankUserName;
	}


	public void setBankUserName(String bankUserName) {
		this.bankUserName = bankUserName;
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


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public Integer getEducation() {
		return education;
	}


	public void setEducation(Integer education) {
		this.education = education;
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


	public String getStature() {
		return stature;
	}


	public void setStature(String stature) {
		this.stature = stature;
	}


	public String getAvoirdupois() {
		return avoirdupois;
	}


	public void setAvoirdupois(String avoirdupois) {
		this.avoirdupois = avoirdupois;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	public String getEdu() {
		return edu;
	}


	public void setEdu(String edu) {
		this.edu = edu;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
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


	public String getPostCode() {
		return postCode;
	}


	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}


	public String getQq() {
		return qq;
	}


	public void setQq(String qq) {
		this.qq = qq;
	}


	public String getMsn() {
		return msn;
	}


	public void setMsn(String msn) {
		this.msn = msn;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}


//	public List<CityInfo> getCityList() {
//		return cityList;
//	}
//
//
//	public void setCityList(List<CityInfo> cityList) {
//		this.cityList = cityList;
//	}
//
//
//	public void setCityInfoService(ICityInfoService cityInfoService) {
//		this.cityInfoService = cityInfoService;
//	}

}