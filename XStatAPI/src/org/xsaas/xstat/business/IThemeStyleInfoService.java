package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ThemeStyleInfo;


public interface IThemeStyleInfoService {
	/**
	 * 保存报告翻译信息
	 * @param data 报告翻译信息
	 */
	public void saveThemeStyleInfo(ThemeStyleInfo data);
	/**
	 * 更新报告翻译信息
	 * @param data 报告翻译信息
	 */
	public void updateThemeStyleInfo(ThemeStyleInfo data);
	/**
	 * 删除报告翻译信息
	 * @param data 报告翻译信息
	 */
	public void deleteThemeStyleInfo(ThemeStyleInfo data);	
	/**
	 * 获取报告翻译信息
	 * @param translateID 报告翻译编号
	 * @return 报告翻译信息
	 */
	public ThemeStyleInfo getThemeStyleInfo(Long translateID);
	/**
	 * 获取报告翻译信息列表
	 * @return 报告翻译信息列表
	 */
	public List<ThemeStyleInfo> getThemeStyleInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getThemeStyleInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ThemeStyleInfo> findThemeStyleInfoByPage(final int firstResult, final int maxResult);
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
	public List<ThemeStyleInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
