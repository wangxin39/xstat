package org.xsaas.xstat.web.action.manage.edit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.po.OptionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditSelectManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6769434775929025493L;
	private static Log logger = LogFactory.getLog(EditSelectManageAction.class);
	private IOptionInfoService optionInfoService = null;
	private Long optionID = null;
	
	private Integer type = null;
	private String chinaOption = null;
	private String englishOption = null;	

	@SuppressWarnings("unchecked")
	public String execute()throws Exception{
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			OptionInfo info = (OptionInfo) ActionContext.getContext().getSession().get("SELECTEDIT");			
			if(info != null) {
				if(chinaOption != null) {
					info.setChinaOption(chinaOption);					
				}
				if(englishOption != null) {
					info.setEnglishOption(englishOption);
				}
				if(type != null) {
					info.setType(type);
				}
				optionInfoService.update(info);
				ActionContext.getContext().getSession().put("SELECTINPUTEDITISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
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
			if(optionID == null){
				this.addActionError("找不到要编辑的选项信息！");
				return ERROR;
			}
			OptionInfo optionInfo = optionInfoService.getOptionInfo(optionID);
			ActionContext.getContext().getSession().put("SELECTEDIT",optionInfo);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
			return ERROR;
		}		

		return SUCCESS;
	}	


	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}

	public Long getOptionID() {
		return optionID;
	}

	public void setOptionID(Long optionID) {
		this.optionID = optionID;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	public String getEnglishOption() {
		return englishOption;
	}

	public void setEnglishOption(String englishOption) {
		this.englishOption = englishOption;
	}

	public String getChinaOption() {
		return chinaOption;
	}

	public void setChinaOption(String chinaOption) {
		this.chinaOption = chinaOption;
	}
}
