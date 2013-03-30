package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.PartInfo;


public interface IPartInfoService {

	/**
	 * 保存调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void savePartInfo(PartInfo data);
	/**
	 * 更新调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void updatePartInfo(PartInfo data);
	/**
	 * 删除调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void deletePartInfo(PartInfo data);	
	/**
	 * 获取调查问卷信息
	 * @param partID 试题部分编号
	 * @return 调查问卷信息
	 */
	public PartInfo getPartInfo(Long partID);
	
	public List<PartInfo> getPartInfoList(Long inquisitionID);
	/**
	 * 获取调查问卷信息列表
	 * @return 调查问卷信息列表
	 */
	public List<PartInfo> getPartInfoList();
	/**
	 * 通过指定的起始数和结束数得到一个集合
	 * @param firstResult 
	 * @param maxResult 
	 * @return 调查问卷信息
	 */
	public List<PartInfo> findByPagePartInfo(long inquisitionID,final int firstResult,final int maxResult);
	/**
	 * 通过指定的起始数获取总集合
	 * @return 总数
	 */
	public int getTotalPartInfo(long inquisitionID);
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
	public List<PartInfo> findByPage(final int firstResult, final int maxResult);	

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
	public List<PartInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
