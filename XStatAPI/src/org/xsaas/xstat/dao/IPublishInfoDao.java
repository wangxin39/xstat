package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.PublishInfo;



public interface IPublishInfoDao {
	/**
	 * 保存问卷部分
	 * @param data 问卷部分
	 */
	public void save(PublishInfo data);
	/**
	 * 更新问卷部分
	 * @param data 问卷部分
	 */
	public void update(PublishInfo data);
	/**
	 * 删除问卷部分
	 * @param data 问卷部分
	 */
	public void delete(PublishInfo data);	
	/**
	 * 获取问卷部分
	 * @param qpID 问题类型编号
	 * @return 问卷部分
	 */
	public PublishInfo getPublishInfo(Long qpID);
	/**
	 * 获取问卷部分列表
	 * @return 问卷部分列表
	 */
	public List<PublishInfo> getPublishInfoList();
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
	public List<PublishInfo> findByPage(final int firstResult, final int maxResult);

	public int getTotal(int type);
	public int getTotal(int type,Long smgkID);
	public List<PublishInfo> findByPage(final int type,final int firstResult, final int maxResult);
	public List<PublishInfo> findByPage(final int type,final Long smgkID,final int firstResult, final int maxResult);
	
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
	public List<PublishInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
