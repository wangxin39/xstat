package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.ICheckDetailInfoService;
import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.business.IProjectInfoService;
import org.xsaas.xstat.po.CheckDetailInfo;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.IssueInfo;
import org.xsaas.xstat.po.ProjectInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListCheckAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 179282249083478153L;
	private static Log logger = LogFactory.getLog(ListCheckAction.class);
	private ICheckDetailInfoService checkDetailInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IProjectInfoService projectInfoService = null;
	private IClientInfoService clientInfoService = null;
	private List<String> iiList = new LinkedList<String>();
	
	private Long inquisitionID = null;

	private Long issueID = null;
	private Long clientID = null;
	private Long projectID = null;

	private Integer num = null;
	private List<CheckDetailInfo> pageList = null;
	private PaginationUtil pu = null;		
	private Long checkDetailID = null;
	
	private List<InquisitionInfo> inquisitionList = new LinkedList<InquisitionInfo>();
	private List<IssueInfo> issueList = new LinkedList<IssueInfo>();
	private List<ProjectInfo> projectList = new LinkedList<ProjectInfo>();	
			
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {	
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		if(username == null || password == null) {
			return LOGIN;
		}
		try{

			EmployeeInfo employeeInfo = employeeInfoService.isLogin(username, password);
			if(employeeInfo == null) {
				return LOGIN;
			}
			int page = 1;
			if(num != null){
				page = num.intValue();
			}
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);//初始化省份信息
			}			
			
			long selectClientID = 0;
			if(clientID!= null){
				selectClientID = clientID.longValue();
			}else{
				if(clientInfoList.size()>0){
					ClientInfo ci = clientInfoList.get(0);
					if(ci!=null){
						selectClientID = ci.getClientID().longValue();
						ActionContext.getContext().put("CLIENTVALUE",selectClientID);
					}
				}
			}

			int total = 0;
			if(selectClientID!=0){
				total = checkDetailInfoService.getCheckDetailInfoTotal(selectClientID);
			}else{
				total = checkDetailInfoService.getCheckDetailInfoTotal();
			}
		
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			if(selectClientID!=0){
				pageList = checkDetailInfoService.findCheckDetailInfoByPage(selectClientID,pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = checkDetailInfoService.findCheckDetailInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}
			
			for(CheckDetailInfo info:pageList){
				InquisitionInfo iti = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());
				
				if(iti!=null && iti.getTitle()!=null){
					iiList.add(""+iti.getTitle());
				}else{
					iiList.add("");
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
			if(checkDetailID == null) {
				this.addActionError("checkDetailID为空！");
				return ERROR;
			}
			CheckDetailInfo info = checkDetailInfoService.getCheckDetailInfo(checkDetailID);
			if(info!=null && info.getType()!=null){
				ActionContext.getContext().put("CHECKDETAIL",info);
				ActionContext.getContext().put("TYPE",QuestionTypeConstants.CheckDict.get(info.getType()));
			}
			InquisitionInfo ii = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());

			if(ii!=null && ii.getTitle()!=null){
				ActionContext.getContext().put("INQUISITION",ii.getTitle());
			}
			if(info.getStatus()!=null){
				ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));
			}
			IssueInfo iii = issueInfoService.getIssueInfo(info.getIssueID());
			if(iii!=null && iii.getIssue()!=null){
				ActionContext.getContext().put("ISSUE",iii.getIssue());
			}
			ClientInfo ci = clientInfoService.getClientInfo(info.getClientID());
			org.xsaas.xstat.po.ProjectInfo pi = projectInfoService.getProjectInfo(info.getProjectID());
			if(ci!=null && ci.getCompany()!=null){
				ActionContext.getContext().put("CLIENT",ci.getCompany());
			}
			if(pi!=null && pi.getName()!=null){
				ActionContext.getContext().put("PROJECT",pi.getName());
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


	public List<String> getIiList() {
		return iiList;
	}


	public void setIiList(List<String> iiList) {
		this.iiList = iiList;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}
	public PaginationUtil getPu() {
		return pu;
	}
	
	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public Long getInquisitionID() {
		return inquisitionID;
	}


	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
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

	public List<IssueInfo> getIssueList() {
		return issueList;
	}


	public void setIssueList(List<IssueInfo> issueList) {
		this.issueList = issueList;
	}

	public List<CheckDetailInfo> getPageList() {
		return pageList;
	}


	public void setPageList(List<CheckDetailInfo> pageList) {
		this.pageList = pageList;
	}


	public Long getCheckDetailID() {
		return checkDetailID;
	}


	public void setCheckDetailID(Long checkDetailID) {
		this.checkDetailID = checkDetailID;
	}


	public void setCheckDetailInfoService(
			ICheckDetailInfoService checkDetailInfoService) {
		this.checkDetailInfoService = checkDetailInfoService;
	}


	public Long getClientID() {
		return clientID;
	}


	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}


	public Long getProjectID() {
		return projectID;
	}


	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}


	public void setProjectInfoService(IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}


	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}


	public List<InquisitionInfo> getInquisitionList() {
		return inquisitionList;
	}


	public void setInquisitionList(List<InquisitionInfo> inquisitionList) {
		this.inquisitionList = inquisitionList;
	}


	public List<ProjectInfo> getProjectList() {
		return projectList;
	}


	public void setProjectList(List<ProjectInfo> projectList) {
		this.projectList = projectList;
	}


}
