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
import org.xsaas.xstat.business.IInquisitionTemplateInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InquisitionTemplateInfo;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListTemplateReportAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6062925099474622735L;
	private static Log logger = LogFactory.getLog(ListTemplateReportAction.class);
	private IInquisitionTemplateInfoService inquisitionTemplateInfoService = null;

	private List<String> statusList = new LinkedList<String>();
	private List<String> typeList = new LinkedList<String>();
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<InquisitionTemplateInfo> pageList = null;	
	private PaginationUtil pu = null;	
	private Long templateID = null;
	
	public String ajax() throws Exception {
		return SUCCESS;
	}			
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
			int total = inquisitionTemplateInfoService.getInquisitionTemplateInfoTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = inquisitionTemplateInfoService.findInquisitionTemplateInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			for(InquisitionTemplateInfo info:pageList){
				if(pageList != null){
					if(info.getStatus() != null) {
						statusList.add(""+StatusConstants.StatusDict.get(info.getStatus()));
					}else{
						statusList.add("");
					}
					if(info.getFileType() != null) {
						typeList.add(""+QuestionTypeConstants.TemplateTypeDict.get(info.getFileType()));
						
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
			if(templateID==null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			InquisitionTemplateInfo info = inquisitionTemplateInfoService.getInquisitionTemplateInfo(templateID);
			ActionContext.getContext().put("TEMPLATE",info);
			ActionContext.getContext().put("TEMPLATETYPE",QuestionTypeConstants.TemplateTypeDict.get(info.getFileType()));
			ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));
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
	public void setInquisitionTemplateInfoService(
			IInquisitionTemplateInfoService inquisitionTemplateInfoService) {
		this.inquisitionTemplateInfoService = inquisitionTemplateInfoService;
	}
	public List<String> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}


	public Long getTemplateID() {
		return templateID;
	}

	public void setTemplateID(Long templateID) {
		this.templateID = templateID;
	}
	public List<InquisitionTemplateInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<InquisitionTemplateInfo> pageList) {
		this.pageList = pageList;
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

}
