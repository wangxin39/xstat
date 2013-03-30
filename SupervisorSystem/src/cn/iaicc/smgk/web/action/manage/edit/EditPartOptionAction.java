package cn.iaicc.smgk.web.action.manage.edit;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IOptionInfoService;
import cn.iaicc.smgk.business.IPartQuestionInfoService;
import cn.iaicc.smgk.business.IPartSelectInfoService;
import cn.iaicc.smgk.business.IQuestionInfoService;
import cn.iaicc.smgk.po.OptionInfo;
import cn.iaicc.smgk.po.PartQuestionInfo;
import cn.iaicc.smgk.po.PartSelectInfo;
import cn.iaicc.smgk.po.QuestionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditPartOptionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8214185261887712162L;
	private static Log logger = LogFactory.getLog(EditPartOptionAction.class);
	private IPartSelectInfoService partSelectInfoService = null;	
	private IOptionInfoService optionInfoService = null;
	private IPartQuestionInfoService partQuestionInfoService = null;
	private IQuestionInfoService questionInfoService = null;

	private Long alterID = null;
	private Long optionID = null;
	private String showNum = null;
	private Integer optionType = null;
	private Integer showOrder = null;
	private String comment = null;
	private String englishComment = null;
	
	private Long partSelectID = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			PartSelectInfo info = (PartSelectInfo) ActionContext.getContext().getSession().get("EDITPARTSELECTINFO");			
			if(info != null) {
				if(englishComment != null) {
					info.setEnglishComment(englishComment);
				}
				if(alterID != null) {
					info.setAlterID(alterID);
				}
				if(optionType != null) {
					info.setOptionType(optionType);
				}
				if(optionID != null && optionID != -1) {
					info.setOptionID(optionID);
				}
				if(showNum != null) {
					info.setShowNum(showNum);
				}
				if(showOrder != null) {
					info.setShowOrder(showOrder);					
				}
				if(comment != null) {
					info.setComment(comment);					
				}
				info.setComment(comment);
				partSelectInfoService.updatePartSelectInfo(info);
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			if(username == null || password == null) {
				return LOGIN;
			}
			if(partSelectID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}		
			PartSelectInfo info = partSelectInfoService.getPartSelectInfo(partSelectID);
			if(info == null) {
				this.addActionError("找不到要编辑的部分问题选项!");
				return ERROR;
			}
			if(info.getPartQuestionID() == null) {
				this.addActionError("非法操作");
				this.addActionError("编号为空！");
				return ERROR;
			}
			ActionContext.getContext().getSession().put("EDITPARTSELECTINFO",info);	
			
			java.util.Map<Long,String> options = new java.util.HashMap<Long,String>();
			if(info.getOptionType() == 1) {
				OptionInfo optionInfo = optionInfoService.getOptionInfo(info.getOptionID());
				if(optionInfo != null) {
					options.put(optionInfo.getOptionID(),optionInfo.getChinaOption());
				}
			}else{
				if(info.getOptionID() != null) {
					PartQuestionInfo pqi = partQuestionInfoService.getPartQuestionInfo(info.getOptionID());							
					if(pqi != null) {
						QuestionInfo qi = questionInfoService.getQuestionInfo(pqi.getQuestionID());
						if(qi != null) {
							options.put(pqi.getPartQuestionID(), ""+qi.getQuestion());							
						}else{
							options.put(pqi.getPartQuestionID(), ""+pqi.getPartQuestionID());							
						}

					}
				}				
				
			}
			ActionContext.getContext().getSession().put("SELECTPARTQUESTIONINFOMAP", options);
						
			List<OptionInfo> optionInfoList = (List<OptionInfo>)ActionContext.getContext().getSession().get("ALTEROPTIOINFOLIST");
			if(optionInfoList == null) {
				optionInfoList = optionInfoService.getList(1);
				OptionInfo oi = new OptionInfo();
				oi.setOptionID(new Long(-1));
				oi.setChinaOption(" ");
				optionInfoList.add(oi);
				ActionContext.getContext().getSession().put("ALTEROPTIOINFOLIST",optionInfoList);
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		

		return SUCCESS;
	}
	public Integer getShowOrder() {
		return showOrder;
	}


	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
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
	public Long getPartSelectID() {
		return partSelectID;
	}
	public void setPartSelectID(Long partSelectID) {
		this.partSelectID = partSelectID;
	}

	public Long getOptionID() {
		return optionID;
	}
	public void setOptionID(Long optionID) {
		this.optionID = optionID;
	}
	public String getShowNum() {
		return showNum;
	}
	public void setShowNum(String showNum) {
		this.showNum = showNum;
	}
	public Integer getOptionType() {
		return optionType;
	}
	public void setOptionType(Integer optionType) {
		this.optionType = optionType;
	}
	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}
	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}
	public Long getAlterID() {
		return alterID;
	}
	public void setAlterID(Long alterID) {
		this.alterID = alterID;
	}
	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}

	
}
