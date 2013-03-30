package org.xsaas.xstat.web.action.manage.add;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.IssueConstants;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.business.IProjectInfoService;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.IssueInfo;
import org.xsaas.xstat.po.ProjectInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddIssueActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(AddIssueActions.class);
	private IIssueInfoService issueInfoService = null;
	private IClientInfoService clientInfoService = null;
	private IProjectInfoService projectInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	
	private String issue = null;
	private Long clientID = null;
	private Long projectID = null;
	private Long inquisitionID = null;

	private String startDay = null;
	private String endDay = null;	
	private String startTime = null;
	private String endTime = null;
	private String checkTime = null;
	private Integer year = null;
	private Integer isFirst = null;
	
	
	private Boolean isRegister = null;
	
	
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
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				if(clientID == null){
					this.addActionError("客户名称不能为空，请先添加客户信息!");
					return INPUT;
				}
				if(projectID == null){
					this.addActionError("项目名称不能为空,请先添加项目信息!");
					return INPUT;
				}
				if(inquisitionID == null){
					this.addActionError("调查问卷不能为空,请先添加调查问卷!");
					return INPUT;
				}
				IssueInfo info = new IssueInfo();
				isRegister = issueInfoService.isRegister(issue);
				if(isRegister !=  null && isRegister) {
					this.addActionError("期次不能重复!");
					return INPUT;
				}
				info.setClientID(clientID);
				info.setProjectID(projectID);
				info.setInquisitionID(inquisitionID);
				info.setIssue(issue);
				
				logger.debug("startDay:"+startDay+"|endDay:"+endDay+"|startTime:"+startTime+"|endTime:"+endTime+"|year:"+year+"|isFirst:"+isFirst);
				
				if(year != null) {
					info.setYear(year);
				}
				if(isFirst != null) {
					info.setIsFirst(isFirst);
				}
				if(startDay != null) {
					info.setStartDay(startDay);
				}
				if(endDay != null) {
					info.setEndDay(endDay);
				}
				if(startTime != null) {
					info.setStartTime(startTime);
				}
				if(endTime != null) {
					info.setEndTime(endTime);
				}
				if(checkTime != null) {					
					info.setCheckTime(Timestamp.valueOf(checkTime+".000"));
				}
				info.setChartStatus(IssueConstants.NOT_STATUS);
				info.setStatStatus(IssueConstants.NOT_STATUS);
				info.setActions(IssueConstants.INQUISITION_DO);
				info.setEvaluationStatus(IssueConstants.NOT_STATUS);
				info.setReportStatus(IssueConstants.NOT_STATUS);
				info.setAddTime(new Timestamp(System.currentTimeMillis()));
				info.setStatus(StatusConstants.ZHENGCHANG);
				
				issueInfoService.saveIssueInfo(info);
				
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		
		return SUCCESS;
	}
	// 增加输入界面
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			
			if(username == null || password == null) {
				return LOGIN;
			}		
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息

			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();			
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);
			}
			Long selectClientID = null;
			if(clientID != null){
				selectClientID = clientID;
			}else{
				if(clientInfoList.size() > 0){
					ClientInfo ci = clientInfoList.get(0);
					if(ci != null && ci.getClientID() != null){
						selectClientID = ci.getClientID();
					}
				}
			}
			ActionContext.getContext().put("CLIENTVALUE",selectClientID);
		
			inquisitionInfoList = inquisitionInfoService.getInquisitionInfoList(selectClientID);
		    projectInfoList = projectInfoService.getProjectInfoList(selectClientID);
			
			ActionContext.getContext().getSession().put("PROJECTSELECT",projectInfoList);
			ActionContext.getContext().getSession().put("INQUISITIONSELECT",inquisitionInfoList);
			ActionContext.getContext().getSession().put("TYPE",QuestionTypeConstants.InquisitionTypeDict);
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}	
	public String check() throws Exception {
		if(issue != null) {
			isRegister = issueInfoService.isRegister(issue);
		}		
		return SUCCESS;
	}
	
	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
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

	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}


	public Boolean getIsRegister() {
		return isRegister;
	}

	public void setIsRegister(Boolean isRegister) {
		this.isRegister = isRegister;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(Integer isFirst) {
		this.isFirst = isFirst;
	}
	public List<InquisitionInfo> getInquisitionInfoList() {
		return inquisitionInfoList;
	}
	public List<ProjectInfo> getProjectInfoList() {
		return projectInfoList;
	}
	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}
	public void setProjectInfoService(IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}
	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}


}
