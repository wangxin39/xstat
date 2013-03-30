package org.xsaas.xstat.web.action.manage.edit;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IProjectInfoService;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.ProjectInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditProjectAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4749480355407371401L;
	private static Log logger = LogFactory.getLog(EditProjectAction.class);
	private IProjectInfoService projectInfoService = null;
	private IClientInfoService clientInfoService = null;
	private Long clientID = null;
	private String name = null;
	private String description = null;
	private Integer status = null;
	private String englishName = null;
	
	
	public Long projectID = null;
	
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
				ProjectInfo info = (ProjectInfo) ActionContext.getContext().getSession().get("PROJECTEDIT");
				info.setClientID(clientID);
				info.setDescription(description);
				info.setName(name);
				info.setEnglishName(englishName);
				projectInfoService.updateProjectInfo(info);
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
			if(projectID == null) {
				this.addActionError("编号为空！");
				return ERROR;
			}

			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);//初始化省份信息
			}
			ActionContext.getContext().put("STATUS",StatusConstants.CStatusDict);
			ProjectInfo info = projectInfoService.getProjectInfo(projectID);
			ActionContext.getContext().getSession().put("PROJECTEDIT",info);
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
	
		return SUCCESS;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setProjectInfoService(IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}

	public String getEnglishName() {
		return englishName;
	}


	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public Long getProjectID() {
		return projectID;
	}

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

}
