package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IReportTemplateInfoService;
import org.xsaas.xstat.po.ReportTemplateInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListReportTemplateAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8918173886699601500L;
	private static Log logger = LogFactory.getLog(ListReportTemplateAction.class);
	private IReportTemplateInfoService reportTemplateInfoService = null;

	private List<String> statusList = new LinkedList<String>();
	private List<String> typeList = new LinkedList<String>();
	private Long reportTemplateID = null;
	
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<ReportTemplateInfo> pageList = null;	
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
			int total = reportTemplateInfoService.getReportTemplateInfoTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = reportTemplateInfoService.findReportTemplateInfoByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			for(ReportTemplateInfo info:pageList){
				if(pageList != null){
					if(info.getStatus() != null){
						statusList.add(""+StatusConstants.StatusDict.get(info.getStatus()));
					}else{
						statusList.add("");
					}
					if(info.getType() != null){
						typeList.add(""+QuestionTypeConstants.ReportDict.get(info.getType()));
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
			if(reportTemplateID == null){
				return ERROR;
			}
			ReportTemplateInfo info = reportTemplateInfoService.getReportTemplateInfo(reportTemplateID);
			if(info!=null && info.getStatus()!=null && info.getType()!=null){
				ActionContext.getContext().put("TEMPLATE",info);
				ActionContext.getContext().put("TYPE",QuestionTypeConstants.ReportDict.get(info.getType()));
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


	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public List<ReportTemplateInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<ReportTemplateInfo> pageList) {
		this.pageList = pageList;
	}
	public void setReportTemplateInfoService(
			IReportTemplateInfoService reportTemplateInfoService) {
		this.reportTemplateInfoService = reportTemplateInfoService;
	}
	public PaginationUtil getPu() {
		return pu;
	}
	public Long getReportTemplateID() {
		return reportTemplateID;
	}
	public void setReportTemplateID(Long reportTemplateID) {
		this.reportTemplateID = reportTemplateID;
	}
	public List<String> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}


}
