package org.xsaas.xstat.web.action.manage.delete;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.ISitePopedomInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.SitePopedomInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteSitePopedomAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7332811562714125510L;
	private static Log logger = LogFactory.getLog(DeleteSitePopedomAction.class);
	private ISitePopedomInfoService sitePopedomInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;


	private Long sitePopedomID = null;



	@Override
	public String execute() throws Exception {

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(sitePopedomID == null)return ERROR;
			SitePopedomInfo info = sitePopedomInfoService.getSitePopedomInfo(sitePopedomID);
			info.setStatus(StatusConstants.SHANCHU);
			sitePopedomInfoService.updateSitePopedomInfo(info);	
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}



	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}



	public Long getSitePopedomID() {
		return sitePopedomID;
	}



	public void setSitePopedomID(Long sitePopedomID) {
		this.sitePopedomID = sitePopedomID;
	}



	public void setSitePopedomInfoService(
			ISitePopedomInfoService sitePopedomInfoService) {
		this.sitePopedomInfoService = sitePopedomInfoService;
	}
	

	
}
