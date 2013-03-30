package cn.iaicc.smgk.web.action;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IMenuInfoService;
import cn.iaicc.smgk.po.MenuInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 744972483952628319L;
	private static Log logger = LogFactory.getLog(MenuAction.class);
	
	private IMenuInfoService menuInfoService = null;	
	
	private Integer showMenuID = null;
	
	/**
	 * 一级菜单列表
	 */
	private List<MenuInfo> menusList = null;
	/**
	 * 一级菜单数量
	 */
	private int length = 0;
	/**
	 * 一级菜单映射
	 */
	private Map<String,List<MenuInfo>> menuMap = null;
	/**
	 * 一级菜单下的二级菜单数量映射
	 */
	private Map<String,Integer> menuMapLength = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		long time = System.currentTimeMillis();
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			
			if(username == null || password == null) {
				return LOGIN;
			}
			String sID = (String)ActionContext.getContext().getSession().get("SELECTMENUID");
			if(sID != null) {
				showMenuID = Integer.parseInt(sID);
			}
			if(showMenuID == null) {
				showMenuID = 2;
			}

			menusList = (List<MenuInfo>)ActionContext.getContext().getSession().get("GLOBALMENUINFOLIST");
			menuMap = (Map<String,List<MenuInfo>>)ActionContext.getContext().getSession().get("GLOBALMENUMAP");
			menuMapLength = (Map<String,Integer>)ActionContext.getContext().getSession().get("GLOBALMENUMAPLENGTH");			
			
			// 如果没有初始，则初始化
			if(menusList == null || menuMap == null || menuMapLength == null) {
				// 获取一级菜单
				menusList = menuInfoService.getMenuInfoList(new Long(0), 1);			
				ActionContext.getContext().getSession().put("GLOBALMENUINFOLIST",menusList);
				
				menuMap = new HashMap<String,List<MenuInfo>>();
				menuMapLength = new HashMap<String,Integer>();
				
				List<MenuInfo> subMenuList = null;
				
				// 处理二级菜单的映射
				for(MenuInfo info:menusList) {
					subMenuList = menuInfoService.getMenuInfoList(info.getMenuID(), 1);
					if(subMenuList != null) {
						menuMap.put(info.getMenu(), subMenuList);
						menuMapLength.put(info.getMenu(), subMenuList.size());					
					}
				}	
				
				ActionContext.getContext().getSession().put("GLOBALMENUMAP",menuMap);				
				ActionContext.getContext().getSession().put("GLOBALMENUMAPLENGTH",menuMapLength);
			}
			
			length = menusList.size();
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		logger.debug("读取菜单耗费时间："+(System.currentTimeMillis()-time)+"秒");
		
		return SUCCESS;
	}

	public List<MenuInfo> getMenusList() {
		return menusList;
	}

	public int getLength() {
		return length;
	}

	public void setMenuInfoService(IMenuInfoService menuInfoService) {
		this.menuInfoService = menuInfoService;
	}

	public Map<String, List<MenuInfo>> getMenuMap() {
		return menuMap;
	}

	public Map<String, Integer> getMenuMapLength() {
		return menuMapLength;
	}

	public Integer getShowMenuID() {
		return showMenuID;
	}
}
