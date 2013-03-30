package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.FinalEvaluationInfo;


public interface IFinalEvaluationInfoService {
	/**
	 * 保存问卷自动评分信息
	 * @param data 问卷自动评分信息
	 */
	public void saveFinalEvaluationInfo(FinalEvaluationInfo data);
	/**
	 * 更新问卷自动评分信息
	 * @param data 问卷自动评分信息
	 */
	public void updateFinalEvaluationInfo(FinalEvaluationInfo data);
	/**
	 * 删除问卷自动评分信息
	 * @param data 问卷自动评分信息
	 */
	public void deleteFinalEvaluationInfo(FinalEvaluationInfo data);	
	/**
	 * 获取问卷自动评分信息
	 * @param gradeID 评分编号
	 * @return 问卷自动评分信息
	 */
	public FinalEvaluationInfo getFinalEvaluationInfo(Long gradeID);
	/**
	 * 获取问卷自动评分信息列表
	 * @return 问卷自动评分信息列表
	 */
	public List<FinalEvaluationInfo> getFinalEvaluationInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getFinalEvaluationInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<FinalEvaluationInfo> findFinalEvaluationInfoByPage(final int firstResult, final int maxResult);

}
