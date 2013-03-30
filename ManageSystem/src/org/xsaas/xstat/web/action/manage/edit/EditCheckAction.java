package org.xsaas.xstat.web.action.manage.edit;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;

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

public class EditCheckAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453855886740013266L;
	private static Log logger = LogFactory.getLog(EditCheckAction.class);

	private ICheckDetailInfoService checkDetailInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IProjectInfoService projectInfoService = null;
	private IClientInfoService clientInfoService = null;
	
	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}


	private Long inquisitionID = null;
	private Long clientID = null;
	private Long projectID = null;
	private Long issueID = null;
	private String what = null;
	private String enWhat = null;
	private Integer type = null;
	private Integer status = null;

	private Long checkDetailID = null;
	
	private List<InquisitionInfo> inquisitionList = new LinkedList<InquisitionInfo>();
	private List<IssueInfo> issueList = new LinkedList<IssueInfo>();
	private List<ProjectInfo> projectList = new LinkedList<ProjectInfo>();
	
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
				CheckDetailInfo info =  (CheckDetailInfo) ActionContext.getContext().getSession().get("CHECKEDIT");
				info.setInquisitionID(inquisitionID);
				info.setClientID(clientID);
				info.setProjectID(projectID);
				info.setIssueID(issueID);
				info.setEnWhat(enWhat);
				info.setWhat(what);
				info.setType(type);
				checkDetailInfoService.updateCheckDetailInfo(info);
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
			if(checkDetailID == null) {
				this.addActionError("checkDetailID为空！");
				return ERROR;
			}
			CheckDetailInfo info = checkDetailInfoService.getCheckDetailInfo(checkDetailID);
			ActionContext.getContext().getSession().put("CHECKEDIT",info);
			
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);//初始化省份信息
			}
			long selectClientID = 0;
			if(clientID != null){
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
			
			inquisitionList = inquisitionInfoService.getInquisitionInfoList(selectClientID);
			projectList = projectInfoService.getProjectInfoList(selectClientID);
			ActionContext.getContext().getSession().put("INQUISITIONLIST",inquisitionList);//调查问卷集合列表
			ActionContext.getContext().getSession().put("PROJECTLIST",projectList);
			
			long selectInquisitionID = 0;
			InquisitionInfo ii = null;
			if(inquisitionID !=null){
				selectInquisitionID = inquisitionID.longValue();
			}else{
				if(inquisitionList.size()>0){
					ii = inquisitionList.get(0);
					if(ii!=null){
						selectInquisitionID = ii.getInquisitionID().longValue();
					}
				}
			}		
			
			long selectProjectID = 0;
			if(projectID == null){//判断有无值  没有赋值
				if(projectList.size()>0){
					ProjectInfo pi = projectList.get(0);
					if(pi!=null){
						selectProjectID = pi.getProjectID().longValue();
					}
				}else{
					this.addActionMessage("请添加期次信息!");
					return ERROR;
				}
			}else{
				selectProjectID = projectID.longValue();
			}
			
			issueList = issueInfoService.getList(selectProjectID, selectInquisitionID);
			ActionContext.getContext().getSession().put("ISSUELIST",issueList);
			
			ActionContext.getContext().getSession().put("TYPE",QuestionTypeConstants.CheckDict);			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		


		return SUCCESS;
	}			

	public Long getInquisitionID() {
		return inquisitionID;
	}


	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}


	public String getWhat() {
		return what;
	}


	public void setWhat(String what) {
		this.what = what;
	}


	public String getEnWhat() {
		return enWhat;
	}


	public void setEnWhat(String enWhat) {
		this.enWhat = enWhat;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public void setCheckDetailInfoService(
			ICheckDetailInfoService checkDetailInfoService) {
		this.checkDetailInfoService = checkDetailInfoService;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
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


	public Long getProjectID() {
		return projectID;
	}


	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	public Long getCheckDetailID() {
		return checkDetailID;
	}

	public void setCheckDetailID(Long checkDetailID) {
		this.checkDetailID = checkDetailID;
	}

	public List<InquisitionInfo> getInquisitionList() {
		return inquisitionList;
	}

	public List<IssueInfo> getIssueList() {
		return issueList;
	}

	public List<ProjectInfo> getProjectList() {
		return projectList;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}

	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}

	public void setProjectInfoService(IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

}
