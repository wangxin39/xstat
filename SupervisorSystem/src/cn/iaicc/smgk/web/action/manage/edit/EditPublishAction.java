package cn.iaicc.smgk.web.action.manage.edit;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IArticleInfoService;
import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IPublishInfoService;
import cn.iaicc.smgk.business.ISmgkInfoService;
import cn.iaicc.smgk.po.ArticleInfo;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.PublishInfo;
import cn.iaicc.smgk.po.SmgkInfo;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditPublishAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(EditPublishAction.class);
	private IPublishInfoService publishInfoService = null;
	private ISmgkInfoService smgkInfoService = null;
	private IArticleInfoService articleInfoService = null;

	private Long articleID = null;
	private Long smgkID = null;
	private Integer type = null;

	private Long publishID = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			PublishInfo info = (PublishInfo) ActionContext.getContext().getSession().get("PUBLISHEDIT");
			if(info != null) {
				if(articleID != null) {
					info.setArticleID(articleID);					
				}
				if(smgkID != null) {
					info.setSmgkID(smgkID);					
				}
				if(type != null) {
					info.setType(type);					
				}
				publishInfoService.updatePublishInfo(info);
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		try{
			if (publishID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			List<ArticleInfo> articleList = articleInfoService.getArticleInfoList();		
			ActionContext.getContext().getSession().put("ARTICLESELECT",articleList);
			
			PublishInfo info = publishInfoService.getPublishInfo(publishID);		
			ActionContext.getContext().getSession().put("PUBLISHEDIT",info);
			if(info!=null && info.getSmgkID()!=null){
				ActionContext.getContext().put("SMGKID",info.getSmgkID());
				SmgkInfo smgkInfo = smgkInfoService.getSmgkInfo(info.getSmgkID());
				if(smgkInfo!=null && smgkInfo.getUserName()!=null){
					ActionContext.getContext().getSession().put("SMGKVALUE",smgkInfo.getUserName());
				}
				
			}
				
			ActionContext.getContext().getSession().put("TYPE",QuestionTypeConstants.PublishTypeDict);
//			String content = info.getContent();
//			content = content.replaceAll("\r\n","<br/>");
//			ActionContext.getContext().getSession().put("ARTICLECONTENT",content);		
			ActionContext.getContext().getSession().put("STATUS",StatusConstants.StatusDict);
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

	public Long getPublishID() {
		return publishID;
	}

	public void setPublishID(Long publishID) {
		this.publishID = publishID;
	}

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}

	public void setArticleInfoService(IArticleInfoService articleInfoService) {
		this.articleInfoService = articleInfoService;
	}

}
