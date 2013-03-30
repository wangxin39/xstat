package org.xsaas.xstat.web.action.backend.list;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListTopAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7868366986298651708L;
	private static Log logger = LogFactory.getLog(ListTopAction.class);
	private ISmgkInfoService smgkInfoService = null;
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
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
