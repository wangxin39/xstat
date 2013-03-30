package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.ISelectWeightInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.SelectWeightInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteWeightAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453855886740013266L;
	private static Log logger = LogFactory.getLog(DeleteWeightAction.class);
	private ISelectWeightInfoService selectWeightInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	private Long selectWeightID = null;

	
	@Override
	public String execute() throws Exception {	

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			if(selectWeightID == null)return ERROR;
			SelectWeightInfo info = selectWeightInfoService.getSelectWeightInfo(selectWeightID);
			info.setStatus(StatusConstants.SHANCHU);
			selectWeightInfoService.update(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}


	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}


	public Long getSelectWeightID() {
		return selectWeightID;
	}


	public void setSelectWeightID(Long selectWeightID) {
		this.selectWeightID = selectWeightID;
	}


	public void setSelectWeightInfoService(
			ISelectWeightInfoService selectWeightInfoService) {
		this.selectWeightInfoService = selectWeightInfoService;
	}

	
}
