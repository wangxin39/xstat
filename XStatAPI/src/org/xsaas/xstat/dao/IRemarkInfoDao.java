package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.RemarkInfo;


public interface IRemarkInfoDao {
	/**
	 * 保存调查问卷人工评语信息
	 * @param data 调查问卷人工评语信息
	 */
	public void save(RemarkInfo data);
	/**
	 * 更新调查问卷人工评语信息
	 * @param data 调查问卷人工评语信息
	 */
	public void update(RemarkInfo data);
	/**
	 * 删除调查问卷人工评语信息
	 * @param data 调查问卷人工评语信息
	 */
	public void delete(RemarkInfo data);	
	/**
	 * 获取调查问卷人工评语信息
	 * @param remarkID 人工评语编号
	 * @return 调查问卷人工评语信息
	 */
	public RemarkInfo getRemarkInfo(Long remarkID);
	/**
	 * 获取调查问卷人工评语信息列表
	 * @return 调查问卷人工评语信息列表
	 */
	public List<RemarkInfo> getRemarkInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(long inquisitionID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<RemarkInfo> findByPage(long inquisitionID,final int firstResult, final int maxResult);
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
	public List<RemarkInfo> findByPage(final int firstResult, final int maxResult);
	
	/**
	 * 获取评论信息
	 * @param issueID
	 * @param informantID
	 * @param inquisitionID
	 * @return 评论信息列表
	 */
	public List<RemarkInfo> findByInformant(Long issueID, Long informantID, Long inquisitionID);
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
	public List<RemarkInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
