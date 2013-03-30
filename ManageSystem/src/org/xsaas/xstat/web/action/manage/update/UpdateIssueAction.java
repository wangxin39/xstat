package org.xsaas.xstat.web.action.manage.update;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.po.IssueInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateIssueAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2350155159062965454L;
	private static Log logger = LogFactory.getLog(UpdateIssueAction.class);
	
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
			IssueInfo issueInfo = issueInfoService.getIssueInfo(issueID);
			if(issueInfo == null) {
				this.addActionError("找不到要更新的数据对象！");
				return ERROR;
			}
			issueInfo.setActions((issueInfo.getActions()+1));
			issueInfoService.updateIssueInfo(issueInfo);			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}

	public Long getIssueID() {
		return issueID;
	}

	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}

	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}

}
