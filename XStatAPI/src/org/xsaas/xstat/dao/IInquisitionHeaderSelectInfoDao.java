package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.InquisitionHeaderSelectInfo;


public interface IInquisitionHeaderSelectInfoDao {
	/**
	 * 保存调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void save(InquisitionHeaderSelectInfo data);
	/**
	 * 更新调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void update(InquisitionHeaderSelectInfo data);
	/**
	 * 删除调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void delete(InquisitionHeaderSelectInfo data);	
	/**
	 * 获取调查问卷头部信息
	 * @param headerSelectID 调查问卷头部信息编号
	 * @return 调查问卷头部信息
	 */
	public InquisitionHeaderSelectInfo getInquisitionHeaderSelectInfo(Long headerSelectID);
	/**
	 * 获取调查问卷头部信息列表
	 * @return 调查问卷头部信息列表
	 */
	public List<InquisitionHeaderSelectInfo> getList();
	/**
	 * 获取问卷表头所属选项列表
	 * @param inquisitionID
	 * @param headerID
	 * @return 信息列表
	 */
	public List<InquisitionHeaderSelectInfo> getList(Long inquisitionID,Long headerID);

	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(Long headerID);
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
	public List<InquisitionHeaderSelectInfo> findByPage(Long headerID,final int firstResult, final int maxResult);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<InquisitionHeaderSelectInfo> findByPage(final int firstResult, final int maxResult);
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
	public List<InquisitionHeaderSelectInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
