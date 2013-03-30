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
import cn.iaicc.smgk.business.IRealityCheckInfoService;
import cn.iaicc.smgk.po.ClientInfo;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.InquisitionInfo;
import cn.iaicc.smgk.po.IssueInfo;
import cn.iaicc.smgk.po.ProjectInfo;
import cn.iaicc.smgk.po.RealityCheckInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditRealityAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453855886740013266L;
	private static Log logger = LogFactory.getLog(EditRealityAction.class);
	private IRealityCheckInfoService realityCheckInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IProjectInfoService projectInfoService = null;
	private IClientInfoService clientInfoService = null;


	private Long inquisitionID = null;
	private Timestamp addTime = null;
	private Long clientID = null;
	private Long projectID = null;
	private Long issueID = null;
	private String thisTime = null;
	private String enThisTime = null;
	private String soFarTime = null;
	private String enSoFarTime = null;
	private String markReal = null;
	private String enMarkReal = null;

	private List<InquisitionInfo> inquisitionList = new LinkedList<InquisitionInfo>();
	private List<IssueInfo> issueList = new LinkedList<IssueInfo>();
	private List<ProjectInfo> projectList = new LinkedList<ProjectInfo>();	
	
	private Long realityCheckID = null;
	
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
				RealityCheckInfo info = (RealityCheckInfo) ActionContext.getContext().getSession().get("REALITYEDIT");
				
				info.setAddTime(new Timestamp(System.currentTimeMillis()));
				info.setInquisitionID(inquisitionID);
				info.setClientID(clientID);
				info.setProjectID(projectID);
				info.setIssueID(issueID);
				info.setEnMarkReal(enMarkReal);
				info.setEnSoFarTime(enSoFarTime);
				info.setEnThisTime(enThisTime);
				info.setThisTime(thisTime);
				info.setSoFarTime(soFarTime);
				info.setMarkReal(markReal);
				realityCheckInfoService.updateRealityCheckInfo(info);
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
			
			if(realityCheckID == null) {
				this.addActionError("编号为空！");
				return ERROR;
			}
			RealityCheckInfo info = realityCheckInfoService.getRealityCheckInfo(realityCheckID);
			ActionContext.getContext().getSession().put("REALITYEDIT",info);
			ActionContext.getContext().getSession().put("STATUS",StatusConstants.StatusDict);
			
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


	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public String getThisTime() {
		return thisTime;
	}


	public void setThisTime(String thisTime) {
		this.thisTime = thisTime;
	}


	public String getEnThisTime() {
		return enThisTime;
	}


	public void setEnThisTime(String enThisTime) {
		this.enThisTime = enThisTime;
	}


	public String getSoFarTime() {
		return soFarTime;
	}


	public void setSoFarTime(String soFarTime) {
		this.soFarTime = soFarTime;
	}


	public String getEnSoFarTime() {
		return enSoFarTime;
	}


	public void setEnSoFarTime(String enSoFarTime) {
		this.enSoFarTime = enSoFarTime;
	}


	public String getMarkReal() {
		return markReal;
	}


	public void setMarkReal(String markReal) {
		this.markReal = markReal;
	}


	public String getEnMarkReal() {
		return enMarkReal;
	}


	public void setEnMarkReal(String enMarkReal) {
		this.enMarkReal = enMarkReal;
	}


	public void setRealityCheckInfoService(
			IRealityCheckInfoService realityCheckInfoService) {
		this.realityCheckInfoService = realityCheckInfoService;
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

	public Long getRealityCheckID() {
		return realityCheckID;
	}

	public void setRealityCheckID(Long realityCheckID) {
		this.realityCheckID = realityCheckID;
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
