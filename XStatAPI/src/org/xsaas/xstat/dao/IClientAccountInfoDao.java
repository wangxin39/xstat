package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ClientAccountInfo;


public interface IClientAccountInfoDao {
	/**
	 * 保存检测客户信息
	 * @param data 检测客户信息
	 */
	public void saveClientAccountInfo(ClientAccountInfo data);
	/**
	 * 更新检测客户信息
	 * @param data 检测客户信息
	 */
	public void updateClientAccountInfo(ClientAccountInfo data);
	/**
	 * 删除检测客户信息
	 * @param data 检测客户信息
	 */
	public void deleteClientAccountInfo(ClientAccountInfo data);	
	/**
	 * 获取检测客户信息
	 * @param clientID 问卷编号
	 * @return 检测客户信息
	 */
	public ClientAccountInfo getClientAccountInfo(Long clientID);
	/**
	 * 获取检测客户信息列表
	 * @return 检测客户信息列表
	 */
	public List<ClientAccountInfo> getClientAccountInfoList();
	public List<ClientAccountInfo> getClientAccountInfoList(Long clientID,Long informantID);	
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getClientAccountInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ClientAccountInfo> findClientAccountInfoByPage(final int firstResult, final int maxResult);

	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getClientAccountInfoTotal(int account);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ClientAccountInfo> findClientAccountInfoByPage(final int account,final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getClientAccountInfoTotal(Long clientID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ClientAccountInfo> findClientAccountInfoByPage(final Long clientID,final int firstResult, final int maxResult);
	/**
	 * 登陆系统
	 * @param username 用户名称
	 * @param password 用户密码
	 * @return SmgkInfo
	 */
	public ClientAccountInfo isLogin(String loginname,String password);
	public boolean isRegister(String loginname,String password);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotalByDelStatus();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ClientAccountInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	
}
