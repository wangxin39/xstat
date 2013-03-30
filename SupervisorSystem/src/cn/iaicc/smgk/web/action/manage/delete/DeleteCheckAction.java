package cn.iaicc.smgk.web.action.manage.delete;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.ICheckDetailInfoService;
import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.po.CheckDetailInfo;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCheckAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453855886740013266L;
	private static Log logger = LogFactory.getLog(DeleteCheckAction.class);
	private ICheckDetailInfoService checkDetailInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;


	private Long checkDetailID = null;
	
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(checkDetailID == null){
				return ERROR;
			}
			CheckDetailInfo info = checkDetailInfoService.getCheckDetailInfo(checkDetailID);
			info.setStatus(StatusConstants.SHANCHU);
			checkDetailInfoService.updateCheckDetailInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
	
		return SUCCESS;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public Long getCheckDetailID() {
		return checkDetailID;
	}

	public void setCheckDetailID(Long checkDetailID) {
		this.checkDetailID = checkDetailID;
	}

	public void setCheckDetailInfoService(
			ICheckDetailInfoService checkDetailInfoService) {
		this.checkDetailInfoService = checkDetailInfoService;
	}

}
