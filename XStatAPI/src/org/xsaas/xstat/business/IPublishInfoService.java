package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.PublishInfo;


public interface IPublishInfoService {

	/**
	 * 保存调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void savePublishInfo(PublishInfo data);
	/**
	 * 更新调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void updatePublishInfo(PublishInfo data);
	/**
	 * 删除调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void deletePublishInfo(PublishInfo data);	
	/**
	 * 获取调查问卷信息
	 * @param partID 试题部分编号
	 * @return 调查问卷信息
	 */
	public PublishInfo getPublishInfo(Long partID);
	/**
	 * 获取调查问卷信息列表
	 * @return 调查问卷信息列表
	 */
	public List<PublishInfo> getPublishInfoList();
	/**
	 * 通过指定的起始数和结束数得到一个集合
	 * @param firstResult 
	 * @param maxResult 
	 * @return 调查问卷信息
	 */
	public List<PublishInfo> findByPagePublishInfo(final int firstResult,final int maxResult);
	/**
	 * 通过指定的起始数获取总集合
	 * @return 总数
	 */
	public int getTotalPublishInfo();
	
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
