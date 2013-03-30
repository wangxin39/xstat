package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.StatQuestionInfo;


public interface IStatQuestionInfoService {

	/**
	 * ��������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void saveStatQuestionInfo(StatQuestionInfo data);
	/**
	 * ���µ����ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void updateStatQuestionInfo(StatQuestionInfo data);
	/**
	 * ɾ�������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void deleteStatQuestionInfo(StatQuestionInfo data);	
	/**
	 * ��ȡ�����ʾ���Ϣ
	 * @param partID ���ⲿ�ֱ��
	 * @return �����ʾ���Ϣ
	 */
	public StatQuestionInfo getStatQuestionInfo(Long partID);
	/**
	 * ��ȡ�����ʾ���Ϣ�б�
	 * @return �����ʾ���Ϣ�б�
	 */
	public List<StatQuestionInfo> getStatQuestionInfoList();
	/**
	 * ͨ��ָ������ʼ���ͽ������õ�һ������
	 * @param firstResult 
	 * @param maxResult 
	 * @return �����ʾ���Ϣ
	 */
	public List<StatQuestionInfo> findByPageStatQuestionInfo(final int firstResult,final int maxResult);
	/**
	 * ͨ��ָ������ʼ����ȡ�ܼ���
	 * @return ����
	 */
	public int getTotalStatQuestionInfo();
	/**
	 * �Ƿ��ѿ��Դ洢
	 * @param planID
	 * @param partID
	 * @param partQuestionID
	 * @param partSelectID
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
