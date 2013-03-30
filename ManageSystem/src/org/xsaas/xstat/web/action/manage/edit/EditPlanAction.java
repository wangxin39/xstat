package org.xsaas.xstat.web.action.manage.edit;


import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.PlanStatusConstants;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IClientAccountInfoService;
import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInformantInfoService;
import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.business.IPlanInfoService;
import org.xsaas.xstat.business.IProjectInfoService;
import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InformantInfo;
import org.xsaas.xstat.po.IssueInfo;
import org.xsaas.xstat.po.PlanInfo;
import org.xsaas.xstat.po.ProjectInfo;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditPlanAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8214185261887712162L;
	private static Log logger = LogFactory.getLog(EditPlanAction.class);
	private IPlanInfoService planInfoService = null;
	private IClientAccountInfoService clientAccountInfoService = null;
	private ISmgkInfoService smgkInfoService = null;
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
	private String startDay = null;
	private String endDay = null;
	private String startTime = null;
	private String endTime = null;
	private String name = null;
	private Integer round = null;
	private Integer weightPattern = null;
	private Integer planType = null;
	
	public Integer getWeightPattern() {
		return weightPattern;
	}
	public void setWeightPattern(Integer weightPattern) {
		this.weightPattern = weightPattern;
	}
	
	private Map<Long,String> issueMap = new HashMap<Long,String>();
	private List<InformantInfo> inList = new LinkedList<InformantInfo>();
	private Long planID = null;
	
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
				PlanInfo info = (PlanInfo) ActionContext.getContext().getSession().get("PLANEDIT");
				IssueInfo ii = (IssueInfo) ActionContext.getContext().getSession().get("ISSUESELECT");
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
				if(jobID == null){
					ActionContext.getContext().getSession().put("typeError","任务编号不能为空！且规则是期次＋项目编号！");
					return INPUT;
				}
				planInfoService.updatePlanInfo(info);
				
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		
		return SUCCESS;
		
	}
	
	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
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
			ActionContext.getContext().getSession().put("PLANEDIT",info);
			if(info!=null && info.getSmgkID()!=null){
				SmgkInfo smgkInfo = smgkInfoService.getSmgkInfo(info.getSmgkID());
				ActionContext.getContext().put("SMGKID",info.getSmgkID());
				ActionContext.getContext().getSession().put("SMGKSELECT",smgkInfo.getUserName());
			}
			ActionContext.getContext().getSession().put("STATUS",StatusConstants.PlanStatusDict);			
			
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			IssueInfo ii = null;
			Long clientID = null;
			long selectID = 0;
			if(issueID == null){//判断有无值  没有赋值
				List<IssueInfo> iList = issueInfoService.getIssueInfoList();
				for(IssueInfo issueInfo : iList){
					ProjectInfo pi = projectInfoService.getProjectInfo(issueInfo.getProjectID());
					if(pi!=null){
						issueMap.put(issueInfo.getIssueID(),pi.getName()+"|"+issueInfo.getIssue());
					}else{
						issueMap.put(issueInfo.getIssueID(),issueInfo.getIssue());
					}
					ActionContext.getContext().getSession().put("ISSUELIST",issueMap);
				}
				
				if(iList.size() > 0){
					ii = iList.get(0);
					if(ii!=null){
						selectID = ii.getIssueID().longValue();

						//ActionContext.getContext().put("ISSUEVALUE",ii);
					}
				}else{
					this.addActionMessage("请添加期次信息!");
					return INPUT;
				}
				
			}else{
				selectID = issueID.longValue();
			}
			ii = issueInfoService.getIssueInfo(selectID);
			ActionContext.getContext().getSession().put("ISSUESELECT",ii);//添加时候调用

			// 根据当前选择的其次所属客户,默任
			clientID = ii.getClientID();
			
			
			inList = informantInfoService.getInformantInfoList(clientID);//获取调查对象中信息
			ActionContext.getContext().getSession().put("INFORSELECT",inList);
			ActionContext.getContext().getSession().put("ROUND",QuestionTypeConstants.RoundDict);
			ActionContext.getContext().getSession().put("WEIFHT",PlanStatusConstants.weightDict);
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}


		return SUCCESS;
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
	public Long getPlanID() {
		return planID;
	}
	public void setPlanID(Long planID) {
		this.planID = planID;
	}
	public Map<Long, String> getIssueMap() {
		return issueMap;
	}
	public List<InformantInfo> getInList() {
		return inList;
	}
	public void setClientAccountInfoService(
			IClientAccountInfoService clientAccountInfoService) {
		this.clientAccountInfoService = clientAccountInfoService;
	}
	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
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
