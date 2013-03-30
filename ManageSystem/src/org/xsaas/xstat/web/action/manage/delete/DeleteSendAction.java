package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmailSendInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;

import org.xsaas.xstat.po.EmailSendInfo;
import org.xsaas.xstat.po.EmployeeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteSendAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2907110765258863578L;
	private static Log logger = LogFactory.getLog(DeleteSendAction.class);
	private IEmailSendInfoService emailSendInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	
	private Long sendID = null;
	
	public String execute() throws Exception {	

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(sendID == null)return ERROR;
			EmailSendInfo info = emailSendInfoService.getEmailSendInfo(sendID);
			info.setStatus(StatusConstants.SHANCHU);
			emailSendInfoService.updateEmailSendInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}


	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}


	public Long getSendID() {
		return sendID;
	}

	public void setSendID(Long sendID) {
		this.sendID = sendID;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setEmailSendInfoService(IEmailSendInfoService emailSendInfoService) {
		this.emailSendInfoService = emailSendInfoService;
	}


}
