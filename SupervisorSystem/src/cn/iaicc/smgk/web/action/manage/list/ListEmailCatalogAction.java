package cn.iaicc.smgk.web.action.manage.list;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IAddressCatalogInfoService;
import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.po.AddressCatalogInfo;
import cn.iaicc.smgk.po.EmployeeInfo;

import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListEmailCatalogAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(ListEmailCatalogAction.class);
	private IAddressCatalogInfoService addressCatalogInfoService = null;

	private Long acID = null;
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<AddressCatalogInfo> pageList = null;
	
	private PaginationUtil pu = null;	
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
			int total = addressCatalogInfoService.getAddressCatalogInfoTotal();
			pu = new PaginationUtil(total, page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = addressCatalogInfoService.findAddressCatalogInfoByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}
			

			
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}


	public void setAddressCatalogInfoService(
			IAddressCatalogInfoService addressCatalogInfoService) {
		this.addressCatalogInfoService = addressCatalogInfoService;
	}

	public Long getAcID() {
		return acID;
	}

	public void setAcID(Long acID) {
		this.acID = acID;
	}
	public List<AddressCatalogInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<AddressCatalogInfo> pageList) {
		this.pageList = pageList;
	}
	public PaginationUtil getPu() {
		return pu;
	}


}
