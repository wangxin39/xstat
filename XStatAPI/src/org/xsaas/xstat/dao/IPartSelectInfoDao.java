package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.PartSelectInfo;


public interface IPartSelectInfoDao {
	/**
	 * 保存问卷部分选项
	 * @param data 问卷部分选项
	 */
	public void save(PartSelectInfo data);
	/**
	 * 更新问卷部分选项
	 * @param data 问卷部分选项
	 */
	public void update(PartSelectInfo data);
	/**
	 * 删除问卷部分选项
	 * @param data 问卷部分选项
	 */
	public void delete(PartSelectInfo data);	
	/**
	 * 获取问卷部分选项
	 * @param partQuestionSelectID 试题部分选项编号
	 * @return 问卷部分选项
	 */
	public PartSelectInfo getPartSelectInfo(Long partQuestionSelectID);
	/**
	 * 获取问卷部分选项列表
	 * @return 问卷部分选项列表
	 */
	public List<PartSelectInfo> getPartSelectInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(long questionID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<PartSelectInfo> findByPage(long questionID,final int firstResult, final int maxResult);

	/**
	 * 获取指定问题的选项
	 * @param inquestionID
	 * @param partQuestionID
	 * @param questionID
	 * @return List<PartSelectInfo> 选项列表
	 */
	public List<PartSelectInfo> findByQuestion(Long inquisitionID,Long partQuestionID);

	/**
	 * 获取指定问题的选项
	 * @param inquestionID
	 * @param partQuestionID
	 * @param questionID
	 * @return List<PartSelectInfo> 选项列表
	 */
	public List<PartSelectInfo> findByQuestion(Long partQuestionID);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getPartSelectInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<PartSelectInfo> findPartSelectInfoByPage(final int firstResult, final int maxResult);
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
	public List<PartSelectInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
