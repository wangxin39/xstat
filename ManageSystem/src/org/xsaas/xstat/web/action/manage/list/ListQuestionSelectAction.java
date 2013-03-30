package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IQuestionInfoService;
import org.xsaas.xstat.po.QuestionInfo;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListQuestionSelectAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6466443869055598571L;
	private static Log logger = LogFactory.getLog(ListQuestionSelectAction.class);
	private IQuestionInfoService questionInfoService = null;
	private List<String> questionList = new LinkedList<String>();
	private List<String> fieldTypeList = new LinkedList<String>();
	private Integer num = null;
	private List<QuestionInfo> pageList = null;
	private PaginationUtil pu = null;	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}			
			int page = 1;
			if(num != null){
				page = num.intValue();
			}
			int total = questionInfoService.getQuestionInfoTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = questionInfoService.findByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			
			for(QuestionInfo info:pageList){
				if(info.getQuestionType() != null){
					questionList.add(""+QuestionTypeConstants.QuestionTypeDict.get(info.getQuestionType()));
				}else{
					questionList.add("");
				}
				if(info.getFieldType()!= null){
					fieldTypeList.add(""+QuestionTypeConstants.FieldTypeDict.get(info.getFieldType()));
				}else{
					fieldTypeList.add("");
				}
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}


	public List<String> getQuestionList() {
		return questionList;
	}


	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}


	public List<String> getFieldTypeList() {
		return fieldTypeList;
	}


	public void setFieldTypeList(List<String> fieldTypeList) {
		this.fieldTypeList = fieldTypeList;
	}

	public List<QuestionInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<QuestionInfo> pageList) {
		this.pageList = pageList;
	}
	public PaginationUtil getPu() {
		return pu;
	}

}
