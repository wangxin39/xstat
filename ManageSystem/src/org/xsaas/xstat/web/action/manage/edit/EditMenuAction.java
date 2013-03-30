package org.xsaas.xstat.web.action.manage.edit;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IMenuInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.MenuInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditMenuAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -495705973840811829L;
	private static Log logger = LogFactory.getLog(EditMenuAction.class);
	
	private IMenuInfoService menuInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	private Integer type = null;
	private String menu = null;
	private Long parentID = null;
	private String url = null;
	
	private Long menuID = null;
	
	public Long getMenuID() {
		return menuID;
	}

	public void setMenuID(Long menuID) {
		this.menuID = menuID;
	}
	
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
				MenuInfo info = (MenuInfo) ActionContext.getContext().getSession().get("EDITMENUINFO");;
				if(menu != null) {
					info.setMenu(menu);					
				}
				if(parentID != null) {
					info.setParentID(parentID);					
				}
				if(type != null) {
					info.setType(type);					
				}
				if(url != null) {
					info.setUrl(url);					
				}
				menuInfoService.updateMenuInfo(info);
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
			if(menuID == null){
				this.addActionError("非法操作，找不到要编辑的对象！");
				return ERROR;
			}
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			MenuInfo mi = menuInfoService.getMenuInfo(menuID);
			ActionContext.getContext().getSession().put("EDITMENUINFO",mi);
			if(mi.getParentID() != null && mi.getParentID() > 0) {
				MenuInfo fmi = menuInfoService.getMenuInfo(mi.getParentID());
				// 如果为空，则为一级菜单添加，不处理上级菜单问题
				ActionContext.getContext().put("FATHERMENUINFO",fmi);				
			}			
			ActionContext.getContext().getSession().put("TYPE",QuestionTypeConstants.MenuTypeDict);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}	

	public String getMenu() {
		return menu;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getParentID() {
		return parentID;
	}

	public void setParentID(Long parentID) {
		this.parentID = parentID;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}



	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	public void setMenuInfoService(IMenuInfoService menuInfoService) {
		this.menuInfoService = menuInfoService;
	}


}
