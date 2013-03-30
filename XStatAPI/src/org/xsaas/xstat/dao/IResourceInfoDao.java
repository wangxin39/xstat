package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ResourceInfo;


public interface IResourceInfoDao {

	/**
	 * 保存试题资源类型信息
	 * @param data 试题资源类型信息
	 */
	public void save(ResourceInfo data);
	/**
	 * 更新试题资源类型信息
	 * @param data 试题资源类型信息
	 */
	public void update(ResourceInfo data);
	/**
	 * 删除试题资源类型信息
	 * @param data 试题资源类型信息
	 */
	public void delete(ResourceInfo data);	
	/**
	 * 获取试题资源类型信息
	 * @param resourceID 试题资源编号
	 * @return 试题资源类型信息
	 */
	public ResourceInfo getResourceInfo(Long resourceID);
	/**
	 * 获取试题资源类型信息列表
	 * @return 试题资源类型信息列表
	 */
	public List<ResourceInfo> getList();
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
	public List<ResourceInfo> findByPage(final int firstResult, final int maxResult);
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
	public List<ResourceInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	
}
