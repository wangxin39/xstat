package org.xsaas.xstat.web.action.manage.edit;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IPartInfoService;
import org.xsaas.xstat.business.IPartQuestionInfoService;
import org.xsaas.xstat.business.ISelectWeightInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.PartInfo;
import org.xsaas.xstat.po.PartQuestionInfo;
import org.xsaas.xstat.po.SelectWeightInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditWeightAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453855886740013266L;
	private static Log logger = LogFactory.getLog(EditWeightAction.class);
	private ISelectWeightInfoService selectWeightInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IPartQuestionInfoService partQuestionInfoService = null;
	private IPartInfoService partInfoService = null;
//	private IQuestionSelectInfoService questionSelectInfoService = null;

//	private List<QuestionSelectInfo> selectInfoList = null;
	private List<PartInfo> partInfoList =  new LinkedList<PartInfo>();
	private List<PartQuestionInfo> partQuestionInfoList =  new LinkedList<PartQuestionInfo>();
	private List<InquisitionInfo> inquisitionInfoList =  new LinkedList<InquisitionInfo>();
	
	private Long inquisitionID = null;
	private Long partQuestionID = null;
	private Long partID = null;
	private Long partSelectID = null;
	private Integer weight = null;
	private Long optionRelationID = null;
	
	private Long selectWeightID = null;	
	
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			SelectWeightInfo info = (SelectWeightInfo) ActionContext.getContext().getSession().get("WEIGHTEDIT");
			if(info != null) {
				if(partQuestionID != null) {
					info.setPartQuestionID(partQuestionID);					
				}
				if(inquisitionID != null) {
					info.setInquisitionID(inquisitionID);					
				}
				if(weight != null) {
					info.setWeight(weight);					
				}
				if(partID != null) {
					info.setPartID(partID);					
				}
				if(partSelectID != null) {
					info.setPartSelectID(partSelectID);
				}
				if(optionRelationID != null) {
					info.setOptionRelationID(optionRelationID);
				}

				selectWeightInfoService.update(info);							
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}


	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return LOGIN;
			}
			if(selectWeightID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}

			inquisitionInfoList = inquisitionInfoService.getInquisitionInfoList();		
			Long selectInquisitionID = null;
			if(inquisitionID != null){
				selectInquisitionID = inquisitionID;
			}else{
				if(inquisitionInfoList != null && inquisitionInfoList.size() > 0) {
					InquisitionInfo ii = inquisitionInfoList.get(0);
					if(ii!=null){
						selectInquisitionID = ii.getInquisitionID();
					}				
				}
			}
			ActionContext.getContext().put("INQUISITIONVALUE",selectInquisitionID);//客户问卷初始化
			Long selectPartID = null;			
		    partInfoList = partInfoService.getPartInfoList(selectInquisitionID);
		    if(partID != null){
		    	selectPartID = partID;
			}else{
				if(partInfoList != null && partInfoList.size() > 0) {
					PartInfo pi = partInfoList.get(0);
					if(pi!=null){
						selectPartID = pi.getPartID();
					}				
				}
			}
		    if(selectPartID != null) {
			    partQuestionInfoList = partQuestionInfoService.getPartQuestionInfoList(selectPartID);		    	
		    }
			SelectWeightInfo info = selectWeightInfoService.getSelectWeightInfo(selectWeightID);
			ActionContext.getContext().getSession().put("WEIGHTEDIT",info);		
		}catch(Exception e){
			logger.error(""+e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}	



	public Long getPartQuestionID() {
		return partQuestionID;
	}

	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void setSelectWeightInfoService(
			ISelectWeightInfoService selectWeightInfoService) {
		this.selectWeightInfoService = selectWeightInfoService;
	}
	public Long getPartID() {
		return partID;
	}
	public void setPartID(Long partID) {
		this.partID = partID;
	}

	public Long getInquisitionID() {
		return inquisitionID;
	}
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}


	public Long getSelectWeightID() {
		return selectWeightID;
	}


	public void setSelectWeightID(Long selectWeightID) {
		this.selectWeightID = selectWeightID;
	}

	public List<PartInfo> getPartInfoList() {
		return partInfoList;
	}


	public List<PartQuestionInfo> getPartQuestionInfoList() {
		return partQuestionInfoList;
	}


	public List<InquisitionInfo> getInquisitionInfoList() {
		return inquisitionInfoList;
	}


	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}


	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}


	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}


	public void setOptionRelationID(Long optionRelationID) {
		this.optionRelationID = optionRelationID;
	}


	public Long getPartSelectID() {
		return partSelectID;
	}


	public void setPartSelectID(Long partSelectID) {
		this.partSelectID = partSelectID;
	}
}
