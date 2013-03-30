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

import org.xsaas.xstat.business.IInquisitionHeaderInfoService;
import org.xsaas.xstat.business.IInquisitionHeaderSelectInfoService;
import org.xsaas.xstat.business.IInquisitionInfoService;
import org.xsaas.xstat.business.IInquisitionTemplateInfoService;
import org.xsaas.xstat.business.IOptionRelationInfoService;
import org.xsaas.xstat.business.IPartInfoService;
import org.xsaas.xstat.business.IPartQuestionInfoService;
import org.xsaas.xstat.business.IPartSelectInfoService;
import org.xsaas.xstat.business.IQuestionInfoService;
import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.po.InquisitionHeaderInfo;
import org.xsaas.xstat.po.InquisitionHeaderSelectInfo;
import org.xsaas.xstat.po.InquisitionInfo;
import org.xsaas.xstat.po.InquisitionTemplateInfo;
import org.xsaas.xstat.po.OptionRelationInfo;
import org.xsaas.xstat.po.PartInfo;
import org.xsaas.xstat.po.PartQuestionInfo;
import org.xsaas.xstat.po.PartSelectInfo;
import org.xsaas.xstat.po.QuestionInfo;
import org.xsaas.xstat.po.OptionInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PreviewAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3593961681409664260L;
	private static Log logger = LogFactory.getLog(PreviewAction.class);
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
	 * 调查问卷表头选项服务
	 */
	private IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService = null;
	/**
	 * 选项关系信息服务
	 */
	private IOptionRelationInfoService optionRelationInfoService = null;
	
	private Long inquisitionID = null;
	
	private String title = null;
	private Timestamp startTime = null;
	private Timestamp endTime = null;
	
	private List<HeaderTemplateInfo> headerList = null;
	private List<PartTemplateInfo> partList = null;	
	
	private String templateUrl = null;
	
	@Override
	public String execute() throws Exception {

		try{
			String username = (String)ActionContext.getContext().getSession().get("LOGINUSERNAME");
			String password = (String)ActionContext.getContext().getSession().get("LOGINPASSWORD");	
			
			if(username == null || password == null) {
				return LOGIN;
			}
			Long id = null;
			if(inquisitionID != null) {
				id = inquisitionID;
			}
			if(id == null) {
				this.addActionError("请选择一个问卷");			
				return ERROR;
			}
			InquisitionInfo ii = inquisitionInfoService.getInquisitionInfo(id);
			if(ii == null) {
				this.addActionError("请增加问卷");
				return ERROR;
			}
			InquisitionTemplateInfo iti = inquisitionTemplateInfoService.getInquisitionTemplateInfo(ii.getTemplateID());
			if(iti == null) {
				this.addActionError("请上传问卷模版");
				return ERROR;
			}
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
						if(info.getSelectType() == 1 && info.getOptionTemplateID() != null) { // 选项模板
							List<OptionRelationInfo> optionRelationInfoList = optionRelationInfoService.getList(info.getOptionTemplateID());
							for(OptionRelationInfo ori:optionRelationInfoList){
								hsti = new HeaderSelectTemplateInfo();							
								hsti.setFieldName(info.getFieldName());							
								hsti.setFieldValue(""+ori.getOptionRelationID());							
								OptionInfo oi = optionInfoService.getOptionInfo(ori.getAlterID());							
								if(oi != null) {
									hsti.setOption(""+oi.getChinaOption());								
								}else{
									hsti.setOption("");								
								}
								
								hsti.setOptionRelationID(ori.getOptionRelationID());
								hsti.setInquisitionID(info.getInquisitionID());
															
								hstiList.add(hsti);														
							}
						}

						if(info.getSelectType() == 2){ //表头选项
							List<InquisitionHeaderSelectInfo> ihsiList = inquisitionHeaderSelectInfoService.getList(inquisitionID,info.getHeaderID());
							for(int i=0;i<ihsiList.size();i++){
								InquisitionHeaderSelectInfo ihsi = ihsiList.get(i);
								hsti = new HeaderSelectTemplateInfo();							
								hsti.setFieldName(info.getFieldName());							
								hsti.setFieldValue(""+ihsi.getHeaderSelectID());
								OptionInfo oi = optionInfoService.getOptionInfo(ihsi.getAlterID());
								if(oi != null) {
									hsti.setOption(""+oi.getChinaOption());								
								}else{
									hsti.setOption("");								
								}
								hsti.setHeaderSelectID(ihsi.getHeaderSelectID());
								hsti.setInquisitionID(info.getInquisitionID());
								
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
				if(logger.isDebugEnabled()) {
					logger.debug("partID:"+pi.getPartID()+"|"+partQuestionList.size());				
				}
				for(PartQuestionInfo pqi:partQuestionList) {
					qti = new QuestionTemplateInfo();
					logger.debug("pqi.getQuestionID():"+pqi.getQuestionID());
					QuestionInfo qi = questionInfoService.getQuestionInfo(pqi.getQuestionID());
					logger.debug("qi:"+qi);
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
						
						// 检查该问题下是否有子问题
						List<PartQuestionInfo> logicList = partQuestionInfoService.getFatherPqInfo(pqi.getPartQuestionID());
						if(logicList != null) {
							qti.setIsLogic(1); // 逻辑题 
						}				
						
						// 选择处理
						if(qi.getQuestionType() <= 4) {
							List<SelectTemplateInfo> selectList = new LinkedList<SelectTemplateInfo>();
							if(pqi.getSelectType() == 1 && pqi.getOptionTemplateID() != null) {
								List<OptionRelationInfo> optionRelationInfoList = optionRelationInfoService.getList(pqi.getOptionTemplateID());
								logger.debug("optionRelationInfoList size:"+optionRelationInfoList.size());
								for(OptionRelationInfo ori:optionRelationInfoList) {
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
//										logger.debug("pqsi.getSelectID():"+pqsi.getSelectID());
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
									
									selectList.add(sti);
								} // end for							
							}
							if(pqi.getSelectType() == 2){
//								logger.debug("pi.getInquisitionID():"+pi.getInquisitionID()+"|pi.getPartID():"+pi.getPartID()+"|qi.getQuestionID():"+qi.getQuestionID());
								List<PartSelectInfo> pqsiList = partSelectInfoService.findByQuestion(pi.getInquisitionID(),pqi.getPartQuestionID());
//								logger.debug("pqsiList size:"+pqsiList.size());
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
									
//									sti.setWeight()
									
									if(pqsi.getAlterID() != null) {
//										logger.debug("pqsi.getSelectID():"+pqsi.getSelectID());
										OptionInfo oi = optionInfoService.getOptionInfo(pqsi.getAlterID());
										if(oi != null) {
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
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(""+e.getMessage(),e.getCause());
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

	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}

	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}

	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}

	public Long getInquisitionID() {
		return inquisitionID;
	}

	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}

	public void setInquisitionInfoService(
			IInquisitionInfoService inquisitionInfoService) {
		this.inquisitionInfoService = inquisitionInfoService;
	}

	public void setInquisitionTemplateInfoService(
			IInquisitionTemplateInfoService inquisitionTemplateInfoService) {
		this.inquisitionTemplateInfoService = inquisitionTemplateInfoService;
	}

	public void setPartSelectInfoService(
			IPartSelectInfoService partSelectInfoService) {
		this.partSelectInfoService = partSelectInfoService;
	}
	public void setInquisitionHeaderSelectInfoService(
			IInquisitionHeaderSelectInfoService inquisitionHeaderSelectInfoService) {
		this.inquisitionHeaderSelectInfoService = inquisitionHeaderSelectInfoService;
	}

	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}

	public void setOptionRelationInfoService(
			IOptionRelationInfoService optionRelationInfoService) {
		this.optionRelationInfoService = optionRelationInfoService;
	}



	

}
