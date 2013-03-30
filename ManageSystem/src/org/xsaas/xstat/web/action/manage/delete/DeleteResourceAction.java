package org.xsaas.xstat.web.action.manage.delete;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IResourceInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.ResourceInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteResourceAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6466443869055598571L;
	private static Log logger = LogFactory.getLog(DeleteResourceAction.class);
	private IResourceInfoService resourceInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	private Long resourceID = null;
	
	public String execute()throws Exception{

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(resourceID == null){
				return ERROR;
			}
			ResourceInfo info = resourceInfoService.getResourceInfo(resourceID);
			info.setStatus(StatusConstants.SHANCHU);
			resourceInfoService.update(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	public Long getResourceID() {
		return resourceID;
	}

	public void setResourceID(Long resourceID) {
		this.resourceID = resourceID;
	}

	public void setResourceInfoService(IResourceInfoService resourceInfoService) {
		this.resourceInfoService = resourceInfoService;
	}


}
