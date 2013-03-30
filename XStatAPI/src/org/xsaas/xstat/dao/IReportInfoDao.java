package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ReportInfo;


public interface IReportInfoDao {
	/**
	 * 保存表单类型信息
	 * @param data 试题资源类型信息
	 */
	public void save(ReportInfo data);
	/**
	 * 更新表单类型信息
	 * @param data 表单类型信息
	 */
	public void update(ReportInfo data);
	/**
	 * 删除表单类型信息
	 * @param data 表单类型信息
	 */
	public void delete(ReportInfo data);	
	/**
	 * 获取表单类型信息
	 * @param jtID 表单类型编号
	 * @return 表单类型信息
	 */
	public ReportInfo getReportInfo(Long jtID);
	/**
	 * 获取表单类型信息列表
	 * @return 表单类型信息列表
	 */
	public List<ReportInfo> getReportInfoList();
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
	public List<ReportInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(Long issueID,Long informantID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ReportInfo> findByPage(Long issueID,Long informantID,final int firstResult, final int maxResult);
	
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
	public List<ReportInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	
}
