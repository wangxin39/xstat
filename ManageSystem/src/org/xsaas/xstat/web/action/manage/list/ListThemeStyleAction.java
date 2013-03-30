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
import org.xsaas.xstat.business.IReportTemplateInfoService;
import org.xsaas.xstat.business.IThemeInfoService;
import org.xsaas.xstat.business.IThemeStyleInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.ReportTemplateInfo;
import org.xsaas.xstat.po.ThemeInfo;
import org.xsaas.xstat.po.ThemeStyleInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListThemeStyleAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127570233615470183L;
	private static Log logger = LogFactory.getLog(ListThemeStyleAction.class);
	private IThemeStyleInfoService themeStyleInfoService = null;
	private IThemeInfoService themeInfoService = null;
	private IReportTemplateInfoService reportTemplateInfoService = null;
	
	
	private List<String> themeList = new LinkedList<String>();
	private List<String> templateList = new LinkedList<String>();
	private List<String> typeList = new LinkedList<String>();
	private List<String> statusList = new LinkedList<String>();
	private List<String> backList = new LinkedList<String>();
	private Long styleID = null;

	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<ThemeStyleInfo> pageList = null;
	private PaginationUtil pu = null;	
	
		
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
			int total = themeStyleInfoService.getThemeStyleInfoTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = themeStyleInfoService.findThemeStyleInfoByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			for(ThemeStyleInfo info:pageList){
				if(pageList != null){
					if(info.getStatType() != null) {
						typeList.add(""+QuestionTypeConstants.ReportTypeDict.get(info.getStatType()));				
					}else{
						typeList.add("");				
					}
					ThemeInfo ti = themeInfoService.getThemeInfo(info.getThemeID());
					if(ti!=null && ti.getTitle()!=null){
						themeList.add(""+ti.getTitle());
					}
					ReportTemplateInfo rti = reportTemplateInfoService.getReportTemplateInfo(info.getReportTemplateID());
					if(rti!=null && rti.getName()!=null){
						templateList.add(""+rti.getName());
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
		try{		
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			if(styleID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			ThemeStyleInfo info = themeStyleInfoService.getThemeStyleInfo(styleID);
			if(info!=null && info.getStatType()!=null && info.getStatus()!=null && info.getIsBackImage()!=null){
				ActionContext.getContext().put("STYLEDETAIL",info);
				ActionContext.getContext().put("STATTYPE",QuestionTypeConstants.StatDict.get(info.getStatType()));
				ActionContext.getContext().put("BACK",QuestionTypeConstants.BackDict.get(info.getIsBackImage()));
				ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));
			}
			ThemeInfo ti = themeInfoService.getThemeInfo(info.getThemeID());
			ReportTemplateInfo rti = reportTemplateInfoService.getReportTemplateInfo(info.getReportTemplateID());
			if(ti!=null && ti.getTitle()!=null){
				ActionContext.getContext().put("THEME",ti.getTitle());
			}
			if(rti!=null && rti.getName()!=null){
				ActionContext.getContext().put("TEMPLATE",rti.getName());
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


	public List<String> getTypeList() {
		return typeList;
	}


	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}

	public List<String> getThemeList() {
		return themeList;
	}
	public void setThemeList(List<String> themeList) {
		this.themeList = themeList;
	}
	public List<String> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}
	public List<String> getBackList() {
		return backList;
	}
	public void setBackList(List<String> backList) {
		this.backList = backList;
	}
	public Long getStyleID() {
		return styleID;
	}
	public void setStyleID(Long styleID) {
		this.styleID = styleID;
	}
	public List<ThemeStyleInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<ThemeStyleInfo> pageList) {
		this.pageList = pageList;
	}
	public void setThemeStyleInfoService(
			IThemeStyleInfoService themeStyleInfoService) {
		this.themeStyleInfoService = themeStyleInfoService;
	}
	public void setThemeInfoService(IThemeInfoService themeInfoService) {
		this.themeInfoService = themeInfoService;
	}
	public void setReportTemplateInfoService(
			IReportTemplateInfoService reportTemplateInfoService) {
		this.reportTemplateInfoService = reportTemplateInfoService;
	}
	public PaginationUtil getPu() {
		return pu;
	}
	public List<String> getTemplateList() {
		return templateList;
	}
	public void setTemplateList(List<String> templateList) {
		this.templateList = templateList;
	}

}
