package cn.iaicc.smgk.web.action.manage.list;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IMenuInfoService;
import cn.iaicc.smgk.po.MenuInfo;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListMenuAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -495705973840811829L;
	private static Log logger = LogFactory.getLog(ListMenuAction.class);
	private IMenuInfoService menuInfoService = null;
	private Long menuID = null;
	
	public Long getMenuID() {
		return menuID;
	}

	public void setMenuID(Long menuID) {
		this.menuID = menuID;
	}
	
	private List<String> systemList = null;
	private List<String> fatherList = null;
	
	private List<MenuInfo> pageList = null;
	

	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			long selectMenuID = 0;
			if(menuID != null) {
				selectMenuID = menuID;
			}
			systemList = new java.util.LinkedList<String>();
			fatherList = new java.util.LinkedList<String>();			
			pageList = menuInfoService.getMenuInfoList(selectMenuID, QuestionTypeConstants.SITESYSTEM);
			
			for(MenuInfo mi:pageList) {
				if(mi.getType() != null) {
					systemList.add(""+QuestionTypeConstants.MenuTypeDict.get(mi.getType()));					
				}else{
					systemList.add("");					
				}
				if(mi.getParentID() != null && mi.getParentID() > 0) {
					MenuInfo info = menuInfoService.getMenuInfo(mi.getParentID());
					if(info != null) {
						fatherList.add(""+info.getMenu());						
					}else{
						fatherList.add("无");						
					}
				}else{
					fatherList.add("无");											
				}
			}
		
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}


	
	public void setMenuInfoService(IMenuInfoService menuInfoService) {
		this.menuInfoService = menuInfoService;
	}
	public List<String> getSystemList() {
		return systemList;
	}

	public List<String> getFatherList() {
		return fatherList;
	}

	public List<MenuInfo> getPageList() {
		return pageList;
	}

}
