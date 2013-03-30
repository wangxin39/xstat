package org.xsaas.xstat.web.action.manage.edit;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IOptionTemplateInfoService;
import org.xsaas.xstat.business.IPartInfoService;
import org.xsaas.xstat.business.IPartQuestionInfoService;
import org.xsaas.xstat.business.IQuestionInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.OptionTemplateInfo;
import org.xsaas.xstat.po.PartInfo;
import org.xsaas.xstat.po.PartQuestionInfo;
import org.xsaas.xstat.po.QuestionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditPartQuestionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8214185261887712162L;
	private static Log logger = LogFactory.getLog(EditPartQuestionAction.class);
	private IPartQuestionInfoService partQuestionInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;
	private IQuestionInfoService questionInfoService = null;
	private IPartInfoService partInfoService = null;
	private IOptionTemplateInfoService optionTemplateInfoService = null;
	
	private Long questionID = null;
	private Integer showNum = null;
	private Long fatherPqID = null;
	private Integer selectType = null;
	private Long optionTemplateID = null;
	
	private Long partQuestionID = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			PartQuestionInfo info = (PartQuestionInfo) ActionContext.getContext().getSession().get("PARTQUESTIONINFOEDIT");
			logger.debug("partQuestionInfo:"+info);
			if(info != null) {
				if(fatherPqID != null) {
					info.setFatherPqID(fatherPqID);					
				}

				Long partID = (Long)ActionContext.getContext().getSession().get("SELECTPARTID");
				if(partID != null && partID != info.getPartID()) {
					PartInfo pi = partInfoService.getPartInfo(partID);
					if(pi != null) {
						info.setPartID(partID);						
						info.setInquisitionID(pi.getInquisitionID());						
					}
				}				
				logger.debug("questionID:"+questionID);
				if(questionID != null) {
					QuestionInfo qi = questionInfoService.getQuestionInfo(questionID);
					if(qi != null) {
						info.setQuestionID(qi.getQuestionID());			
						info.setQuestionType(qi.getQuestionType());
					}
				}
				if(selectType != null) {
					info.setSelectType(selectType);
					if(optionTemplateID != null && optionTemplateID != -1 && selectType == 1) {
						info.setOptionTemplateID(optionTemplateID);
					}
				}				
				if(showNum != null) {
					if(info.getQuestionType() != null && info.getQuestionType() <= 4) {
						info.setFieldName("h"+showNum+"s");											
					}else{
						info.setFieldName("h"+showNum+"");											
					}
					info.setShowNum(showNum);
				}			
				partQuestionInfoService.updatePartQuestionInfo(info);
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
			if(partQuestionID == null) {
				this.addActionError("非法操作!找不到要操作的数据!");
				return ERROR;
			}
			PartQuestionInfo info = partQuestionInfoService.getPartQuestionInfo(partQuestionID);
			if(info == null) {
				this.addActionError("找不到你要管理的部分问题！");
				return ERROR;
			}
			ActionContext.getContext().getSession().put("PARTQUESTIONINFOEDIT", info);
			if(info.getPartID() == null) {
				this.addActionError("非法操作，找不到要操作的部分！");
				return ERROR;
			}
			if(info.getFatherPqID() != null) {
				PartQuestionInfo fatherInfo = partQuestionInfoService.getPartQuestionInfo(info.getFatherPqID());
				java.util.Map<Long,String> fqMap = new java.util.HashMap<Long, String>();
				if(fatherInfo != null && fatherInfo.getQuestionID() != null) { 
					QuestionInfo qi = questionInfoService.getQuestionInfo(fatherInfo.getQuestionID());
					if(qi != null) {
						fqMap.put(partQuestionID, ""+qi.getQuestion());						
					}
				}
				ActionContext.getContext().put("FATHERINFOMAP", fqMap);
			}			
			PartInfo pi = partInfoService.getPartInfo(info.getPartID());
			if(pi != null) {
				ActionContext.getContext().getSession().put("PARTNAME", ""+pi.getName());							
			}
			if(info.getQuestionID() != null && info.getQuestionID() != -1) {
				QuestionInfo qInfo = questionInfoService.getQuestionInfo(info.getQuestionID());
				ActionContext.getContext().getSession().put("EDITQUESTIONNAME",qInfo.getQuestion());
				ActionContext.getContext().getSession().put("EDITQUESTIONVALUE",info.getQuestionID());				
			}else{
				ActionContext.getContext().getSession().put("EDITQUESTIONNAME","请选择问题");
				ActionContext.getContext().getSession().put("EDITQUESTIONVALUE","-1");								
			}
			ActionContext.getContext().getSession().put("VALIDATIONSELECT",QuestionTypeConstants.ValidationDict);

			List<OptionTemplateInfo> optionTemplateInfoList = (List<OptionTemplateInfo>)ActionContext.getContext().getSession().get("OPTIONTEMPLATEINFOLIST");
			if(optionTemplateInfoList == null) {
				optionTemplateInfoList = optionTemplateInfoService.getList(0, Integer.MAX_VALUE);	
				ActionContext.getContext().getSession().put("OPTIONTEMPLATEINFOLIST",optionTemplateInfoList);							
			}		
		
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		

		return SUCCESS;
	}	
	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public Long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}

	public Integer getShowNum() {
		return showNum;
	}

	public void setShowNum(Integer showNum) {
		this.showNum = showNum;
	}


	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}

	public Long getFatherPqID() {
		return fatherPqID;
	}

	public void setFatherPqID(Long fatherPqID) {
		this.fatherPqID = fatherPqID;
	}

	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}

	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}
	public Long getPartQuestionID() {
		return partQuestionID;
	}
	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}
	public Integer getSelectType() {
		return selectType;
	}
	public void setSelectType(Integer selectType) {
		this.selectType = selectType;
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
