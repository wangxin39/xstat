package cn.iaicc.smgk.web.action.manage.add;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IPartInfoService;
import cn.iaicc.smgk.business.IPartQuestionInfoService;
import cn.iaicc.smgk.business.IQuestionInfoService;
import cn.iaicc.smgk.po.PartInfo;
import cn.iaicc.smgk.po.PartQuestionInfo;
import cn.iaicc.smgk.po.QuestionInfo;
import cn.iaicc.smgk.web.conf.QuestionTypeConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddPartQuestionActions extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8214185261887712162L;
	private static Log logger = LogFactory.getLog(AddPartQuestionActions.class);
	private IPartQuestionInfoService partQuestionInfoService = null;
	private IPartInfoService partInfoService = null;
	private IQuestionInfoService questionInfoService = null;

	private Long questionID = null;
	private Integer validation = null;
	private Long fatherID = null;
	
	private Long partQuestionID = null;
	private String arrQuestionID = null;
	
	@Override
	public String execute() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			Long partID =  (Long)ActionContext.getContext().getSession().get("SELECTPARTID");
			Long inquisitionID = null;
			Long fID = new Long(0);
			if(fatherID != null) {
				fID = fatherID;					
			}
			
			logger.debug("partID:"+partID);
			if(partID == null) {
				this.addActionError("找不到当前部分，请返回选择要操作的部分！");
				return ERROR;
			}
			
			if(partID != null) {
				PartInfo pi = partInfoService.getPartInfo(partID);
				logger.debug("pi:"+pi);
				if(pi != null) {
					inquisitionID = pi.getInquisitionID();						
				}
			}			
			
			PartQuestionInfo info = null;
			if(arrQuestionID != null) {
				logger.debug("questionID:"+questionID+"|validation:"+validation+"|fatherID:"+fatherID+"|arrQuestionID:"+arrQuestionID);
				String[] arrs = arrQuestionID.trim().split(" ");
				for(String str:arrs) {
					info = new PartQuestionInfo();
					if(str != null) {
						info.setFatherPqID(fID);
						info.setPartID(partID);
						info.setInquisitionID(inquisitionID);
						info.setValidation(validation);
						info.setStatus(StatusConstants.ZHENGCHANG);
						info.setQuestionID(Long.parseLong(str));
						savePartQuestion(info);
					}
				}
			}else{
				logger.debug("questionID:"+questionID);
				info = new PartQuestionInfo();
				info.setFatherPqID(fID);
				info.setPartID(partID);
				info.setInquisitionID(inquisitionID);
				info.setValidation(validation);
				info.setStatus(StatusConstants.ZHENGCHANG);
				info.setQuestionID(questionID);
				savePartQuestion(info);					
			}
			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		
		return SUCCESS;
	}
	private void savePartQuestion(PartQuestionInfo info) {
		if(info.getQuestionID() != null && info.getQuestionID() != -1) {
			QuestionInfo qi = questionInfoService.getQuestionInfo(info.getQuestionID());
			if(qi != null) {
				info.setQuestionType(qi.getQuestionType());
			}
		}
		int showNum = 1;
		if(info != null && info.getInquisitionID() != null) {
			showNum = partQuestionInfoService.getLastShowNum(info.getInquisitionID());
		}
		info.setShowNum(showNum);
		if(info.getQuestionType() != null && info.getQuestionType() <= 4) {
			info.setFieldName("h"+showNum+"s");						
		}else{
			info.setFieldName("h"+showNum+"");						
		}	
		partQuestionInfoService.savePartQuestionInfo(info);
	}
	@SuppressWarnings("unchecked")
	public String input() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			
			// 如果失败返回，则从SESSION中取上次记录
			if(partQuestionID == null) {
				partQuestionID = (Long)ActionContext.getContext().getSession().get("SELECTPARTQUESTIONID");
			}
			if(partQuestionID != null) {
				ActionContext.getContext().getSession().put("SELECTPARTQUESTIONID", partQuestionID);
				PartQuestionInfo fatherInfo = partQuestionInfoService.getPartQuestionInfo(partQuestionID);
				java.util.Map<Long,String> fqMap = new java.util.HashMap<Long, String>();
				if(fatherInfo != null && fatherInfo.getQuestionID() != null) { 
					QuestionInfo qi = questionInfoService.getQuestionInfo(fatherInfo.getQuestionID());
					if(qi != null) {
						fqMap.put(fatherInfo.getPartQuestionID(), ""+qi.getQuestion());	
					}else{
						fqMap.put(fatherInfo.getPartQuestionID(),"请选择上级部分问题");						
					}
				}
				ActionContext.getContext().put("FATHERINFOMAP", fqMap);
			}			
			
			ActionContext.getContext().getSession().put("CLIENTINPUTADDISOK","OK");//防止刷新提交多次相同信息
			Long partID = (Long)ActionContext.getContext().getSession().get("SELECTPARTID");
			if(partID != null) {
				PartInfo pi = partInfoService.getPartInfo(partID);
				if(pi != null) {
					ActionContext.getContext().getSession().put("PARTSELECT",""+pi.getName());
				}
			}
			ActionContext.getContext().getSession().put("VALIDATIONSELECT",QuestionTypeConstants.ValidationDict);
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}		
		return SUCCESS;
	}

	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}

	public Long getFatherID() {
		return fatherID;
	}

	public void setFatherID(Long fatherID) {
		this.fatherID = fatherID;
	}

	public void setValidation(Integer validation) {
		this.validation = validation;
	}

	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}

	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}
	public Long getPartQuestionID() {
		return partQuestionID;
	}
	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}
	public Long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}
	public Integer getValidation() {
		return validation;
	}
	public String getArrQuestionID() {
		return arrQuestionID;
	}
	public void setArrQuestionID(String arrQuestionID) {
		this.arrQuestionID = arrQuestionID;
	}

}
