package cn.iaicc.smgk.web.action.manage.add;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IClientInfoService;
import cn.iaicc.smgk.business.IInformantInfoService;
import cn.iaicc.smgk.business.IInquisitionHeaderInfoService;
import cn.iaicc.smgk.business.IInquisitionInfoService;
import cn.iaicc.smgk.business.IQuestionInfoService;
import cn.iaicc.smgk.po.ClientInfo;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.po.InquisitionHeaderInfo;
import cn.iaicc.smgk.po.InquisitionInfo;
import cn.iaicc.smgk.po.QuestionInfo;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;

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
	private IClientInfoService clientInfoService = null;
	private IInformantInfoService informantInfoService = null;


	
	private Long inquisitionID = null;
	private Long questionID = null;
	private Integer showOrder = null;
	private String fieldName = null;
	private Integer isInput = null;
	private Integer selectType = null;
	private Long optionTemplateID = null;

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				if(inquisitionID == null){
					this.addActionMessage("调查问卷不能为空,请先添调查问卷!");
					return INPUT;
				}
				if(questionID == null){
					this.addActionMessage("问题不能为空,请先添加问题信息!");
					return INPUT;
				}
				InquisitionHeaderInfo info = new InquisitionHeaderInfo();
				info.setInquisitionID(inquisitionID);
				info.setIsinput(isInput);
				info.setShowOrder(showOrder);
				info.setFieldName("h"+showOrder+"s");
				if(questionID != null) {
					QuestionInfo qi = questionInfoService.getQuestionInfo(questionID);
					if(qi != null) {
						info.setQuestionID(questionID);		
						info.setQuestionType(qi.getQuestionType());						
					}
				}
				if(selectType != null) {
					info.setSelectType(selectType);				
				}
				info.setStatus(StatusConstants.ZHENGCHANG);
				inquisitionHeaderInfoService.saveInquisitionHeaderInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
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
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);
			}
			List<InformantInfo> informantInfoList = (List<InformantInfo>)ActionContext.getContext().getSession().get("");
			if(informantInfoList == null) {				
				informantInfoList = informantInfoService.getInformantInfoList();
				ActionContext.getContext().getSession().put("GLOBALINFORMANTLIST",informantInfoList);				
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

	public Long getInquisitionID() {
		return inquisitionID;
	}
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}


	public Long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}

	public Integer getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	public void setInquisitionHeaderInfoService(
			IInquisitionHeaderInfoService inquisitionHeaderInfoService) {
		this.inquisitionHeaderInfoService = inquisitionHeaderInfoService;
	}

	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Integer getIsInput() {
		return isInput;
	}
	public void setIsInput(Integer isInput) {
		this.isInput = isInput;
	}
	public Integer getSelectType() {
		return selectType;
	}

	public void setSelectType(Integer selectType) {
		this.selectType = selectType;
	}
	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}
	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}
	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}
	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}
	public Long getOptionTemplateID() {
		return optionTemplateID;
	}
	public void setOptionTemplateID(Long optionTemplateID) {
		this.optionTemplateID = optionTemplateID;
	}

}
