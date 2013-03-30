package cn.iaicc.smgk.web.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7868366986298651708L;
	private static Log logger = LogFactory.getLog(LoginAction.class);
	private IEmployeeInfoService employeeInfoService = null;
	
	private String loginName = null;
	private String passWord = null;
	private Boolean isRegister = false;
	private String authCode = null;
 	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		try{
			if(loginName == null || passWord == null) {
				this.addActionError("登录名称或密码为空！");
				return INPUT;
			}
			loginName = loginName.trim();
			passWord = passWord.trim();
			
			EmployeeInfo info = employeeInfoService.isLogin(loginName, passWord);
			if(info == null) {
				this.addActionError("找不到该用户信息！");
				return INPUT;
			}
			
			ActionContext.getContext().getSession().put("GLOBALEMPLOYEEID",info.getEmployeeID());		
			String code = (String) ActionContext.getContext().getSession().get("rand");
			
			if(!authCode.equals(code)){
				this.addActionError("您输入的验证码有误！请注意大小写匹配！");
				return INPUT;
			}		
			if(loginName.equals(""+info.getLoginName()) && passWord.equals(""+info.getPassWord())){
				ActionContext.getContext().getSession().put("LOGINUSERNAME",loginName);
				ActionContext.getContext().getSession().put("LOGINPASSWORD",passWord);	
			}else{
				this.addActionError("您输入的用户名或密码有误!请重新输入!");
				return INPUT;
			}						
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
			return INPUT;
		}

		return SUCCESS;
	}
	
	public String check() throws Exception {
		if(loginName != null) {
			isRegister = employeeInfoService.isRegister(loginName, passWord);
		}		
		return SUCCESS;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getLoginName() {
		return loginName;
	}

	public Boolean getIsRegister() {
		return isRegister;
	}

	public void setIsRegister(Boolean isRegister) {
		this.isRegister = isRegister;
	}


	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}


}
