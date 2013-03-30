package org.xsaas.xstat.web.action.manage.list;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IGradeStdInfoService;
import org.xsaas.xstat.po.GradeStdInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListGradeStdAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1200835414721769503L;
	private static Log logger = LogFactory.getLog(ListGradeStdAction.class);
	
	private IGradeStdInfoService gradeStdInfoService = null;
	
	private Long inquisitionID = null;
	
	private Integer num = null;
	
	private List<GradeStdInfo> pageList = null;
	private Map<String,String> pageNumList = null;
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
			if(num != null) {
				page = num.intValue();
			}
			
			int total = gradeStdInfoService.getTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = gradeStdInfoService.findByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);			
		
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}

	public List<GradeStdInfo> getPageList() {
		return pageList;
	}	
	public void setGradeStdInfoService(IGradeStdInfoService gradeStdInfoService) {
		this.gradeStdInfoService = gradeStdInfoService;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Map<String, String> getPageNumList() {
		return pageNumList;
	}
	public PaginationUtil getPu() {
		return pu;
	}
	public Long getInquisitionID() {
		return inquisitionID;
	}
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}


}
