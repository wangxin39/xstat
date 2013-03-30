package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.SmgkInfo;


public interface ISmgkInfoDao {
	/**
	 * 保存神秘顾客信息
	 * @param data 神秘顾客信息
	 */
	public void saveSmgkInfo(SmgkInfo data);
	/**
	 * 更新神秘顾客信息
	 * @param data 神秘顾客信息
	 */
	public void updateSmgkInfo(SmgkInfo data);
	/**
	 * 删除神秘顾客信息
	 * @param data 神秘顾客信息
	 */
	public void deleteSmgkInfo(SmgkInfo data);	
	/**
	 * 获取神秘顾客信息
	 * @param smgkID 神秘顾客编号
	 * @return 神秘顾客信息
	 */
	public SmgkInfo getSmgkInfo(Long smgkID);
	/**
	 * 获取神秘顾客信息列表
	 * @return 神秘顾客信息列表
	 */
	public List<SmgkInfo> getSmgkInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getSmgkInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<SmgkInfo> findSmgkInfoByPage(final int firstResult, final int maxResult);
	/**
	 * 登陆系统
	 * @param username 用户名称
	 * @param password 用户密码
	 * @return SmgkInfo
	 */
	public SmgkInfo isLogin(String username,String password);
	public boolean isRegister(String userName);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getSmgkInfoTotal(Integer status);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<SmgkInfo> findSmgkInfoByPage(Integer status,final int firstResult, final int maxResult);
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
	public List<SmgkInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
