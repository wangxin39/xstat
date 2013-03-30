package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IAddressCatalogInfoService;
import cn.iaicc.smgk.business.IEmailAddressInfoService;
import cn.iaicc.smgk.po.AddressCatalogInfo;
import cn.iaicc.smgk.po.EmailAddressInfo;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListAddressAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7332811562714125510L;
	private static Log logger = LogFactory.getLog(ListAddressAction.class);
	private IEmailAddressInfoService emailAddressInfoService = null;
	private IAddressCatalogInfoService addressCatalogInfoService = null;

	private List<String> acList = new LinkedList<String>();
	private List<String> cityList = new LinkedList<String>();

	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<EmailAddressInfo> pageList = null;
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
			if(num != null){
				page = num.intValue();
			}
			int total = emailAddressInfoService.getEmailAddressInfoTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = emailAddressInfoService.findEmailAddressInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			for(EmailAddressInfo info:pageList){
				if(pageList != null){
					AddressCatalogInfo acInfo = addressCatalogInfoService.getAddressCatalogInfo(info.getAcID());
					if(acInfo != null){
						acList.add(""+acInfo.getName());
					}else{
						acList.add("");
					}
				}else{
					this.addActionMessage("数据库中没有数据!");
				}
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}
			


	
	public List<String> getAcList() {
		return acList;
	}

	public void setAcList(List<String> acList) {
		this.acList = acList;
	}


	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setEmailAddressInfoService(
			IEmailAddressInfoService emailAddressInfoService) {
		this.emailAddressInfoService = emailAddressInfoService;
	}

	public void setAddressCatalogInfoService(
			IAddressCatalogInfoService addressCatalogInfoService) {
		this.addressCatalogInfoService = addressCatalogInfoService;
	}

	public List<String> getCityList() {
		return cityList;
	}

	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}

	public java.util.List<EmailAddressInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<EmailAddressInfo> pageList) {
		this.pageList = pageList;
	}
	public PaginationUtil getPu() {
		return pu;
	}

}
