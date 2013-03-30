package cn.iaicc.smgk.web.action.manage.edit;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IInquisitionHeaderInfoService;
import cn.iaicc.smgk.business.IInquisitionInfoService;
import cn.iaicc.smgk.business.IQuestionInfoService;
import cn.iaicc.smgk.po.InquisitionHeaderInfo;
import cn.iaicc.smgk.po.InquisitionInfo;
import cn.iaicc.smgk.po.QuestionInfo;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditHeaderAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8122202414454388824L;
	private static Log logger = LogFactory.getLog(EditHeaderAction.class);
	private IInquisitionHeaderInfoService inquisitionHeaderInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IQuestionInfoService questionInfoService = null;

	private Long questionID = null;
	private Integer showOrder = null;
	private Integer isInput = null;
	private Long inquisitionID = null;
	private String fieldName = null;
	private Integer selectType = null;
	private Long optionTemplateID = null;
	
	private Long headerID = null;
	
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}

			InquisitionHeaderInfo info = (InquisitionHeaderInfo) ActionContext.getContext().getSession().get("HEADEREDIT");
			if(info != null) {
				if(inquisitionID != null) {
					info.setInquisitionID(inquisitionID);					
				}
				if(isInput != null) {
					info.setIsinput(isInput);					
				}
				if(showOrder != null) {
					info.setShowOrder(showOrder);
					info.setFieldName("h"+showOrder+"s");					
				}
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
				if(optionTemplateID != null) {
					info.setOptionTemplateID(optionTemplateID);
				}
				inquisitionHeaderInfoService.updateInquisitionHeaderInfo(info);
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		

		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}		
			if(headerID == null) return ERROR;
			List<InquisitionInfo> iList = inquisitionInfoService.getInquisitionInfoList(); 
			
			InquisitionHeaderInfo info = inquisitionHeaderInfoService.getInquisitionHeaderInfo(headerID);
			ActionContext.getContext().getSession().put("HEADEREDIT",info);
		
			if(info.getQuestionID()!= null) {
				QuestionInfo qInfo = questionInfoService.getQuestionInfo(info.getQuestionID());
				ActionContext.getContext().getSession().put("QUESTIONLI",qInfo.getQuestion());			
			}

			ActionContext.getContext().getSession().put("INQUISITIONLIST",iList);
			ActionContext.getContext().getSession().put("TYPELIST",QuestionTypeConstants.QuestionTypeDict);
			ActionContext.getContext().getSession().put("ISINPUTLIST",QuestionTypeConstants.IsinputTypeDict);
			ActionContext.getContext().getSession().put("SELECTLIST",QuestionTypeConstants.SelectDict);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		
		return SUCCESS;
	}			
	public Integer getSelectType() {
		return selectType;
	}

	public void setSelectType(Integer selectType) {
		this.selectType = selectType;
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
	public Long getHeaderID() {
		return headerID;
	}
	public void setHeaderID(Long headerID) {
		this.headerID = headerID;
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
}