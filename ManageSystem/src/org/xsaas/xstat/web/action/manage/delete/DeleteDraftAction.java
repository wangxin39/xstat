package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmailDraftInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.po.EmailDraftInfo;
import org.xsaas.xstat.po.EmployeeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteDraftAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2907110765258863578L;
	private static Log logger = LogFactory.getLog(DeleteDraftAction.class);
	private IEmailDraftInfoService emailDraftInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	
	private Long draftID = null;
	
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}

			
			if(draftID == null)return ERROR;
			EmailDraftInfo info = emailDraftInfoService.getEmailDraftInfo(draftID);
			info.setStatus(StatusConstants.SHANCHU);
			emailDraftInfoService.updateEmailDraftInfo(info);	
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}


	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}


	public Long getDraftID() {
		return draftID;
	}

	public void setDraftID(Long draftID) {
		this.draftID = draftID;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setEmailDraftInfoService(IEmailDraftInfoService emailDraftInfoService) {
		this.emailDraftInfoService = emailDraftInfoService;
	}


}
