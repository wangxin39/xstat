package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ReportInfo;


public interface IReportInfoService {
	/**
	 * �����������Ϣ
	 * @param data ��������Ϣ
	 */
	public void saveReportInfo(ReportInfo data);
	/**
	 * ���±�������Ϣ
	 * @param data ��������Ϣ
	 */
	public void updateReportInfo(ReportInfo data);
	/**
	 * ɾ����������Ϣ
	 * @param data ��������Ϣ
	 */
	public void deleteReportInfo(ReportInfo data);	
	/**
	 * ��ȡ��������Ϣ
	 * @param reportID �����ͱ��
	 * @return ��������Ϣ
	 */
	public ReportInfo getReportInfo(Long reportID);
	/**
	 * ��ȡ��������Ϣ�б�
	 * @return ��������Ϣ�б�
	 */
	public List<ReportInfo> getReportInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getReportInfoTotal();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getReportInfoTotal(Long issueID,Long informantID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ReportInfo> findReportInfoByPage(Long issueID,Long informantID,final int firstResult, final int maxResult);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ReportInfo> findReportInfoByPage(final int firstResult, final int maxResult);
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
