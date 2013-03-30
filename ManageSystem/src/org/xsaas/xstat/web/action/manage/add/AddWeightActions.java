package org.xsaas.xstat.web.action.manage.add;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.StatusConstants;

import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IPartInfoService;
import org.xsaas.xstat.business.ISelectWeightInfoService;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.PartInfo;
import org.xsaas.xstat.po.PartQuestionInfo;
import org.xsaas.xstat.po.SelectWeightInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddWeightActions extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453855886740013266L;
	private static Log logger = LogFactory.getLog(AddWeightActions.class);
	private ISelectWeightInfoService selectWeightInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IPartInfoService partInfoService = null;
	
	private List<PartInfo> partInfoList =  new LinkedList<PartInfo>();
	private List<PartQuestionInfo> partQuestionInfoList =  new LinkedList<PartQuestionInfo>();
	private List<InquisitionInfo> inquisitionInfoList =  new LinkedList<InquisitionInfo>();

	private Long inquisitionID = null;
	private Long partQuestionID = null;
	private Long partID = null;
	private Long partSelectID = null;
	private Integer weight = null;
	private Long optionRelationID = null;
	
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
				logger.debug("partSelectID:"+partSelectID+"|optionRelationID:"+optionRelationID);
				if(inquisitionID == null){
					this.addActionMessage("调查问卷不能为空，请先添加问卷!");
					return INPUT;
				}
				SelectWeightInfo info = new SelectWeightInfo();
				if(partQuestionID != null) {
					info.setPartQuestionID(partQuestionID);					
				}
				if(partSelectID != null) {
					info.setPartSelectID(partSelectID);
				}
				if(optionRelationID != null) {
					info.setOptionRelationID(optionRelationID);
				}
				info.setInquisitionID(inquisitionID);
				if(weight != null) {
					info.setWeight(weight);					
				}
				if(partID != null) {
					info.setPartID(partID);					
				}
				info.setStatus(StatusConstants.ZHENGCHANG);
				selectWeightInfoService.save(info);
				// 判断是否设定此权重，需要判断
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
			if(selectInquisitionID != null) {
			    partInfoList = partInfoService.getPartInfoList(selectInquisitionID);				
			}
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
	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}

	public Long getPartSelectID() {
		return partSelectID;
	}
	public void setPartSelectID(Long partSelectID) {
		this.partSelectID = partSelectID;
	}
	public void setOptionRelationID(Long optionRelationID) {
		this.optionRelationID = optionRelationID;
	}
	public Long getOptionRelationID() {
		return optionRelationID;
	}

}
