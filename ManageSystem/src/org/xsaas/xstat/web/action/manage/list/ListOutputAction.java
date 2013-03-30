package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInformantInfoService;
import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.business.IOutputInfoService;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InformantInfo;
import org.xsaas.xstat.po.IssueInfo;
import org.xsaas.xstat.po.OutputInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListOutputAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127570233615470183L;
	private static Log logger = LogFactory.getLog(ListOutputAction.class);
	private IOutputInfoService outputInfoService = null;

	private IIssueInfoService issueInfoService = null;
	private IClientInfoService clientInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private List<String> issueList = new LinkedList<String>();
	private List<String> informantList = new LinkedList<String>();
	private List<String> clientList = new LinkedList<String>();
	private List<String> statusList = new LinkedList<String>();
	private List<String> typeList = new LinkedList<String>();
	private List<InformantInfo> informantInfoList = new LinkedList<InformantInfo>();
	private Long issueID = null;
	private Long informantID = null;
	private Long outputID = null;
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<OutputInfo> pageList = null;	
	private PaginationUtil pu = null;		
	
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
			
			IssueInfo ii = null;
			long selectIssueID = 0;
			if(issueID != null){
				selectIssueID = issueID.longValue();
			}else{
				List<IssueInfo> iiList = issueInfoService.getIssueInfoList();
				ActionContext.getContext().getSession().put("ISSUELIST", iiList);//期次列表
				if(iiList.size() >0) {
					ii = iiList.get(0);
					if(ii!=null){
						selectIssueID = ii.getInquisitionID();
						ActionContext.getContext().put("ISSUESELECT",selectIssueID);//初始化期次
					}
				}
			}
			informantInfoList = informantInfoService.getInformantInfoList(selectIssueID);
			
			ActionContext.getContext().getSession().put("INFORSELECT",informantInfoList);
			long selectID = 0;
			if(informantID!=null){
				selectID = informantID.longValue();
			}else{
				informantInfoList = informantInfoService.getInformantInfoList();
				if(informantInfoList.size()>0){
					InformantInfo info = informantInfoList.get(0);
					if(info!=null){
						selectID = info.getInformantID().longValue();
					}
				}
			}
			int total = 0;
			if(selectID!=0 && selectIssueID!=0){
				total = outputInfoService.getOutputInfoTotal(selectID,selectIssueID);
			}else{
				total = outputInfoService.getOutputInfoTotal();
			}
			
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			if(selectID!=0 && selectIssueID!=0){
				pageList = outputInfoService.findOutputInfoByPage(selectID,selectIssueID,pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = outputInfoService.findOutputInfoByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			}
			
			for(OutputInfo info:pageList){
				if(pageList != null){

					ii = issueInfoService.getIssueInfo(info.getIssueID());
					InformantInfo ifi = informantInfoService.getInformantInfo(info.getInformantID());
					ClientInfo ci = clientInfoService.getClientInfo(info.getClientID());
					
					if(info.getStatus() != null){
						statusList.add(""+StatusConstants.StatusDict.get(info.getStatus()));
					}else{
						statusList.add("");
					}
					if(ii != null && ii.getIssue()!=null){
						issueList.add(""+ii.getIssue());
					}else{
						issueList.add("");
					}
					if(ifi != null && ifi.getName()!=null){
						informantList.add(""+ifi.getName());
					}else{
						informantList.add("");
					}
					if(ci!=null && ci.getCompany()!=null){
						clientList.add(""+ci.getCompany());
					}else{
						clientList.add("");
					}
					if(info!=null && info.getFileType()!=null){
						typeList.add(""+QuestionTypeConstants.ExportTypeDict.get(info.getFileType()));
					}else{
						typeList.add("");
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
	public String detail() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}

			if(outputID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			OutputInfo info = outputInfoService.getOutputInfo(outputID);
			IssueInfo ii = issueInfoService.getIssueInfo(info.getIssueID());
			InformantInfo ifi = informantInfoService.getInformantInfo(info.getInformantID());
			ClientInfo ci = clientInfoService.getClientInfo(info.getClientID());
			if(info!=null){
				ActionContext.getContext().put("DETAIL",info);
			}
			if(ii!=null && ii.getIssue()!=null){
				ActionContext.getContext().put("ISSUE",ii.getIssue());
			}
			if(ifi != null && ifi.getName()!=null){
				ActionContext.getContext().put("INFORMANT",ifi.getName());
			}
			if(ci!=null && ci.getCompany()!=null){
				ActionContext.getContext().put("CLIENT",ci.getCompany());
			}
			if(info!=null && info.getFileType()!=null){
				ActionContext.getContext().put("TYPE",QuestionTypeConstants.ExportTypeDict.get(info.getFileType()));
			}
			if(info!=null && info.getStatus()!=null){
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
	
	public List<String> getStatusList() {
		return statusList;
	}

	public List<String> getIssueList() {
		return issueList;
	}
	public void setIssueList(List<String> issueList) {
		this.issueList = issueList;
	}
	public List<String> getInformantList() {
		return informantList;
	}
	public void setInformantList(List<String> informantList) {
		this.informantList = informantList;
	}
	public List<String> getClientList() {
		return clientList;
	}
	public void setClientList(List<String> clientList) {
		this.clientList = clientList;
	}
	public List<InformantInfo> getInformantInfoList() {
		return informantInfoList;
	}
	public void setInformantInfoList(List<InformantInfo> informantInfoList) {
		this.informantInfoList = informantInfoList;
	}
	public List<OutputInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<OutputInfo> pageList) {
		this.pageList = pageList;
	}
	public void setOutputInfoService(IOutputInfoService outputInfoService) {
		this.outputInfoService = outputInfoService;
	}
	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}
	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}
	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}
	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public PaginationUtil getPu() {
		return pu;
	}

	public List<String> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}
	public Long getIssueID() {
		return issueID;
	}
	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}
	public Long getOutputID() {
		return outputID;
	}
	public void setOutputID(Long outputID) {
		this.outputID = outputID;
	}
	public Long getInformantID() {
		return informantID;
	}
	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}

}
