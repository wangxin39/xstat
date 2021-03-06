package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.InquisitionInfo;


public interface IInquisitionInfoService {
	/**
	 * 保存调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void saveInquisitionInfo(InquisitionInfo data);
	/**
	 * 更新调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void updateInquisitionInfo(InquisitionInfo data);
	/**
	 * 删除调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void deleteInquisitionInfo(InquisitionInfo data);	
	/**
	 * 获取调查问卷信息
	 * @param inquisitionID 调查问卷编号
	 * @return 调查问卷信息
	 */
	public InquisitionInfo getInquisitionInfo(Long inquisitionID);
	/**
	 * 获取调查问卷信息列表
	 * @return 调查问卷信息列表
	 */
	public List<InquisitionInfo> getInquisitionInfoList();
	/**
	 * 获取调查问卷信息列表
	 * @return 调查问卷信息列表
	 */
	public List<InquisitionInfo> getInquisitionInfoList(Long clientID);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getInquisitionInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<InquisitionInfo> findInquisitionInfoByPage(final int firstResult, final int maxResult);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(int status);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<InquisitionInfo> findByPage(final int status,final int firstResult, final int maxResult);

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
	public List<InquisitionInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
