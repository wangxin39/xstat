package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ThemeStyleInfo;


public interface IThemeStyleInfoService {
	/**
	 * ���汨�淭����Ϣ
	 * @param data ���淭����Ϣ
	 */
	public void saveThemeStyleInfo(ThemeStyleInfo data);
	/**
	 * ���±��淭����Ϣ
	 * @param data ���淭����Ϣ
	 */
	public void updateThemeStyleInfo(ThemeStyleInfo data);
	/**
	 * ɾ�����淭����Ϣ
	 * @param data ���淭����Ϣ
	 */
	public void deleteThemeStyleInfo(ThemeStyleInfo data);	
	/**
	 * ��ȡ���淭����Ϣ
	 * @param translateID ���淭����
	 * @return ���淭����Ϣ
	 */
	public ThemeStyleInfo getThemeStyleInfo(Long translateID);
	/**
	 * ��ȡ���淭����Ϣ�б�
	 * @return ���淭����Ϣ�б�
	 */
	public List<ThemeStyleInfo> getThemeStyleInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getThemeStyleInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<ThemeStyleInfo> findThemeStyleInfoByPage(final int firstResult, final int maxResult);
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
