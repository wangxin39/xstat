package cn.iaicc.smgk.web.action.manage.delete;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.ISitePopedomInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.SitePopedomInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteSitePopedomAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7332811562714125510L;
	private static Log logger = LogFactory.getLog(DeleteSitePopedomAction.class);
	private ISitePopedomInfoService sitePopedomInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;


	private Long sitePopedomID = null;



	@Override
	public String execute() throws Exception {

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(sitePopedomID == null)return ERROR;
			SitePopedomInfo info = sitePopedomInfoService.getSitePopedomInfo(sitePopedomID);
			info.setStatus(StatusConstants.SHANCHU);
			sitePopedomInfoService.updateSitePopedomInfo(info);	
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}



	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}



	public Long getSitePopedomID() {
		return sitePopedomID;
	}



	public void setSitePopedomID(Long sitePopedomID) {
		this.sitePopedomID = sitePopedomID;
	}



	public void setSitePopedomInfoService(
			ISitePopedomInfoService sitePopedomInfoService) {
		this.sitePopedomInfoService = sitePopedomInfoService;
	}
	

	
}
