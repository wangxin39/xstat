package org.xsaas.xstat.web.action.manage.add;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.business.IPartSelectInfoService;
import org.xsaas.xstat.po.OptionInfo;
import org.xsaas.xstat.po.PartQuestionInfo;
import org.xsaas.xstat.po.PartSelectInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddPartOptionActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8214185261887712162L;
	private static Log logger = LogFactory.getLog(AddPartOptionActions.class);
	private IPartSelectInfoService partSelectInfoService = null;
	private IOptionInfoService optionInfoService = null;

	private Long alterID = null;
	private String showNum = null;
	private Long optionID = null;
	private Integer optionType = null;
	private String comment = null;
	private String englishComment = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			logger.debug("alterID:"+alterID+"|showNum:"+showNum+"|optionID:"+optionID+"|optionType:"+optionType+"|comment:"+comment+"|englishComment:"+englishComment);
			PartQuestionInfo  partInfo = (PartQuestionInfo) ActionContext.getContext().getSession().get("GLOBALPARTQUESTIONINFO");
			if(partInfo == null) {
				this.addActionMessage("末能获取到部分信息，请联系管理员.");
				return ERROR;
			}
			String isOK = (String)ActionContext.getContext().getSession().get("PARTSELECTINPUTADDISOK");
			if(isOK != null && "OK".equals(isOK)) {
				PartSelectInfo info = new PartSelectInfo();
				info.setPartQuestionID(partInfo.getPartQuestionID());
				info.setInquisitionID(partInfo.getInquisitionID());
				
				if(englishComment != null) {
					info.setEnglishComment(englishComment);					
				}
				if(alterID != null && alterID != -1) {
					info.setAlterID(alterID);					
				}
				if(optionID != null && optionID != -1) {
					info.setOptionID(optionID);
				}
				if(optionType != null) {
					info.setOptionType(optionType);
				}
				if(showNum != null) {
					info.setShowNum(showNum);
				}
				// 此处需要改为取得当前最新顺序号+1				
				info.setShowOrder(1);
				if(comment != null) {
					info.setComment(comment);					
				}
				info.setStatus(StatusConstants.ZHENGCHANG);
				partSelectInfoService.savePartSelectInfo(info);				
				ActionContext.getContext().getSession().put("PARTSELECTINPUTADDISOK","NOT");
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
			
			
			List<OptionInfo> optionInfoList = (List<OptionInfo>)ActionContext.getContext().getSession().get("ALTEROPTIOINFOLIST");
			if(optionInfoList == null) {
				optionInfoList = optionInfoService.getList(1);
				OptionInfo oi = new OptionInfo();
				oi.setOptionID(new Long(-1));
				oi.setChinaOption(" ");
				optionInfoList.add(oi);
				ActionContext.getContext().getSession().put("ALTEROPTIOINFOLIST",optionInfoList);
			}
			optionInfoList = (List<OptionInfo>)ActionContext.getContext().getSession().get("VALUEOPTIOINFOLIST");
			if(optionInfoList == null) {
				optionInfoList = optionInfoService.getList(2);
				OptionInfo oi = new OptionInfo();
				oi.setOptionID(new Long(-1));
				oi.setChinaOption(" ");
				optionInfoList.add(oi);
				ActionContext.getContext().getSession().put("VALUEOPTIOINFOLIST",optionInfoList);
			}			
			ActionContext.getContext().getSession().put("PARTSELECTINPUTADDISOK","OK");			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}	
				
		return SUCCESS;
	}	

	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getEnglishComment() {
		return englishComment;
	}


	public void setEnglishComment(String englishComment) {
		this.englishComment = englishComment;
	}


	public void setPartSelectInfoService(
			IPartSelectInfoService partSelectInfoService) {
		this.partSelectInfoService = partSelectInfoService;
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

	public Integer getOptionType() {
		return optionType;
	}

	public void setOptionType(Integer optionType) {
		this.optionType = optionType;
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
