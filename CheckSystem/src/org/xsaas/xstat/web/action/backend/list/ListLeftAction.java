package org.xsaas.xstat.web.action.backend.list;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.xsaas.xstat.business.ISmgkMenuInfoService;
import org.xsaas.xstat.po.SmgkMenuInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListLeftAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 744972483952628319L;
	private static Log logger = LogFactory.getLog(ListLeftAction.class);
	private ISmgkMenuInfoService smgkMenuInfoService = null;
	/**
	 * �?��菜单列表
	 */
	private List<SmgkMenuInfo> menusList = null;
	/**
	 * �?��菜单数量
	 */
	private int length = 0;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}
	/**
	 * 处理菜单显示
	 * @return 成功(SUCCESS),失败(ERROR)
	 */
	public String initMenu() {
		
		menusList = smgkMenuInfoService.getSmgkMenuInfoList();
		length = menusList.size();
		return SUCCESS;
	}

	public List<SmgkMenuInfo> getMenusList() {
		return menusList;
	}

	public int getLength() {
		return length;
	}

	public void setSmgkMenuInfoService(ISmgkMenuInfoService smgkMenuInfoService) {
		this.smgkMenuInfoService = smgkMenuInfoService;
	}

}
