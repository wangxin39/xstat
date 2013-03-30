package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ReportTemplateInfo;


public interface IReportTemplateInfoDao {
	/**
	 * 保存调查问卷模板信息
	 * @param data 调查问卷模板信息
	 */
	public void saveReportTemplateInfo(ReportTemplateInfo data);
	/**
	 * 更新调查问卷模板信息
	 * @param data 调查问卷模板信息
	 */
	public void updateReportTemplateInfo(ReportTemplateInfo data);
	/**
	 * 删除调查问卷模板信息
	 * @param data 调查问卷模板信息
	 */
	public void deleteReportTemplateInfo(ReportTemplateInfo data);	
	/**
	 * 获取调查问卷模板信息
	 * @param tempID 问卷问题编号
	 * @return 调查问卷模板信息
	 */
	public ReportTemplateInfo getReportTemplateInfo(Long tempID);
	/**
	 * 获取调查问卷模板信息列表
	 * @return 调查问卷模板信息列表
	 */
	public List<ReportTemplateInfo> getReportTemplateInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getReportTemplateInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ReportTemplateInfo> findReportTemplateInfoByPage(final int firstResult, final int maxResult);
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
	public List<ReportTemplateInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
