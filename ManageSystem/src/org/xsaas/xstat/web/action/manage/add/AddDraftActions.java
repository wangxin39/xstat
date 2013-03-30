package org.xsaas.xstat.web.action.manage.add;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IAddressCatalogInfoService;
import org.xsaas.xstat.business.IEmailAddressInfoService;
import org.xsaas.xstat.business.IEmailDraftInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.po.AddressCatalogInfo;
import org.xsaas.xstat.po.EmailAddressInfo;
import org.xsaas.xstat.po.EmailDraftInfo;
import org.xsaas.xstat.po.EmployeeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddDraftActions extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2907110765258863578L;
	private static Log logger = LogFactory.getLog(AddDraftActions.class);
	private IEmailDraftInfoService emailDraftInfoService = null;
	private IAddressCatalogInfoService addressCatalogInfoService = null;
	private IEmailAddressInfoService emailAddressInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	private List<String> eList = new LinkedList<String>();
	private List<String> eaList = new LinkedList<String>();
	private List<String> acList = new LinkedList<String>();
	private Long addressID = null;
	private Long acID = null;
	private Long employeeID = null;
	private String sendTo = null;
	private String att = null;
	private String topic = null;
	private String content = null;

	private Long draftID = null;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				if(addressID == null){
					ActionContext.getContext().put("nullError","通讯录名不能为空，请先添加通讯录信息!");
					return INPUT;
				}
				if(acID == null){
					ActionContext.getContext().put("nullError","分类名称不能为空，请先添加分类信息!");
					return INPUT;
				}
				EmailDraftInfo info = new EmailDraftInfo();
				info.setAcID(acID);
				info.setAddressID(addressID);
				info.setAtt(att);
				info.setContent(content);
				info.setEmployeeID(employeeID);
				info.setSendTime(new Timestamp(System.currentTimeMillis()));
				info.setSendTo(sendTo);
				info.setTopic(topic);
				info.setStatus(StatusConstants.ZHENGCHANG);
				emailDraftInfoService.saveEmailDraftInfo(info);
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
			List<EmployeeInfo> eList = employeeInfoService.getEmployeeInfoList();
			List<EmailAddressInfo> eaList = emailAddressInfoService.getEmailAddressInfoList();
			List<AddressCatalogInfo> acList = addressCatalogInfoService.getAddressCatalogInfoList();
			ActionContext.getContext().getSession().put("EMPLOYEESELECT",eList);
			ActionContext.getContext().getSession().put("EMAILSELEST",eaList);
			ActionContext.getContext().getSession().put("CATALOGSELECT",acList);
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		

		return SUCCESS;
	}	
	
	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}
	public List<String> getEList() {
		return eList;
	}

	public void setEList(List<String> list) {
		eList = list;
	}



	public List<String> getEaList() {
		return eaList;
	}

	public void setEaList(List<String> eaList) {
		this.eaList = eaList;
	}

	public List<String> getAcList() {
		return acList;
	}

	public void setAcList(List<String> acList) {
		this.acList = acList;
	}

	public Long getAddressID() {
		return addressID;
	}

	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	public Long getAcID() {
		return acID;
	}

	public void setAcID(Long acID) {
		this.acID = acID;
	}


	public void setEmailDraftInfoService(
			IEmailDraftInfoService emailDraftInfoService) {
		this.emailDraftInfoService = emailDraftInfoService;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getAtt() {
		return att;
	}

	public void setAtt(String att) {
		this.att = att;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	public Long getDraftID() {
		return draftID;
	}
	public void setDraftID(Long draftID) {
		this.draftID = draftID;
	}
	public void setAddressCatalogInfoService(
			IAddressCatalogInfoService addressCatalogInfoService) {
		this.addressCatalogInfoService = addressCatalogInfoService;
	}
	public void setEmailAddressInfoService(
			IEmailAddressInfoService emailAddressInfoService) {
		this.emailAddressInfoService = emailAddressInfoService;
	}
}
