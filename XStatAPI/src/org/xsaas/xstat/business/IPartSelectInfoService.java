package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.PartSelectInfo;


public interface IPartSelectInfoService {
	/**
	 * 保存问题选项信息
	 * @param data 问题选项信息
	 */
	public void savePartSelectInfo(PartSelectInfo data);
	/**
	 * 更新问题选项信息
	 * @param data 问题选项信息
	 */
	public void updatePartSelectInfo(PartSelectInfo data);
	/**
	 * 删除问题选项信息
	 * @param data 问题选项信息
	 */
	public void deletePartSelectInfo(PartSelectInfo data);	
	/**
	 * 获取问题选项信息
	 * @param partQuestionSelectID 问题部分选项编号
	 * @return 问题选项信息
	 */
	public PartSelectInfo getPartSelectInfo(Long partQuestionSelectID);
	/**
	 * 获取问题选项信息列表
	 * @return 问题选项信息列表
	 */
	public List<PartSelectInfo> getPartSelectInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getPartSelectInfoTotal(long inquisitionID);
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
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<PartSelectInfo> findPartSelectInfoByPage(long inquisitionID,final int firstResult, final int maxResult);
	/**
	 * 获取指定问题的选项
	 * @param inquestionID
	 * @param partQuestionID
	 * @return List<PartSelectInfo> 选项列表
	 */
	public List<PartSelectInfo> findByQuestion(Long inquisitionID,Long partQuestionID);
	/**
	 * 获取指定问题的选项
	 * @param inquestionID
	 * @param partQuestionID
	 * @return List<PartSelectInfo> 选项列表
	 */
	public List<PartSelectInfo> findByQuestion(Long partQuestionID);
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
