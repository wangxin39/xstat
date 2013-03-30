package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.StatQuestionInfo;



public interface IStatQuestionInfoDao {
	/**
	 * 保存问卷部分
	 * @param data 问卷部分
	 */
	public void save(StatQuestionInfo data);
	/**
	 * 更新问卷部分
	 * @param data 问卷部分
	 */
	public void update(StatQuestionInfo data);
	/**
	 * 删除问卷部分
	 * @param data 问卷部分
	 */
	public void delete(StatQuestionInfo data);	
	/**
	 * 获取问卷部分
	 * @param qpID 问题类型编号
	 * @return 问卷部分
	 */
	public StatQuestionInfo getStatQuestionInfo(Long qpID);
	/**
	 * 获取问卷部分列表
	 * @return 问卷部分列表
	 */
	public List<StatQuestionInfo> getStatQuestionInfoList();
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
	public List<StatQuestionInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * 是否已可以存储
	 * @param planID
	 * @param partID
	 * @param partQuestionID
	 * @param selectID
	 * @return boolean true 不存在，false 已存在
	 */
	public boolean isSave(Long planID,Long partID,Long partQuestionID,Long partSelectID);
	/**
	 * 获取部分统计得分
	 * @param planID
	 * @param partID
	 * @return 部分统计得分
	 */
	public int getCountMarks(Long planID,Long partID);
	/**
	 * 获取计划统计得分
	 * @param planID
	 * @return 统计得分
	 */
	public int getCountMarks(Long planID);
	/**
	 * 获取统计问题信息，根据指定的期次和计划以及部分编号
	 * @param issueID
	 * @param planID
	 * @param partID
	 * @return 统计问题编号
	 */
	public StatQuestionInfo findByPlan(Long issueID,Long planID,Long partID);
	/**
	 * 获取指定期次和部分问卷及轮次下的问题得分数据
	 * @param issueID 期次编号
	 * @param partID 部分编号
	 * @param partQuestionID 部分问题编号
	 * @param round 轮次
	 * @return 统计问题信息
	 */
	public StatQuestionInfo findByIssue(Long issueID,Long partID,Long partQuestionID,Integer round);
	/**
	 * 获取部分权重
	 * @param planID
	 * @param partID
	 * @return 部分权重
	 */
	public int getCountWeights(Long planID,Long partID);
	/**
	 * 获取计划部分权重
	 * @param planID
	 * @return 部分权重
	 */
	public int getCountWeights(Long planID);	
}
