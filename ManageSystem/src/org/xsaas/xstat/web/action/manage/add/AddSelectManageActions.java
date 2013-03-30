package org.xsaas.xstat.web.action.manage.add;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.po.OptionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddSelectManageActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6769434775929025493L;
	private static Log logger = LogFactory.getLog(AddSelectManageActions.class);
	private IOptionInfoService optionInfoService = null;
	
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
			String isOK = (String)ActionContext.getContext().getSession().get("SELECTINPUTADDISOK");
			logger.debug("ISOK:"+isOK);
			if(isOK != null && "OK".equals(isOK)) {
				OptionInfo info = new OptionInfo();
				logger.debug("chinaOption:"+chinaOption+"|englishOption:"+englishOption);
				if(chinaOption != null) {
					info.setChinaOption(chinaOption);					
				}
				if(type != null) {
					info.setType(type);
				}
				if(englishOption != null) {
					info.setEnglishOption(englishOption);					
				}
				info.setStatus(StatusConstants.ZHENGCHANG);
				optionInfoService.save(info);
				ActionContext.getContext().getSession().put("SELECTINPUTADDISOK","NOT");
				
				ActionContext.getContext().getSession().put("ALTEROPTIOINFOLIST",null);
				ActionContext.getContext().getSession().put("VALUEOPTIOINFOLIST",null);
				
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
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
			ActionContext.getContext().getSession().put("SELECTINPUTADDISOK","OK");//防止刷新提交多次相同信息
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
			return ERROR;
		}
		return SUCCESS;
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
	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}
	public String getChinaOption() {
		return chinaOption;
	}
	public void setChinaOption(String chinaOption) {
		this.chinaOption = chinaOption;
	}


}
