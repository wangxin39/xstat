package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.PartRecordInfo;


public interface IPartRecordInfoDao {
	/**
	 * 保存调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void save(PartRecordInfo data);
	/**
	 * 更新调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void update(PartRecordInfo data);
	/**
	 * 删除调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void delete(PartRecordInfo data);	
	/**
	 * 获取调查问卷头部信息
	 * @param answerID 调查问卷头部信息编号
	 * @return 调查问卷头部信息
	 */
	public PartRecordInfo getInfo(Long answerID);
	/**
	 * 获取调查问卷头部信息列表
	 * @return 调查问卷头部信息列表
	 */
	public List<PartRecordInfo> getList();
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
	public List<PartRecordInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * 获取当前计划数据
	 * @param planID
	 * @return 答卷信息
	 */
	public List<PartRecordInfo> findByPlan(Long planID);
	
}
