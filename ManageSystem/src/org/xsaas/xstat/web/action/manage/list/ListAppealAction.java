package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.conf.StatusConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IClientAccountInfoService;
import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IReqInfoService;
import org.xsaas.xstat.po.ClientAccountInfo;
import org.xsaas.xstat.po.EmployeeInfo;

import org.xsaas.xstat.po.ReqInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListAppealAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6142593724307137364L;
	private static Log logger = LogFactory.getLog(ListAppealAction.class);
	private IReqInfoService reqInfoService = null;
	
	private IEmployeeInfoService employeeInfoService = null;
	private IClientAccountInfoService clientAccountInfoService = null;
	
	private List<String> clientAccountList = new LinkedList<String>();
	private List<String> employeeList = new LinkedList<String>();
	private List<String> statusList = new LinkedList<String>();
	private Long reqID = null;
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<ReqInfo> pageList = null;
	private PaginationUtil pu = null;		
		
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
			if(num != null){
				page = num.intValue();
			}
			
			int total = reqInfoService.getReqInfoTotal();
			
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = reqInfoService.findReqInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			
			for(ReqInfo info:pageList){
				
				ClientAccountInfo ci = clientAccountInfoService.getClientAccountInfo(info.getAccountID());
				if(ci != null){
					clientAccountList.add(""+ci.getClientName());
					
				}
				else{
					clientAccountList.add("");
				}
				if(info.getEmployeeID() != 0) {
					EmployeeInfo ei = employeeInfoService.getEmployeeInfo(info.getEmployeeID());				
					if(ei != null) {
						employeeList.add(""+ei.getName());					
					}
				}else{
					employeeList.add("");				
				}
				if(info.getStatus() != null) {
					statusList.add(""+StatusConstants.ReStatusDict.get(info.getStatus()));	
					
				}else{
					statusList.add("");				
				}
			}
			ReqInfo ri = null;
			long reqEditID = 0;
			if(reqID != null){
				reqEditID = reqID.longValue();
			}else{
				List<ReqInfo> reqList = reqInfoService.getReqInfoList();
				if(reqList.size()>0){
					ri = reqList.get(0);
					reqEditID = ri.getReqID().longValue();
				}
				ActionContext.getContext().getSession().put("REQLIST",reqList);
			}
			ri = reqInfoService.getReqInfo(reqEditID);
			if(ri!=null){
				ActionContext.getContext().getSession().put("REQINFO",ri);//封装申诉内容
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		return SUCCESS;
	}		

	public String detail() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			if(reqID == null){
				this.addActionError("employeeInfo为空！");
				return ERROR;
			}
			ReqInfo info = reqInfoService.getReqInfo(reqID);
			EmployeeInfo ei = employeeInfoService.getEmployeeInfo(info.getEmployeeID());
			ClientAccountInfo ai = clientAccountInfoService.getClientAccountInfo(info.getAccountID());
			if(info!=null){
				ActionContext.getContext().put("REQDETAIL",info);
			}
			if(ei!=null && ei.getName()!=null){
				ActionContext.getContext().put("EMPLOYEE",ei.getName());
			}
			if(info.getReqStatus()!=null && info.getStatus()!=null){
				ActionContext.getContext().put("REQSTATUS", StatusConstants.ReStatusDict.get(info.getReqStatus()));
				ActionContext.getContext().put("STATUS", StatusConstants.StatusDict.get(info.getStatus()));
			}
			if(ai!=null && ai.getClientName()!=null){
				ActionContext.getContext().put("ACCOUNT",ai.getClientName());
				
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


	public List<String> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<String> employeeList) {
		this.employeeList = employeeList;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public void setReqInfoService(IReqInfoService reqInfoService) {
		this.reqInfoService = reqInfoService;
	}

	public PaginationUtil getPu() {
		return pu;
	}
	public Long getReqID() {
		return reqID;
	}
	public void setReqID(Long reqID) {
		this.reqID = reqID;
	}
	public List<ReqInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<ReqInfo> pageList) {
		this.pageList = pageList;
	}
	public void setClientAccountInfoService(
			IClientAccountInfoService clientAccountInfoService) {
		this.clientAccountInfoService = clientAccountInfoService;
	}
	public void setClientAccountList(List<String> clientAccountList) {
		this.clientAccountList = clientAccountList;
	}
	public List<String> getClientAccountList() {
		return clientAccountList;
	}
}
