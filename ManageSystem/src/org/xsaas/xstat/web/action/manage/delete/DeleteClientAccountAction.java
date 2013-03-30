package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IClientAccountInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.po.ClientAccountInfo;
import org.xsaas.xstat.po.EmployeeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteClientAccountAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(DeleteClientAccountAction.class);
	private IEmployeeInfoService employeeInfoService = null;
	private IClientAccountInfoService clientAccountInfoService = null;
	private Long accountID = null;
	
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}

			if(accountID == null)return ERROR;
			ClientAccountInfo info = clientAccountInfoService.getClientAccountInfo(accountID);
			info.setStatus(StatusConstants.SHANCHU);
			clientAccountInfoService.updateClientAccountInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		return SUCCESS;
	}
	
	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}
	public void setClientAccountInfoService(
			IClientAccountInfoService clientAccountInfoService) {
		this.clientAccountInfoService = clientAccountInfoService;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	
}
