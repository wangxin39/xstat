package cn.iaicc.smgk.web.action.manage.add;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IMenuInfoService;
import cn.iaicc.smgk.po.MenuInfo;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddMenuActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -495705973840811829L;
	private static Log logger = LogFactory.getLog(AddMenuActions.class);
	
	private IMenuInfoService menuInfoService = null;

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
				MenuInfo info = new MenuInfo();
				if(menu != null) {
					info.setMenu(menu);
				}
				if(parentID != null) {
					info.setParentID(parentID);					
				}else{
					info.setParentID(new Long(0));	 // 默认为0，如果是一级菜单				
				}
				if(type != null) {
					info.setType(type);					
				}
				if(url != null) {
					info.setUrl(url);					
				}
				info.setStatus(StatusConstants.ZHENGCHANG);
				menuInfoService.saveMenuInfo(info);
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
			// 如果为空，则为一级菜单添加，不处理上级菜单问题
			if(menuID != null) {				
				MenuInfo mi = menuInfoService.getMenuInfo(menuID);
				ActionContext.getContext().put("FATHERMENUINFO",mi);
			}
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
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
