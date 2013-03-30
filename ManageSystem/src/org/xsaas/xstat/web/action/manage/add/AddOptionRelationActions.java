package org.xsaas.xstat.web.action.manage.add;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.business.IOptionRelationInfoService;
import org.xsaas.xstat.business.IOptionTemplateInfoService;
import org.xsaas.xstat.po.OptionInfo;
import org.xsaas.xstat.po.OptionRelationInfo;
import org.xsaas.xstat.po.OptionTemplateInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddOptionRelationActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8175616649592020791L;
	private static Log logger = LogFactory.getLog(AddOptionRelationActions.class);
	private IOptionRelationInfoService optionRelationInfoService = null;
	private IOptionTemplateInfoService optionTemplateInfoService = null;
	private IOptionInfoService optionInfoService = null;
	
	private Long optionTemplateID = null;
	private String showNum = null;
	private String optionName = null;
	private Long alterID = null;
	private Long optionID = null;
			
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			String isAddOK = (String)ActionContext.getContext().getSession().get("ISADDOK");
			if(isAddOK != null && "NO".equals(isAddOK)) {
				OptionRelationInfo info = new OptionRelationInfo();	
				logger.debug("optionTemplateID:"+optionTemplateID);
				if(optionTemplateID != null) {
					info.setOptionTemplateID(optionTemplateID);
				}
				if(optionName != null) {
					info.setOptionName(optionName);
				}
				if(alterID != null && alterID != -1) {
					info.setAlterID(alterID);
				}
				if(optionID != null && optionID != -1) {
					info.setOptionID(optionID);
				}			
				if(showNum != null) {
					info.setShowNum(showNum);				
				}
				info.setStatus(StatusConstants.ZHENGCHANG);
				optionRelationInfoService.save(info);
				
				ActionContext.getContext().getSession().put("ISADDOK", "YES");
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
			
			List<OptionTemplateInfo> optionTemplateInfoList = (List<OptionTemplateInfo>)ActionContext.getContext().getSession().get("OPTIONTEMPLATEINFOLIST");
			if(optionTemplateInfoList == null) {
				optionTemplateInfoList = optionTemplateInfoService.getList(0, Integer.MAX_VALUE);	
				ActionContext.getContext().getSession().put("OPTIONTEMPLATEINFOLIST",optionTemplateInfoList);							
			}	
			
			List<OptionInfo> optionInfoList = (List<OptionInfo>)ActionContext.getContext().getSession().get("ALTEROPTIOINFOLIST");
			if(optionInfoList == null) {
				optionInfoList = optionInfoService.getList(1);
				OptionInfo oi = new OptionInfo();
				oi.setOptionID(new Long(-1));
				oi.setChinaOption(" ");
				optionInfoList.add(oi);
				ActionContext.getContext().getSession().put("ALTEROPTIOINFOLIST",optionInfoList);
			}
			optionInfoList = (List<OptionInfo>)ActionContext.getContext().getSession().get("VALUEOPTIOINFOLIST");
			if(optionInfoList == null) {
				optionInfoList = optionInfoService.getList(2);
				OptionInfo oi = new OptionInfo();
				oi.setOptionID(new Long(-1));
				oi.setChinaOption(" ");
				optionInfoList.add(oi);
				ActionContext.getContext().getSession().put("VALUEOPTIOINFOLIST",optionInfoList);
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}
	public String getShowNum() {
		return showNum;
	}


	public void setShowNum(String showNum) {
		this.showNum = showNum;
	}


	public String getOptionName() {
		return optionName;
	}


	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}


	public Long getAlterID() {
		return alterID;
	}


	public void setAlterID(Long alterID) {
		this.alterID = alterID;
	}


	public Long getOptionID() {
		return optionID;
	}


	public void setOptionID(Long optionID) {
		this.optionID = optionID;
	}


	public void setOptionRelationInfoService(
			IOptionRelationInfoService optionRelationInfoService) {
		this.optionRelationInfoService = optionRelationInfoService;
	}


	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}


	public void setOptionTemplateInfoService(
			IOptionTemplateInfoService optionTemplateInfoService) {
		this.optionTemplateInfoService = optionTemplateInfoService;
	}


	public Long getOptionTemplateID() {
		return optionTemplateID;
	}


	public void setOptionTemplateID(Long optionTemplateID) {
		this.optionTemplateID = optionTemplateID;
	}
}
