package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.OutputInfo;


public interface IOutputInfoService {
	/**
	 * 保存报告翻译信息
	 * @param data 报告翻译信息
	 */
	public void saveOutputInfo(OutputInfo data);
	/**
	 * 更新报告翻译信息
	 * @param data 报告翻译信息
	 */
	public void updateOutputInfo(OutputInfo data);
	/**
	 * 删除报告翻译信息
	 * @param data 报告翻译信息
	 */
	public void deleteOutputInfo(OutputInfo data);	
	/**
	 * 获取报告翻译信息
	 * @param translateID 报告翻译编号
	 * @return 报告翻译信息
	 */
	public OutputInfo getOutputInfo(Long translateID);
	/**
	 * 获取报告翻译信息列表
	 * @return 报告翻译信息列表
	 */
	public List<OutputInfo> getOutputInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getOutputInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<OutputInfo> findOutputInfoByPage(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getOutputInfoTotal(Long informantID,Long issueID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<OutputInfo> findOutputInfoByPage(Long informantID,Long issueID,final int firstResult, final int maxResult);

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
	public List<OutputInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
