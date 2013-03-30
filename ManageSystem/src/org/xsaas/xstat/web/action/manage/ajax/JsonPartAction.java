package org.xsaas.xstat.web.action.manage.ajax;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.xsaas.xstat.business.IPartQuestionInfoService;
import org.xsaas.xstat.business.IQuestionInfoService;

import com.opensymphony.xwork2.ActionSupport;

public class JsonPartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4007146017378220003L;
	private static Log logger = LogFactory.getLog(JsonPartAction.class);
	private IPartQuestionInfoService partQuestionInfoService = null;
	private IQuestionInfoService questionInfoService = null;	

	@Override
	public String execute() throws Exception {
		try{
			
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}

	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}

	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}

}
