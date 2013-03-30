
package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.ClientPopedomInfo;


public interface IClientPopedomInfoService {
	/**
	 * 保存检测客户权限信息
	 * @param data 检测客户权限信息
	 */
	public void saveClientPopedomInfo(ClientPopedomInfo data);
	/**
	 * 更新检测客户权限信息
	 * @param data 检测客户权限信息
	 */
	public void updateClientPopedomInfo(ClientPopedomInfo data);
	/**
	 * 删除检测客户权限信息
	 * @param data 检测客户权限信息
	 */
	public void deleteClientPopedomInfo(ClientPopedomInfo data);	
	/**
	 * 获取检测客户权限信息
	 * @param clientPopedomID 检测客户权限编号
	 * @return 检测客户权限信息
	 */
	public ClientPopedomInfo getClientPopedomInfo(Long clientPopedomID);
	/**
	 * 获取检测客户权限信息列表
	 * @return 检测客户权限信息列表
	 */
	public List<ClientPopedomInfo> getClientPopedomInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getClientPopedomInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ClientPopedomInfo> findClientPopedomInfoByPage(final int firstResult, final int maxResult);

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
	public List<ClientPopedomInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
