package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.QuestionInfo;


public interface IQuestionInfoDao {
	/**
	 * 保存问卷信息
	 * @param data 问卷信息
	 */
	public void save(QuestionInfo data);
	/**
	 * 删除问卷信息
	 * @param data 问卷信息
	 */
	public void delete(QuestionInfo data);
	/**
	 * 修改问卷信息
	 * @param data 问卷信息
	 */
	public void update(QuestionInfo data);
	/**
	 * 获取指定问卷信息
	 * @param questionID 问卷问题编号
	 * @return 问卷信息
	 */
	public QuestionInfo getQuestionInfo(Long questionID);
	/**
	 * 获取问题信息列表

	 * @return List<QuestionInfo>问卷信息
	 */
	public List<QuestionInfo> getQuestionInfoList();
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
	public List<QuestionInfo> findByPage(final int questionType,final String keyword,final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(int questionType,String keyword);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<QuestionInfo> findByPage(final String keyword,final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(String keyword);

	/**
	 * 获取指定问题类型的问题列表
	 * @param questionType
	 * @param firstResult
	 * @param maxResult
	 * @return List<QuestionInfo>
	 */
	public List<QuestionInfo> findByPage(final int questionType, final int firstResult,final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(int questionType);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<QuestionInfo> findByPage(final int firstResult, final int maxResult);
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
	public List<QuestionInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
