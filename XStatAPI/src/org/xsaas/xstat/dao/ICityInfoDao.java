package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.CityInfo;


public interface ICityInfoDao {
	/**
	 * ���������Ϣ
	 * @param data ������Ϣ
	 */
	public void saveCityInfo(CityInfo data);
	/**
	 * ���³�����Ϣ
	 * @param data ������Ϣ
	 */
	public void updateCityInfo(CityInfo data);
	/**
	 * ɾ��������Ϣ
	 * @param data ������Ϣ
	 */
	public void deleteCityInfo(CityInfo data);	
	/**
	 * ��ȡ������Ϣ
	 * @param cityID �ʾ���
	 * @return ������Ϣ
	 */
	public CityInfo getCityInfo(Long cityID);
	/**
	 * ��ȡ������Ϣ�б�
	 * @return ������Ϣ�б�
	 */
	public List<CityInfo> getCityInfoList();
	/**
	 * ��ȡ������Ϣ�б�
	 * @return ������Ϣ�б�
	 */
	public List<CityInfo> getCityInfoList(int province);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getCityInfoTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<CityInfo> findCityInfoByPage(final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @param province
	 * @return ����
	 */
	public int getCityInfoTotal(int province);

	/**
	 * ��ҳ��Ϣ
	 * @param province ʡ�ݱ��
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<CityInfo> findCityInfoByPage(final int province,final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotalByDelStatus();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<CityInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
