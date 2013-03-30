package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ReportInfo;


public interface IReportInfoService {
	/**
	 * 保存表单类型信息
	 * @param data 表单类型信息
	 */
	public void saveReportInfo(ReportInfo data);
	/**
	 * 更新表单类型信息
	 * @param data 表单类型信息
	 */
	public void updateReportInfo(ReportInfo data);
	/**
	 * 删除表单类型信息
	 * @param data 表单类型信息
	 */
	public void deleteReportInfo(ReportInfo data);	
	/**
	 * 获取表单类型信息
	 * @param reportID 表单类型编号
	 * @return 表单类型信息
	 */
	public ReportInfo getReportInfo(Long reportID);
	/**
	 * 获取表单类型信息列表
	 * @return 表单类型信息列表
	 */
	public List<ReportInfo> getReportInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getReportInfoTotal();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getReportInfoTotal(Long issueID,Long informantID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ReportInfo> findReportInfoByPage(Long issueID,Long informantID,final int firstResult, final int maxResult);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ReportInfo> findReportInfoByPage(final int firstResult, final int maxResult);
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
