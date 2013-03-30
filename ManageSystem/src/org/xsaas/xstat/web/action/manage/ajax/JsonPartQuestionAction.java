package org.xsaas.xstat.web.action.manage.ajax;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.xsaas.xstat.business.IPartQuestionInfoService;
import org.xsaas.xstat.business.IQuestionInfoService;
import org.xsaas.xstat.po.PartQuestionInfo;
import org.xsaas.xstat.po.QuestionInfo;

import com.opensymphony.xwork2.ActionSupport;

public class JsonPartQuestionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8914794879813209981L;
	private static Log logger = LogFactory.getLog(JsonPartQuestionAction.class);
	private IPartQuestionInfoService partQuestionInfoService = null;
	private IQuestionInfoService questionInfoService = null;
	
	
	private Long partQuestionID = null;
	
	private String question = null;
	
	@Override
	public String execute() throws Exception {
		try{
			if(partQuestionID != null) {
				PartQuestionInfo pqi = partQuestionInfoService.getPartQuestionInfo(partQuestionID);
				if(pqi != null && pqi.getQuestionID() != null) {
					QuestionInfo qi = questionInfoService.getQuestionInfo(pqi.getQuestionID());
					if(qi != null) {
						question = ""+qi.getQuestion();
					}
				}
			}	
		
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}

	public Long getPartQuestionID() {
		return partQuestionID;
	}

	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}


	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}

	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}

	public String getQuestion() {
		return question;
	}
}
