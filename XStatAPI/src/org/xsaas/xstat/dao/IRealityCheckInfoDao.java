package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.RealityCheckInfo;


public interface IRealityCheckInfoDao {
	/**
	 * 保存检测客户信息
	 * @param data 检测客户信息
	 */
	public void saveRealityCheckInfo(RealityCheckInfo data);
	/**
	 * 更新检测客户信息
	 * @param data 检测客户信息
	 */
	public void updateRealityCheckInfo(RealityCheckInfo data);
	/**
	 * 删除检测客户信息
	 * @param data 检测客户信息
	 */
	public void deleteRealityCheckInfo(RealityCheckInfo data);	
	/**
	 * 获取检测客户信息
	 * @param clientID 问卷编号
	 * @return 检测客户信息
	 */
	public RealityCheckInfo getRealityCheckInfo(Long clientID);
	/**
	 * 获取检测客户信息列表
	 * @return 检测客户信息列表
	 */
	public List<RealityCheckInfo> getRealityCheckInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getRealityCheckInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<RealityCheckInfo> findRealityCheckInfoByPage(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(Long issueID,Long inquisitionID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<RealityCheckInfo> findByPage(Long issueID,Long inquisitionID,final int firstResult, final int maxResult);
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
	public List<RealityCheckInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getRealityCheckInfoTotal(Long clientID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<RealityCheckInfo> findRealityCheckInfoByPage(Long clientID,final int firstResult, final int maxResult);


}
