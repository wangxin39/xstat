package org.xsaas.xstat.web.action.manage.ajax;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;

import org.xsaas.xstat.business.IOptionTemplateInfoService;
import org.xsaas.xstat.po.OptionTemplateInfo;

import com.opensymphony.xwork2.ActionSupport;

public class JsonOptionTemplateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2143364316144401148L;
	private static Log logger = LogFactory.getLog(JsonOptionTemplateAction.class);
	private IOptionTemplateInfoService optionTemplateInfoService = null;
	
	
	private List<OptionTemplateInfo> pageList = null;
	
	private Integer total = 0;
	
	private Integer start = 0;
	private Integer limit = 0;
	
	@Override
	public String execute() throws Exception {
		try{
			if(limit == 0 || limit == null) {
				limit = SmgkConstants.PAGE_MAX_RESULT;
			}
			pageList = optionTemplateInfoService.getList(start, limit);
			if(pageList != null) {
				total = pageList.size();				
			}
			logger.debug("start:"+start+"|limit:"+limit+"|total:"+total);		
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}

	public Integer getTotal() {
		return total;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public List<OptionTemplateInfo> getPageList() {
		return pageList;
	}

	public void setOptionTemplateInfoService(
			IOptionTemplateInfoService optionTemplateInfoService) {
		this.optionTemplateInfoService = optionTemplateInfoService;
	}
	
	
}
