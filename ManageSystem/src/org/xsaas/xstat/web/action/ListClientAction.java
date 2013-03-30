package org.xsaas.xstat.web.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IClientInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;

import org.xsaas.xstat.po.ClientInfo;
import org.xsaas.xstat.po.EmployeeInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListClientAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7568400183849106961L;
	private static Log logger = LogFactory.getLog(ListClientAction.class);
	private IClientInfoService clientInfoService = null;
	private IEmployeeInfoService employeeInfoService = null;

	
	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<ClientInfo> pageList = null;	
	/**
	 * 总页数
	 */
	private String totalPageNum = null;
	
	private PaginationUtil pu = null;
	
	public Long clientID = null;
	
	@Override
	public String execute() throws Exception {
		
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			EmployeeInfo employeeInfo = employeeInfoService.isLogin(username, password);
			if(employeeInfo == null) {
				return LOGIN;
			}
			int page = 1;
			if(num != null) {
				page = num.intValue();
			}
			
			int total = clientInfoService.getClientInfoTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = clientInfoService.findClientInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			
			java.util.Map<String,String> pageNumList = new java.util.LinkedHashMap<String,String>();
			for(int i=1;i<=pu.getTotalPageNum();i++) {
				pageNumList.put(""+i,""+i);
			}
			totalPageNum = ""+pu.getTotalPageNum();
			ActionContext.getContext().put("PAGENUMLIST", pageNumList);						
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}
	public String detail() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			if(clientID != null) {
				ClientInfo info = clientInfoService.getClientInfo(clientID);
				if(info != null && info.getStatus()!=null){
					ActionContext.getContext().put("CLIENTINFODETAIL",info);
					ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));
				}
				
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}		
	
	// 增加输入界面
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}	
	// 修改界面
	@SuppressWarnings("unchecked")
	public String edit() throws Exception {	
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			if(clientID != null) {
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");
				ClientInfo info = clientInfoService.getClientInfo(clientID);
				ActionContext.getContext().getSession().put("CLIENTINFOEDIT",info);	
				ActionContext.getContext().getSession().put("STATUS",StatusConstants.StatusDict);	
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}			
	public void setclientInfoService(
			IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}
	
	public void setClientInfoService(IClientInfoService clientInfoService) {
		this.clientInfoService = clientInfoService;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<ClientInfo> getPageList() {
		return pageList;
	}

	public void setPageList(List<ClientInfo> pageList) {
		this.pageList = pageList;
	}

	public String getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(String totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public Long getClientID() {
		return clientID;
	}
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	public PaginationUtil getPu() {
		return pu;
	}
}
