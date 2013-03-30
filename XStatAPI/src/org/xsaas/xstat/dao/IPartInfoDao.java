package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.PartInfo;



public interface IPartInfoDao {
	/**
	 * 保存问卷部分
	 * @param data 问卷部分
	 */
	public void save(PartInfo data);
	/**
	 * 更新问卷部分
	 * @param data 问卷部分
	 */
	public void update(PartInfo data);
	/**
	 * 删除问卷部分
	 * @param data 问卷部分
	 */
	public void delete(PartInfo data);	
	/**
	 * 获取问卷部分
	 * @param qpID 问题类型编号
	 * @return 问卷部分
	 */
	public PartInfo getPartInfo(Long qpID);
	public List<PartInfo> getPartInfoList(Long inquisitionID);
	/**
	 * 获取问卷部分列表
	 * @return 问卷部分列表
	 */
	public List<PartInfo> getPartInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(long inquisitionID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<PartInfo> findByPage(long inquisitionID,final int firstResult, final int maxResult);
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
	public List<PartInfo> findByPage(final int firstResult, final int maxResult);
	
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
	public List<PartInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
