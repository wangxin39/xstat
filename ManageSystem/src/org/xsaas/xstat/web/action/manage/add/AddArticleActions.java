package org.xsaas.xstat.web.action.manage.add;

import java.sql.Timestamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;


import org.xsaas.xstat.business.IArticleInfoService;
import org.xsaas.xstat.po.ArticleInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddArticleActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(AddArticleActions.class);
	private IArticleInfoService articleInfoService = null;
	private String title = null;
	private String content = null;
	private String author = null;
	private String source = null;

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
				ArticleInfo info = new ArticleInfo();
				info.setTitle(title);
				info.setContent(content);
				info.setAuthor(author);
				info.setSource(source);
				info.setStatus(StatusConstants.ZHENGCHANG);
				info.setAddTime(new Timestamp(System.currentTimeMillis()));		
				articleInfoService.saveArticleInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setArticleInfoService(IArticleInfoService articleInfoService) {
		this.articleInfoService = articleInfoService;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
