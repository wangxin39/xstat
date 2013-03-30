package org.xsaas.xstat.web.action.manage.list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.IssueConstants;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.business.IProjectInfoService;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.IssueInfo;
import org.xsaas.xstat.po.ProjectInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListIssueAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7568400183849106961L;
	private static Log logger = LogFactory.getLog(ListIssueAction.class);
	private IIssueInfoService issueInfoService = null;
	private IClientInfoService clientInfoService = null;
	private IProjectInfoService projectInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;

	
	private List<String> clientList = new LinkedList<String>();
	private List<String> projectList = new LinkedList<String>();
	private List<String> inquisitionList = new LinkedList<String>();
	
	private List<String> actionsList = new LinkedList<String>();
	private List<String> actionList = new LinkedList<String>();
	public Long clientID = null;
	public Long projectID = null;
	
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<IssueInfo> pageList = null;	
	
	private PaginationUtil pu = null;
	
	public Long issueID = null;
	public Integer actions = null;
	Map<Long,String> projectMap = new HashMap<Long,String>();
	
	private List<InquisitionInfo> inquisitionInfoList = new LinkedList<InquisitionInfo>();
	private List<ProjectInfo> projectInfoList = new LinkedList<ProjectInfo>();

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
			if(num != null) {
				page = num.intValue();
			}
			List<ProjectInfo> piList = projectInfoService.getProjectInfoList();
			
			for(ProjectInfo pi: piList){
				ClientInfo ci = clientInfoService.getClientInfo(pi.getClientID());
				if(ci!=null){
					projectMap.put(pi.getProjectID(),pi.getName()+"|"+ci.getCompany());
				}else{
					projectMap.put(pi.getProjectID(),pi.getName());
				}			
			}
			ActionContext.getContext().getSession().put("PROJECTLIST", projectMap);

			long selectprojectID = 0;
			if(projectID != null) {
				selectprojectID = projectID.longValue();
			}
			
			int total = 0;
			if(selectprojectID != 0){
				total = issueInfoService.getTotal(selectprojectID);
			}else{
				total = issueInfoService.getIssueInfoTotal();
			}
			
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			if(selectprojectID != 0){
				pageList = issueInfoService.findByPage(selectprojectID,pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = issueInfoService.findIssueInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}
			
			for(IssueInfo info:pageList){
				if(pageList != null){
					if(info.getProjectID() != null){
						ProjectInfo pInfo = projectInfoService.getProjectInfo(info.getProjectID());
						if(pInfo !=null && pInfo.getName()!=null){
							projectList.add(""+pInfo.getName());
						}
						
					}else{
						projectList.add("");
					}
					if(info.getClientID() != null){
						ClientInfo cInfo = clientInfoService.getClientInfo(info.getClientID());
						if(cInfo != null && cInfo.getCompany()!=null){
							clientList.add(""+cInfo.getCompany());
						}
						
					}else{
						clientList.add("");
					}
					if(info.getInquisitionID() != null){
						InquisitionInfo iInfo = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());
						if(iInfo!=null && iInfo.getTitle()!=null){
							inquisitionList.add(""+iInfo.getTitle());
						}
						
					}else{
						inquisitionList.add("");
					}
					
					if(info.getActions()!=null){
						actionsList.add(""+IssueConstants.actionsMap.get(info.getActions()));//显示状态
					}
					
				}else{
					this.addActionMessage("数据库中没有值!");
				}
			}
	
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String updateActions() throws Exception{
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	

			if(username == null || password == null) {
				return LOGIN;
			}
			int page = 1;
			if(num != null) {
				page = num.intValue();
			}
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);//初始化省份信息
			}
			long selectClientID = 0;
			if(clientID != null) {
				selectClientID = clientID.longValue();
			}else{
				//客户信息不为空
				if(clientInfoList.size() >0) {
					ClientInfo ci = clientInfoList.get(0);
					if(ci!=null && ci.getClientID()!=null){
						selectClientID = ci.getClientID().longValue();	
					}
								
				}
			}

			long issueStatusID = 0;
			IssueInfo ii = null;
			
			if(issueID == null){
				List<IssueInfo> issueList = issueInfoService.getIssueInfoList();
				if(issueList.size()>0){
					ii = issueList.get(0);
					if(ii!=null){
						issueStatusID = ii.getIssueID().longValue();//初始化
					}
				}
			}else{
				issueStatusID = issueID.longValue();
			}
			ii = issueInfoService.getIssueInfo(issueStatusID);
			ii.setActions(ii.getActions()+1);
			issueInfoService.updateIssueInfo(ii);
			
			int total = 0;
			if(issueStatusID != 0 && selectClientID!=0){
				total = issueInfoService.getTotal(selectClientID,issueStatusID);
			}
			else{
				total = issueInfoService.getIssueInfoTotal();
			}
			
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			if(issueStatusID != 0 && selectClientID!=0){
				pageList = issueInfoService.findByPage(selectClientID,issueStatusID,pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = issueInfoService.findIssueInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}
			for(IssueInfo info:pageList){
				if(pageList != null){
					if(info.getProjectID() != null){
						ProjectInfo pInfo = projectInfoService.getProjectInfo(info.getProjectID());
						projectList.add(pInfo.getName());
					}else{
						projectList.add("");
					}
					if(info.getClientID() != null){
						ClientInfo cInfo = clientInfoService.getClientInfo(info.getClientID());
						clientList.add(cInfo.getCompany());
					}else{
						clientList.add("");
					}
					if(info.getInquisitionID() != null){
						InquisitionInfo iInfo = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());
						inquisitionList.add(iInfo.getTitle());
					}else{
						inquisitionList.add("");
					}
					
					if(info.getActions()!=null){
						actionsList.add(""+IssueConstants.actionsMap.get(info.getActions()));//显示状态
					}
					
				}else{
					this.addActionMessage("数据库中没有值!");
				}
			}

		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
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
			
			if(issueID != null) {
				IssueInfo info = issueInfoService.getIssueInfo(issueID);
				if(info  != null)
				ActionContext.getContext().put("ISSUEINFODETAIL",info);
				ClientInfo cList = clientInfoService.getClientInfo(info.getClientID());
				if(cList  != null && cList.getCompany()  != null)
				ActionContext.getContext().put("COMPANY",cList.getCompany());
				ProjectInfo pi = projectInfoService.getProjectInfo(info.getProjectID());
				if(pi  != null && pi.getName()  != null)
				ActionContext.getContext().put("PROJECTNAME",pi.getName());
				InquisitionInfo ii = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());
				if(ii  != null && ii.getTitle()  != null)
				ActionContext.getContext().put("TITLE",ii.getTitle());
				
				if(info.getActions() != null){
					ActionContext.getContext().put("ACTIONS",IssueConstants.actionsMap.get(info.getActions()));			
				}
				if(info.getStatStatus() != null && info.getStatus()!=null){
					ActionContext.getContext().put("STATUS",IssueConstants.statusMap.get(info.getStatus()));
					ActionContext.getContext().put("STATSTATUS",IssueConstants.statusMap.get(info.getStatStatus()));
				}
				if(info.getReportStatus() != null && info.getEvaluationStatus()!=null && info.getChartStatus()!=null){
					ActionContext.getContext().put("RSTATUS",IssueConstants.statusMap.get(info.getReportStatus()));
					ActionContext.getContext().put("ESTATUS",IssueConstants.statusMap.get(info.getEvaluationStatus()));
					ActionContext.getContext().put("CSTATUS",IssueConstants.statusMap.get(info.getChartStatus()));
				}
				if(info != null && info.getIsFirst() != null) {
					ActionContext.getContext().put("ISFRIST",StatusConstants.FirstYearDict.get(info.getIsFirst()));
				}				
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}		
	
				
	public void setclientInfoService(
			IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}
	
	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<String> getClientList() {
		return clientList;
	}
	public void setClientList(List<String> clientList) {
		this.clientList = clientList;
	}
	public List<String> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<String> projectList) {
		this.projectList = projectList;
	}
	public List<String> getInquisitionList() {
		return inquisitionList;
	}
	public void setInquisitionList(List<String> inquisitionList) {
		this.inquisitionList = inquisitionList;
	}
	public List<IssueInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<IssueInfo> pageList) {
		this.pageList = pageList;
	}
	public Long getIssueID() {
		return issueID;
	}
	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}
	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}
	public void setProjectInfoService(IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}
	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}
	public PaginationUtil getPu() {
		return pu;
	}

	public Long getClientID() {
		return clientID;
	}
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	public List<String> getActionsList() {
		return actionsList;
	}
	public void setActionsList(List<String> actionsList) {
		this.actionsList = actionsList;
	}
	public List<String> getActionList() {
		return actionList;
	}
	public void setActionList(List<String> actionList) {
		this.actionList = actionList;
	}
	
	public Integer getActions() {
		return actions;
	}

	public void setActions(Integer actions) {
		this.actions = actions;
	}

	public List<InquisitionInfo> getInquisitionInfoList() {
		return inquisitionInfoList;
	}

	public void setInquisitionInfoList(List<InquisitionInfo> inquisitionInfoList) {
		this.inquisitionInfoList = inquisitionInfoList;
	}

	public List<ProjectInfo> getProjectInfoList() {
		return projectInfoList;
	}

	public void setProjectInfoList(List<ProjectInfo> projectInfoList) {
		this.projectInfoList = projectInfoList;
	}

	public Map<Long, String> getProjectMap() {
		return projectMap;
	}

	public void setProjectMap(Map<Long, String> projectMap) {
		this.projectMap = projectMap;
	}

	public Long getProjectID() {
		return projectID;
	}

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

}
