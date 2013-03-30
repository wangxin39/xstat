package org.xsaas.xstat.business;

import java.util.List;

import org.xsaas.xstat.po.InquisitionMarkInfo;


public interface IInquisitionMarkInfoService {

	/**
	 * 保存调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void saveInquisitionMarkInfo(InquisitionMarkInfo data);
	/**
	 * 更新调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void updateInquisitionMarkInfo(InquisitionMarkInfo data);
	/**
	 * 删除调查问卷信息
	 * @param data 调查问卷信息
	 */
	public void deleteInquisitionMarkInfo(InquisitionMarkInfo data);	
	/**
	 * 获取调查问卷信息
	 * @param partID 试题部分编号
	 * @return 调查问卷信息
	 */
	public InquisitionMarkInfo getInquisitionMarkInfo(Long partID);
	/**
	 * 获取调查问卷信息列表
	 * @return 调查问卷信息列表
	 */
	public List<InquisitionMarkInfo> getInquisitionMarkInfoList();
	/**
	 * 通过指定的起始数和结束数得到一个集合
	 * @param firstResult 
	 * @param maxResult 
	 * @return 调查问卷信息
	 */
	public List<InquisitionMarkInfo> findByPageInquisitionMarkInfo(final int firstResult,final int maxResult);
	/**
	 * 通过指定的起始数获取总集合
	 * @return 总数
	 */
	public int getTotalInquisitionMarkInfo();
	/**
	 * 根据指定的期次、神秘客和调查对象获取问卷的统计值
	 * @param issueID 期次编号
	 * @param smgkID 神秘客编号
	 * @param informantID 调查对象编号
	 * @return 调查问卷分数信息
	 */
	public InquisitionMarkInfo findByISI(Long issueID, Long smgkID, Long informantID);	
	/**
	 * 根据当前计划，检查是否可以存储
	 * @param issueID 期次编号
	 * @param smgkID 神秘顾客
	 * @param informantID 调查对象
	 * @return true 可以保存，false 不允许保存
	 */
	public boolean isSave(Long issueID, Long smgkID,Long informantID);
	/**
	 * 根据调查对象获取相应统计数据
	 * @param informantID 调查对象编号
	 * @param projectID 项目编号
	 * @return 统计数据
	 */
	public List<InquisitionMarkInfo> findByInformant(Long informantID,Long projectID);
	/**
	 * 根据客户编号,项目，获取相应统计数据
	 * @param clientID 客户编号
	 * @param projectID 项目编号
	 * @return 统计数据
	 */
	public List<InquisitionMarkInfo> findByClient(Long clientID,Long projectID);	
	
	/**
	 * 获取所有统计年份
	 * @param clientID
	 * @param projectID
	 * @param informantID
	 * @return 年份列表
	 */
	public List<Integer> getCountYear(Long clientID,Long projectID, Long informantID);
	/**
	 * 获得当前所有统计月份
	 * @param clientID
	 * @param projectID
	 * @param informantID
	 * @return 月份列表
	 */
	public List<Integer> getCountQuarter(Long clientID,Long projectID, Long informantID);
	/**
	 * 获得所有统计日期
	 * @param clientID
	 * @param projectID
	 * @param informantID
	 * @param year
	 * @param month
	 * @return 日期列表
	 */
	public List<Integer> getCountWeek(Long clientID,Long projectID, Long informantID,Integer year,Integer month);	
	/**
	 * 获取所有统计年份
	 * @param clientID
	 * @param projectID
	 * @return 年份列表
	 */
	public List<Integer> getCountYear(Long clientID,Long projectID);
	/**
	 * 获得当前所有统计月份
	 * @param clientID
	 * @param projectID
	 * @return 月份列表
	 */
	public List<Integer> getCountQuarter(Long clientID,Long projectID);
	/**
	 * 获得所有统计日期
	 * @param clientID
	 * @param projectID
	 * @return 日期列表
	 */
	public List<Integer> getCountWeek(Long clientID,Long projectID,Integer year,Integer month);	
	
	/**
	 * 获取指定调查对象指定期次的权重设定值
	 * @param informantID 调查对象编号
	 * @param issueID 期次编号
	 * @return 权重设定总值
	 */
	public int getWeightedRound1Total(Long informantID,Long issueID);
	/**
	 * 获取指定调查对象指定期次的权重实际得分
	 * @param informantID 调查对象编号
	 * @param issueID 期次编号
	 * @return 权重得分总值
	 */
	public int getActualRound1Total(Long informantID,Long issueID);
	/**
	 * 获取指定调查对象指定期次的权重设定值
	 * @param informantID 调查对象编号
	 * @param issueID 期次编号
	 * @return 权重设定总值
	 */
	public int getWeightedRound2Total(Long informantID,Long issueID);
	/**
	 * 获取指定调查对象指定期次的权重实际得分
	 * @param informantID 调查对象编号
	 * @param issueID 期次编号
	 * @return 权重得分总值
	 */
	public int getActualRound2Total(Long informantID,Long issueID);
	/**
	 * 获取指定调查对象和期次一共有多少神秘客参与检测
	 * @param informantID 调查对象编号
	 * @param issueID 期次编号
	 * @return 神秘客总人数
	 */
	public int getSmgkTotal(Long informantID,Long issueID);
	/**
	 * 获取平均分统计
	 * @param informantID
	 * @param issueID
	 * @param year
	 * @param month
	 * @return 平均分总和
	 */
	public double getAverageTotal(Long informantID, Long issueID , Integer year, Integer month);
	/**
	 * 获取平均分统计
	 * @param informantID
	 * @param issueID
	 * @param year
	 * @return 平均分总和
	 */
	public double getAverageTotal(Long informantID, Long issueID , Integer year);	
	/**
	 * 获取平均分统计
	 * @param informantID
	 * @param issueID
	 * @return 平均分总和
	 */
	public double getAverageTotal(Long informantID, Long issueID);	
	/**
	 * 获取平均分统计
	 * @param issueID
	 * @param year
	 * @param month
	 * @return 平均分总和
	 */
	public double getAverageTotal(Long issueID , Integer year, Integer month);
	/**
	 * 获取平均分统计
	 * @param issueID
	 * @param year
	 * @return 平均分总和
	 */
	public double getAverageTotal(Long issueID , Integer year);	
	/**
	 * 获取平均分统计
	 * @param issueID
	 * @return 平均分总和
	 */	
	public double getAverageTotal(Long issueID);		
	/**
	 * 获取平均分统计
	 * @param year
	 * @param month
	 * @return 平均分总和
	 */
	public double getAverageTotal(Integer year, Integer month);
	/**
	 * 获取平均分统计
	 * @param year
	 * @return 平均分总和
	 */
	public double getAverageTotal(Integer year);	
	/**
	 * 获取平均分统计
	 * @param year
	 * @param month
	 * @param informantID
	 * @return 平均分总和
	 */
	public double getAverageTotal(Integer year, Integer month, Long informantID);
	/**
	 * 获取平均分统计
	 * @param year
	 * @param informantID
	 * @return 平均分总和
	 */
	public double getAverageTotal(Integer year, Long informantID);	

	/**
	 * 获取总神秘顾客人数
	 * @param issueID
	 * @param year
	 * @param month
	 * @return 神秘顾客人数
	 */
	public int getSmgkTotal(Long issueID, Integer year, Integer month);		
	/**
	 * 获取总神秘顾客人数
	 * @param issueID
	 * @param year
	 * @return 神秘顾客人数
	 */
	public int getSmgkTotal(Long issueID, Integer year);			
	/**
	 * 获取总神秘顾客人数
	 * @param informantID
	 * @param year
	 * @param month
	 * @return 神秘顾客人数
	 */
	public int getSmgkTotal(Integer year, Integer month,Long informantID);		
	/**
	 * 获取总神秘顾客人数
	 * @param year
	 * @param month
	 * @return 神秘顾客人数
	 */
	public int getSmgkTotal(Integer year,Integer month);	
	/**
	 * 获取指定期次的权重设定值
	 * @param issueID 期次编号
	 * @return 权重设定总值
	 */
	public int getWeightedRound1Total(Long issueID);
	/**
	 * 获取指定期次的权重实际得分
	 * @param issueID 期次编号
	 * @return 权重得分总值
	 */
	public int getActualRound1Total(Long issueID);
	/**
	 * 获取指定期次的权重设定值
	 * @param issueID 期次编号
	 * @return 权重设定总值
	 */
	public int getWeightedRound2Total(Long issueID);
	/**
	 * 获取指定期次的权重实际得分
	 * @param issueID 期次编号
	 * @return 权重得分总值
	 */
	public int getActualRound2Total(Long issueID);
	/**
	 * 获取指定期次一共有多少神秘客参与检测
	 * @param issueID 期次编号
	 * @return 神秘客总人数
	 */
	public int getSmgkTotal(Long issueID);		
	/**
	 * 获取指定年度最新期次编号
	 * @param informantID 调查对象
	 * @param year 年度
	 * @return 期次编号(issueID)
	 */
	public Long getLastIssue(Long informantID, Integer year);
	/**
	 * 获取指定年度最新期次编号
	 * @param year 年度
	 * @return 期次编号(issueID)
	 */
	public Long getLastIssue(Integer year);
	
	public double getAverage(Long issueID);
}
