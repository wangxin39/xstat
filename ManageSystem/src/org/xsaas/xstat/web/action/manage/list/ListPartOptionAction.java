package org.xsaas.xstat.web.action.manage.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.SmgkConstants;
import org.xsaas.xstat.web.util.PaginationUtil;

import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.business.IPartQuestionInfoService;
import org.xsaas.xstat.business.IPartSelectInfoService;
import org.xsaas.xstat.business.IQuestionInfoService;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.PartQuestionInfo;
import org.xsaas.xstat.po.PartSelectInfo;
import org.xsaas.xstat.po.QuestionInfo;
import org.xsaas.xstat.po.OptionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListPartOptionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2072274367732074056L;
	private static Log logger = LogFactory.getLog(ListPartOptionAction.class);
	private IPartSelectInfoService partSelectInfoService = null;
	private IPartQuestionInfoService partQuestionInfoService = null;
	private IInquisitionInfoService inquisitionInfoService = null;
	private IOptionInfoService optionInfoService = null;
	private IQuestionInfoService questionInfoService = null;
	
	List<String> selectList = new LinkedList<String>();

	private Long partQuestionID = null;
	private Long inquisitionID = null;
	private Long partSelectID = null;
	
	/**
	 * 当前第几页
	 */
	private Integer num = null;
	/**
	 * 分页数据列表
	 */
	private List<PartSelectInfo> pageList = null;	
	private PaginationUtil pu = null;	
			
	
	private Integer optionType = null;
	private List<String> options = new LinkedList<String>();
	
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
		
			List<InquisitionInfo> iList = inquisitionInfoService.getInquisitionInfoList();
			
			ActionContext.getContext().getSession().put("INQUISITIONSELECT", iList);		
			
			Long selectPartID = (Long)ActionContext.getContext().getSession().get("SELECTPARTQUESTIONID");
			if(partQuestionID != null){
				selectPartID = partQuestionID;
				ActionContext.getContext().getSession().put("SELECTPARTQUESTIONID",partQuestionID);
			}
			if(selectPartID == null) {
				this.addActionError("找不到要操作的部分问题编号!");				
				return ERROR;
			}			
			PartQuestionInfo pi = partQuestionInfoService.getPartQuestionInfo(selectPartID);
			ActionContext.getContext().getSession().put("GLOBALPARTQUESTIONINFO", pi);

			int	total = 0;
			if(selectPartID != 0){
				total = partSelectInfoService.getPartSelectInfoTotal(selectPartID);
			}
			pu = new PaginationUtil(total,page,SmgkConstants.PAGE_MAX_RESULT);
			if(selectPartID != 0){
				pageList = partSelectInfoService.findPartSelectInfoByPage(selectPartID,pu.getStartRecord(),SmgkConstants.PAGE_MAX_RESULT);
			}
			for(PartSelectInfo info:pageList){
				OptionInfo optionInfo = optionInfoService.getOptionInfo(info.getAlterID());
				if(optionInfo != null){
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
	
	@SuppressWarnings("unchecked")
	public String option() throws Exception {
		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			if(username == null || password == null) {
				return ERROR;
			}	
			options.clear();
			if(optionType == null || (optionType != null && optionType == 1)) {
				List<OptionInfo> optionInfoList = (List<OptionInfo>)ActionContext.getContext().getSession().get("QUESTIONSELECTINFOLIST");
				if(optionInfoList == null) {
					optionInfoList = optionInfoService.getList(2); //传入类型
					ActionContext.getContext().getSession().put("QUESTIONSELECTINFOLIST",optionInfoList);
				}
				for(OptionInfo oi:optionInfoList) {
					options.add(oi.getOptionID()+","+oi.getChinaOption());
				}
			}else{
				// 取得二级部分问题
				Long partQuestionID = (Long)ActionContext.getContext().getSession().get("SELECTPARTQUESTIONID");
				if(partQuestionID != null) {
					List<PartQuestionInfo> partQuestionInfoList = partQuestionInfoService.findByFather(partQuestionID);						
					QuestionInfo qi = null;
					for(PartQuestionInfo pqi:partQuestionInfoList) {
						qi = questionInfoService.getQuestionInfo(pqi.getQuestionID());
						if(qi != null) {
							options.add(pqi.getPartQuestionID()+","+qi.getQuestion());
						}else{
							options.add(pqi.getPartQuestionID()+","+pqi.getPartQuestionID());
						}
					}
				}				
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
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
			if(partSelectID == null){
				this.addActionError("编号为空！");
				return ERROR;
			}
			PartSelectInfo info = partSelectInfoService.getPartSelectInfo(partSelectID);
			if(info == null) {
				this.addActionError("找不到你要操作的选择！");
				return ERROR;
			}
			if(info != null){
				ActionContext.getContext().put("DELETEPARTSELECTINFO",info);
			}
			if(info.getPartQuestionID() != null) {
				PartQuestionInfo pqi = partQuestionInfoService.getPartQuestionInfo(info.getPartQuestionID());						
				if(pqi != null && pqi.getFieldName() != null){
					ActionContext.getContext().put("PARTSELECT",pqi.getFieldName());
				}
			}
			if(info.getAlterID() != null) {
				OptionInfo oi = optionInfoService.getOptionInfo(info.getAlterID());
				if(oi != null && oi.getChinaOption() != null){
					ActionContext.getContext().put("QUESTIONSELEST", oi.getChinaOption());
				}				
			}
			if(info.getInquisitionID() != null) {
				InquisitionInfo ii = inquisitionInfoService.getInquisitionInfo(info.getInquisitionID());
				if(ii != null && ii.getTitle() != null){
					ActionContext.getContext().put("INQUISITIONSELECT", ii.getTitle());
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
	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}
	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}

	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}
	public PaginationUtil getPu() {
		return pu;
	}
	public Long getPartQuestionID() {
		return partQuestionID;
	}
	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}
	public List<String> getSelectList() {
		return selectList;
	}
	public void setSelectList(List<String> selectList) {
		this.selectList = selectList;
	}
	public Long getPartSelectID() {
		return partSelectID;
	}
	public void setPartSelectID(Long partSelectID) {
		this.partSelectID = partSelectID;
	}
	public List<PartSelectInfo> getPageList() {
		return pageList;
	}
	public void setPageList(List<PartSelectInfo> pageList) {
		this.pageList = pageList;
	}
	public void setPartSelectInfoService(
			IPartSelectInfoService partSelectInfoService) {
		this.partSelectInfoService = partSelectInfoService;
	}
	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}

	public Integer getOptionType() {
		return optionType;
	}

	public void setOptionType(Integer optionType) {
		this.optionType = optionType;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}

	
	
}
