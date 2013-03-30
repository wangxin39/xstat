package cn.iaicc.smgk.web.action.manage.edit;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IClientInfoService;
import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IInquisitionInfoService;
import cn.iaicc.smgk.business.IIssueInfoService;
import cn.iaicc.smgk.business.IProjectInfoService;
import cn.iaicc.smgk.po.ClientInfo;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.InquisitionInfo;
import cn.iaicc.smgk.po.IssueInfo;
import cn.iaicc.smgk.po.ProjectInfo;
import cn.iaicc.smgk.web.conf.IssueConstants;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditIssueAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(EditIssueAction.class);
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
	
	public Long issueID = null;
	
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
				IssueInfo info = (IssueInfo) ActionContext.getContext().getSession().get("ISSUEINFOEDIT");	
				if(clientID != null) {
					info.setClientID(clientID);					
				}
				if(inquisitionID != null) {
					info.setInquisitionID(inquisitionID);					
				}
				if(issue != null) {
					info.setIssue(issue);					
				}
				if(projectID != null) {
					info.setProjectID(projectID);					
				}				
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
					int pos = startTime.indexOf("T");
					startTime = startTime.substring(pos+1,startTime.length());
					pos = startTime.indexOf("+");
					startTime = startTime.substring(0,pos);
					info.setStartTime(startTime);
				}
				if(endTime != null) {
					int pos = endTime.indexOf("T");
					endTime = endTime.substring(pos+1,endTime.length());
					pos = endTime.indexOf("+");
					endTime = endTime.substring(0,pos);
					info.setEndTime(endTime);
				}
				if(checkTime != null) {					
					info.setCheckTime(Timestamp.valueOf(checkTime+" 00:00:01.000"));
				}		
				issueInfoService.updateIssueInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		
		return SUCCESS;
	}

	// 修改界面
	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}		
			if(issueID == null) {
				this.addActionError("找不到该期次！");
				return ERROR;
			}			
			IssueInfo info = issueInfoService.getIssueInfo(issueID);
			ActionContext.getContext().getSession().put("ISSUEINFOEDIT",info);	
			ActionContext.getContext().getSession().put("TYPE",QuestionTypeConstants.InquisitionTypeDict);
			ActionContext.getContext().getSession().put("ACTIONS",IssueConstants.actionsMap);
			ActionContext.getContext().getSession().put("STATUS",IssueConstants.statusMap);
			
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);//初始化省份信息
			}
			
			Long selectClientID = null;
			if(clientID!=null){
				selectClientID = clientID;
			}else{
				if(clientInfoList.size()>0){
					ClientInfo ci = clientInfoList.get(0);
					if(ci!=null && ci.getClientID()!=null){
						selectClientID = ci.getClientID();

					}
				}
			}
			ActionContext.getContext().put("CLIENTVALUE",selectClientID);
			logger.debug("startDay:"+info.getStartDay()+"|endDay:"+info.getEndDay()+"|startTime:"+info.getStartTime()+"|endTime:"+info.getEndTime()+"|year:"+info.getYear()+"|isFirst:"+info.getIsFirst());			
			
			
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

	public Long getIssueID() {
		return issueID;
	}

	public void setIssueID(Long issueID) {
		this.issueID = issueID;
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

	public void setInquisitionInfoList(List<InquisitionInfo> inquisitionInfoList) {
		this.inquisitionInfoList = inquisitionInfoList;
	}

	public void setProjectInfoList(List<ProjectInfo> projectInfoList) {
		this.projectInfoList = projectInfoList;
	}


}
