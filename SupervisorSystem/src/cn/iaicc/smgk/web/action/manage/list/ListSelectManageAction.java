package cn.iaicc.smgk.web.action.manage.list;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IOptionInfoService;
import cn.iaicc.smgk.po.OptionInfo;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListSelectManageAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2184001068355336965L;
	private static Log logger = LogFactory.getLog(ListSelectManageAction.class);

	private IOptionInfoService optionInfoService = null;
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<OptionInfo> pageList = null;

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
			int total = optionInfoService.getTotal();
			pu = new PaginationUtil(total, page,SmgkConstants.PAGE_MAX_RESULT);		
			pageList = optionInfoService.findByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
			return ERROR;
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

	public List<OptionInfo> getPageList() {
		return pageList;
	}

	public void setPageList(List<OptionInfo> pageList) {
		this.pageList = pageList;
	}


	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}
}
