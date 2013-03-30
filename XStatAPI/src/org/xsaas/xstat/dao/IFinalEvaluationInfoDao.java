package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.FinalEvaluationInfo;


public interface IFinalEvaluationInfoDao {

	/**
	 * �����ʾ��Զ�����
	 * @param data �ʾ��Զ�����
	 */
	public void save(FinalEvaluationInfo data);
	/**
	 * �����ʾ��Զ�����
	 * @param data �ʾ��Զ�����
	 */
	public void update(FinalEvaluationInfo data);
	/**
	 * ɾ���ʾ��Զ�����
	 * @param data �ʾ��Զ�����
	 */
	public void delete(FinalEvaluationInfo data);	
	/**
	 * ��ȡ�ʾ��Զ�����
	 * @param gradeID ������Դ���ͱ��
	 * @return �ʾ��Զ�����
	 */
	public FinalEvaluationInfo getFinalEvaluationInfo(Long gradeID);
	/**
	 * ��ȡ�ʾ��Զ������б�
	 * @return �ʾ��Զ������б�
	 */
	public List<FinalEvaluationInfo> getFinalEvaluationInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<FinalEvaluationInfo> findByPage(final int firstResult, final int maxResult);

}
