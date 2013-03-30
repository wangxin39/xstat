package org.xsaas.xstat.web.action.manage.add;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IArticleInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IPublishInfoService;
import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.ArticleInfo;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.PublishInfo;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddPublishActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(AddPublishActions.class);
	private IPublishInfoService publishInfoService = null;
	private ISmgkInfoService smgkInfoService = null;
	private IArticleInfoService articleInfoService = null;

	private Long articleID = null;
	private Long smgkID = null;
	private Integer type = null;

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
				if(articleID == null){
					ActionContext.getContext().put("nullError","文章标题不能为空，请先添加文章信息!");
					return INPUT;
				}
				PublishInfo info = new PublishInfo();
				if(articleID != null) {
					info.setArticleID(articleID);					
				}
				if(smgkID != null) {
					info.setSmgkID(smgkID);					
				}
				if(type != null) {
					info.setType(type);					
				}
				info.setPublishTime(new Timestamp(System.currentTimeMillis()));				
				info.setStatus(StatusConstants.ZHENGCHANG);
				publishInfoService.savePublishInfo(info);
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
			List<ArticleInfo> articleList = articleInfoService.getArticleInfoList();		
			ActionContext.getContext().getSession().put("ARTICLESELECT",articleList);
			List<SmgkInfo> smgkList = smgkInfoService.getSmgkInfoList();
			ActionContext.getContext().getSession().put("SMGKSELECT",smgkList);
			ActionContext.getContext().getSession().put("TYPE",QuestionTypeConstants.PublishTypeDict);
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}	

	public Long getArticleID() {
		return articleID;
	}

	public void setArticleID(Long articleID) {
		this.articleID = articleID;
	}

	public Long getSmgkID() {
		return smgkID;
	}

	public void setSmgkID(Long smgkID) {
		this.smgkID = smgkID;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	public void setPublishInfoService(IPublishInfoService publishInfoService) {
		this.publishInfoService = publishInfoService;
	}
	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}
	public void setArticleInfoService(IArticleInfoService articleInfoService) {
		this.articleInfoService = articleInfoService;
	}

}
