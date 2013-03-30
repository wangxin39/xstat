package org.xsaas.xstat.web.action.manage.ajax;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xsaas.xstat.web.conf.QuestionTypeConstants;

import org.xsaas.xstat.business.IOptionInfoService;
import org.xsaas.xstat.business.IOptionRelationInfoService;
import org.xsaas.xstat.business.IOptionTemplateInfoService;
import org.xsaas.xstat.business.IPartInfoService;
import org.xsaas.xstat.business.IPartQuestionInfoService;
import org.xsaas.xstat.business.IPartSelectInfoService;
import org.xsaas.xstat.business.IQuestionInfoService;
import org.xsaas.xstat.po.OptionInfo;
import org.xsaas.xstat.po.OptionRelationInfo;
import org.xsaas.xstat.po.OptionTemplateInfo;
import org.xsaas.xstat.po.PartInfo;
import org.xsaas.xstat.po.PartQuestionInfo;
import org.xsaas.xstat.po.PartSelectInfo;
import org.xsaas.xstat.po.QuestionInfo;

import com.opensymphony.xwork2.ActionSupport;

public class JsonWeightAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 148427507747962412L;
	private static Log logger = LogFactory.getLog(JsonWeightAction.class);
	
	private IPartInfoService partInfoService = null;
	private IOptionTemplateInfoService optionTemplateInfoService = null;
	private IOptionRelationInfoService optionRelationInfoService = null;
	private IOptionInfoService optionInfoService = null;
	
	private IPartQuestionInfoService partQuestionInfoService = null;
	private IQuestionInfoService questionInfoService = null;
	private IPartSelectInfoService partSelectInfoService = null;
	
	private Long inquisitionID = null;	
	private Long partID = null;
	
	private Long partQuestionID = null;

	private List<PartInfo> partInfoList = null;
	private List<Long> partQuestionIDList = null;
	private LinkedHashMap<Long, String> partQuestionInfoMap = null;
	private List<OptionTemplateInfo> optionTemplateInfoList = null;
	
	private Integer selectType = null;
	
	private List<Long> partSelectIDList = null;
	private LinkedHashMap<Long, String> partSelectInfoMap = null;
	
	private Long optionTemplateID = null;
	
	
	@Override
	public String execute() throws Exception {
		logger.debug("partID:"+partID+"|inquisitionID:"+inquisitionID+"|partQuestionID:"+partQuestionID+"|optionTemplateID:"+optionTemplateID);
		try{		
			if(inquisitionID != null) {
				partInfoList = partInfoService.getPartInfoList(inquisitionID);
			}
			
			// 点选部分菜单
			if(partID != null) {
				partQuestionInfoMap = new LinkedHashMap<Long,String>();
				partQuestionIDList = new java.util.LinkedList<Long>();
				List<PartQuestionInfo> partQuestionInfoList = partQuestionInfoService.getPartQuestionInfoList(partID);
				QuestionInfo qi = null;
				String selectType = "";
				String question = "";
				for(PartQuestionInfo pqi:partQuestionInfoList) {
					qi = questionInfoService.getQuestionInfo(pqi.getQuestionID());
					// 只允许选择题定义权重
					if(pqi.getQuestionType() <= 4) {
						
						if(pqi.getSelectType() != null) {
							selectType = "|"+QuestionTypeConstants.selectTypeDict.get(pqi.getSelectType());
						}
						question = qi.getQuestion();
						if(question != null && question.length() > 30) {
							question = question.substring(0,30)+"...";
						}
						partQuestionInfoMap.put(pqi.getPartQuestionID(), ""+question+"|"+QuestionTypeConstants.QuestionTypeDict.get(pqi.getQuestionType())+""+selectType);
						partQuestionIDList.add(pqi.getPartQuestionID());						
					}
				}
			}
			
			
			//点选部分问题菜单处理
			if(partQuestionID != null) {
				PartQuestionInfo pqi = partQuestionInfoService.getPartQuestionInfo(partQuestionID);
				if(pqi != null) {
					selectType = pqi.getSelectType();
					if(selectType != null && selectType == 1) {
						optionTemplateInfoList = optionTemplateInfoService.getList(0, Integer.MAX_VALUE);						
					}
					if(optionTemplateInfoList == null) {
						optionTemplateInfoList = new java.util.LinkedList<OptionTemplateInfo>();
					}
					
					if(selectType != null && selectType == 2) {
						partSelectInfoMap = new LinkedHashMap<Long,String>();
						partSelectIDList = new java.util.LinkedList<Long>();
						OptionInfo oi = null;
						List<PartSelectInfo> partSelectInfoList = partSelectInfoService.findByQuestion(partQuestionID);
						for(PartSelectInfo psi:partSelectInfoList) {
							if(psi.getAlterID() != null) {
								oi = optionInfoService.getOptionInfo(psi.getAlterID());
								partSelectInfoMap.put(psi.getPartSelectID(), ""+oi.getChinaOption());
								partSelectIDList.add(psi.getPartSelectID());
							}
						}
					}
				}
			}
			// 模板选项,取出对应关系
			if(optionTemplateID != null) {
				
				partSelectInfoMap = new LinkedHashMap<Long,String>();
				partSelectIDList = new java.util.LinkedList<Long>();
				OptionInfo oi = null;
				List<OptionRelationInfo> optionRelationInfoList = optionRelationInfoService.getList(optionTemplateID);
				for(OptionRelationInfo ori:optionRelationInfoList) {
					if(ori.getAlterID() != null) {
						oi = optionInfoService.getOptionInfo(ori.getAlterID());
						partSelectInfoMap.put(ori.getOptionRelationID(), ""+oi.getChinaOption());
						partSelectIDList.add(ori.getOptionRelationID());
					}
				}
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
		return SUCCESS;
	}


	public void setPartInfoService(IPartInfoService partInfoService) {
		this.partInfoService = partInfoService;
	}


	public void setOptionTemplateInfoService(
			IOptionTemplateInfoService optionTemplateInfoService) {
		this.optionTemplateInfoService = optionTemplateInfoService;
	}


	public void setOptionRelationInfoService(
			IOptionRelationInfoService optionRelationInfoService) {
		this.optionRelationInfoService = optionRelationInfoService;
	}


	public void setPartQuestionInfoService(
			IPartQuestionInfoService partQuestionInfoService) {
		this.partQuestionInfoService = partQuestionInfoService;
	}


	public void setInquisitionID(Long inquisitionID) {
		this.inquisitionID = inquisitionID;
	}


	public void setPartID(Long partID) {
		this.partID = partID;
	}


	public List<PartInfo> getPartInfoList() {
		return partInfoList;
	}


	public void setPartInfoList(List<PartInfo> partInfoList) {
		this.partInfoList = partInfoList;
	}
	public LinkedHashMap<Long, String> getPartQuestionInfoMap() {
		return partQuestionInfoMap;
	}


	public void setQuestionInfoService(IQuestionInfoService questionInfoService) {
		this.questionInfoService = questionInfoService;
	}


	public List<Long> getPartQuestionIDList() {
		return partQuestionIDList;
	}


	public Long getPartQuestionID() {
		return partQuestionID;
	}


	public void setPartQuestionID(Long partQuestionID) {
		this.partQuestionID = partQuestionID;
	}


	public Integer getSelectType() {
		return selectType;
	}


	public List<OptionTemplateInfo> getOptionTemplateInfoList() {
		return optionTemplateInfoList;
	}


	public void setPartSelectInfoService(
			IPartSelectInfoService partSelectInfoService) {
		this.partSelectInfoService = partSelectInfoService;
	}


	public void setOptionInfoService(IOptionInfoService optionInfoService) {
		this.optionInfoService = optionInfoService;
	}


	public List<Long> getPartSelectIDList() {
		return partSelectIDList;
	}


	public LinkedHashMap<Long, String> getPartSelectInfoMap() {
		return partSelectInfoMap;
	}


	public Long getOptionTemplateID() {
		return optionTemplateID;
	}


	public void setOptionTemplateID(Long optionTemplateID) {
		this.optionTemplateID = optionTemplateID;
	}
	
}
