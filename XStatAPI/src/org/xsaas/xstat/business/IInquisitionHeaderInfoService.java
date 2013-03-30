package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.InquisitionHeaderInfo;


public interface IInquisitionHeaderInfoService {
	/**
	 * 保存调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void saveInquisitionHeaderInfo(InquisitionHeaderInfo data);
	/**
	 * 更新调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void updateInquisitionHeaderInfo(InquisitionHeaderInfo data);
	/**
	 * 删除调查问卷头部信息
	 * @param data 调查问卷头部信息
	 */
	public void deleteInquisitionHeaderInfo(InquisitionHeaderInfo data);	
	
	/**
	 * 获取调查问卷头部信息
	 * @param ihID 问卷头部编号
	 * @return 调查问卷头部信息
	 */
	public InquisitionHeaderInfo getInquisitionHeaderInfo(Long ihID);
	/**
	 * 获取调查问卷头部信息列表
	 * @return 调查问卷头部信息列表
	 */
	public List<InquisitionHeaderInfo> getInquisitionHeaderInfoList();
	public List<InquisitionHeaderInfo> getInquisitionHeaderInfoList(Long inquisitionID);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getInquisitionHeaderInfoTotal();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getInquisitionHeaderInfoTotal(long inquisitionID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<InquisitionHeaderInfo> findInquisitionHeaderInfoByPage(long inquisitionID,final int firstResult, final int maxResult);	
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<InquisitionHeaderInfo> findInquisitionHeaderInfoByPage(final int firstResult, final int maxResult);

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
	public List<InquisitionHeaderInfo> findPageByDelStatus(final int firstResult, final int maxResult);
	/**
	 * 获取新显示顺序
	 * @param inquisitionID
	 * @return 显示顺序
	 */
	public int getNewShowOrder(Long inquisitionID);
}
