package cn.iaicc.smgk.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IThemeInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.ThemeInfo;

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
			cn.iaicc.smgk.business.IThemeInfoService themeInfoService) {
		this.themeInfoService = themeInfoService;
	}


	public Long getThemeID() {
		return themeID;
	}


	public void setThemeID(Long themeID) {
		this.themeID = themeID;
	}

	
}
