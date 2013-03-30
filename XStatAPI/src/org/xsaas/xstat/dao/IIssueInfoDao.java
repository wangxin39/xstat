package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.IssueInfo;


public interface IIssueInfoDao {
	/**
	 * 保存项目培训信息
	 * @param data 项目培训信息
	 */
	public void save(IssueInfo data);
	/**
	 * 删除项目培训信息
	 * @param data 项目培训信息
	 */
	public void delete(IssueInfo data);
	/**
	 * 修改项目培训信息
	 * @param data 项目培训信息
	 */
	public void update(IssueInfo data);
	/**
	 * 获取项目培训信息
	 * @param ptID 项目培训项目培训编号
	 * @return 项目培训信息
	 */
	public IssueInfo getIssueInfo(Long ptID);
	/**
	 * 获取项目培训信息
	 * @param ptID 项目培训项目培训编号
	 * @return 项目培训信息
	 */
	public IssueInfo getIssueInfoSmgk(long smgkID);
	/**
	 * 获取项目培训信息列表
	 * @return List<IssueInfo>项目培训信息
	 */
	public List<IssueInfo> getIssueInfoList();
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
	public List<IssueInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(long smgkID,int status);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<IssueInfo> findByPage(long smgkID,int status,final int firstResult, final int maxResult);
	/**
	 * 判断是否已存在
	 * @param issue
	 * @return true 已存在， false 不存在
	 */
	public boolean isRegister(String issue);
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
	public List<IssueInfo> findByPage(Long clientID,final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getIssueInfoTotal(Long clientID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<IssueInfo> findIssueInfoByPage(Long clientID,final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(Long clientID,Long issueID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<IssueInfo> findByPage(Long clientID,Long issueID,final int firstResult, final int maxResult);
	/**
	 * 获取项目培训信息列表
	 * @return 项目培训信息列表
	 */
	public List<IssueInfo> getList(Long inquisitionID);
	/**
	 * 获取项目培训信息列表
	 * @return 项目培训信息列表
	 */
	public List<IssueInfo> getList(Long projectID,Long inquisitionID);
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
	public List<IssueInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getIssueInfoTotal(Long clientID,Long issueID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<IssueInfo> findIssueInfoByPage(Long clientID,Long issueID,final int firstResult, final int maxResult);
	/**
	 * 获取所有有效期次，用于后台统计
	 * @return 有效期次
	 */
	public List<IssueInfo> findIssueInfoListByReportStatus();
	/**
	 * 根据当前期次，获取上一期次编号
	 * @param clientID 客户编号
	 * @param projectID 项目编号
	 * @param issue 当前期次
	 * @return 上期信息
	 */
	public IssueInfo getLastIssueID(Long clientID,Long projectID,String issue);
}
