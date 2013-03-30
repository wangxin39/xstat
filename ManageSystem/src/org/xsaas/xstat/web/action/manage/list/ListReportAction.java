package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInformantInfoService;
import org.xsaas.xstat.business.IIssueInfoService;
import org.xsaas.xstat.business.IReportInfoService;
import org.xsaas.xstat.business.IThemeInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InformantInfo;
import org.xsaas.xstat.po.IssueInfo;
import org.xsaas.xstat.po.ReportInfo;
import org.xsaas.xstat.po.ThemeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListReportAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127570233615470183L;
	private static Log logger = LogFactory.getLog(ListReportAction.class);

	private IReportInfoService reportInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IThemeInfoService themeInfoService = null;
	private IIssueInfoService issueInfoService = null;
	
	
	private List<InformantInfo> informantList = new LinkedList<InformantInfo>();
	private List<String> themeList = new LinkedList<String>();
	private Long reportID = null;
	private Long issueID= null;
	private Long informantID = null;

	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<ReportInfo> pageList = null;

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
			long selectIssueID = 0;
			IssueInfo ii = null;
			if(issueID == null){//判断有无值  没有赋值
				List<IssueInfo> iList = issueInfoService.getIssueInfoList();
				if(iList.size()>0){
					ii =iList.get(0);
					if(ii!=null){
						selectIssueID = ii.getIssueID().longValue();
						ActionContext.getContext().put("ISSUESELECT",ii);
					}
				}else{
					ActionContext.getContext().put("ISSUESELECT",null);
				}				
				ActionContext.getContext().getSession().put("ISSUELIST",iList);
			}else{
				selectIssueID = issueID.longValue();
			}	
			ii = issueInfoService.getIssueInfo(selectIssueID);
			if(ii!=null && ii.getClientID()!=null){
				informantList = informantInfoService.getInformantInfoList(ii.getClientID());//获取调查对象中信息
			}
			ActionContext.getContext().getSession().put("INFORSELECT",informantList);
			
			long selectInformantID = 0;
			if(informantID !=null){
				selectInformantID = informantID.longValue();
			}else{
				informantList = informantInfoService.getInformantInfoList();
				if(informantList.size()>0){
					InformantInfo ifi = informantList.get(0);
					if(ifi!=null){
						selectInformantID = ifi.getInformantID().longValue();
					}
				}
			}

			int total = 0;
			if(selectInformantID!=0 && selectIssueID!= 0){
				total = reportInfoService.getReportInfoTotal(selectIssueID,selectInformantID);
			}else{
				total = reportInfoService.getReportInfoTotal();
			}
			
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			if(selectInformantID!=0 && selectIssueID!= 0){
				pageList = reportInfoService.findReportInfoByPage(selectIssueID,selectInformantID,pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = reportInfoService.findReportInfoByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			}
			
			for(ReportInfo info:pageList){
				if(pageList != null){
					ThemeInfo ti = themeInfoService.getThemeInfo(info.getThemeID());
					if(ti!=null && ti.getTitle()!=null){
						themeList.add(""+ti.getTitle());
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
		
	public String  detail() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		if(username == null || password == null) {
			return LOGIN;
		}
		try{
			if(reportID == null){
				return ERROR;
			}
			ReportInfo info = reportInfoService.getReportInfo(reportID);
			if(info.getReportType()!=null && info.getStatus()!=null){
				ActionContext.getContext().put("REPORTINFO",info);
				ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));
				ActionContext.getContext().put("REPORTTYPE",QuestionTypeConstants.ReportTypeDict.get(info.getReportType()));
			}
			IssueInfo ii = issueInfoService.getIssueInfo(info.getIssueID());
			InformantInfo ifi = informantInfoService.getInformantInfo(info.getInformantID());
			ThemeInfo ti = themeInfoService.getThemeInfo(info.getThemeID());
			if(ii!=null && ii.getIssue()!=null){
				ActionContext.getContext().put("ISSUE",ii.getIssue());
			}
			if(ifi!=null && ifi.getName()!=null){
				ActionContext.getContext().put("INFORMANT",ifi.getName());
			}
			if(ti!=null && ti.getTitle()!=null){
				ActionContext.getContext().put("THEME",ti.getTitle());
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


	public Long getReportID() {
		return reportID;
	}

	public void setReportID(Long reportID) {
		this.reportID = reportID;
	}


	public void setReportInfoService(
			IReportInfoService reportInfoService) {
		this.reportInfoService = reportInfoService;
	}

	public List<ReportInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<ReportInfo> pageList) {
		this.pageList = pageList;
	}
	public PaginationUtil getPu() {
		return pu;
	}

	public List<InformantInfo> getInformantList() {
		return informantList;
	}
	public void setInformantList(List<InformantInfo> informantList) {
		this.informantList = informantList;
	}
	public Long getIssueID() {
		return issueID;
	}
	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}
	public void setInformantInfoService(IInformantInfoService informantInfoService) {
		this.informantInfoService = informantInfoService;
	}
	public void setThemeInfoService(IThemeInfoService themeInfoService) {
		this.themeInfoService = themeInfoService;
	}
	public void setIssueInfoService(IIssueInfoService issueInfoService) {
		this.issueInfoService = issueInfoService;
	}
	public List<String> getThemeList() {
		return themeList;
	}
	public void setThemeList(List<String> themeList) {
		this.themeList = themeList;
	}
	public Long getInformantID() {
		return informantID;
	}
	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}

}
