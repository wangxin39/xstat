package cn.iaicc.smgk.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IStatQuestionInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.StatQuestionInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteGradeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453855886740013266L;
	private static Log logger = LogFactory.getLog(DeleteGradeAction.class);
	private IStatQuestionInfoService statQuestionInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	
	private Long statID = null;

	@Override
	public String execute() throws Exception {

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if (statID == null) {
				return ERROR;
			}
			StatQuestionInfo info = statQuestionInfoService.getStatQuestionInfo(statID);
			info.setStatus(StatusConstants.SHANCHU);
			statQuestionInfoService.updateStatQuestionInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
	
		return SUCCESS;
	}

	public Long getStatID() {
		return statID;
	}

	public void setStatID(Long statID) {
		this.statID = statID;
	}

	public void setStatQuestionInfoService(
			IStatQuestionInfoService statQuestionInfoService) {
		this.statQuestionInfoService = statQuestionInfoService;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

}
