package cn.iaicc.smgk.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.ISmgkInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.SmgkInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCustomerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(DeleteCustomerAction.class);
	private ISmgkInfoService smgkInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	private Long smgkID = null;

	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}			
			if(smgkID == null){
				this.addActionError("找不到该神秘客！");
				return ERROR;
			}
			SmgkInfo info = smgkInfoService.getSmgkInfo(smgkID);
			info.setStatus(StatusConstants.SHANCHU);
			smgkInfoService.updateSmgkInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public Long getSmgkID() {
		return smgkID;
	}

	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
	}

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}


}
