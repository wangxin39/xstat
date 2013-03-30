package org.xsaas.xstat.web.action.manage.add;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IInquisitionTemplateInfoService;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.InquisitionTemplateInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddMakeExamActions extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8122202414454388824L;
	private static Log logger = LogFactory.getLog(AddMakeExamActions.class);
	private IInquisitionInfoService inquisitionInfoService = null;
	private IClientInfoService clientInfoService = null;
	private IInquisitionTemplateInfoService inquisitionTemplateInfoService = null;

	private Long clientID = null;
	private Long templateID = null;
	private Integer status = null;
	private String title = null;

	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			if(clientID == null){
				ActionContext.getContext().put("nullError","客户名称不能为空，请先添加客户信息!");
				return INPUT;
			}
			if(templateID == null){
				ActionContext.getContext().put("nullError","模板名称不能为空，请先添加模板信息!");
				return INPUT;
			}			
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				InquisitionInfo info = new InquisitionInfo();
				if(clientID != null) {
					info.setClientID(clientID);									
				}
				if(title != null) {
					info.setTitle(title);					
				}
				if(templateID != null) {
					info.setTemplateID(templateID);					
				}
				
				info.setInquisitionStatus(StatusConstants.ZHENGZAIZUJUAN);
				info.setStatus(StatusConstants.ZHENGCHANG);
				inquisitionInfoService.saveInquisitionInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
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
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			List<InquisitionTemplateInfo> tList = inquisitionTemplateInfoService.getInquisitionTemplateInfoList(); 
			List<ClientInfo> clList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clList == null) {
				clList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clList);
			}
			ActionContext.getContext().getSession().put("TEMPLATELIST",tList);
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}
	public void setInquisitionTemplateInfoService(
			IInquisitionTemplateInfoService inquisitionTemplateInfoService) {
		this.inquisitionTemplateInfoService = inquisitionTemplateInfoService;
	}

}
