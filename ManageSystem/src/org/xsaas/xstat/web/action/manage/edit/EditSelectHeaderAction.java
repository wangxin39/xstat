package org.xsaas.xstat.web.action.manage.edit;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInquisitionHeaderInfoService;
import org.xsaas.xstat.business.IInquisitionHeaderSelectInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.business.IQuestionInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InquisitionHeaderInfo;
import org.xsaas.xstat.po.InquisitionHeaderSelectInfo;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.OptionInfo;
import org.xsaas.xstat.po.QuestionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditSelectHeaderAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8122202414454388824L;
	private static Log logger = LogFactory.getLog(EditSelectHeaderAction.class);
	private IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IInquisitionHeaderInfoService inquisitionHeaderInfoService = null;
	private IQuestionInfoService questionInfoService = null;
	private IOptionInfoService optionInfoService = null;
	
	private Long inquisitionID = null;
	private Long headerID = null;
	private Long alterID = null;
	private Integer showOrder = null;
	private String fieldName = null;
	private String showNum = null;
	private Long optionID = null;
	
	private Long headerSelectID = null;
	
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			InquisitionHeaderSelectInfo info = (InquisitionHeaderSelectInfo) ActionContext.getContext().getSession().get("IHSEDIT");
			if(info != null) {
				InquisitionHeaderInfo ih = (InquisitionHeaderInfo) ActionContext.getContext().getSession().get("HEADERLIST");
				info.setInquisitionID(ih.getInquisitionID());
				if(alterID != null) {
					info.setAlterID(alterID);					
				}
				if(showOrder != null) {
					info.setShowOrder(showOrder);					
				}
				info.setFieldName("h"+showOrder+"s");
				info.setHeaderID(ih.getHeaderID());
				if(showNum != null) {
					info.setShowNum(showNum);					
				}
				if(optionID != null) {
					info.setOptionID(optionID);					
				}				
				inquisitionHeaderSelectInfoService.update(info);
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
			if(headerSelectID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			List<InquisitionInfo> iList = inquisitionInfoService.getInquisitionInfoList(); 
			List<QuestionInfo> qlList = questionInfoService.getQuestionInfoList();
			List<InquisitionHeaderInfo> headerList = inquisitionHeaderInfoService.getInquisitionHeaderInfoList(); 
			List<OptionInfo> alterList = optionInfoService.getList(1);
			List<OptionInfo> valueList = optionInfoService.getList(2);
			ActionContext.getContext().getSession().put("QUESTIONLIST",qlList);
			ActionContext.getContext().getSession().put("INQUISITIONLIST",iList);
			ActionContext.getContext().getSession().put("HEADERLIST",headerList);
			ActionContext.getContext().getSession().put("ALTERLIST",alterList);
			ActionContext.getContext().getSession().put("OPTIONLIST",valueList);			
			ActionContext.getContext().getSession().put("SELECTVALUE",QuestionTypeConstants.OptionValueDict);
			InquisitionHeaderSelectInfo info = inquisitionHeaderSelectInfoService.getInfo(headerSelectID);
			ActionContext.getContext().getSession().put("IHSEDIT",info);
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

	public Integer getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	public void setInquisitionHeaderSelectInfoService(
			IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService) {
		this.inquisitionHeaderSelectInfoService = inquisitionHeaderSelectInfoService;
	}

	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Long getHeaderID() {
		return headerID;
	}

	public void setHeaderID(Long headerID) {
		this.headerID = headerID;
	}
	public Long getHeaderSelectID() {
		return headerSelectID;
	}

	public void setHeaderSelectID(Long headerSelectID) {
		this.headerSelectID = headerSelectID;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}

	public void setInquisitionHeaderInfoService(
			IInquisitionHeaderInfoService inquisitionHeaderInfoService) {
		this.inquisitionHeaderInfoService = inquisitionHeaderInfoService;
	}

	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}

	public String getShowNum() {
		return showNum;
	}

	public void setShowNum(String showNum) {
		this.showNum = showNum;
	}

	public Long getOptionID() {
		return optionID;
	}

	public void setOptionID(Long optionID) {
		this.optionID = optionID;
	}

	public Long getAlterID() {
		return alterID;
	}

	public void setAlterID(Long alterID) {
		this.alterID = alterID;
	}

	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}
	
}
