package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.StatChartInfo;


public interface IStatChartInfoService {

	/**
	 * 保存调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void saveStatChartInfo(StatChartInfo data);
	/**
	 * 更新调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void updateStatChartInfo(StatChartInfo data);
	/**
	 * 删除调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void deleteStatChartInfo(StatChartInfo data);	
	/**
	 * 获取调查问卷信息
	 * @param partID 试题部分编号
	 * @return 调查问卷信息
	 */
	public StatChartInfo getStatChartInfo(Long partID);
	/**
	 * 获取调查问卷信息列表
	 * @return 调查问卷信息列表
	 */
	public List<StatChartInfo> getStatChartInfoList();
	/**
	 * 通过指定的起始数和结束数得到一个集合
	 * @param firstResult 
	 * @param maxResult 
	 * @return 调查问卷信息
	 */
	public List<StatChartInfo> findByPageStatChartInfo(final int firstResult,final int maxResult);
	/**
	 * 通过指定的起始数获取总集合
	 * @return 总数
	 */
	public int getTotalStatChartInfo();
}
