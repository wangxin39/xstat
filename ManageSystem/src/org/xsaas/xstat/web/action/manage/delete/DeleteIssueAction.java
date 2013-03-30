package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.IssueInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteIssueAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(DeleteIssueAction.class);
	private IEmployeeInfoService employeeInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private Long issueID = null;

	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			IssueInfo info = issueInfoService.getIssueInfo(issueID);	
			info.setStatus(StatusConstants.SHANCHU);
			issueInfoService.updateIssueInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	
	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}


	public Long getIssueID() {
		return issueID;
	}


	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}


}
