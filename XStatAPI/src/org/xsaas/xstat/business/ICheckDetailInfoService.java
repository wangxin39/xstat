package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.CheckDetailInfo;


public interface ICheckDetailInfoService {
	/**
	 * 保存检测客户信息
	 * @param data 检测客户信息
	 */
	public void saveCheckDetailInfo(CheckDetailInfo data);
	/**
	 * 更新检测客户信息
	 * @param data 检测客户信息
	 */
	public void updateCheckDetailInfo(CheckDetailInfo data);
	/**
	 * 删除检测客户信息
	 * @param data 检测客户信息
	 */
	public void deleteCheckDetailInfo(CheckDetailInfo data);	
	/**
	 * 获取检测客户信息
	 * @param checkClientID 问卷编号
	 * @return 检测客户信息
	 */
	public CheckDetailInfo getCheckDetailInfo(Long checkClientID);
	/**
	 * 获取检测客户信息列表
	 * @return 检测客户信息列表
	 */
	public List<CheckDetailInfo> getCheckDetailInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getCheckDetailInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<CheckDetailInfo> findCheckDetailInfoByPage(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getCheckDetailInfoTotal(Long issueID,Long informantID,Long inquisitionID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<CheckDetailInfo> findCheckDetailInfoByPage(Long issueID,Long informantID,Long inquisitionID,final int firstResult, final int maxResult);
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
	public List<CheckDetailInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getCheckDetailInfoTotal(Long clientID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<CheckDetailInfo> findCheckDetailInfoByPage(Long clientID,final int firstResult, final int maxResult);
	

}
