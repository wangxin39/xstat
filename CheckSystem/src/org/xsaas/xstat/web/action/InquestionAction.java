package org.xsaas.xstat.web.action;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.inquestion.HeaderSelectTemplateInfo;
import org.xsaas.xstat.web.inquestion.HeaderTemplateInfo;
import org.xsaas.xstat.web.inquestion.PartTemplateInfo;
import org.xsaas.xstat.web.inquestion.QuestionTemplateInfo;
import org.xsaas.xstat.web.inquestion.SelectTemplateInfo;

import org.xsaas.xstat.business.IEmployeeInfoService;
import org.xsaas.xstat.business.IInquisitionHeaderInfoService;
import org.xsaas.xstat.business.IInquisitionHeaderSelectInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IInquisitionTemplateInfoService;
import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.business.IOptionRelationInfoService;
import org.xsaas.xstat.business.IPartInfoService;
import org.xsaas.xstat.business.IPartQuestionInfoService;
import org.xsaas.xstat.business.IPartSelectInfoService;
import org.xsaas.xstat.business.IQuestionInfoService;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.po.InquisitionHeaderInfo;
import org.xsaas.xstat.po.InquisitionHeaderSelectInfo;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.InquisitionTemplateInfo;
import org.xsaas.xstat.po.OptionInfo;
import org.xsaas.xstat.po.OptionRelationInfo;
import org.xsaas.xstat.po.PartInfo;
import org.xsaas.xstat.po.PartQuestionInfo;
import org.xsaas.xstat.po.PartSelectInfo;
import org.xsaas.xstat.po.QuestionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InquestionAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7595816280790565022L;
	private static Log logger = LogFactory.getLog(InquestionAction.class);
	/**
	 * 调查问卷表头信息服务
	 */
	private IInquisitionHeaderInfoService inquisitionHeaderInfoService = null;
	/**
	 * 部分信息服务
	 */
	private IPartInfoService partInfoService = null;
	/**
	 * 部分问题服务
	 */
	private IPartQuestionInfoService partQuestionInfoService = null;
	/**
	 * 调查问卷信息服务
	 */
	private IInquisitionInfoService inquisitionInfoService = null;
	/**
	 * 问卷信息服务
	 */
	private IQuestionInfoService questionInfoService = null;
	/**
	 * 问卷模板信息服务
	 */
	private IInquisitionTemplateInfoService inquisitionTemplateInfoService = null;	
	/**
	 * 部分问题选项信息服务
	 */
	private IPartSelectInfoService partSelectInfoService = null;
	/**
	 * 选项信息服务
	 */
	private IOptionInfoService optionInfoService = null;
	/**
	 * 选项关系服务
	 */
	private IOptionRelationInfoService optionRelationInfoService = null;	
	/**
	 * 员工信息服务
	 */
	private IEmployeeInfoService employeeInfoService = null;
	/**
	 * 调查问卷表头选项服务
	 */
	private IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService = null;
	
	/**
	 * 调查问卷编号
	 */
	private Long id = null;
	/**
	 * 计划编号
	 */
	private Long planID = null;
	
	
	/**
	 * 调查问卷标题
	 */
	private String title = null;
	/**
	 * 调查问卷开始时间
	 */
	private Timestamp startTime = null;
	/**
	 * 调查问卷结束时间
	 */
	private Timestamp endTime = null;
	/**
	 * 表头列表
	 */
	private List<HeaderTemplateInfo> headerList = null;
	/**
	 * 部分列表
	 */
	private List<PartTemplateInfo> partList = null;	
	/**
	 * 模板文件
	 */
	private String templateUrl = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
		String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
		try{
			
		}catch(Exception e) {
			logger.error(""+e.getMessage(),e.getCause());
		}

		EmployeeInfo employeeInfo = employeeInfoService.isLogin(username, password);
		if(employeeInfo == null) {
			return LOGIN;
		}
		
		/**
		 * 处理传入的调查问卷编号
		 */
		Long inquisitionID = null;
		if(id != null) {
			inquisitionID = id;
		}
		if(inquisitionID == null) {
			this.addActionError("请选择一个问卷");			
			return ERROR;
		}
		/**
		 * 获取调查问卷信息
		 */
		InquisitionInfo ii = inquisitionInfoService.getInquisitionInfo(inquisitionID);
		if(ii == null) {
			this.addActionError("请增加问卷");
			return ERROR;
		}
		/**
		 * 获取调查问卷模板信息
		 */
		InquisitionTemplateInfo iti = inquisitionTemplateInfoService.getInquisitionTemplateInfo(ii.getTemplateID());
		if(iti == null) {
			this.addActionError("请上传问卷模版");
			return ERROR;
		}
		
		if(planID == null) {
			this.addActionError("非法操作");
			return ERROR;
		}		
		ActionContext.getContext().getSession().put("INQUISITIONID", inquisitionID);
		ActionContext.getContext().getSession().put("PLANID", planID);		
	
		// 设置使用的模版,"/WEB-INF/ftl/inquestion.ftl"
		this.templateUrl = iti.getSavePath()+"/"+iti.getFileName();
		
		title = ""+ii.getTitle();
		startTime = new Timestamp(System.currentTimeMillis());
		endTime = new Timestamp(System.currentTimeMillis()+7*24*60*60*100);
		headerList = new LinkedList<HeaderTemplateInfo>();
		partList = new LinkedList<PartTemplateInfo>();
		
		// 获取指定调查问卷的表头问题列表
		List<InquisitionHeaderInfo> inquisitionHeaderList = inquisitionHeaderInfoService.getInquisitionHeaderInfoList(inquisitionID);
		HeaderTemplateInfo hti = null;
		for(InquisitionHeaderInfo info:inquisitionHeaderList) {
			hti = new HeaderTemplateInfo();
			QuestionInfo qi = questionInfoService.getQuestionInfo(info.getQuestionID());
			if(qi != null) {
				hti.setLabel(""+qi.getQuestion());
				hti.setFieldName(info.getFieldName());
				hti.setFieldType(info.getQuestionType());
				if(info.getIsinput() != null) {
					hti.setIsInput(info.getIsinput());					
				}
				if(info.getSelectType() != null) {
					hti.setSelectType(info.getSelectType());					
				}
				List<HeaderSelectTemplateInfo> hstiList = new LinkedList<HeaderSelectTemplateInfo>();
				
				// 处理选项
				if(info.getQuestionType() <= 4) {
					logger.debug("questionType:"+info.getQuestionType());
					HeaderSelectTemplateInfo hsti = null;
					// 选项模板
					if(info.getSelectType() == 1 && info.getOptionTemplateID() != null) {
						List<OptionRelationInfo> optionRelationInfoList = optionRelationInfoService.getList(info.getOptionTemplateID());
						for(OptionRelationInfo ori:optionRelationInfoList) {
							hsti = new HeaderSelectTemplateInfo();							
							hsti.setFieldName(info.getFieldName());							
							hsti.setFieldValue(""+ori.getOptionRelationID());
							hsti.setOptionRelationID(ori.getOptionRelationID());
							OptionInfo qsi = optionInfoService.getOptionInfo(ori.getAlterID());
							if(qsi != null) {
								hsti.setOption(""+qsi.getChinaOption());								
							}else{
								hsti.setOption("");
							}	
							hsti.setInquisitionID(info.getInquisitionID());
							
							hstiList.add(hsti);																				
						}
					}
					if(info.getSelectType() == 2) { // 1:选项模板  2:自定义选项
						List<InquisitionHeaderSelectInfo> ihsiList = inquisitionHeaderSelectInfoService.getList(inquisitionID,info.getHeaderID());
						logger.debug("ihsi size:"+ihsiList.size());
						for(int i=0;i<ihsiList.size();i++){
							InquisitionHeaderSelectInfo ihsi = ihsiList.get(i);
							hsti = new HeaderSelectTemplateInfo();							
							hsti.setFieldName(info.getFieldName());							
							hsti.setFieldValue(""+ihsi.getHeaderSelectID());
							OptionInfo qsi = optionInfoService.getOptionInfo(ihsi.getAlterID());
							if(qsi != null) {
								hsti.setOption(""+qsi.getChinaOption());								
							}else{
								hsti.setOption("");								
							}
							hsti.setHeaderSelectID(ihsi.getHeaderSelectID());
							hsti.setInquisitionID(info.getInquisitionID());
							hsti.setShowNum(""+ihsi.getShowNum());
							
							hstiList.add(hsti);							
						}
						
					}			
				}								
				hti.setSelectList(hstiList);
				headerList.add(hti);
			}
		}
		// 表头问题选项的处理算法？
		
		List<QuestionTemplateInfo> qtiList = null;
		
		List<PartInfo> partInfoList = partInfoService.getPartInfoList(inquisitionID);
		PartTemplateInfo pti = null;
		for(PartInfo pi:partInfoList) {
			pti = new PartTemplateInfo();
			pti.setName(pi.getName());
			pti.setInquestionID(id);
			pti.setPartID(pi.getPartID());
			pti.setShowNum(pi.getShowNum());
			pti.setShowOrder(pi.getShowOrder());
			
			qtiList = new LinkedList<QuestionTemplateInfo>();
			
			QuestionTemplateInfo qti = null;
			List<PartQuestionInfo> partQuestionList = partQuestionInfoService.getPartQuestionInfoList(pi.getInquisitionID(), pi.getPartID());
			for(PartQuestionInfo pqi:partQuestionList) {
				qti = new QuestionTemplateInfo();
				QuestionInfo qi = questionInfoService.getQuestionInfo(pqi.getQuestionID());
				if(qi != null) {
					qti.setQuestion(qi.getQuestion());
					qti.setEnglishQuestion(qi.getEnglishQuestion());
					qti.setEnglishExplain(qi.getEnglishExplain());
					qti.setQuestionType(qi.getQuestionType());
					qti.setFieldName(pqi.getFieldName());
					qti.setShowNum(pqi.getShowNum());
					qti.setZhExplain(qi.getZhExplain());
					qti.setQuestionID(qi.getQuestionID());
					qti.setSelectType(pqi.getSelectType());

					// 检查该问题下是否有子问题,如有，则为逻辑题 
					List<PartQuestionInfo> logicList = partQuestionInfoService.getFatherPqInfo(pqi.getPartQuestionID());
					if(logicList != null) {
						qti.setIsLogic(1); // 逻辑题
					}
										
					// 选择处理
					if(qi.getQuestionType() <= 4) {
						List<SelectTemplateInfo> selectList = new LinkedList<SelectTemplateInfo>();						
						if(pqi.getSelectType() == 1 && pqi.getOptionTemplateID() != null) { // 选项模板
							List<OptionRelationInfo> optionRelationInfoList = optionRelationInfoService.getList(pqi.getOptionTemplateID());
							for(OptionRelationInfo ori:optionRelationInfoList){
								SelectTemplateInfo sti = new SelectTemplateInfo();
								sti.setPartID(pi.getPartID());
								sti.setPartQuestionID(pqi.getPartQuestionID());
								sti.setFieldName(qti.getFieldName());
								sti.setSelectID(ori.getAlterID());
								sti.setShowNum(ori.getShowNum());
								sti.setOptionID(ori.getOptionID());
								sti.setOptionType(0);
								sti.setOptionRelationID(ori.getOptionRelationID());
								
								if(ori.getAlterID() != null) {
									OptionInfo oi = optionInfoService.getOptionInfo(ori.getAlterID());
									if(oi != null) {
										sti.setFieldValue(""+ori.getOptionRelationID());
										sti.setAlterText(""+oi.getChinaOption());
									}														
								}
								// 处理选项值
								if(ori.getOptionID() != null){
									OptionInfo oi = optionInfoService.getOptionInfo(ori.getOptionID());
									if(oi != null) {
										sti.setOption(oi.getChinaOption());
									}																
								}
							}
						}
						
						if(pqi.getSelectType() == 2){						
							List<PartSelectInfo> pqsiList = partSelectInfoService.findByQuestion(pi.getInquisitionID(),pqi.getPartQuestionID());
							for(PartSelectInfo pqsi:pqsiList) {
								SelectTemplateInfo sti = new SelectTemplateInfo();
								sti.setPartSelectID(pqsi.getPartSelectID());
								sti.setPartID(pi.getPartID());
								sti.setPartQuestionID(pqsi.getPartQuestionID());
								sti.setFieldName(qti.getFieldName());
								sti.setComment(pqsi.getComment());
								sti.setEnglishComment(pqsi.getEnglishComment());
								sti.setSelectID(pqsi.getAlterID());
								sti.setShowOrder(pqsi.getShowOrder());
								sti.setShowNum(pqsi.getShowNum());
								sti.setOptionID(pqsi.getOptionID());
								sti.setOptionType(pqsi.getOptionType());
								
	//							sti.setWeight()
								
								if(pqsi.getAlterID() != null) {
	//								logger.debug("pqsi.getSelectID():"+pqsi.getSelectID());
									OptionInfo oi = optionInfoService.getOptionInfo(pqsi.getAlterID());
									if(oi != null) {
	//									sti.setFieldValue(""+qsi.getOptionValue());
										sti.setFieldValue(""+pqsi.getPartSelectID());
										sti.setAlterText(""+oi.getChinaOption());
									}														
								}
								// 处理选项值
								if(pqsi.getOptionType() == 1 && pqsi.getOptionID() != null){
									OptionInfo oi = optionInfoService.getOptionInfo(pqsi.getOptionID());
									if(oi != null) {
										sti.setOption(oi.getChinaOption());
									}							
									
								}else if(pqsi.getOptionType() == 2 && pqsi.getOptionID() != null){
									PartQuestionInfo partQuestionInfo = partQuestionInfoService.getPartQuestionInfo(pqsi.getOptionID());
									if(partQuestionInfo != null) {
										QuestionInfo questionInfo = questionInfoService.getQuestionInfo(partQuestionInfo.getQuestionID());
										if(questionInfo != null) {
											sti.setOption(questionInfo.getQuestion());
										}
									}
								}							
							
								selectList.add(sti);
							} // end for
						}
						qti.setSelectList(selectList);						
					} // end if					
					qtiList.add(qti);		
				}
			}			
			pti.setQuestionList(qtiList);
			partList.add(pti);
		}
		
		return SUCCESS;
	}

	public String getTitle() {
		return title;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public List<HeaderTemplateInfo> getHeaderList() {
		return headerList;
	}

	public List<PartTemplateInfo> getPartList() {
		return partList;
	}


	public String getTemplateUrl() {
		return templateUrl;
	}

	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}

	public void setInquisitionHeaderInfoService(
			IInquisitionHeaderInfoService inquisitionHeaderInfoService) {
		this.inquisitionHeaderInfoService = inquisitionHeaderInfoService;
	}

	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}

	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}

	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}

	public void setInquisitionTemplateInfoService(
			IInquisitionTemplateInfoService inquisitionTemplateInfoService) {
		this.inquisitionTemplateInfoService = inquisitionTemplateInfoService;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setPartSelectInfoService(
			IPartSelectInfoService partSelectInfoService) {
		this.partSelectInfoService = partSelectInfoService;
	}

	public Long getPlanID() {
		return planID;
	}

	public void setPlanID(Long planID) {
		this.planID = planID;
	}
	public void setInquisitionHeaderSelectInfoService(
			IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService) {
		this.inquisitionHeaderSelectInfoService = inquisitionHeaderSelectInfoService;
	}

	public void setEmployeeInfoService(IEmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}

	public void setOptionRelationInfoService(
			IOptionRelationInfoService optionRelationInfoService) {
		this.optionRelationInfoService = optionRelationInfoService;
	}

	
}
