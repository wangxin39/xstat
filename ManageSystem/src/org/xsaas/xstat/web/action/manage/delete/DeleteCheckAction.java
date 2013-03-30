package org.xsaas.xstat.web.action.manage.delete;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.ICheckDetailInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.po.CheckDetailInfo;
import org.xsaas.xstat.po.EmployeeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCheckAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453855886740013266L;
	private static Log logger = LogFactory.getLog(DeleteCheckAction.class);
	private ICheckDetailInfoService checkDetailInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;


	private Long checkDetailID = null;
	
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(checkDetailID == null){
				return ERROR;
			}
			CheckDetailInfo info = checkDetailInfoService.getCheckDetailInfo(checkDetailID);
			info.setStatus(StatusConstants.SHANCHU);
			checkDetailInfoService.updateCheckDetailInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
	
		return SUCCESS;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public Long getCheckDetailID() {
		return checkDetailID;
	}

	public void setCheckDetailID(Long checkDetailID) {
		this.checkDetailID = checkDetailID;
	}

	public void setCheckDetailInfoService(
			ICheckDetailInfoService checkDetailInfoService) {
		this.checkDetailInfoService = checkDetailInfoService;
	}

}
