package org.xsaas.xstat.web.action.backend.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1832738050627630367L;	
	private static Log logger = LogFactory.getLog(ListPublishAction.class);	
	private IArticleInfoService articleInfoService = null;
	private IPublishInfoService publishInfoService = null;
	private ISmgkInfoService smgkInfoService = null;
	
	private LinkedList<String> articleList = new java.util.LinkedList<String>();	
	private Integer num = null;
		
	private Integer type = null;
	
	private List<PublishInfo> pageList = null;
	private PaginationUtil pu = null;
	
	private Long id = null;
	
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
			int total = 0;
			int articleType = 1;
			
			if(num != null) {
				page = num.intValue();
			}
			if(type != null) {
				articleType = type.intValue();
			}		
			if(articleType == 1 || articleType == 5) {
				total = publishInfoService.getTotal(articleType, smgkInfo.getSmgkID());
				pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
				pageList = publishInfoService.findByPage(articleType,smgkInfo.getSmgkID(),pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}else{
				total = publishInfoService.getTotal(articleType);			
				pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
				pageList = publishInfoService.findByPage(articleType, pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}
			
			logger.debug("total:"+total);
			logger.debug("pageList size:"+pageList.size());
			
			ArticleInfo ai = null;
			for(PublishInfo info:pageList) {
				ai = articleInfoService.getArticleInfo(info.getArticleID());
				logger.debug("ai:"+ai);
				if(ai != null) {
					articleList.add(""+ai.getTitle());
				}else{
					articleList.add("");
				}
			}					
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}
	public String detail() throws Exception {
		if(id == null) {
			return ERROR;
		}
		ArticleInfo ai = articleInfoService.getArticleInfo(id);
		ActionContext.getContext().put("ARTICLEINFO",ai);
		
		return SUCCESS;
	}

	public Integer getNum() {
		return num;
	}


	public void setNum(Integer num) {
		this.num = num;
	}


	public LinkedList<String> getArticleList() {
		return articleList;
	}

	public void setArticleInfoService(IArticleInfoService articleInfoService) {
		this.articleInfoService = articleInfoService;
	}


	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}


	public void setPublishInfoService(IPublishInfoService publishInfoService) {
		this.publishInfoService = publishInfoService;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<PublishInfo> getPageList() {
		return pageList;
	}


	public PaginationUtil getPu() {
		return pu;
	}
}
