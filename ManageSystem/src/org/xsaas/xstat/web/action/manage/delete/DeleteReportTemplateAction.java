package org.xsaas.xstat.web.action.manage.delete;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IReportTemplateInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.ReportTemplateInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteReportTemplateAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127570233615470183L;
	private static Log logger = LogFactory.getLog(DeleteReportTemplateAction.class);
	private IReportTemplateInfoService reportTemplateInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	private Long reportTemplateID = null;

	@Override
	public String execute() throws Exception {	

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			ReportTemplateInfo info = reportTemplateInfoService.getReportTemplateInfo(reportTemplateID);
			info.setStatus(StatusConstants.SHANCHU);
			reportTemplateInfoService.updateReportTemplateInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public Long getReportTemplateID() {
		return reportTemplateID;
	}

	public void setReportTemplateID(Long reportTemplateID) {
		this.reportTemplateID = reportTemplateID;
	}

	public void setReportTemplateInfoService(
			IReportTemplateInfoService reportTemplateInfoService) {
		this.reportTemplateInfoService = reportTemplateInfoService;
	}


}
