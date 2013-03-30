package cn.iaicc.smgk.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IQuestionInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.QuestionInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteQuestionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2619921652887202507L;
	private static Log logger = LogFactory.getLog(DeleteQuestionAction.class);
	private IQuestionInfoService questionInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;


	private Long questionID = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}

			if(questionID == null){
				return ERROR;
			}
			QuestionInfo info = questionInfoService.getQuestionInfo(questionID);
			if(info != null) {
				info.setStatus(StatusConstants.SHANCHU);
				questionInfoService.update(info);				
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public Long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}

	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}



}
