package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.SitePopedomInfo;


public interface ISitePopedomInfoDao {
	/**
	 * 保存网站权限信息
	 * @param data 试题资源类型信息
	 */
	public void save(SitePopedomInfo data);
	/**
	 * 更新网站权限信息
	 * @param data 网站权限信息
	 */
	public void update(SitePopedomInfo data);
	/**
	 * 删除网站权限信息
	 * @param data 网站权限信息
	 */
	public void delete(SitePopedomInfo data);	
	/**
	 * 获取网站权限信息
	 * @param sitePopedomID 网站权限编号
	 * @return 网站权限信息
	 */
	public SitePopedomInfo getSitePopedomInfo(Long sitePopedomID);
	/**
	 * 获取网站权限信息列表
	 * @return 网站权限信息列表
	 */
	public List<SitePopedomInfo> getSitePopedomInfoList();
	/**
	 * 获取网站权限信息列表
	 * @return 网站权限信息列表
	 */
	public List<SitePopedomInfo> getSitePopedomInfoList(Long employeeID);
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
	public List<SitePopedomInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getSitePopedomInfoTotal(long employeeID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<SitePopedomInfo> findSitePopedomInfoByPage(long employeeID,final int firstResult, final int maxResult);

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
	public List<SitePopedomInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	
}
