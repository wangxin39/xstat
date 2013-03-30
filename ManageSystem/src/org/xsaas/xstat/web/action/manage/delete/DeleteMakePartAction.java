package org.xsaas.xstat.web.action.manage.delete;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IPartInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.PartInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteMakePartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6466443869055598571L;
	private static Log logger = LogFactory.getLog(DeleteMakePartAction.class);
	private IPartInfoService partInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;


	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	private Long partID = null;

	public String execute()throws Exception{

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			if(partID == null){
				return ERROR;
			}
			PartInfo info = partInfoService.getPartInfo(partID);
			info.setStatus(StatusConstants.SHANCHU);
			partInfoService.updatePartInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	
	public void setPartInfoService(
			IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}

	public Long getPartID() {
		return partID;
	}

	public void setPartID(Long partID) {
		this.partID = partID;
	}

	
}
