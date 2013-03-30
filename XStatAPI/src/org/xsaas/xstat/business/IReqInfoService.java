package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ReqInfo;


public interface IReqInfoService {
	/**
	 * 保存检测申诉信息
	 * @param data 检测申诉信息
	 */
	public void saveReqInfo(ReqInfo data);
	/**
	 * 更新检测申诉信息
	 * @param data 检测申诉信息
	 */
	public void updateReqInfo(ReqInfo data);
	/**
	 * 删除检测申诉信息
	 * @param data 检测申诉信息
	 */
	public void deleteReqInfo(ReqInfo data);	
	/**
	 * 获取检测申诉信息
	 * @param reqID 问卷编号
	 * @return 检测申诉信息
	 */
	public ReqInfo getReqInfo(Long reqID);
	/**
	 * 获取检测申诉信息列表
	 * @return 检测申诉信息列表
	 */
	public List<ReqInfo> getReqInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getReqInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ReqInfo> findReqInfoByPage(final int firstResult, final int maxResult);
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
	public List<ReqInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
