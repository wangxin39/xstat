package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IThemeInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.ThemeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteThemeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127570233615470183L;
	private static Log logger = LogFactory.getLog(DeleteThemeAction.class);
	private IThemeInfoService themeInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;


	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}


	private Long themeID = null;
  	

	@Override
	public String execute() throws Exception {	

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			ThemeInfo info = themeInfoService.getThemeInfo(themeID);
			info.setStatus(StatusConstants.SHANCHU);
			themeInfoService.updateThemeInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}


	public void setThemeInfoService(
			org.xsaas.xstat.business.IThemeInfoService themeInfoService) {
		this.themeInfoService = themeInfoService;
	}


	public Long getThemeID() {
		return themeID;
	}


	public void setThemeID(Long themeID) {
		this.themeID = themeID;
	}

	
}
