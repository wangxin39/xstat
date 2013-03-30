package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.IssueInfo;


public interface IIssueInfoService {
	/**
	 * 保存项目培训信息
	 * @param data 项目培训信息
	 */
	public void saveIssueInfo(IssueInfo data);
	/**
	 * 更新项目培训信息
	 * @param data 项目培训信息
	 */
	public void updateIssueInfo(IssueInfo data);
	/**
	 * 删除项目培训信息
	 * @param data 项目培训信息
	 */
	public void deleteIssueInfo(IssueInfo data);	
	/**
	 * 获取项目培训信息
	 * @param ptID 培训编号
	 * @return 项目培训信息
	 */
	public IssueInfo getIssueInfo(Long ptID);
	public IssueInfo getIssueInfoSmgk(long smgkID);
	/**
	 * 获取项目培训信息列表
	 * @return 项目培训信息列表
	 */
	public List<IssueInfo> getIssueInfoList();
	/**
	 * 获取项目培训信息列表
	 * @return 项目培训信息列表
	 */
	public List<IssueInfo> getIssueInfoList(Long inquisitionID);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getIssueInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<IssueInfo> findIssueInfoByPage(final int firstResult, final int maxResult);
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
	 * 获取项目培训信息列表
	 * @return 项目培训信息列表
	 */
	public List<IssueInfo> getList(Long inquisitionID,Long projectID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<IssueInfo> findByPage(Long clientID,Long issueID,final int firstResult, final int maxResult);

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
