package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.QuestionInfo;


public interface IQuestionInfoService {

	/**
	 * 保存问卷问题信息
	 * @param data 问卷问题信息
	 */
	public void save(QuestionInfo data);
	/**
	 * 删除问卷问题信息
	 * @param data 问卷问题信息
	 */
	public void delete(QuestionInfo data);
	/***
	 * 更新问卷问题信息
	 * @param data 问卷问题信息
	 */
	public void update(QuestionInfo data);
	/**
	 * 获取问卷问题信息
	 * @param questionID 问卷问题编号
	 * @return 问卷问题信息
	 */
	public QuestionInfo getQuestionInfo(long questionID);
	/**
	 * 获取问卷问题信息列表
	 * @return 问卷问题信息
	 */
	public List<QuestionInfo> getQuestionInfoList();
	
	public int getQuestionInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<QuestionInfo> findByPage(final int firstResult, final int maxResult);
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
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(int questionType,String keyword);	
	public List<QuestionInfo> findByPage(final int questionType,final String keyword,final int firstResult,final int maxResult);
	
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
	
}
