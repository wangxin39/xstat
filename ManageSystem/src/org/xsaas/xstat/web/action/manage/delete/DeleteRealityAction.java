package org.xsaas.xstat.web.action.manage.delete;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IRealityCheckInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.RealityCheckInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteRealityAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453855886740013266L;
	private static Log logger = LogFactory.getLog(DeleteRealityAction.class);
	private IRealityCheckInfoService realityCheckInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	private Long realityCheckID = null;
	
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			if(realityCheckID == null){
				return ERROR;
			}
			RealityCheckInfo info = realityCheckInfoService.getRealityCheckInfo(realityCheckID);
			info.setStatus(StatusConstants.SHANCHU);
			realityCheckInfoService.updateRealityCheckInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public Long getRealityCheckID() {
		return realityCheckID;
	}

	public void setRealityCheckID(Long realityCheckID) {
		this.realityCheckID = realityCheckID;
	}

	public void setRealityCheckInfoService(
			IRealityCheckInfoService realityCheckInfoService) {
		this.realityCheckInfoService = realityCheckInfoService;
	}

}
