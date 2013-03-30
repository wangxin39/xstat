package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.HeaderRecordInfo;


public interface IHeaderRecordInfoService {
	/**
	 * 保存调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void saveHeaderRecordInfo(HeaderRecordInfo data);
	/**
	 * 更新调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void updateHeaderRecordInfo(HeaderRecordInfo data);
	/**
	 * 删除调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void deleteHeaderRecordInfo(HeaderRecordInfo data);	
	/**
	 * 获取调查问卷头部信息
	 * @param answerID 问卷头部编号
	 * @return 调查问卷头部信息
	 */
	public HeaderRecordInfo getHeaderRecordInfo(Long answerID);
	/**
	 * 获取调查问卷头部信息列表
	 * @return 调查问卷头部信息列表
	 */
	public List<HeaderRecordInfo> getHeaderRecordInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getHeaderRecordInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<HeaderRecordInfo> findHeaderRecordInfoByPage(final int firstResult, final int maxResult);

}
