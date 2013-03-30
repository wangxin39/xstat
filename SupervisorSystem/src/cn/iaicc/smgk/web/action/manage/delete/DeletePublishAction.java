package cn.iaicc.smgk.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IPublishInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.PublishInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePublishAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(DeletePublishAction.class);
	private IPublishInfoService publishInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	private Long publishID = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			PublishInfo info = publishInfoService.getPublishInfo(publishID);
			info.setStatus(StatusConstants.SHANCHU);
			publishInfoService.updatePublishInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}
	
	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public void setPublishInfoService(IPublishInfoService publishInfoService) {
		this.publishInfoService = publishInfoService;
	}

	public Long getPublishID() {
		return publishID;
	}

	public void setPublishID(Long publishID) {
		this.publishID = publishID;
	}

}
