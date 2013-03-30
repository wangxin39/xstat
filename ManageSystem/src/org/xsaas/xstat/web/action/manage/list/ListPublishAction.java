package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;


import org.xsaas.xstat.business.IArticleInfoService;
import org.xsaas.xstat.business.IPublishInfoService;
import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.ArticleInfo;
import org.xsaas.xstat.po.PublishInfo;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListPublishAction extends ActionSupport {
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(ListPublishAction.class);
	private IPublishInfoService publishInfoService = null;
	private ISmgkInfoService smgkInfoService = null;
	private IArticleInfoService articleInfoService = null;

	private List<String> statusList = new LinkedList<String>();
	private List<String> typeList = new LinkedList<String>();
	private List<String> smgkList = new LinkedList<String>();
	private List<String> articleList = new LinkedList<String>();
	private Long publishID = null;

	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<PublishInfo> pageList = null;	

	private PaginationUtil pu = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		
		int page = 1;
		if (num != null) {
			page = num.intValue();
		}
		SmgkInfo smgkInfo = null;
		int total = publishInfoService.getTotalPublishInfo();
		pu = new PaginationUtil(total, page,SmgkConstants.PAGE_MAX_RESULT);
		pageList = publishInfoService.findByPagePublishInfo(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
		for(PublishInfo info:pageList) {
			if(pageList != null){
				if(info.getStatus() != null){
					statusList.add(""+StatusConstants.StatusDict.get(info.getStatus()));
				}else{
					statusList.add("");
				}
				if(info.getArticleID() != null){
					ArticleInfo articleInfo = articleInfoService.getArticleInfo(info.getArticleID());
					articleList.add(""+articleInfo.getTitle());
				}else{
					articleList.add("");
				}
				if(info.getSmgkID() != null){
					smgkInfo = smgkInfoService.getSmgkInfo(info.getSmgkID());
					smgkList.add(""+smgkInfo.getUserName());
				}else{
					smgkList.add("");
				}
				if(info.getType() != null){
					typeList.add(""+QuestionTypeConstants.PublishTypeDict.get(info.getType()));
				}else{
					typeList.add("");
				}
			}else{
				this.addActionMessage("数据库中没有数据!");
			}
			
		}	
		return SUCCESS;
	}
				
	@SuppressWarnings("unchecked")
	public String detail() throws Exception{
		if(publishID == null) {
			this.addActionError("编号为空！");
			return ERROR;
		}
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			PublishInfo info = publishInfoService.getPublishInfo(publishID);
			if(info != null)
			ActionContext.getContext().getSession().put("PUBLISHINFO",info);
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

	
	public List<String> getSmgkList() {
		return smgkList;
	}

	public void setSmgkList(List<String> smgkList) {
		this.smgkList = smgkList;
	}


	public Long getPublishID() {
		return publishID;
	}

	public void setPublishID(Long publishID) {
		this.publishID = publishID;
	}

	public void setPublishInfoService(IPublishInfoService publishInfoService) {
		this.publishInfoService = publishInfoService;
	}

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}

	public List<PublishInfo> getPageList() {
		return pageList;
	}

	public void setPageList(List<PublishInfo> pageList) {
		this.pageList = pageList;
	}

	public PaginationUtil getPu() {
		return pu;
	}

	public List<String> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<String> articleList) {
		this.articleList = articleList;
	}

	public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}
}
