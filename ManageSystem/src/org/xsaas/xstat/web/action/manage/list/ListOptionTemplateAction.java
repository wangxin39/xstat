package org.xsaas.xstat.web.action.manage.list;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IOptionTemplateInfoService;
import org.xsaas.xstat.po.OptionTemplateInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListOptionTemplateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2533733607855576774L;
	private static Log logger = LogFactory.getLog(ListOptionTemplateAction.class);
	
	private IOptionTemplateInfoService optionTemplateInfoService = null;
	
	
	private Integer num = null;
	private List<OptionTemplateInfo> pageList = null;	
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
			int total = optionTemplateInfoService.getTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = optionTemplateInfoService.getList(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		
		return SUCCESS;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<OptionTemplateInfo> getPageList() {
		return pageList;
	}

	public PaginationUtil getPu() {
		return pu;
	}

	public void setOptionTemplateInfoService(
			IOptionTemplateInfoService optionTemplateInfoService) {
		this.optionTemplateInfoService = optionTemplateInfoService;
	}
}
