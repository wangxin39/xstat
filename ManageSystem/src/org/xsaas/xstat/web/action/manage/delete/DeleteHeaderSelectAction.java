package org.xsaas.xstat.web.action.manage.delete;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInquisitionHeaderSelectInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InquisitionHeaderSelectInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteHeaderSelectAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8122202414454388824L;
	private static Log logger = LogFactory.getLog(DeleteHeaderSelectAction.class);
	private IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	private Long headerSelectID = null;


	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			InquisitionHeaderSelectInfo info = inquisitionHeaderSelectInfoService.getInfo(headerSelectID);
			info.setStatus(StatusConstants.SHANCHU);
			inquisitionHeaderSelectInfoService.update(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	
	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}


	public Long getHeaderSelectID() {
		return headerSelectID;
	}


	public void setHeaderSelectID(Long headerSelectID) {
		this.headerSelectID = headerSelectID;
	}


	public void setInquisitionHeaderSelectInfoService(
			IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService) {
		this.inquisitionHeaderSelectInfoService = inquisitionHeaderSelectInfoService;
	}

}
