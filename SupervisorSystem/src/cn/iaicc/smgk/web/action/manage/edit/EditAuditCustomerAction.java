package cn.iaicc.smgk.web.action.manage.edit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.ISmgkInfoService;
import cn.iaicc.smgk.po.SmgkInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditAuditCustomerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8822918904716156808L;
	private static Log logger = LogFactory.getLog(EditAuditCustomerAction.class);
	private ISmgkInfoService smgkInfoService = null;
	
	private Long smgkID = null;

	public String audit() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	

			if(username == null || password == null) {
				return LOGIN;
			}

			if(smgkID == null) {
				this.addActionError("编号为空！");
				return ERROR;
			}
			
			SmgkInfo info = smgkInfoService.getSmgkInfo(smgkID);
			if(info !=null ){
				info.setAuthStatus(StatusConstants.YANZHENGCHENGGONG);
				smgkInfoService.updateSmgkInfo(info);
			}	
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
			this.addActionError(""+e.getMessage());
			return ERROR;
		}
		return SUCCESS;
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
