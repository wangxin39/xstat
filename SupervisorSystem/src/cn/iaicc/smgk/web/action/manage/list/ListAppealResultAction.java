package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IClientAccountInfoService;
import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IReqInfoService;
import cn.iaicc.smgk.business.IReqResultInfoService;
import cn.iaicc.smgk.po.ClientAccountInfo;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.ReqInfo;
import cn.iaicc.smgk.po.ReqResultInfo;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListAppealResultAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7739475960664629870L;
	private static Log logger = LogFactory.getLog(ListAppealResultAction.class);			
	private IClientAccountInfoService clientAccountInfoService = null;
	private IReqResultInfoService reqResultInfoService= null;
	private IEmployeeInfoService employeeInfoService = null;
	private IReqInfoService reqInfoService= null;
	private List<String> clientAccountList = new LinkedList<String>();
	private List<String> employeeList = new LinkedList<String>();
	private List<String> reqList = new LinkedList<String>();
	
	private Long reqID = null;
	private Long resultID = null;
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<ReqResultInfo> pageList = null;	
	private PaginationUtil pu = null;	
	
		
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
				this.addActionError("employeeInfo为空！");
				return LOGIN;
			}
			
			int page = 1;
			if(num != null){
				page = num.intValue();
			}
			
			int total = reqResultInfoService.getReqResultInfoTotal();
			
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = reqResultInfoService.findReqResultInfoByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			for(ReqResultInfo info:pageList){
				ClientAccountInfo ci = clientAccountInfoService.getClientAccountInfo(info.getAccountID());
				if(ci != null){
					clientAccountList.add(""+ci.getClientName());
				}
				else{
					clientAccountList.add("");
				}
				if( info.getEmployeeID() != null) {
					EmployeeInfo ei = employeeInfoService.getEmployeeInfo(info.getEmployeeID());				
					if(ei != null) {
						employeeList.add(""+ei.getName());					
					}
				}else{
					employeeList.add("");				
				}
				ReqInfo ri = reqInfoService.getReqInfo(info.getReqID());
				if(ri!=null && ri.getName()!=null){
					reqList.add(""+ri.getName());
				}else{
					reqList.add("");
				}
				
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}


		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		if(username == null || password == null) {
			return LOGIN;
		}
		try{
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息			
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

			if(resultID == null){
				this.addActionError("resultID为空！");
				return ERROR;
			}
			ReqResultInfo info = reqResultInfoService.getReqResultInfo(resultID);
			if(info!=null && info.getStatus()!=null){
				ActionContext.getContext().put("RESULTDETAIL",info);
				ActionContext.getContext().put("STATUS", StatusConstants.StatusDict.get(info.getStatus()));
			}
			ReqInfo ri = reqInfoService.getReqInfo(info.getReqID());
			ClientAccountInfo ci = clientAccountInfoService.getClientAccountInfo(info.getAccountID());
			EmployeeInfo ei = employeeInfoService.getEmployeeInfo(info.getEmployeeID());
			if(ri!=null && ri.getName()!=null){
				ActionContext.getContext().put("REQINOF",ri.getName());
			}
			if(ci!=null && ci.getClientName()!=null){
				ActionContext.getContext().put("ACCOUNT",ci.getClientName());
			}
			if(ei!=null && ei.getName()!=null){
				ActionContext.getContext().put("EMPLOYEE",ei.getName());
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

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}
	public PaginationUtil getPu() {
		return pu;
	}

	public void setReqResultInfoService(IReqResultInfoService reqResultInfoService) {
		this.reqResultInfoService = reqResultInfoService;
	}
	public List<ReqResultInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<ReqResultInfo> pageList) {
		this.pageList = pageList;
	}

	public void setPu(PaginationUtil pu) {
		this.pu = pu;
	}

	public void setClientAccountInfoService(
			IClientAccountInfoService clientAccountInfoService) {
		this.clientAccountInfoService = clientAccountInfoService;
	}
	public void setClientAccountList(List<String> clientAccountList) {
		this.clientAccountList = clientAccountList;
	}
	public List<String> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<String> employeeList) {
		this.employeeList = employeeList;
	}
	public List<String> getClientAccountList() {
		return clientAccountList;
	}
	public List<String> getReqList() {
		return reqList;
	}
	public void setReqList(List<String> reqList) {
		this.reqList = reqList;
	}
	public void setReqInfoService(IReqInfoService reqInfoService) {
		this.reqInfoService = reqInfoService;
	}
	public Long getResultID() {
		return resultID;
	}
	public void setResultID(Long resultID) {
		this.resultID = resultID;
	}
	public Long getReqID() {
		return reqID;
	}
	public void setReqID(Long reqID) {
		this.reqID = reqID;
	}
	
}
