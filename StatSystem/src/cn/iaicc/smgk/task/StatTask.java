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
 * �����ʾ��ͳ�Ʒ��������ܵ÷����⣬���ֵ÷֣��Լ��ʾ�÷���ϸͳ������
 * @author wangxin
 *
 */
public class StatTask implements Runnable {
	private static Log logger = LogFactory.getLog(StatTask.class);
	private final double PASS = 0.75; // ���ں͵���0.75�֣���ͨ��������ͨ��
	/**
	 * Ҫͳ�Ƶ��ڴ�
	 */
	private IssueInfo issueInfo = null;
	/**
	 * ��ǰ����ļƻ�
	 */
	private PlanInfo planInfo = null;	

	public StatTask(IssueInfo issueInfo, PlanInfo planInfo) {
		super();
		this.issueInfo = issueInfo;
		this.planInfo = planInfo;
	}
	
	@Override
	public void run() {
		logger.debug("ͳ�Ʋ�������Ȩ������");
		// ��鿼��/���Լƻ��Ƿ��ڿ�ʼ���ںͽ������ڷ�Χ��
		if(issueInfo != null && planInfo != null) {
			try{
				// ͳ�ƿ�ʼ�����¼ƻ������״̬				
				synchronized(planInfo) {				
					planInfo.setStatStatus(PlanConstants.START_STATUS);
					ServiceUtils.get().getPlanInfoService().updatePlanInfo(planInfo);
				}			
				
				// ͳ��ԭʼ���ݣ� ȡ���ύ�Ĳ��������
				statQuestion();				
				// ͳ�Ʋ�������
				statPart();				
				// ͳ���ʾ����
				statInquisition();
				
				// �ڶ��ֲ���������
				if(planInfo.getRound() == 2) {
					checkPart();					
				}				
				// ͳ����ϣ����¼ƻ������״̬				
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
	 * ��ⲿ��
	 */
	private void checkPart() {
		try{
			List<PartInfo> partInfoList = ServiceUtils.get().getPartInfoService().getPartInfoList(issueInfo.getInquisitionID());
			InformantEvaluationInfo info = null;
			StatPartInfo spi = null;
			double average = 0.0;
			for(PartInfo pi:partInfoList) {
				
				info = new InformantEvaluationInfo();
				
				// ȡ��һ������
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
				// ȡ�ڶ�������
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
						info.setEvaluation(2); //ͨ��							
					}else{
						info.setEvaluation(1); //ʧ��														
					}
				    // �洢
					ServiceUtils.get().getInquisitionEvaluateInfoService().save(info);
				    
				}else if(average > 0 && spi == null && info.getIssueID() != null){ // ����ֻ�е�һ�֣���ȡ��һ������
					if(average >= PASS) {
						info.setEvaluation(2); //ͨ��							
					}else{
						info.setEvaluation(1); //ʧ��														
					}
					
					// �洢
				    ServiceUtils.get().getInquisitionEvaluateInfoService().save(info);
				}else{
					logger.error("spi:"+spi+"|average:"+average);
				}
			}
			//����������������Ϣ��
		}catch(Exception e) {
			logger.error(e.getMessage(),e.getCause());
		}

	}	
	
	/**
	 * ͳ�������ʾ����
	 */
	private void statInquisition() {
		try{
			InquisitionMarkInfo imi = null;		
			logger.debug("ͳ���ʾ�|issueID:"+issueInfo.getIssue()+"|smgkID:"+planInfo.getSmgkID()+"|informantID:"+planInfo.getInformantID());
			// ֻ�����һ�ֵģ���ڶ��֣�����±�					
			if(planInfo.getRound() == 1) {
				List<StatPartInfo> spiList = ServiceUtils.get().getStatPartInfoService().findByPlan(planInfo.getPlanID());
				StatPartInfo spi = null;
				logger.debug("��һ��|spiList:"+spiList);
				if(spiList != null && spiList.size() > 0) {
					spi = spiList.get(0);
				}
				// ��һ��
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
				logger.debug("�ڶ���|imi:|getActualMarkRound1:"+imi.getActualMarkRound1()+"|getWeightMarkRound1:"+imi.getWeightMarkRound1());
				// �ڶ��֣�����£�����ƽ����
				logger.debug("�ڶ���|year:"+imi.getYear()+"|month:"+imi.getMonth()+"|day:"+imi.getDay());				
				
				int actualMark = ServiceUtils.get().getStatPartInfoService().getActualTotal(planInfo.getPlanID());
				int weightedMark = ServiceUtils.get().getStatPartInfoService().getWeightedTotal(planInfo.getPlanID());
	
				logger.debug("�ڶ���|actualMark:"+actualMark+"|weightedMark:"+weightedMark);				
				
				imi.setActualMarkRound2(actualMark);
				imi.setWeightMarkRound2(weightedMark);
				
				double mark = 0.0;
				if(actualMark > 0 && weightedMark > 0) {
					mark = new Double((double)actualMark/(double)weightedMark);
				}
				imi.setScoreMarkRound2(mark);
				logger.debug("�ڶ���|setScoreMarkRound2:"+mark);								
				
				int averageActualMark = imi.getActualMarkRound1()+imi.getActualMarkRound2();
				int averageWeightedMark = imi.getWeightMarkRound1()+imi.getWeightMarkRound2();
				logger.debug("�ڶ���|averageActualMark:"+averageActualMark+"|averageWeightedMark:"+averageWeightedMark);								
				
				double average = 0.0;
				if(averageActualMark > 0 && averageWeightedMark > 0) {
					average = (double)averageActualMark/(double)averageWeightedMark;
				}
				imi.setAverage(average);
				logger.debug("�ڶ���|average:"+average);												
				if(imi != null) {
					synchronized(imi) {
						// ���´���
						ServiceUtils.get().getInquisitionMarkInfoService().updateInquisitionMarkInfo(imi);															
					}
				}
			}

		}catch(Exception e) {
			logger.error("ͳ���ʾ�|"+e.getMessage(),e.getCause());
		}
	}
	
	/**
	 * ͳ�Ʋ�����Ϣ
	 */
	private void statPart() {
		try{
			// ��������ͳ����Ϣ��������������		
			List<PartInfo> partInfoList = ServiceUtils.get().getPartInfoService().getPartInfoList(issueInfo.getInquisitionID());
			StatPartInfo spi = null;			
			StatQuestionInfo sqi = null;
			logger.debug("ͳ�Ʋ���|partInfoList:"+partInfoList);
			// �������в���
			for(PartInfo info:partInfoList) {
				spi = new StatPartInfo();
				
				// ���ݵ�ǰ�ڴκͼƻ��Ͳ��ֱ�Ż�ȡͳ��������Ϣ
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
					logger.debug("ͳ�Ʋ���|weighted:"+weighted+"|actual:"+actual);
					
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

					logger.debug("ͳ�Ʋ���|partID:"+info.getPartID()+"|percentage:"+spi.getPercentage());

					// ��ǰ�ƻ��¸ò����Ƿ񱣴�
					if(ServiceUtils.get().getStatPartInfoService().isSave(planInfo.getPlanID(), info.getPartID())) {
						// ����ͳ������
						ServiceUtils.get().getStatPartInfoService().saveStatPartInfo(spi);							
					}
					
				}
			}				
		}catch(Exception e) {
			logger.error("ͳ�Ʋ���|"+e.getMessage(),e.getCause());
		}	

	}

	/**
	 * ͳ��������Ϣ
	 */

	private void statQuestion() {
		try{
			Map<Long, Map<Long,Integer>> weightMap = new HashMap<Long, Map<Long,Integer>>();
			Map<Long,Integer> selectMap = null;
			
			if(planInfo != null) {
				// �����ڴκ͵�������ȡ��ǰ���ֹ�ϵ
				GradeRelationInfo gradeRelationInfo = ServiceUtils.get().getGradeRelationInfoService().findByIssue(planInfo.getIssueID(), planInfo.getInformantID());

				List<GradeStdRelationInfo> gradeStdRelationInfoList = null;
				// ���ݵ�ǰ���ֹ�ϵ�е����ֱ�׼��ţ���ȡ���ֱ�׼Ȩ�ع�ϵ�б�
				if(gradeRelationInfo != null && gradeRelationInfo.getGradeStdID() != null) {
					gradeStdRelationInfoList = ServiceUtils.get().getGradeStdRelationInfoService().findByGradeStd(gradeRelationInfo.getGradeStdID());					
				}
				weightMap.clear();
				SelectWeightInfo swi = null;
				if(gradeStdRelationInfoList != null) {
					for(GradeStdRelationInfo info:gradeStdRelationInfoList) {
						// ȡ�õ�ǰȨ����Ϣ
						swi = ServiceUtils.get().getSelectWeightInfoService().getSelectWeightInfo(info.getSelectWeightID());
						// status == 1  ��ʾ��ǰȨ��Ϊ��������Ȩ��
						if(swi != null && swi.getStatus() == 1) {
							// ����Ƿ��Ѵ��ڵ�ǰ��������ѡ���������µ�ѡ��ޣ���������
							selectMap = weightMap.get(swi.getPartQuestionID());							
							// ���Ϊ�գ���MAP��ʵ��
							if(selectMap == null) {
								selectMap = new HashMap<Long,Integer>();
							}							
							selectMap.put(swi.getPartQuestionID(), swi.getWeight());
							
							// ���뵽MAP��
							weightMap.put(swi.getPartQuestionID(), selectMap);
						}
					}
				}
			}
			if(weightMap.size() > 15) {
				// ��ȡ�÷���Ϣ
				List<PartRecordInfo> records = ServiceUtils.get().getPartRecordInfoService().findByPlan(planInfo.getPlanID());				
				logger.debug("ͳ������|records:"+records);
				if(records != null) {
					StatQuestionInfo sqi = null;
					logger.debug("ͳ������|records size:"+records.size());
					for(PartRecordInfo info:records) {
						sqi = new StatQuestionInfo();
						// �����ѡ���⣬�����ѡ���ȡ��ǰ���������Ȩ��
						selectMap = weightMap.get(info.getPartQuestionID());						
						//�����Ϊ�գ���ΪȨ����
						if(selectMap != null) {
							logger.debug("ͳ������|addTime:"+info.getAddTime());
							List<Integer> timeList = Constants.init(info.getAddTime());
							logger.debug("ͳ������|timeList size:"+timeList.size());					
							if(timeList.size() == 3) {
								sqi.setYear(timeList.get(0));
								sqi.setMonth(timeList.get(1));
								sqi.setDay(timeList.get(2));
							}
							
							logger.debug("ͳ������|year:"+sqi.getYear()+"|month:"+sqi.getMonth()+"|day:"+sqi.getDay());
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
								// ���������Ȩ���趨
								if(selectMap != null) {
									// ȡ�õ�ǰȨ��ֵ
									Integer weight = new Integer(0);
									Iterator<Long> it = selectMap.keySet().iterator();
									Long key = null;
									while(it.hasNext()) {
										key = it.next();
										// ��ǰ����Ȩ����ֵ
										weight += selectMap.get(key);
									}
									if(weight == null) {
										weight = new Integer(0);
									}
									sqi.setWeight(weight);								
									logger.debug("����Ȩ����ֵ|weight:"+weight);
								}							
							}						

							// �������û�е÷֣���ǰû�е÷�
							if(info.getWeighted() != null) {
								sqi.setMarks(info.getWeighted());
							}else{
								sqi.setMarks(new Integer(0));
							}
							sqi.setStatus(1);
							// �����ǰȨ�ز�Ϊ0���򱣴�
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
			logger.error("ͳ������"+e.getMessage(),e.getCause());
		}

	}

}
