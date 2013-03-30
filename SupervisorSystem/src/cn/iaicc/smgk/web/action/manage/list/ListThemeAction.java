package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IThemeInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.ThemeInfo;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListThemeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127570233615470183L;
	private static Log logger = LogFactory.getLog(ListThemeAction.class);

	private IThemeInfoService themeInfoService = null;
	private List<String> statusList = new LinkedList<String>();

	private Long themeID = null;
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<ThemeInfo> pageList = null;	
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
			int total = themeInfoService.getThemeInfoTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = themeInfoService.findThemeInfoByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			for(ThemeInfo info:pageList){
				if(pageList != null){
					if(info.getStatus() != null){
						statusList.add(""+StatusConstants.StatusDict.get(info.getStatus()));
					}else{
						statusList.add("");
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

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}
	public PaginationUtil getPu() {
		return pu;
	}
	public Long getThemeID() {
		return themeID;
	}
	public void setThemeID(Long themeID) {
		this.themeID = themeID;
	}
	public void setThemeInfoService(IThemeInfoService themeInfoService) {
		this.themeInfoService = themeInfoService;
	}
	public List<ThemeInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<ThemeInfo> pageList) {
		this.pageList = pageList;
	}

}
