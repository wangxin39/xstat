package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmailAddressInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.po.EmailAddressInfo;
import org.xsaas.xstat.po.EmployeeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAddressAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7332811562714125510L;
	private static Log logger = LogFactory.getLog(DeleteAddressAction.class);
	private IEmailAddressInfoService emailAddressInfoService = null;

	private Long addressID = null;

	@Override
	public String execute() throws Exception {		
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(addressID == null)return ERROR;
			EmailAddressInfo info = emailAddressInfoService.getEmailAddressInfo(addressID);
			info.setStatus(StatusConstants.SHANCHU);
			emailAddressInfoService.updateEmailAddressInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	public Long getAddressID() {
		return addressID;
	}

	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}


	public void setEmailAddressInfoService(
			IEmailAddressInfoService emailAddressInfoService) {
		this.emailAddressInfoService = emailAddressInfoService;
	}

}
