package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.StatChartInfo;


public interface IStatChartInfoService {

	/**
	 * ��������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void saveStatChartInfo(StatChartInfo data);
	/**
	 * ���µ����ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void updateStatChartInfo(StatChartInfo data);
	/**
	 * ɾ�������ʾ���Ϣ
	 * @param data �����ʾ���Ϣ
	 */
	public void deleteStatChartInfo(StatChartInfo data);	
	/**
	 * ��ȡ�����ʾ���Ϣ
	 * @param partID ���ⲿ�ֱ��
	 * @return �����ʾ���Ϣ
	 */
	public StatChartInfo getStatChartInfo(Long partID);
	/**
	 * ��ȡ�����ʾ���Ϣ�б�
	 * @return �����ʾ���Ϣ�б�
	 */
	public List<StatChartInfo> getStatChartInfoList();
	/**
	 * ͨ��ָ������ʼ���ͽ������õ�һ������
	 * @param firstResult 
	 * @param maxResult 
	 * @return �����ʾ���Ϣ
	 */
	public List<StatChartInfo> findByPageStatChartInfo(final int firstResult,final int maxResult);
	/**
	 * ͨ��ָ������ʼ����ȡ�ܼ���
	 * @return ����
	 */
	public int getTotalStatChartInfo();
}
