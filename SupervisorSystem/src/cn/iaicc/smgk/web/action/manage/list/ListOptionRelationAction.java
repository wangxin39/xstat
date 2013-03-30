package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IOptionInfoService;
import cn.iaicc.smgk.business.IOptionRelationInfoService;
import cn.iaicc.smgk.business.IOptionTemplateInfoService;
import cn.iaicc.smgk.po.OptionInfo;
import cn.iaicc.smgk.po.OptionRelationInfo;
import cn.iaicc.smgk.po.OptionTemplateInfo;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListOptionRelationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6356055607864871573L;
	private static Log logger = LogFactory.getLog(ListOptionRelationAction.class);
	private IOptionRelationInfoService optionRelationInfoService = null;	
	private IOptionTemplateInfoService optionTemplateInfoService = null;
	private IOptionInfoService optionInfoService = null;
	
	private Integer num = null;
	private List<OptionRelationInfo> pageList = null;	
	private PaginationUtil pu = null;	
	
	
	private List<String> templateList = new LinkedList<String>();
	private List<String> alterList = new LinkedList<String>();
	private List<String> optionList = new LinkedList<String>();
	
	
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
			int total = optionRelationInfoService.getTotal();
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = optionRelationInfoService.getList(pu.getStartRecord(), SmgkConstants.PAGE_MAX_RESULT);
			
			templateList.clear();
			alterList.clear();
			optionList.clear();
			
			OptionTemplateInfo oti = null;
			OptionInfo oi = null;
			
			
			for(OptionRelationInfo info:pageList) {
				if(info.getOptionTemplateID() != null) {
					oti = optionTemplateInfoService.getOptionTemplateInfo(info.getOptionTemplateID());
					if(oti != null) {
						templateList.add(""+oti.getTitle());
					}else{
						templateList.add("");
					}
				}
				if(info.getAlterID() != null) {
					oi = optionInfoService.getOptionInfo(info.getAlterID());
					if(oi != null) {
						alterList.add(""+oi.getChinaOption());
					}else{
						alterList.add("");
					}
				}
				if(info.getOptionID() != null) {
					oi = optionInfoService.getOptionInfo(info.getOptionID());
					if(oi != null) {
						optionList.add(""+oi.getChinaOption());
					}else{
						optionList.add("");
					}
				}			
			}
			
			
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

	public List<OptionRelationInfo> getPageList() {
		return pageList;
	}

	public PaginationUtil getPu() {
		return pu;
	}

	public void setOptionRelationInfoService(
			IOptionRelationInfoService optionRelationInfoService) {
		this.optionRelationInfoService = optionRelationInfoService;
	}

	public List<String> getTemplateList() {
		return templateList;
	}

	public List<String> getAlterList() {
		return alterList;
	}

	public List<String> getOptionList() {
		return optionList;
	}

	public void setOptionTemplateInfoService(
			IOptionTemplateInfoService optionTemplateInfoService) {
		this.optionTemplateInfoService = optionTemplateInfoService;
	}

	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}

}
