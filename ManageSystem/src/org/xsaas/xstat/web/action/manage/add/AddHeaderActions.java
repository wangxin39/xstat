package org.xsaas.xstat.web.action.manage.add;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IInquisitionHeaderInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IOptionTemplateInfoService;
import org.xsaas.xstat.business.IQuestionInfoService;
import org.xsaas.xstat.po.InquisitionHeaderInfo;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.OptionTemplateInfo;
import org.xsaas.xstat.po.QuestionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddHeaderActions extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8122202414454388824L;
	private static Log logger = LogFactory.getLog(AddHeaderActions.class);
	private IInquisitionHeaderInfoService inquisitionHeaderInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IQuestionInfoService questionInfoService = null;
	private IOptionTemplateInfoService optionTemplateInfoService = null;
	
	private Integer isInput = null;
	private Long optionTemplateID = null;

	private String arrQuestionID = null;
	
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			int showOrder = 1;
//			logger.debug("arrQuestionID:"+arrQuestionID);
			InquisitionHeaderInfo info = null;
			Long questionID = null;
			Long inquisitionID = (Long)ActionContext.getContext().getSession().get("GLOBALINQUISITIONID");				
			if(arrQuestionID != null && inquisitionID != null) {
				String[] arrs = arrQuestionID.trim().split(" ");
				for(String str:arrs) {					
					if(str != null) {
						info = new InquisitionHeaderInfo();
						info.setInquisitionID(inquisitionID);
						info.setIsinput(isInput);
						showOrder = inquisitionHeaderInfoService.getNewShowOrder(inquisitionID);
						info.setShowOrder(showOrder);
						questionID = Long.parseLong(str);
						if(questionID != null) {
							QuestionInfo qi = questionInfoService.getQuestionInfo(questionID);
							if(qi != null) {
								info.setQuestionID(questionID);		
								info.setQuestionType(qi.getQuestionType());
								if(qi.getQuestionType() <= 4) {
									info.setFieldName("h"+showOrder+"s");
									if(optionTemplateID != null && optionTemplateID != -1) {
										info.setSelectType(1);
										info.setOptionTemplateID(optionTemplateID);
									}else{
										info.setSelectType(2); //表头选项
									}
								}else{
									info.setFieldName("h"+showOrder+"");									
								}
							}
						}
						info.setStatus(StatusConstants.ZHENGCHANG);
						inquisitionHeaderInfoService.saveInquisitionHeaderInfo(info);							
					}
				}
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
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			List<OptionTemplateInfo> optionTemplateInfoList = (List<OptionTemplateInfo>)ActionContext.getContext().getSession().get("OPTIONTEMPLATEINFOLIST");
			if(optionTemplateInfoList == null) {
				optionTemplateInfoList = optionTemplateInfoService.getList(0, Integer.MAX_VALUE);	
				ActionContext.getContext().getSession().put("OPTIONTEMPLATEINFOLIST",optionTemplateInfoList);							
			}			
			List<InquisitionInfo> inquisitionInfoList = (List<InquisitionInfo>)ActionContext.getContext().getSession().get("GLOBALINQUISITIONLIST");
			if(inquisitionInfoList == null) {				
				inquisitionInfoList = inquisitionInfoService.getInquisitionInfoList();
				ActionContext.getContext().getSession().put("GLOBALINQUISITIONLIST",inquisitionInfoList);				
			}

			List<QuestionInfo> questionInfoList = (List<QuestionInfo>)ActionContext.getContext().getSession().get("GLOBALQUESTIONLIST");
			if(questionInfoList == null) {
				questionInfoList = questionInfoService.getQuestionInfoList();
				ActionContext.getContext().getSession().put("GLOBALQUESTIONLIST",questionInfoList);				
			}
		
			ActionContext.getContext().getSession().put("ISINPUTLIST",QuestionTypeConstants.IsinputTypeDict);
			ActionContext.getContext().getSession().put("TYPELIST",QuestionTypeConstants.QuestionTypeDict);
			ActionContext.getContext().getSession().put("SELECTLIST",QuestionTypeConstants.SelectDict);
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
	
	
		return SUCCESS;
	}
	public void setInquisitionHeaderInfoService(
			IInquisitionHeaderInfoService inquisitionHeaderInfoService) {
		this.inquisitionHeaderInfoService = inquisitionHeaderInfoService;
	}

	public Integer getIsInput() {
		return isInput;
	}
	public void setIsInput(Integer isInput) {
		this.isInput = isInput;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}
	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
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
	public void setArrQuestionID(String arrQuestionID) {
		this.arrQuestionID = arrQuestionID;
	}

}
