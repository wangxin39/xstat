package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.OptionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteSelectManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6769434775929025493L;
	private static Log logger = LogFactory.getLog(DeleteSelectManageAction.class);

	private IOptionInfoService optionInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	private Long optionID = null;

	public String execute()throws Exception{

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(optionID == null){
				return ERROR;
			}

			OptionInfo info = optionInfoService.getOptionInfo(optionID);
			info.setStatus(StatusConstants.SHANCHU);
			optionInfoService.update(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public Long getOptionID() {
		return optionID;
	}

	public void setOptionID(Long optionID) {
		this.optionID = optionID;
	}

	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}


}
