package org.xsaas.xstat.web.action.manage.list;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListAuditingAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5896476815373061783L;
	private static Log logger = LogFactory.getLog(ListAuditingAction.class);
		
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
