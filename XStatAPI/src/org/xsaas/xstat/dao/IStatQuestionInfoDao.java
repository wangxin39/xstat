package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.StatQuestionInfo;



public interface IStatQuestionInfoDao {
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void save(StatQuestionInfo data);
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void update(StatQuestionInfo data);
	/**
	 * ɾ���ʾ���
	 * @param data �ʾ���
	 */
	public void delete(StatQuestionInfo data);	
	/**
	 * ��ȡ�ʾ���
	 * @param qpID �������ͱ��
	 * @return �ʾ���
	 */
	public StatQuestionInfo getStatQuestionInfo(Long qpID);
	/**
	 * ��ȡ�ʾ����б�
	 * @return �ʾ����б�
	 */
	public List<StatQuestionInfo> getStatQuestionInfoList();
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
	public List<StatQuestionInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * �Ƿ��ѿ��Դ洢
	 * @param planID
	 * @param partID
	 * @param partQuestionID
	 * @param selectID
	 * @return boolean true �����ڣ�false �Ѵ���
	 */
	public boolean isSave(Long planID,Long partID,Long partQuestionID,Long partSelectID);
	/**
	 * ��ȡ����ͳ�Ƶ÷�
	 * @param planID
	 * @param partID
	 * @return ����ͳ�Ƶ÷�
	 */
	public int getCountMarks(Long planID,Long partID);
	/**
	 * ��ȡ�ƻ�ͳ�Ƶ÷�
	 * @param planID
	 * @return ͳ�Ƶ÷�
	 */
	public int getCountMarks(Long planID);
	/**
	 * ��ȡͳ��������Ϣ������ָ�����ڴκͼƻ��Լ����ֱ��
	 * @param issueID
	 * @param planID
	 * @param partID
	 * @return ͳ��������
	 */
	public StatQuestionInfo findByPlan(Long issueID,Long planID,Long partID);
	/**
	 * ��ȡָ���ڴκͲ����ʾ��ִ��µ�����÷�����
	 * @param issueID �ڴα��
	 * @param partID ���ֱ��
	 * @param partQuestionID ����������
	 * @param round �ִ�
	 * @return ͳ��������Ϣ
	 */
	public StatQuestionInfo findByIssue(Long issueID,Long partID,Long partQuestionID,Integer round);
	/**
	 * ��ȡ����Ȩ��
	 * @param planID
	 * @param partID
	 * @return ����Ȩ��
	 */
	public int getCountWeights(Long planID,Long partID);
	/**
	 * ��ȡ�ƻ�����Ȩ��
	 * @param planID
	 * @return ����Ȩ��
	 */
	public int getCountWeights(Long planID);	
}
