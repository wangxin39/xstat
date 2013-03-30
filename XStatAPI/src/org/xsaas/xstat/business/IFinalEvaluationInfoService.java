package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.FinalEvaluationInfo;


public interface IFinalEvaluationInfoService {
	/**
	 * �����ʾ��Զ�������Ϣ
	 * @param data �ʾ��Զ�������Ϣ
	 */
	public void saveFinalEvaluationInfo(FinalEvaluationInfo data);
	/**
	 * �����ʾ��Զ�������Ϣ
	 * @param data �ʾ��Զ�������Ϣ
	 */
	public void updateFinalEvaluationInfo(FinalEvaluationInfo data);
	/**
	 * ɾ���ʾ��Զ�������Ϣ
	 * @param data �ʾ��Զ�������Ϣ
	 */
	public void deleteFinalEvaluationInfo(FinalEvaluationInfo data);	
	/**
	 * ��ȡ�ʾ��Զ�������Ϣ
	 * @param gradeID ���ֱ��
	 * @return �ʾ��Զ�������Ϣ
	 */
	public FinalEvaluationInfo getFinalEvaluationInfo(Long gradeID);
	/**
	 * ��ȡ�ʾ��Զ�������Ϣ�б�
	 * @return �ʾ��Զ�������Ϣ�б�
	 */
	public List<FinalEvaluationInfo> getFinalEvaluationInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getFinalEvaluationInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<FinalEvaluationInfo> findFinalEvaluationInfoByPage(final int firstResult, final int maxResult);

}
