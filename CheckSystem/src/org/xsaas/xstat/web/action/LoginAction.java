package org.xsaas.xstat.web.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7868366986298651708L;
	private static Log logger = LogFactory.getLog(LoginAction.class);
	private ISmgkInfoService smgkInfoService = null;
	
	private String username = null;
	private String password = null;
	private String authCode = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		try{
			if(username == null || password == null || authCode == null) {
				this.addActionMessage("请输入用户名称和密码及验证码！");
				return LOGIN;
			}
			username = username.trim();
			password = password.trim();
			String code = (String) ActionContext.getContext().getSession().get("rand");
			
			if(!authCode.equals(""+code)){
				this.addActionMessage("您输入的验证码有误！请注意大小写匹配！");
				return LOGIN;
			}
		
			SmgkInfo info = smgkInfoService.isLogin(username, password);
			if(info == null) {
				this.addActionMessage("您输入的用户名或密码有误！请重新输入！");
				return LOGIN;
			}
			if(info.getRegStatus() != null && info.getRegStatus() == StatusConstants.YANZHENGYITONGGUO){
				ActionContext.getContext().getSession().put("LOGINID",info.getSmgkID());
				ActionContext.getContext().getSession().put("LOGINUSERNAME",username);
				ActionContext.getContext().getSession().put("LOGINPASSWORD",password);	
			}else{
				this.addActionMessage("你的帐号暂时没有审核，请稍后登陆！");
				ActionContext.getContext().getSession().put("LOGINID",null);
				ActionContext.getContext().getSession().put("LOGINUSERNAME",null);
				ActionContext.getContext().getSession().put("LOGINPASSWORD",null);		
				return LOGIN;
			}		
			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
			return LOGIN;
		}
		logger.debug("登陆成功|username:"+username);
		return SUCCESS;
	}
	
	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}


}
