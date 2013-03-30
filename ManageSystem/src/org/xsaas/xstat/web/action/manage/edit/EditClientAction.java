package org.xsaas.xstat.web.action.manage.edit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.EmployeeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditClientAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(EditClientAction.class);
	private IClientInfoService clientInfoService = null;
	private String company = null;
	private String description = null;
	private String enCompany = null;
	private Integer status = null;
	
	public Long clientID = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			ClientInfo info = (ClientInfo) ActionContext.getContext().getSession().get("CLIENTINFOEDIT");
			if(info != null) {
				if(company != null) {
					info.setCompany(company);					
				}
				if(enCompany != null) {
					info.setEnCompany(enCompany);					
				}
				if(description != null) {
					info.setDescription(description);					
				}
				clientInfoService.updateClientInfo(info);			
			}		
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}	
	
	// 修改界面
	@SuppressWarnings("unchecked")
	public String edit() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			if(clientID != null) {
				ClientInfo info = clientInfoService.getClientInfo(clientID);
				ActionContext.getContext().getSession().put("CLIENTINFOEDIT",info);	
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}				
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setClientInfoService(
			IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}


	public String getEnCompany() {
		return enCompany;
	}

	public void setEnCompany(String enCompany) {
		this.enCompany = enCompany;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

}
