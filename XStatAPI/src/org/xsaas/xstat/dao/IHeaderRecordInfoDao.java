package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.HeaderRecordInfo;


public interface IHeaderRecordInfoDao {
	/**
	 * 保存调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void save(HeaderRecordInfo data);
	/**
	 * 更新调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void update(HeaderRecordInfo data);
	/**
	 * 删除调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void delete(HeaderRecordInfo data);	
	/**
	 * 获取调查问卷头部信息
	 * @param answerID 调查问卷头部信息编号
	 * @return 调查问卷头部信息
	 */
	public HeaderRecordInfo getInfo(Long answerID);
	/**
	 * 获取调查问卷头部信息列表
	 * @return 调查问卷头部信息列表
	 */
	public List<HeaderRecordInfo> getList();
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
	public List<HeaderRecordInfo> findByPage(final int firstResult, final int maxResult);

	
}
