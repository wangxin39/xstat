package org.xsaas.xstat.web.action.backend.list;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListAuthAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5784001785491331445L;
	private static Log logger = LogFactory.getLog(ListAuthAction.class);
	private ISmgkInfoService smgkInfoService = null;
	
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			SmgkInfo smgkInfo = smgkInfoService.isLogin(username, password);
			if(smgkInfo == null) {
				return LOGIN;
			}	
			ActionContext.getContext().put("SMGKINFO",smgkInfo);
			if(smgkInfo.getAuthStatus() != null) {
				ActionContext.getContext().put("STATUS",StatusConstants.AuStatusDict.get(smgkInfo.getAuthStatus()));			
			}
			if(smgkInfo.getFileType() != null) {
				ActionContext.getContext().put("TYPE",QuestionTypeConstants.AuthTypeDict.get(smgkInfo.getFileType()));						
			}			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		
		
		return SUCCESS;
	}
	

	
	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}

}
