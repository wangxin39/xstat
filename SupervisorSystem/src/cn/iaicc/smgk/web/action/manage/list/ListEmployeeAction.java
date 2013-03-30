package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListEmployeeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248039003761278571L;
	private static Log logger = LogFactory.getLog(ListEmployeeAction.class);

	private List<String> statList = new LinkedList<String>();
	private IEmployeeInfoService employeeInfoService = null;
	private Long employeeID = null;

	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<EmployeeInfo> pageList = null;	
	
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
			int total = employeeInfoService.getEmployeeInfoTotal();
			pu = new PaginationUtil(total, page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = employeeInfoService.findEmployeeInfoByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
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
			if(employeeID == null) {
				logger.debug("employeeID:"+employeeID);
				this.addActionError("编号为空！");
				return ERROR;
			}
			EmployeeInfo info = employeeInfoService.getEmployeeInfo(employeeID);
			if(info != null){
				ActionContext.getContext().put("EMPLOYEEETAIL",info);
				
			}
			if(info.getStatus()!=null){
				ActionContext.getContext().put("STATUS",StatusConstants.EmStatusDict.get(info.getStatus()));
			}			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		
		
		return SUCCESS;
	}		
	
		
	public Integer getNum() {
		return num;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}


	public List<String> getStatList() {
		return statList;
	}

	public void setStatList(List<String> statList) {
		this.statList = statList;
	}

	public PaginationUtil getPu() {
		return pu;
	}
	public List<EmployeeInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<EmployeeInfo> pageList) {
		this.pageList = pageList;
	}
}
