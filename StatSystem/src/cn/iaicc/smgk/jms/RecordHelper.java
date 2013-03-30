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
 * �����������ϵ
 * @author Administrator
 *
 *	1��Ȩ������֤�Ƿ�÷�
 *	2������
 *
 *	��ȡ��ǰ�ƻ�����Ӧ��������ϵ
 *  ����������ϵ���Զ�����
 */

public class RecordHelper {
	private static Log logger = LogFactory.getLog(RecordHelper.class);
	public static void saveHeader(RecordInfo recordInfo) {
		logger.debug("�����ͷ����");
		HeaderRecordInfo record = null;		
		String[] arrs = null;
		String fieldValue = null;
		PlanInfo pi = null;
		List<InquisitionHeaderInfo> inquisitionHeaderInfoList = null;
		try{
			// �������������
			if(recordInfo != null && recordInfo.getPlanID() != null && recordInfo.getInquisitionID() != null) {
				pi = ServiceUtils.get().getPlanInfoService().getPlanInfo(recordInfo.getPlanID());				
				
				// ȡ�����б�ͷ����
				inquisitionHeaderInfoList = ServiceUtils.get().getInquisitionHeaderInfoService().getInquisitionHeaderInfoList(recordInfo.getInquisitionID());
			}else{
				logger.error("�Ҳ����ƻ����ʾ�");
			}
			
			if(pi != null && inquisitionHeaderInfoList != null) {
				// ��֤ÿһ������ʹ�
				for(InquisitionHeaderInfo info:inquisitionHeaderInfoList) {
					// ȡ���ֶ�ֵ
					arrs = (String[])recordInfo.getParameters().get(info.getFieldName());
					// ����ύ�ˣ��򱣴�,��û���ύ�𰸣��򲻱���
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
							// ȡ�Է���ʱ��
							record.setAddTime(recordInfo.getSendTime()); 			
							
							//�������ʹ��� 1:��ѡ�˵� 2����ѡ��ť 3����ѡ�˵� 4����ѡ��ť 5����ʾ��� 6����ʾ�ı�				
							if(info != null && info.getQuestionType() <= 4 && fieldValue != null && !"".equals(fieldValue)) {
								Long headerSelectID = Long.parseLong(""+fieldValue);
								record.setHeaderSelectID(headerSelectID);
								if(info.getSelectType() == 1) { //��ͷѡ��
									logger.debug("headerSelectID:"+headerSelectID);
									InquisitionHeaderSelectInfo inquisitionHeaderSelectInfo = ServiceUtils.get().getInquisitionHeaderSelectInfoService().getInfo(headerSelectID);
									logger.debug("inquisitionHeaderSelectInfo:"+inquisitionHeaderSelectInfo);
									if(inquisitionHeaderSelectInfo != null && inquisitionHeaderSelectInfo.getAlterID() != null) {
										// ���ݵ�ǰ��ͷѡ���ѡ���Ż�ȡ��Ӧѡ����Ϣ
//										QuestionSelectInfo questionSelectInfo = ServiceUtils.get().getQuestionSelectInfoService().getQuestionSelectInfo(inquisitionHeaderSelectInfo.getOptionID());
//										if(questionSelectInfo != null) { 
//											record.setAnswer(""+questionSelectInfo.getSelectID());
//										}else{
//											record.setAnswer(""+fieldValue);
//										}
									}else{
										record.setAnswer(""+fieldValue);						
									}
								}else if(info.getSelectType() == 2) { // �ͻ��ʻ�
									ClientAccountInfo clientAccountInfo = ServiceUtils.get().getClientAccountInfoService().getClientAccountInfo(headerSelectID);
									if(clientAccountInfo != null) {										
										record.setAnswer(clientAccountInfo.getClientName());
									}else{
										record.setAnswer(""+fieldValue);					
									}
								}else if(info.getSelectType() == 3) { //�������
									InformantInfo informantInfo = ServiceUtils.get().getInformantInfoService().getInformantInfo(headerSelectID);
									if(informantInfo != null) {
										record.setAnswer(""+informantInfo.getAliasName());											
									}else{
										record.setAnswer(""+fieldValue);
									}
								}else{
									record.setAnswer(""+fieldValue);					
								}
							}else if(info != null && info.getQuestionType() == 5){ // ��ʾ���
								record.setHeaderSelectID(new Long(0));
								record.setAnswer(""+fieldValue); // �ı�
							}else{ // ��֪��������
								record.setHeaderSelectID(new Long(0));
								record.setAnswer(""+fieldValue);
							}	
		
						
							// ���浽���ݿ�
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
		logger.debug("���沿������");
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
			// �������������
			if(recordInfo != null && recordInfo.getPlanID() != null && recordInfo.getInquisitionID() != null) {
				pi = ServiceUtils.get().getPlanInfoService().getPlanInfo(recordInfo.getPlanID());				
				
				// ȡ��ָ���ʾ�����в���
				partInfoList =  ServiceUtils.get().getPartInfoService().getPartInfoList(recordInfo.getInquisitionID());
				
				// �����ڴκ͵�������ȡ��ǰ���ֹ�ϵ
				GradeRelationInfo gradeRelationInfo = ServiceUtils.get().getGradeRelationInfoService().findByIssue(pi.getIssueID(), pi.getInformantID());

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
				
			}else{
				logger.error("�Ҳ����ƻ����ʾ�");
			}
			
			if(pi != null && partInfoList != null && weightMap.size() > 10) {
				for(PartInfo partInfo:partInfoList) {
					partQuestionList = ServiceUtils.get().getPartQuestionInfoService().getPartQuestionInfoList(recordInfo.getInquisitionID(), partInfo.getPartID());
					
					// ��֤ÿһ������ʹ�
					for(PartQuestionInfo info:partQuestionList) {
						// ȡ���ֶ�ֵ
						arrs = (String[])recordInfo.getParameters().get(info.getFieldName());
						// ����ύ�ˣ��򱣴�,��û���ύ�𰸣��򲻱���
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
								// ȡ�Է���ʱ��
								record.setAddTime(recordInfo.getSendTime()); 			
								
								//�������ʹ��� 1:��ѡ�˵� 2����ѡ��ť 3����ѡ�˵� 4����ѡ��ť 5����ʾ��� 6����ʾ�ı�				
								if(info != null && info.getQuestionType() <= 4 && fieldValue != null && !"".equals(fieldValue)) {
									Long partSelectID = Long.parseLong(fieldValue);	
									record.setPartSelectID(partSelectID);
									// ����ѡ����Ϣ
									PartSelectInfo partSelectInfo = ServiceUtils.get().getPartSelectInfoService().getPartSelectInfo(partSelectID);
									if(partSelectInfo != null) { //��������ѡ��
										logger.debug("partSelectID:"+partSelectID);
										record.setPartQuestionID(partSelectInfo.getPartQuestionID());
										
										// ����ѡ��ֵ,��ֹ��ѡ��ֵ�仯���������б仯��
										record.setAnswer(""+fieldValue);	
										
										// �����ѡ���⣬�����ѡ���ȡ��ǰ���������Ȩ��
										selectMap = weightMap.get(info.getPartQuestionID());
										// ���������Ȩ���趨
										if(selectMap != null) {
											// ȡ�õ�ǰȨ��ֵ���統ǰѡ����Ȩ�أ���Ϊ���
//											Integer weight = selectMap.get(partSelectInfo.getSelectID());
//											if(weight == null) {
//												record.setWeighted(new Integer(0));
//											}else{ //��ԣ�ȡ��ǰȨ��Ϊ�÷�
//												record.setWeighted(weight);
//											}
										}else{
											record.setWeighted(new Integer(0));																						
										}

									}else{
										record.setAnswer(""+fieldValue);					
									}
								}else if(info != null && info.getQuestionType() == 5){ // ��ʾ���									
									if(fieldValue != null && !"".equals(fieldValue)) {
										record.setAnswer(""+fieldValue);
									}
									record.setPartSelectID(new Long(0));
									record.setWeighted(new Integer(0));
								}else{ // ��֪��������
									record.setPartSelectID(new Long(0));
									record.setAnswer(""+fieldValue);
									record.setWeighted(new Integer(0));
								}
							
								// ���浽���ݿ�
								ServiceUtils.get().getPartRecordInfoService().savePartRecordInfo(record);					
								// �������
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
				pi.setCheckStatus(PlanStatusConstants.OVER_CHECKSTATUS); //������
				synchronized(pi) {
					// �˼ƻ��������
					ServiceUtils.get().getPlanInfoService().updatePlanInfo(pi);					
				}
			}
		}

	}	
}
