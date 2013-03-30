package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.ISmgkInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.SmgkInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListSmgkSelectAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6466443869055598571L;
	private static Log logger = LogFactory.getLog(ListSmgkSelectAction.class);
	private ISmgkInfoService smgkInfoService = null;


	private List<String> smgkList = new LinkedList<String>();
	private List<String> authList = new LinkedList<String>();

	private List<String> statusList = new LinkedList<String>();
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<SmgkInfo> pageList = null;	
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
			int total = smgkInfoService.getSmgkInfoTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = smgkInfoService.findSmgkInfoByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			for(SmgkInfo info:pageList){
				if(pageList != null){
					if(info.getStatus() != null){
						statusList.add(""+StatusConstants.SmgStatusDict.get(info.getStatus()));
					}else{
						statusList.add("");
					}
					if(info.getAuthStatus()!= null){
						authList.add(""+StatusConstants.AuStatusDict.get(info.getAuthStatus()));
					}else{
						authList.add("");
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
			
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	public PaginationUtil getPu() {
		return pu;
	}

	public List<String> getSmgkList() {
		return smgkList;
	}

	public void setSmgkList(List<String> smgkList) {
		this.smgkList = smgkList;
	}

	public List<String> getAuthList() {
		return authList;
	}

	public void setAuthList(List<String> authList) {
		this.authList = authList;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public List<SmgkInfo> getPageList() {
		return pageList;
	}

	public void setPageList(List<SmgkInfo> pageList) {
		this.pageList = pageList;
	}

	public void setSmgkInfoService(ISmgkInfoService smgkInfoService) {
		this.smgkInfoService = smgkInfoService;
	}

}
