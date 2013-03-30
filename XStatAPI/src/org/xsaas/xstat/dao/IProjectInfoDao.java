package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.ProjectInfo;


public interface IProjectInfoDao {
	/**
	 * 保存顾客检测信息
	 * @param data 顾客检测信息
	 */
	public void saveProjectInfo(ProjectInfo data);
	/**
	 * 更新顾客检测信息
	 * @param data 顾客检测信息
	 */
	public void updateProjectInfo(ProjectInfo data);
	/**
	 * 删除顾客检测信息
	 * @param data 顾客检测信息
	 */
	public void deleteProjectInfo(ProjectInfo data);	
	/**
	 * 获取顾客检测信息
	 * @param projectID 问卷编号
	 * @return 顾客检测信息
	 */
	public ProjectInfo getProjectInfo(Long projectID);
	public ProjectInfo getProjectInfoClient(long clientID);
	/**
	 * 获取顾客检测信息列表
	 * @return 顾客检测信息列表
	 */
	public List<ProjectInfo> getProjectInfoList();
	/**
	 * 获取顾客检测信息列表
	 * @return 顾客检测信息列表
	 */
	public List<ProjectInfo> getProjectInfoList(Long clientID);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getProjectInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ProjectInfo> findProjectInfoByPage(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getProjectInfoTotal(long clientID,int status);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<ProjectInfo> findProjectInfoByPage(long clientID,int status,final int firstResult, final int maxResult);
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
	public List<ProjectInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
