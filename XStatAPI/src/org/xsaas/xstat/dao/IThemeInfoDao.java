package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ThemeInfo;



public interface IThemeInfoDao {
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void save(ThemeInfo data);
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void update(ThemeInfo data);
	/**
	 * ɾ���ʾ���
	 * @param data �ʾ���
	 */
	public void delete(ThemeInfo data);	
	/**
	 * ��ȡ�ʾ���
	 * @param qpID �������ͱ��
	 * @return �ʾ���
	 */
	public ThemeInfo getThemeInfo(Long qpID);
	/**
	 * ��ȡ�ʾ����б�
	 * @return �ʾ����б�
	 */
	public List<ThemeInfo> getThemeInfoList();
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
	public List<ThemeInfo> findByPage(final int firstResult, final int maxResult);
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
	public List<ThemeInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
