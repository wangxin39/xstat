package cn.iaicc.smgk.web.action.manage.edit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IThemeInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.ThemeInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditThemeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127570233615470183L;
	private static Log logger = LogFactory.getLog(EditThemeAction.class);
	private IThemeInfoService themeInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	private Long themeID = null;
	private String description = null;
  	private String title = null;
  	private Integer status = null;

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
				ThemeInfo info = (ThemeInfo) ActionContext.getContext().getSession().get("THEMEEDIT");
				info.setDescription(description);
				info.setTitle(title);
				themeInfoService.updateThemeInfo(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			if(themeID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			ActionContext.getContext().getSession().put("STATUS",StatusConstants.StatusDict);
			ThemeInfo info = themeInfoService.getThemeInfo(themeID);
			ActionContext.getContext().getSession().put("THEMEEDIT",info);	
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		

		return SUCCESS;
	}
	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setThemeInfoService(
			cn.iaicc.smgk.business.IThemeInfoService themeInfoService) {
		this.themeInfoService = themeInfoService;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getThemeID() {
		return themeID;
	}

	public void setThemeID(Long themeID) {
		this.themeID = themeID;
	}
	
}
