package cn.iaicc.smgk.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.business.IInquisitionInfoService;
import cn.iaicc.smgk.business.IOptionInfoService;
import cn.iaicc.smgk.business.IOptionRelationInfoService;
import cn.iaicc.smgk.business.IPartInfoService;
import cn.iaicc.smgk.business.IPartQuestionInfoService;
import cn.iaicc.smgk.business.ISelectWeightInfoService;
import cn.iaicc.smgk.po.InquisitionInfo;
import cn.iaicc.smgk.po.OptionRelationInfo;
import cn.iaicc.smgk.po.PartInfo;
import cn.iaicc.smgk.po.PartQuestionInfo;
import cn.iaicc.smgk.po.SelectWeightInfo;
import cn.iaicc.smgk.web.conf.SmgkConstants;
import cn.iaicc.smgk.web.conf.StatusConstants;
import cn.iaicc.smgk.web.util.PaginationUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 权重管理
 * @author 王鑫
 *
 */
public class ListWeightAction extends ActionSupport {
	private static final long serialVersionUID = 453855886740013266L;
	private static Log logger = LogFactory.getLog(ListWeightAction.class);
	private ISelectWeightInfoService selectWeightInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IPartQuestionInfoService partQuestionInfoService = null;
	private IPartInfoService partInfoService = null;
	private IOptionRelationInfoService optionRelationInfoService = null;

	
	// 权重编号
	private Long selectWeightID = null;	
	private Long inquisitionID = null;	
	private Long partID = null;
		
	private Map<Long, String> informantMap = null;
	
	private List<OptionRelationInfo> selectInfoList = null;
	private List<PartInfo> partInfoList =  new LinkedList<PartInfo>();
	private List<PartQuestionInfo> partQuestionInfoList =  new LinkedList<PartQuestionInfo>();
	private List<InquisitionInfo> inquisitionInfoList =  new LinkedList<InquisitionInfo>();
	
	private List<String> inquisitionList = new LinkedList<String>();
	private List<String> partList = new LinkedList<String>();
	private List<String> questionList = new LinkedList<String>();
	private List<String> selectList = new LinkedList<String>();	
	
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<SelectWeightInfo> pageList = null;
	private PaginationUtil pu = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {	
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			
			if(username == null || password == null) {
				return LOGIN;
			}


			//依据客户编号获取调查问卷信息
			inquisitionInfoList = inquisitionInfoService.getInquisitionInfoList();
			ActionContext.getContext().getSession().put("INQUISITIONLIST",inquisitionInfoList);	
			//获取调查问卷编号
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
						
			//依据调查问卷编号获取部分信息
			partInfoList = partInfoService.getPartInfoList(selectInquisitionID);		
			Map<Long, String> partMap = new HashMap<Long, String>();
			for(PartInfo pi:partInfoList) {
				partMap.put(pi.getPartID(), ""+pi.getShowNum()+"."+pi.getName());
			}			
		
			//分页设置
			int page = 1;
			if(num != null){
				page = num.intValue();
			}
			int total = selectWeightInfoService.getTotal(selectInquisitionID);		
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			pageList = selectWeightInfoService.findByPage(selectInquisitionID,pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);			

			OptionRelationInfo OptionRelationInfo = null;
			PartQuestionInfo pqi = null;		
			InquisitionInfo ii = null;
			
			if(pageList != null) {
				for(SelectWeightInfo info:pageList){
					if(info.getPartQuestionID() != null) {
						pqi = partQuestionInfoService.getPartQuestionInfo(info.getPartQuestionID());						
					}
					if(info.getPartSelectID() != null) {
//						selectInfo = questionSelectInfoService.getQuestionSelectInfo(info.getSelectID());											
					}
					if(info.getInquisitionID() != null) {
						ii = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());						
					}					
					if(pqi != null){
						questionList.add(""+pqi.getFieldName());
					}else{
						questionList.add("");
					}
					if(ii != null && ii.getTitle() != null) {
						inquisitionList.add(""+ii.getTitle());						
					}else{
						inquisitionList.add("");						
					}

//					if(info.getOptionRelationID() != null){
//						selectList.add(""+selectInfo.getAlertText());
//					}else{
//						selectList.add("");
//					}
					if(info.getPartID() != null) {
						partList.add(partMap.get(info.getPartID()));						
					}else{
						partList.add("");
					}
				}			
			}else{
				this.addActionMessage("找不到数据，请联系管理员！");
				return ERROR;
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
			
			if(selectWeightID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			SelectWeightInfo info = selectWeightInfoService.getSelectWeightInfo(selectWeightID);
			if(info != null){
				ActionContext.getContext().put("WEIGHTLIST",info);
				ActionContext.getContext().put("STATUS",StatusConstants.StatusDict.get(info.getStatus()));
			}
		
			PartInfo partInfo = partInfoService.getPartInfo(info.getPartID());
//			QuestionSelectInfo selectInfo = questionSelectInfoService.getQuestionSelectInfo(info.getSelectID());
			PartQuestionInfo partQuestionInfo = partQuestionInfoService.getPartQuestionInfo(info.getPartQuestionID());
			InquisitionInfo inquisitionInfo = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());
			if(inquisitionInfo != null && inquisitionInfo.getTitle()!= null){
				ActionContext.getContext().put("INQUISITION",inquisitionInfo.getTitle());
			}
//			if(selectInfo != null && selectInfo.getAlertText() != null){
//				ActionContext.getContext().put("CLIENTSELECT",selectInfo.getAlertText());
//			}
			if(partInfo != null && partInfo.getName() != null){
				ActionContext.getContext().put("PARTSELECT",partInfo.getName());
			}
			if(partInfo != null && partQuestionInfo.getFieldName() != null){
				ActionContext.getContext().put("QUESTIONSELECT",partQuestionInfo.getFieldName());
			}
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}		

		return SUCCESS;
	}
	public void setSelectWeightInfoService(
			ISelectWeightInfoService selectWeightInfoService) {
		this.selectWeightInfoService = selectWeightInfoService;
	}
	public void setPageList(List<SelectWeightInfo> pageList) {
		this.pageList = pageList;
	}
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	public PaginationUtil getPu() {
		return pu;
	}

	public List<String> getPartList() {
		return partList;
	}
	public void setPartList(List<String> partList) {
		this.partList = partList;
	}
	public List<String> getSelectList() {
		return selectList;
	}
	public void setSelectList(List<String> selectList) {
		this.selectList = selectList;
	}

	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}

	public List<SelectWeightInfo> getPageList() {
		return pageList;
	}
	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}
	public List<String> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}

	public List<PartInfo> getPartInfoList() {
		return partInfoList;
	}
	public void setPartInfoList(List<PartInfo> partInfoList) {
		this.partInfoList = partInfoList;
	}
	public Long getInquisitionID() {
		return inquisitionID;
	}
	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}
	public List<PartQuestionInfo> getPqList() {
		return partQuestionInfoList;
	}
	public void setPqList(List<PartQuestionInfo> pqList) {
		this.partQuestionInfoList = pqList;
	}
	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}
	public Map<Long, String> getInformantMap() {
		return informantMap;
	}
	public Long getSelectWeightID() {
		return selectWeightID;
	}
	public void setSelectWeightID(Long selectWeightID) {
		this.selectWeightID = selectWeightID;
	}
	public Long getPartID() {
		return partID;
	}
	public void setPartID(Long partID) {
		this.partID = partID;
	}
	public List<PartQuestionInfo> getPartQuestionInfoList() {
		return partQuestionInfoList;
	}
	public List<InquisitionInfo> getInquisitionInfoList() {
		return inquisitionInfoList;
	}
	public List<OptionRelationInfo> getSelectInfoList() {
		return selectInfoList;
	}
	public List<String> getInquisitionList() {
		return inquisitionList;
	}

	
}
