package cn.iaicc.smgk.jms;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.util.ServiceUtils;

import cn.iaicc.smgk.conf.PlanStatusConstants;
import cn.iaicc.smgk.po.ClientAccountInfo;
import cn.iaicc.smgk.po.GradeRelationInfo;
import cn.iaicc.smgk.po.GradeStdRelationInfo;
import cn.iaicc.smgk.po.HeaderRecordInfo;
import cn.iaicc.smgk.po.InformantInfo;
import cn.iaicc.smgk.po.InquisitionHeaderInfo;
import cn.iaicc.smgk.po.InquisitionHeaderSelectInfo;
import cn.iaicc.smgk.po.PartInfo;
import cn.iaicc.smgk.po.PartQuestionInfo;
import cn.iaicc.smgk.po.PartRecordInfo;
import cn.iaicc.smgk.po.PartSelectInfo;
import cn.iaicc.smgk.po.PlanInfo;
import cn.iaicc.smgk.po.SelectWeightInfo;

/**
 * 处理答案评分体系
 * @author Administrator
 *
 *	1、权重题验证是否得分
 *	2、保存
 *
 *	获取当前计划所对应的评分体系
 *  根据评分体系，自动评分
 */

public class RecordHelper {
	private static Log logger = LogFactory.getLog(RecordHelper.class);
	public static void saveHeader(RecordInfo recordInfo) {
		logger.debug("保存表头数据");
		HeaderRecordInfo record = null;		
		String[] arrs = null;
		String fieldValue = null;
		PlanInfo pi = null;
		List<InquisitionHeaderInfo> inquisitionHeaderInfoList = null;
		try{
			// 检查数据完整性
			if(recordInfo != null && recordInfo.getPlanID() != null && recordInfo.getInquisitionID() != null) {
				pi = ServiceUtils.get().getPlanInfoService().getPlanInfo(recordInfo.getPlanID());				
				
				// 取得所有表头问题
				inquisitionHeaderInfoList = ServiceUtils.get().getInquisitionHeaderInfoService().getInquisitionHeaderInfoList(recordInfo.getInquisitionID());
			}else{
				logger.error("找不到计划或问卷！");
			}
			
			if(pi != null && inquisitionHeaderInfoList != null) {
				// 验证每一个问题和答案
				for(InquisitionHeaderInfo info:inquisitionHeaderInfoList) {
					// 取得字段值
					arrs = (String[])recordInfo.getParameters().get(info.getFieldName());
					// 如果提交了，则保存,如没有提交答案，则不保存
					if(arrs != null) {
						for(int i=0;i<arrs.length;i++) {
							fieldValue = arrs[i];
							logger.debug("fieldName:"+info.getFieldName()+"|fieldValue:"+fieldValue);
							record = new HeaderRecordInfo();
							record.setInquisitionID(recordInfo.getInquisitionID());
							record.setPlanID(recordInfo.getPlanID());
							record.setClientID(pi.getClientID());
							record.setIssueID(pi.getIssueID());
							record.setRound(pi.getRound());
							record.setSmgkID(pi.getSmgkID());
							record.setInformantID(pi.getInformantID());						
							record.setFieldName(info.getFieldName());
							record.setHeaderID(info.getHeaderID());
							record.setQuestionType(info.getQuestionType());
							// 取自发送时间
							record.setAddTime(recordInfo.getSendTime()); 			
							
							//根据类型处理 1:单选菜单 2：单选按钮 3：多选菜单 4：多选按钮 5：提示填空 6：提示文本				
							if(info != null && info.getQuestionType() <= 4 && fieldValue != null && !"".equals(fieldValue)) {
								Long headerSelectID = Long.parseLong(""+fieldValue);
								record.setHeaderSelectID(headerSelectID);
								if(info.getSelectType() == 1) { //表头选项
									logger.debug("headerSelectID:"+headerSelectID);
									InquisitionHeaderSelectInfo inquisitionHeaderSelectInfo = ServiceUtils.get().getInquisitionHeaderSelectInfoService().getInfo(headerSelectID);
									logger.debug("inquisitionHeaderSelectInfo:"+inquisitionHeaderSelectInfo);
									if(inquisitionHeaderSelectInfo != null && inquisitionHeaderSelectInfo.getAlterID() != null) {
										// 根据当前表头选项的选择编号获取相应选项信息
//										QuestionSelectInfo questionSelectInfo = ServiceUtils.get().getQuestionSelectInfoService().getQuestionSelectInfo(inquisitionHeaderSelectInfo.getOptionID());
//										if(questionSelectInfo != null) { 
//											record.setAnswer(""+questionSelectInfo.getSelectID());
//										}else{
//											record.setAnswer(""+fieldValue);
//										}
									}else{
										record.setAnswer(""+fieldValue);						
									}
								}else if(info.getSelectType() == 2) { // 客户帐户
									ClientAccountInfo clientAccountInfo = ServiceUtils.get().getClientAccountInfoService().getClientAccountInfo(headerSelectID);
									if(clientAccountInfo != null) {										
										record.setAnswer(clientAccountInfo.getClientName());
									}else{
										record.setAnswer(""+fieldValue);					
									}
								}else if(info.getSelectType() == 3) { //调查对象
									InformantInfo informantInfo = ServiceUtils.get().getInformantInfoService().getInformantInfo(headerSelectID);
									if(informantInfo != null) {
										record.setAnswer(""+informantInfo.getAliasName());											
									}else{
										record.setAnswer(""+fieldValue);
									}
								}else{
									record.setAnswer(""+fieldValue);					
								}
							}else if(info != null && info.getQuestionType() == 5){ // 提示填空
								record.setHeaderSelectID(new Long(0));
								record.setAnswer(""+fieldValue); // 文本
							}else{ // 不知道的类型
								record.setHeaderSelectID(new Long(0));
								record.setAnswer(""+fieldValue);
							}	
		
						
							// 保存到数据库
							ServiceUtils.get().getHeaderRecordInfoService().saveHeaderRecordInfo(record);								
							
						}				
					}
				}
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}
	}
	
	public static void savePart(RecordInfo recordInfo) {
		logger.debug("保存部分数据");
		boolean isAddOk = false;
		PartRecordInfo record = null;
		String[] arrs = null;
		String fieldValue = null;
		PlanInfo pi = null;
		List<PartInfo> partInfoList = null;
		List<PartQuestionInfo> partQuestionList = null;		
		Map<Long, Map<Long,Integer>> weightMap = new HashMap<Long, Map<Long,Integer>>();
		Map<Long,Integer> selectMap = null;
		try{
			// 检查数据完整性
			if(recordInfo != null && recordInfo.getPlanID() != null && recordInfo.getInquisitionID() != null) {
				pi = ServiceUtils.get().getPlanInfoService().getPlanInfo(recordInfo.getPlanID());				
				
				// 取得指定问卷的所有部分
				partInfoList =  ServiceUtils.get().getPartInfoService().getPartInfoList(recordInfo.getInquisitionID());
				
				// 根据期次和调查对象获取当前评分关系
				GradeRelationInfo gradeRelationInfo = ServiceUtils.get().getGradeRelationInfoService().findByIssue(pi.getIssueID(), pi.getInformantID());

				List<GradeStdRelationInfo> gradeStdRelationInfoList = null;
				// 根据当前评分关系中的评分标准编号，获取评分标准权重关系列表
				if(gradeRelationInfo != null && gradeRelationInfo.getGradeStdID() != null) {
					gradeStdRelationInfoList = ServiceUtils.get().getGradeStdRelationInfoService().findByGradeStd(gradeRelationInfo.getGradeStdID());					
				}
				weightMap.clear();
				SelectWeightInfo swi = null;
				if(gradeStdRelationInfoList != null) {
					for(GradeStdRelationInfo info:gradeStdRelationInfoList) {
						// 取得当前权重信息
						swi = ServiceUtils.get().getSelectWeightInfoService().getSelectWeightInfo(info.getSelectWeightID());
						// status == 1  表示当前权重为正常可用权重
						if(swi != null && swi.getStatus() == 1) {
							// 检查是否已存在当前部分问题选项，有则加入新的选项，无，则新生成
							selectMap = weightMap.get(swi.getPartQuestionID());							
							// 如果为空，则创MAP新实例
							if(selectMap == null) {
								selectMap = new HashMap<Long,Integer>();
							}							
							selectMap.put(swi.getPartQuestionID(), swi.getWeight());
							
							// 加入到MAP中
							weightMap.put(swi.getPartQuestionID(), selectMap);
						}
					}
				}
				
			}else{
				logger.error("找不到计划或问卷！");
			}
			
			if(pi != null && partInfoList != null && weightMap.size() > 10) {
				for(PartInfo partInfo:partInfoList) {
					partQuestionList = ServiceUtils.get().getPartQuestionInfoService().getPartQuestionInfoList(recordInfo.getInquisitionID(), partInfo.getPartID());
					
					// 验证每一个问题和答案
					for(PartQuestionInfo info:partQuestionList) {
						// 取得字段值
						arrs = (String[])recordInfo.getParameters().get(info.getFieldName());
						// 如果提交了，则保存,如没有提交答案，则不保存
						if(arrs != null) {
							for(int i=0;i<arrs.length;i++) {
								fieldValue = arrs[i];
								logger.debug("fieldName:"+info.getFieldName()+"|fieldValue:"+fieldValue);
								record = new PartRecordInfo();
								record.setInquisitionID(recordInfo.getInquisitionID());
								record.setPlanID(recordInfo.getPlanID());
								record.setClientID(pi.getClientID());
								record.setIssueID(pi.getIssueID());
								record.setRound(pi.getRound());
								record.setSmgkID(pi.getSmgkID());
								record.setInformantID(pi.getInformantID());						
								record.setFieldName(info.getFieldName());
								record.setPartID(partInfo.getPartID());
								record.setPartQuestionID(info.getPartQuestionID());
								record.setQuestionType(info.getQuestionType());								
								// 取自发送时间
								record.setAddTime(recordInfo.getSendTime()); 			
								
								//根据类型处理 1:单选菜单 2：单选按钮 3：多选菜单 4：多选按钮 5：提示填空 6：提示文本				
								if(info != null && info.getQuestionType() <= 4 && fieldValue != null && !"".equals(fieldValue)) {
									Long partSelectID = Long.parseLong(fieldValue);	
									record.setPartSelectID(partSelectID);
									// 部分选项信息
									PartSelectInfo partSelectInfo = ServiceUtils.get().getPartSelectInfoService().getPartSelectInfo(partSelectID);
									if(partSelectInfo != null) { //部分问题选项
										logger.debug("partSelectID:"+partSelectID);
										record.setPartQuestionID(partSelectInfo.getPartQuestionID());
										
										// 保存选择值,防止因选项值变化，导致所有变化。
										record.setAnswer(""+fieldValue);	
										
										// 如果是选择题，则根据选项，获取当前部分问题的权重
										selectMap = weightMap.get(info.getPartQuestionID());
										// 如果此问题权重设定
										if(selectMap != null) {
											// 取得当前权重值，如当前选项无权重，则为答错
//											Integer weight = selectMap.get(partSelectInfo.getSelectID());
//											if(weight == null) {
//												record.setWeighted(new Integer(0));
//											}else{ //答对，取当前权重为得分
//												record.setWeighted(weight);
//											}
										}else{
											record.setWeighted(new Integer(0));																						
										}

									}else{
										record.setAnswer(""+fieldValue);					
									}
								}else if(info != null && info.getQuestionType() == 5){ // 提示填空									
									if(fieldValue != null && !"".equals(fieldValue)) {
										record.setAnswer(""+fieldValue);
									}
									record.setPartSelectID(new Long(0));
									record.setWeighted(new Integer(0));
								}else{ // 不知道的类型
									record.setPartSelectID(new Long(0));
									record.setAnswer(""+fieldValue);
									record.setWeighted(new Integer(0));
								}
							
								// 保存到数据库
								ServiceUtils.get().getPartRecordInfoService().savePartRecordInfo(record);					
								// 保存完毕
								isAddOk = true;
							}				
						}
					}
					
				}

			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}finally{
			if(isAddOk) {
				pi.setCheckStatus(PlanStatusConstants.OVER_CHECKSTATUS); //检测结束
				synchronized(pi) {
					// 此计划保存完毕
					ServiceUtils.get().getPlanInfoService().updatePlanInfo(pi);					
				}
			}
		}

	}	
}
