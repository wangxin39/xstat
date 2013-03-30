package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IProjectInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.ProjectInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteProjectAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4749480355407371401L;
	private static Log logger = LogFactory.getLog(DeleteProjectAction.class);
	private IEmployeeInfoService employeeInfoService = null;
	private IProjectInfoService projectInfoService = null;
	private Long projectID = null;

	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			if(projectID == null) return ERROR;
			ProjectInfo info = projectInfoService.getProjectInfo(projectID);
			info.setStatus(StatusConstants.SHANCHU);
			projectInfoService.updateProjectInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}

	public Long getProjectID() {
		return projectID;
	}

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	public void setProjectInfoService(
			IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

}
