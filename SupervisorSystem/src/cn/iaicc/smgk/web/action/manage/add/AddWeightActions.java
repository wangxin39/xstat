package cn.iaicc.smgk.web.action.manage.add;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IEmployeeInfoService;
import cn.iaicc.smgk.business.IInquisitionInfoService;
import cn.iaicc.smgk.business.IOptionInfoService;
import cn.iaicc.smgk.business.IOptionRelationInfoService;
import cn.iaicc.smgk.business.IOptionTemplateInfoService;
import cn.iaicc.smgk.business.IPartInfoService;
import cn.iaicc.smgk.business.IPartQuestionInfoService;
import cn.iaicc.smgk.business.ISelectWeightInfoService;
import cn.iaicc.smgk.po.EmployeeInfo;
import cn.iaicc.smgk.po.InquisitionInfo;
import cn.iaicc.smgk.po.PartInfo;
import cn.iaicc.smgk.po.PartQuestionInfo;
import cn.iaicc.smgk.po.SelectWeightInfo;
import cn.iaicc.smgk.web.conf.StatusConstants;

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
	private IPartQuestionInfoService partQuestionInfoService = null;
	private IPartInfoService partInfoService = null;
	private IOptionRelationInfoService optionRelationInfoService = null;
	private IOptionInfoService optionInfoService = null;
	private IOptionTemplateInfoService optionTemplateInfoService = null;
	
	private List<PartInfo> partInfoList =  new LinkedList<PartInfo>();
	private List<PartQuestionInfo> partQuestionInfoList =  new LinkedList<PartQuestionInfo>();
	private List<InquisitionInfo> inquisitionInfoList =  new LinkedList<InquisitionInfo>();

	private Long inquisitionID = null;
	private Long partQuestionID = null;
	private Long partID = null;
	private Long partSelectID = null;
	private Integer weight = null;
	
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
				if(inquisitionID == null){
					this.addActionMessage("调查问卷不能为空，请先添加问卷!");
					return INPUT;
				}
				SelectWeightInfo info = new SelectWeightInfo();
				info.setPartQuestionID(partQuestionID);
				info.setPartSelectID(partSelectID);
				info.setInquisitionID(inquisitionID);
				info.setWeight(weight);
				info.setPartID(partID);
				info.setStatus(StatusConstants.ZHENGCHANG);
				selectWeightInfoService.save(info);
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
		    partQuestionInfoList = partQuestionInfoService.getPartQuestionInfoList(selectPartID);
		    
//			selectInfoList = questionSelectInfoService.getQuestionSelectInfoList();
			partQuestionInfoList = partQuestionInfoService.getPartQuestionInfoList();

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
	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
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
	public void setOptionRelationInfoService(
			IOptionRelationInfoService optionRelationInfoService) {
		this.optionRelationInfoService = optionRelationInfoService;
	}
	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}
	public void setOptionTemplateInfoService(
			IOptionTemplateInfoService optionTemplateInfoService) {
		this.optionTemplateInfoService = optionTemplateInfoService;
	}

}
