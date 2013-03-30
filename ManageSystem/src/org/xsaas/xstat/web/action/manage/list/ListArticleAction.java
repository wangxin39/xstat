package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;


import org.xsaas.xstat.business.IArticleInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.po.ArticleInfo;
import org.xsaas.xstat.po.EmployeeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListArticleAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(ListArticleAction.class);
	private IEmployeeInfoService employeeInfoService = null;
	private IArticleInfoService articleInfoService = null;
	private List<String> statusList = new LinkedList<String>();
	private String keyword = null;
	private Long articleID = null;

	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<ArticleInfo> pageList = null;	
	private PaginationUtil pu = null;
	
	@Override
	public String execute() throws Exception {
		
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		if(username == null || password == null) {
			return LOGIN;
		}
		try{
			EmployeeInfo employeeInfo = employeeInfoService.isLogin(username, password);
			if(employeeInfo == null) {
				return LOGIN;
			}
			int page = 1;
			if (num != null) {
				page = num.intValue();
			}
			int total = 0;
			if(keyword == null){
				total = articleInfoService.getArticleInfoTotal();
			}else{
				total = articleInfoService.getArticleInfoTotal(keyword);
			}
			
			pu = new PaginationUtil(total, page,SmgkConstants.PAGE_MAX_RESULT);
			if(keyword == null){
				pageList = articleInfoService.findArticleInfoByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = articleInfoService.findArticleInfoByPage(keyword,pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			}
			
			for(ArticleInfo info:pageList) {
				if(pageList != null){
					if(info.getStatus() != null){
						statusList.add(""+StatusConstants.StatusDict.get(info.getStatus()));
					}else{
						statusList.add("");
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
				
	public String detail() throws Exception{
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			if(articleID == null) {
				this.addActionError("编号为空！");
				return ERROR;
			}
			ArticleInfo info = articleInfoService.getArticleInfo(articleID);
			if(info != null)
			ActionContext.getContext().put("ARTICLEINFO", info);
			ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));
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
	public void setArticleInfoService(IArticleInfoService articleInfoService) {
		this.articleInfoService = articleInfoService;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public Long getArticleID() {
		return articleID;
	}

	public void setArticleID(Long articleID) {
		this.articleID = articleID;
	}
	public List<ArticleInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<ArticleInfo> pageList) {
		this.pageList = pageList;
	}
	public PaginationUtil getPu() {
		return pu;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
