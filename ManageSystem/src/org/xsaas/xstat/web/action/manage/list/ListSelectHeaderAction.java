package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IInquisitionHeaderInfoService;
import org.xsaas.xstat.business.IInquisitionHeaderSelectInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.po.InquisitionHeaderInfo;
import org.xsaas.xstat.po.InquisitionHeaderSelectInfo;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.OptionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListSelectHeaderAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8154573800306729423L;
	private static Log logger = LogFactory.getLog(ListSelectHeaderAction.class);
	private IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IInquisitionHeaderInfoService inquisitionHeaderInfoService = null;
	private IOptionInfoService optionInfoService = null;
	
	private List<String> optionList = new LinkedList<String>();
	private List<String> selectList = new LinkedList<String>();
	
	private Long headerID = null;
	
	private Long headerSelectID = null;
	
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<InquisitionHeaderSelectInfo> pageList = null;

	private PaginationUtil pu = null;	
	private Integer total = null;

			
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
			
			//先添加表头信息
			Long selectHeaderID = (Long)ActionContext.getContext().getSession().get("HEADERID");			
			if(headerID != null) {
				selectHeaderID = headerID;
				ActionContext.getContext().getSession().put("HEADERID",selectHeaderID);
			}
			logger.debug("headerID:"+selectHeaderID);
			InquisitionHeaderInfo inquisitionHeaderInfo = null;			
			if(selectHeaderID != null)
			{
				inquisitionHeaderInfo = inquisitionHeaderInfoService.getInquisitionHeaderInfo(selectHeaderID);
				ActionContext.getContext().getSession().put("HEADERLIST",inquisitionHeaderInfo);
				total = inquisitionHeaderSelectInfoService.getTotal(selectHeaderID);
			}else{
				total = inquisitionHeaderSelectInfoService.getTotal();			
			}		
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);

			if(selectHeaderID != 0) {
				pageList = inquisitionHeaderSelectInfoService.findByPage(selectHeaderID,pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}else{
				pageList = inquisitionHeaderSelectInfoService.findByPage(pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);			
			}
			optionList.clear();
			selectList.clear();
			
			OptionInfo optionInfo = null;			
			for(InquisitionHeaderSelectInfo info:pageList){				
				if(info.getOptionID() != null) {
					optionInfo = optionInfoService.getOptionInfo(info.getOptionID());
					if(optionInfo != null) {
						optionList.add(""+optionInfo.getChinaOption());						
					}
				}else{
					optionList.add("");								
				}				
				if(info.getAlterID() != null) {
					optionInfo = optionInfoService.getOptionInfo(info.getAlterID());
					selectList.add(""+optionInfo.getChinaOption());				
				}else{
					selectList.add("");				
				}
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
			if(headerSelectID == null) return ERROR;
			InquisitionHeaderSelectInfo info = inquisitionHeaderSelectInfoService.getInfo(headerSelectID);
			if(info != null){
				ActionContext.getContext().put("ISELECTLIST",info);
				ActionContext.getContext().put("SELECTVALUE",QuestionTypeConstants.OptionValueDict);
			}
			
			InquisitionHeaderInfo ihi = inquisitionHeaderInfoService.getInquisitionHeaderInfo(info.getHeaderID());
			if(ihi != null && ihi.getFieldName() != null){
				ActionContext.getContext().put("HEADEREDIT",ihi.getFieldName());
			}
			
			InquisitionInfo ii = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID()); 
			OptionInfo oi = optionInfoService.getOptionInfo(info.getAlterID());
			if(oi != null && oi.getChinaOption() != null){
				ActionContext.getContext().put("SELECTLIST",oi.getChinaOption());
			}
			if(ii != null && ii.getTitle() != null){
				ActionContext.getContext().put("INQUISITIONLIST",ii.getTitle());
				
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

	public void setInquisitionHeaderInfoService(
			IInquisitionHeaderInfoService inquisitionHeaderInfoService) {
		this.inquisitionHeaderInfoService = inquisitionHeaderInfoService;
	}
	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}
	public List<InquisitionHeaderSelectInfo> getPageList() {
		return pageList;
	}
	public PaginationUtil getPu() {
		return pu;
	}
	public List<String> getSelectList() {
		return selectList;
	}

	public void setInquisitionHeaderSelectInfoService(
			IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService) {
		this.inquisitionHeaderSelectInfoService = inquisitionHeaderSelectInfoService;
	}
	public void setPu(PaginationUtil pu) {
		this.pu = pu;
	}
	
	public Long getHeaderID() {
		return headerID;
	}
	public void setHeaderID(Long headerID) {
		this.headerID = headerID;
	}
	public Long getHeaderSelectID() {
		return headerSelectID;
	}
	public void setHeaderSelectID(Long headerSelectID) {
		this.headerSelectID = headerSelectID;
	}


	public Integer getTotal() {
		return total;
	}


	public List<String> getOptionList() {
		return optionList;
	}
}
