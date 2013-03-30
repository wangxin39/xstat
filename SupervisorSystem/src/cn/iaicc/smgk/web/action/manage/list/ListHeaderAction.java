package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IInquisitionHeaderInfoService;
import cn.iaicc.smgk.business.IInquisitionInfoService;
import cn.iaicc.smgk.business.IQuestionInfoService;
import cn.iaicc.smgk.po.InquisitionHeaderInfo;
import cn.iaicc.smgk.po.InquisitionInfo;
import cn.iaicc.smgk.po.QuestionInfo;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListHeaderAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8154573800306729423L;
	private static Log logger = LogFactory.getLog(ListHeaderAction.class);
	private IInquisitionHeaderInfoService inquisitionHeaderInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IQuestionInfoService questionInfoService = null;
	
	private List<String> questionList = new LinkedList<String>();
	private List<String> inquisitionList = new LinkedList<String>();
	private List<String> isinputList = new LinkedList<String>();
	private List<String> typeList = new LinkedList<String>();
	private Long inquisitionID = null;

	private Long headerID = null;
	
	private Integer num = null;
	private List<InquisitionHeaderInfo> pageList = null;	
	private PaginationUtil pu = null;	
			
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
			List<InquisitionInfo> iList = inquisitionInfoService.getInquisitionInfoList();
			//先添加调查问卷
			long selectInquisitionID = 0;
			if(inquisitionID != null) {
				selectInquisitionID = inquisitionID.longValue();
			}else{
				//客户信息不为空
				if(iList.size() >0) {
					InquisitionInfo ci = iList.get(0);
					selectInquisitionID = ci.getInquisitionID();				
				}
			}
			ActionContext.getContext().getSession().put("INQUISITIONSELECT",iList);		
			int total = 0;
			if(selectInquisitionID != 0)
			{
				total = inquisitionHeaderInfoService.getInquisitionHeaderInfoTotal(selectInquisitionID);
			}else{
				total = inquisitionHeaderInfoService.getInquisitionHeaderInfoTotal();			
			}
			
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);

			if(selectInquisitionID != 0) {
				pageList = inquisitionHeaderInfoService.findInquisitionHeaderInfoByPage(selectInquisitionID,pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = inquisitionHeaderInfoService.findInquisitionHeaderInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);			
			}
			
			Map<Long,String> iqMap = new java.util.HashMap<Long, String>();
			for(InquisitionInfo info:iList)
			{
				if(info.getInquisitionID() != null) {
					iqMap.put(info.getInquisitionID(), ""+info.getTitle());				
				}
			}
			
			for(InquisitionHeaderInfo info:pageList){				
				if(info.getQuestionID() != null) {
					QuestionInfo qInfo = questionInfoService.getQuestionInfo(info.getQuestionID());
					questionList.add(""+qInfo.getQuestion());				
				}else{
					questionList.add("");								
				}
				
				if(info.getInquisitionID() != null) {
					inquisitionList.add(""+iqMap.get(info.getInquisitionID()));				
				}else{
					inquisitionList.add("");				
				}
				
				if(info.getIsinput() != null) {
					isinputList.add(""+QuestionTypeConstants.IsinputTypeDict.get(info.getIsinput()));				
				}else{
					isinputList.add("");				
				}
				
				if(info.getQuestionType() != null) {
					typeList.add(""+QuestionTypeConstants.QuestionTypeDict.get(info.getQuestionType()));				
				}else{
					typeList.add("");				
				}
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}
	
	
	public String detail() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			if(headerID == null) {
				this.addActionError("编号为空！");
				return ERROR;
			}
			InquisitionHeaderInfo info = inquisitionHeaderInfoService.getInquisitionHeaderInfo(headerID);
			if(info != null){
				ActionContext.getContext().put("HEADEREDIT",info);
			}
			
			InquisitionInfo ii = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID()); 
			QuestionInfo qi = questionInfoService.getQuestionInfo(info.getQuestionID());
		
			if(qi != null && qi.getQuestion() != null) {
				ActionContext.getContext().put("QUESTIONLIST",qi.getQuestion());				
			}
			if(ii != null && ii.getTitle() != null) {
				ActionContext.getContext().put("INQUISITIONLIST",ii.getTitle());				
			}
			if(info != null && info.getIsinput() != null) {
				ActionContext.getContext().put("ISINPUTLIST",QuestionTypeConstants.IsinputTypeDict.get(info.getIsinput()));			
			}
			if(info != null && info.getQuestionType() != null) {
				ActionContext.getContext().put("TYPELIST",QuestionTypeConstants.QuestionTypeDict.get(info.getQuestionType()));			
			}
			if(info != null && info.getSelectType() != null) {
				ActionContext.getContext().put("SELECTLIST",QuestionTypeConstants.SelectDict.get(info.getSelectType()));			
			}			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		

	
		return SUCCESS;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setInquisitionHeaderInfoService(
			IInquisitionHeaderInfoService inquisitionHeaderInfoService) {
		this.inquisitionHeaderInfoService = inquisitionHeaderInfoService;
	}

	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}

	public List<String> getQuestionList() {
		return questionList;
	}
	
	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}



	public List<String> getInquisitionList() {
		return inquisitionList;
	}



	public void setInquisitionList(List<String> inquisitionList) {
		this.inquisitionList = inquisitionList;
	}



	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}

	public List<String> getIsinputList() {
		return isinputList;
	}

	public void setIsinputList(List<String> isinputList) {
		this.isinputList = isinputList;
	}

	public List<InquisitionHeaderInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<InquisitionHeaderInfo> pageList) {
		this.pageList = pageList;
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

	public Long getHeaderID() {
		return headerID;
	}
	public void setHeaderID(Long headerID) {
		this.headerID = headerID;
	}
}
