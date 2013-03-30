package org.xsaas.xstat.web.action.backend.list;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListCheckAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8224630026292176949L;
	private static Log logger = LogFactory.getLog(ListCheckAction.class);
	private ISmgkInfoService smgkInfoService = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}		
			SmgkInfo info = smgkInfoService.isLogin(username, password);
			if(info == null) {
				ActionContext.getContext().put("typeError", "您输入的用户名或密码有误！请重新输入！");
				return LOGIN;
			}
		}catch(Exception e){
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}

}
