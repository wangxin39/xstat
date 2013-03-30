package org.xsaas.xstat.web.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7868366986298651708L;
	private static Log logger = LogFactory.getLog(LogoutAction.class);
	
	@Override
	public String execute() throws Exception {
		ActionContext.getContext().getSession().clear();
		logger.debug("退出系统");
		return SUCCESS;
	}

}
