package cn.iaicc.smgk.web.action.manage.delete;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IMenuInfoService;
import cn.iaicc.smgk.po.MenuInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteMenuAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -495705973840811829L;
	private static Log logger = LogFactory.getLog(DeleteMenuAction.class);
	private IMenuInfoService menuInfoService = null;

	private Long menuID = null;

	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			if(menuID == null){
				return ERROR;
			}
			MenuInfo info = menuInfoService.getMenuInfo(menuID);
			info.setStatus(StatusConstants.SHANCHU);
			menuInfoService.updateMenuInfo(info);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}


	public void setMenuInfoService(IMenuInfoService menuInfoService) {
		this.menuInfoService = menuInfoService;
	}

	public Long getMenuID() {
		return menuID;
	}

	public void setMenuID(Long menuID) {
		this.menuID = menuID;
	}

}
