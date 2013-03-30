package org.xsaas.xstat.web.action.backend.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.bo.PlanHeaderInfo;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IInformantInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.business.IPlanInfoService;
import org.xsaas.xstat.business.IProjectInfoService;
import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.InformantInfo;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.IssueInfo;
import org.xsaas.xstat.po.PlanInfo;
import org.xsaas.xstat.po.ProjectInfo;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListProjectAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2898380874870429052L;
	private static Log logger = LogFactory.getLog(ListProjectAction.class);
	
	private ISmgkInfoService smgkInfoService = null;
	private IPlanInfoService planInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IProjectInfoService projectInfoService = null;
	private IClientInfoService clientInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IInformantInfoService informantInfoService = null;
	
	private Integer num = null;
	private List<PlanInfo> pageList = null;
	private Integer totalPageNum = null;	
	private PaginationUtil pu = null;
	
	private LinkedList<PlanHeaderInfo> planHeaderList = new LinkedList<PlanHeaderInfo>();
	private LinkedList<IssueInfo> issueList = new LinkedList<IssueInfo>();
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}

			SmgkInfo smgkInfo = smgkInfoService.isLogin(username, password);
			if(smgkInfo == null) {
				return LOGIN;
			}
			int page = 1;
			if(num != null) {
				page = num.intValue();
			}
			
			pageList = planInfoService.findBySmgk(smgkInfo.getSmgkID());
			int total = 0;
			if(pageList != null) {
				total = pageList.size();
				pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);			
			}
		
			PlanHeaderInfo phi = null;
			planHeaderList.clear();
			issueList.clear();
			
			for(int i=0;i<total;i++) {
				PlanInfo pi = pageList.get(i);
				phi = new PlanHeaderInfo();
				IssueInfo issueInfo = null;
				if(pi != null && pi.getIssueID() != null) {
					issueInfo = issueInfoService.getIssueInfo(pi.getIssueID());
				}
				if(issueInfo != null) {
					phi.setIssue(""+issueInfo.getIssue());
					issueList.add(issueInfo);
					
					ClientInfo ci = clientInfoService.getClientInfo(issueInfo.getClientID());
					if(ci != null) {
						phi.setCompany(""+ci.getCompany());
					}
					ProjectInfo projectInfo = projectInfoService.getProjectInfo(issueInfo.getProjectID());
					if(projectInfo != null && projectInfo.getName() != null) {
						phi.setProjectName(""+projectInfo.getName());
					}
					
					if(issueInfo != null && issueInfo.getInquisitionID() != null) {
						InquisitionInfo ii = inquisitionInfoService.getInquisitionInfo(issueInfo.getInquisitionID());
						if(ii != null) {
							phi.setInquisition(""+ii.getTitle());						
						}
					}

				}
				if(pi != null && pi.getInformantID() != null) {
					InformantInfo ii = informantInfoService.getInformantInfo(pi.getInformantID());
					phi.setInformantName(""+ii.getAliasName());
				}		

				planHeaderList.add(phi);
				
			}			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}

		
		
		
		return SUCCESS;
	}

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}

	public void setPlanInfoService(IPlanInfoService planInfoService) {
		this.planInfoService = planInfoService;
	}
	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}

	public void setProjectInfoService(IProjectInfoService projectInfoService) {
		this.projectInfoService = projectInfoService;
	}

	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<PlanInfo> getPageList() {
		return pageList;
	}

	public Integer getTotalPageNum() {
		return totalPageNum;
	}

	public PaginationUtil getPu() {
		return pu;
	}

	public LinkedList<IssueInfo> getIssueList() {
		return issueList;
	}

	public LinkedList<PlanHeaderInfo> getPlanHeaderList() {
		return planHeaderList;
	}

	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}


}
