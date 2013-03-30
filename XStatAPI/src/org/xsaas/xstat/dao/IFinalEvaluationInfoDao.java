package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.FinalEvaluationInfo;


public interface IFinalEvaluationInfoDao {

	/**
	 * 保存问卷自动评分
	 * @param data 问卷自动评分
	 */
	public void save(FinalEvaluationInfo data);
	/**
	 * 更新问卷自动评分
	 * @param data 问卷自动评分
	 */
	public void update(FinalEvaluationInfo data);
	/**
	 * 删除问卷自动评分
	 * @param data 问卷自动评分
	 */
	public void delete(FinalEvaluationInfo data);	
	/**
	 * 获取问卷自动评分
	 * @param gradeID 试题资源类型编号
	 * @return 问卷自动评分
	 */
	public FinalEvaluationInfo getFinalEvaluationInfo(Long gradeID);
	/**
	 * 获取问卷自动评分列表
	 * @return 问卷自动评分列表
	 */
	public List<FinalEvaluationInfo> getFinalEvaluationInfoList();
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
	public List<FinalEvaluationInfo> findByPage(final int firstResult, final int maxResult);

}
