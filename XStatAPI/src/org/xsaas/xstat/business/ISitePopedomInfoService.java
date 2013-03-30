package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.SitePopedomInfo;


public interface ISitePopedomInfoService {
	/**
	 * 保存网站权限信息
	 * @param data 网站权限信息
	 */
	public void saveSitePopedomInfo(SitePopedomInfo data);
	/**
	 * 更新网站权限信息
	 * @param data 网站权限信息
	 */
	public void updateSitePopedomInfo(SitePopedomInfo data);
	/**
	 * 删除网站权限信息
	 * @param data 网站权限信息
	 */
	public void deleteSitePopedomInfo(SitePopedomInfo data);	
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
	 * 信息总数
	 * @return 数量
	 */
	public int getSitePopedomInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<SitePopedomInfo> findSitePopedomInfoByPage(final int firstResult, final int maxResult);
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
	/**
	 * 获取网站权限信息列表
	 * @return 网站权限信息列表
	 */
	public List<SitePopedomInfo> getSitePopedomInfoList(Long employeeID);

}
