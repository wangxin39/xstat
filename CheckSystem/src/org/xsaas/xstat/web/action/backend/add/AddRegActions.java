package org.xsaas.xstat.web.action.backend.add;

import java.sql.Timestamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.activation.DataHandler;
//import javax.activation.FileDataSource;
//import javax.mail.Message;
//import javax.mail.Multipart;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
//import org.springframework.mail.MailException;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessagePreparator;

import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddRegActions extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4628020941334025859L;
	private static Log logger = LogFactory.getLog(AddRegActions.class);
	private ISmgkInfoService smgkInfoService = null;

	private Integer province = null;
	private Long cityID = null;
	private String loginName = null;
	private String passWord = null;
	private String confirm = null;
	private Integer education = null;
	private String realName = null;
	private String telephone = null;
	private String mobile = null;
	private String birthDay = null;
	private String sex = null;
	private Timestamp regTime = null;
	private Integer status = null;
	private String authCode = null;
	private Long smgkID = null;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		
		String registerUser = (String)ActionContext.getContext().getSession().get("REGISTERUSER");
		if(registerUser != null && !"NOSAVE".equals(registerUser)) {
			this.addActionMessage("此用户名不存在！");
			return LOGIN;
		}
		String code = (String) ActionContext.getContext().getSession().get("rand");
		
		if(!authCode.equals(code)){
			this.addActionMessage("您输入的验证码有误！请注意大小写匹配！");
			
			return INPUT;
		}
		
		if(!confirm.equals(""+passWord)){
			this.addActionMessage("您输入的密码和确认密码不一致!请重新输入!");
			return INPUT;
		}

		boolean isRegister = smgkInfoService.isRegister(loginName);
		if(isRegister) {
			return INPUT;
		}
	
		SmgkInfo info = new SmgkInfo();
		info.setBirthDay(birthDay);
		info.setEducation(education);
		info.setUserName(loginName);
		info.setTelephone(telephone);
		info.setSex(sex);
		info.setProvince(province);
		info.setCityID(cityID);
		info.setRealName(realName);
		info.setPassWord(passWord);
		info.setMobile(mobile);
		info.setRegTime(new Timestamp(System.currentTimeMillis()));
		info.setStatus(StatusConstants.ZHENGCHANG);
		info.setAuthStatus(StatusConstants.ZHENGZAISHENGHE);
		info.setRegStatus(StatusConstants.YANZHENGYITONGGUO);
		smgkInfoService.saveSmgkInfo(info);
		ActionContext.getContext().getSession().put("SMGKINOF",info);
		
//		StringBuffer sb = new StringBuffer();
//		sb.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html;charset=gb2312\"></head><body><h1><a href=\"http://anima.kmip.net/customer/admin/authReg.do?code=");
//		sb.append(code);
//		sb.append("&amp;name=");
//		sb.append(loginName);
//		sb.append(">http://anima.kmip.net/customer/admin/authReg.do?code=");
//		sb.append(code);
//		sb.append("&amp;name=");
//		sb.append(loginName);				
//		sb.append("</a>请点击此连接激活您的信息!</body></html>");						
		
//		MailUtil.get().send(loginName,SmgkConstants.fromMail,"神秘顾客注册激活验证邮件",sb.toString(),SmgkConstants.encoding);	
//		//创建ApplicationContext实例

		return SUCCESS;
	}

	public String regStatus() throws Exception{
		if(authCode == null && loginName == null){
			this.addActionMessage("邮箱未激活！");
			return INPUT;
		}
		SmgkInfo info = smgkInfoService.getSmgkInfo(smgkID);
		info.setRegStatus(StatusConstants.YANZHENGYITONGGUO);
		info.setCode(authCode);
		smgkInfoService.updateSmgkInfo(info);
		return SUCCESS;
	}
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public String getAuthCode() {
		return authCode;
	}

	public Long getSmgkID() {
		return smgkID;
	}

	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
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


	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}


	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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

}
