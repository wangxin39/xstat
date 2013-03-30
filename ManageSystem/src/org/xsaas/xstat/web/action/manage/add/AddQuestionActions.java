package org.xsaas.xstat.web.action.manage.add;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IQuestionInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.QuestionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddQuestionActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1182578343300364970L;
	private static Log logger = LogFactory.getLog(AddQuestionActions.class);
			
	private IQuestionInfoService questionInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	private String question = null;
	private String englishQuestion = null;
	private String zhExplain = null;
	private String englishExplain = null;
	private Integer questionType = null;
	private String format = null;
	private String fieldValue = null;
	private Integer fieldType = null;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				QuestionInfo info = new QuestionInfo();
				if(englishExplain != null) {
					info.setEnglishExplain(englishExplain);					
				}
				if(englishQuestion != null) {
					info.setEnglishQuestion(englishQuestion);					
				}
				if(zhExplain != null) {
					info.setZhExplain(zhExplain);					
				}
				if(fieldType != null) {
					info.setFieldType(fieldType);					
				}
				if(format != null) {
					info.setFormat(format);					
				}
				if(fieldValue != null) {
					info.setFieldValue(fieldValue);					
				}
				if(questionType != null) {
					info.setQuestionType(questionType);					
				}
				if(question != null) {
					info.setQuestion(question);					
				}
				info.setStatus(StatusConstants.ZHENGCHANG);
				questionInfoService.save(info);
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
			ActionContext.getContext().getSession().put("QUESTIONTYPE",QuestionTypeConstants.QuestionTypeDict);
			ActionContext.getContext().getSession().put("FIELDTYPE",QuestionTypeConstants.FieldTypeDict);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}	
	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}
	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}


	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	public String getEnglishQuestion() {
		return englishQuestion;
	}

	public void setEnglishQuestion(String englishQuestion) {
		this.englishQuestion = englishQuestion;
	}

	public String getZhExplain() {
		return zhExplain;
	}

	public void setZhExplain(String zhExplain) {
		this.zhExplain = zhExplain;
	}

	public String getEnglishExplain() {
		return englishExplain;
	}

	public void setEnglishExplain(String englishExplain) {
		this.englishExplain = englishExplain;
	}

	

	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	
	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Integer getFieldType() {
		return fieldType;
	}

	public void setFieldType(Integer fieldType) {
		this.fieldType = fieldType;
	}
	
	

}
