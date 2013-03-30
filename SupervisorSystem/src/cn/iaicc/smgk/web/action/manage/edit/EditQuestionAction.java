package cn.iaicc.smgk.web.action.manage.edit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IQuestionInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.QuestionInfo;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditQuestionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6466443869055598571L;
	private static Log logger = LogFactory.getLog(EditQuestionAction.class);
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

	private Long questionID = null;
	
	@SuppressWarnings("unchecked")
	public String execute()throws Exception{
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			QuestionInfo info = (QuestionInfo) ActionContext.getContext().getSession().get("QUESTIONINFOEDIT");
			if(isOK != null && "OK".equals(isOK) && info != null) {
				if(englishExplain != null) {
					info.setEnglishExplain(englishExplain);					
				}
				if(englishQuestion != null) {
					info.setEnglishQuestion(englishQuestion);					
				}
				if(zhExplain != null) {
					info.setZhExplain(zhExplain);
				}
				if(format != null) {
					info.setFormat(format);					
				}
				if(fieldValue != null) {
					info.setFieldValue(fieldValue);					
				}
				if(fieldType != null) {
					info.setFieldType(fieldType);					
				}
				if(questionType != null) {
					info.setQuestionType(questionType);					
				}
				if(question != null) {
					info.setQuestion(question);					
				}
				questionInfoService.update(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");					
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
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			if(questionID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			QuestionInfo info = questionInfoService.getQuestionInfo(questionID);
			ActionContext.getContext().getSession().put("QUESTIONINFOEDIT", info);
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

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
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

	public Long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}

}
