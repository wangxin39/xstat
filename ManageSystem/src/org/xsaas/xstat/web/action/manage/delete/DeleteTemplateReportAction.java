package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInquisitionTemplateInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InquisitionTemplateInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteTemplateReportAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6062925099474622735L;
	private static Log logger = LogFactory.getLog(DeleteTemplateReportAction.class);
	private IInquisitionTemplateInfoService inquisitionTemplateInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	private Long templateID = null;

	@Override
	public String execute() throws Exception {

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(templateID == null) return ERROR;
			InquisitionTemplateInfo info = inquisitionTemplateInfoService.getInquisitionTemplateInfo(templateID);
			info.setStatus(StatusConstants.SHANCHU);
			inquisitionTemplateInfoService.updateInquisitionTemplateInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public void setInquisitionTemplateInfoService(
			IInquisitionTemplateInfoService inquisitionTemplateInfoService) {
		this.inquisitionTemplateInfoService = inquisitionTemplateInfoService;
	}


	public Long getTemplateID() {
		return templateID;
	}

	public void setTemplateID(Long templateID) {
		this.templateID = templateID;
	}


}
