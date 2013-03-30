package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.SmgkMenuInfo;


public interface ISmgkMenuInfoService {
	/**
	 * 保存菜单信息
	 * @param data 菜单信息
	 */
	public void saveSmgkMenuInfo(SmgkMenuInfo data);
	/**
	 * 更新菜单信息
	 * @param data 菜单信息
	 */	
	public void updateSmgkMenuInfo(SmgkMenuInfo data);
	/**
	 * 删除菜单
	 * @param data 菜单信息
	 */
	public void deleteSmgkMenuInfo(SmgkMenuInfo data);
	/**
	 * 获取菜单
	 * @return List<SmgkMenuInfo> 菜单列表
	 */
	public List<SmgkMenuInfo> getSmgkMenuInfoList();
	/**
	 * 获取指定编辑菜单信息
	 * @param menuID 菜单编号
	 * @return 菜单信息
	 */
	public SmgkMenuInfo getSmgkMenuInfo(Long menuID);

	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getSmgkMenuInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<SmgkMenuInfo> findSmgkMenuInfoByPage(final int firstResult, final int maxResult);

}
