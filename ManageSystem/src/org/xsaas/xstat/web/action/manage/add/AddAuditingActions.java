package org.xsaas.xstat.web.action.manage.add;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddAuditingActions extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3504532266474847319L;
	private static Log logger = LogFactory.getLog(AddAuditingActions.class);
	
	public String input() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}
}
