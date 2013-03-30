package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.VideoInfo;


public interface IVideoInfoService {

	/**
	 * 保存调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void saveVideoInfo(VideoInfo data);
	/**
	 * 更新调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void updateVideoInfo(VideoInfo data);
	/**
	 * 删除调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void deleteVideoInfo(VideoInfo data);	
	/**
	 * 获取调查问卷信息
	 * @param partID 试题部分编号
	 * @return 调查问卷信息
	 */
	public VideoInfo getVideoInfo(Long partID);
	/**
	 * 获取调查问卷信息列表
	 * @return 调查问卷信息列表
	 */
	public List<VideoInfo> getVideoInfoList();
	/**
	 * 通过指定的起始数和结束数得到一个集合
	 * @param firstResult 
	 * @param maxResult 
	 * @return 调查问卷信息
	 */
	public List<VideoInfo> findVideoInfoByPage(final int firstResult,final int maxResult);
	/**
	 * 通过指定的起始数获取总集合
	 * @return 总数
	 */
	public int getVideoInfoTotal();
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
