package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.InformantInfo;


public interface IInformantInfoService {
	/**
	 * 保存被检测对象信息
	 * @param data 被检测对象信息
	 */
	public void saveInformantInfo(InformantInfo data);
	/**
	 * 更新被检测对象信息
	 * @param data 被检测对象信息
	 */
	public void updateInformantInfo(InformantInfo data);
	/**
	 * 删除被检测对象信息
	 * @param data 被检测对象信息
	 */
	public void deleteInformantInfo(InformantInfo data);	
	/**
	 * 获取被检测对象信息
	 * @param informantID 检测对象编号
	 * @return 被检测对象信息
	 */
	public InformantInfo getInformantInfo(Long informantID);
	/**
	 * 获取被检测对象信息列表
	 * @return 被检测对象信息列表
	 */
	public List<InformantInfo> getInformantInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getInformantInfoTotal();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getInformantInfoTotal(long clientID);
	public int getInformantInfoTotal(long informantID,long clientID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<InformantInfo> findInformantInfoByPage(final long clientID,final int firstResult, final int maxResult);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<InformantInfo> findInformantInfoByPage(final int firstResult, final int maxResult);
	public List<InformantInfo> getInformantInfoList(Long clientID);
	

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
	public List<InformantInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
