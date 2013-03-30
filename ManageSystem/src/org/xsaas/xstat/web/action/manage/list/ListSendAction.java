package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IAddressCatalogInfoService;
import org.xsaas.xstat.business.IEmailAddressInfoService;
import org.xsaas.xstat.business.IEmailSendInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.po.AddressCatalogInfo;
import org.xsaas.xstat.po.EmailAddressInfo;
import org.xsaas.xstat.po.EmailSendInfo;
import org.xsaas.xstat.po.EmployeeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListSendAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2907110765258863578L;
	private static Log logger = LogFactory.getLog(ListSendAction.class);
	private IEmailSendInfoService emailSendInfoService = null;
	private IAddressCatalogInfoService addressCatalogInfoService = null;
	private IEmailAddressInfoService emailAddressInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;
	
	
	private List<String> eList = new LinkedList<String>();
	private List<String> eaList = new LinkedList<String>();
	private List<String> acList = new LinkedList<String>();
	private List<String> statusList = new LinkedList<String>();
	private Long sendID = null;
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<EmailSendInfo> pageList = null;

	private PaginationUtil pu = null;		
	
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
			int total = emailSendInfoService.getEmailSendInfoTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = emailSendInfoService.findEmailSendInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			for(EmailSendInfo info:pageList){
				if(pageList != null){
					EmployeeInfo eInfo = employeeInfoService.getEmployeeInfo(info.getEmployeeID());
					EmailAddressInfo eaInfo = emailAddressInfoService.getEmailAddressInfo(info.getAddressID());
					AddressCatalogInfo acInfo = addressCatalogInfoService.getAddressCatalogInfo(info.getAcID());
					if(eInfo != null){
						eaList.add(""+eaInfo.getName());
					}else{
						eaList.add("");
					}
					if(eaInfo != null){
						eList.add(""+eInfo.getName());			
					}else{
						eList.add("");
					}
					if(acInfo != null){
						acList.add(""+acInfo.getName());	
					}else{
						acList.add("");	
					}
					if(info.getStatus() != null){
						statusList.add(""+StatusConstants.StatusDict.get(info.getStatus()));
					}else{
						statusList.add("");
					}
				}else{
					this.addActionMessage("数据库中没有数据!");
				}
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}
	
	public String detail() throws Exception{
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			if(sendID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			EmailSendInfo esi = emailSendInfoService.getEmailSendInfo(sendID);
			if(esi != null){
				ActionContext.getContext().put("SENDDETAIL",esi);
			}
			EmailAddressInfo ai = emailAddressInfoService.getEmailAddressInfo(esi.getAddressID());
			if(ai.getName() != null){
				ActionContext.getContext().put("ADDRESS",ai.getName());
			}
			
			AddressCatalogInfo aci = addressCatalogInfoService.getAddressCatalogInfo(esi.getAcID());
			if(aci.getName() != null){
				ActionContext.getContext().put("CATALOG",aci.getName());
			}
			
			EmployeeInfo ei = employeeInfoService.getEmployeeInfo(esi.getEmployeeID());
			if(ei.getName()!=null){
				ActionContext.getContext().put("EMPLOYEE",ei.getName());
			}
			if(esi.getStatus()!=null){
				ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(esi.getStatus()));
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}

		
		return SUCCESS;
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

	public Long getSendID() {
		return sendID;
	}

	public void setSendID(Long sendID) {
		this.sendID = sendID;
	}

	public List<String> getAcList() {
		return acList;
	}

	public void setAcList(List<String> acList) {
		this.acList = acList;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setEmailSendInfoService(IEmailSendInfoService emailSendInfoService) {
		this.emailSendInfoService = emailSendInfoService;
	}

	public void setAddressCatalogInfoService(
			IAddressCatalogInfoService addressCatalogInfoService) {
		this.addressCatalogInfoService = addressCatalogInfoService;
	}

	public void setEmailAddressInfoService(
			IEmailAddressInfoService emailAddressInfoService) {
		this.emailAddressInfoService = emailAddressInfoService;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}
	
	public List<EmailSendInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<EmailSendInfo> pageList) {
		this.pageList = pageList;
	}

	public PaginationUtil getPu() {
		return pu;
	}
}
