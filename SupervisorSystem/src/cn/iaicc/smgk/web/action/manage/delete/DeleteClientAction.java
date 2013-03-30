package cn.iaicc.smgk.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IClientInfoService;
import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.po.ClientInfo;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteClientAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(DeleteClientAction.class);
	private IEmployeeInfoService employeeInfoService = null;
	private IClientInfoService clientInfoService = null;
	private Long clientID = null;

	@Override
	public String execute() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		if(username == null || password == null) {
			return LOGIN;
		}
		try{
			if(clientID == null){
				return ERROR;
			}
			ClientInfo info = clientInfoService.getClientInfo(clientID);
			info.setStatus(StatusConstants.SHANCHU);
			clientInfoService.updateClientInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		return SUCCESS;
	}

	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public void setClientInfoService(
			IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}
}
