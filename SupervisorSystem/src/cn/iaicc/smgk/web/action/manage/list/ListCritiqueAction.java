package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IClientInfoService;
import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IInformantInfoService;
import cn.iaicc.smgk.business.IInquisitionInfoService;
import cn.iaicc.smgk.business.IIssueInfoService;
import cn.iaicc.smgk.business.IPartInfoService;
import cn.iaicc.smgk.business.IProjectInfoService;
import cn.iaicc.smgk.business.IRemarkInfoService;
import cn.iaicc.smgk.po.ClientInfo;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.po.InquisitionInfo;
import cn.iaicc.smgk.po.IssueInfo;
import cn.iaicc.smgk.po.PartInfo;
import cn.iaicc.smgk.po.RemarkInfo;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListCritiqueAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 179282249083478153L;
	private static Log logger = LogFactory.getLog(ListCritiqueAction.class);
	private IRemarkInfoService remarkInfoService = null;
	private IPartInfoService partInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IClientInfoService clientInfoService = null;
	private IProjectInfoService projectInfoService = null;
	
	private List<String> partList = new LinkedList<String>();
	private List<String> iiList = new LinkedList<String>();
	private List<String> eiList = new LinkedList<String>();
	
	private Long inquisitionID = null;
	private Long clientID = null;
	
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<RemarkInfo> pageList = null;
	
	private PaginationUtil pu = null;	
	
	private Long remarkID = null;
	
			
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
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);
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
				total = remarkInfoService.getRemarkInfoTotal(selectClientID);
			}else{
				total = remarkInfoService.getRemarkInfoTotal();
			}
			
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			if(selectClientID !=0){
				pageList = remarkInfoService.findRemarkInfoByPage(selectClientID,pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = remarkInfoService.findRemarkInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}
			
			for(RemarkInfo info:pageList){
				PartInfo pInfo = partInfoService.getPartInfo(info.getPartID());
				EmployeeInfo ei = employeeInfoService.getEmployeeInfo(info.getEmployeeID());
				InquisitionInfo ii = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());
				if(ei!=null && ei.getName()!=null){
					eiList.add(""+ei.getName());
				}else{
					eiList.add("");
				}
				if(ii!=null && ii.getTitle()!=null){
					iiList.add(""+ii.getTitle());
				}else{
					iiList.add("");
				}
				if(pInfo != null && pInfo.getName()!=null){
					partList.add(""+pInfo.getName());
				}else{
					partList.add("");
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
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(remarkID == null) {
				this.addActionError("id为空！");
				return ERROR;
			}
			RemarkInfo info = remarkInfoService.getRemarkInfo(remarkID);
			if(info!=null){
				ActionContext.getContext().put("REMAEKETAIL",info);
			}
			EmployeeInfo ei = employeeInfoService.getEmployeeInfo(info.getEmployeeID());
			InquisitionInfo ii = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());
			PartInfo pi = partInfoService.getPartInfo(info.getPartID());
			if(ei!=null && ei.getName()!=null){
				ActionContext.getContext().put("EMPLOYEE",ei.getName());		
			}
			if(ii!=null && ii.getTitle()!=null){
				ActionContext.getContext().put("INQUISITION",ii.getTitle());
			}
			if(pi!=null && pi.getName()!=null){
				ActionContext.getContext().put("PARTSELECT",pi.getName());
			}
			if(info.getStatus()!=null){
				ActionContext.getContext().put("STATUS",StatusConstants.RemarkDict.get(info.getStatus()));
			}
			InformantInfo ifi = informantInfoService.getInformantInfo(info.getInformantID());
			IssueInfo iii = issueInfoService.getIssueInfo(info.getIssueID());
			if(iii!=null && iii.getIssue()!=null){
				ActionContext.getContext().put("ISSUE",iii.getIssue());
			}
			if(ifi!=null && ifi.getName()!=null){
				ActionContext.getContext().put("INFORMANT",ifi.getName());
			}
			ClientInfo ci = clientInfoService.getClientInfo(info.getClientID());
			cn.iaicc.smgk.po.ProjectInfo piInfo = projectInfoService.getProjectInfo(info.getProjectID());
			if(ci!=null && ci.getCompany()!=null){
				ActionContext.getContext().put("CLIENT",ci.getCompany());
			}
			if(piInfo!=null && piInfo.getName()!=null){
				ActionContext.getContext().put("PROJECT",piInfo.getName());
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
	
		return SUCCESS;
	}		
		
	
	public Long getRemarkID() {
		return remarkID;
	}

	public void setRemarkID(Long remarkID) {
		this.remarkID = remarkID;
	}
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public void setRemarkInfoService(IRemarkInfoService remarkInfoService) {
		this.remarkInfoService = remarkInfoService;
	}

	public List<String> getPartList() {
		return partList;
	}


	public void setPartList(List<String> partList) {
		this.partList = partList;
	}


	public List<String> getIiList() {
		return iiList;
	}


	public void setIiList(List<String> iiList) {
		this.iiList = iiList;
	}


	public List<String> getEiList() {
		return eiList;
	}


	public void setEiList(List<String> eiList) {
		this.eiList = eiList;
	}


	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}


	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}


	public List<RemarkInfo> getPageList() {
		return pageList;
	}

	public PaginationUtil getPu() {
		return pu;
	}
	public void setPageList(List<RemarkInfo> pageList) {
		this.pageList = pageList;
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


	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}


	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}

	public Long getClientID() {
		return clientID;
	}


	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}


	public void setProjectInfoService(IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}
}
