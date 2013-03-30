package org.xsaas.xstat.web.action.manage.list;

import java.util.List;
import java.util.Map;
import java.util.LinkedList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

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

public class ListGradeRelationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5787261135094108353L;
	private static Log logger = LogFactory.getLog(ListGradeRelationAction.class);
	private IClientInfoService clientInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IGradeStdInfoService gradeStdInfoService = null;
	
	
	private IGradeRelationInfoService gradeRelationInfoService = null;

	private Long gradeRelationID = null;
	
	private Integer num = null;
	
	private List<GradeRelationInfo> pageList = null;
	private Map<String,String> pageNumList = null;
	private PaginationUtil pu = null;

	private List<String> clientList = null;
	private List<String> issueList = null;
	private List<String> informantList = null;
	private List<String> gradeStdList = null;
	
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			int page = 1;
			if(num != null) {
				page = num.intValue();
			}
			
			int total = gradeRelationInfoService.getTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = gradeRelationInfoService.findByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);			
			
			clientList = new LinkedList<String>();
			issueList = new LinkedList<String>();
			informantList = new LinkedList<String>();
			gradeStdList = new LinkedList<String>();			
	
			IssueInfo issueInfo = null;
			ClientInfo clientInfo = null;
			InformantInfo informantInfo = null;
			GradeStdInfo gradeStdInfo = null;
			
			
			for(GradeRelationInfo info:pageList) {
				if(info.getIssueID() != null) {
					issueInfo= issueInfoService.getIssueInfo(info.getIssueID());					
				}
				if(info.getClientID() != null) {
					clientInfo = clientInfoService.getClientInfo(info.getClientID());
				}
				if(info.getInformantID() != null) {
					informantInfo = informantInfoService.getInformantInfo(info.getInformantID());
				}
				if(info.getGradeStdID() != null) {
					gradeStdInfo = gradeStdInfoService.getGradeStdInfo(info.getGradeStdID());
				}
				
				
				if(issueInfo != null) {
					issueList.add(""+issueInfo.getIssue());
				}else{
					issueList.add("");
				}
				if(clientInfo != null) {
					clientList.add(""+clientInfo.getCompany());
				}else{
					clientList.add("");					
				}
				if(informantInfo != null) {
					informantList.add(""+informantInfo.getName());
				}else{
					informantList.add("");
				}
				
				if(gradeStdInfo != null) {
					gradeStdList.add(""+gradeStdInfo.getTitle());
				}else{
					gradeStdList.add("");
				}
				
				
			}
			
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}

	public Long getGradeRelationID() {
		return gradeRelationID;
	}

	public void setGradeRelationID(Long gradeRelationID) {
		this.gradeRelationID = gradeRelationID;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<GradeRelationInfo> getPageList() {
		return pageList;
	}

	public Map<String, String> getPageNumList() {
		return pageNumList;
	}

	public PaginationUtil getPu() {
		return pu;
	}
	public void setGradeRelationInfoService(
			IGradeRelationInfoService gradeRelationInfoService) {
		this.gradeRelationInfoService = gradeRelationInfoService;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public List<String> getClientList() {
		return clientList;
	}

	public List<String> getIssueList() {
		return issueList;
	}

	public List<String> getInformantList() {
		return informantList;
	}

	public List<String> getGradeStdList() {
		return gradeStdList;
	}

	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}

	public void setGradeStdInfoService(IGradeStdInfoService gradeStdInfoService) {
		this.gradeStdInfoService = gradeStdInfoService;
	}

	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}	
}
