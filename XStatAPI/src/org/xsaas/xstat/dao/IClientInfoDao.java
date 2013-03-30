package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ClientInfo;


public interface IClientInfoDao {
	/**
	 * 保存检测客户信息
	 * @param data 检测客户信息
	 */
	public void saveClientInfo(ClientInfo data);
	/**
	 * 更新检测客户信息
	 * @param data 检测客户信息
	 */
	public void updateClientInfo(ClientInfo data);
	/**
	 * 删除检测客户信息
	 * @param data 检测客户信息
	 */
	public void deleteClientInfo(ClientInfo data);	
	/**
	 * 获取检测客户信息
	 * @param clientID 问卷编号
	 * @return 检测客户信息
	 */
	public ClientInfo getClientInfo(Long clientID);
	/**
	 * 获取检测客户信息列表
	 * @return 检测客户信息列表
	 */
	public List<ClientInfo> getClientInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getClientInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ClientInfo> findClientInfoByPage(final int firstResult, final int maxResult);

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
	public List<ClientInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
