package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ThemeInfo;


public interface IThemeInfoService {
	/**
	 * ���汨�淭����Ϣ
	 * @param data ���淭����Ϣ
	 */
	public void saveThemeInfo(ThemeInfo data);
	/**
	 * ���±��淭����Ϣ
	 * @param data ���淭����Ϣ
	 */
	public void updateThemeInfo(ThemeInfo data);
	/**
	 * ɾ�����淭����Ϣ
	 * @param data ���淭����Ϣ
	 */
	public void deleteThemeInfo(ThemeInfo data);	
	/**
	 * ��ȡ���淭����Ϣ
	 * @param translateID ���淭����
	 * @return ���淭����Ϣ
	 */
	public ThemeInfo getThemeInfo(Long translateID);
	/**
	 * ��ȡ���淭����Ϣ�б�
	 * @return ���淭����Ϣ�б�
	 */
	public List<ThemeInfo> getThemeInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getThemeInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ThemeInfo> findThemeInfoByPage(final int firstResult, final int maxResult);
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
