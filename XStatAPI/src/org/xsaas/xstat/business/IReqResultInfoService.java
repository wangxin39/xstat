package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ReqResultInfo;


public interface IReqResultInfoService {
	/**
	 * 保存顾客认证信息
	 * @param data 顾客认证信息
	 */
	public void saveReqResultInfo(ReqResultInfo data);
	/**
	 * 更新顾客认证信息
	 * @param data 顾客认证信息
	 */
	public void updateReqResultInfo(ReqResultInfo data);
	/**
	 * 删除顾客认证信息
	 * @param data 顾客认证信息
	 */
	public void deleteReqResultInfo(ReqResultInfo data);	
	/**
	 * 获取顾客认证信息
	 * @param authID 问卷编号
	 * @return 顾客认证信息
	 */
	public ReqResultInfo getReqResultInfo(Long authID);
	
	/**
	 * 获取顾客认证信息列表
	 * @return 顾客认证信息列表
	 */
	public List<ReqResultInfo> getReqResultInfoList();
	/**
	 * 获取顾客认证信息列表
	 * @return 顾客认证信息列表
	 */
	public List<ReqResultInfo> findReqResultInfoByReq(Long reqID);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getReqResultInfoTotal();
	public ReqResultInfo findReqResultInfoBySmgk(long smgkID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ReqResultInfo> findReqResultInfoByPage(final int firstResult, final int maxResult);
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
	public List<ReqResultInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
