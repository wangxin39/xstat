package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.RemarkInfo;


public interface IRemarkInfoService {
	/**
	 * 保存问卷人工评分信息
	 * @param data 问卷人工评分信息
	 */
	public void saveRemarkInfo(RemarkInfo data);
	/**
	 * 更新问卷人工评分信息
	 * @param data 问卷人工评分信息
	 */
	public void updateRemarkInfo(RemarkInfo data);
	/**
	 * 删除问卷人工评分信息
	 * @param data 问卷人工评分信息
	 */
	public void deleteRemarkInfo(RemarkInfo data);	
	/**
	 * 获取问卷人工评分信息
	 * @param remarkID 问卷人工评分编号
	 * @return 问卷人工评分信息
	 */
	public RemarkInfo getRemarkInfo(Long remarkID);
	/**
	 * 获取问卷人工评分信息列表
	 * @return 问卷人工评分信息列表
	 */
	public List<RemarkInfo> getRemarkInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getRemarkInfoTotal(long inquisitionID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<RemarkInfo> findRemarkInfoByPage(long inquisitionID,final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getRemarkInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<RemarkInfo> findRemarkInfoByPage(final int firstResult, final int maxResult);
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
