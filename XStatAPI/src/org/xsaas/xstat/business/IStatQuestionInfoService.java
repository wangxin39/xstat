package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.StatQuestionInfo;


public interface IStatQuestionInfoService {

	/**
	 * 保存调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void saveStatQuestionInfo(StatQuestionInfo data);
	/**
	 * 更新调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void updateStatQuestionInfo(StatQuestionInfo data);
	/**
	 * 删除调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void deleteStatQuestionInfo(StatQuestionInfo data);	
	/**
	 * 获取调查问卷信息
	 * @param partID 试题部分编号
	 * @return 调查问卷信息
	 */
	public StatQuestionInfo getStatQuestionInfo(Long partID);
	/**
	 * 获取调查问卷信息列表
	 * @return 调查问卷信息列表
	 */
	public List<StatQuestionInfo> getStatQuestionInfoList();
	/**
	 * 通过指定的起始数和结束数得到一个集合
	 * @param firstResult 
	 * @param maxResult 
	 * @return 调查问卷信息
	 */
	public List<StatQuestionInfo> findByPageStatQuestionInfo(final int firstResult,final int maxResult);
	/**
	 * 通过指定的起始数获取总集合
	 * @return 总数
	 */
	public int getTotalStatQuestionInfo();
	/**
	 * 是否已可以存储
	 * @param planID
	 * @param partID
	 * @param partQuestionID
	 * @param partSelectID
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
