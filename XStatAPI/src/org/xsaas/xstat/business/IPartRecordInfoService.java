package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.PartRecordInfo;


public interface IPartRecordInfoService {
	/**
	 * 保存调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void savePartRecordInfo(PartRecordInfo data);
	/**
	 * 更新调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void updatePartRecordInfo(PartRecordInfo data);
	/**
	 * 删除调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void deletePartRecordInfo(PartRecordInfo data);	
	/**
	 * 获取调查问卷头部信息
	 * @param answerID 问卷头部编号
	 * @return 调查问卷头部信息
	 */
	public PartRecordInfo getPartRecordInfo(Long answerID);
	/**
	 * 获取调查问卷头部信息列表
	 * @return 调查问卷头部信息列表
	 */
	public List<PartRecordInfo> getPartRecordInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getPartRecordInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<PartRecordInfo> findPartRecordInfoByPage(final int firstResult, final int maxResult);
	/**
	 * 获取当前计划数据
	 * @param planID
	 * @return 答卷信息
	 */
	public List<PartRecordInfo> findByPlan(Long planID);
}
