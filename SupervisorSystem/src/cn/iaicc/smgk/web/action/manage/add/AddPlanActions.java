package cn.iaicc.smgk.web.action.manage.add;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IClientAccountInfoService;
import cn.iaicc.smgk.business.IClientInfoService;
import cn.iaicc.smgk.business.IInformantInfoService;
import cn.iaicc.smgk.business.IIssueInfoService;
import cn.iaicc.smgk.business.IPlanInfoService;
import cn.iaicc.smgk.business.IProjectInfoService;
import cn.iaicc.smgk.business.ISmgkInfoService;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.po.IssueInfo;
import cn.iaicc.smgk.po.PlanInfo;
import cn.iaicc.smgk.po.ProjectInfo;
import cn.iaicc.smgk.web.conf.IssueConstants;
import cn.iaicc.smgk.web.conf.PlanStatusConstants;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddPlanActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8214185261887712162L;
	private static Log logger = LogFactory.getLog(AddPlanActions.class);
	private IPlanInfoService planInfoService = null;
	private IClientAccountInfoService clientAccountInfoService = null;
	private IClientInfoService clientInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IProjectInfoService projectInfoService = null;

	
	private Long smgkID = null;
	private Long clientID = null;
	private Long projectID = null;
	private Long issueID = null;
	private Long informantID = null;
	private String jobID = null;
	private Integer status = null;
	private String startDay = null;
	private String endDay = null;
	private String startTime = null;
	private String endTime = null;
	private String name = null;
	private Integer round = null;
	private Integer weightPattern = null;
	private Integer planType = null;
	
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
				PlanInfo info = new PlanInfo();
				IssueInfo ii = (IssueInfo) ActionContext.getContext().getSession().get("ISSUESELECT");
				
				if(smgkID == null){
					this.addActionMessage("请添加神秘顾客!");
					return INPUT;
				}
				if(informantID == null){
					this.addActionMessage("请添加调查对象!");
					return INPUT;
				}
				if(issueID == null){
					this.addActionMessage("请添加期次信息!");
					return INPUT;
				}
				

				info.setClientID(ii.getClientID());
				if(smgkID != null) {
					info.setSmgkID(smgkID);					
				}
				if(informantID != null) {
					info.setInformantID(informantID);					
				}
				if(issueID != null) {
					info.setIssueID(issueID);					
				}
				if(jobID != null) {
					info.setJobID(jobID);					
				}
				if(ii != null && ii.getProjectID() != null) {
					info.setProjectID(ii.getProjectID());					
				}
				if(startDay != null) {
					info.setStartDay(Timestamp.valueOf(startDay+" 00:00:00.0"));					
				}
				if(endDay != null) {
					info.setEndDay(Timestamp.valueOf(endDay+" 00:00:00.0"));					
				}
				if(startTime != null) {
					info.setStartTime(startTime);					
				}
				if(endTime != null) {
					info.setEndTime(endTime);					
				}
				if(weightPattern != null) {
					info.setWeightPattern(weightPattern);					
				}
				if(round != null) {
					info.setRound(round);					
				}
				if(name != null) {
					info.setName(name);					
				}
				if(planType != null) {
					info.setPlanType(planType);
				}
				info.setCheckStatus(StatusConstants.PZHENGZAIJIANCE);
				info.setChartStatus(IssueConstants.NOT_STATUS);
				info.setEvaluationStatus(IssueConstants.NOT_STATUS);
				info.setReportStatus(IssueConstants.NOT_STATUS);
				info.setStatStatus(IssueConstants.NOT_STATUS);
				info.setStatus(StatusConstants.ZHENGCHANG);
				if(jobID == null){
					this.addActionError("任务编号不能为空！");
					return INPUT;
				}
				planInfoService.savePlanInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		
		}catch(Exception e){
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			ActionContext.getContext().getSession().put("GLOBALROUNDDICT",QuestionTypeConstants.RoundDict);
			ActionContext.getContext().getSession().put("GLOBALWEIFHTDICT",PlanStatusConstants.weightDict);			
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			IssueInfo ii = null;
			Long selectID = null;
			if(issueID == null){ //判断有无值  没有赋值
				List<IssueInfo> issueInfoList = issueInfoService.getIssueInfoList();
				if(issueInfoList != null) {
					Map<Long,String> issueMap = new HashMap<Long,String>();
					for(IssueInfo issueInfo : issueInfoList){
						ProjectInfo pi = projectInfoService.getProjectInfo(issueInfo.getProjectID());
						if(pi!=null){
							issueMap.put(issueInfo.getIssueID(),pi.getName()+"|"+issueInfo.getIssue());
						}else{
							issueMap.put(issueInfo.getIssueID(),issueInfo.getIssue());
						}
						ActionContext.getContext().getSession().put("GLOBALISSUEMAP",issueMap);
					}					
					if(issueInfoList.size() > 0){
						ii = issueInfoList.get(0);
						if(ii!=null){
							selectID = ii.getIssueID();
						}
					}					
				}				
			}else{
				selectID = issueID;
			}
			ii = issueInfoService.getIssueInfo(selectID);
			ActionContext.getContext().getSession().put("ISSUESELECT",ii);//添加时候调用
			if(ii != null && ii.getClientID() != null) {
				// 根据当前选择的其次所属客户,默任				
				 List<InformantInfo> informantInfoList = informantInfoService.getInformantInfoList(ii.getClientID());//获取调查对象中信息
				ActionContext.getContext().getSession().put("GLOBALINFORMANTINFOLIST",informantInfoList);				
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}	
	public Integer getWeightPattern() {
		return weightPattern;
	}
	public void setWeightPattern(Integer weightPattern) {
		this.weightPattern = weightPattern;
	}
	
	public Long getSmgkID() {
		return smgkID;
	}

	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
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

	public Long getIssueID() {
		return issueID;
	}

	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}

	public Long getInformantID() {
		return informantID;
	}
	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}
	public String getJobID() {
		return jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	public void setPlanInfoService(IPlanInfoService planInfoService) {
		this.planInfoService = planInfoService;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRound() {
		return round;
	}
	public void setRound(Integer round) {
		this.round = round;
	}
	public Integer getPlanType() {
		return planType;
	}
	public void setPlanType(Integer planType) {
		this.planType = planType;
	}
	public void setClientAccountInfoService(
			IClientAccountInfoService clientAccountInfoService) {
		this.clientAccountInfoService = clientAccountInfoService;
	}
	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}
	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}
	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}
	public void setProjectInfoService(IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}



}
