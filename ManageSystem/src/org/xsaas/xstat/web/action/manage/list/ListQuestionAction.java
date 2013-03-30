package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedHashMap;
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

public class ListQuestionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6466443869055598571L;
	private static Log logger = LogFactory.getLog(ListQuestionAction.class);
	private IQuestionInfoService questionInfoService = null;

	private List<String> questionTypeList = new LinkedList<String>();
	private List<String> fieldTypeList = new LinkedList<String>();
	private Long questionID = null;

	/**
	 * 查询关键词
	 */
	private String keyword = null;
	private Integer questionType = null;
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<QuestionInfo> pageList = null;
	
	private Integer total = null;
	
	private PaginationUtil pu = null;		

	
	private Integer start = null;
	private Integer limit = null;
	
	@SuppressWarnings("unchecked")
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
			int type = -1; // 问题类型,默认为全部
			if(questionType != null){
				type = questionType.intValue();
			}
			String key = null;
			if(keyword != null) {
				key = keyword;
			}
			
			if(type != -1) { //选择类型
				if(key != null) {
					total = questionInfoService.getTotal(type,key);			
				}else{
					total = questionInfoService.getTotal(type);
				}				
				
				if(start != null) {
					if(key != null) {
						pageList = questionInfoService.findByPage(type,key, start, limit);			
					}else{
						pageList = questionInfoService.findByPage(type, start, limit);	
					}						
				}else{
					pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);											
					if(key != null) {
						pageList = questionInfoService.findByPage(type,key, pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);			
					}else{
						pageList = questionInfoService.findByPage(type,  pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);	
					}						
				}
			}else{ //全部类型
				if(key != null) {
					total = questionInfoService.getTotal(key);
					if(start != null) {
						pageList = questionInfoService.findByPage(key, start, limit);									
					}else{
						pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);				
						pageList = questionInfoService.findByPage(key, pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);									
					}
				}else{
					total = questionInfoService.getQuestionInfoTotal();
					if(start != null) {
						pageList = questionInfoService.findByPage(start, limit);															
					}else{
						pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);									
						pageList = questionInfoService.findByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);									
					}

				}
			}		

			for(QuestionInfo info:pageList){
				if(pageList != null){
					if(info.getQuestionType() != null){
						if(info.getQuestionType() != -1)
						questionTypeList.add(""+QuestionTypeConstants.QuestionTypeDict.get(info.getQuestionType()));
					}else if(info.getQuestionType() == -1){
						questionTypeList.add("全部");
					}
					if(info.getFieldType() != null){
						fieldTypeList.add(""+QuestionTypeConstants.FieldTypeDict.get(info.getFieldType()));
					}else{
						fieldTypeList.add("");
					}
				}else{
					this.addActionMessage("数据库中没有数据!");
				}
			}
			LinkedHashMap<Integer,String> qiMap = QuestionTypeConstants.QuestionTypeDict;
			qiMap.put(new Integer(-1), "全部");			
			ActionContext.getContext().getSession().put("QUESTIONTYPEMAP",qiMap);
			ActionContext.getContext().getSession().put("QUESTIONTYPE",type);				

		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		return SUCCESS;
	}
	
	
	public String detail() throws Exception{		
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}			
			if(logger.isDebugEnabled()) {
				logger.debug("questionID:"+questionID);
			}
			if(questionID == null) {
				this.addActionError("编号为空！");
				return ERROR;
			}
			QuestionInfo info = questionInfoService.getQuestionInfo(questionID);		
			if(logger.isDebugEnabled()) {
				logger.debug("QuestionInfo:"+info);
				logger.debug("QuestionInfo questionType:"+info.getQuestionType());
				logger.debug("QuestionInfo fieldType:"+info.getFieldType());
			}
			ActionContext.getContext().put("QUESTIONINFO", info);
			if(info.getQuestionType() != null && info.getFieldType() != null) {
				ActionContext.getContext().put("FIELDTYPE",QuestionTypeConstants.FieldTypeDict.get(new Integer(info.getFieldType())));			
				ActionContext.getContext().put("QUESTIONTYPE",QuestionTypeConstants.QuestionTypeDict.get(new Integer(info.getQuestionType())));
			}else{
				ActionContext.getContext().put("FIELDTYPE","");	
				ActionContext.getContext().put("QUESTIONTYPE","");	
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


	public List<String> getFieldTypeList() {
		return fieldTypeList;
	}


	public void setFieldTypeList(List<String> fieldTypeList) {
		this.fieldTypeList = fieldTypeList;
	}


	public List<String> getQuestionTypeList() {
		return questionTypeList;
	}


	public void setQuestionTypeList(List<String> questionTypeList) {
		this.questionTypeList = questionTypeList;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public Integer getQuestionType() {
		return questionType;
	}


	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public Long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
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


	public Integer getTotal() {
		return total;
	}


	public Integer getStart() {
		return start;
	}


	public void setStart(Integer start) {
		this.start = start;
	}


	public Integer getLimit() {
		return limit;
	}


	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
