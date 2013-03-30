package cn.iaicc.smgk.task;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.iaicc.smgk.conf.Constants;
import cn.iaicc.smgk.conf.PlanConstants;
import cn.iaicc.smgk.po.GradeRelationInfo;
import cn.iaicc.smgk.po.GradeStdRelationInfo;
import cn.iaicc.smgk.po.InformantEvaluationInfo;
import cn.iaicc.smgk.po.InquisitionMarkInfo;
import cn.iaicc.smgk.po.IssueInfo;
import cn.iaicc.smgk.po.PartInfo;
import cn.iaicc.smgk.po.PartRecordInfo;
import cn.iaicc.smgk.po.PlanInfo;
import cn.iaicc.smgk.po.SelectWeightInfo;
import cn.iaicc.smgk.po.StatPartInfo;
import cn.iaicc.smgk.po.StatQuestionInfo;
import cn.iaicc.smgk.util.ServiceUtils;
/**
 * 调查问卷的统计分析，汇总得分问题，部分得分，以及问卷得分详细统计数据
 * @author wangxin
 *
 */
public class StatTask implements Runnable {
	private static Log logger = LogFactory.getLog(StatTask.class);
	private final double PASS = 0.75; // 大于和等于0.75分，则通过，否则不通过
	/**
	 * 要统计的期次
	 */
	private IssueInfo issueInfo = null;
	/**
	 * 当前处理的计划
	 */
	private PlanInfo planInfo = null;	

	public StatTask(IssueInfo issueInfo, PlanInfo planInfo) {
		super();
		this.issueInfo = issueInfo;
		this.planInfo = planInfo;
	}
	
	@Override
	public void run() {
		logger.debug("统计部分问题权重数据");
		// 检查考试/测试计划是否在开始日期和结束日期范围内
		if(issueInfo != null && planInfo != null) {
			try{
				// 统计开始，更新计划里相关状态				
				synchronized(planInfo) {				
					planInfo.setStatStatus(PlanConstants.START_STATUS);
					ServiceUtils.get().getPlanInfoService().updatePlanInfo(planInfo);
				}			
				
				// 统计原始数据， 取得提交的部分问题答案
				statQuestion();				
				// 统计部分数据
				statPart();				
				// 统计问卷分数
				statInquisition();
				
				// 第二轮才启动评估
				if(planInfo.getRound() == 2) {
					checkPart();					
				}				
				// 统计完毕，更新计划里相关状态				
				synchronized(planInfo) {
					planInfo.setStatStatus(PlanConstants.END_STATUS);
					ServiceUtils.get().getPlanInfoService().updatePlanInfo(planInfo);
				}
				
			}catch(Exception e) {
				logger.error(e.getMessage(),e.getCause());
			}
		}else{
			logger.debug("issueInfo:"+issueInfo+"|planInfo:"+planInfo);
		}
	}
	
	/**
	 * 检测部分
	 */
	private void checkPart() {
		try{
			List<PartInfo> partInfoList = ServiceUtils.get().getPartInfoService().getPartInfoList(issueInfo.getInquisitionID());
			InformantEvaluationInfo info = null;
			StatPartInfo spi = null;
			double average = 0.0;
			for(PartInfo pi:partInfoList) {
				
				info = new InformantEvaluationInfo();
				
				// 取第一轮数据
				spi = ServiceUtils.get().getStatPartInfoService().findByIssue(issueInfo.getIssueID(),planInfo.getInformantID(),pi.getPartID(),1);
				if(spi != null) {
					average = spi.getPercentage();
					info.setYear(spi.getYear());
					info.setMonth(spi.getMonth());
					info.setDay(spi.getDay());
					info.setCheckTime(spi.getCheckTime());
					info.setClientID(spi.getClientID());
					info.setPartID(pi.getPartID());
					info.setProjectID(spi.getProjectID());
					info.setIssueID(spi.getIssueID());
					info.setInformantID(spi.getInformantID());					
				}
				// 取第二轮数据
				spi = ServiceUtils.get().getStatPartInfoService().findByIssue(issueInfo.getIssueID(),planInfo.getInformantID(),pi.getPartID(),2);
				if(spi != null) {
					info.setYear(spi.getYear());
					info.setMonth(spi.getMonth());
					info.setDay(spi.getDay());
					info.setCheckTime(spi.getCheckTime());
					info.setClientID(spi.getClientID());
					info.setPartID(pi.getPartID());
					info.setProjectID(spi.getProjectID());
					info.setIssueID(issueInfo.getIssueID());
					info.setInformantID(spi.getInformantID());
					
					if(average > 0) {
						average = (average+spi.getPercentage()/2);						
					}
					if(average >= PASS) {
						info.setEvaluation(2); //通过							
					}else{
						info.setEvaluation(1); //失败														
					}
				    // 存储
					ServiceUtils.get().getInquisitionEvaluateInfoService().save(info);
				    
				}else if(average > 0 && spi == null && info.getIssueID() != null){ // 假如只有第一轮，则取第一轮数据
					if(average >= PASS) {
						info.setEvaluation(2); //通过							
					}else{
						info.setEvaluation(1); //失败														
					}
					
					// 存储
				    ServiceUtils.get().getInquisitionEvaluateInfoService().save(info);
				}else{
					logger.error("spi:"+spi+"|average:"+average);
				}
			}
			//结果存入调查评估信息表
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}

	}	
	
	/**
	 * 统计整个问卷分数
	 */
	private void statInquisition() {
		try{
			InquisitionMarkInfo imi = null;		
			logger.debug("统计问卷|issueID:"+issueInfo.getIssue()+"|smgkID:"+planInfo.getSmgkID()+"|informantID:"+planInfo.getInformantID());
			// 只保存第一轮的，如第二轮，则更新表					
			if(planInfo.getRound() == 1) {
				List<StatPartInfo> spiList = ServiceUtils.get().getStatPartInfoService().findByPlan(planInfo.getPlanID());
				StatPartInfo spi = null;
				logger.debug("第一轮|spiList:"+spiList);
				if(spiList != null && spiList.size() > 0) {
					spi = spiList.get(0);
				}
				// 第一轮
				imi = new InquisitionMarkInfo();
				if(spi != null) {
					imi.setYear(spi.getYear());
					imi.setMonth(spi.getMonth());
					imi.setDay(spi.getDay());										
					imi.setCheckTime(spi.getCheckTime());				
				}
				imi.setClientID(planInfo.getClientID());
				imi.setInformantID(planInfo.getInformantID());
				imi.setIssueID(planInfo.getIssueID());
				imi.setSmgkID(planInfo.getSmgkID());
				imi.setProjectID(planInfo.getProjectID());
				imi.setInquisitionID(issueInfo.getInquisitionID());	
				
				int actualMark = ServiceUtils.get().getStatPartInfoService().getActualTotal(planInfo.getPlanID());
				int weightedMark = ServiceUtils.get().getStatPartInfoService().getWeightedTotal(planInfo.getPlanID());
	
				imi.setActualMarkRound1(actualMark);
				imi.setWeightMarkRound1(weightedMark);
				double mark = 0.0;
				if(actualMark > 0 && weightedMark > 0) {
					mark = new Double((double)actualMark/(double)weightedMark);
				}
				
				imi.setScoreMarkRound1(mark);
				
				imi.setActualMarkRound2(0);
				imi.setWeightMarkRound2(0);
				imi.setScoreMarkRound2(new Double(0));
				imi.setAverage(mark);
				
				if(ServiceUtils.get().getInquisitionMarkInfoService().isSave(imi.getIssueID(), imi.getSmgkID(), imi.getInformantID())) {
					ServiceUtils.get().getInquisitionMarkInfoService().saveInquisitionMarkInfo(imi);					
				}				
			}else if(planInfo.getRound() == 2){
				//
				imi = ServiceUtils.get().getInquisitionMarkInfoService().findByISI(issueInfo.getIssueID(), planInfo.getSmgkID(), planInfo.getInformantID());
				logger.debug("第二轮|imi:|getActualMarkRound1:"+imi.getActualMarkRound1()+"|getWeightMarkRound1:"+imi.getWeightMarkRound1());
				// 第二轮，则更新，计算平均分
				logger.debug("第二轮|year:"+imi.getYear()+"|month:"+imi.getMonth()+"|day:"+imi.getDay());				
				
				int actualMark = ServiceUtils.get().getStatPartInfoService().getActualTotal(planInfo.getPlanID());
				int weightedMark = ServiceUtils.get().getStatPartInfoService().getWeightedTotal(planInfo.getPlanID());
	
				logger.debug("第二轮|actualMark:"+actualMark+"|weightedMark:"+weightedMark);				
				
				imi.setActualMarkRound2(actualMark);
				imi.setWeightMarkRound2(weightedMark);
				
				double mark = 0.0;
				if(actualMark > 0 && weightedMark > 0) {
					mark = new Double((double)actualMark/(double)weightedMark);
				}
				imi.setScoreMarkRound2(mark);
				logger.debug("第二轮|setScoreMarkRound2:"+mark);								
				
				int averageActualMark = imi.getActualMarkRound1()+imi.getActualMarkRound2();
				int averageWeightedMark = imi.getWeightMarkRound1()+imi.getWeightMarkRound2();
				logger.debug("第二轮|averageActualMark:"+averageActualMark+"|averageWeightedMark:"+averageWeightedMark);								
				
				double average = 0.0;
				if(averageActualMark > 0 && averageWeightedMark > 0) {
					average = (double)averageActualMark/(double)averageWeightedMark;
				}
				imi.setAverage(average);
				logger.debug("第二轮|average:"+average);												
				if(imi != null) {
					synchronized(imi) {
						// 更新此项
						ServiceUtils.get().getInquisitionMarkInfoService().updateInquisitionMarkInfo(imi);															
					}
				}
			}

		}catch(Exception e) {
			logger.error("统计问卷|"+e.getMessage(),e.getCause());
		}
	}
	
	/**
	 * 统计部分信息
	 */
	private void statPart() {
		try{
			// 根据问题统计信息，分析问题数据		
			List<PartInfo> partInfoList = ServiceUtils.get().getPartInfoService().getPartInfoList(issueInfo.getInquisitionID());
			StatPartInfo spi = null;			
			StatQuestionInfo sqi = null;
			logger.debug("统计部分|partInfoList:"+partInfoList);
			// 处理所有部分
			for(PartInfo info:partInfoList) {
				spi = new StatPartInfo();
				
				// 根据当前期次和计划和部分编号获取统计问题信息
				sqi = ServiceUtils.get().getStatQuestionInfoService().findByPlan(planInfo.getIssueID(),planInfo.getPlanID(),info.getPartID());
				synchronized(spi) {
					if(sqi != null) {
						spi.setYear(sqi.getYear());
						spi.setMonth(sqi.getMonth());
						spi.setDay(sqi.getDay());										
						spi.setCheckTime(sqi.getCheckTime());
					}
					spi.setPlanID(planInfo.getPlanID());
					spi.setClientID(planInfo.getClientID());
					spi.setInformantID(planInfo.getInformantID());
					spi.setIssueID(planInfo.getIssueID());
					spi.setSmgkID(planInfo.getSmgkID());
					spi.setProjectID(planInfo.getProjectID());
					spi.setRound(planInfo.getRound());
					spi.setInquisitionID(issueInfo.getInquisitionID());
					spi.setStatus(1);

					int weighted = ServiceUtils.get().getStatQuestionInfoService().getCountWeights(planInfo.getPlanID(),info.getPartID());
					int actual = ServiceUtils.get().getStatQuestionInfoService().getCountMarks(planInfo.getPlanID(), info.getPartID());
					logger.debug("统计部分|weighted:"+weighted+"|actual:"+actual);
					
					double percentage = 0.0;
					if(actual > 0 && weighted > 0) {
						percentage = (double)actual/(double)weighted;
					}
					spi.setPartID(info.getPartID());
					spi.setWeightedMark(weighted);
					spi.setActualMarks(actual);
					if(percentage > 0) {
						BigDecimal bd = new BigDecimal(percentage);					
						spi.setPercentage(bd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());						
					}else{
						spi.setPercentage(new Double(0.0));
					}

					logger.debug("统计部分|partID:"+info.getPartID()+"|percentage:"+spi.getPercentage());

					// 当前计划下该部分是否保存
					if(ServiceUtils.get().getStatPartInfoService().isSave(planInfo.getPlanID(), info.getPartID())) {
						// 保存统计数据
						ServiceUtils.get().getStatPartInfoService().saveStatPartInfo(spi);							
					}
					
				}
			}				
		}catch(Exception e) {
			logger.error("统计部分|"+e.getMessage(),e.getCause());
		}	

	}

	/**
	 * 统计问题信息
	 */

	private void statQuestion() {
		try{
			Map<Long, Map<Long,Integer>> weightMap = new HashMap<Long, Map<Long,Integer>>();
			Map<Long,Integer> selectMap = null;
			
			if(planInfo != null) {
				// 根据期次和调查对象获取当前评分关系
				GradeRelationInfo gradeRelationInfo = ServiceUtils.get().getGradeRelationInfoService().findByIssue(planInfo.getIssueID(), planInfo.getInformantID());

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
			}
			if(weightMap.size() > 15) {
				// 获取得分信息
				List<PartRecordInfo> records = ServiceUtils.get().getPartRecordInfoService().findByPlan(planInfo.getPlanID());				
				logger.debug("统计问题|records:"+records);
				if(records != null) {
					StatQuestionInfo sqi = null;
					logger.debug("统计问题|records size:"+records.size());
					for(PartRecordInfo info:records) {
						sqi = new StatQuestionInfo();
						// 如果是选择题，则根据选项，获取当前部分问题的权重
						selectMap = weightMap.get(info.getPartQuestionID());						
						//如果不为空，则为权重题
						if(selectMap != null) {
							logger.debug("统计问题|addTime:"+info.getAddTime());
							List<Integer> timeList = Constants.init(info.getAddTime());
							logger.debug("统计问题|timeList size:"+timeList.size());					
							if(timeList.size() == 3) {
								sqi.setYear(timeList.get(0));
								sqi.setMonth(timeList.get(1));
								sqi.setDay(timeList.get(2));
							}
							
							logger.debug("统计问题|year:"+sqi.getYear()+"|month:"+sqi.getMonth()+"|day:"+sqi.getDay());
							sqi.setPlanID(planInfo.getPlanID());
							sqi.setClientID(planInfo.getClientID());
							sqi.setInformantID(planInfo.getInformantID());
							sqi.setIssueID(planInfo.getIssueID());
							sqi.setSmgkID(planInfo.getSmgkID());
							sqi.setProjectID(planInfo.getProjectID());
							sqi.setRound(planInfo.getRound());
							sqi.setInquisitionID(info.getInquisitionID());
							sqi.setCheckTime(info.getAddTime());
							sqi.setPartID(info.getPartID());
							sqi.setPartQuestionID(info.getPartQuestionID());
//							sqi.setSelectID(info.getSelectID());
							sqi.setPartSelectID(info.getPartSelectID());
							
							if(info.getPartQuestionID() != null && info.getPartQuestionID() > 0) {
								// 如果此问题权重设定
								if(selectMap != null) {
									// 取得当前权重值
									Integer weight = new Integer(0);
									Iterator<Long> it = selectMap.keySet().iterator();
									Long key = null;
									while(it.hasNext()) {
										key = it.next();
										// 当前问题权重总值
										weight += selectMap.get(key);
									}
									if(weight == null) {
										weight = new Integer(0);
									}
									sqi.setWeight(weight);								
									logger.debug("问题权重总值|weight:"+weight);
								}							
							}						

							// 如果答案中没有得分，则当前没有得分
							if(info.getWeighted() != null) {
								sqi.setMarks(info.getWeighted());
							}else{
								sqi.setMarks(new Integer(0));
							}
							sqi.setStatus(1);
							// 如果当前权重不为0，则保存
							if(sqi.getWeight() > 0) {
								boolean isSave = ServiceUtils.get().getStatQuestionInfoService().isSave(sqi.getPlanID(), sqi.getPartID(), sqi.getPartQuestionID(), sqi.getPartSelectID());								
								if(isSave) {
									ServiceUtils.get().getStatQuestionInfoService().saveStatQuestionInfo(sqi);
								}								
							}
						}

					}							
				}				
			}
		}catch(Exception e) {
			logger.error("统计问题"+e.getMessage(),e.getCause());
		}

	}

}
