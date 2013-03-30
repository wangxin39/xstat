package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.VideoInfo;



public interface IVideoInfoDao {
	/**
	 * 保存问卷部分
	 * @param data 问卷部分
	 */
	public void save(VideoInfo data);
	/**
	 * 更新问卷部分
	 * @param data 问卷部分
	 */
	public void update(VideoInfo data);
	/**
	 * 删除问卷部分
	 * @param data 问卷部分
	 */
	public void delete(VideoInfo data);	
	/**
	 * 获取问卷部分
	 * @param qpID 问题类型编号
	 * @return 问卷部分
	 */
	public VideoInfo getVideoInfo(Long qpID);
	/**
	 * 获取问卷部分列表
	 * @return 问卷部分列表
	 */
	public List<VideoInfo> getVideoInfoList();
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
	public List<VideoInfo> findByPage(final int firstResult, final int maxResult);
	
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(Long clientID,Long informantID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<VideoInfo> findByPage(Long clientID,Long informantID, final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(Long clientID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<VideoInfo> findByPage(Long clientID, final int firstResult, final int maxResult);	
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
	public List<VideoInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
