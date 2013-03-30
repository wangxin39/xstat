package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.StatPartInfo;


public interface IStatPartInfoService {

	/**
	 * ��������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void saveStatPartInfo(StatPartInfo data);
	/**
	 * ���µ����ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void updateStatPartInfo(StatPartInfo data);
	/**
	 * ɾ�������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void deleteStatPartInfo(StatPartInfo data);	
	/**
	 * ��ȡ�����ʾ���Ϣ
	 * @param partID ���ⲿ�ֱ��
	 * @return �����ʾ���Ϣ
	 */
	public StatPartInfo getStatPartInfo(Long partID);
	/**
	 * ��ȡ�����ʾ���Ϣ�б�
	 * @return �����ʾ���Ϣ�б�
	 */
	public List<StatPartInfo> getStatPartInfoList();
	/**
	 * ͨ��ָ������ʼ���ͽ������õ�һ������
	 * @param firstResult 
	 * @param maxResult 
	 * @return �����ʾ���Ϣ
	 */
	public List<StatPartInfo> findByPageStatPartInfo(final int firstResult,final int maxResult);
	/**
	 * ͨ��ָ������ʼ����ȡ�ܼ���
	 * @return ����
	 */
	public int getTotalStatPartInfo();
	/**
	 * ����Ƿ��Ѵ汣
	 * @param planID
	 * @param partID
	 * @return true û�б��棬false �ѱ���
	 */
	public boolean isSave(Long planID,Long partID);
	/**
	 * ���ݼƻ�����ȡ�üƻ���������
	 * @param planID �ƻ�
	 * @return ������
	 */
	public int getPartTotal(Long planID);
	/**
	 * ��ȡ�ʾ�Ȩ������
	 * @param planID
	 * @return Ȩ������
	 */
	public int getWeightedTotal(Long planID);
	/**
	 * ��ȡ�ʾ�ʵ�ʵ÷�
	 * @param planID
	 * @return ʵ�ʵ÷�
	 */
	public int getActualTotal(Long planID);
	/**
	 * ���ݼƻ���ȡ���иüƻ�ͳ������
	 * @param planID �ƻ�
	 * @return ����ͳ������
	 */
	public List<StatPartInfo> findByPlan(Long planID);	
	/**
	 * ��ȡָ���������ָ���ڴκͲ��ֵ�Ȩ���趨ֵ
	 * @param informantID ���������
	 * @param issueID �ڴα��
	 * @param partID ���ֱ��
	 * @return Ȩ���趨��ֵ
	 */
	public int getWeightedTotal(Long informantID,Long issueID, Long partID);
	/**
	 * ��ȡָ���������ָ���ڴκͲ��ֵ�Ȩ��ʵ�ʵ÷�
	 * @param informantID ���������
	 * @param issueID �ڴα��
	 * @param partID ���ֱ��
	 * @return Ȩ�ص÷���ֵ
	 */
	public int getActualTotal(Long informantID,Long issueID, Long partID);
	/**
	 * ��ȡָ�����������ڴ�һ���ж������ؿͲ�����
	 * @param informantID ���������
	 * @param issueID �ڴα��
	 * @return ���ؿ�������
	 */
	public int getSmgkTotal(Long informantID,Long issueID);
	/**
	 * ��ȡָ���ڴκͲ��ֵ�Ȩ���趨ֵ
	 * @param issueID �ڴα��
	 * @param partID ���ֱ��
	 * @return Ȩ���趨��ֵ
	 */
	public int getWeightedTotal(Long issueID, Long partID);
	/**
	 * ��ȡָ���ڴκͲ��ֵ�Ȩ��ʵ�ʵ÷�
	 * @param issueID �ڴα��
	 * @param partID ���ֱ��
	 * @return Ȩ�ص÷���ֵ
	 */
	public int getActualTotal(Long issueID, Long partID);
	/**
	 * ��ȡָ���ڴ�һ���ж������ؿͲ�����
	 * @param issueID �ڴα��
	 * @return ���ؿ�������
	 */
	public int getSmgkTotal(Long issueID);	
	/**
	 * ͨ���ڴκͲ��ֱ�Ż�ȡָ���ִθò��ֳɼ�
	 * @param issueID �ڴα��
	 * @param partID ���ֱ��
	 * @param round �ִ�
	 * @return �ɼ�
	 */
	public StatPartInfo findByIssue(Long issueID, Long partID , Integer round);	
	/**
	 * ��ȡָ�����ʵ�ʵ÷�
	 * @param year ���
	 * @param clientID �ͻ����
	 * @param projectID ��Ŀ���
	 * @return ʵ���ܵ÷�
	 */
	public int findActualByYear(Integer year,Long clientID,Long projectID);
	/**
	 * ��ȡָ������趨��
	 * @param year ���
	 * @param clientID �ͻ����
	 * @param projectID ��Ŀ���
	 * @return �趨�ܷ�
	 */
	public int findWeightedByYear(Integer year,Long clientID,Long projectID);	
	/**
	 * ��ȡָ�����ʵ�ʵ÷�
	 * @param year ���
	 * @param clientID �ͻ����
	 * @param projectID ��Ŀ���
	 * @return ʵ���ܵ÷�
	 */
	public int findActualByYear(Integer year,Long clientID,Long projectID,Long informantID);
	/**
	 * ��ȡָ������趨��
	 * @param year ���
	 * @param clientID �ͻ����
	 * @param projectID ��Ŀ���
	 * @return �趨�ܷ�
	 */
	public int findWeightedByYear(Integer year,Long clientID,Long projectID,Long informantID);		
	/**
	 * ͨ���ڴκͲ��ֱ�Ż�ȡָ���ִθò��ֳɼ�
	 * @param issueID �ڴα��
	 * @param informantID ���������
	 * @param partID ���ֱ��
	 * @param round �ִ�
	 * @return �ɼ�
	 */
	public StatPartInfo findByIssue(Long issueID,Long informantID, Long partID , Integer round);
}
