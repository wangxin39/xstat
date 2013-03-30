package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IPartInfoService;
import org.xsaas.xstat.business.IPartQuestionInfoService;
import org.xsaas.xstat.business.IQuestionInfoService;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.PartInfo;
import org.xsaas.xstat.po.PartQuestionInfo;
import org.xsaas.xstat.po.QuestionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListPartQuestionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2072274367732074056L;
	private static Log logger = LogFactory.getLog(ListPartQuestionAction.class);
	private IPartQuestionInfoService partQuestionInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IPartInfoService partInfoService = null;

	private IQuestionInfoService questionInfoService = null;
	List<String> inquisitionList = new LinkedList<String>();
	List<String> partList = new LinkedList<String>();
	List<String> questionList = new LinkedList<String>();
	List<String> typeList = new LinkedList<String>();
	List<String> validationList = new LinkedList<String>();
	
	private Long partQuestionID = null;
	private Long inquisitionID = null;
	private Long partID = null;
	private Long questionID = null;
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<PartQuestionInfo> pageList = null;
	
	private PaginationUtil pu = null;	
			
	private Integer total = null;
	
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
		
			List<PartInfo> pList = partInfoService.getPartInfoList();
			ActionContext.getContext().getSession().put("PARTSELECT", pList);
			
			Long selectPartID = (Long)ActionContext.getContext().getSession().get("SELECTPARTID");
			if(partID != null){
				selectPartID = partID;				
			}			
			if(selectPartID == null) {
				if(pList != null && pList.size() > 0) {
					PartInfo pi = pList.get(0);
					if(pi != null && pi.getPartID() != null) {
						selectPartID = pi.getPartID();						
					}
				}
			}
			total = partQuestionInfoService.getPartQuestionTotal(selectPartID);				
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);			
			pageList = partQuestionInfoService.findPartQuestionInfoByPage(selectPartID,pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);			
			ActionContext.getContext().getSession().put("SELECTPARTID", selectPartID);			
			
			PartInfo partInfo = null;
			QuestionInfo questionInfo = null;
			
			partList.clear();
			questionList.clear();
			typeList.clear();
			
			if(pageList != null) {
				for(PartQuestionInfo info : pageList){		
					if(info.getPartID() != null) {
						partInfo = partInfoService.getPartInfo(info.getPartID());						
					}
					if(info.getQuestionID() != null && info.getQuestionID() != -1) {
						questionInfo = questionInfoService.getQuestionInfo(info.getQuestionID());
					}
					if(partInfo != null){
						partList.add(""+partInfo.getName());
					}else{
						partList.add("");
					}
					if(questionInfo != null){
						questionList.add(""+questionInfo.getQuestion());
						
					}else{
						questionList.add("");						
					}
					if(info.getQuestionType() != null) {
						typeList.add(""+QuestionTypeConstants.QuestionTypeDict.get(info.getQuestionType()));
					}else{
						typeList.add("");
					}
				}				
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}

	public String detail() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	

			
			if(username == null || password == null) {
				return LOGIN;
			}
			if(partQuestionID == null) {
				this.addActionError("非法操作！找不到要操作的对象！");
				return ERROR;
			}
			PartQuestionInfo info = partQuestionInfoService.getPartQuestionInfo(partQuestionID);
			ActionContext.getContext().put("DETAILPARTQUESTIONINFO", info);
			
			PartInfo pInfo = partInfoService.getPartInfo(info.getPartID());
			if(pInfo!= null && pInfo.getName()!=null){
				ActionContext.getContext().put("PARTSELECT", pInfo.getName());
			}
			if(info.getFatherPqID() != null) {
				PartQuestionInfo fatherInfo = partQuestionInfoService.getPartQuestionInfo(info.getFatherPqID());
				if(fatherInfo != null && fatherInfo.getQuestionID() != null) { 
					QuestionInfo qi = questionInfoService.getQuestionInfo(fatherInfo.getQuestionID());
					if(qi != null) {
						ActionContext.getContext().put("FATHERNAME", qi.getQuestion());						
					}
				}
			}			
			if(info.getQuestionID() != -1) {
				QuestionInfo qInfo = questionInfoService.getQuestionInfo(info.getQuestionID());
				if(qInfo !=null && qInfo.getQuestion() != null){
					ActionContext.getContext().put("QUESTIONSELEST", qInfo.getQuestion());
				}
				if(info.getQuestionType() != null){
					ActionContext.getContext().put("TYPESELEST", QuestionTypeConstants.QuestionTypeDict.get(info.getQuestionType()));
				}
			}
			if(info.getInquisitionID() != null) {
				InquisitionInfo ii = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());
				if(ii!=null && ii.getTitle()!=null){
					ActionContext.getContext().put("INQUISITIONSELECT", ii.getTitle());
				}				
			}
			if(info.getValidation()!=null){
				ActionContext.getContext().put("VALIDATIONSELECT",QuestionTypeConstants.ValidationDict.get(info.getValidation()));
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}	
		

	public void setInquisitionList(List<String> inquisitionList) {
		this.inquisitionList = inquisitionList;
	}

	public List<String> getPartList() {
		return partList;
	}
	public void setPartList(List<String> partList) {
		this.partList = partList;
	}
	public List<String> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}
	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}
	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}
	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}

	public Long getPartID() {
		return partID;
	}

	public void setPartID(Long partID) {
		this.partID = partID;
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

	public List<String> getInquisitionList() {
		return inquisitionList;
	}

	public List<PartQuestionInfo> getPageList() {
		return pageList;
	}
	public PaginationUtil getPu() {
		return pu;
	}
	public List<String> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}
	public List<String> getValidationList() {
		return validationList;
	}
	public void setValidationList(List<String> validationList) {
		this.validationList = validationList;
	}
	public Long getPartQuestionID() {
		return partQuestionID;
	}
	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}

	public Integer getTotal() {
		return total;
	}
	
	
}
