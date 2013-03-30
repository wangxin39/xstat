package org.xsaas.xstat.web.action.backend.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.PlanStatusConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.business.IPlanInfoService;
import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.IssueInfo;
import org.xsaas.xstat.po.PlanInfo;
import org.xsaas.xstat.po.SmgkInfo;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListPlanAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4628020941334025859L;
	private static Log logger = LogFactory.getLog(ListPlanAction.class);
	private IPlanInfoService planInfoService = null;
	private ISmgkInfoService smgkInfoService = null;
	private IIssueInfoService issueInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	
	private Integer num = null;
	private List<PlanInfo> pageList = null;
	private Integer totalPageNum = null;
	
	private PaginationUtil pu = null;		
	private LinkedList<String> statusList = new LinkedList<String>();
	
	private List<InquisitionInfo> inquisitionList = new LinkedList<InquisitionInfo>();
	
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
			int total = pageList.size();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);

			statusList.clear();
			inquisitionList.clear();
			
			InquisitionInfo ii = null;
			IssueInfo issueInfo = null;
			for(PlanInfo info:pageList) {		
				statusList.add(""+PlanStatusConstants.checkMap.get(info.getCheckStatus()));	
				
				issueInfo = issueInfoService.getIssueInfo(info.getIssueID());
				if(issueInfo != null && issueInfo.getInquisitionID() != null) {										
					ii = inquisitionInfoService.getInquisitionInfo(issueInfo.getInquisitionID());
					inquisitionList.add(ii);					
				}else{					
					inquisitionList.add(new InquisitionInfo());					
				}

			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}

		
		return SUCCESS;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setPlanInfoService(IPlanInfoService planInfoService) {
		this.planInfoService = planInfoService;
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

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}
	public LinkedList<String> getStatusList() {
		return statusList;
	}

	public List<InquisitionInfo> getInquisitionList() {
		return inquisitionList;
	}

	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}




}
