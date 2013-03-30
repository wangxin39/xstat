package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IClientInfoService;
import cn.iaicc.smgk.business.IInformantInfoService;
import cn.iaicc.smgk.business.IInquisitionInfoService;
import cn.iaicc.smgk.business.IIssueInfoService;
import cn.iaicc.smgk.business.IPartInfoService;
import cn.iaicc.smgk.business.IPartQuestionInfoService;
import cn.iaicc.smgk.business.IPlanInfoService;
import cn.iaicc.smgk.business.IProjectInfoService;
import cn.iaicc.smgk.business.ISmgkInfoService;
import cn.iaicc.smgk.business.IStatQuestionInfoService;
import cn.iaicc.smgk.po.ClientInfo;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.po.InquisitionInfo;
import cn.iaicc.smgk.po.IssueInfo;
import cn.iaicc.smgk.po.PartInfo;
import cn.iaicc.smgk.po.PartQuestionInfo;
import cn.iaicc.smgk.po.PlanInfo;
import cn.iaicc.smgk.po.ProjectInfo;
import cn.iaicc.smgk.po.SmgkInfo;
import cn.iaicc.smgk.po.StatQuestionInfo;
import cn.iaicc.smgk.web.bo.PlanHeaderInfo;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListGradeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453855886740013266L;
	private static Log logger = LogFactory.getLog(ListGradeAction.class);
	private IStatQuestionInfoService statQuestionInfoService = null;
	
	private Long statID = null;
	private IClientInfoService clientInfoService = null;
	private IProjectInfoService projectInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private ISmgkInfoService smgkInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IPlanInfoService planInfoService = null;
	private IPartQuestionInfoService partQuestionInfoService = null;
	private IPartInfoService partInfoService = null;
//	private IQuestionSelectInfoService questionSelectInfoService = null;
	
	private List<String> planList = new LinkedList<String>();
	private List<String> partList = new LinkedList<String>();
	private List<String> selectList = new LinkedList<String>();
	
	
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<StatQuestionInfo> pageList = null;

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
			int total = statQuestionInfoService.getTotalStatQuestionInfo();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = statQuestionInfoService.findByPageStatQuestionInfo(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			for(StatQuestionInfo info:pageList){
				if(pageList != null){
					PlanInfo planInfo = planInfoService.getPlanInfo(info.getPlanID());
					PartQuestionInfo partInfo = partQuestionInfoService.getPartQuestionInfo(info.getPartQuestionID());
		
					if(planInfo != null){
						PlanHeaderInfo phi = new PlanHeaderInfo();
						IssueInfo ii = issueInfoService.getIssueInfo(planInfo.getIssueID());
						if(ii != null){
							phi.setIssue(ii.getIssue());
						}
						planList.add(""+planInfo.getIssueID());
						
					}else{
						planList.add("");
					}
					if(partInfo != null){
						partList.add(""+partInfo.getFieldName());
					}else{
						partList.add("");
					}				
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
			if(statID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			StatQuestionInfo info = statQuestionInfoService.getStatQuestionInfo(statID);
			if(info!=null && info.getStatus()!=null){
				ActionContext.getContext().put("STATDETAIL",info);
				ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));
			}
			ClientInfo ci = clientInfoService.getClientInfo(info.getClientID());
			if(ci!=null && ci.getCompany()!=null){
				ActionContext.getContext().put("CLIENTINFO",ci.getCompany());
			}
			ProjectInfo pi = projectInfoService.getProjectInfo(info.getProjectID());
			if(pi!=null && pi.getName()!=null){
				ActionContext.getContext().put("PROJECTINFO", pi.getName());
			}
			IssueInfo issueInfo = issueInfoService.getIssueInfo(info.getIssueID());
			if(issueInfo!=null && issueInfo.getIssue()!=null){
				ActionContext.getContext().put("ISSUEINFO", issueInfo.getIssue());
			}
			SmgkInfo smgkInfo = smgkInfoService.getSmgkInfo(info.getSmgkID());
			if(smgkInfo!=null && smgkInfo.getUserName()!=null){
				ActionContext.getContext().put("SMGKINFO", smgkInfo.getUserName());
			}
			InformantInfo informantInfo = informantInfoService.getInformantInfo(info.getInformantID());
			if(informantInfo!=null && informantInfo!=null){
				ActionContext.getContext().put("INFORMANT",informantInfo.getName());
			}
			PlanInfo planInfo = planInfoService.getPlanInfo(info.getPlanID());
			if(planInfo!= null && planInfo.getName()!=null){
				ActionContext.getContext().put("PLANINFO", planInfo.getName());
			}
			PartQuestionInfo pqi = partQuestionInfoService.getPartQuestionInfo(info.getPartQuestionID());
			if(pqi!= null && pqi.getFieldName()!=null){
				ActionContext.getContext().put("PARTQUESTION", pqi.getFieldName());
			}
//			QuestionSelectInfo qsi = questionSelectInfoService.getQuestionSelectInfo(info.getSelectID());
//			if(qsi!=null && qsi.getAlertText()!=null){
//				ActionContext.getContext().put("QUESTIONSELECTINFO", qsi.getAlertText());
//			}
			
			PartInfo pInfo = partInfoService.getPartInfo(info.getPartID());
			if(pInfo!= null && pInfo.getName()!=null){
				ActionContext.getContext().put("PARTSELECT", pInfo.getName());
			}
		
			InquisitionInfo ii = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());
			
			if(ii!=null && ii.getTitle()!=null){
				ActionContext.getContext().put("INQUISITION", ii.getTitle());
			}
			if(info.getRound()!=null){
				ActionContext.getContext().put("ROUND", QuestionTypeConstants.RoundDict.get(info.getRound()));
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

	public List<StatQuestionInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<StatQuestionInfo> pageList) {
		this.pageList = pageList;
	}

	public PaginationUtil getPu() {
		return pu;
	}

	public Long getStatID() {
		return statID;
	}
	public void setStatID(Long statID) {
		this.statID = statID;
	}
	public List<String> getPlanList() {
		return planList;
	}
	public void setPlanList(List<String> planList) {
		this.planList = planList;
	}
	public List<String> getPartList() {
		return partList;
	}
	public void setPartList(List<String> partList) {
		this.partList = partList;
	}
	public List<String> getSelectList() {
		return selectList;
	}
	public void setSelectList(List<String> selectList) {
		this.selectList = selectList;
	}
	public void setPlanInfoService(IPlanInfoService planInfoService) {
		this.planInfoService = planInfoService;
	}
	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}
	public void setStatQuestionInfoService(
			IStatQuestionInfoService statQuestionInfoService) {
		this.statQuestionInfoService = statQuestionInfoService;
	}
//	public void setQuestionSelectInfoService(
//			IQuestionSelectInfoService questionSelectInfoService) {
//		this.questionSelectInfoService = questionSelectInfoService;
//	}
	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public void setProjectInfoService(IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}

	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}

	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}
	
}
