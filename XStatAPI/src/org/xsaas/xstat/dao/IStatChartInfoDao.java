package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.StatChartInfo;



public interface IStatChartInfoDao {
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void save(StatChartInfo data);
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void update(StatChartInfo data);
	/**
	 * ɾ���ʾ���
	 * @param data �ʾ���
	 */
	public void delete(StatChartInfo data);	
	/**
	 * ��ȡ�ʾ���
	 * @param qpID �������ͱ��
	 * @return �ʾ���
	 */
	public StatChartInfo getStatChartInfo(Long qpID);
	/**
	 * ��ȡ�ʾ����б�
	 * @return �ʾ����б�
	 */
	public List<StatChartInfo> getStatChartInfoList();
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
	public List<StatChartInfo> findByPage(final int firstResult, final int maxResult);

}
