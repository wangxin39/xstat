package org.xsaas.xstat.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IRemarkInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.RemarkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCritiqueAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453855886740013266L;
	private static Log logger = LogFactory.getLog(DeleteCritiqueAction.class);
	private IRemarkInfoService remarkInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	private Long remarkID = null;

	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if (remarkID == null) {
				return ERROR;
			}
			RemarkInfo info = remarkInfoService.getRemarkInfo(remarkID);
			info.setStatus(StatusConstants.SHANCHU);
			remarkInfoService.updateRemarkInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	public Long getRemarkID() {
		return remarkID;
	}

	public void setRemarkID(Long remarkID) {
		this.remarkID = remarkID;
	}

	public void setRemarkInfoService(IRemarkInfoService remarkInfoService) {
		this.remarkInfoService = remarkInfoService;
	}

	
}
