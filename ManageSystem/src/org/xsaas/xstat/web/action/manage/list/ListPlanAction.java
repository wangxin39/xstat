package org.xsaas.xstat.web.action.manage.list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.IssueConstants;
import org.xsaas.xstat.web.conf.PlanStatusConstants;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IClientAccountInfoService;
import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInformantInfoService;
import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.business.IPlanInfoService;
import org.xsaas.xstat.business.IProjectInfoService;
import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.ClientAccountInfo;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InformantInfo;
import org.xsaas.xstat.po.IssueInfo;
import org.xsaas.xstat.po.PlanInfo;
import org.xsaas.xstat.po.ProjectInfo;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListPlanAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2072274367732074056L;
	private static Log logger = LogFactory.getLog(ListPlanAction.class);
	private IPlanInfoService planInfoService = null;
	private IClientAccountInfoService clientAccountInfoService = null;
	private ISmgkInfoService smgkInfoService = null;
	private IClientInfoService clientInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IProjectInfoService projectInfoService = null;

	
	private List<String> accountList = new LinkedList<String>();
	private List<String> clientList = new LinkedList<String>();
	private List<String> smgkList = new LinkedList<String>();
	private List<String> issueList = new LinkedList<String>();
	private List<String> projectList = new LinkedList<String>();
	private List<String> informantList = new LinkedList<String>();
	
	private Map<Long,String> issueMap = new HashMap<Long,String>();
	
	private Long planID = null;
	private Long smgkID = null;
	private Long issueID = null;
	private Long clientID = null;
	private Long informantID = null;
	
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<PlanInfo> pageList = null;
	
	private PaginationUtil pu = null;	
	
	private List<InformantInfo> inList = new LinkedList<InformantInfo>();
			
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
			int total = planInfoService.getPlanInfoTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = planInfoService.findPlanInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			for(PlanInfo info:pageList){
				if(pageList != null){
					SmgkInfo smgkInfo = smgkInfoService.getSmgkInfo(info.getSmgkID());
					InformantInfo inInfo = informantInfoService.getInformantInfo(info.getInformantID());
					IssueInfo issueInfo = issueInfoService.getIssueInfo(info.getIssueID());
					ClientInfo clientInfo = clientInfoService.getClientInfo(info.getClientID());
					ProjectInfo projectInfo = projectInfoService.getProjectInfo(info.getProjectID());
					ClientAccountInfo accountInfo = clientAccountInfoService.getClientAccountInfo(info.getInformantID());
					if(smgkInfo != null && smgkInfo.getUserName()!=null){
						smgkList.add(""+smgkInfo.getUserName());
					}else{
						smgkList.add("");
					}
					if(issueInfo != null && issueInfo.getIssue()!=null){
						issueList.add(""+issueInfo.getIssue());
					}else{
						issueList.add("");
					}
					if(clientInfo != null && clientInfo.getCompany()!=null){
						clientList.add(""+clientInfo.getCompany());
					}else{
						clientList.add("");
					}
					if(projectInfo != null && projectInfo.getName()!=null){
						projectList.add(""+projectInfo.getName());
					}else{
						projectList.add("");
					}
					if(accountInfo != null && accountInfo.getClientName()!=null){
						accountList.add(""+accountInfo.getClientName());
					}else{
						accountList.add("");
					}
					if(inInfo != null && inInfo.getName()!=null){
						informantList.add(""+inInfo.getName());
					}else{
						informantList.add("");
					}
					
				}else{
					this.addActionMessage("数据库中没有数据！");
				}
			}
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
			if(planID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			PlanInfo info = planInfoService.getPlanInfo(planID);
			if(info!=null && info.getWeightPattern()!=null){
				ActionContext.getContext().put("PLANDETAIL",info);
				ActionContext.getContext().put("WEIFHT",PlanStatusConstants.weightDict.get(info.getWeightPattern()));
			}
			if(info.getStatus()!=null && info.getChartStatus()!=null && info.getCheckStatus()!=null && info.getEvaluationStatus()!=null && info.getReportStatus()!=null && info.getStatStatus()!=null){
				ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));
				ActionContext.getContext().put("STATSTATUS",IssueConstants.statusMap.get(info.getStatStatus()));
				ActionContext.getContext().put("CHECKSTATUS",StatusConstants.PlanStatusDict.get(info.getCheckStatus()));
				ActionContext.getContext().put("CHARTSTATUS",IssueConstants.statusMap.get(info.getChartStatus()));
				ActionContext.getContext().put("EVALUATIONSTATUS",IssueConstants.statusMap.get(info.getEvaluationStatus()));
				ActionContext.getContext().put("REPORTSTATUS",IssueConstants.statusMap.get(info.getReportStatus()));
			}
			IssueInfo ii = issueInfoService.getIssueInfo(info.getIssueID());
			if(ii!=null && ii.getIssue()!=null){
				ActionContext.getContext().put("ISSUE",ii.getIssue());
			}
			ClientInfo ci = clientInfoService.getClientInfo(info.getClientID());
			if(ci!=null && ci.getCompany()!=null){
				ActionContext.getContext().put("CLIENT",ci.getCompany());
			}
			ProjectInfo pi = projectInfoService.getProjectInfo(info.getProjectID());
			if(pi!=null && pi.getName()!=null){
				ActionContext.getContext().put("PROJECT",pi.getName());
			}
			InformantInfo ifi = informantInfoService.getInformantInfo(info.getInformantID());
			if(ifi!=null && ifi.getName()!=null){
				ActionContext.getContext().put("INFORMANT",ifi.getName());
			}
			SmgkInfo si = smgkInfoService.getSmgkInfo(info.getSmgkID());
			if(si!=null && si.getUserName()!=null){
				ActionContext.getContext().put("SMGKINFO",si.getUserName());
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}
	
	public List<String> getQuestionList() {
		return smgkList;
	}
	public void setQuestionList(List<String> smgkList) {
		this.smgkList = smgkList;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

	public PaginationUtil getPu() {
		return pu;
	}
	public List<String> getClientList() {
		return clientList;
	}
	public void setClientList(List<String> clientList) {
		this.clientList = clientList;
	}
	public List<String> getSmgkList() {
		return smgkList;
	}
	public void setSmgkList(List<String> smgkList) {
		this.smgkList = smgkList;
	}
	
	public void setPlanInfoService(IPlanInfoService planInfoService) {
		this.planInfoService = planInfoService;
	}
	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}
	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}
	
	public void setPageList(List<PlanInfo> pageList) {
		this.pageList = pageList;
	}
	public List<PlanInfo> getPageList() {
		return pageList;
	}
	public Long getPlanID() {
		return planID;
	}
	public void setPlanID(Long planID) {
		this.planID = planID;
	}
	public List<String> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<String> accountList) {
		this.accountList = accountList;
	}
	public List<String> getIssueList() {
		return issueList;
	}
	public void setIssueList(List<String> issueList) {
		this.issueList = issueList;
	}
	public List<String> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<String> projectList) {
		this.projectList = projectList;
	}
	
	public void setClientAccountInfoService(
			IClientAccountInfoService clientAccountInfoService) {
		this.clientAccountInfoService = clientAccountInfoService;
	}
	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}
	public void setProjectInfoService(IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}
	public List<String> getInformantList() {
		return informantList;
	}
	public void setInformantList(List<String> informantList) {
		this.informantList = informantList;
	}
	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}
	public Long getSmgkID() {
		return smgkID;
	}
	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
	}

	public Long getIssueID() {
		return issueID;
	}
	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}
	public Long getClientID() {
		return clientID;
	}
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	public Long getInformantID() {
		return informantID;
	}
	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}
	public List<InformantInfo> getInList() {
		return inList;
	}
	public void setInList(List<InformantInfo> inList) {
		this.inList = inList;
	}
	public Map<Long, String> getIssueMap() {
		return issueMap;
	}
	public void setIssueMap(Map<Long, String> issueMap) {
		this.issueMap = issueMap;
	}
	
}
