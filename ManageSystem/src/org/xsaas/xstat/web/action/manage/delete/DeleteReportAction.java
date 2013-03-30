package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IReportInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.ReportInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteReportAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127570233615470183L;
	private static Log logger = LogFactory.getLog(DeleteReportAction.class);
	private IReportInfoService reportInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}


	private Long reportID = null;

	@Override
	public String execute() throws Exception {	

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			ReportInfo info = reportInfoService.getReportInfo(reportID);
			info.setStatus(StatusConstants.SHANCHU);
			reportInfoService.updateReportInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}


	public void setReportInfoService(
			IReportInfoService reportInfoService) {
		this.reportInfoService = reportInfoService;
	}


	public Long getReportID() {
		return reportID;
	}


	public void setReportID(Long reportID) {
		this.reportID = reportID;
	}


}
