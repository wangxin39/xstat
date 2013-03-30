package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.ISitePopedomInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;

import cn.iaicc.smgk.po.SitePopedomInfo;
import cn.iaicc.smgk.web.conf.PopedomTypeConstants;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListSitePopedomAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7332811562714125510L;
	private static Log logger = LogFactory.getLog(ListSitePopedomAction.class);
	private ISitePopedomInfoService sitePopedomInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;
	private List<String> popedomList = new LinkedList<String>();
	private List<String> eList = new LinkedList<String>();
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<SitePopedomInfo> pageList = null;
	private PaginationUtil pu = null;
	private Long sitePopedomID = null;
	private Long employeeID = null;

	public String ajax() throws Exception {
		return SUCCESS;
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
			int page = 1;
			if (num != null) {
				page = num.intValue();
			}
			
			int total = 0;
			long selectID = 0;
			if (employeeID != null) {
				selectID = employeeID.longValue();
				ActionContext.getContext().getSession().put("ID", selectID);
			} else {
				selectID = (Long) ActionContext.getContext().getSession().get(
						"ID");
			}
			EmployeeInfo ei = employeeInfoService.getEmployeeInfo(selectID);
			ActionContext.getContext().getSession().put("EMPLOYEE", ei);

			if (selectID != 0) {
				total = sitePopedomInfoService
						.getSitePopedomInfoTotal(selectID);
			} else {
				total = sitePopedomInfoService.getSitePopedomInfoTotal();
			}

			pu = new PaginationUtil(total, page, SmgkConstants.PAGE_MAX_RESULT);
			if (selectID != 0) {
				pageList = sitePopedomInfoService.findSitePopedomInfoByPage(
						selectID, pu.getStartRecord(),
						SmgkConstants.PAGE_MAX_RESULT);
			} else {
				pageList = sitePopedomInfoService.findSitePopedomInfoByPage(pu
						.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			}

			for (SitePopedomInfo info : pageList) {
				if (pageList != null) {
					EmployeeInfo employeeInfo1 = employeeInfoService
							.getEmployeeInfo(info.getEmployeeID());
					if (employeeInfo1 != null) {
						eList.add("" + employeeInfo1.getName());
					} else {
						eList.add("");
					}
					if (info.getPopedom() != null) {
						popedomList.add(""
								+ PopedomTypeConstants.sitePopedomDict
										.get(new Integer(info.getPopedom())));
					} else {
						popedomList.add("");
					}
				} else {
					this.addActionMessage("数据库中没有数据!");
				}

			}	
		} catch (Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		return SUCCESS;
	}



	public List<String> getEList() {
		return eList;
	}

	public Long getSitePopedomID() {
		return sitePopedomID;
	}

	public void setSitePopedomID(Long sitePopedomID) {
		this.sitePopedomID = sitePopedomID;
	}

	public void setEList(List<String> list) {
		eList = list;
	}

	public List<String> getPopedomList() {
		return popedomList;
	}

	public void setPopedomList(List<String> popedomList) {
		this.popedomList = popedomList;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setSitePopedomInfoService(
			ISitePopedomInfoService sitePopedomInfoService) {
		this.sitePopedomInfoService = sitePopedomInfoService;
	}

	public List<SitePopedomInfo> getPageList() {
		return pageList;
	}

	public void setPageList(List<SitePopedomInfo> pageList) {
		this.pageList = pageList;
	}
	public PaginationUtil getPu() {
		return pu;
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
}
