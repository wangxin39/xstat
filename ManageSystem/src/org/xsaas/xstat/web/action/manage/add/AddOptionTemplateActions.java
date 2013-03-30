package org.xsaas.xstat.web.action.manage.add;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IOptionTemplateInfoService;
import org.xsaas.xstat.po.OptionTemplateInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddOptionTemplateActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2738608278284742451L;	
	private static Log logger = LogFactory.getLog(AddOptionTemplateActions.class);
	
	private IOptionTemplateInfoService optionTemplateInfoService = null;
	
	private String title = null;
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
			String isOK = (String)ActionContext.getContext().getSession().get("ISADDOK");
			if(isOK != null && "NO".equals(isOK)) {
				OptionTemplateInfo info = new OptionTemplateInfo();
				if(title != null) {
					info.setTitle(title);				
				}
				if(description != null) {
					info.setDescription(description);
				}
				info.setStatus(StatusConstants.ZHENGCHANG);
				optionTemplateInfoService.save(info);
				ActionContext.getContext().getSession().put("ISADDOK", "YES");
				
				ActionContext.getContext().getSession().put("OPTIONTEMPLATEINFOLIST", null);
				
			}

			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}
	
	
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			ActionContext.getContext().getSession().put("ISADDOK", "NO");
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setOptionTemplateInfoService(
			IOptionTemplateInfoService optionTemplateInfoService) {
		this.optionTemplateInfoService = optionTemplateInfoService;
	}
}
