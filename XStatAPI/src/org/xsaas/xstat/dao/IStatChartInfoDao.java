package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.StatChartInfo;



public interface IStatChartInfoDao {
	/**
	 * 保存问卷部分
	 * @param data 问卷部分
	 */
	public void save(StatChartInfo data);
	/**
	 * 更新问卷部分
	 * @param data 问卷部分
	 */
	public void update(StatChartInfo data);
	/**
	 * 删除问卷部分
	 * @param data 问卷部分
	 */
	public void delete(StatChartInfo data);	
	/**
	 * 获取问卷部分
	 * @param qpID 问题类型编号
	 * @return 问卷部分
	 */
	public StatChartInfo getStatChartInfo(Long qpID);
	/**
	 * 获取问卷部分列表
	 * @return 问卷部分列表
	 */
	public List<StatChartInfo> getStatChartInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<StatChartInfo> findByPage(final int firstResult, final int maxResult);

}
