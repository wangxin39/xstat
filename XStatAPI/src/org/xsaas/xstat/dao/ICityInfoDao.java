package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.CityInfo;


public interface ICityInfoDao {
	/**
	 * 保存城市信息
	 * @param data 城市信息
	 */
	public void saveCityInfo(CityInfo data);
	/**
	 * 更新城市信息
	 * @param data 城市信息
	 */
	public void updateCityInfo(CityInfo data);
	/**
	 * 删除城市信息
	 * @param data 城市信息
	 */
	public void deleteCityInfo(CityInfo data);	
	/**
	 * 获取城市信息
	 * @param cityID 问卷编号
	 * @return 城市信息
	 */
	public CityInfo getCityInfo(Long cityID);
	/**
	 * 获取城市信息列表
	 * @return 城市信息列表
	 */
	public List<CityInfo> getCityInfoList();
	/**
	 * 获取城市信息列表
	 * @return 城市信息列表
	 */
	public List<CityInfo> getCityInfoList(int province);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getCityInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<CityInfo> findCityInfoByPage(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @param province
	 * @return 数量
	 */
	public int getCityInfoTotal(int province);

	/**
	 * 分页信息
	 * @param province 省份编号
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<CityInfo> findCityInfoByPage(final int province,final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotalByDelStatus();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<CityInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
