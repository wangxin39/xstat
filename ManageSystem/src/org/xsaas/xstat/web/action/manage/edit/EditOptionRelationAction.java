package org.xsaas.xstat.web.action.manage.edit;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.business.IOptionRelationInfoService;
import org.xsaas.xstat.business.IOptionTemplateInfoService;
import org.xsaas.xstat.po.OptionInfo;
import org.xsaas.xstat.po.OptionRelationInfo;
import org.xsaas.xstat.po.OptionTemplateInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditOptionRelationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3841528902792855175L;
	private static Log logger = LogFactory.getLog(EditOptionRelationAction.class);
	private IOptionRelationInfoService optionRelationInfoService = null;
	private IOptionInfoService optionInfoService = null;
	private IOptionTemplateInfoService optionTemplateInfoService = null;
	
	private Long optionRelationID = null;
	
	private Long optionTemplateID = null;
	private String showNum = null;
	private String optionName = null;
	private Long alterID = null;
	private Long optionID = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			OptionRelationInfo info = (OptionRelationInfo)ActionContext.getContext().getSession().get("OPTIONRELATIONINFOEDIT");
			if(info != null) {
				logger.debug("optionTemplateID:"+optionTemplateID);
				if(optionTemplateID != null) {
					info.setOptionTemplateID(optionTemplateID);
				}
				if(optionName != null) {
					info.setOptionName(optionName);
				}
				if(alterID != null) {
					info.setAlterID(alterID);
				}
				if(optionID != null) {
					info.setOptionID(optionID);
				}			
				if(showNum != null) {
					info.setShowNum(showNum);				
				}			
				optionRelationInfoService.update(info);				
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
			if(optionRelationID == null) {
				this.addActionMessage("找不到要编辑的信息");
				return ERROR;
			}			
			OptionRelationInfo info = optionRelationInfoService.getOptionRelationInfo(optionRelationID);
			ActionContext.getContext().getSession().put("OPTIONRELATIONINFOEDIT", info);
			
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


	public Long getOptionRelationID() {
		return optionRelationID;
	}


	public void setOptionRelationID(Long optionRelationID) {
		this.optionRelationID = optionRelationID;
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


	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}


	public void setOptionTemplateInfoService(
			IOptionTemplateInfoService optionTemplateInfoService) {
		this.optionTemplateInfoService = optionTemplateInfoService;
	}


	public void setOptionRelationInfoService(
			IOptionRelationInfoService optionRelationInfoService) {
		this.optionRelationInfoService = optionRelationInfoService;
	}


	public Long getOptionTemplateID() {
		return optionTemplateID;
	}


	public void setOptionTemplateID(Long optionTemplateID) {
		this.optionTemplateID = optionTemplateID;
	}
}
