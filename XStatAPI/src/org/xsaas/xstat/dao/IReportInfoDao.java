package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ReportInfo;


public interface IReportInfoDao {
	/**
	 * �����������Ϣ
	 * @param data ������Դ������Ϣ
	 */
	public void save(ReportInfo data);
	/**
	 * ���±�������Ϣ
	 * @param data ��������Ϣ
	 */
	public void update(ReportInfo data);
	/**
	 * ɾ����������Ϣ
	 * @param data ��������Ϣ
	 */
	public void delete(ReportInfo data);	
	/**
	 * ��ȡ��������Ϣ
	 * @param jtID �����ͱ��
	 * @return ��������Ϣ
	 */
	public ReportInfo getReportInfo(Long jtID);
	/**
	 * ��ȡ��������Ϣ�б�
	 * @return ��������Ϣ�б�
	 */
	public List<ReportInfo> getReportInfoList();
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
	public List<ReportInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(Long issueID,Long informantID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ReportInfo> findByPage(Long issueID,Long informantID,final int firstResult, final int maxResult);
	
	/**
	 * ɾ��״̬����
	 * @return int
	 */
	public int getTotalByDelStatus();
	/**
	 * ɾ��״̬��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ReportInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	
}
