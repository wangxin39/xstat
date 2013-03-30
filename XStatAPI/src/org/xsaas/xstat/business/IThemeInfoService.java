package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ThemeInfo;


public interface IThemeInfoService {
	/**
	 * 保存报告翻译信息
	 * @param data 报告翻译信息
	 */
	public void saveThemeInfo(ThemeInfo data);
	/**
	 * 更新报告翻译信息
	 * @param data 报告翻译信息
	 */
	public void updateThemeInfo(ThemeInfo data);
	/**
	 * 删除报告翻译信息
	 * @param data 报告翻译信息
	 */
	public void deleteThemeInfo(ThemeInfo data);	
	/**
	 * 获取报告翻译信息
	 * @param translateID 报告翻译编号
	 * @return 报告翻译信息
	 */
	public ThemeInfo getThemeInfo(Long translateID);
	/**
	 * 获取报告翻译信息列表
	 * @return 报告翻译信息列表
	 */
	public List<ThemeInfo> getThemeInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getThemeInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ThemeInfo> findThemeInfoByPage(final int firstResult, final int maxResult);
	/**
	 * 删除状态总数
	 * @return int
	 */
	public int getTotalByDelStatus();
	/**
	 * 删除状态分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ThemeInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
