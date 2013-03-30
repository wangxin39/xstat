package org.xsaas.xstat.web.action.manage.edit;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IInquisitionTemplateInfoService;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.InquisitionTemplateInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditMakeExamAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8122202414454388824L;
	private static Log logger = LogFactory.getLog(EditMakeExamAction.class);
	private IInquisitionInfoService inquisitionInfoService = null;
	private IClientInfoService clientInfoService = null;
	private IInquisitionTemplateInfoService inquisitionTemplateInfoService = null;

	private Long clientID = null;
	private Long templateID = null;
	private String title = null;
	private Integer inquisitionStatus = null;

	private Long inquisitionID = null;
	
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			InquisitionInfo info = (InquisitionInfo) ActionContext.getContext().getSession().get("INQUISITIONEDIT");
			if(info != null) {			
				if(clientID != null) {
					info.setClientID(clientID);									
				}
				if(title != null) {
					info.setTitle(title);					
				}
				if(templateID != null) {
					info.setTemplateID(templateID);					
				}
				if(inquisitionStatus != null) {
					info.setInquisitionStatus(inquisitionStatus);					
				}
				inquisitionInfoService.updateInquisitionInfo(info);
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
			if(inquisitionID == null) {
				this.addActionError("编号为空！");
				return ERROR;
			}
			List<InquisitionTemplateInfo> tList = inquisitionTemplateInfoService.getInquisitionTemplateInfoList(); 
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);//初始化省份信息
			}	
			ActionContext.getContext().getSession().put("TEMPLATELIST",tList);
			ActionContext.getContext().getSession().put("STATUS",StatusConstants.InStatusDict);
		
			InquisitionInfo info = inquisitionInfoService.getInquisitionInfo(inquisitionID);
			ActionContext.getContext().getSession().put("INQUISITIONEDIT",info);
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		

		return SUCCESS;
	}		

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}

	
	public Long getClientID() {
		return clientID;
	}
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public Long getTemplateID() {
		return templateID;
	}
	public void setTemplateID(Long templateID) {
		this.templateID = templateID;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getInquisitionStatus() {
		return inquisitionStatus;
	}

	public void setInquisitionStatus(Integer inquisitionStatus) {
		this.inquisitionStatus = inquisitionStatus;
	}

	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public void setInquisitionTemplateInfoService(
			IInquisitionTemplateInfoService inquisitionTemplateInfoService) {
		this.inquisitionTemplateInfoService = inquisitionTemplateInfoService;
	}
}
