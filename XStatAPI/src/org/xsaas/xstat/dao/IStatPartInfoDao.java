package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.StatPartInfo;



public interface IStatPartInfoDao {
	/**
	 * 保存问卷部分
	 * @param data 问卷部分
	 */
	public void save(StatPartInfo data);
	/**
	 * 更新问卷部分
	 * @param data 问卷部分
	 */
	public void update(StatPartInfo data);
	/**
	 * 删除问卷部分
	 * @param data 问卷部分
	 */
	public void delete(StatPartInfo data);	
	/**
	 * 获取问卷部分
	 * @param qpID 问题类型编号
	 * @return 问卷部分
	 */
	public StatPartInfo getStatPartInfo(Long qpID);
	/**
	 * 获取问卷部分列表
	 * @return 问卷部分列表
	 */
	public List<StatPartInfo> getStatPartInfoList();
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
	public List<StatPartInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * 检查是否已存保
	 * @param planID
	 * @param partID
	 * @return true 没有保存，false 已保存
	 */
	public boolean isSave(Long planID,Long partID);
	/**
	 * 根据计划，获取该计划部分数量
	 * @param planID 计划
	 * @return 部分数
	 */
	public int getPartTotal(Long planID);
	/**
	 * 获取问卷权重总数
	 * @param planID
	 * @return 权重总数
	 */
	public int getWeightedTotal(Long planID);
	/**
	 * 获取问卷实际得分
	 * @param planID
	 * @return 实际得分
	 */
	public int getActualTotal(Long planID);
	/**
	 * 根据计划获取所有该计划统计数据
	 * @param planID 计划
	 * @return 部分统计数据
	 */
	public List<StatPartInfo> findByPlan(Long planID);
	/**
	 * 获取指定调查对象指定期次和部分的权重设定值
	 * @param informantID 调查对象编号
	 * @param issueID 期次编号
	 * @param partID 部分编号
	 * @return 权重设定总值
	 */
	public int getWeightedTotal(Long informantID,Long issueID, Long partID);
	/**
	 * 获取指定调查对象指定期次和部分的权重实际得分
	 * @param informantID 调查对象编号
	 * @param issueID 期次编号
	 * @param partID 部分编号
	 * @return 权重得分总值
	 */
	public int getActualTotal(Long informantID,Long issueID, Long partID);
	/**
	 * 获取指定调查对象和期次一共有多少神秘客参与检测
	 * @param informantID 调查对象编号
	 * @param issueID 期次编号
	 * @return 神秘客总人数
	 */
	public int getSmgkTotal(Long informantID,Long issueID);
	/**
	 * 获取指定期次和部分的权重设定值
	 * @param issueID 期次编号
	 * @param partID 部分编号
	 * @return 权重设定总值
	 */
	public int getWeightedTotal(Long issueID, Long partID);
	/**
	 * 获取指定期次和部分的权重实际得分
	 * @param issueID 期次编号
	 * @param partID 部分编号
	 * @return 权重得分总值
	 */
	public int getActualTotal(Long issueID, Long partID);
	/**
	 * 获取指定期次一共有多少神秘客参与检测
	 * @param issueID 期次编号
	 * @return 神秘客总人数
	 */
	public int getSmgkTotal(Long issueID);	
	/**
	 * 通过期次和部分编号获取指定轮次该部分成绩
	 * @param issueID 期次编号
	 * @param partID 部分编号
	 * @param round 轮次
	 * @return 成绩
	 */
	public StatPartInfo findByIssue(Long issueID, Long partID , Integer round);
	/**
	 * 获取指定年度实际得分
	 * @param year 年度
	 * @param clientID 客户编号
	 * @param projectID 项目编号
	 * @return 实际总得分
	 */
	public int findActualByYear(Integer year,Long clientID,Long projectID);
	/**
	 * 获取指定年度设定分
	 * @param year 年度
	 * @param clientID 客户编号
	 * @param projectID 项目编号
	 * @return 设定总分
	 */
	public int findWeightedByYear(Integer year,Long clientID,Long projectID);	
	/**
	 * 获取指定年度实际得分
	 * @param year 年度
	 * @param clientID 客户编号
	 * @param projectID 项目编号
	 * @return 实际总得分
	 */
	public int findActualByYear(Integer year,Long clientID,Long projectID,Long informantID);
	/**
	 * 获取指定年度设定分
	 * @param year 年度
	 * @param clientID 客户编号
	 * @param projectID 项目编号
	 * @return 设定总分
	 */
	public int findWeightedByYear(Integer year,Long clientID,Long projectID,Long informantID);	
	/**
	 * 通过期次和部分编号获取指定轮次该部分成绩
	 * @param issueID 期次编号
	 * @param informantID 调查对象编号
	 * @param partID 部分编号
	 * @param round 轮次
	 * @return 成绩
	 */
	public StatPartInfo findByIssue(Long issueID,Long informantID, Long partID , Integer round);		
}
