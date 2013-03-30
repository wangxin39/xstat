package org.xsaas.xstat.web.action.manage.edit;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.MailUtil;

import org.xsaas.xstat.business.IAddressCatalogInfoService;
import org.xsaas.xstat.business.IEmailAddressInfoService;
import org.xsaas.xstat.business.IEmailSendInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.po.AddressCatalogInfo;
import org.xsaas.xstat.po.EmailAddressInfo;
import org.xsaas.xstat.po.EmailSendInfo;
import org.xsaas.xstat.po.EmployeeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditSendAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2907110765258863578L;
	private static Log logger = LogFactory.getLog(EditSendAction.class);
	private IEmailSendInfoService emailSendInfoService = null;
	private IAddressCatalogInfoService addressCatalogInfoService = null;
	private IEmailAddressInfoService emailAddressInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;
	private Long sendID = null;
	
	private List<String> eList = new LinkedList<String>();
	private List<String> eaList = new LinkedList<String>();
	private List<String> acList = new LinkedList<String>();
	private Long addressID = null;
	private Long acID = null;
	
	private Long employeeID = null;
	private String sendTo = null;
	private String att = null;
	private String topic = null;
	private String content = null;

	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				EmailSendInfo info = (EmailSendInfo) ActionContext.getContext().getSession().get("SENDEDIT");
				info.setAcID(acID);
				info.setAddressID(addressID);
				info.setAtt(att);
				info.setContent(content);
				info.setEmployeeID(employeeID);
				info.setSendTo(sendTo);
				info.setTopic(topic);
				emailSendInfoService.updateEmailSendInfo(info);
				MailUtil.get().send(sendTo,SmgkConstants.fromMail,topic,content,SmgkConstants.encoding);	
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			if(sendID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			List<EmployeeInfo> eList = employeeInfoService.getEmployeeInfoList();
			List<EmailAddressInfo> eaList = emailAddressInfoService.getEmailAddressInfoList();
			List<AddressCatalogInfo> acList = addressCatalogInfoService.getAddressCatalogInfoList();
			ActionContext.getContext().getSession().put("EMPLOYEESELECT",eList);
			ActionContext.getContext().getSession().put("EMAILSELEST",eaList);
			ActionContext.getContext().getSession().put("CATALOGSELECT",acList);
			EmailSendInfo sendList = emailSendInfoService.getEmailSendInfo(sendID);
			ActionContext.getContext().getSession().put("STATUS",StatusConstants.StatusDict);
			ActionContext.getContext().getSession().put("SENDEDIT",sendList);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}		
	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}
	public List<String> getEList() {
		return eList;
	}

	public void setEList(List<String> list) {
		eList = list;
	}



	public List<String> getEaList() {
		return eaList;
	}

	public void setEaList(List<String> eaList) {
		this.eaList = eaList;
	}

	public List<String> getAcList() {
		return acList;
	}

	public void setAcList(List<String> acList) {
		this.acList = acList;
	}

	public Long getAddressID() {
		return addressID;
	}

	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	public Long getAcID() {
		return acID;
	}

	public void setAcID(Long acID) {
		this.acID = acID;
	}


	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getAtt() {
		return att;
	}

	public void setAtt(String att) {
		this.att = att;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setEmailSendInfoService(IEmailSendInfoService emailSendInfoService) {
		this.emailSendInfoService = emailSendInfoService;
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public Long getSendID() {
		return sendID;
	}

	public void setSendID(Long sendID) {
		this.sendID = sendID;
	}

	public void setAddressCatalogInfoService(
			IAddressCatalogInfoService addressCatalogInfoService) {
		this.addressCatalogInfoService = addressCatalogInfoService;
	}

	public void setEmailAddressInfoService(
			IEmailAddressInfoService emailAddressInfoService) {
		this.emailAddressInfoService = emailAddressInfoService;
	}
}
