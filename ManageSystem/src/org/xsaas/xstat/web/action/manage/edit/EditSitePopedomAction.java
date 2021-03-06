package org.xsaas.xstat.web.action.manage.edit;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.PopedomTypeConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.ISitePopedomInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.SitePopedomInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditSitePopedomAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7332811562714125510L;
	private static Log logger = LogFactory.getLog(EditSitePopedomAction.class);
	private ISitePopedomInfoService sitePopedomInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;
	private Long sitePopedomID = null;

	private List<String> acList = new LinkedList<String>();
	
	private Long employeeID = null;

	@Override
	public String execute() throws Exception {		
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			SitePopedomInfo info = null;
			HttpServletRequest request = org.apache.struts2.ServletActionContext.getRequest();
			String[] popedomValue = request.getParameterValues("popedom");//id唯一，但是值为多个。
			EmployeeInfo ei = (EmployeeInfo) ActionContext.getContext().getSession().get("EMPLOYEE");
			
			if(popedomValue != null){
				int len = popedomValue.length;
		
				for(int i=0;i<len;i++){
					String str = popedomValue[i];
					info = (SitePopedomInfo) ActionContext.getContext().getSession().get("SITEPOPEDOMLIST");
					int num = new Integer(str).intValue();
					info.setPopedom(num);
					info.setEmployeeID(ei.getEmployeeID());
					sitePopedomInfoService.updateSitePopedomInfo(info);	
				}
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}


	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		if(username == null || password == null) {
			return LOGIN;
		}
		try{
			if (sitePopedomID == null) {
				this.addActionError("编号为空！");
				return ERROR;
			}
			SitePopedomInfo info = sitePopedomInfoService.getSitePopedomInfo(sitePopedomID);
			ActionContext.getContext().getSession().put("SITEPOPEDOMLIST", info);
			ActionContext.getContext().getSession().put("POPEDOMLIST",PopedomTypeConstants.sitePopedomDict);
			
			List<EmployeeInfo> list = employeeInfoService.getEmployeeInfoList();
			ActionContext.getContext().getSession().put("SITEPOPEDOMLIST", list);
			// ActionContext.getContext().getSession().put("POPEDOMLIST",PopedomTypeConstants.sitePopedomDict);
			EmployeeInfo ei = (EmployeeInfo) ActionContext.getContext().getSession().get("EMPLOYEE");
			if (ei == null) {
				this.addActionError("Session失效,请重新登陆");
			} else {
				// long selectId =
				// (Long)ActionContext.getContext().getSession().get("ID");
				List<SitePopedomInfo> pagList = sitePopedomInfoService.findSitePopedomInfoByPage(ei.getEmployeeID(), 0,	Integer.MAX_VALUE);
				LinkedHashMap<Integer, String> pList = PopedomTypeConstants.sitePopedomDict;
				LinkedHashMap<Integer, String> piMap = new LinkedHashMap<Integer, String>();
				LinkedHashMap<Integer, String> piMapn = new LinkedHashMap<Integer, String>();
				if (pagList != null) {
					for (SitePopedomInfo spi : pagList) {
						piMap.put(spi.getPopedom(),	PopedomTypeConstants.sitePopedomDict.get(spi.getPopedom()));
					}

					for (Integer key : pList.keySet()) {
						if (!piMap.containsKey(key)) {
							piMapn.put(key, pList.get(key));
//						} else {
//							piMap.put(key, PopedomTypeConstants.sitePopedomDict
//									.get(key));
						}

					}
					ActionContext.getContext().getSession().put("HADPOPLIST",piMap);
					ActionContext.getContext().getSession().put("POPEDOMLIST",piMapn);
					// for(SitePopedomInfo sp : pagList){
					// pList.remove(sp.getPopedom());
					// }
					// ActionContext.getContext().getSession().put("POPEDOMLIST",pList);
				} else {
					ActionContext.getContext().getSession().put("POPEDOMLIST",
							PopedomTypeConstants.sitePopedomDict);
				}
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}
	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public List<String> getAcList() {
		return acList;
	}

	public void setAcList(List<String> acList) {
		this.acList = acList;
	}


	public Long getSiteID() {
		return employeeID;
	}

	public void setSiteID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public void setSitePopedomInfoService(
			ISitePopedomInfoService sitePopedomInfoService) {
		this.sitePopedomInfoService = sitePopedomInfoService;
	}


	public Long getSitePopedomID() {
		return sitePopedomID;
	}


	public void setSitePopedomID(Long sitePopedomID) {
		this.sitePopedomID = sitePopedomID;
	}

}