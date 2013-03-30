package cn.iaicc.smgk.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IInquisitionInfoService;

import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.InquisitionInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteMakeExamAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8122202414454388824L;
	private static Log logger = LogFactory.getLog(DeleteMakeExamAction.class);
	private IInquisitionInfoService inquisitionInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	private Long inquisitionID = null;



	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			if(inquisitionID == null){
				return ERROR;
			}
			InquisitionInfo info = inquisitionInfoService.getInquisitionInfo(inquisitionID);
			info.setStatus(StatusConstants.SHANCHU);
			inquisitionInfoService.updateInquisitionInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}	

		return SUCCESS;
	}
	
	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}

}
