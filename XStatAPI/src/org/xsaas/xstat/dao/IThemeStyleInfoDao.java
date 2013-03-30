package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ThemeStyleInfo;



public interface IThemeStyleInfoDao {
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void save(ThemeStyleInfo data);
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void update(ThemeStyleInfo data);
	/**
	 * ɾ���ʾ���
	 * @param data �ʾ���
	 */
	public void delete(ThemeStyleInfo data);	
	/**
	 * ��ȡ�ʾ���
	 * @param qpID �������ͱ��
	 * @return �ʾ���
	 */
	public ThemeStyleInfo getThemeStyleInfo(Long qpID);
	/**
	 * ��ȡ�ʾ����б�
	 * @return �ʾ����б�
	 */
	public List<ThemeStyleInfo> getThemeStyleInfoList();
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
	public List<ThemeStyleInfo> findByPage(final int firstResult, final int maxResult);
	
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
	public List<ThemeStyleInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
