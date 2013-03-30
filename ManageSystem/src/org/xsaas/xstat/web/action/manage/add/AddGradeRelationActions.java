package org.xsaas.xstat.web.action.manage.add;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IGradeRelationInfoService;
import org.xsaas.xstat.business.IGradeStdInfoService;
import org.xsaas.xstat.business.IInformantInfoService;
import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.GradeRelationInfo;
import org.xsaas.xstat.po.GradeStdInfo;
import org.xsaas.xstat.po.InformantInfo;
import org.xsaas.xstat.po.IssueInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddGradeRelationActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3092454915764068202L;
	private static Log logger = LogFactory.getLog(AddGradeRelationActions.class);
	
	private IClientInfoService clientInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IGradeStdInfoService gradeStdInfoService = null;
	private IGradeRelationInfoService gradeRelationInfoService = null;
	
	private Long clientID = null;
	private Long issueID = null;
	private Long informantID = null;
	private Long gradeStdID = null;	

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(clientID == null || issueID == null || gradeStdID == null) {
				this.addActionError("请选择客户和期次以及评分标准！");
				return ERROR;
			}
			String isOK = (String)ActionContext.getContext().getSession().get("GRADERELATIONINFOADD");
			if("OK".equals(isOK)) {
				GradeRelationInfo info = new GradeRelationInfo();
				info.setClientID(clientID);
				info.setInformantID(informantID);
				info.setIssueID(issueID);
				info.setStatus(1);
				info.setGradeStdID(gradeStdID);
				
				gradeRelationInfoService.save(info);	
				ActionContext.getContext().getSession().put("GRADERELATIONINFOADD","NOT");
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
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
			
			ActionContext.getContext().getSession().put("GRADERELATIONINFOADD","OK");
					
			List<ClientInfo> clientInfoList = (List<ClientInfo>)ActionContext.getContext().getSession().get("GLOBALCLIENTINFOLIST");
			if(clientInfoList == null) {
				clientInfoList = clientInfoService.getClientInfoList();
				ActionContext.getContext().getSession().put("GLOBALCLIENTINFOLIST",clientInfoList);
			}
			List<IssueInfo> issueInfoList = (List<IssueInfo>)ActionContext.getContext().getSession().get("GLOBALISSUEINFOLIST");
			if(issueInfoList == null) {
				issueInfoList = issueInfoService.getIssueInfoList();
				ActionContext.getContext().getSession().put("GLOBALISSUEINFOLIST",issueInfoList);
			}
			List<InformantInfo> informantInfoList = (List<InformantInfo>)ActionContext.getContext().getSession().get("GLOBALINFORMANTINFOLIST");
			if(informantInfoList == null) {				
				informantInfoList = informantInfoService.getInformantInfoList();
				ActionContext.getContext().getSession().put("GLOBALINFORMANTINFOLIST",informantInfoList);
			}			
			List<GradeStdInfo> gradeStdInfoList = (List<GradeStdInfo>)ActionContext.getContext().getSession().get("GLOBALGRADESTDINFOLIST");
			if(gradeStdInfoList == null) {
				gradeStdInfoList = gradeStdInfoService.findByPage(0, Integer.MAX_VALUE);				
				ActionContext.getContext().getSession().put("GLOBALGRADESTDINFOLIST",gradeStdInfoList);
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}
	public Long getClientID() {
		return clientID;
	}
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	public Long getIssueID() {
		return issueID;
	}
	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}
	public Long getInformantID() {
		return informantID;
	}
	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}
	public Long getGradeStdID() {
		return gradeStdID;
	}
	public void setGradeStdID(Long gradeStdID) {
		this.gradeStdID = gradeStdID;
	}
	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}
	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}
	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}
	public void setGradeStdInfoService(IGradeStdInfoService gradeStdInfoService) {
		this.gradeStdInfoService = gradeStdInfoService;
	}
	public void setGradeRelationInfoService(
			IGradeRelationInfoService gradeRelationInfoService) {
		this.gradeRelationInfoService = gradeRelationInfoService;
	}
}
