package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IOptionInfoService;

import org.xsaas.xstat.po.OptionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListQuestionOptionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6466443869055598571L;
	private static Log logger = LogFactory.getLog(ListQuestionOptionAction.class);

	private IOptionInfoService optionInfoService = null;
	private List<String> questionList = new LinkedList<String>();
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
			if(num != null){
				page = num.intValue();
			}
			int total = optionInfoService.getTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = optionInfoService.findByPage(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
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

	public List<String> getQuestionList() {
		return questionList;
	}


	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}

	public List<OptionInfo> getPageList() {
		return pageList;
	}

	public void setPageList(List<OptionInfo> pageList) {
		this.pageList = pageList;
	}

	public PaginationUtil getPu() {
		return pu;
	}

	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}
}
