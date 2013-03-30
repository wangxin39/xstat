package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.MenuInfo;


public interface IMenuInfoDao {
	/**
	 * 保存菜单信息
	 * @param data 菜单信息
	 */
	public void save(MenuInfo data);
	/**
	 * 更新菜单信息
	 * @param data 菜单信息
	 */	
	public void update(MenuInfo data);
	/**
	 * 删除菜单
	 * @param data 菜单信息
	 */
	public void delete(MenuInfo data);
	/**
	 * 获取指定编辑菜单信息
	 * @param menuID 菜单编号
	 * @return 菜单信息
	 */
	public MenuInfo getMenuInfo(Long menuID);
	/**
	 * 获取菜单
	 * @param parentID 为0，则为一级菜单，指定上级菜单编号，则返回该菜单下的菜单
	 * @param type 1：网络管理系统，2：神秘顾客系统，3：客户分析系统，4：审核编辑系统
	 * @return List<MenuInfo> 菜单列表
	 */
	public List<MenuInfo> getMenuInfoList(Long parentID,int type);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<MenuInfo> findByPage(final int firstResult, final int maxResult);
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
	public List<MenuInfo> findPageByDelStatus(final int firstResult, final int maxResult);

}
