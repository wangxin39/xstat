package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IThemeStyleInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.ThemeStyleInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteThemeStyleAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127570233615470183L;
	private static Log logger = LogFactory.getLog(DeleteThemeStyleAction.class);
	private IThemeStyleInfoService themeStyleInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

  	private Long styleID = null;


	@Override
	public String execute() throws Exception {	

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}		
			ThemeStyleInfo info = themeStyleInfoService.getThemeStyleInfo(styleID);			
			info.setStatus(StatusConstants.SHANCHU);			
			themeStyleInfoService.updateThemeStyleInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public void setThemeStyleInfoService(
			IThemeStyleInfoService themeStyleInfoService) {
		this.themeStyleInfoService = themeStyleInfoService;
	}

	public Long getStyleID() {
		return styleID;
	}

	public void setStyleID(Long styleID) {
		this.styleID = styleID;
	}


}
