package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ReportTemplateInfo;


public interface IReportTemplateInfoDao {
	/**
	 * ��������ʾ�ģ����Ϣ
	 * @param data �����ʾ�ģ����Ϣ
	 */
	public void saveReportTemplateInfo(ReportTemplateInfo data);
	/**
	 * ���µ����ʾ�ģ����Ϣ
	 * @param data �����ʾ�ģ����Ϣ
	 */
	public void updateReportTemplateInfo(ReportTemplateInfo data);
	/**
	 * ɾ�������ʾ�ģ����Ϣ
	 * @param data �����ʾ�ģ����Ϣ
	 */
	public void deleteReportTemplateInfo(ReportTemplateInfo data);	
	/**
	 * ��ȡ�����ʾ�ģ����Ϣ
	 * @param tempID �ʾ�������
	 * @return �����ʾ�ģ����Ϣ
	 */
	public ReportTemplateInfo getReportTemplateInfo(Long tempID);
	/**
	 * ��ȡ�����ʾ�ģ����Ϣ�б�
	 * @return �����ʾ�ģ����Ϣ�б�
	 */
	public List<ReportTemplateInfo> getReportTemplateInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getReportTemplateInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ReportTemplateInfo> findReportTemplateInfoByPage(final int firstResult, final int maxResult);
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
	public List<ReportTemplateInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
