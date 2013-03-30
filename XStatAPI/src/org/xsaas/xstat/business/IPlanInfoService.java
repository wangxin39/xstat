package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.PlanInfo;


public interface IPlanInfoService {
	/**
	 * 保存神秘顾客测试信息
	 * @param data 神秘顾客测试信息
	 */
	public void savePlanInfo(PlanInfo data);
	/**
	 * 更新神秘顾客测试信息
	 * @param data 神秘顾客测试信息
	 */
	public void updatePlanInfo(PlanInfo data);
	/**
	 * 删除神秘顾客测试信息
	 * @param data 神秘顾客测试信息
	 */
	public void deletePlanInfo(PlanInfo data);	
	/**
	 * 获取神秘顾客测试信息
	 * @param planID 神秘顾客测试信息编号
	 * @return 神秘顾客测试信息
	 */
	public PlanInfo getPlanInfo(Long planID);
	/**
	 * 获取神秘顾客测试信息列表
	 * @return 神秘顾客测试信息列表
	 */
	public List<PlanInfo> getPlanInfoList();
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getPlanInfoTotal();
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<PlanInfo> findPlanInfoByPage(final int firstResult, final int maxResult);

	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getTotal(long smgkID, int type);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<PlanInfo> findByPage(long smgkID, int type,final int firstResult, final int maxResult);	
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getClientTotal(long clientID, int type);
	/**
	 * 信息总数
	 * @return 数量
	 */
	public int getPlanTotal(long clientID,long smgkID,long inquisitionID);
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<PlanInfo> findByClientPage(long clientID, int type,final int firstResult, final int maxResult);	
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	public List<PlanInfo> findPlanByPage(long clientID,long smgkID,long inquisitionID,final int firstResult, final int maxResult);	
	public List<PlanInfo> findBySmgk(Long smgkID);
	public List<PlanInfo> findByAccount(Long accountID);
	public List<PlanInfo> findByClient(Long clientID);	
	public List<PlanInfo> findBySmgk(Long smgkID,int inquisitionType);
	
	public List<PlanInfo> findByIssue(Long issueID);
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
	public List<PlanInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
