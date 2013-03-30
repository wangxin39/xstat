package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IProjectInfoService;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.ProjectInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListProjectAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4749480355407371401L;
	private static Log logger = LogFactory.getLog(ListProjectAction.class);
	private IClientInfoService clientInfoService = null;

	private IProjectInfoService projectInfoService = null;
	private List<ClientInfo> clientList = null;
	private List<String> statusList = null;
	private List<String> clientInfoList = new LinkedList<String>();
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<ProjectInfo> pageList = null;	
	private PaginationUtil pu = null;	
	public Long projectID = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		int page = 1;
		if(num != null) {
			page = num.intValue();
		}
		
		int total = projectInfoService.getProjectInfoTotal();
		pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
		pageList = projectInfoService.findProjectInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);	
		
		clientList = new LinkedList<ClientInfo>();
		statusList = new LinkedList<String>();
		for(ProjectInfo info:pageList)
		{
			if(info.getClientID() != null) {
				ClientInfo ci = clientInfoService.getClientInfo(info.getClientID());
				clientInfoList.add(""+ci.getCompany());				
			}else{
				clientInfoList.add("");
			}
			
			if(info.getStatus() != null) {
				statusList.add(""+StatusConstants.CStatusDict.get(info.getStatus()));				
			}else{
				statusList.add("");
			}
		}	
		
		return SUCCESS;
	}		
	
	public String detail() throws Exception {
		if(projectID == null){
			this.addActionError("编号为空！");
			return ERROR;
		}
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			ProjectInfo pi = projectInfoService.getProjectInfo(projectID);
			if(pi != null){
				ActionContext.getContext().put("PROJECTINFO", pi);
			}
			
			ClientInfo ci = clientInfoService.getClientInfo(pi.getClientID());	
			if(ci != null && pi.getClientID() != null) {
						
				ActionContext.getContext().put("COMPANYNAME", ci.getCompany());
			}else{
				ActionContext.getContext().put("COMPANYNAME","");
			}
			
			if(pi.getStatus() != null) {
				ActionContext.getContext().put("STATUS", StatusConstants.CStatusDict.get(pi.getStatus()));
			}else{
				ActionContext.getContext().put("STATUS","");
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}			
		

		return SUCCESS;
	}
	


	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public void setProjectInfoService(IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}


	public List<ProjectInfo> getPageList() {
		return pageList;
	}

	public void setPageList(List<ProjectInfo> pageList) {
		this.pageList = pageList;
	}

	public List<ClientInfo> getClientList() {
		return clientList;
	}

	public void setClientList(List<ClientInfo> clientList) {
		this.clientList = clientList;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public Long getProjectID() {
		return projectID;
	}

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	public PaginationUtil getPu() {
		return pu;
	}

	public List<String> getClientInfoList() {
		return clientInfoList;
	}

	public void setClientInfoList(List<String> clientInfoList) {
		this.clientInfoList = clientInfoList;
	}

}
