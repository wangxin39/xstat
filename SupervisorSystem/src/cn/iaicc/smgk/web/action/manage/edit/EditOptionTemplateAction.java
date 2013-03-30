package cn.iaicc.smgk.web.action.manage.edit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IOptionTemplateInfoService;
import cn.iaicc.smgk.po.OptionTemplateInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditOptionTemplateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8529721120212040702L;
	private static Log logger = LogFactory.getLog(EditOptionTemplateAction.class);
	
	private IOptionTemplateInfoService optionTemplateInfoService = null;
	
	private String title = null;
	private String description = null;
	
	private Long optionTemplateID = null;
	
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			OptionTemplateInfo info = (OptionTemplateInfo)ActionContext.getContext().getSession().get("OPTIONTEMPLATEINFOEDIT");
			if(info != null) {
				
				if(title != null) {
					info.setTitle(title);					
				}
				if(description != null) {
					info.setDescription(description);
				}
				optionTemplateInfoService.update(info);
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}
	
	
	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			if(optionTemplateID == null) {
				this.addActionMessage("找不到要编辑的信息！");
				return ERROR;
			}
			OptionTemplateInfo info = optionTemplateInfoService.getOptionTemplateInfo(optionTemplateID);
			ActionContext.getContext().getSession().put("OPTIONTEMPLATEINFOEDIT", info);
			
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


	public Long getOptionTemplateID() {
		return optionTemplateID;
	}


	public void setOptionTemplateID(Long optionTemplateID) {
		this.optionTemplateID = optionTemplateID;
	}


	public void setOptionTemplateInfoService(
			IOptionTemplateInfoService optionTemplateInfoService) {
		this.optionTemplateInfoService = optionTemplateInfoService;
	}

}
