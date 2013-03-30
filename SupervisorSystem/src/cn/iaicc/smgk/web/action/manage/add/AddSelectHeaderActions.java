package cn.iaicc.smgk.web.action.manage.add;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IInquisitionHeaderSelectInfoService;
import cn.iaicc.smgk.business.IOptionInfoService;

import cn.iaicc.smgk.po.InquisitionHeaderInfo;
import cn.iaicc.smgk.po.InquisitionHeaderSelectInfo;
import cn.iaicc.smgk.po.OptionInfo;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddSelectHeaderActions extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8122202414454388824L;
	private static Log logger = LogFactory.getLog(AddSelectHeaderActions.class);
	private IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService = null;
	private IOptionInfoService optionInfoService = null;

	
	private Long inquisitionID = null;
	private Long headerID = null;
	private Long alterID = null;
	private String showNum = null;
	private Long optionID = null;
	private Integer showOrder = null;
	private String fieldName = null;

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			String isOK = (String)ActionContext.getContext().getSession().get("CLIENTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				InquisitionHeaderSelectInfo info = new InquisitionHeaderSelectInfo();
				InquisitionHeaderInfo ih = (InquisitionHeaderInfo) ActionContext.getContext().getSession().get("HEADERLIST");
				info.setInquisitionID(ih.getInquisitionID());
				info.setHeaderID(ih.getHeaderID());
				if(alterID != null) {
					info.setAlterID(alterID);
				}
				if(showOrder != null) {
					info.setShowOrder(showOrder);					
				}
				if(ih.getHeaderID() != null) {
					info.setFieldName("h"+showOrder+"s");
				}
				if(showNum != null) {
					info.setShowNum(showNum);					
				}
				if(optionID != null) {
					info.setOptionID(optionID);					
				}
				info.setStatus(StatusConstants.ZHENGCHANG);
				inquisitionHeaderSelectInfoService.save(info);
				ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","NOT");
			}
			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

	
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	

			if(username == null || password == null) {
				return LOGIN;
			}
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			List<OptionInfo> alterList = optionInfoService.getList(1);
			List<OptionInfo> optionList = optionInfoService.getList(2);
			ActionContext.getContext().getSession().put("ALTERLIST",alterList);
			ActionContext.getContext().getSession().put("OPTIONLIST",alterList);			
			ActionContext.getContext().getSession().put("SELECTVALUE",QuestionTypeConstants.OptionValueDict);
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		

		return SUCCESS;
	}	
	
	public Long getHeaderID() {
		return headerID;
	}

	public void setHeaderID(Long headerID) {
		this.headerID = headerID;
	}
	
	public Long getInquisitionID() {
		return inquisitionID;
	}
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}
	public Integer getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	public void setInquisitionHeaderSelectInfoService(
			IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService) {
		this.inquisitionHeaderSelectInfoService = inquisitionHeaderSelectInfoService;
	}

	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getShowNum() {
		return showNum;
	}
	public void setShowNum(String showNum) {
		this.showNum = showNum;
	}
	public Long getOptionID() {
		return optionID;
	}
	public void setOptionID(Long optionID) {
		this.optionID = optionID;
	}
	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}
	public Long getAlterID() {
		return alterID;
	}
	public void setAlterID(Long alterID) {
		this.alterID = alterID;
	}
	
}
