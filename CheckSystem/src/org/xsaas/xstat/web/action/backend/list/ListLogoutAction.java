package org.xsaas.xstat.web.action.backend.list;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListLogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5565591876389432864L;
	private static Log logger = LogFactory.getLog(ListLogoutAction.class);
	@Override
	public String execute() throws Exception {		
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}			
			
			boolean isLogout = true;
			if(isLogout) {
				return LOGIN;
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}

}
