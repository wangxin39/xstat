package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.PartQuestionInfo;



public interface IPartQuestionInfoDao {
	/**
	 * 保存问卷部分
	 * @param data 问卷部分
	 */
	public void save(PartQuestionInfo data);
	/**
	 * 更新问卷部分
	 * @param data 问卷部分
	 */
	public void update(PartQuestionInfo data);
	/**
	 * 删除问卷部分
	 * @param data 问卷部分
	 */
	public void delete(PartQuestionInfo data);	
	/**
	 * 获取问卷部分
	 * @param partQuestionID 问题类型编号
	 * @return 问卷部分
	 */
	public PartQuestionInfo getPartQuestionInfo(Long inquisitionID);
	/**
	 * 获取问卷部分列表
	 * @return 问卷部分列表
	 */
	public List<PartQuestionInfo> getPartQuestionInfoList();
	public List<PartQuestionInfo> getPartQuestionInfoList(Long partID,Long questionID, Long inquisitionID);
	public List<PartQuestionInfo> getPartQuestionInfoList(Long inquisitionID,Long partID);
	public List<PartQuestionInfo> getList(Long partID);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(Long partID, Long questionID,Long inquisitionID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<PartQuestionInfo> findByPage(final Long questionID,final Long inquisitionID,final Long partID,final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getPartQuestionInfoTotal(Long partID,Long inquisitionID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<PartQuestionInfo> findPartQuestionInfoByPage(final Long inquisitionID,final Long partID,final int firstResult, final int maxResult);
	
	public int getQuestionTotal(Long inquisitionID);
	public List<PartQuestionInfo> getFatherPqInfo(Long fatherPqID);
	
	public int getPartQuestionTotal(Long partID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<PartQuestionInfo> findPartQuestionInfoByPage(final Long partID,final int firstResult, final int maxResult);
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
	public List<PartQuestionInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	/**
	 * 获取总记录数
	 * @return 总记录数
	 */	
	public int getTotal();
	/**
	 * 获取分页数据
	 * @param firstResult
	 * @param maxResult
	 * @return 分页数据
	 */
	public List<PartQuestionInfo> findByPage(final int firstResult, final int maxResult);
	/**
	 * 获取当前问题最新显示编号
	 * @param inquisitionID
	 * @return 最新显示编号
	 */
	public int getLastShowNum(Long inquisitionID);
	/**
	 * 查找所有上级部分问题的部分问题列表
	 * @param partQuestionID
	 * @return 部分问题列表
	 */
	public List<PartQuestionInfo> findByFather(Long partQuestionID);
}
