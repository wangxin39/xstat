package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.InquisitionMarkInfo;


public interface IInquisitionMarkInfoService {

	/**
	 * ��������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void saveInquisitionMarkInfo(InquisitionMarkInfo data);
	/**
	 * ���µ����ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void updateInquisitionMarkInfo(InquisitionMarkInfo data);
	/**
	 * ɾ�������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void deleteInquisitionMarkInfo(InquisitionMarkInfo data);	
	/**
	 * ��ȡ�����ʾ���Ϣ
	 * @param partID ���ⲿ�ֱ��
	 * @return �����ʾ���Ϣ
	 */
	public InquisitionMarkInfo getInquisitionMarkInfo(Long partID);
	/**
	 * ��ȡ�����ʾ���Ϣ�б�
	 * @return �����ʾ���Ϣ�б�
	 */
	public List<InquisitionMarkInfo> getInquisitionMarkInfoList();
	/**
	 * ͨ��ָ������ʼ���ͽ������õ�һ������
	 * @param firstResult 
	 * @param maxResult 
	 * @return �����ʾ���Ϣ
	 */
	public List<InquisitionMarkInfo> findByPageInquisitionMarkInfo(final int firstResult,final int maxResult);
	/**
	 * ͨ��ָ������ʼ����ȡ�ܼ���
	 * @return ����
	 */
	public int getTotalInquisitionMarkInfo();
	/**
	 * ����ָ�����ڴΡ����ؿͺ͵�������ȡ�ʾ��ͳ��ֵ
	 * @param issueID �ڴα��
	 * @param smgkID ���ؿͱ��
	 * @param informantID ���������
	 * @return �����ʾ������Ϣ
	 */
	public InquisitionMarkInfo findByISI(Long issueID, Long smgkID, Long informantID);	
	/**
	 * ���ݵ�ǰ�ƻ�������Ƿ���Դ洢
	 * @param issueID �ڴα��
	 * @param smgkID ���ع˿�
	 * @param informantID �������
	 * @return true ���Ա��棬false ��������
	 */
	public boolean isSave(Long issueID, Long smgkID,Long informantID);
	/**
	 * ���ݵ�������ȡ��Ӧͳ������
	 * @param informantID ���������
	 * @param projectID ��Ŀ���
	 * @return ͳ������
	 */
	public List<InquisitionMarkInfo> findByInformant(Long informantID,Long projectID);
	/**
	 * ���ݿͻ����,��Ŀ����ȡ��Ӧͳ������
	 * @param clientID �ͻ����
	 * @param projectID ��Ŀ���
	 * @return ͳ������
	 */
	public List<InquisitionMarkInfo> findByClient(Long clientID,Long projectID);	
	
	/**
	 * ��ȡ����ͳ�����
	 * @param clientID
	 * @param projectID
	 * @param informantID
	 * @return ����б�
	 */
	public List<Integer> getCountYear(Long clientID,Long projectID, Long informantID);
	/**
	 * ��õ�ǰ����ͳ���·�
	 * @param clientID
	 * @param projectID
	 * @param informantID
	 * @return �·��б�
	 */
	public List<Integer> getCountQuarter(Long clientID,Long projectID, Long informantID);
	/**
	 * �������ͳ������
	 * @param clientID
	 * @param projectID
	 * @param informantID
	 * @param year
	 * @param month
	 * @return �����б�
	 */
	public List<Integer> getCountWeek(Long clientID,Long projectID, Long informantID,Integer year,Integer month);	
	/**
	 * ��ȡ����ͳ�����
	 * @param clientID
	 * @param projectID
	 * @return ����б�
	 */
	public List<Integer> getCountYear(Long clientID,Long projectID);
	/**
	 * ��õ�ǰ����ͳ���·�
	 * @param clientID
	 * @param projectID
	 * @return �·��б�
	 */
	public List<Integer> getCountQuarter(Long clientID,Long projectID);
	/**
	 * �������ͳ������
	 * @param clientID
	 * @param projectID
	 * @return �����б�
	 */
	public List<Integer> getCountWeek(Long clientID,Long projectID,Integer year,Integer month);	
	
	/**
	 * ��ȡָ���������ָ���ڴε�Ȩ���趨ֵ
	 * @param informantID ���������
	 * @param issueID �ڴα��
	 * @return Ȩ���趨��ֵ
	 */
	public int getWeightedRound1Total(Long informantID,Long issueID);
	/**
	 * ��ȡָ���������ָ���ڴε�Ȩ��ʵ�ʵ÷�
	 * @param informantID ���������
	 * @param issueID �ڴα��
	 * @return Ȩ�ص÷���ֵ
	 */
	public int getActualRound1Total(Long informantID,Long issueID);
	/**
	 * ��ȡָ���������ָ���ڴε�Ȩ���趨ֵ
	 * @param informantID ���������
	 * @param issueID �ڴα��
	 * @return Ȩ���趨��ֵ
	 */
	public int getWeightedRound2Total(Long informantID,Long issueID);
	/**
	 * ��ȡָ���������ָ���ڴε�Ȩ��ʵ�ʵ÷�
	 * @param informantID ���������
	 * @param issueID �ڴα��
	 * @return Ȩ�ص÷���ֵ
	 */
	public int getActualRound2Total(Long informantID,Long issueID);
	/**
	 * ��ȡָ�����������ڴ�һ���ж������ؿͲ�����
	 * @param informantID ���������
	 * @param issueID �ڴα��
	 * @return ���ؿ�������
	 */
	public int getSmgkTotal(Long informantID,Long issueID);
	/**
	 * ��ȡƽ����ͳ��
	 * @param informantID
	 * @param issueID
	 * @param year
	 * @param month
	 * @return ƽ�����ܺ�
	 */
	public double getAverageTotal(Long informantID, Long issueID , Integer year, Integer month);
	/**
	 * ��ȡƽ����ͳ��
	 * @param informantID
	 * @param issueID
	 * @param year
	 * @return ƽ�����ܺ�
	 */
	public double getAverageTotal(Long informantID, Long issueID , Integer year);	
	/**
	 * ��ȡƽ����ͳ��
	 * @param informantID
	 * @param issueID
	 * @return ƽ�����ܺ�
	 */
	public double getAverageTotal(Long informantID, Long issueID);	
	/**
	 * ��ȡƽ����ͳ��
	 * @param issueID
	 * @param year
	 * @param month
	 * @return ƽ�����ܺ�
	 */
	public double getAverageTotal(Long issueID , Integer year, Integer month);
	/**
	 * ��ȡƽ����ͳ��
	 * @param issueID
	 * @param year
	 * @return ƽ�����ܺ�
	 */
	public double getAverageTotal(Long issueID , Integer year);	
	/**
	 * ��ȡƽ����ͳ��
	 * @param issueID
	 * @return ƽ�����ܺ�
	 */	
	public double getAverageTotal(Long issueID);		
	/**
	 * ��ȡƽ����ͳ��
	 * @param year
	 * @param month
	 * @return ƽ�����ܺ�
	 */
	public double getAverageTotal(Integer year, Integer month);
	/**
	 * ��ȡƽ����ͳ��
	 * @param year
	 * @return ƽ�����ܺ�
	 */
	public double getAverageTotal(Integer year);	
	/**
	 * ��ȡƽ����ͳ��
	 * @param year
	 * @param month
	 * @param informantID
	 * @return ƽ�����ܺ�
	 */
	public double getAverageTotal(Integer year, Integer month, Long informantID);
	/**
	 * ��ȡƽ����ͳ��
	 * @param year
	 * @param informantID
	 * @return ƽ�����ܺ�
	 */
	public double getAverageTotal(Integer year, Long informantID);	

	/**
	 * ��ȡ�����ع˿�����
	 * @param issueID
	 * @param year
	 * @param month
	 * @return ���ع˿�����
	 */
	public int getSmgkTotal(Long issueID, Integer year, Integer month);		
	/**
	 * ��ȡ�����ع˿�����
	 * @param issueID
	 * @param year
	 * @return ���ع˿�����
	 */
	public int getSmgkTotal(Long issueID, Integer year);			
	/**
	 * ��ȡ�����ع˿�����
	 * @param informantID
	 * @param year
	 * @param month
	 * @return ���ع˿�����
	 */
	public int getSmgkTotal(Integer year, Integer month,Long informantID);		
	/**
	 * ��ȡ�����ع˿�����
	 * @param year
	 * @param month
	 * @return ���ع˿�����
	 */
	public int getSmgkTotal(Integer year,Integer month);	
	/**
	 * ��ȡָ���ڴε�Ȩ���趨ֵ
	 * @param issueID �ڴα��
	 * @return Ȩ���趨��ֵ
	 */
	public int getWeightedRound1Total(Long issueID);
	/**
	 * ��ȡָ���ڴε�Ȩ��ʵ�ʵ÷�
	 * @param issueID �ڴα��
	 * @return Ȩ�ص÷���ֵ
	 */
	public int getActualRound1Total(Long issueID);
	/**
	 * ��ȡָ���ڴε�Ȩ���趨ֵ
	 * @param issueID �ڴα��
	 * @return Ȩ���趨��ֵ
	 */
	public int getWeightedRound2Total(Long issueID);
	/**
	 * ��ȡָ���ڴε�Ȩ��ʵ�ʵ÷�
	 * @param issueID �ڴα��
	 * @return Ȩ�ص÷���ֵ
	 */
	public int getActualRound2Total(Long issueID);
	/**
	 * ��ȡָ���ڴ�һ���ж������ؿͲ�����
	 * @param issueID �ڴα��
	 * @return ���ؿ�������
	 */
	public int getSmgkTotal(Long issueID);		
	/**
	 * ��ȡָ����������ڴα��
	 * @param informantID �������
	 * @param year ���
	 * @return �ڴα��(issueID)
	 */
	public Long getLastIssue(Long informantID, Integer year);
	/**
	 * ��ȡָ����������ڴα��
	 * @param year ���
	 * @return �ڴα��(issueID)
	 */
	public Long getLastIssue(Integer year);
	
	public double getAverage(Long issueID);
}
