package cn.iaicc.smgk.web.action.manage.edit;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IInformantInfoService;
import cn.iaicc.smgk.business.IIssueInfoService;
import cn.iaicc.smgk.business.IReportInfoService;
import cn.iaicc.smgk.business.IThemeInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.po.IssueInfo;
import cn.iaicc.smgk.po.ReportInfo;
import cn.iaicc.smgk.po.ThemeInfo;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditReportAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127570233615470183L;
	private static Log logger = LogFactory.getLog(EditReportAction.class);
	private IReportInfoService reportInfoService = null;
	private IInformantInfoService informantInfoService = null;
	private IThemeInfoService themeInfoService = null;
	private IIssueInfoService issueInfoService = null;
	
	private Long reportID = null;
	private List<InformantInfo> informantList = new LinkedList<InformantInfo>();

	private String checkName = null;
  	private String reportTitle = null;
	private Integer reportType = null;
	private String enReportTitle = null;
	private Long issueID = null;
  	private Long themeID = null;
  	private Long informantID = null;
  	private String quarterTitle = null;
  	private Integer pageCount = null;

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				ReportInfo info = (ReportInfo) ActionContext.getContext().getSession().get("TYPEEDIT");
				info.setCheckName(checkName);
				info.setAddTime(new Timestamp(System.currentTimeMillis()));
				info.setReportType(reportType);
				info.setEnReportTitle(enReportTitle);
				info.setPageCount(pageCount);
				info.setQuarterTitle(quarterTitle);
				info.setInformantID(informantID);
				info.setIssueID(issueID);
				info.setReportTitle(reportTitle);
				info.setThemeID(themeID);

				reportInfoService.updateReportInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String  edit() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		if(username == null || password == null) {
			return LOGIN;
		}
		try{
			if(reportID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			ReportInfo info = reportInfoService.getReportInfo(reportID);
			ActionContext.getContext().getSession().put("REPORTEDIT",info);
			ActionContext.getContext().getSession().put("STATUS",StatusConstants.StatusDict);
			
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			long selectIssueID = 0;
			if(issueID == null){//判断有无值  没有赋值
				List<IssueInfo> iList = issueInfoService.getIssueInfoList();
				if(iList.size()>0){
					IssueInfo qi =iList.get(0);
					if(qi!=null){
						selectIssueID = qi.getIssueID().longValue();
						ActionContext.getContext().put("ISSUESELECT",qi);
					}
				}else{
					this.addActionMessage("请添加期次信息!");
					return ERROR;
				}
				ActionContext.getContext().getSession().put("ISSUELIST",iList);
			}else{
				selectIssueID = issueID.longValue();
			}
			informantList = informantInfoService.getInformantInfoList(selectIssueID);//获取调查对象中信息
			ActionContext.getContext().getSession().put("INFORSELECT",informantList);
			
			List<ThemeInfo> themeList = themeInfoService.getThemeInfoList();
			ActionContext.getContext().getSession().put("THEMELIST",themeList);
			ActionContext.getContext().getSession().put("REPORTTYPE",QuestionTypeConstants.ReportTypeDict);

		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		
		return SUCCESS;
	}	

	public Integer getReportType() {
		return reportType;
	}

	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getEnReportTitle() {
		return enReportTitle;
	}

	public void setEnReportTitle(String enReportTitle) {
		this.enReportTitle = enReportTitle;
	}

	public Long getIssueID() {
		return issueID;
	}

	public void setIssueID(Long issueID) {
		this.issueID = issueID;
	}

	public Long getThemeID() {
		return themeID;
	}

	public void setThemeID(Long themeID) {
		this.themeID = themeID;
	}

	public Long getInformantID() {
		return informantID;
	}

	public void setInformantID(Long informantID) {
		this.informantID = informantID;
	}

	public String getQuarterTitle() {
		return quarterTitle;
	}

	public void setQuarterTitle(String quarterTitle) {
		this.quarterTitle = quarterTitle;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public void setReportInfoService(
			IReportInfoService reportInfoService) {
		this.reportInfoService = reportInfoService;
	}

	public Long getReportID() {
		return reportID;
	}

	public void setReportID(Long reportID) {
		this.reportID = reportID;
	}

	public List<InformantInfo> getInformantList() {
		return informantList;
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


}
