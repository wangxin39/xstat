package cn.iaicc.smgk.web.action.manage.add;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IClientInfoService;
import cn.iaicc.smgk.po.ClientInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddClientActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(AddClientActions.class);
	private IClientInfoService clientInfoService = null;
	private String company = null;
	private String enCompany = null;
	private String description = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}

			if(company == null)
			{
				this.addActionMessage("请输入客户名称");
				return INPUT;
			}
		
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");

			if(isOK != null && "OK".equals(isOK)) {//验证是不是在input过来的。
				ClientInfo info = new ClientInfo();
				if(company != null) {
					info.setCompany(company);					
				}
				if(enCompany != null) {
					info.setEnCompany(enCompany);					
				}
				if(description != null) {
					info.setDescription(description);					
				}
				info.setStatus(StatusConstants.ZHENGCHANG);
				clientInfoService.saveClientInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

	
		return SUCCESS;
	}
	// 增加输入界面
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}	

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setClientInfoService(
			IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getEnCompany() {
		return enCompany;
	}


	public void setEnCompany(String enCompany) {
		this.enCompany = enCompany;
	}

}
