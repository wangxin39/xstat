package cn.iaicc.smgk.web.action.manage.list;

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
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListRealityAction extends ActionSupport {
	private static final long serialVersionUID = 179282249083478153L;
	private static Log logger = LogFactory.getLog(ListRealityAction.class);
	private IRealityCheckInfoService realityCheckInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IProjectInfoService projectInfoService = null;
	private IClientInfoService clientInfoService = null;

	private Long inquisitionID = null;
	
	private List<String> iiList = new LinkedList<String>();
	private List<InquisitionInfo> inquisitionList = new LinkedList<InquisitionInfo>();
	private List<IssueInfo> issueList = new LinkedList<IssueInfo>();
	private List<ProjectInfo> projectList = new LinkedList<ProjectInfo>();
	private Long issueID = null;
	private Long clientID = null;
	private Long projectID = null;
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<RealityCheckInfo> pageList = null;
	
	private PaginationUtil pu = null;	
	
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
			
			int total = 0;
			if(selectClientID !=0){
				total = realityCheckInfoService.getRealityCheckInfoTotal(selectClientID);
			}else{
				total = realityCheckInfoService.getRealityCheckInfoTotal();
			}
			
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);

			if(selectClientID !=0){
				pageList = realityCheckInfoService.findRealityCheckInfoByPage(selectClientID,pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = realityCheckInfoService.findRealityCheckInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}
					
			for(RealityCheckInfo info:pageList){
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
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		if(username == null || password == null) {
			return LOGIN;
		}
		try{
			if(realityCheckID == null) {
				this.addActionError("编号为空！");
				return ERROR;
			}
			RealityCheckInfo info = realityCheckInfoService.getRealityCheckInfo(realityCheckID);
			if(info!=null){
				ActionContext.getContext().put("REALITYDETAIL",info);
			}
			InquisitionInfo ii = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());

			if(ii!=null && ii.getTitle()!=null){
				ActionContext.getContext().put("INQUISITION",ii.getTitle());
			}
			if(info.getStatus()!=null){
				ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));
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

	public List<RealityCheckInfo> getPageList() {
		return pageList;
	}


	public void setPageList(List<RealityCheckInfo> pageList) {
		this.pageList = pageList;
	}


	public Long getRealityCheckID() {
		return realityCheckID;
	}


	public void setRealityCheckID(Long realityCheckID) {
		this.realityCheckID = realityCheckID;
	}


	public void setRealityCheckInfoService(
			IRealityCheckInfoService realityCheckInfoService) {
		this.realityCheckInfoService = realityCheckInfoService;
	}


	public Long getInquisitionID() {
		return inquisitionID;
	}


	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}


	public List<InquisitionInfo> getInquisitionList() {
		return inquisitionList;
	}


	public void setInquisitionList(List<InquisitionInfo> inquisitionList) {
		this.inquisitionList = inquisitionList;
	}


	public List<IssueInfo> getIssueList() {
		return issueList;
	}


	public void setIssueList(List<IssueInfo> issueList) {
		this.issueList = issueList;
	}


	public List<ProjectInfo> getProjectList() {
		return projectList;
	}


	public void setProjectList(List<ProjectInfo> projectList) {
		this.projectList = projectList;
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
