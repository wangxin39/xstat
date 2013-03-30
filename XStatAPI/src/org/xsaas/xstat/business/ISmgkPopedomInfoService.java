package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.SmgkPopedomInfo;


public interface ISmgkPopedomInfoService {
	/**
	 * 保存神秘顾客权限信息
	 * @param data 神秘顾客权限信息
	 */
	public void saveSmgkPopedomInfo(SmgkPopedomInfo data);
	/**
	 * 更新神秘顾客权限信息
	 * @param data 神秘顾客权限信息
	 */
	public void updateSmgkPopedomInfo(SmgkPopedomInfo data);
	/**
	 * 删除神秘顾客权限信息
	 * @param data 神秘顾客权限信息
	 */
	public void deleteSmgkPopedomInfo(SmgkPopedomInfo data);	
	/**
	 * 获取神秘顾客权限信息
	 * @param smgkPopedomID 神秘顾客权限信息编号
	 * @return 神秘顾客权限信息
	 */
	public SmgkPopedomInfo getSmgkPopedomInfo(Long smgkPopedomID);
	/**
	 * 获取神秘顾客权限信息列表
	 * @return 神秘顾客权限信息列表
	 */
	public List<SmgkPopedomInfo> getSmgkPopedomInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getSmgkPopedomInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<SmgkPopedomInfo> findSmgkPopedomInfoByPage(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getSmgkPopedomInfoTotal(long employeeID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<SmgkPopedomInfo> findSmgkPopedomInfoByPage(long employeeID,final int firstResult, final int maxResult);

}
